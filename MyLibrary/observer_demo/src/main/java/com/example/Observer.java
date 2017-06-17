package com.example;
/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/4/10
 * @本类描述	  观察者设计模式(订阅者)
 * @内容说明
 * @补充内容   生活例子: 杂志读者
 *
 * ---------------------------------     
 * @更新时间   
 * @新增内容   
 *
 */

public interface Observer {
    String getName(); //Observer2 测试用

    void update(String state);
}
