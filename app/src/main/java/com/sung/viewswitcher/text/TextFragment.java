package com.sung.viewswitcher.text;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.sung.viewswitcher.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment implements ViewSwitcher.ViewFactory,View.OnClickListener{
    public final static int TAG = 1;
    private int position = 0;
    private TextSwitcher mTSswitcher;
    private String[] strs = {"示例文本1","示例文本2","示例文本3","示例文本4","示例文本5"};

    public static TextFragment newInstance() {
        return new TextFragment();
    }

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTSswitcher = (TextSwitcher) view.findViewById(R.id.tv_switcher);
        mTSswitcher.setFactory(this);
        mTSswitcher.setOnClickListener(this);
        mTSswitcher.setText(strs[position]);
        mTSswitcher.setInAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left));
        mTSswitcher.setOutAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right));
    }

    @Override
    public View makeView() {
        TextView text = new TextView(getContext());
        text.setTextSize(20);
        text.setGravity(Gravity.CENTER);
        return text;
    }

    @Override
    public void onClick(View view) {
        position++;
        if (position >= strs.length)
            position = 0;
        mTSswitcher.setText(strs[position]);
    }
}
