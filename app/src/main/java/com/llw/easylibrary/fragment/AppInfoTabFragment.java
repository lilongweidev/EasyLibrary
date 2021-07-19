package com.llw.easylibrary.fragment;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.easylibrary.R;
import com.llw.easylibrary.adapter.AppAdapter;
import com.llw.easyutil.EasyAppInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 个人主页TabFragment
 *
 * @author llw
 * @date 2021/4/29 17:17
 */
public class AppInfoTabFragment extends Fragment {

    private String content;
    private RecyclerView rv;
    private List<String> typeList = new ArrayList<>();

    private String[] titleArray = {"全部App", "系统预装", "手动安装"};

    private int appType = 0;//0 全部，1 预装 ，2 手动

    public AppInfoTabFragment(String content) {
        this.content = content;
        for (int i = 0; i < titleArray.length; i++) {
            if (titleArray[i].equals(content)) {
                appType = i;
            }
        }
    }


    @Override
    public View onCreateView(final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_app_info_tab,
                container, false);
        rv = view.findViewById(R.id.rv);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        AppAdapter personTypeAdapter = new AppAdapter(R.layout.item_app_rv, getAppInfoList());
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(personTypeAdapter);
    }

    /**
     * 获取App信息列表
     * @return 列表数据
     */
    private List<EasyAppInfo.AppInfo> getAppInfoList() {
        List<EasyAppInfo.AppInfo> appInfos = new ArrayList<>();
        switch (appType) {
            case 0:
                appInfos = EasyAppInfo.getAppInfoList();
                break;
            case 1:
                appInfos = EasyAppInfo.getAppInfoList(EasyAppInfo.getAllApp(true));
                break;
            case 2:
                appInfos = EasyAppInfo.getAppInfoList(EasyAppInfo.getAllApp(false));
                break;
            default:break;
        }
        return appInfos;
    }
}