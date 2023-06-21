package com.example.lecture11exer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.lecture11exer.databinding.FragmentQuizResultBinding;


public class QuizResultFragment extends Fragment {
    private FragmentQuizResultBinding binding;
        String message;
        TextView TWdisplay_message, TWdisplay_score;
        char character;
        String score_string;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentQuizResultBinding.inflate(inflater, container, false);
        View view= binding.getRoot();
        TWdisplay_message=binding.TWmessage;
        TWdisplay_score= binding.TWscore;
        String message = QuizResultFragmentArgs.fromBundle(requireArguments()).getMessage();
        score_string= QuizResultFragmentArgs.fromBundle(requireArguments()).getScoreString();
        TWdisplay_score.setText("Final score: "+score_string);
        TWdisplay_message.setText(message);
        binding.reTtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_quiz_result_Fragment_to_quiz_board_fragment);
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