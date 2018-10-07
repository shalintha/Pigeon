package com.example.subhashana.pigeonn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private Button SendFriendrequest;
    private Button declineFriendrequest;
    private TextView ProfileName;
    private TextView ProfileStatus;
    private ImageView ProfileImage;

    private DatabaseReference UsersReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        UsersReference = FirebaseDatabase.getInstance().getReference().child("Users");
        String visit_user_id = getIntent().getExtras().get("visit_user_id").toString();


        SendFriendrequest = (Button) findViewById(R.id.profile_visit_send_req_btn);
        declineFriendrequest = (Button) findViewById(R.id.profile_decline_friend_req_btn);
        ProfileName = (TextView) findViewById(R.id.profile_visit_username);
        ProfileStatus = (TextView) findViewById(R.id.profile_visit_user_status);
        ProfileImage = (ImageView) findViewById(R.id.profile_visit_user_image);


        UsersReference.child(visit_user_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("user_name").getValue().toString();
                String status = dataSnapshot.child("user_status").getValue().toString();
                String image = dataSnapshot.child("user_image").getValue().toString();


                ProfileName.setText(name);
                ProfileStatus.setText(status);
                Picasso.with(ProfileActivity.this).load(image).placeholder(R.drawable.default_profile_image).into(ProfileImage);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
