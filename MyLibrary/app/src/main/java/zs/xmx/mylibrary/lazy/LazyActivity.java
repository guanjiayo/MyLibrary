package zs.xmx.mylibrary.lazy;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import zs.xmx.mylibrary.R;

/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2016/11/15 0:29
 * @本类描述	  LazyLibrary  Simple 首页
 * @内容说明
 * @补充内容
 *
 * ---------------------------------     
 * @新增内容
 *
 */
public class LazyActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.simple_expandable_list_item_1, Arrays.asList(new
                String[]{"LazyViewPagerAdapter", "LazyFragmentPagerAdapter"})));
        listView.setOnItemClickListener(this);
        setContentView(listView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup
                .LayoutParams.FILL_PARENT));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            startActivity(new Intent(this, TestLazyViewPagerAdapterActivity.class));
        } else {
            startActivity(new Intent(this, TestLazyFragmentPagerAdapterActivity.class));
        }
    }
}