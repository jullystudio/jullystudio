package com.example.example3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //컴포넌트를 입력하고, 해당 컴포넌트의 아이디들을 나열한 뒤, Alt + Enter를 하면 위에 import 항이 추가된다.
    EditText EditText_email, EditText_password;
    Button Button_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // R (Resource)의 id인 ~~를 볼러와 변수로 설정하는 것. (앞과 뒤가 똑같은 변수명이지만, 지역적으로 할당되어 있으므로 문제 없음)
        // 실제로 이렇게 하면 xml에서 찾아오기가 수월하다.
        EditText_email = findViewById(R.id.EditText_email);
        EditText_password = findViewById(R.id.EditText_password);
        Button_Login = findViewById(R.id.Button_Login);

        // 1. 값을 가져온다
        // 2. 클릭을 감지한다
        // 3. 1번의 값을 다음 액티비티로 넘긴다.

        //클릭 가능 여부를 설정
        Button_Login.setClickable(true);
        Button_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getText()의 기본형은 string이 아니므로 (Editable) .toString()을 해줘야 함.
                String email = EditText_email.getText().toString();
                String password = EditText_password.getText().toString();

                //값을 다른 액티비티 클래스로 넘겨주는 프로세스

                //전송을 시작할 때는 새로 만들어야 하므로 new
                //this 앞에 MainActivity를 사용해주는 건 전역과 지역의 중복때문이다.
                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);

                //Intent 형으로 정의된 intent의 putExtra 기능을 통해 email과 passsword를 전송한다.
                intent.putExtra("email", email);
                intent.putExtra( "password", password);

                //이를 전달해 그 다음 Activity를 시작한다.
                startActivity(intent);
            }
        });


    }
}
