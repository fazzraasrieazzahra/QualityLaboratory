package com.example.davegan.qualitylaboratory30;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davegan.qualitylaboratory30.api.ApiRequestBiodata;
import com.example.davegan.qualitylaboratory30.api.Retroserver;
import com.example.davegan.qualitylaboratory30.model.ResponsModel2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Peminjaman extends AppCompatActivity {

    EditText getDetail_id_alat,getDetail_kondisi_sebelum,getDetail_id_peminjam,getDetail_id_lab,getDetail_nama_peminjam,getDetail_no_telfon,getDetail_alamat_email, getDetail_tanggal_pinjam,getDetail_kondisi_sesudah;
    TextView getDetail_nama_alat,getDetail_tanggal_pengembalian;
    Button btnSave,btnTampilData;
    ProgressDialog pd;
    View viewLayout;
    String valFormAct1,valFormAct2;


    private String getDateToday(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
        Date date=new Date();
        String today= dateFormat.format(date);
        return today;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peminjaman);


        getDetail_nama_alat = (TextView) findViewById(R.id.edt_nama_alat);
        getDetail_kondisi_sebelum = (EditText) findViewById(R.id.edt_kondisi_sebelum);
        getDetail_id_peminjam = (EditText) findViewById(R.id.edt_id_peminjam);

        getDetail_nama_peminjam = (EditText) findViewById(R.id.edt_nama_peminjam);
        getDetail_no_telfon = (EditText) findViewById(R.id.edt_no_telfon);
        getDetail_alamat_email = (EditText) findViewById(R.id.edt_alamat_email);
        getDetail_tanggal_pinjam = (EditText) findViewById(R.id.edt_tanggal_pinjam);
        getDetail_tanggal_pengembalian = (EditText) findViewById(R.id.edt_tanggal_pengembalian);


        btnSave = (Button) findViewById(R.id.btn_insertdata);
        btnTampilData = (Button) findViewById(R.id.btntampildata);
        pd = new ProgressDialog(this);

        valFormAct1 = getIntent().getExtras().getString("data1");
        valFormAct2 = getIntent().getExtras().getString("data2");
        getDetail_id_alat.setText(valFormAct1);
        getDetail_nama_alat.setText(valFormAct2);
        getDetail_tanggal_pinjam.setText(getDateToday());



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Send Data...");
                pd.setCancelable(false);
                pd.show();
                Intent intent = new Intent(Peminjaman.this,MasterListAlatUkur.class);
                startActivity(intent);

                String $Detail_id_alat = getDetail_id_alat.getText().toString();
                String $Detail_nama_alat = getDetail_nama_alat.getText().toString();
                String $Detail_kondisi_sebelum = getDetail_kondisi_sebelum.getText().toString();
                String $Detail_id_peminjam = getDetail_id_peminjam.getText().toString();
                String $Detail_id_lab = getDetail_id_lab.getText().toString();
                String $Detail_nama_peminjam = getDetail_nama_peminjam.getText().toString();
                String $Detail_no_telfon = getDetail_no_telfon.getText().toString();
                String $Detail_alamat_email = getDetail_alamat_email.getText().toString();
                String $Detail_tanggal_pinjam = getDateToday();
                String $Detail_tanggal_pengembalian =getDetail_tanggal_pengembalian.getText().toString();
                String $Detail_kondisi_sesudah = getDetail_kondisi_sesudah.getText().toString();


                final ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);

                Call<ResponsModel2> sendPinjam = api.sendPinjam ($Detail_id_alat,$Detail_nama_alat,$Detail_kondisi_sebelum,$Detail_id_peminjam,$Detail_id_lab,$Detail_nama_peminjam,$Detail_no_telfon,$Detail_alamat_email,$Detail_tanggal_pengembalian,$Detail_kondisi_sesudah,$Detail_tanggal_pinjam);

                sendPinjam.enqueue(new Callback<ResponsModel2>() {
                    @Override
                    public void onResponse(Call<ResponsModel2> call, Response<ResponsModel2> response) {
                        pd.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String kode = response.body().getKode();

                        if (kode.equals("1"))
                        {
                            Toast toast1 = Toast.makeText(Peminjaman.this,"Berhasil Input",Toast.LENGTH_SHORT);
                            toast1.setGravity(Gravity.CENTER,0,0);
                            toast1.show();
                        }else
                        {
                            Toast.makeText(Peminjaman.this,"Gagal Coy",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel2> call, Throwable t) {
                        pd.hide();
                        Log.d("RETRO", "Falure :" + "Gagal Mengirim");
                    }
                });

            }
        });


        }
}
