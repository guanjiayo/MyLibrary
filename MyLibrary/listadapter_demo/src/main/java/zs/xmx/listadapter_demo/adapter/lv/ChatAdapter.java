package zs.xmx.listadapter_demo.adapter.lv;

import android.content.Context;

import java.util.List;

import zs.xmx.adapter.abslistview.MultiItemTypeAdapter;
import zs.xmx.listadapter_demo.bean.ChatMessage;


/**
 * Created by zhy on 15/9/4.
 */
public class ChatAdapter extends MultiItemTypeAdapter<ChatMessage> {
    public ChatAdapter(Context context, List<ChatMessage> datas) {
        super(context, datas);
        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }

}
