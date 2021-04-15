package com.example.room;

import java.util.List;

public class RoomListData {

   private List<Data> mData;

    public List<Data> getData() {
        return mData;
    }

    public void setData(List<Data> data) {
        mData = data;
    }

    public static class Data {
        private String name;
        private int age;
        private String sex;


        public String getName() {

            return name;
        }

        public int getAge() {
            return age;
        }

        public String getSex() {
            return sex;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
