package star.yx.tabview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import star.yx.test.BaseRecyclerViewAdapter;
import star.yx.test.BaseSwipeRefreshLayout;

/**
 * Created by yx on 16/4/3.
 */
public class WechatFragment extends BaseFragment implements ITabClickListener {
    private BaseSwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mListView;
    private LinearLayoutManager layoutManager;
    WechatAdapter adapter;

    @Override
    public void fetchData() {
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_layout, container, false);
        mSwipeRefreshLayout = (BaseSwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mListView = (RecyclerView) view.findViewById(R.id.list);
        this.layoutManager = new LinearLayoutManager(this.getContext());
        this.layoutManager.setOrientation(1);
        this.mListView.setLayoutManager(this.layoutManager);
        adapter = new WechatAdapter();
        mListView.setAdapter(adapter);
        return view;
    }


    private void getData() {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    mSwipeRefreshLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

    @Override
    public void onMenuItemClick() {

    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }


    class WechatAdapter extends BaseRecyclerViewAdapter {
        public WechatAdapter() {
            super(R.layout.contact_item);
        }

        @Override
        public void onBindViewData(ViewHolder var1, int var2) {
            var1.getTextView(R.id.contact).setText("你有新消息");
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }
}
