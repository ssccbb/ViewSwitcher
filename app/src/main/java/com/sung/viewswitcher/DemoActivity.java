package com.sung.viewswitcher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.sung.viewswitcher.image.IamgeFragment;
import com.sung.viewswitcher.text.TextFragment;
import com.sung.viewswitcher.view.ViewFragment;
import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity {
    public final static String GO_TO = "DemoActivity";
    private int position = 0;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        position = getIntent().getIntExtra(DemoActivity.GO_TO,0);

        fragmentManager = getSupportFragmentManager();
        initFragment();

//        switchFragment(0,position);
    }

    private void initFragment(){
        if (fragments == null)
            fragments = new ArrayList<>();

        Fragment fragment = IamgeFragment.newInstance();
        fragments.add(fragment);
        fragment = TextFragment.newInstance();
        fragments.add(fragment);
        fragment = ViewFragment.newInstance();
        fragments.add(fragment);

        fragmentManager.beginTransaction()
                .add(R.id.root_layout, fragments.get(position))
                .show(fragments.get(position)).commit();
    }

    private void switchFragment(int from, int to){
        if (from == to)
            return;

        if (fragments.get(to).isAdded()){
            fragmentManager.beginTransaction()
                    .show(fragments.get(to))
                    .hide(fragments.get(from))
                    .commit();
        }else {
            fragmentManager.beginTransaction()
                    .add(R.id.root_layout, fragments.get(to),to+"")
                    .show(fragments.get(to))
                    .hide(fragments.get(from))
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (fragmentManager != null)
            fragmentManager = null;

        if (fragments != null){
            fragments.clear();
            fragments=null;
        }
    }
}
