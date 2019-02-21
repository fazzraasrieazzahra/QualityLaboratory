package com.example.davegan.qualitylaboratory30;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davegan.qualitylaboratory30.api.ApiRequestBiodata;
import com.example.davegan.qualitylaboratory30.api.Retroserver;
import com.example.davegan.qualitylaboratory30.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputDashboard extends AppCompatActivity {
    EditText id_no, nama_alat, item_id, serial_no, gambar_alat, sertifikat, location, item_range, maximum_tolerance, item_precision, calibration_places, schedul, calibration_period, merk, last_calibration, next_calibration, condition ;
    Button btnSave,btnTampilData;
    ProgressDialog pd;
    View viewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_dashboard);

        id_no = (EditText) findViewById(R.id.edt_id_no);
        nama_alat = (EditText) findViewById(R.id.edt_nama_alat);

        serial_no =(EditText) findViewById(R.id.edt_serial_no);
        gambar_alat = (EditText) findViewById(R.id.edt_gambar_alat);
        sertifikat = (EditText) findViewById(R.id.edt_sertifikat);

        item_range = (EditText) findViewById(R.id.edt_item_range);
        maximum_tolerance = (EditText) findViewById(R.id.edt_maximum_tolerance);
        item_precision = (EditText) findViewById(R.id.edt_item_precision);
        calibration_places = (EditText) findViewById(R.id.edt_calibration_places);
        schedul = (EditText) findViewById(R.id.edt_schedul);
        calibration_period = (EditText) findViewById(R.id.edt_calibration_period);
        merk = (EditText) findViewById(R.id.edt_merk);
        last_calibration = (EditText) findViewById(R.id.edt_last_calibration);
        next_calibration = (EditText) findViewById(R.id.edt_next_calibration);
        condition = (EditText) findViewById(R.id.edt_condition);
        btnSave = (Button) findViewById(R.id.btn_insertdata);
        btnTampilData = (Button) findViewById(R.id.btntampildata);
        pd = new ProgressDialog(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        viewLayout = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_layout));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Send Data...");
                pd.setCancelable(false);
                pd.show();
                Intent intent = new Intent(InputDashboard.this,DashView.class);
                startActivity(intent);

                String $id_no = id_no.getText().toString();
                String $nama_alat = nama_alat.getText().toString();
                String $item_id = item_id.getText().toString();
                String $serial_no = serial_no.getText().toString();
                String $gambar_alat = gambar_alat.getText().toString();
                String $sertifikat = sertifikat.getText().toString();
                String $location = location.getText().toString();
                String $item_range = item_range.getText().toString();
                String $maximum_tolerance = maximum_tolerance.getText().toString();
                String $item_percision = item_precision.getText().toString();
                String $calibration_places = calibration_places.getText().toString();
                String $schedul = schedul.getText().toString();
                String $calibration_period = calibration_period.getText().toString();
                String $merk = merk.getText().toString();
                String $last_calibration = last_calibration.getText().toString();
                String $next_calibration =  next_calibration.getText().toString();
                String $condition = condition.getText().toString();


         final ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);

                Call<ResponsModel> sendBiodata = api.sendBiodata($id_no,$nama_alat,$item_id,$serial_no,$gambar_alat,$sertifikat,$location,$item_range,$maximum_tolerance,$item_percision,$calibration_places,$schedul,$calibration_period,$merk,$last_calibration,$next_calibration,$condition);
                sendBiodata.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        pd.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String kode = response.body().getKode();

                        if (kode.equals("1"))
                        {
                            Toast toast1 = Toast.makeText(InputDashboard.this,"Toast:Gravity.Top",Toast.LENGTH_SHORT);
                            toast1.setGravity(Gravity.CENTER,0,0);
                            toast1.setView(viewLayout);
                            toast1.show();
                        }else
                        {
                            Toast.makeText(InputDashboard.this,"Gagal Coy",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("RETRO", "Falure :" + "Gagal Mengirim");
                    }
                });

            }
        });

    }
}
