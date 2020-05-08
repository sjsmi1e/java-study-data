package com.fehead.service;

import com.fehead.mapper.ProjectMapper;
import com.fehead.pojo.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ProjectService
 * @Description TODO
 * @Date 2019/1/24 19:55
 * @Created by smile丶
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    public List<ProjectInfo> getAllProject(int conf_id){
        return projectMapper.getAllProject(conf_id);
    }

    public ProjectInfo getPrijectInfoByProjectId(int project_id){
        return projectMapper.getPrijectInfoByProjectId(project_id);
    }

    public void addProjectInfo(ProjectInfo projectInfo){
        projectMapper.addUser(projectInfo);
    }

}
