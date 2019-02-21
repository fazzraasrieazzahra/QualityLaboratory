package com.example.davegan.qualitylaboratory30.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.davegan.qualitylaboratory30.R;
import com.example.davegan.qualitylaboratory30.model.DataModel;


import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{

    private List<DataModel> mList;
    private Context ctx;

    public AdapterData (Context ctx,List<DataModel> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist2,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = mList.get(position);
        holder.namaPart.setText(dm.getNama_alat());
        holder.typePart.setText(dm.getItem_id());
        holder.pemohon.setText(dm.getCondition());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData extends RecyclerView.ViewHolder {
        TextView namaPart,typePart,pemohon;

        public HolderData(View v)
        {
            super(v);

            namaPart= (TextView) v.findViewById(R.id.jNama);
            typePart = (TextView) v.findViewById(R.id.jType);
            pemohon = (TextView) v.findViewById(R.id.jStatus);
        }
    }
}
