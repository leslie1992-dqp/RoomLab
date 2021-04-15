package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG="打印出";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                databaseOperation();
            }
        }).start();

    }
    private void databaseOperation() {
        UserDatabase mUserDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "users").build();
        UserDao mUserDao = mUserDatabase.getUserDao();

        //写数据库
        Log.d(TAG, "开始写入数据...");
        writeDatabase(mUserDao, "鸣鸣", 18,"男");
        writeDatabase(mUserDao, "秋秋", 19,"女");
        Log.d(TAG, "写入数据库完毕.");

        //读数据库
        Log.d(TAG, "第1次读数据库");
        readDatabase(mUserDao);

        //更新数据库
        updateUser(mUserDao);

        //读数据库
        Log.d(TAG, "第2次读数据库");
        readDatabase(mUserDao);

        //删除数据，根据主键id
        deleteUser(mUserDao, 1);

        //读数据库
        Log.d(TAG, "第3次读数据库");
        readDatabase(mUserDao);

        Log.d(TAG, "========================");
        Log.d(TAG, "本轮数据库操作事务全部结束");
        Log.d(TAG, "========================");
    }

    private void readDatabase(UserDao dao) {
        Log.d(TAG, "读数据库...");
        List<User> users = dao.getAllUsers();
        for (User u : users) {
            Log.d(TAG, u.id + "," + u.name + "," + u.age + "," + u.sex);
        }
        Log.d(TAG, "读数据库完毕.");
    }

    private void writeDatabase(UserDao dao, String name, int age,String sex) {
        User user = new User();
        user.name = name;
        user.age = age;
        user.sex=sex;
        dao.insertUser(user);
    }

    private void updateUser(UserDao dao) {
        Log.d(TAG, "更新数据库...");
        User u = new User();
        u.id = 2;
        u.name = "鸣鸣";
        u.age = 18;
        u.sex="男";
        dao.updateUser(u);
        Log.d(TAG, "更新数据库完毕.");
    }

    private void deleteUser(UserDao dao, int id) {
        Log.d(TAG, "删除数据库...");
        User u = new User();
        u.id = id;
        dao.deleteUser(u);
        Log.d(TAG, "删除数据库完毕.");
    }

}