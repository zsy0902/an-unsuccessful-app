package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private String fragmentTitle[] = {"首页", "提问", "体系", "我的"};
    private int fragmentImage[] = {R.drawable.home, R.drawable.question, R.drawable.system, R.drawable.user};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentMain());
        fragments.add(new FragmentQuestion());
        fragments.add(new FragmentSystem());
        fragments.add(new FragmentMine());
        VPagerAdapter adapter = new VPagerAdapter(getSupportFragmentManager(),
                VPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null)
                tab.setCustomView(adapter.getTabView(i));
        }
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class VPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments;
        private String fragmentTitle[];
        public VPagerAdapter(@NonNull FragmentManager fm, int behavior,List<Fragment> fragments) {
            super(fm, behavior);
            this.fragments=fragments;
        }

        @NonNull
        @Override
        public CharSequence getPageTitle(int position){
            if(position==0)
                return "首页";
            if(position==1)
                return "问答";
            if(position==2)
                return "体系";
            if(position==3)
                return "我的";
            return "...";
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        public View getTabView(int position){
            View view= LayoutInflater.from(ViewPagerActivity.this).inflate(R.layout.tab_icon,null);
            ImageView imageView=view.findViewById(R.id.imageView0);
            TextView textView=view.findViewById(R.id.text0);
            imageView.setImageResource(fragmentImage[position]);
            textView.setText(fragmentTitle[position]);
            return view;
        }
    }
}