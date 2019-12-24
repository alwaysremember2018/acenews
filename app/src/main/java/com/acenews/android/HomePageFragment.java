package com.acenews.android;


import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    public HomePageFragment() {
        // Required empty public constructor
    }
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPager2 = getActivity().findViewById(R.id.newsViewPage);
        mTabLayout = getActivity().findViewById(R.id.tabLayout);
        mViewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                final List<NewsFragment> newsFragmentList = new ArrayList<>();
                for(int i = 0; i < 3; i++ ){
                    newsFragmentList.add(new NewsFragment());
                }
                if(position == 1){
                    return new MyFragment();
                }
                return newsFragmentList.get(position);
            }
            @Override
            public int getItemCount() {  //返回三个页面
                return 3;
            }
        });
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("Fragment" + position);
            }
        });
        tabLayoutMediator.attach();

    }
}
