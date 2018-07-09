package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.User;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserDao {
    @Insert("INSERT INTO xiaomi_user ( userId, userName, password, telephoneNumber, " +
            "createTime, img, hobby, address, sign) " +
            "VALUES(#{record.userId}, #{record.userName}, #{record.password}, " +
            "#{record.telephoneNumber}, #{record.createTime}, #{record.img}, " +
            "#{record.hobby}, #{record.address}, #{record.sign})")
    int insert(@Param("record") User record);

    @Select("SELECT * FROM xiaomi_user")
    List<User> selectAll();

    @Select("SELECT * FROM xiaomi_user WHERE userId = #{userId}")
    User selectByPrimaryKey(String userId);

    @Select("SELECT * FROM xiaomi_user WHERE userName = #{userName}")
    User selectByUserName(String userName);

    @Select("SELECT createTime from xiaomi_user order by createTime ")
    List<Timestamp> selectTime();

    @Update("UPDATE xiaomi_user " +
            " SET userName = #{record.userName}," +
            " password = #{record.password}," +
            " telephoneNumber = #{record.telephoneNumber}," +
            " createTime = #{record.createTime}," +
            " img = #{record.img}," +
            " hobby = #{record.hobby}," +
            " address = #{record.address}," +
            " sign = #{record.sign}" +
            " WHERE userId = #{record.userId}")
    int update(@Param("record") User record);

    @Delete("DELETE FROM xiaomi_user WHERE userId = #{userId}")
    int delete(String userId);
}
