package com.example.calendarandroid;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.calendarandroid.Utils.Utility;

    public class FirstLaunchActivity extends LifecycleLoggingActivity {
        private ViewPager mViewPager;
        private ImageButton mNextBtn;
        private Button mSkipBtn, mFinishBtn;
        private com.example.calendarandroid.FirstLaunchActivity.SectionsPagerAdapter mSectionsPagerAdapter;
        private ImageView[] indicators;
        private int pageNumber = 0;


        @Override
        protected void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_launch);
//            final Intent intent = getIntent();

            setAllComponents();

            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_trans80));


            // Set up the ViewPager with the sections adapter.
            mViewPager.setAdapter(mSectionsPagerAdapter);
            mViewPager.setCurrentItem(pageNumber);
            updateIndicators(pageNumber);

            final int color1 = ContextCompat.getColor(this, R.color.violet);
            final int color2 = ContextCompat.getColor(this, R.color.orange);
            final int color3 = ContextCompat.getColor(this, R.color.green);

            final int[] colorList = new int[]{color1, color2, color3};

            final ArgbEvaluator evaluator = new ArgbEvaluator();

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                color update
                    int colorUpdate = (Integer) evaluator.evaluate(
                            positionOffset, colorList[position], colorList[position == 2 ? position : position + 1]);
                    mViewPager.setBackgroundColor(colorUpdate);
                }

                @Override
                public void onPageSelected(int currentPageNumber) {

                    pageNumber = currentPageNumber;

                    updateIndicators(currentPageNumber);

                    switch (currentPageNumber) {
                        case 0:
                            mViewPager.setBackgroundColor(color1);
                            break;
                        case 1:
                            mViewPager.setBackgroundColor(color2);
                            break;
                        case 2:
                            mViewPager.setBackgroundColor(color3);
                            break;
                    }

                    mNextBtn.setVisibility(currentPageNumber == 2 ? View.GONE : View.VISIBLE);
                    mFinishBtn.setVisibility(currentPageNumber == 2 ? View.VISIBLE : View.GONE);

                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });

            mNextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pageNumber += 1;
                    mViewPager.setCurrentItem(pageNumber, true);
                }
            });

            mSkipBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utility.setSharedSetting(FirstLaunchActivity.this, MainActivity.PREF_USER_FIRST_TIME,false);
//                    Intent backToMain = new Intent(FirstLaunchActivity.this, MainActivity.class);
//                    backToMain.putExtra("myBoolean", false);
//                    startActivity(backToMain);
//                    Intent backToMain = new Intent(FirstLaunchActivity.this, MainActivity.class);
                finish();
                }
            });

            mFinishBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utility.setSharedSetting(FirstLaunchActivity.this, MainActivity.PREF_USER_FIRST_TIME, false);
//                    Intent backToMain = new Intent(FirstLaunchActivity.this, MainActivity.class);
//                    backToMain.putExtra("myBoolean", false);
//                    startActivity(backToMain);
                    finish();
//                    Intent backToMain = new Intent(FirstLaunchActivity.this, MainActivity.class);
                }
            });

        }

        private void updateIndicators(int currentPageNumber) {
            for (int i = 0; i < indicators.length; i++) {
                indicators[i].setBackgroundResource(
                        i == currentPageNumber ? R.drawable.indicator_selected : R.drawable.intro_unselected_page_indicator
                );
            }
        }

        private void setAllComponents(){

            ImageView zero, one, two;

            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            mNextBtn = findViewById(R.id.intro_btn_next);
            mSkipBtn = findViewById(R.id.intro_btn_skip);
            mFinishBtn = findViewById(R.id.intro_btn_finish);

            zero = findViewById(R.id.intro_indicator_0);
            one = findViewById(R.id.intro_indicator_1);
            two = findViewById(R.id.intro_indicator_2);

            indicators = new ImageView[]{zero, one, two};

            mViewPager = findViewById(R.id.container);
        }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_first_launch, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

        //    A placeholder fragment containing a simple view.
        public static class PlaceholderFragment extends Fragment {

            //        The fragment argument representing the section number for this
//        fragment.
            private static final String ARG_SECTION_NUMBER = "section_number";

            ImageView img;
            TextView textView;
            View rootView;

            int[] bgs = new int[]{
                    R.drawable.fl1,
                    R.drawable.fl2,
                    R.drawable.ic_mail_24dp};
//        public PlaceholderFragment() {}

            //        Returns a new instance of this fragment for the given section
//        number.
            public static com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment newInstance(int sectionNumber) {
                com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment fragment = new com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment();
                Bundle args = new Bundle();
                args.putInt(ARG_SECTION_NUMBER, sectionNumber);
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                rootView = inflater.inflate(R.layout.fragment_first_launch, container, false);
                textView = rootView.findViewById(R.id.intro_label);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

                img = rootView.findViewById(R.id.section_img);
                img.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);


                return rootView;
            }


        }

        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            private SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int currentPageNumber) {
                // getItem is called to instantiate the fragment for the given pageNumber.
                // Return a PlaceholderFragment (defined as a static inner class below).
                return com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment.newInstance(currentPageNumber + 1);
            }

            @Override
            public int getCount() {
                // Show 3 total pages.
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int currentPageNumber) {
                switch (currentPageNumber) {
                    case 0:
                        return "SECTION 1";
                    case 1:
                        return "SECTION 2";
                    case 2:
                        return "SECTION 3";
                }
                return null;
            }

        }
    }
