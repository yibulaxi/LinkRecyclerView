package com.test;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RvLeftAdapter extends RecyclerView.Adapter{

    private  MainActivity context;
    private List<LeftData.LeftItem> mList=new ArrayList<>();
    public int selectPosition=0;

    public RvLeftAdapter(Context context){
        this.context= (MainActivity)context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=context.getLayoutInflater().inflate(R.layout.listcell_left,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, final int position) {

        final MyViewHolder holder= (MyViewHolder) holder1;
        holder.text.setText(mList.get(position).name);
        if (position==selectPosition){
            holder.text.setTextColor(Color.parseColor("#ff4141"));
            holder.text.setBackgroundResource(R.color.white);

        }else {
            holder.text.setTextColor(Color.parseColor("#808080"));
            holder.text.setBackgroundResource(R.color.color_F8);
        }


    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }

    public void setData(ArrayList<LeftData.LeftItem> list) {
        this.mList=list;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   int position= getPosition();
                    selectPosition=position;
                    notifyDataSetChanged();
                    context.getRightData(mList.get(selectPosition).id);
                }
            });
        }
    }


}
