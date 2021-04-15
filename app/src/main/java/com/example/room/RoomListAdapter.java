package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.ViewHolder>{

    public Context mContext;
    private List<RoomListData.Data> mDataList=new ArrayList<>();
   private int position;

    public RoomListAdapter(Context context,List<RoomListData.Data> DataList){
        this.mContext=context;
        this.mDataList=DataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       private TextView mName;
       private TextView mAge;
       private TextView mSex;

        public ViewHolder(@NonNull View itemView,int position) {
            super(itemView);
         mName=(TextView)itemView.findViewById(R.id.name_block);
         mAge=(TextView)itemView.findViewById(R.id.age_block);
         mSex=(TextView)itemView.findViewById(R.id.sex_block);
        }
    }
    @Override
    public RoomListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item,parent,false);
       ViewHolder holder=new ViewHolder(view,position);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomListAdapter.ViewHolder holder, int position) {
        RoomListData.Data data=new RoomListData.Data();
        holder.mName.setText(data.getName());
        holder.mAge.setText(data.getAge());
        holder.mSex.setText(data.getSex());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
