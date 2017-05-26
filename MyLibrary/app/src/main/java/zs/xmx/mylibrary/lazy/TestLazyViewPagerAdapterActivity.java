package zs.xmx.mylibrary.lazy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import zs.xmx.lazylibrary.LazyViewPager;
import zs.xmx.lazylibrary.LazyViewPagerAdapter;
import zs.xmx.mylibrary.R;

/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2016/11/15 0:37
 * @本类描述	  LazyViewPager
 * @内容说明   ViewPager 懒加载
 * @补充内容   1.导入类库
 *            2.在布局文件添加viewpager控件
 *            3.自定义 CustomLazyViewPagerAdapter 类继承 LazyViewPagerAdapter
 *            4.实现getCount() 和  getItem()
 *
 *@源码地址:https://github.com/lianghanzhen/LazyViewPager
 * ---------------------------------     
 * @新增内容
 *
 */
public class TestLazyViewPagerAdapterActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ((LazyViewPager) findViewById(R.id.lazy_view_pager)).setAdapter(new CustomLazyViewPagerAdapter(this));
    }

    private static class CustomLazyViewPagerAdapter extends LazyViewPagerAdapter {

        private final Context mContext;

        private CustomLazyViewPagerAdapter(Context context) {
            mContext = context;
        }

        /**
         * 通过position得到 lazyItem
         *
         * @param container {@link LazyViewPager}
         * @param position  the position of lazy item
         * @return
         */
        @Override
        public View getItem(ViewGroup container, int position) {
            return buildItemView(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @SuppressLint("DefaultLocale")
        private View buildItemView(int position) {
            TextView view = new TextView(mContext);
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));
            view.setText(String.format("ItemView #%d", position));
            view.setTextColor(Color.BLACK);
            view.setTextSize(18);
            view.setGravity(Gravity.CENTER);
            view.setBackgroundColor(Color.YELLOW);
            return view;
        }

    }
}
