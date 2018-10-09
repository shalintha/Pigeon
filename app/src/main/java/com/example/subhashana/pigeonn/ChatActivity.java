package com.example.subhashana.pigeonn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {


    private String messageReceiverId;
    private String messageReceiverName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        messageReceiverId = getIntent().getExtras().get("visit_user_id").toString();
        messageReceiverName = getIntent().getExtras().get("user_name").toString();


        Toast.makeText(ChatActivity.this, messageReceiverId, Toast.LENGTH_SHORT).show();
        Toast.makeText(ChatActivity.this, messageReceiverName, Toast.LENGTH_SHORT).show();
    }
}
