package com.example.davegan.qualitylaboratory30;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListAlatUkur extends AppCompatActivity {

    String urladdress = "http://192.168.137.1/askiServer/read2.php";

    String[] id_no;
    String[] nama_alat;
    String[] item_id;
    String[] serial_no;
    String[] gambar_alat;
    String[] sertifikat;
    String[] location;
    String[] item_range;
    String[] maximum_tolerance;
    String[] item_precision;
    String[] calibration_places;
    String[] schedul;
    String[] calibration_period;
    String[] merk;
    String[] last_calibration;
    String[] next_calibration;
    String[] condition;
    String[] imagepath;
    GridView gridView;
    BufferedInputStream inputStream;
    String line=null;
    String result=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alat_ukur);

        gridView = (GridView) findViewById(R.id.ListAlatUkur);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        CollectData();

        CustomListView customListView = new CustomListView( this,id_no, nama_alat, item_id, serial_no,
                sertifikat, location, item_range, maximum_tolerance, item_precision, calibration_places,
                schedul, calibration_period, merk, last_calibration, next_calibration, condition, imagepath);
        gridView.setAdapter(customListView);
    }

        private void CollectData()
        {
            try{

                URL url = new URL(urladdress);
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                inputStream = new BufferedInputStream(con.getInputStream());

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

    //content
            try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((line=bufferedReader.readLine())!=null){
                    stringBuilder.append(line+"\n");
                }
                inputStream.close();
                result=stringBuilder.toString();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

//json
         try {
             JSONArray ja=new JSONArray(result);
             JSONObject jo=null;
             id_no=new String[ja.length()];
             nama_alat=new String[ja.length()];
             last_calibration=new String[ja.length()];
             gambar_alat=new String[ja.length()];

             for(int i=0;i<=ja.length();i++){
                 jo=ja.getJSONObject(i);
                 nama_alat[i]=jo.getString("nama_alat");
                 item_id[i]=jo.getString("item_id");
                 last_calibration[i]=jo.getString("last_calibration");
                 gambar_alat[i]=jo.getString("gambar_alat");
             }
         }
         catch (Exception ex)
         {
             ex.printStackTrace();
         }
    }
}
