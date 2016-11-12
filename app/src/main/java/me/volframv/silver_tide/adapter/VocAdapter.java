package me.volframv.silver_tide.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import me.volframv.silver_tide.OnTapListener;
import me.volframv.silver_tide.R;
import me.volframv.silver_tide.item.Item;
import me.volframv.silver_tide.item.SetViewHolder;


/**
 * Created by PRIME-USER-X10423 on 11/11/2016.
 */

public class VocAdapter extends RecyclerView.Adapter<SetViewHolder> {
    private Activity activity;
    List<Item> items = Collections.emptyList();
    private OnTapListener onTapListener;
    public VocAdapter(Activity activity, List<Item> items){
        this.activity=activity;
        this.items=items;

    }
    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, final int position) {
        holder.txt_exercise.setText(items.get(position).getExercise());
        holder.txt_weight.setText(items.get(position).getWeight());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(onTapListener !=null){
                    onTapListener.OnTapView(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public void setOnTapListener(OnTapListener onTapListener) {
        this.onTapListener=onTapListener;
    }
}
