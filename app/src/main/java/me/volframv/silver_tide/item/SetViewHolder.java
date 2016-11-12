package me.volframv.silver_tide.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import me.volframv.silver_tide.R;

/**
 * Created by PRIME-USER-X10423 on 11/11/2016.
 */

public class SetViewHolder extends RecyclerView.ViewHolder{
    public TextView txt_exercise;
    public TextView txt_weight;
    public TextView txt_rep;
    public TextView txt_set;

    public SetViewHolder(View itemView) {
        super(itemView);
        txt_exercise= (TextView) itemView.findViewById(R.id.txt_exercise);
        txt_weight=(TextView) itemView.findViewById(R.id.txt_weight);
       // txt_rep=(TextView) itemView.findViewById(R.id.txt_rep); ADD TO CARD
       // txt_set=(TextView) itemView.findViewById(R.id.txt_set); ADD TO CARD U NUB ;-)
    }
}
