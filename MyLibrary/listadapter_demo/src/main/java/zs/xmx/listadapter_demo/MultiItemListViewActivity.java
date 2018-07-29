package zs.xmx.listadapter_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import zs.xmx.adapter.abslistview.CommonAdapter;

import zs.xmx.listadapter_demo.adapter.lv.ChatAdapter;
import zs.xmx.listadapter_demo.bean.ChatMessage;


public class MultiItemListViewActivity extends AppCompatActivity {

    private ListView      mListView;
    private CommonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        mListView.setAdapter(new ChatAdapter(this, ChatMessage.MOCK_DATAS));

    }

}
