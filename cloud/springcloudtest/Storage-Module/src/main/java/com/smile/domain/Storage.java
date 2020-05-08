package com.smile.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author smi1e
 * @description
 * @Date 2020/5/1 15:03
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    private Long id;
    // 产品id
    private Long productId;
    //总库存
    private Integer total;
    //已用库存
    private Integer used;
    //剩余库存
    private Integer residue;
}
