package com.fehead.service;

import com.fehead.mapper.FileInfoMapper;
import com.fehead.pojo.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname FileService
 * @Description TODO
 * @Date 2019/2/1 0001 下午 17:45
 * @Created by Administrator
 */
@Service
public class FileService {
    @Autowired
    public FileInfoMapper fileInfoMapper;

    public void addFileInfo(FileInfo file){
        fileInfoMapper.addFileInfo(file);
    }


    public FileInfo getFileInfoByName(String name){return fileInfoMapper.getFileInfoByName(name);}

    public FileInfo getFileInfoById(int id){return fileInfoMapper.getFileInfoById(id);}
}
