package com.example;
/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/4/10
 * @本类描述
 * @内容说明
 * @补充内容
 *
 * ---------------------------------     
 * @更新时间   
 * @新增内容   
 *
 */

public class Observer2 implements Observer {
    public Observer2(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public void update(String state) {
        System.out.println(this.name+" receive a new magazine Theme:" + state);
    }


}
