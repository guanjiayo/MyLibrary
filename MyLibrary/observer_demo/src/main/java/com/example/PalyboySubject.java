package com.example;
/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2017/4/10
 * @本类描述	  Subject 的子类
 * @内容说明   使用父类Subject的notifyObservers()方法发送消息
 * @补充内容
 *
 * ---------------------------------     
 * @更新时间   
 * @新增内容   
 *
 */

public class PalyboySubject extends Subject {
    /**
     * 改变状态
     * <p>
     * 看图其实就是使用父类notifyObservers()方法
     *
     * @param state
     */
    public void change(String state) {
        notifyObservers(state);
    }
}
