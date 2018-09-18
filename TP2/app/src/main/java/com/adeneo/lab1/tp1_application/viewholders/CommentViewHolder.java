package com.adeneo.lab1.tp1_application.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.objects.Comment;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    private ImageView avatarComment;
    private TextView pseudoComment;
    private TextView messageComment;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        avatarComment = itemView.findViewById(R.id.avatarComment);
        pseudoComment = itemView.findViewById(R.id.pseudoComment);
        messageComment = itemView.findViewById(R.id.messageComment);
    }

    public void layoutForComment(Comment comment){
        if(comment != null){
            if(avatarComment != null){
                avatarComment.setImageResource(R.drawable.avatar);
            }
            if(pseudoComment != null){
                pseudoComment.setText(comment.getPseudo());
            }
            if(messageComment != null){
                messageComment.setText(comment.getMessage());
            }
        }
    }
}
