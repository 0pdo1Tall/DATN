package com.example.basebottom.ui.mylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.basebottom.databinding.FragmentMylistBinding;

public class MylistFragment extends Fragment {

    private FragmentMylistBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MylistViewModel mylistViewModel =
                new ViewModelProvider(this).get(MylistViewModel.class);

        binding = FragmentMylistBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMylist;
        mylistViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}