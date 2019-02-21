package com.example.davegan.qualitylaboratory30;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsAlat extends AppCompatActivity {

    TextView Detail_id_no, Detail_nama_alat, Detail_item_id, Detail_serial_no, Detail_sertifikat, Detail_location, Detail_item_range, Detail_maximum_tolerance, Detail_item_precision, Detail_calibration_places, Detail_schedul, Detail_calibration_period, Detail_merk, Detail_last_calibration, Detail_next_calibration, Detail_condition;
    CheckBox techExistsDetailCheckBox;
    ImageView Detail_gambar_alat;
    Button btn_request;
    String editTextVal1,editTextVal2;

    private void initializeWidgets(){
        Detail_nama_alat= findViewById(R.id.Detail_nama_alat);
        Detail_item_id= findViewById(R.id.Detail_item_id);
        Detail_serial_no= findViewById(R.id.Detail_serial_no);
        Detail_sertifikat= findViewById(R.id.Detail_sertifikat);
        Detail_location= findViewById(R.id.Detail_location);
        Detail_item_range= findViewById(R.id.Detail_item_range);
        Detail_maximum_tolerance= findViewById(R.id.Detail_maximum_tolerance);
        Detail_item_precision= findViewById(R.id.Detail_item_precision);
        Detail_calibration_places= findViewById(R.id.Detail_calibration_places);
        Detail_schedul= findViewById(R.id.Detail_schedul);
        Detail_calibration_period= findViewById(R.id.Detail_calibration_period);
        Detail_merk= findViewById(R.id.Detail_merk);
        Detail_last_calibration= findViewById(R.id.Detail_last_calibration);
        Detail_next_calibration= findViewById(R.id.Detail_next_calibration);
        Detail_condition= findViewById(R.id.Detail_condition);
        techExistsDetailCheckBox= findViewById(R.id.techExistsDetailCheckBox);
        Detail_gambar_alat=findViewById(R.id.Detail_gambar_alat);
    }
    private void receiveAndShowData(){
        //RECEIVE DATA FROM ITEMS ACTIVITY VIA INTENT
        Intent i=this.getIntent();
        String nama_alat=i.getExtras().getString("NAME_KEY");
        String item=i.getExtras().getString("PROPELLANT_KEY");
        String technologyExists=i.getExtras().getString("TECHNOLOGY_EXISTS_KEY");
        String imageURL=i.getExtras().getString("IMAGE_KEY");
        String serial_no=i.getExtras().getString("SERIAL_NO");
        String serifikat=i.getExtras().getString("SERTIFIKAT");
        String location=i.getExtras().getString("LOCATION");
        String item_range=i.getExtras().getString("ITEM_RANGE");
        String max_tolerance=i.getExtras().getString("MAX_TOLERANCE");
        String item_precision=i.getExtras().getString("ITEM_PRECESION");
        String calibrated_place=i.getExtras().getString("CALIBRATED_PLACE");
        String schedule=i.getExtras().getString("SCHEDULE");
        String lastcalibration=i.getExtras().getString("LAST CALIBRATION");
        String nextcalibration=i.getExtras().getString("NEXT CALIBRATION");
        String condition=i.getExtras().getString("CONDITION");



        //SET RECEIVED DATA TO TEXTVIEWS AND IMAGEVIEWS
        Detail_nama_alat.setText(nama_alat);
        Detail_item_id.setText(item);
        techExistsDetailCheckBox.setChecked(technologyExists.equalsIgnoreCase("YES"));
        techExistsDetailCheckBox.setEnabled(false);
        Picasso.get().load(imageURL).placeholder(R.drawable.placeholder).into(Detail_gambar_alat);
        Detail_serial_no.setText(serial_no);
        Detail_sertifikat.setText(serifikat);
        Detail_location.setText(location);
        Detail_item_range.setText(item_range);
        Detail_maximum_tolerance.setText(max_tolerance);
        Detail_item_precision.setText(item_precision);
        Detail_calibration_places.setText(calibrated_place);
        Detail_schedul.setText(schedule);
        Detail_last_calibration.setText(lastcalibration);
        Detail_next_calibration.setText(nextcalibration);
        Detail_condition.setText(condition);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_alat);

        btn_request =(Button) findViewById(R.id.btn_request);
        Detail_id_no = (TextView) findViewById(R.id.Detail_id_no);

        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailsAlat.this,Peminjaman.class);
                editTextVal1 = Detail_id_no.getText().toString();
                editTextVal2 = Detail_nama_alat.getText().toString();
                i.putExtra("data1",editTextVal1);
                i.putExtra("data2",editTextVal2);
                startActivity(i);
                finish();
            }
        });



        initializeWidgets();
        receiveAndShowData();
    }

}
