package com.example;

/**
 *
 */
public class MyClass {
    public static void main(String[] args) {

        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2("hanmeimei");
        Observer observer3 = new Observer2("lilei");
        Observer observer4 = new Observer2("fengjie");
        PalyboySubject palyboySubject = new PalyboySubject();
        // palyboySubject.attach(observer1);

        //attach在Android 中on,我们可以作为setListener
        palyboySubject.attach(observer2);
        palyboySubject.attach(observer3);

        //change在Android 中,我们可以作为Button的点击事件
        palyboySubject.change("The secret of Victoria");

        palyboySubject.detach(observer4);
        palyboySubject.change("on my god");
    }
}
