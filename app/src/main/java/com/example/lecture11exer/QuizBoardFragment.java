package com.example.lecture11exer;

import android.app.backup.BackupDataInput;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lecture11exer.databinding.FragmentQuizBoardBinding;

import java.util.function.BiConsumer;

public class QuizBoardFragment extends Fragment {
    private FragmentQuizBoardBinding binding;
    private QuizViewMode viewMode;
    int count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentQuizBoardBinding.inflate(inflater, container, false);
        viewMode= new ViewModelProvider(this).get(QuizViewMode.class);


        View view= binding.getRoot();
        viewMode.ans_A=binding.answerA;
        viewMode.ans_B=binding.answerB;
        viewMode.ans_C= binding.answerC;
        viewMode.ans_D= binding.answerD;
        viewMode.next= binding.nextButton;
        viewMode.display_questions=binding.TWDisplayQuestion;
        viewMode.TWscore= binding.TWScore;
        viewMode.display_cur_number_questionTW= binding.TWCurQuestionOnTotal;
        viewMode.load_question();
        //display number of current question

   binding.TWCurQuestionOnTotal.setText("Question " + viewMode.number_curr_question+"/20");

        count =viewMode.score;

        if(viewMode.check==true){
            viewMode.disable();

            if(viewMode.a_check==true ){
            viewMode.display_correct_wrong_answer_ButtonA_click();
            }

            else if(viewMode.b_check==true){

            viewMode.display_correct_wrong_answer_Button_B_click();

            }
            else if(viewMode.c_check==true){
            viewMode.display_correct_wrong_answer_Button_C_click();

            }
            else{
            viewMode.display_correct_wrong_answer_Button_D_click();

            }
            viewMode.score=count;
        }

        binding.TWScore.setText("Score: "+viewMode.score);

        viewMode.ans_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMode.display_correct_wrong_answer_ButtonA_click();
                viewMode.disable();
                viewMode.a_check=true;
                viewMode.check=true;
            }
        });

        viewMode.ans_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMode.display_correct_wrong_answer_Button_B_click();
                viewMode.disable();
                viewMode.b_check=true;
                viewMode.check=true;
            }
        });

        viewMode.ans_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMode.display_correct_wrong_answer_Button_C_click();
                viewMode.disable();
                viewMode.c_check=true;
                viewMode.check=true;
            }
        });

        viewMode.ans_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMode.display_correct_wrong_answer_Button_D_click();
                viewMode.disable();
                viewMode.d_check=true;
                viewMode.check=true;
            }
        });



        viewMode.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewMode.check=false;
                viewMode.a_check=false;
                viewMode.b_check=false;
                viewMode.c_check=false;
                viewMode.d_check=false;

                viewMode.ans_A.setEnabled(true);
                viewMode.ans_B.setEnabled(true);
                viewMode.ans_C.setEnabled(true);
                viewMode.ans_D.setEnabled(true);
                viewMode.ans_A.setBackgroundColor(Color.WHITE);
                viewMode.ans_A.setChecked(false);
                viewMode.ans_B.setBackgroundColor(Color.WHITE);
                viewMode.ans_B.setChecked(false);
                viewMode.ans_C.setBackgroundColor(Color.WHITE);
                viewMode.ans_C.setChecked(false);
                viewMode.ans_D.setBackgroundColor(Color.WHITE);
                viewMode.ans_D.setChecked(false);

                String score_string= String.valueOf(viewMode.score);
                if( viewMode.number_curr_question==20 && viewMode.score>=16){
                    NavDirections action = QuizBoardFragmentDirections.actionQuizBoardFragmentToQuizResultFragment(viewMode.pass_message, score_string);
                    Navigation.findNavController(view).navigate(action);


                }
                else if( viewMode.number_curr_question==20 && viewMode.score<16){
                    NavDirections action = QuizBoardFragmentDirections.actionQuizBoardFragmentToQuizResultFragment(viewMode.loss_message, score_string);
                    Navigation.findNavController(view).navigate(action);
                }
                else{
                    viewMode.question_index++;
                    viewMode.load_question();
                    viewMode.number_curr_question++;}

                viewMode.display_cur_number_questionTW.setText("Question " + viewMode.number_curr_question+"/20");
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