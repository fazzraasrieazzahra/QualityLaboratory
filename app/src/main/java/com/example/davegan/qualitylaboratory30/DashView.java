package com.example.davegan.qualitylaboratory30;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.davegan.qualitylaboratory30.adapter.AdapterData;
import com.example.davegan.qualitylaboratory30.api.ApiRequestBiodata;
import com.example.davegan.qualitylaboratory30.api.Retroserver;
import com.example.davegan.qualitylaboratory30.model.DataModel;
import com.example.davegan.qualitylaboratory30.model.ResponsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashView extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataModel> mItem = new ArrayList<>();
    ProgressDialog pd;
    FloatingActionButton inputData;

    public DashView() {
        // Required empty public constructor
    }

    protected View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_dash_view, container, false);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_view);

        inputData = (FloatingActionButton) findViewById(R.id.btn_inputData) ;
        inputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Siap Menambahkan Poject !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashView.this,InputDashboard.class);
                startActivity(intent);
            }
        });


        pd = new ProgressDialog(this);

        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycler.setLayoutManager(mManager);


        pd.setMessage("Loading......");
        pd.setCancelable(false);
        pd.show();

        ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);

        Call<ResponsModel> getdata = api.getBiodata();

        getdata.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItem = response.body().getResult();
                mAdapter = new AdapterData(DashView.this,mItem);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : Respon GAGAL");
            }
        });
    }
}
