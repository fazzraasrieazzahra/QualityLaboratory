package com.example.davegan.qualitylaboratory30;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class CustomListView extends ArrayAdapter<String> {

    private String[] id_no;
    private String[] nama_alat;
    private String[] item_id;
    private String[] serial_no;
    private String[] sertifikat;
    private String[] location;
    private String[] item_range;
    private String[] maximum_tolerance;
    private String[] item_precision;
    private String[] calibration_places;
    private String[] schedul;
    private String[] calibration_period;
    private String[] merk;
    private String[] last_calibration;
    private String[] next_calibration;
    private String[] condition;
    private String[] imagepath;
    private Activity context;
    Bitmap bitmap;

    public CustomListView(Activity context,String[] idProduk,String[] namaalat,String[] item_id,String[]
                            serial_no,String[] sertifikat,String[] location,String[] item_range,String[] maximum_tolerance,String[]
                            item_precision,String[] calibration_places,String[] schedul,String[] calibration_period,String[]
                            merk,String[] last_calibration,String[] next_calibration,String[] condition,String[] imagepath){
        super(context,R.layout.layout_alatukur,idProduk);
        this.context=context;
        this.id_no=idProduk;
        this.nama_alat=namaalat;
        this.item_id=item_id;
        this.serial_no=serial_no;
        this.sertifikat=sertifikat;
        this.location=location;
        this.item_range=item_range;
        this.maximum_tolerance=maximum_tolerance;
        this.item_precision=item_precision;
        this.calibration_places=calibration_places;
        this.schedul=schedul;
        this.calibration_period=calibration_period;
        this.merk=merk;
        this.last_calibration=last_calibration;
        this.next_calibration=next_calibration;
        this.condition=condition;
        this.imagepath=imagepath;

    }


    @NonNull
    @Override

    public View getView (int position, @Nullable View converView, @NonNull ViewGroup parent){
        View r = converView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout_alatukur,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)r.getTag();
        }

        viewHolder.tvw1.setText(id_no[position]);
        viewHolder.tvw2.setText(nama_alat[position]);
        viewHolder.tvw3.setText(item_id[position]);
        viewHolder.tvw4.setText(serial_no[position]);
        viewHolder.tvw5.setText(sertifikat[position]);
        viewHolder.tvw6.setText(location[position]);
        viewHolder.tvw7.setText(item_range[position]);
        viewHolder.tvw8.setText(maximum_tolerance[position]);
        viewHolder.tvw9.setText(item_precision[position]);
        viewHolder.tvw10.setText(calibration_places[position]);
        viewHolder.tvw11.setText(schedul[position]);
        viewHolder.tvw12.setText(calibration_period[position]);
        viewHolder.tvw13.setText(merk[position]);
        viewHolder.tvw14.setText(last_calibration[position]);
        viewHolder.tvw15.setText(next_calibration[position]);
        viewHolder.tvw16.setText(condition[position]);

        new GetImageFromURL(viewHolder.ivw).execute(imagepath[position]);

        return r;
    }

    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;
        TextView tvw5;
        TextView tvw6;
        TextView tvw7;
        TextView tvw8;
        TextView tvw9;
        TextView tvw10;
        TextView tvw11;
        TextView tvw12;
        TextView tvw13;
        TextView tvw14;
        TextView tvw15;
        TextView tvw16;


        ImageView ivw;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.edt_id_no);
            tvw2=(TextView)v.findViewById(R.id.edt_nama_alat);
            tvw3=(TextView)v.findViewById(R.id.edt_item_id);
            tvw4=(TextView)v.findViewById(R.id.edt_serial_no);
            tvw5=(TextView)v.findViewById(R.id.edt_sertifikat);
            tvw6=(TextView)v.findViewById(R.id.edt_item_range);
            tvw4=(TextView)v.findViewById(R.id.edt_last_calibration);
            tvw16=(TextView)v.findViewById(R.id.edt_condition);
            ivw=(ImageView)v.findViewById(R.id.imageView);
        }
    }

    public  class GetImageFromURL extends AsyncTask<String,Void,Bitmap>
    {
        ImageView imgView;
        public GetImageFromURL(ImageView imgv)
        {
            this.imgView=imgv;
        }
        @Override
        protected Bitmap doInBackground(String... url) {
            String urlDisplay=url[0];
            bitmap=null;

            try{
                InputStream ist=new java.net.URL(urlDisplay).openStream();
                bitmap= BitmapFactory.decodeStream(ist);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);
        }
    }

}
