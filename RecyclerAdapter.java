 package com.example.alaap.amityyouthfest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;


 class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewholder> {

     private LayoutInflater inflater;
     private List<Information> data = Collections.emptyList();
      Context context;

     RecyclerAdapter(Context c, List<Information> list) {
         this.context = c;
         this.data = list;
         inflater = LayoutInflater.from(c);
     }


     @Override
     public RecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

         View row = inflater.inflate(R.layout.listrecycler, parent, false);
         RecyclerViewholder holder = new RecyclerViewholder(row);
         return holder;
     }

     @Override
     public void onBindViewHolder(RecyclerViewholder holder, int position) {

         Information current = data.get(position);
         holder.head.setText(current.header);
         holder.sub.setText(current.sub);
         holder.imghead.setImageResource(current.head);
         holder.icon.setImageResource(current.icon);

     }


     @Override
     public int getItemCount() {
         return data.size();
     }

     class RecyclerViewholder extends RecyclerView.ViewHolder {
         TextView head, sub;
         ImageView imghead, icon;

         RecyclerViewholder(View itemView) {
             super(itemView);
             head = (TextView) itemView.findViewById(R.id.head);
             sub = (TextView) itemView.findViewById(R.id.sub);
             imghead = (ImageView) itemView.findViewById(R.id.img);
             icon = (ImageView) itemView.findViewById(R.id.icon);
         }
     }
 }