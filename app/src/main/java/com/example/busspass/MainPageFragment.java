package com.example.busspass;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import com.google.firebase.auth.FirebaseAuth;

public class MainPageFragment extends Fragment {

    private CardView mBuyPass,mTransactions,mCallButton,mReminder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main_page, container, false);
        //mLogOut=v.findViewById(R.id.logout);
        mBuyPass=v.findViewById(R.id.buyPass);

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


    public void signOut(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        getActivity().finish();

    }
}