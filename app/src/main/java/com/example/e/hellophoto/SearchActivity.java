package com.example.e.hellophoto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnFocusChangeListener;
import android.text.TextWatcher;
import android.text.Editable;
import android.content.Intent;

public class SearchActivity extends AppCompatActivity {

    private EditText edit_ID;
    private Button btn_next,btn_scan;
    private String okdata;
    private TextView monitor_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        EditText edit_ID = (EditText) findViewById(R.id.edit_Id);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_scan = (Button) findViewById(R.id.btn_scan);
        monitor_edit = (TextView) findViewById(R.id.monitor_edit);

        // Button
        btn_scan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    monitor_edit.setText("开始扫描");
                    //edit_ID.setText("");
            }
        });


        // Button
        btn_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isId(okdata))
                {
                    monitor_edit.setText("学号错误！");
                }
                else
                {
                    monitor_edit.setText("学号正确！");
                    Intent intent=new Intent(SearchActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("Name","名字名字很多字");
                    bundle.putString("ID","12345678901");
                    bundle.putString("Status","正常");
                    bundle.putString("Title","作品名字很多字很多字XYZ") ;
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        // Edit Focus Listen
        edit_ID.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // 当hasFocus = true 是获取焦点
                if (!hasFocus) {
                    if (!isId(okdata)) {
                        monitor_edit.setText("请输入正确的学号！");
                    }
                }
            }
        });

        // 对EditText内容的实时监听
        edit_ID.addTextChangedListener(new TextWatcher() {
            // 第二个执行
            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                System.out.println("onTextChanged:" + "start:" + start + "before:" + before + "count:" + count);
            }
            // 第一个执行
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
                System.out.println("beforeTextChanged:" + "start:" + start + "count:" + count + "after:" + after);
            }
            // 第三个执行
            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("afterTextChanged:" + s);

                okdata = s.toString();
                if (isId(s.toString())) {
                    monitor_edit.setText("正确!");
                }else {
                    monitor_edit.setText("请输入正确的学号！");
                }

            }
        });
    };
    /*** 是否为学号Char
     * @param idStr
     * @return
     * */
    public static boolean isId(String idStr) {
        String regex = "^[0-9]{11}$";
        if (idStr == null || "".equals(idStr.trim())) {
            return false;
        } else if (idStr.matches(regex)){
            return true;
        }
        return false;
    };
}
