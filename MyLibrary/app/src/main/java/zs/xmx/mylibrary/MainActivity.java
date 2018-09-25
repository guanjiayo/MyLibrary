package zs.xmx.mylibrary;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zs.xmx.mylibrary.domain.AppInfo;
import zs.xmx.mylibrary.lazy.LazyActivity;
import zs.xmx.permission.annotation.NeedPermission;
import zs.xmx.permission.annotation.PermissionCanceled;
import zs.xmx.permission.annotation.PermissionDenied;
import zs.xmx.permission.bean.DenyBean;

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
        mList = new ArrayList<>();

        mList.add(new AppInfo("LazyViewPager (懒加载)").toString());
        mList.add(new AppInfo("AOP权限库测试").toString());
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
            default:
                break;
        }
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
        Toast.makeText(this, bean.getDenyList()+"权限被拒绝", Toast.LENGTH_SHORT).show();
    }

}
