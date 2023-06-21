package com.example.lecture11exer;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

public class QuizViewMode extends ViewModel{
    RadioButton ans_A, ans_B, ans_C, ans_D;
    Button next;
    TextView display_questions, TWscore, display_cur_number_questionTW;
    int score =0, question_index=0;
    int number_curr_question=1;
    boolean check=false,a_check=false,b_check=false,c_check=false,d_check=false,correct=true;
    String pass_message="Congratulation, You Passed The Test!!!!", loss_message="You Fail The Test!!!\nPlease review before take the retest!";





    public void disable(){
        ans_A.setEnabled(false);
        ans_B.setEnabled(false);
        ans_C.setEnabled(false);
        ans_D.setEnabled(false);

    }
    //load questions
    public void load_question(){
        display_questions.setText(QuestionsAnswers.questions[question_index]);
        ans_A.setText(QuestionsAnswers.choose_answer[question_index][0]);
        ans_B.setText(QuestionsAnswers.choose_answer[question_index][1]);
        ans_C.setText(QuestionsAnswers.choose_answer[question_index][2]);
        ans_D.setText(QuestionsAnswers.choose_answer[question_index][3]);
    }


    //action when user click button answer A
    public void display_correct_wrong_answer_ButtonA_click(){
        String text_buttonA= ans_A.getText().toString();
        String text_buttonB = ans_B.getText().toString();
        String text_buttonC = ans_C.getText().toString();
        String text_buttonD = ans_D.getText().toString();
        if(text_buttonA.equals(QuestionsAnswers.correct_answer[question_index])){
            score +=1;
            TWscore.setText("Score: "+score);
            ans_A.setBackgroundColor(Color.GREEN);
            ans_B.setBackgroundColor(Color.GRAY);
            ans_C.setBackgroundColor(Color.GRAY);
            ans_D.setBackgroundColor(Color.GRAY);
        }
        else{
            ans_A.setBackgroundColor(Color.RED);
            if(text_buttonB.equals(QuestionsAnswers.correct_answer[question_index])){
                ans_B.setBackgroundColor(Color.GREEN);
                ans_C.setBackgroundColor(Color.GRAY);
                ans_D.setBackgroundColor(Color.GRAY);
            }
            else if(text_buttonC.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_B.setBackgroundColor(Color.GRAY);
                ans_C.setBackgroundColor(Color.GREEN);
                ans_D.setBackgroundColor(Color.GRAY);
            }
            else if(text_buttonD.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_B.setBackgroundColor(Color.GRAY);
                ans_C.setBackgroundColor(Color.GRAY);
                ans_D.setBackgroundColor(Color.GREEN);
            }
        }
    }

    //action when user click on button answer B
    public void display_correct_wrong_answer_Button_B_click(){
        String text_buttonA= ans_A.getText().toString();
        String text_buttonB = ans_B.getText().toString();
        String text_buttonC = ans_C.getText().toString();
        String text_buttonD = ans_D.getText().toString();
        if(text_buttonB.equals(QuestionsAnswers.correct_answer[question_index])){
            score +=1;
            TWscore.setText("Score: "+score);
            ans_B.setBackgroundColor(Color.GREEN);
            ans_A.setBackgroundColor(Color.GRAY);
            ans_C.setBackgroundColor(Color.GRAY);
            ans_D.setBackgroundColor(Color.GRAY);
           // correct=true;
        }
        else{
            ans_B.setBackgroundColor(Color.RED);
            if(text_buttonA.equals(QuestionsAnswers.correct_answer[question_index])){
                ans_A.setBackgroundColor(Color.GREEN);
                ans_C.setBackgroundColor(Color.GRAY);
                ans_D.setBackgroundColor(Color.GRAY);
            }
            else if(text_buttonC.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_A.setBackgroundColor(Color.GRAY);
                ans_C.setBackgroundColor(Color.GREEN);
                ans_D.setBackgroundColor(Color.GRAY);
            }
            else if(text_buttonD.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_A.setBackgroundColor(Color.GRAY);
                ans_C.setBackgroundColor(Color.GRAY);
                ans_D.setBackgroundColor(Color.GREEN);
            }
           // correct=false;
        }
    }

    //action when user click button answer C
    public void display_correct_wrong_answer_Button_C_click(){
        String text_buttonA= ans_A.getText().toString();
        String text_buttonB = ans_B.getText().toString();
        String text_buttonC = ans_C.getText().toString();
        String text_buttonD = ans_D.getText().toString();
        if(text_buttonC.equals(QuestionsAnswers.correct_answer[question_index])){
            score +=1;
            TWscore.setText("Score: "+score);
            ans_C.setBackgroundColor(Color.GREEN);
            ans_B.setBackgroundColor(Color.GRAY);
            ans_A.setBackgroundColor(Color.GRAY);
            ans_D.setBackgroundColor(Color.GRAY);
        }
        else{
            ans_C.setBackgroundColor(Color.RED);
            if(text_buttonB.equals(QuestionsAnswers.correct_answer[question_index])){
                ans_A.setBackgroundColor(Color.GRAY);
                ans_B.setBackgroundColor(Color.GREEN);
                ans_D.setBackgroundColor(Color.GRAY);
            }
            else if(text_buttonD.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_B.setBackgroundColor(Color.GRAY);
                ans_A.setBackgroundColor(Color.GRAY);
                ans_D.setBackgroundColor(Color.GREEN);
            }
            else if(text_buttonA.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_B.setBackgroundColor(Color.GRAY);
                ans_A.setBackgroundColor(Color.GREEN);
                ans_D.setBackgroundColor(Color.GRAY);
            }
        }
    }

    //action when user click button answer D
    public void display_correct_wrong_answer_Button_D_click(){
        String text_buttonA= ans_A.getText().toString();
        String text_buttonB = ans_B.getText().toString();
        String text_buttonC = ans_C.getText().toString();
        String text_buttonD = ans_D.getText().toString();
        if(text_buttonD.equals(QuestionsAnswers.correct_answer[question_index])){
            score +=1;
            TWscore.setText("Score: "+score);
            ans_D.setBackgroundColor(Color.GREEN);
            ans_B.setBackgroundColor(Color.GRAY);
            ans_C.setBackgroundColor(Color.GRAY);
            ans_A.setBackgroundColor(Color.GRAY);        }
        else{
            ans_D.setBackgroundColor(Color.RED);
            if(text_buttonA.equals(QuestionsAnswers.correct_answer[question_index])){
                ans_A.setBackgroundColor(Color.GREEN);
                ans_B.setBackgroundColor(Color.GRAY);
                ans_C.setBackgroundColor(Color.GRAY);
            }
            else if(text_buttonB.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_B.setBackgroundColor(Color.GREEN);
                ans_A.setBackgroundColor(Color.GRAY);
                ans_D.setBackgroundColor(Color.GRAY);
            }
            else if(text_buttonC.equals((QuestionsAnswers.correct_answer[question_index]))){
                ans_A.setBackgroundColor(Color.GRAY);
                ans_B.setBackgroundColor(Color.GRAY);
                ans_C.setBackgroundColor(Color.GREEN);
            }
        }
    }
}
