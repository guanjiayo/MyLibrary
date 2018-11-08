package zs.xmx.aop.login;


import zs.xmx.aop.login.callback.ILoginCallback;

/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2018/11/8 11:48
 * @本类描述	  登录拦截实现类
 * @内容说明   这个类放在全局Application里面
 * @使用说明   1.LoginAssistant.getInstance().setLoginCallBack(new ILoginCallback() {
            @Override
            public void loginFail(Context context, int userDefine) {
                if (userDefine == 0) { //默认,可以自己传参
                    Toast.makeText(context, "未登录,请登录", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean isLogin(Context context) {
                //return SP中的登录状态
                return false;
            }
        });

        2.然后在需要在检测登录状态的方法上使用@CheckLogin()注解
 */
public class LoginAssistant {
    private static LoginAssistant instance;

    public static LoginAssistant getInstance() {
        if (instance == null) {
            synchronized (LoginAssistant.class) {
                if (instance == null) {
                    instance = new LoginAssistant();
                }
            }
        }
        return instance;
    }

    private ILoginCallback mCallback;

    public ILoginCallback getLoginCallBack() {
        return mCallback;
    }

    public void setLoginCallBack(ILoginCallback callback) {
        this.mCallback = callback;
    }
}
