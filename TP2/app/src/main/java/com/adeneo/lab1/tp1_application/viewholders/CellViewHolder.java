package com.adeneo.lab1.tp1_application.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.adeneo.lab1.tp1_application.objects.Cell;

public abstract class CellViewHolder extends RecyclerView.ViewHolder{

    public CellViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void layoutForCell(Cell cell);
}
