package com.llw.easylibrary.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.llw.easylibrary.R;
import com.llw.easyutil.EasyAppInfo;

import java.util.List;

/**
 * @author llw
 * @description AppAdapter
 * @date 2021/7/16 19:40
 */
public class AppAdapter extends BaseQuickAdapter<EasyAppInfo.AppInfo, BaseViewHolder> {

    public AppAdapter(int layoutResId, List<EasyAppInfo.AppInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EasyAppInfo.AppInfo item) {
        helper.setText(R.id.tv_app_name, item.getAppName())
                .setImageDrawable(R.id.iv_app_icon, item.getAppIcon());
    }
}
