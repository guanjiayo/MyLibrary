package zs.xmx.listadapter_demo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import zs.xmx.adapter.abslistview.CommonAdapter;
import zs.xmx.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://github.com/hongyangAndroid/baseAdapter 研究总结
 */
public class MainActivity extends AppCompatActivity {
    private List<String> mDatas = new ArrayList<>(Arrays.asList("MultiItem ListView",
            "RecyclerView",
            "MultiItem RecyclerView",
            "RecycleView Manager"));
    private ListView mListView;

    private View mEmptyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = ((ListView) findViewById(R.id.id_listview_list));
        mEmptyView = findViewById(R.id.id_empty_view);
        mListView.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, mDatas) {
            @Override
            public void convert(ViewHolder holder, String o, int pos) {
                holder.setText(R.id.id_item_list_title, o);
            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView) {
                super.onViewHolderCreated(holder, itemView);
            }
        });

        mListView.setEmptyView(mEmptyView);
        //        TextView t1 = new TextView(this);
        //        t1.setText("Header 1");
        //        TextView t2 = new TextView(this);
        //        t2.setText("Header 2");
        //        mListView.addHeaderView(t1);
        //        mListView.addHeaderView(t2);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                    default:
                        intent = new Intent(MainActivity.this, MultiItemListViewActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, MultiItemRvActivity.class);
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "参考: github: https://github.com/DingMouRen", Toast.LENGTH_LONG).show();
                        break;

                }
                if (intent != null)
                    startActivity(intent);
            }
        });
    }


}
