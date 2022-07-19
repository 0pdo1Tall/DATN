package com.example.basebottom.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.basebottom.LoginActivity;
import com.example.basebottom.MainActivity;
import com.example.basebottom.databinding.FragmentLogoutBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogoutFragment extends Fragment {

    private FragmentLogoutBinding binding;
    private FirebaseAuth auth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        auth.signOut();

        return null;

//        LogoutViewModel logoutViewModel =
//                new ViewModelProvider(this).get(LogoutViewModel.class);
//
//        binding = FragmentLogoutBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textLogout;
//        logoutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}