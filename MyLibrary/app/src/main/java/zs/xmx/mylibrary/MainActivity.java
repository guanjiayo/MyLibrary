package zs.xmx.mylibrary;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import zs.xmx.aop.login.LoginAssistant;
import zs.xmx.aop.login.annotation.CheckLogin;
import zs.xmx.aop.login.callback.ILoginCallback;
import zs.xmx.aop.permission.annotation.NeedPermission;
import zs.xmx.aop.permission.annotation.PermissionCanceled;
import zs.xmx.aop.permission.annotation.PermissionDenied;
import zs.xmx.aop.permission.bean.DenyBean;
import zs.xmx.mylibrary.domain.AppInfo;
import zs.xmx.mylibrary.lazy.LazyActivity;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<String> mList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();

    }

    private void initEvent() {
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.activity_main, mList));
        listView.setOnItemClickListener(this);

    }

    private void initData() {
        initLoginState();

        mList = new ArrayList<>();
        mList.add(new AppInfo("LazyViewPager (懒加载)").toString());
        mList.add(new AppInfo("AOP权限库测试").toString());
        mList.add(new AppInfo("AOP集中式登录库测试").toString());
    }

    private void initLoginState() {
        LoginAssistant.getInstance().setLoginCallBack(new ILoginCallback() {
            @Override
            public void unLogin(Context context, int tipType) {
                if (tipType == 0) {
                    Toast.makeText(context, "未登录,请登录", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean isLogin(Context context) {
                //return SP中的登录状态
                return false;
            }
        });
    }

    private void initView() {
        listView = new ListView(this);
        setContentView(listView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.MATCH_PARENT));


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, LazyActivity.class));
                break;
            case 1:
                callMap();
                break;
            case 2:
                isLogined();
                break;
            default:
                break;
        }
    }

    @CheckLogin()
    private void isLogined() {//已经登录过的后续操作
        Toast.makeText(this, "已登录", Toast.LENGTH_SHORT).show();
    }


    /**
     * 申请单个权限
     */
    @NeedPermission({Manifest.permission.ACCESS_FINE_LOCATION})
    public void callMap() {
        Toast.makeText(this, "定位权限通过", Toast.LENGTH_SHORT).show();
    }

    /**
     * 权限被取消
     */
    @PermissionCanceled
    public void dealCancelPermission() {
        Toast.makeText(this, "权限被取消", Toast.LENGTH_SHORT).show();
    }

    /**
     * 权限被拒绝
     */
    @PermissionDenied
    public void dealPermission(DenyBean bean) {
        Toast.makeText(this, bean.getDenyList() + "权限被拒绝", Toast.LENGTH_SHORT).show();
    }

}
