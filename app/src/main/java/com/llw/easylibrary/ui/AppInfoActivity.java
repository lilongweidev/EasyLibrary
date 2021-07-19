package com.llw.easylibrary.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.llw.easylibrary.R;
import com.llw.easylibrary.adapter.AppAdapter;
import com.llw.easylibrary.adapter.AppInfoFragmentAdapter;
import com.llw.easylibrary.fragment.AppInfoTabFragment;
import com.llw.easyutil.EasyAppInfo;

import java.util.ArrayList;
import java.util.Locale;

/**
 * EasyAppInfo Used
 *
 * @author llw
 * @date 2021/7/15 20:03
 */
public class AppInfoActivity extends BaseActivity {

    public static final String TAG = AppInfoActivity.class.getSimpleName();
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        initView();

    }

    /**
     * 初始化
     */
    private void initView() {
//        back();
//        setPageTitle(4);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        toolbar.inflateMenu(R.menu.menu_app_info);
        setContent(R.id.tv_package_name, 0);
        setContent(R.id.tv_version_code, 1);
        setContent(R.id.tv_version_name, 2);
        setContent(R.id.tv_install_first_start, 3);
        setContent(R.id.tv_today_first_start, 4);

        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        appBarLayout = findViewById(R.id.appbar_layout);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        //伸缩偏移量监听
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {//收缩时
                    collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);
                    collapsingToolbarLayout.setTitle("App信息");
                    isShow = true;
                } else if (isShow) {//展开时
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });

        final ArrayList<Fragment> fragments = new ArrayList<>();
        final ArrayList<String> tabName = new ArrayList<>();

        String[] titleArray = {"全部App", "系统预装", "手动安装"};

        for (int i = 0; i < titleArray.length; i++) {
            fragments.add(new AppInfoTabFragment(titleArray[i]));
            tabName.add(titleArray[i]);
        }
        AppInfoFragmentAdapter fragTabAdapter = new AppInfoFragmentAdapter(getSupportFragmentManager(), fragments,
                tabName);
        viewPager.setAdapter(fragTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    /**
     * 设置列表内容
     * @param resId 控件id
     * @param type 内容类型
     */
    private void setContent(int resId, int type) {
        TextView textView = (TextView) findViewById(resId);
        switch (type) {
            case 0:
                textView.setText(String.format("App包名：%s", EasyAppInfo.getPackageName()));
                break;
            case 1:
                textView.setText(String.format(Locale.getDefault(), "App版本号：%d", EasyAppInfo.getVersionCode()));
                break;
            case 2:
                textView.setText(String.format("App版本名：%s", EasyAppInfo.getVersionName()));
                break;
            case 3:
                textView.setText(String.format("App首次安装运行？%s", EasyAppInfo.isFirstStartApp()));
                break;
            case 4:
                textView.setText(String.format("今天第一次运行？%s", EasyAppInfo.isTodayFirstStartApp()));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_info, menu);
        return true;
    }




}