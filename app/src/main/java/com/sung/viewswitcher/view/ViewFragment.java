package com.sung.viewswitcher.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.sung.viewswitcher.R;
import com.sung.viewswitcher.text.TextFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment implements View.OnClickListener{
    public final static int TAG = 2;
    private ViewFlipper mVFcontent;

    public static ViewFragment newInstance() {
        return new ViewFragment();
    }

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVFcontent = (ViewFlipper) view.findViewById(R.id.vf_content);
        initView();
    }

    private void initView(){
        mVFcontent.setOnClickListener(this);
        mVFcontent.setInAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left));
        mVFcontent.setOutAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right));
    }

    @Override
    public void onClick(View view) {
        mVFcontent.showNext();
    }
}
