package com.example.basebottom.ui.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basebottom.ClickListener;
import com.example.basebottom.MainActivity;
import com.example.basebottom.R;
import com.example.basebottom.RecyclerViewAdapter;
import com.example.basebottom.databinding.FragmentHomeBinding;
import com.example.basebottom.model.Movie;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    //
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Movie> movieList;

    //
    Dialog myDialog;

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
                //
                View v = (View)getLayoutInflater().inflate(R.layout.fragment_home_popup, null);
                showPopup(v);
            }
        });

        recyclerView.setAdapter(recyclerViewAdapter);

        //
        myDialog = new Dialog(getContext());

        // Firebase testing
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Log.d(HomeFragment.class.toString(), "db instance: " + db.toString());

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

    public void showPopup(View v){
        TextView txtClose;
        Button btnFollow;
        myDialog.setContentView(R.layout.fragment_home_popup);
        txtClose = myDialog.findViewById(R.id.txtClose);
        btnFollow = myDialog.findViewById(R.id.btn_follow);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Added to Favorites", Toast.LENGTH_SHORT).show();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}