package com.example.room;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomLabView extends AppCompatActivity {


    private Context mContext;
    private RecyclerView mRecyclerView;
    private LinearLayout mLinearLayout;
    private RoomListAdapter mRoomListAdapter;
    private List<RoomListData.Data> mData=new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
       mRecyclerView=(RecyclerView)findViewById(R.id.room_list);
       mLinearLayout=(LinearLayout)findViewById(R.id.room_item);
       mRecyclerView.setLayoutManager(mLayoutManager);
        RoomListLab roomListLab=RoomListLab.get(mContext);
        List<RoomListData.Data> data=roomListLab.getmData();
        mRoomListAdapter=new RoomListAdapter(mContext,data);
        mRecyclerView.setAdapter(mRoomListAdapter);
       mLayoutManager.setOrientation(RecyclerView.VERTICAL);
    }
}
