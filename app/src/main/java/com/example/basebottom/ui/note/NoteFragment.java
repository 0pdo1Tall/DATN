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
import androidx.navigation.fragment.NavHostFragment;

import com.example.basebottom.R;
import com.example.basebottom.databinding.FragmentNoteBinding;

import java.util.ArrayList;

public class NoteFragment extends Fragment {

    private FragmentNoteBinding binding;

    //
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> mylist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NoteViewModel noteViewModel =
                new ViewModelProvider(requireActivity()).get(NoteViewModel.class);

        binding = FragmentNoteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNote;
//        noteViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //
        listView = binding.listView;
        mylist = new ArrayList<>();
        mylist.add("C");
        mylist.add("C++");
        mylist.add("C#");
        mylist.add("Java");
        mylist.add("Advanced java");
        mylist.add("Interview prep with c++");
        mylist.add("Interview prep with java");
        mylist.add("data structures with c");
        mylist.add("data structures with java");
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                noteViewModel.setText((String)adapterView.getItemAtPosition(i));
                Toast.makeText(getActivity(), (String)adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(NoteFragment.this)
                        .navigate(R.id.action_navigation_note_to_navigation_note_detail);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}