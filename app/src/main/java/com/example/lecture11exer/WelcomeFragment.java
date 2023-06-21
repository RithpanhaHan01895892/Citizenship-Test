package com.example.lecture11exer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lecture11exer.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {
    private FragmentWelcomeBinding binding;
    Button start_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentWelcomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        start_button= binding.welcomeButotn;
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_quiz_board_fragment);
            }
        });
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}