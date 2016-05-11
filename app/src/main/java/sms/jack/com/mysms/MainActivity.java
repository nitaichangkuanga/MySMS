package sms.jack.com.mysms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_num;
    private EditText et_content;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num = (EditText) findViewById(R.id.et_num);
        et_content = (EditText) findViewById(R.id.et_content);
        button = (Button) findViewById(R.id.b);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String num = et_num.getText().toString().trim();
        String content = et_content.getText().toString().trim();
        if ("".equals(num) || "".equals(content)) {
            Toast.makeText(this, "号码或者短信内容为空", Toast.LENGTH_SHORT).show();
            return;
        }
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num,null,content,null,null);
        et_num.setText("");
        et_content.setText("");
        Toast.makeText(this,"发送成功",Toast.LENGTH_SHORT).show();
    }
}
