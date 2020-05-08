package com.fehead.controller.viewobject;

/**
 * @author lmwis on 2019-01-30 21:36
 */
public class UserVO {
    private Integer id;
    private String name;
    private Byte gendar;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGendar() {
        return gendar;
    }

    public void setGendar(Byte gendar) {
        this.gendar = gendar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
