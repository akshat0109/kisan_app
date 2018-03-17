package com.example.application.kisan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by HP on 06-02-2018.
 */

public class MachineryDataLoader extends RecyclerView.Adapter<MachineryDataLoader.MachineryBindViewClass>{

    private Context context;
    private HashMap<String,String> data;
    public MachineryDataLoader (Context context,HashMap<String,String> import_data) {
        this.context = context;
        data = import_data;
    }
    @Override
    public MachineryBindViewClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_data,parent,false);
        return new MachineryBindViewClass(view);
    }

    @Override
    public void onBindViewHolder(MachineryBindViewClass holder, int position) {
        holder.field.setText("" + data.get(position));
        holder.data.setText("" + data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MachineryBindViewClass extends RecyclerView.ViewHolder {

        TextView field;
        TextView data;

        public MachineryBindViewClass(View view) {
            super(view);

            field = view.findViewById(R.id.field);
            data = view.findViewById(R.id.data);


        }

    }
}
