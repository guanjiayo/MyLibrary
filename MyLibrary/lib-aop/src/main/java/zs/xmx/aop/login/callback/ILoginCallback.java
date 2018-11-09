package zs.xmx.aop.login.callback;

import android.content.Context;

/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2018/11/8 11:23
 * @本类描述	  登录状态回调接口
 * @内容说明
 *
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
