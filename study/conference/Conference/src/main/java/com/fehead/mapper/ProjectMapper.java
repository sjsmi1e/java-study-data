package com.fehead.mapper;

import com.fehead.pojo.ProjectInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname ProjectMapper
 * @Description TODO
 * @Date 2019/1/24 19:52
 * @Created by smile丶
 */

@Repository
public interface ProjectMapper {
    /**
     * 通过会议ID查询所有参赛项目信息
     */

    @Select("select * from project_info where conf_id=#{conf_id}")
    @Results({
        @Result(id = true,column = "project_id",property = "projectId"),
            @Result(column = "conf_id",property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select="com.fehead.mapper.UserMapper.selectUserById")),
            @Result(column = "file_id",property = "fileId"),
            @Result(column = "project_name",property = "projectName"),
            @Result(column = "project_avg",property = "projectAvg"),
            @Result(column = "project_sum",property = "projectSum"),
            @Result(column = "project_desc",property = "projectDesc"),
    }
    )
    public List<ProjectInfo> getAllProject(@Param("conf_id") int conf_id);

    /**
     * 通过会议ID查询所有参赛项目信息
     */

    @Select("select * from project_info where conf_id=#{conf_id}")
    @Results({
            @Result(id = true,column = "project_id",property = "projectId"),
            @Result(column = "conf_id",property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select="com.fehead.mapper.UserMapper.selectUserById")),
            @Result(column = "file_id",property = "fileId"),
            @Result(column = "project_name",property = "projectName"),
            @Result(column = "project_avg",property = "projectAvg"),
            @Result(column = "project_sum",property = "projectSum"),
            @Result(column = "project_desc",property = "projectDesc"),
    }
    )
    public List<ProjectInfo> getAllProjectByConfId(@Param("conf_id") int conf_id);


    /**
     * 通过project_id查询详细信息
     */

    @Select("select * from project_info where project_id=#{project_id}")
    @Results({
            @Result(id = true,column = "project_id",property = "projectId"),
            @Result(column = "conf_id",property = "confId"),
            @Result(column = "user_id", property = "userId",one = @One(select="com.fehead.mapper.UserMapper.selectUserById")),
            @Result(column = "file_id",property = "fileId"),
            @Result(column = "project_name",property = "projectName"),
            @Result(column = "project_avg",property = "projectAvg"),
            @Result(column = "project_sum",property = "projectSum"),
            @Result(column = "project_desc",property = "projectDesc"),
    })
    public ProjectInfo getPrijectInfoByProjectId(@Param("project_id") int project_id);

    /**
     * 添加项目信息
     */
    @Insert("insert into project_info(conf_id,user_id,file_id,project_name,project_avg,project_sum,project_desc)" +
            "values(#{project.confId},#{project.userId.userId},#{project.fileId}," +
            "#{project.projectName},#{project.projectAvg},#{project.projectSum},#{project.projectDesc})")
    @Options(useGeneratedKeys=true, keyProperty="project.projectId",keyColumn = "project_id")
    public void addUser(@Param("project") ProjectInfo porject);
    /**
     * 根据用户id删除项目信息
     */
    @Delete("delete from project_info where user_id = #{id}")
    public void deleteByUserId(@Param("id") int id);

    /**
     * 根据项目id删除项目信息
     */

    /**
     * 更新项目信息
     */
//    @UpdateProvider(type=UserInfoDynaSqlProvider.class,method="updateProjectinfo")
//    public void updateUser(ProjectInfo projectInfo);


    @Delete("delete from user_info where project_id = #{id}")
    public void deleteById(@Param("id") int id);
    /**
     * 通过项目名删除项目信息
     */
    @Delete("delete from user_info where  = #{project_name= #{name}")
    public void deleteUserById(@Param("name") String name);
}
