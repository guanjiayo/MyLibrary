package zs.xmx.adapter.abslistview;

import android.content.Context;

import java.util.List;

import zs.xmx.adapter.abslistview.base.ItemViewDelegate;
/*
 * @创建者     默小铭
 * @博客       http://blog.csdn.net/u012792686
 * @创建时间   2016/10/26 21:51
 * @本类描述	  通用适配器
 * @内容说明
 * ---------------------------------------------
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T>
{

    public CommonAdapter(Context context, final int layoutId, List<T> datas)
    {
        super(context, datas);

        addItemViewDelegate(new ItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position)
            {
                return true;
            }
            /**
             * 分析得知需要Item,holder,position
             *
             * @param holder
             * @param item
             * @param position
             */
            @Override
            public void convert(ViewHolder holder, T item, int position)
            {
                CommonAdapter.this.convert(holder, item, position);
            }
        });
    }

    protected abstract void convert(ViewHolder viewHolder, T item, int position);

}
