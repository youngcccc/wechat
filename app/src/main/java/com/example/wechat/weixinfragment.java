package com.example.wechat;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link weixinfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class weixinfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private List<String> list;
    private Context context;
    private  myadapter myadapter;
    public weixinfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment weixinfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static weixinfragment newInstance(String param1, String param2) {
        weixinfragment fragment = new weixinfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.tab_01,container,false);
        context=view.getContext();
        recyclerView=view.findViewById(R.id.recyclerview);
        list=new ArrayList<String>();
        initData();
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        myadapter = new myadapter(list,context);

        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));


        return view;
    }
    private void initData(){
        list.add("HOUSTON ROCKETS");
        list.add("LOSANGEL LAKERS");
        list.add("DALAS MAV");
        list.add("LOSANGEL CLIPPERS");
        list.add("DENVER NUGGETS");
        list.add("PORTLAND BLIZZARDS");
        list.add("GOLDEN STATE WORRIERS");
        list.add("CHICAGO BULLS");
        list.add("BROOKLIN NETS ");
        list.add("TORONTO RAPATORS");
    }
}

