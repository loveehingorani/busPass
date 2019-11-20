package com.example.busspass;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainPageFragment extends Fragment {
private TextView mUserName;
    MondayDatabaseHelper mondaydb;
    private CardView mBuyPass,mTransactions,mCallButton,mReminder;
    private TextView mShowEmail,mShowName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main_page, container, false);
        //mLogOut=v.findViewById(R.id.logout);
        mBuyPass=v.findViewById(R.id.buyPass);
        mondaydb=new MondayDatabaseHelper(getContext());
        //mViewAll=v.findViewById(R.id.viewAll);
        //mShowEmail=(TextView)v.findViewById(R.id.showemail);
       // mShowName=v.findViewById(R.id.showname);

       // mShowEmail.setText(LoginActivity.getEmail());
       // mShowName.setText(LoginActivity.getUserName());

        mCallButton=v.findViewById(R.id.button_call);
       // mPdfButton=v.findViewById(R.id.button1);
        mTransactions=v.findViewById(R.id.transactions);
        mReminder=v.findViewById(R.id.reminder);
        mBuyPass.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.buybuspass));
      //  mBusPass.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.buyBusPassFragment));
        mTransactions.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.transactions));
//        mLogOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signOut(mLogOut);
//
//            }
//        });
//        mViewAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor mondayCursor=mondaydb.getAllData();
//                if(mondayCursor.getCount()==0)
//                {
//                    showMessage("Error","Nothing");
//                    return ;
//                }
//                StringBuffer buffer=new StringBuffer();
//                while(mondayCursor.moveToNext())
//                {
//                    buffer.append("Id"+mondayCursor.getString(0)+"   ");
//                    buffer.append("time"+mondayCursor.getString(1)+"   ");
//                    buffer.append("start"+mondayCursor.getString(2)+"   ");
//                    buffer.append("end"+mondayCursor.getString(3)+"    ");
//                    buffer.append("bus"+mondayCursor.getString(4)+ "    ");
//                    buffer.append("alarm"+mondayCursor.getString(5)+"   ");
//                    buffer.append("notify"+mondayCursor.getString(6)+"\n");
//                }
//
//                showMessage("Data",buffer.toString());
//
//            }
//        });

        mReminder.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.reminder));
        mCallButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7903945473"));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    startActivity(callIntent);
                }
            }
        });

       // mPdfButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.busTimePdf));
        return v;
    }


//    public void showMessage(String title,String Message)
//    {
//        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//
//    }

//    public void signOut(View view) {
//        FirebaseAuth.getInstance().signOut();
//        Intent intent = new Intent(getActivity(), LoginActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//        getActivity().finish();
//
//    }
}