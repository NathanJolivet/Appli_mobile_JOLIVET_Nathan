package com.adeneo.lab1.tp1_application.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.contracts.IItemOnClickManager;
import com.adeneo.lab1.tp1_application.objects.Category;
import com.adeneo.lab1.tp1_application.objects.Cell;
import com.adeneo.lab1.tp1_application.viewholders.CategoryViewHolder;
import com.adeneo.lab1.tp1_application.viewholders.CellViewHolder;
import com.adeneo.lab1.tp1_application.viewholders.FooterViewHolder;
import com.adeneo.lab1.tp1_application.viewholders.HeaderViewHolder;
import com.adeneo.lab1.tp1_application.viewholders.MovieViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CellAdapter extends RecyclerView.Adapter {

    List<Cell> cells = new ArrayList<>();
    int MOVIE_CELL = 0;
    int HEADER_CELL = 1;
    int FOOTER_CELL = 2;

    private IItemOnClickManager mgr;


    public void setClickManager(IItemOnClickManager mgr) {
        this.mgr = mgr;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == MOVIE_CELL){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movie, parent, false);
            MovieViewHolder movieViewHolder = new MovieViewHolder(view);
            movieViewHolder.setClickManager(mgr);
            return movieViewHolder;
        }

        if(viewType == HEADER_CELL){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_header, parent, false);
            HeaderViewHolder headerViewHolder = new HeaderViewHolder(view);
            return headerViewHolder;
        }

        if(viewType == FOOTER_CELL){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_footer, parent, false);
            FooterViewHolder footerViewHolder = new FooterViewHolder(view);
            return footerViewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Cell currentCell = cells.get(position);
        if(viewHolder instanceof CellViewHolder && currentCell != null){
            CellViewHolder viewHolder1 = (CellViewHolder) viewHolder;
            viewHolder1.layoutForCell(currentCell);
        }
    }

    @Override
    public int getItemCount() {
        if(cells != null){
            return cells.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position){
        if(cells != null){
            Cell currentCell = cells.get(position);
            switch (currentCell.getType()){
                case MOVIE:
                    return MOVIE_CELL;
                case FOOTER:
                    return FOOTER_CELL;
                case HEADER:
                    return HEADER_CELL;
            }
        }
        return 0;

    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
