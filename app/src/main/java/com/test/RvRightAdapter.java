package com.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class RvRightAdapter extends RecyclerView.Adapter{
    private MainActivity context;

    public RvRightAdapter(Context context){
        this.context=(MainActivity)context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=context.getLayoutInflater().inflate(R.layout.listcell_right,parent,false);
            MyViewHolder holder=new MyViewHolder(view);
            return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, final int position) {
        MyViewHolder holder= (MyViewHolder) holder1;
        holder.text.setText("hello");
        holder.image.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView text;
        private final CustomImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.text);
            image=(CustomImageView)itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
