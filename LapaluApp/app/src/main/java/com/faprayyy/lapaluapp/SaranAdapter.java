package com.faprayyy.lapaluapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SaranAdapter extends RecyclerView.Adapter<SaranAdapter.SaranViewHolder> {

    private ArrayList<SaranModel> dataList;

    public SaranAdapter(ArrayList<SaranModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public SaranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_saran, parent, false);
        return new SaranViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SaranViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtJudul.setText(dataList.get(position).getJudul());
        holder.txtLaporan.setText(dataList.get(position).getLaporan());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class SaranViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtJudul, txtLaporan;

        public  SaranViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtJudul = (TextView) itemView.findViewById(R.id.txt_judul);
            txtLaporan = (TextView) itemView.findViewById(R.id.txt_laporan_singkat);
        }
    }


}
