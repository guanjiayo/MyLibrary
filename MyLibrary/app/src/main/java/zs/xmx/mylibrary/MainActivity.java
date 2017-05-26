package zs.xmx.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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
        mList = new ArrayList<>();

        mList.add(new AppInfo("LazyViewPager (懒加载)").toString());
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
            default:
                break;
        }
    }
}
