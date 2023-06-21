package com.example.lecture11exer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lecture11exer.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentDetailBinding.inflate(inflater, container, false);
        View view= binding.getRoot();
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}