package zs.xmx.mylibrary.lazy;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zs.xmx.lazylibrary.LazyFragmentPagerAdapter;
import zs.xmx.lazylibrary.LazyViewPager;
import zs.xmx.mylibrary.R;

import static android.view.ViewGroup.LayoutParams.*;


/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2016/11/15 0:37
 * @本类描述	  Fragment 懒加载
 * @内容说明
 * @补充内容  1.导入类库
 *           2.在布局文件添加viewpager控件
 *           3.自定义 CustomLazyFragmentPagerAdapter 类继承 LazyFragmentPagerAdapter
 *           4.实现getCount() 和  getItem() {把position传给自定义CustomFragment}
 *           5.自定义CustomFragment 继承 Fragment 实现 LazyFragmentPagerAdapter.Laziable 接口
 *           6.实现onCreateView 方法
 *
 * @源码地址:https://github.com/lianghanzhen/LazyViewPager
 * ---------------------------------     
 * @新增内容
 *
 */
public class TestLazyFragmentPagerAdapterActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ((LazyViewPager) findViewById(R.id.lazy_view_pager)).setAdapter(new CustomLazyFragmentPagerAdapter
                (getSupportFragmentManager()));
    }

    private static class CustomLazyFragmentPagerAdapter extends LazyFragmentPagerAdapter {

        private CustomLazyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(ViewGroup container, int position) {
            return CustomFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 6;
        }

    }

    public static class CustomFragment extends Fragment implements LazyFragmentPagerAdapter.Laziable {

        private static final String KEY_POSITION = "position" ;

        private static CustomFragment newInstance(int position) {
            CustomFragment customFragment = new CustomFragment();
            Bundle args = new Bundle(1);
            args.putInt(KEY_POSITION, position);
            customFragment.setArguments(args);
            return customFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return buildItemView(getArguments().getInt(KEY_POSITION));
        }

        @SuppressLint("DefaultLocale")
        private View buildItemView(int position) {
            TextView view = new TextView(getActivity());
            view.setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
            view.setText(String.format("ItemFragment #%d", position));
            view.setTextColor(Color.BLACK);
            view.setTextSize(18);
            view.setGravity(Gravity.CENTER);
            view.setBackgroundColor(Color.GREEN);
            return view;
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.e("lazy", "onStart: ");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.e("lazy", "onPause: ");
        }
    }
}
