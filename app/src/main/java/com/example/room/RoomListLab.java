package com.example.room;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class RoomListLab {

    public static RoomListLab sRoomListLab;
    private static List<RoomListData.Data> mData;

    public RoomListLab(Context context){
        mData=new ArrayList<>();
        for(int i=0;i<15;i++){
            RoomListData.Data roomListData=new RoomListData.Data();
            roomListData.setName("名字"+i);
            roomListData.setAge(i);
            roomListData.setSex("性别"+i);
        }
    }
    public static RoomListLab get(Context  context){
        return sRoomListLab;
    }
    public static List<RoomListData.Data> getmData(){
        return mData;
    }
}
