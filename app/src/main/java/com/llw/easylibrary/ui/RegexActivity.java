package com.llw.easylibrary.ui;

import android.os.Bundle;
import android.widget.EditText;

import com.llw.easylibrary.R;
import com.llw.easyutil.EasyRegex;

import static com.llw.easyutil.EasyToast.show;

/**
 * EasyRegex Used
 *
 * @author llw
 * @date 2021/07/12
 */
public class RegexActivity extends BaseActivity {

    private EditText etPhone, etTelephone, etIdCard18, etQq, etEmail, etPostalCode,
            etDomainName, etUrl, etName, etAccount, etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);
        initView();
    }

    /**
     * 页面初始化
     */
    private void initView() {
        back();
        setPageTitle(2);
        etPhone = findViewById(R.id.et_phone);
        etTelephone = findViewById(R.id.et_telephone);
        etIdCard18 = findViewById(R.id.et_id_card_18);
        etQq = findViewById(R.id.et_qq);
        etEmail = findViewById(R.id.et_email);
        etPostalCode = findViewById(R.id.et_postal_code);
        etDomainName = findViewById(R.id.et_domain_name);
        etUrl = findViewById(R.id.et_url);
        etName = findViewById(R.id.et_name);
        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        //手机号码检查
        findViewById(R.id.btn_phone_check).setOnClickListener(v -> checkContent(etPhone, 0));
        //电话号码检查
        findViewById(R.id.btn_telephone_check).setOnClickListener(v -> checkContent(etTelephone, 1));
        //身份证号检查
        findViewById(R.id.btn_id_card_check).setOnClickListener(v -> checkContent(etIdCard18, 2));
        //QQ检查
        findViewById(R.id.btn_qq_check).setOnClickListener(v -> checkContent(etQq, 3));
        //邮箱检查
        findViewById(R.id.btn_email_check).setOnClickListener(v -> checkContent(etEmail, 4));
        //邮政编码检查
        findViewById(R.id.btn_postal_code_check).setOnClickListener(v -> checkContent(etPostalCode, 5));
        //域名检查
        findViewById(R.id.btn_domain_name_check).setOnClickListener(v -> checkContent(etDomainName, 6));
        //URL检查
        findViewById(R.id.btn_url_check).setOnClickListener(v -> checkContent(etUrl, 7));
        //姓名检查
        findViewById(R.id.btn_name_check).setOnClickListener(v -> checkContent(etName, 8));
        //账号检查
        findViewById(R.id.btn_account_check).setOnClickListener(v -> checkContent(etAccount, 9));
        //密码检查
        findViewById(R.id.btn_pwd_check).setOnClickListener(v -> checkContent(etPwd, 10));
    }

    /**
     * 检查输入内容
     *
     * @param etContent 输入控件
     * @param type      检查类型
     */
    private void checkContent(EditText etContent, int type) {
        String content = etContent.getText().toString().trim();
        switch (type) {
            case 0://手机号码检查
                show(content.isEmpty() ? "请输入手机号码" : EasyRegex.isPhoneNumberExact(content) + "");
                break;
            case 1://电话号码检查
                show(content.isEmpty() ? "请输入电话号码" : EasyRegex.isTelephoneNumber(content) + "");
                break;
            case 2://身份证检查
                show(content.isEmpty() ? "请输入18位身份证号" : EasyRegex.isIdCard18(content) + "");
                break;
            case 3://QQ检查
                show(content.isEmpty() ? "请输入QQ" : EasyRegex.isQQ(content) + "");
                break;
            case 4://邮箱检查
                show(content.isEmpty() ? "请输入邮箱" : EasyRegex.isEmail(content) + "");
                break;
            case 5://邮政编码检查
                show(content.isEmpty() ? "请输入邮政编码" : EasyRegex.isPostalCode(content) + "");
                break;
            case 6://域名检查
                show(content.isEmpty() ? "请输入域名" : EasyRegex.isDomainName(content) + "");
                break;
            case 7://URL检查
                show(content.isEmpty() ? "请输入URL" : EasyRegex.isUrl(content) + "");
                break;
            case 8://姓名检查
                show(content.isEmpty() ? "请输入姓名" : EasyRegex.isName(content) + "");
                break;
            case 9://账号检查  （字母开头，允许5-16字节，允许字母数字下划线）
                show(content.isEmpty() ? "请输入账号" : EasyRegex.isAccount(content) + "");
                break;
            case 10://密码检查 （以字母开头，长度在6~18之间，只能包含字母、数字和下划线）
                show(content.isEmpty() ? "请输入密码" : EasyRegex.isPwd(content) + "");
                break;
            default:break;
        }
    }
}