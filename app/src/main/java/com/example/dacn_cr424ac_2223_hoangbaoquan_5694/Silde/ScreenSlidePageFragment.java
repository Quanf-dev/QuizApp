package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Silde;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.DBHelper;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.QuestionController;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;


import java.io.IOException;
import java.util.ArrayList;


public class ScreenSlidePageFragment extends Fragment {

    ArrayList<Question> arr_Ques ;
    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    public int mPageNumber = 0; // vị trí trang hiện tại
    public int checkAns;
    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;
    ImageView imgIcon;


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_quiz, container, false);
        imgIcon=(ImageView) rootView.findViewById(R.id.ivIcon) ;

        tvNum = (TextView) rootView.findViewById(R.id.tvNum);
        tvQuestion = (TextView) rootView.findViewById(R.id.tvQuestion);
        radA = (RadioButton) rootView.findViewById(R.id.radA);
        radB = (RadioButton) rootView.findViewById(R.id.radB);
        radC = (RadioButton) rootView.findViewById(R.id.radC);
        radD = (RadioButton) rootView.findViewById(R.id.radD);

        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);



        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
        arr_Ques = new ArrayList<Question>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = slideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns= getArguments().getInt(ARG_CHECKANSWER);
    }
//
    public static ScreenSlidePageFragment create(int pageNumber, int checkAnswer) {
    ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_PAGE, pageNumber);
    args.putInt(ARG_CHECKANSWER,checkAnswer);
    fragment.setArguments(args);
    return fragment;
}
//
    public Question getItem(int position) {
        return arr_Ques.get(position);
    }
//
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvNum.setText("Câu " + (mPageNumber + 1));
        tvQuestion.setText(arr_Ques.get(mPageNumber).getQuestion());
        radA.setText("A. " + getItem(mPageNumber).getAns_a());
        radB.setText("B. " + getItem(mPageNumber).getAns_b());
        if (getItem(mPageNumber).getAns_c() == null) {
            radC.setVisibility(View.GONE);
        } else radC.setText("C." + getItem(mPageNumber).getAns_c());
        if (getItem(mPageNumber).getAns_d() == null) {
            radD.setVisibility(View.GONE);
        } else radD.setText("D." + getItem(mPageNumber).getAns_d());

        if (getItem(mPageNumber).getImage() != null) {
            Log.e("Hinh", getItem(mPageNumber).getImage());
            imgIcon.setImageResource(getResources().getIdentifier(getItem(mPageNumber).getImage() + "", "drawable", getContext().getPackageName()));
        }


        if (checkAns != 0) {
            getClickAns(getItem(mPageNumber).getTraloi().toString());
            getCheckAns(getItem(mPageNumber).getResult().toString());
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getItem(mPageNumber).choiceID = checkedId;
                getItem(mPageNumber).setTraloi(getChoiceFromID(checkedId));

//                Toast.makeText(getActivity(),"Đây là đáp án "+ checkedId, Toast.LENGTH_SHORT).show();
            }
        });
    }




    //Lấy giá trị (vị trí) radiogroup chuyển thành đáp án A/B/C/D
    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else return "";
    }

//    //Hàm kiểm tra câu đúng, nếu câu đúng thì đổi màu background radiobutton tương ứng
    private void getCheckAns(String ans){
        if(ans.equals("A")==true){
            radA.setBackgroundResource(R.drawable.rightans_custom);
        }
        else if(ans.equals("B")==true){
            radB.setBackgroundResource(R.drawable.rightans_custom);
        }else if(ans.equals("C")==true){
            radC.setBackgroundResource(R.drawable.rightans_custom);
        }else if(ans.equals("D")==true){
            radD.setBackgroundResource(R.drawable.rightans_custom);
        }else ;
    }
    private void getClickAns(String ans){
        if(ans.equals("A")==true){
            radA.setBackgroundResource(R.drawable.ans_custom);
        }
        else if(ans.equals("B")==true){
            radB.setBackgroundResource(R.drawable.ans_custom);
        }else if(ans.equals("C")==true){
            radC.setBackgroundResource(R.drawable.ans_custom);
        }else if(ans.equals("D")==true){
            radD.setBackgroundResource(R.drawable.ans_custom);
        }else ;
    }


//

}
