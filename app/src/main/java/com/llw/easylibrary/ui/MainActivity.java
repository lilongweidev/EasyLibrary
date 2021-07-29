package com.llw.easylibrary.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.llw.easylibrary.R;
import com.llw.easylibrary.adapter.FuncAdapter;
import com.llw.easylibrary.bean.Function;

import java.util.List;

/**
 * Main
 *
 * @author llw
 * @date 2021/06/25
 */
public class MainActivity extends BaseActivity {

    //时间
    private long timeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvFunction = findViewById(R.id.rv_function);
        List<Function> functionList = getFunctionList();

        FuncAdapter funcAdapter = new FuncAdapter(R.layout.item_function_rv, functionList);
        rvFunction.setLayoutManager(new GridLayoutManager(this,3));
        funcAdapter.setAnimationEnable(true);
        funcAdapter.setOnItemClickListener((adapter, view, position) -> jumpActivity(position));
        rvFunction.setAdapter(funcAdapter);
    }

    /**
     * 增加一个退出应用的提示
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                Toast.makeText(this, "再按一次退出EasyLibrary", Toast.LENGTH_SHORT).show();
                timeMillis = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}