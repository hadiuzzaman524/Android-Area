package com.nested.messenger.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nested.messenger.Chat;
import com.nested.messenger.MessageActivity;
import com.nested.messenger.R;
import com.nested.messenger.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{

    private Context mContext;
    private List<Chat> mChats;
    private String imageurl;
    private static final int MSG_TYPE_LEFT=0;
    private static final int MSG_TYPE_RIGHT=1;
    FirebaseUser firebaseUser;


    public MessageAdapter(Context mContext, List<Chat> mChats,String imageurl) {
        this.mContext = mContext;
        this.mChats = mChats;
        this.imageurl=imageurl;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     /*   if (viewType==MSG_TYPE_RIGHT) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View view = layoutInflater.inflate(R.layout.message_right, parent, false);

            return new MessageAdapter.ViewHolder(view);
        }
        else
        {*/
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View view = layoutInflater.inflate(R.layout.message_left, parent, false);

            return new MessageAdapter.ViewHolder(view);
       // }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {

        Chat chat=mChats.get(position);
        holder.msg.setText(chat.getMessage());

        if (imageurl.equals("default"))
        {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        }
        else
        {
            Glide.with(mContext).load(imageurl).into(holder.imageView);

        }
    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView msg;
        public CircleImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            msg=itemView.findViewById(R.id.text_messageid);
            imageView=itemView.findViewById(R.id.chat_picid);
        }
    }

    @Override
    public int getItemViewType(int position) {

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        if(mChats.get(position).getSender().equals(firebaseUser.getUid()))
        {
            return MSG_TYPE_RIGHT;
        }
        else
        {
            return MSG_TYPE_LEFT;
        }
    }
}
