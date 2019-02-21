package com.example.davegan.qualitylaboratory30;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MasterListAlatUkur extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.42.62";
    private static final String FULL_URL = BASE_URL + "/askiServer/";

    class ListAlatUkur {

        @SerializedName("id_no")
        private String id_no;
        @SerializedName("nama_alat")
        private String nama_alat;
        @SerializedName("item_id")
        private String item_id;
        @SerializedName("serial_no")
        private String serial_no;
        @SerializedName("gambar_alat")
        private String gambar_alat;
        @SerializedName("sertifikat")
        private String sertifikat;
        @SerializedName("location")
        private String location;
        @SerializedName("item_range")
        private String item_range;
        @SerializedName("maximum_tolerance")
        private String maximum_tolerance;
        @SerializedName("item_precision")
        private String item_precision;
        @SerializedName("calibration_places")
        private String calibration_places;
        @SerializedName("schedul")
        private String schedul;
        @SerializedName("calibration_period")
        private String calibration_period;
        @SerializedName("merk")
        private String merk;
        @SerializedName("last_calibration")
        private String last_calibration;
        @SerializedName("next_calibration")
        private Date next_calibration;
        @SerializedName("condition")
        private String condition;

        public ListAlatUkur (String id_no, String nama_alat, String item_id, String serial_no, String gambar_alat, String sertifikat, String location, String item_range, String maximum_tolerance, String item_percision, String calibration_places, String schedul, String calibration_period, String merk, Date last_calibration, Date next_calibration, String condition){
            this.id_no = id_no;
            this.nama_alat = nama_alat;
            this.item_id = item_id;
            this.serial_no = serial_no;
            this.gambar_alat = gambar_alat;
            this.sertifikat = sertifikat;
            this.location = location;
            this.item_range = item_range;
            this.maximum_tolerance = maximum_tolerance;
            this.item_precision = item_percision;
            this.calibration_places = calibration_places;
            this.schedul = schedul;
            this.calibration_period = calibration_period;
            this.merk = merk;
            this.next_calibration = next_calibration;
            this.last_calibration = getLast_calibration();
            this.condition = condition;
        }
        public String getId_no() {
            return id_no;
        }
        public void setId_no( String id_no) {
            this.id_no = id_no;
        }

        public String getNama_alat() { return nama_alat; }
        public void setNama_alat(String nama_alat) {
            this.nama_alat = nama_alat;
        }

        public String getItem_id() { return item_id; }
        public void setItem_id(String item_id){this.item_id = item_id;}

        public String getSerial_no() {
            return serial_no;
        }
        public void setSerial_no(String serial_no){this.serial_no = serial_no;}

        public String getGambar_alat() {
            return gambar_alat;
        }
        public void setGambar_alat(String gambar_alat){this.gambar_alat = gambar_alat;}

        public String getSertifikat() {
            return sertifikat;
        }
        public void setSertifikat(String sertifikat) {this.sertifikat = sertifikat;}

        public String getLocation() { return location; }
        public void setLocation(String location){this.location = location;}

        public String getItem_range() { return item_range; }
        public void setItem_range(String item_range){this.item_range = item_range;}

        public String getMaximum_tolerance() {
            return maximum_tolerance;
        }
        public void setMaximum_tolerance(String maximum_tolerance){this.maximum_tolerance = maximum_tolerance;}

        public String getItem_precision() {
            return item_precision;
        }
        public void setItem_precision(String item_precision) {this.item_precision = item_precision;}

        public String getCalibration_places() {
            return calibration_places;
        }
        public void setCalibration_places(String calibration_places){this.calibration_places = calibration_places;}

        public String getSchedul() {
            return schedul;
        }
        public void setSchedul (String schedul) {this.schedul = schedul; }

        public String getCalibration_period() {
            return calibration_period;
        }
        public void setCalibration_period(String calibration_period){this.calibration_period = calibration_period;}

        public String getMerk() {
            return merk;
        }
        public void setMerk(String merk){this.merk = merk;}

        public String getLast_calibration() {
            return last_calibration;
        }
        public void getLast_calibration(Date last_calibration) {this.last_calibration = getLast_calibration(); }

        public Date getNext_calibration() {
            return next_calibration;
        }
        public void getNext_calibration(Date next_calibration) {this.next_calibration = next_calibration; }

        public boolean getCondition() { return getCondition(); }
        public void getCondition(String condition) {this.condition = condition; }


        @Override
        public String toString() {
            return nama_alat;
        }

    }


    interface MyAPIService {

        @GET("/askiServer/")
        Call<List<ListAlatUkur>> getListAlatUkur();
    }
    static class RetrofitClientInstance {

        private static Retrofit retrofit;


        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }
    class GridViewAdapter extends BaseAdapter {

        private List<ListAlatUkur> ListAlats;
        private Context context;

        public GridViewAdapter(Context context,List<ListAlatUkur> ListAlatUkur){
            this.context = context;
            this.ListAlats = ListAlatUkur;
        }

        @Override
        public int getCount() { return ListAlats.size(); }

        @Override
        public Object getItem(int pos) {
            return ListAlats.get(pos);
        }

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if(view==null)
            {
                view=LayoutInflater.from(context).inflate(R.layout.model,viewGroup,false);
            }

            TextView txtNamaAlat = view.findViewById(R.id.Detail_nama_alat);
            TextView txtItemId = view.findViewById(R.id.Detail_item_id);
            TextView txtLastCalibration = view.findViewById(R.id.tvLastCalibration);
            CheckBox chkTechExists = view.findViewById(R.id.myCheckBox);
            ImageView gambar_alat = view.findViewById(R.id.gridAlatUkur);



            final ListAlatUkur thisListAlatUkur= ListAlats.get(position);

                txtNamaAlat.setText(thisListAlatUkur.getNama_alat());
                txtItemId.setText(thisListAlatUkur.getItem_id());
                txtLastCalibration.setText(thisListAlatUkur.getLast_calibration());
                chkTechExists.setChecked(thisListAlatUkur.getCondition());
                chkTechExists.setEnabled(false);

            if(thisListAlatUkur.getGambar_alat() != null && thisListAlatUkur.getGambar_alat().length()>0)
            {
                Picasso.get().load(FULL_URL+"/image/"+thisListAlatUkur.getGambar_alat()).placeholder(R.drawable.placeholder).into(gambar_alat);
            }else {
                Toast.makeText(context, "Empty Image URL", Toast.LENGTH_LONG).show();
                Picasso.get().load(R.drawable.placeholder).into(gambar_alat);
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, thisListAlatUkur.getNama_alat(), Toast.LENGTH_SHORT).show();
                    String techExists="";
                    if (thisListAlatUkur.getCondition()){
                        techExists="YES";
                    }else{
                        techExists="NO";
                    }
                    String[] MasterListAlatUkur = new String[]{
                            thisListAlatUkur.getNama_alat(),
                            thisListAlatUkur.getItem_id(), techExists,
                            FULL_URL + "/image/" + thisListAlatUkur.getGambar_alat(),
                            thisListAlatUkur.getId_no(),
                            thisListAlatUkur.getNama_alat(),
                            thisListAlatUkur.getItem_id(),
                            thisListAlatUkur.getSerial_no(),
                            thisListAlatUkur.getGambar_alat(),
                            thisListAlatUkur.getSertifikat(),
                            thisListAlatUkur.getLocation(),
                            thisListAlatUkur.getItem_range(),
                            thisListAlatUkur.getMaximum_tolerance(),
                            thisListAlatUkur.getItem_precision(),
                            thisListAlatUkur.getCalibration_places(),
                            thisListAlatUkur.getSchedul(),
                            thisListAlatUkur.getCalibration_period(),
                            thisListAlatUkur.getMerk(),
                            thisListAlatUkur.getLast_calibration(),


                    };
                    openDetailActivity(MasterListAlatUkur);
                }
            });


            return view;
        }

        private void openDetailActivity(String[] data) {
            Intent intent = new Intent(MasterListAlatUkur.this, DetailsAlat.class);
            intent.putExtra("ID_NO", data[0]);
            intent.putExtra("NAMA_ALAT", data[1]);
            intent.putExtra("ITEM_ID", data[2]);
            intent.putExtra("SERIAL_NO", data[3]);
            intent.putExtra("GAMBAR_ALAT", data[4]);
            intent.putExtra("SERTIFIKAT",data[5]);
            intent.putExtra("LOCATION",data[6]);
            intent.putExtra("ITEM_RANGE",data[7]);
            intent.putExtra("MAXIMUM_TOLERANCE",data[8]);
            intent.putExtra("ITEM_PRECISION",data[9]);
            intent.putExtra("CALIBRATION_PLACES",data[10]);
            intent.putExtra("SCHEDUL",data[11]);
            intent.putExtra("CALIBRATION_PERIOD",data[12]);
            intent.putExtra("MERK",data[13]);
            intent.putExtra("LAST_CALIBRATION",data[14]);
            intent.putExtra("NEXT_CALIBRATION",data[15]);
            intent.putExtra("CONDITION",data[16]);

            startActivity(intent);
        }
    }
    private GridViewAdapter adapter;
    private GridView mGridView;
    ProgressBar myProgres;

    private void populateGridView(List<ListAlatUkur> spacecraftList) {
        mGridView = findViewById(R.id.gridAlatUkur);
        adapter = new GridViewAdapter(this,spacecraftList);
        mGridView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list_alat_ukur);

        final ProgressBar myProgres= findViewById(R.id.myProgressBar);
        myProgres.setIndeterminate(true);
        myProgres.setVisibility(View.VISIBLE);

        /*Create handle for the RetrofitInstance interface*/
        MyAPIService myAPIService = RetrofitClientInstance.getRetrofitInstance().create(MyAPIService.class);

        Call<List<ListAlatUkur>> call = myAPIService.getListAlatUkur();
        call.enqueue(new Callback<List<MasterListAlatUkur.ListAlatUkur>>() {
            @Override
            public void onResponse(Call<List<ListAlatUkur>> call, Response<List<ListAlatUkur>> response) {
                myProgres.setVisibility(View.GONE);
                populateGridView(response.body());
            }

            @Override
            public void onFailure(Call<List<ListAlatUkur>> call, Throwable t) {
                myProgres.setVisibility(View.GONE);
                Toast.makeText( MasterListAlatUkur.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
