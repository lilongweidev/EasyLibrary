package com.llw.easylibrary.adapter;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.button.MaterialButton;
import com.llw.easylibrary.R;
import com.llw.easylibrary.bean.Function;

import java.util.List;

/**
 * @author llw
 * @description FuncAdapter
 * @date 2021/7/22 20:08
 */
public class FuncAdapter extends BaseQuickAdapter<Function, BaseViewHolder> {

    public FuncAdapter(int layoutResId, List<Function> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Function function) {
        MaterialButton btnFunction = holder.getView(R.id.btn_function);
        btnFunction.setCompoundDrawables(null, drawableTop(function.getDrawable()),null,null);
        btnFunction.setText(function.getName());
        holder.getAdapterPosition();
    }

    private Drawable drawableTop(int id) {
        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getContext().getDrawable(id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }
}
