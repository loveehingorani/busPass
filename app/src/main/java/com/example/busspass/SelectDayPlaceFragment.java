package com.example.busspass;


import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectDayPlaceFragment extends Fragment {

    TextView tv1,tv2,tv3;
    public String stv1,stv2,stv3;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt11,bt12,bt13,bt14,bt15,bt21,bt22,bt23,bt24,bt25,proceed;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_select_day_place, container, false);
        tv1 = (TextView) v.findViewById(R.id.tv1);
        tv2 = (TextView) v.findViewById(R.id.tv2);
        tv3 = (TextView) v.findViewById(R.id.tv3);

        bt1 = (Button) v.findViewById(R.id.button1);
        bt2 = (Button) v.findViewById(R.id.button2);
        bt3 = (Button) v.findViewById(R.id.button3);
        bt4 = (Button) v.findViewById(R.id.button4);
        bt5 = (Button) v.findViewById(R.id.button5);
        bt6 = (Button) v.findViewById(R.id.button6);
        bt7 = (Button) v.findViewById(R.id.button7);
        bt11 = (Button) v.findViewById(R.id.button11);
        bt12 = (Button) v.findViewById(R.id.button12);
        bt13 = (Button) v.findViewById(R.id.button13);
        bt14 = (Button) v.findViewById(R.id.button14);
        bt15 = (Button) v.findViewById(R.id.button15);
        bt21 = (Button) v.findViewById(R.id.button31);
        bt22 = (Button) v.findViewById(R.id.button32);
        bt23 = (Button) v.findViewById(R.id.button33);
        bt24 = (Button) v.findViewById(R.id.button34);
        bt25 = (Button) v.findViewById(R.id.button35);
        proceed = (Button) v.findViewById(R.id.btgo);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Monday");
                tv1.setTypeface(null, Typeface.BOLD);
                stv1 = "Monday";
            }

        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Tuesday");
                tv1.setTypeface(null, Typeface.BOLD);
                stv1 = "Tuesday";
            }

        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Wednesday");
                tv1.setTypeface(null, Typeface.BOLD);
                stv1 = "Wednesday";
            }

        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Thursday");
                tv1.setTypeface(null, Typeface.BOLD);
                stv1 = "Thursday";
            }

        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Friday");
                tv1.setTypeface(null, Typeface.BOLD);
                stv1 = "Friday";
            }

        });


        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Saturday");
                tv1.setTypeface(null, Typeface.BOLD);
                stv1 = "Saturday";
            }

        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("Sunday");
                tv1.setTypeface(null, Typeface.BOLD);
                stv1 = "Sunday";
            }

        });

        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText("Ajmeri Gate");
                tv2.setTypeface(null, Typeface.BOLD);
                stv2 = "Ajmeri Gate";
            }

        });

        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText("LNMIIT");
                tv2.setTypeface(null, Typeface.BOLD);
                stv2 = "LNMIIT";
            }

        });

        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText("Raja Park");
                tv2.setTypeface(null, Typeface.BOLD);
                stv2 = "Raja Park";
            }

        });

        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText("Nai Ki Thadi");
                tv2.setTypeface(null, Typeface.BOLD);
                stv2 = "Nai Ki Thadi";
            }

        });

        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText("Chomu Puliya");
                tv2.setTypeface(null, Typeface.BOLD);
                stv2 = "Chomu Puliya";
            }

        });

        bt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv3.setText("Ajmeri Gate");
                tv3.setTypeface(null, Typeface.BOLD);
                stv3 = "Ajmeri Gate";
            }

        });

        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv3.setText("LNMIIT");
                tv3.setTypeface(null, Typeface.BOLD);
                stv3 = "LNMIIT";
            }

        });

        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv3.setText("Raja Park");
                tv3.setTypeface(null, Typeface.BOLD);
                stv3 = "Raja Park";
            }

        });

        bt24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv3.setText("Nai Ki Thadi");
                tv3.setTypeface(null, Typeface.BOLD);
                stv3 = "Nai Ki Thadi";
            }

        });

        bt25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv3.setText("Chomu Puliya");
                tv3.setTypeface(null, Typeface.BOLD);
                stv3 = "Chomu Puliya";
            }

        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stv1==null||stv2==null||stv3==null)
                    Toast.makeText(getActivity(),"Please Select All The Options",Toast.LENGTH_SHORT).show();

                else if(stv1 == "Sunday" && stv2 == "Chomu Puliya"){
                    Toast.makeText(getActivity(),"No Bus Available",Toast.LENGTH_SHORT).show();
                }

                else if(stv1 == "Sunday" && stv3 == "Chomu Puliya"){
                    Toast.makeText(getActivity(),"No Bus Available",Toast.LENGTH_SHORT).show();
                }

                else if(stv1 == "Sunday" && stv3 == "Nai Ki Thadi"){
                    Toast.makeText(getActivity(),"No Bus Available",Toast.LENGTH_SHORT).show();
                }

                else if(stv1 == "Sunday" && stv2 == "Nai Ki Thadi"){
                    Toast.makeText(getActivity(),"No Bus Available",Toast.LENGTH_SHORT).show();
                }

                else if(stv2 == stv3){
                    Toast.makeText(getActivity(),"Select a valid option",Toast.LENGTH_SHORT).show();
                }

                else{
                    ShowSetReminderFragment s1=new ShowSetReminderFragment();
                    Bundle args = new Bundle();
                    args.putStringArray("key",new String[]{stv1,stv2,stv3});
                    s1.setArguments(args);
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,s1,"findThisFragment").addToBackStack(null).commit();
//                    Navigation.createNavigateOnClickListener(R.id.reminder1);
                    Navigation.findNavController(getView()).navigate(R.id.reminder1,args);
                    stv1=null;
                    stv2=null;
                    stv3=null;
                }

            }
        });


return v;
    }

}