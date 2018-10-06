package com.example.subhashana.pigeonn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.nio.channels.AlreadyBoundException;

public class StartPageActivity extends AppCompatActivity {

    private Button NeedNewAccountButton;
    private Button AlresdyHaveAnAccountButton;

    public StartPageActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        NeedNewAccountButton = (Button) findViewById(R.id.need_account_button);
        AlresdyHaveAnAccountButton = (Button) findViewById(R.id.already_have_account_button);


        NeedNewAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(StartPageActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });


        AlresdyHaveAnAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(StartPageActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
