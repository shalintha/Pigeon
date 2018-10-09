package com.example.subhashana.pigeonn;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Messages> userMessageList;

    public MessageAdapter(List<Messages> userMessageList){

        this.userMessageList = userMessageList;

    }


    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


               View V = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.messages_layout_of_users, parent, false);

        return new MessageViewHolder(V);

    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {


        Messages messages = userMessageList.get(position);

        holder.messageText.setText(messages.getMessage());

    }

    @Override
    public int getItemCount() {
        return userMessageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{

        public TextView messageText;
        public CircleImageView userProfileImage;

        public MessageViewHolder(View view){
            super(view);

            messageText = (TextView) view.findViewById(R.id.message_text);
            userProfileImage = (CircleImageView) view.findViewById(R.id.message_profile_image);

        }
    }

}
