package com.example.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    //表中的主键，可根据该主键进行数据库的基本增删改查等等这些操作
    //设置autoGenerate = true后，该主键将自增长
    @PrimaryKey(autoGenerate = true)
    public int id;

    //@ColumnInfo注解后面跟着的name，标明定义的Java变量将作为表中的一列
    @ColumnInfo(name="User_name")
    public String name;

    @ColumnInfo(name="User_age")
    public int age;

    @ColumnInfo(name="User_sex")
    public String sex;
}
