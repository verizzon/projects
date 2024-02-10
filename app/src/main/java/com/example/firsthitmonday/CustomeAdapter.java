package com.example.firsthitmonday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {
        private static final int VIEW_TYPE_TOP_IMAGE = 0;
    private static final int VIEW_TYPE_CARD = 1;
    ArrayList<DataModel> dataset;

    public CustomeAdapter(ArrayList<DataModel> dataSet) {
        this.dataset = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;
        ImageView imageViewTop;

        public MyViewHolder (View itemView){
            super(itemView);
//            imageViewTop = itemView.findViewById(R.id.imageTop);
            textViewName = itemView.findViewById(R.id.textView1);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout , parent , false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageView;

        textViewName.setText(dataset.get(position).getName());
        textViewVersion.setText((dataset.get(position).getVersion()));
        imageView.setImageResource(dataset.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
