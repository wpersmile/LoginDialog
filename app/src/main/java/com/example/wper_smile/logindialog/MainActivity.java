package com.example.wper_smile.logindialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示自定义对话框
                showDialog();
            }
        });
    }
    private void showDialog()
    {
        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.login,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("账号登陆");
        builder.setView(view);
        final AlertDialog dialog=builder.create();
        Button lgnow=(Button)view.findViewById(R.id.loginNow);
        final EditText useEdit=(EditText)view.findViewById(R.id.useEdt);
        final EditText passEdit=(EditText)view.findViewById(R.id.passEdt);
        lgnow.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (useEdit.getText().toString().equals("123")
                        &&passEdit.getText().toString().equals("456"))
                {
                    Toast.makeText(MainActivity.this,"验证通过", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

                else
                    Toast.makeText(MainActivity.this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}
