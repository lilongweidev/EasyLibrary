package com.llw.easylibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.llw.easylibrary.R;
import com.llw.easyutil.EasySP;

import static com.llw.easyutil.EasyToast.show;

/**
 * EasySP Used
 *
 * @author llw
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private TextView tvTitle;
    private EditText etInt,etString,etBoolean,etFloat;

    public static final String INT_DATA = "intData";
    public static final String STRING_DATA = "stringData";
    public static final String BOOLEAN_DATA = "booleanData";
    public static final String FLOAT_DATA = "floatData";
    public static final String DOUBLE_DATA = "doubleData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("本地缓存使用");
        etInt = findViewById(R.id.et_int);
        etString = findViewById(R.id.et_string);
        etBoolean = findViewById(R.id.et_boolean);
        etFloat = findViewById(R.id.et_float);


        findViewById(R.id.btn_int_set).setOnClickListener(v -> {
            if(etInt.getText().toString().trim().isEmpty()){
                show("请输入数值");return;
            }
            int intResult = Integer.parseInt(etInt.getText().toString().trim());
            EasySP.putInt(INT_DATA, intResult);
            etInt.setText("");
            show("保存成功");
        });
        findViewById(R.id.btn_int_get).setOnClickListener(v -> {
            String intResult = String.valueOf(EasySP.getInt(INT_DATA, 0));
            etInt.setText(intResult);
        });

        findViewById(R.id.btn_string_set).setOnClickListener(v -> {
            if(etInt.getText().toString().trim().isEmpty()){
                show("请输入数值");return;
            }
            int intResult = Integer.parseInt(etInt.getText().toString().trim());
            EasySP.putInt(INT_DATA, intResult);
            etInt.setText("");
            show("保存成功");
        });
        findViewById(R.id.btn_string_get).setOnClickListener(v -> {
            String intResult = String.valueOf(EasySP.getInt(INT_DATA, 0));
            etInt.setText(intResult);
        });



    }
}