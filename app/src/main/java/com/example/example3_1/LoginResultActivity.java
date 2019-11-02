package com.example.example3_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginResultActivity extends AppCompatActivity {

    TextView TextView_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView_get = findViewById(R.id.TextView_get);

        Intent intent = getIntent();

        //Bundle을 가져오는 getExtras를 이용해야 한다.
        //보낼 때 putExtra들을 통해 묶어 보냈으므로, 꺼낼 때는 해당 Bundle에서 따로 꺼내야 한다.
        Bundle bundle = intent.getExtras();
        String email = bundle.getString("email");
        String password = bundle.getString("password");

        TextView_get.setText(email + " / " + password);
    }
}
