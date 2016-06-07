package com.caunk94.materialdesign222;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentSatu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentSatu#newInstance} factory method to
 * create an instance of this fragment.
 */


public class FragmentSatu extends android.support.v4.app.Fragment {


    public FragmentSatu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_satu, container, false);
    }


}
