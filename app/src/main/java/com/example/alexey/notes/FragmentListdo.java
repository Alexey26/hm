package com.example.alexey.notes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

import static android.support.v7.widget.LinearLayoutManager.*;

public class FragmentListdo extends Fragment  {
    private FloatingActionButton butadd;

//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
    public FragmentListdo() {
        // Required empty public constructor
    }
//
//    public static FragmentListdo newInstance(String param1, String param2) {
//        FragmentListdo fragment = new FragmentListdo();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_listdo, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewDo);
        recyclerView.setAdapter(new MyAdapter(DataBase.getInstance().getListDo()));
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(), VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        butadd = view.findViewById(R.id.floatingActionButton);
        butadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".ActivityAddDo");
                startActivity(intent);
            }
        });
        return view;
    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(".ActivityAddDo");
//        startActivity(intent);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
