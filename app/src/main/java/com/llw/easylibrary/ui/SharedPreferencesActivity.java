package com.llw.easylibrary.ui;

import android.os.Bundle;
import android.widget.EditText;

import com.llw.easylibrary.R;
import com.llw.easyutil.EasySP;

import static com.llw.easyutil.EasyToast.show;

/**
 * EasySP Used
 *
 * @author llw
 * @date 2021/07/09
 */
public class SharedPreferencesActivity extends BaseActivity {

    private EditText etInt, etString, etBoolean, etFloat, etLong;

    public static final String INT_DATA = "intData";
    public static final String STRING_DATA = "stringData";
    public static final String BOOLEAN_DATA = "booleanData";
    public static final String FLOAT_DATA = "floatData";
    public static final String LONG_DATA = "longData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        back();
        setPageTitle(1);
        etInt = findViewById(R.id.et_int);
        etString = findViewById(R.id.et_string);
        etBoolean = findViewById(R.id.et_boolean);
        etFloat = findViewById(R.id.et_float);
        etLong = findViewById(R.id.et_long);
        //int
        findViewById(R.id.btn_int_set).setOnClickListener(v -> setData(etInt, 0));
        findViewById(R.id.btn_int_get).setOnClickListener(v -> getData(etInt, 0));
        //string
        findViewById(R.id.btn_string_set).setOnClickListener(v -> setData(etString, 1));
        findViewById(R.id.btn_string_get).setOnClickListener(v -> getData(etString, 1));
        //boolean
        findViewById(R.id.btn_boolean_set).setOnClickListener(v -> setData(etBoolean, 2));
        findViewById(R.id.btn_boolean_get).setOnClickListener(v -> getData(etBoolean, 2));
        //float
        findViewById(R.id.btn_float_set).setOnClickListener(v -> setData(etFloat, 3));
        findViewById(R.id.btn_float_get).setOnClickListener(v -> getData(etFloat, 3));
        //long
        findViewById(R.id.btn_long_set).setOnClickListener(v -> setData(etLong, 4));
        findViewById(R.id.btn_long_get).setOnClickListener(v -> getData(etLong, 4));

    }

    private void setData(EditText etData, int type) {
        String result = etData.getText().toString().trim();
        if (result.isEmpty()) {
            show("请输入数值");
            return;
        }
        switch (type) {
            case 0:
                EasySP.putInt(INT_DATA, Integer.parseInt(result));
                break;
            case 1:
                EasySP.putString(STRING_DATA, result);
                break;
            case 2:
                EasySP.putBoolean(BOOLEAN_DATA, Integer.parseInt(result) < 10);
                break;
            case 3:
                EasySP.putFloat(FLOAT_DATA, Float.parseFloat(result));
                break;
            case 4:
                EasySP.putLong(LONG_DATA,Long.parseLong(result));
                break;
            default:
                break;
        }
        etData.setText("");
        show("保存成功");
    }

    /**
     * 获取缓存值
     *
     * @param etResult 需要设置到的输入框
     * @param type     数据类型
     */
    private void getData(EditText etResult, int type) {
        String data = null;
        switch (type) {
            case 0:
                data = String.valueOf(EasySP.getInt(INT_DATA, 0));
                break;
            case 1:
                data = EasySP.getString(STRING_DATA, null);
                break;
            case 2:
                show(EasySP.getBoolean(BOOLEAN_DATA, false) + "");
                break;
            case 3:
                data = String.valueOf(EasySP.getFloat(FLOAT_DATA, 0.0f));
                break;
            case 4:
                data = String.valueOf(EasySP.getLong(LONG_DATA, 1234567890));
                break;
            default:
                break;
        }
        etResult.setText(data);
        //光标在文字后面
        etResult.setSelection(etResult.getText().length());
    }
}