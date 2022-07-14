package com.example.basebottom.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basebottom.ClickListener;
import com.example.basebottom.MainActivity;
import com.example.basebottom.R;
import com.example.basebottom.RecyclerViewAdapter;
import com.example.basebottom.databinding.FragmentHomeBinding;
import com.example.basebottom.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    //
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Movie> movieList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //
        movieList = new ArrayList<>();
        prepareMovie();
        recyclerView = (RecyclerView) binding.recyclerView;
        recyclerViewAdapter = new RecyclerViewAdapter(movieList);
        recyclerViewAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter.setOnItemClickListener(new ClickListener<Movie>(){
            @Override
            public void onItemClick(Movie data) {
                Toast.makeText(getContext(), data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(recyclerViewAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
}