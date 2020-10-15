package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment mTab01 = new weixinfragment();
    private Fragment mTab02 = new friend();
    private Fragment mTab03 = new contact();
    private Fragment mTab04 = new settings();

    private FragmentManager fm;

    private LinearLayout mTabWeiXin;
    private LinearLayout mTabAddress;
    private LinearLayout mTabFrd;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgAddress;
    private ImageButton mImgFrd;
    private ImageButton mImgSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        initEvent();
        selectfragment(0);
    }
    private void initFragment(){
        fm =getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mTab01);
        transaction.add(R.id.id_content,mTab02);
        transaction.add(R.id.id_content,mTab03);
        transaction.add(R.id.id_content,mTab04);
        transaction.commit();
    }

    private void initView()
    {
        mTabWeiXin= findViewById(R.id.id_tab_weixin);
        mTabFrd= findViewById(R.id.id_tab_frds);
        mTabAddress= findViewById(R.id.id_tab_contact);
        mTabSettings= findViewById(R.id.id_tab_settings);

        mImgWeixin =  findViewById(R.id.id_tab_weixin_img);
        mImgFrd=  findViewById(R.id.id_tab_frds_img);
        mImgAddress=  findViewById(R.id.id_tab_contact_img);
        mImgSettings= findViewById(R.id.id_tab_settings_img);
    }

    private void initEvent(){
        mTabWeiXin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }
    private void Hidefragment(FragmentTransaction transaction)
    {
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    private void selectfragment(int i)
    {
        FragmentTransaction transaction=fm.beginTransaction();
        Hidefragment(transaction);
        switch (i) {
            case 0:
                Log.d("setselct","1");
                transaction.show(mTab01);
                mImgWeixin.setImageResource(R.drawable.rockets);
                break;
            case 1:
                transaction.show(mTab02);
                mImgFrd.setImageResource(R.drawable.lakers);
                break;
            case 2:
                transaction.show(mTab03);
                mImgAddress.setImageResource(R.drawable.cavalier);
                break;
            case 3:
                transaction.show(mTab04);
                mImgSettings.setImageResource(R.drawable.blizard);
                break;
            default:
                break;
        }
        transaction.commit();
    }


    @Override
    public void onClick(View v) {
        Log.d("Onclick","1");
        resetimg();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                Log.d("Onclick","2");
                selectfragment(0);
                break;
            case R.id.id_tab_frds:
                selectfragment(1);
                break;
            case R.id.id_tab_contact:
                selectfragment(2);
                break;
            case R.id.id_tab_settings:
                selectfragment(3);
                break;
            default:
                break;
        }
        }
    public void resetimg() {
    mImgWeixin.setImageResource(R.drawable.celtic);
    mImgFrd.setImageResource(R.drawable.heat);
    mImgAddress.setImageResource(R.drawable.magic);
    mImgSettings.setImageResource(R.drawable.mavericks);
    }
}

