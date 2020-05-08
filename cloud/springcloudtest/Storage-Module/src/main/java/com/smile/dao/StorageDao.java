package com.smile.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 15:02
 */
@Mapper
public interface StorageDao {
    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
