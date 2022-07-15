package com.example.basebottom.ui.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basebottom.ClickListener;
import com.example.basebottom.R;
import com.example.basebottom.RecyclerViewAdapter;
import com.example.basebottom.RecyclerViewFavoriteAdapter;
import com.example.basebottom.databinding.FragmentFavoriteBinding;
import com.example.basebottom.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;

    //
    private RecyclerView recyclerView;
    private RecyclerViewFavoriteAdapter recyclerViewFavoriteAdapter;
    private List<Movie> movieList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoriteViewModel favoriteViewModel =
                new ViewModelProvider(this).get(FavoriteViewModel.class);

        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textFavorite;
//        favoriteViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //
        Toast.makeText(getContext(), "Favorite Fragment", Toast.LENGTH_SHORT).show();
        movieList = new ArrayList<>();
        prepareMovie();
        recyclerView = (RecyclerView) binding.recyclerViewFavorite;
        recyclerViewFavoriteAdapter = new RecyclerViewFavoriteAdapter(movieList);
        recyclerViewFavoriteAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewFavoriteAdapter.setOnItemClickListener(new ClickListener<Movie>(){
            @Override
            public void onItemClick(Movie data) {
                Toast.makeText(getContext(), data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(recyclerViewFavoriteAdapter);
        return root;
    }

    private void prepareMovie(){
        Movie movie = new Movie("Star Wars The Last Jedi", R.drawable.star_war);
        movieList.add(movie);
        movie = new Movie("Coco",R.drawable.coco);
        movieList.add(movie);
        movie = new Movie("Justice League ",R.drawable.justice_league);
        movieList.add(movie);
        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
        movieList.add(movie);
        movie = new Movie("Star Wars The Last Jedi",R.drawable.star_war);
        movieList.add(movie);
        movie = new Movie("Coco",R.drawable.coco);
        movieList.add(movie);
        movie = new Movie("Justice League ",R.drawable.justice_league);
        movieList.add(movie);
        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
        movieList.add(movie);
        movie = new Movie("Star Wars The Last Jedi",R.drawable.star_war);
        movieList.add(movie);
        movie = new Movie("Coco",R.drawable.coco);
        movieList.add(movie);
        movie = new Movie("Justice League ",R.drawable.justice_league);
        movieList.add(movie);
        movie = new Movie("Thor: Ragnarok",R.drawable.thor_ragnarok);
        movieList.add(movie);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}