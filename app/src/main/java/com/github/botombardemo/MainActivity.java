package com.github.botombardemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mFragmentManager = getSupportFragmentManager();
        mBottomBar.setOnTabSelectListener(new TabSelectListener());
        mBottomBar.setOnTabReselectListener(new TabReselectListener());
    }

    private class TabSelectListener implements OnTabSelectListener {

        @Override
        public void onTabSelected(int tabId) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            hideFragments(transaction);
            switch (tabId) {
                case R.id.tab_feed:
                    if (firstFragment == null) {
                        firstFragment = new FirstFragment();
                        transaction.add(R.id.content, firstFragment);
                    } else {
                        transaction.show(firstFragment);
                    }
                    break;
                case R.id.tab_following:
                    if (secondFragment == null) {
                        secondFragment = new SecondFragment();
                        transaction.add(R.id.content, secondFragment);
                    } else {
                        transaction.show(secondFragment);
                    }
                    break;
                case R.id.tab_profile:
                    if (thirdFragment == null) {
                        thirdFragment = new ThirdFragment();
                        transaction.add(R.id.content, thirdFragment);
                    } else {
                        transaction.show(thirdFragment);
                    }
                    break;
            }

            transaction.commitAllowingStateLoss();
        }
    }

    private class TabReselectListener implements OnTabReselectListener {

        @Override
        public void onTabReSelected(int tabId) {

        }
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (firstFragment != null) {
            transaction.hide(firstFragment);
        }
        if (secondFragment != null) {
            transaction.hide(secondFragment);
        }
        if (thirdFragment != null) {
            transaction.hide(thirdFragment);
        }
    }

}
