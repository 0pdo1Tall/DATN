package com.example.basebottom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basebottom.model.Movie;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Movie> movieList;
    private ClickListener<Movie> clickListener;

    public RecyclerViewAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position) {

        final Movie movie = movieList.get(position);

        holder.title.setText(movie.getTitle());
        holder.image.setBackgroundResource(movie.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(movie);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setOnItemClickListener(ClickListener<Movie> movieClickListener) {
        this.clickListener = movieClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private CardView cardView;

        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            image = view.findViewById(R.id.image);
            cardView = view.findViewById(R.id.cardView);
        }
    }
}

