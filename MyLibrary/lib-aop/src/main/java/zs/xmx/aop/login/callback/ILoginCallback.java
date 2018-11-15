package zs.xmx.aop.login.callback;

import android.content.Context;

/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2018/11/8 11:23
 * @本类描述	  登录状态回调接口
 * @内容说明
 * todo 参考下takephoto库,能不能也能类实现这个接口就能拿到数据
 * todo 其实就是MVP,P层拿到V层接口而已,然后传递数据到接口方法而已
 * todo 不过如果是组件化项目,BaseActivity处理完,不好路由跳转(因为路由常量路径,不在BaseLibrary里面)
 */
public interface ILoginCallback {

    /**
     * 判断是否登录
     *
     * @param context
     */
    boolean isLogin(Context context);

    /**
     * 登录事件接收
     *
     * @param context
     */
    void unLogin(Context context, int tipType);
}
