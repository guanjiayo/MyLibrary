package com.example;
/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/4/10
 * @本类描述	  Observer的实现类
 * @内容说明   用于接受Subject发送过来的状态
 * @补充内容
 *
 * ---------------------------------     
 * @更新时间   
 * @新增内容   
 *
 */

public class Observer1 implements Observer {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void update(String state) {
        System.out.println("observer1 receive a new magazine Theme:" + state);
    }
}
