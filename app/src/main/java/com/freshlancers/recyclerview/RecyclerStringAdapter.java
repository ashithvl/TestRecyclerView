package com.freshlancers.recyclerview;

/**
 * Created by Leon on 05-02-18.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerStringAdapter extends RecyclerView.Adapter<RecyclerStringAdapter.ViewHolder> {

    private List<StarWars> arrayList;

    public RecyclerStringAdapter(List<StarWars> arrayList) {

        this.arrayList = arrayList;
    }

    @Override
    public RecyclerStringAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerStringAdapter.ViewHolder holder, int position) {
        StarWars starwar = arrayList.get(position);
        holder.name.setText(starwar.getName());
        holder.gender.setText(starwar.getGender());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, gender;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            gender = itemView.findViewById(R.id.gender);

        }
    }
}