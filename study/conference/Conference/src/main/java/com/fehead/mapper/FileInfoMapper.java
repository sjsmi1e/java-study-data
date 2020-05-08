package com.fehead.mapper;

/**
 * @Classname FileInfoMapper
 * @Description TODO
 * @Date 2019/1/22 0022 上午 10:23
 * @Created by Administrator
 */

import com.fehead.pojo.FileInfo;
import com.fehead.pojo.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*private int fileId;
private int confId;
private UserInfo userId;
private String filePath;
private String fileName;
/**
 * File数据库映射类
 * @author lmwis on create 2019-01-19
 */
@Repository
public interface FileInfoMapper {
    @Select("select * from conference_user_file_info")
    @Results({
            @Result(id = true, column = "file_id", property = "fileId"),
            @Result(column = "conf_id", property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select = "com,fehead.mapper.UserMapper.selectUserById"),javaType = UserInfo.class),
            @Result(column = "file_path", property = "filePath"),
            @Result(column = "file_name", property = "fileName")
    })
    public List<FileInfo> getFileInfo();

    @Select("select * from conference_user_file_info where file_id = #{id}")
    @Results({
            @Result(id = true, column = "file_id", property = "fileId"),
            @Result(column = "conf_id", property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select = "com,fehead.mapper.UserMapper.selectUserById"),javaType = UserInfo.class),
            @Result(column = "file_path", property = "filePath"),
            @Result(column = "file_name", property = "fileName")
    })
    public FileInfo getFileInfoById(@Param("id") int id);

    @Select("select * from conference_user_file_info where file_name =#{name}")
    @Results({
            @Result(id = true, column = "file_id", property = "fileId"),
            @Result(column = "conf_id", property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select = "com,fehead.mapper.UserMapper.selectUserById"),javaType = UserInfo.class),
            @Result(column = "file_path", property = "filePath"),
            @Result(column = "file_name", property = "fileName")
    })
    public FileInfo getFileInfoByName(@Param("name") String name);

    @SelectKey(keyColumn = "file_id", statement = "select last_insert_id()", keyProperty = "fileId", resultType = int.class, before = true)
    @Insert("insert into conference_user_file_info(file_id,conf_id,user_id,file_path,file_name) " +
            " values(#{file.fileId},#{file.confId},#{file.userId.userId},#{file.filePath}," +
            "#{file.fileName})")
    public void addFileInfo(@Param("file") FileInfo file);


    @Update("update conference_user_file_info set conf_id=#{file.fileconfId},user_id=#{file.userId.userId}," +
            "file_path=#{file.filePath},file_name=#{file.fileName}"+ "where file_id = #{id}")
    public void updateFileInfo(@Param("id") int id);

    @Delete("delete from confernce_user_file_info where file_id = #{id}")
    public void deleteFileInfoById(@Param("id") int id);

    @Delete("delete from confernce_user_file_info where file_name = #{name}")
    public void deleteFileInfoByName(@Param("name") String name);

}
