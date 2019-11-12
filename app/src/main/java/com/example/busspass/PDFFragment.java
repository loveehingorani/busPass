package com.example.busspass;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PDFFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pdf, container, false);
        PDFView pdfView = (PDFView) v.findViewById(R.id.pdfView);
        pdfView.fromAsset("bus_time.pdf").load();

       return v;
    }

}
