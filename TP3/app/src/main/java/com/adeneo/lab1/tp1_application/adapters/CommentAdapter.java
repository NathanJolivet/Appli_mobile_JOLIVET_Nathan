package com.adeneo.lab1.tp1_application.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.objects.Category;
import com.adeneo.lab1.tp1_application.objects.Comment;
import com.adeneo.lab1.tp1_application.viewholders.CategoryViewHolder;
import com.adeneo.lab1.tp1_application.viewholders.CommentViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter {

    private List<Comment> comments = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment, parent, false);
        CommentViewHolder commentViewHolder = new CommentViewHolder(view);
        return commentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Comment currentComment = this.comments.get(position);
        if(viewHolder instanceof CommentViewHolder && currentComment != null){
            CommentViewHolder viewHolder1 = (CommentViewHolder) viewHolder;
            viewHolder1.layoutForComment(currentComment);
        }
    }

    @Override
    public int getItemCount() {
        if(this.comments != null){
            return this.comments.size();
        }
        return 0;
    }


    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
