package com.example.basebottom.ui.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.basebottom.databinding.FragmentNoteDetailBinding;

import java.util.ArrayList;

public class NoteDetailFragment extends Fragment {

    private FragmentNoteDetailBinding binding;

    //
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> mylist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NoteViewModel noteDetailViewModel =
                new ViewModelProvider(requireActivity()).get(NoteViewModel.class);

        binding = FragmentNoteDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNote;
//        noteViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        TextView textView = binding.textView;
        noteDetailViewModel.getText().observe(getViewLifecycleOwner(),textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}