package com.sung.viewswitcher.image;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.sung.viewswitcher.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IamgeFragment extends Fragment implements ViewSwitcher.ViewFactory,View.OnClickListener{
    public final static int TAG = 0;
    private ImageSwitcher mISswitcher;
    private TextView mTVindicator;
    private int position = 0;
    private int[] images = {R.drawable.bg_1,R.drawable.bg_2,R.drawable.bg_3};

    public static IamgeFragment newInstance() {
        return new IamgeFragment();
    }

    public IamgeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iamge, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mISswitcher = (ImageSwitcher) view.findViewById(R.id.is_switcher);
        mTVindicator = (TextView) view.findViewById(R.id.tv_indicator);
        initView();
    }

    private void initView(){
        mISswitcher.setFactory(this);
        mISswitcher.setImageResource(images[position]);
        mTVindicator.setText("NO."+position);
        mISswitcher.setOnClickListener(this);
        mISswitcher.setInAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left));
        mISswitcher.setOutAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right));

    }

    @Override
    public View makeView() {
        ImageView view = new ImageView(getContext());
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        return view;
    }

    @Override
    public void onClick(View view) {
        position++;
        if (position>=images.length)
            position = 0;
        mISswitcher.setImageResource(images[position]);
        mTVindicator.setText("NO."+position);
    }
}
