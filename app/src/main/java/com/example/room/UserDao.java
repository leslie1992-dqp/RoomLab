package com.example.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//@Dao注解标明该Java类是一个Android Room中的Dao对象。Android Room中的Dao，可以以接口interface形式定义。
@Dao
public interface UserDao {
    //Android Room中的查询以SQL标准语句定义。

    /**
     * 查询
     *
     * @return
     */
    @Query("SELECT * FROM user_table")
    public List<User> getAllUsers() ;

    /**
     * 添加
     * @param users
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User... users);

    /**
     * 更新
     *
     * @param users
     */
    @Update
    public void updateUser(User... users);

    /**
     * 删除
     *
     * @param users
     */
    @Delete
    public void deleteUser(User... users);


}