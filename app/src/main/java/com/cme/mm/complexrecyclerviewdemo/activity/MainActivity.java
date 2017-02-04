package com.cme.mm.complexrecyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cme.mm.complexrecyclerviewdemo.R;
import com.cme.mm.complexrecyclerviewdemo.adapter.DemoAdapter;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Click(R.id.btn_toComplexListDemo)
    void toComplexList() {
        ComplexListDemoActivity_.intent(this).start();
    }

    @Click(R.id.btn_toListAndGridComplexDemo)
    void toListAndGridComplex() {
        ListAndGridComplexDemoActivity_.intent(this).start();
    }

    @Click(R.id.btn_toMultipleDataDemo)
    void oMultipleDataComplex() {
        MultipleDataModelActivity_.intent(this).start();
    }
}