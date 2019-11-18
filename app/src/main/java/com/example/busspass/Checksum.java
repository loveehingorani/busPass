package com.example.busspass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.paytm.pgsdk.PaytmOrder;

import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class Checksum extends AppCompatActivity implements PaytmPaymentTransactionCallback {
    String customerId="", orderId="", merchantId = "BUXzaY54718402638352";
    int transactionAmount=-1;
    TextView paymentStatusDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checksum);
        paymentStatusDisplay =(TextView)findViewById(R.id.PaymentStatusDisplay);
        paymentStatusDisplay.setText("Payment Status: Pending");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Intent intent = getIntent();
        try {
            orderId = intent.getExtras().getString("Order Id", "ERROR");
            customerId = intent.getExtras().getString("Customer Id", "ERROR");
            transactionAmount = intent.getExtras().getInt("Transaction Amount",-1);
            if(orderId.equals("ERROR")||customerId.equals("ERROR")||(transactionAmount==-1))
            {
                throw new Exception("Error while fetching extras from intent");
            }
        }
        catch(Exception e){
            /*Abhay: Code should not reach here. It reaches if there is a problem with intent passing.
             * Ideally, code shouldn't compile, but I'm throwing an exception anyway just to double check.
             * Cheers mates.
             */
            paymentStatusDisplay.setText("Internal flaw in app detected. Please report to IMAD group 2 ASAP. Try to specify the steps after which this message was displayed so we can fix it faster");
        }
        sendUserDetailTOServerdd dl = new sendUserDetailTOServerdd();
        dl.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    public class sendUserDetailTOServerdd extends AsyncTask<ArrayList<String>, Void, String> {
        private ProgressDialog dialog = new ProgressDialog(Checksum.this);
        //private String orderId , mid, custid, amt;
        String url ="https://hellome9414.000webhostapp.com/Paytm/generateChecksum.php";
        String verifyurl = "https://pguat.paytm.com/paytmchecksum/paytmCallback.jsp";
        String CHECKSUMHASH ="";
        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Please wait");
            this.dialog.show();
        }
        protected String doInBackground(ArrayList<String>... alldata) {
            JSONParser jsonParser = new JSONParser(Checksum.this);
            String param=
                    "MID="+merchantId+
                            "&ORDER_ID=" + orderId+
                            "&CUST_ID="+customerId+
                            "&CHANNEL_ID=WAP"+
                            "&TXN_AMOUNT="+transactionAmount+
                            "&WEBSITE=WEBSTAGING"+
                            "&CALLBACK_URL="+ verifyurl+"&INDUSTRY_TYPE_ID=Retail";
            JSONObject jsonObject = jsonParser.makeHttpRequest(url,"POST",param);
            Log.e("CheckSum result >>",jsonObject.toString());
            if(jsonObject != null){
                Log.e("CheckSum result >>",jsonObject.toString());
                try {
                    CHECKSUMHASH=jsonObject.has("CHECKSUMHASH")?jsonObject.getString("CHECKSUMHASH"):"";
                    Log.e("CheckSum result >>",CHECKSUMHASH);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return CHECKSUMHASH;
        }
        @Override
        protected void onPostExecute(String result) {
            Log.e(" setup acc ","  signup result  " + result);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            PaytmPGService Service = PaytmPGService.getStagingService();
            // when app is ready to publish use production service
            // PaytmPGService  Service = PaytmPGService.getProductionService();
            // now call paytm service here
            //below parameter map is required to construct PaytmOrder object, Merchant should replace below map values with his own values
            HashMap<String, String> paramMap = new HashMap<String, String>();
            //these are mandatory parameters
            paramMap.put("MID", merchantId); //MID provided by paytm
            paramMap.put("ORDER_ID", orderId);
            paramMap.put("CUST_ID", customerId);
            paramMap.put("CHANNEL_ID", "WAP");
            paramMap.put("TXN_AMOUNT", transactionAmount+"");
            paramMap.put("WEBSITE", "WEBSTAGING");
            paramMap.put("CALLBACK_URL" ,verifyurl);
            paramMap.put("CHECKSUMHASH" ,CHECKSUMHASH);
            paramMap.put("INDUSTRY_TYPE_ID", "Retail");
            PaytmOrder Order = new PaytmOrder(paramMap);
            Log.e("checksum ", "param "+ paramMap.toString());
            Service.initialize(Order,null);

            // start payment service call here
            Service.startPaymentTransaction(Checksum.this, true, true,
                    Checksum.this  );
        }
    }
    @Override
    public void onTransactionResponse(Bundle bundle) {
        if(bundle.get("STATUS").equals("TXN_SUCCESS"))
        {
            //Paytm transaction is successful.
            paymentStatusDisplay.setText("Payment Status: Money deducted from paytm. Please wait while we update your bus pass details");
            //TODO: Update user bus pass details to transactions and firebase
            String transactionAmount= bundle.get("TXNAMOUNT").toString();
            String paymentMode= bundle.get("PAYMENTMODE").toString();
            String datetime= bundle.get("TXNDATE").toString();
            paymentStatusDisplay.setText("Payment Status: Success\n Amount="+transactionAmount+
            "\nPaymentMode="+paymentMode+"\nDatetime="+datetime);
        }
        if(bundle.get("STATUS").equals("TXN_FAILURE"))
        paymentStatusDisplay.setText("Payment Status: failure");
    }
    @Override
    public void networkNotAvailable() {
        paymentStatusDisplay.setText("Payment Status: Network Not Available.Check your internet connection");
    }
    @Override
    public void clientAuthenticationFailed(String s) {
        paymentStatusDisplay.setText("Payment Status: Client authentication failed. PayTm server down or checksum error by our group"+s);
    }
    @Override
    public void someUIErrorOccurred(String s) {
        paymentStatusDisplay.setText("Payment Status: UI error occurred. Contact app developers. Error message  is\n"+s);
    }
    @Override
    public void onErrorLoadingWebPage(int i, String s, String s1) {
        paymentStatusDisplay.setText("Payment Status: Error loading web page");
    }
    @Override
    public void onBackPressedCancelTransaction() {
        paymentStatusDisplay.setText("Payment Status: Transaction cancelled. Did you press back button?");
    }
    @Override
    public void onTransactionCancel(String s, Bundle bundle) {
        paymentStatusDisplay.setText("Payment Status: Sorry. Transaction failed. "+s);
    }
}
