package com.example;
/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/4/10
 * @本类描述	  观察者设计模式(订阅者)
 * @内容说明
 * @补充内容   生活例子: (杂志)
 *
 * ---------------------------------     
 * @更新时间   
 * @新增内容   
 *
 */

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("add a observer : "+observer.getName());
    }

    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("remove a observer : "+observer.getName());
    }

    public void notifyObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

}
