//package com.example.calendarandroid.Utils;
//
//import android.animation.ArgbEvaluator;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.calendarandroid.FirstLaunchActivity;
//import com.example.calendarandroid.LifecycleLoggingActivity;
//import com.example.calendarandroid.MainActivity;
//import com.example.calendarandroid.R;
//
//public class PreviousStateCommented {
//    package com.example.calendarandroid;
//
//import android.animation.ArgbEvaluator;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.example.calendarandroid.Utils.Utility;
//
//    public class FirstLaunchActivity extends LifecycleLoggingActivity {
//
////    The {@link android.support.v4.view.PagerAdapter} that will provide
////    fragments for each of the sections. We use a
////    {@link FragmentPagerAdapter} derivative, which will keep every
////    loaded fragment in memory. If this becomes too memory intensive, it
////    may be best to switch to a
////    {@link android.support.v4.app.FragmentStatePagerAdapter}.
//
//
//        //    The {@link ViewPager} that will host the section contents.
//        private ViewPager mViewPager;
//        private ImageButton mNextBtn;
//        private Button mSkipBtn, mFinishBtn;
//        private ImageView zero, one, two;
//        private com.example.calendarandroid.FirstLaunchActivity.SectionsPagerAdapter mSectionsPagerAdapter;
//        private ImageView[] indicators;
////    int lastLeftValue = 0;
////    CoordinatorLayout mCoordinator;
//
//        //    static final String TAG = "PagerActivity";
//        private int pageNumber = 0;
//
//        @Override
//        protected void onCreate(final Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//            setContentView(R.layout.activity_first_launch);
//
//            setAllComponents();
//
////        getWindow().getDecorView().setSystemUiVisibility(
////                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
////        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_trans80));
////        setContentView(R.layout.activity_first_launch);
//            // Create the adapter that will return a fragment for each of the three
//            // primary sections of the activity.
////        mCoordinator = findViewById(R.id.first_launch_main_content);
//
//
//            // Set up the ViewPager with the sections adapter.
//            mViewPager.setAdapter(mSectionsPagerAdapter);
//            mViewPager.setCurrentItem(pageNumber);
//            updateIndicators(pageNumber);
//
//            final int color1 = ContextCompat.getColor(this, R.color.violet);
//            final int color2 = ContextCompat.getColor(this, R.color.orange);
//            final int color3 = ContextCompat.getColor(this, R.color.green);
//
//            final int[] colorList = new int[]{color1, color2, color3};
//
//            final ArgbEvaluator evaluator = new ArgbEvaluator();
//
//            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//                @Override
//                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////                color update
//                    int colorUpdate = (Integer) evaluator.evaluate(
//                            positionOffset, colorList[position], colorList[position == 2 ? position : position + 1]);
//                    mViewPager.setBackgroundColor(colorUpdate);
//                }
//
//                @Override
//                public void onPageSelected(int currentPageNumber) {
//
//                    pageNumber = currentPageNumber;
//
//                    updateIndicators(currentPageNumber);
//
//                    switch (currentPageNumber) {
//                        case 0:
//                            mViewPager.setBackgroundColor(color1);
//                            break;
//                        case 1:
//                            mViewPager.setBackgroundColor(color2);
//                            break;
//                        case 2:
//                            mViewPager.setBackgroundColor(color3);
//                            break;
//                    }
//
//                    mNextBtn.setVisibility(currentPageNumber == 2 ? View.GONE : View.VISIBLE);
//                    mFinishBtn.setVisibility(currentPageNumber == 2 ? View.VISIBLE : View.GONE);
//
//                }
//
//                @Override
//                public void onPageScrollStateChanged(int state) {
//                }
//            });
//
//            mNextBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pageNumber += 1;
//                    mViewPager.setCurrentItem(pageNumber, true);
//                }
//            });
//
//            mSkipBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Utility.setSharedSetting(com.example.calendarandroid.FirstLaunchActivity.this, MainActivity.PREF_USER_FIRST_TIME, false);
//                    Intent backToMain = new Intent(com.example.calendarandroid.FirstLaunchActivity.this, MainActivity.class);
//                    startActivity(backToMain);
////                finish();
//                }
//            });
//
//            mFinishBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //  update 1st time pref
//                    Utility.setSharedSetting(com.example.calendarandroid.FirstLaunchActivity.this, MainActivity.PREF_USER_FIRST_TIME, false);
//                    Intent backToMain = new Intent(com.example.calendarandroid.FirstLaunchActivity.this, MainActivity.class);
//                    startActivity(backToMain);
////                finish();
//                }
//            });
//
//        }
//
//        private void updateIndicators(int currentPageNumber) {
//            for (int i = 0; i < indicators.length; i++) {
//                indicators[i].setBackgroundResource(
//                        i == currentPageNumber ? R.drawable.indicator_selected : R.drawable.intro_unselected_page_indicator
//                );
//            }
//        }
//
//        private void setAllComponents(){
//
//            mSectionsPagerAdapter = new com.example.calendarandroid.FirstLaunchActivity.SectionsPagerAdapter(getSupportFragmentManager());
//
//            mNextBtn = findViewById(R.id.intro_btn_next);
//            mSkipBtn = findViewById(R.id.intro_btn_skip);
//            mFinishBtn = findViewById(R.id.intro_btn_finish);
//
//            zero = findViewById(R.id.intro_indicator_0);
//            one = findViewById(R.id.intro_indicator_1);
//            two = findViewById(R.id.intro_indicator_2);
//
//            indicators = new ImageView[]{zero, one, two};
//
//            mViewPager = findViewById(R.id.container);
//        }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.menu_first_launch, menu);
////        return true;
////    }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        // Handle action bar item clicks here. The action bar will
////        // automatically handle clicks on the Home/Up button, so long
////        // as you specify a parent activity in AndroidManifest.xml.
////        int id = item.getItemId();
////
////        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
////
////        return super.onOptionsItemSelected(item);
////    }
//
//        //    A placeholder fragment containing a simple view.
//        public static class PlaceholderFragment extends Fragment {
//
//            //        The fragment argument representing the section number for this
////        fragment.
//            private static final String ARG_SECTION_NUMBER = "section_number";
//
//            ImageView img;
//            TextView textView;
//            View rootView;
//
//            int[] bgs = new int[]{
//                    R.drawable.ic_flight_24dp,
//                    R.drawable.ic_mail_24dp,
//                    R.drawable.ic_explore_24dp};
////        public PlaceholderFragment() {}
//
//            //        Returns a new instance of this fragment for the given section
////        number.
//            public static com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment newInstance(int sectionNumber) {
//                com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment fragment = new com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment();
//                Bundle args = new Bundle();
//                args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//                fragment.setArguments(args);
//                return fragment;
//            }
//
//            @Override
//            public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                     Bundle savedInstanceState) {
//                rootView = inflater.inflate(R.layout.fragment_first_launch, container, false);
//                textView = rootView.findViewById(R.id.intro_label);
//                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//
//                img = rootView.findViewById(R.id.section_img);
//                img.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
//
//
//                return rootView;
//            }
//
//
//        }
//
//        /**
//         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//         * one of the sections/tabs/pages.
//         */
//        public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//            private SectionsPagerAdapter(FragmentManager fm) {
//                super(fm);
//            }
//
//            @Override
//            public Fragment getItem(int currentPageNumber) {
//                // getItem is called to instantiate the fragment for the given pageNumber.
//                // Return a PlaceholderFragment (defined as a static inner class below).
//                return com.example.calendarandroid.FirstLaunchActivity.PlaceholderFragment.newInstance(currentPageNumber + 1);
//            }
//
//            @Override
//            public int getCount() {
//                // Show 3 total pages.
//                return 3;
//            }
//
//            @Override
//            public CharSequence getPageTitle(int currentPageNumber) {
//                switch (currentPageNumber) {
//                    case 0:
//                        return "SECTION 1";
//                    case 1:
//                        return "SECTION 2";
//                    case 2:
//                        return "SECTION 3";
//                }
//                return null;
//            }
//
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    package com.example.calendarandroid;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.preference.PreferenceManager;
//import android.support.v7.app.AppCompatActivity;
//
//import com.example.calendarandroid.Utils.Utility;
//
//    public class MainActivity extends LifecycleLoggingActivity {
//
//        public static final String PREF_USER_FIRST_TIME = "user_first_time";
//
////    FirstLaunchActivity firstLaunchChecker;
//
////    SharedPreferences sharedPreferencesEditor;
//
//        private boolean isFirstLaunch=true;
//
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////        Utility.setSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, true);
//            isFirstLaunch = checkIfFirstLaunch();
////        isFirstLaunch = sharedPreferencesEditor.getBoolean(PREF_USER_FIRST_TIME, true);
////        isFirstLaunch = getSharedPreferences(PREF_USER_FIRST_TIME,);
////        sharedPreferencesEditor = Utility.setSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, true);
//            if(isFirstLaunch)
//            {
//                Intent firstLaunchIntent = new Intent(com.example.calendarandroid.MainActivity.this, com.example.calendarandroid.FirstLaunchActivity.class);
//                startActivity(firstLaunchIntent);
//                isFirstLaunch=false;
//            }
////        setContentView(R.layout.activity_main);
//        }
//
//        private boolean checkIfFirstLaunch(){
////        sharedPreferencesEditor = getSharedPreferences(PREF_USER_FIRST_TIME, MODE_PRIVATE);
//            if (isFirstLaunch)
//            {
//                Utility.setSharedSetting(com.example.calendarandroid.MainActivity.this, PREF_USER_FIRST_TIME, true);
//            }
//            return Utility.getSharedSetting(com.example.calendarandroid.MainActivity.this, PREF_USER_FIRST_TIME, isFirstLaunch);
////        if(Utility.getSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME)) {
//////            Intent onboarding = new Intent(this, FirstLaunchActivity.class);
//////            startActivity(onboarding);
////        }
//        }
//
////    @Override
////    protected void onFinishFragment() {
////        super.onFinishFragment();
////        // User has seen OnboardingFragment, so mark our SharedPreferences
////        // flag as completed so that we don't show our OnboardingFragment
////        // the next time the user launches the app.
////        SharedPreferences.Editor sharedPreferencesEditor =
////                PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
////        sharedPreferencesEditor.putBoolean(
////                COMPLETED_ONBOARDING_PREF_NAME, true);
////        sharedPreferencesEditor.apply();
////    }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    <?xml version="1.0" encoding="utf-8"?>
//<manifest xmlns:android="http://schemas.android.com/apk/res/android"
//            package="com.example.calendarandroid">
//
//    <application
//    android:allowBackup="true"
//    android:icon="@mipmap/ic_launcher"
//    android:label="@string/app_name"
//    android:roundIcon="@mipmap/ic_launcher_round"
//    android:supportsRtl="true"
//    android:fullBackupContent="false"
//    android:theme="@style/AppTheme2">
//        <activity android:name=".MainActivity" android:label="@string/title_activity_main">
//            <intent-filter>
//                <action android:name="android.intent.action.MAIN" />
//                <action android:name="android.intent.action.VIEW" />
//                <category android:name="android.intent.category.LAUNCHER" />
//            </intent-filter>
//        </activity>
//        <activity android:name=".FirstLaunchActivity"
//    android:label="@string/title_activity_first_launch"
//    android:theme="@style/AppTheme2.NoActionBarr">
//            <intent-filter>
//                <action android:name="android.intent.action.MAIN" />
//                <category android:name="android.intent.category.LAUNCHER" />
//            </intent-filter>
//        </activity>
//
//    </application>
//
//</manifest>
//}








//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//package com.example.calendarandroid;
//
//import android.animation.ArgbEvaluator;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.CoordinatorLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.example.calendarandroid.Utils.Utility;
//
//public class FirstLaunchActivity extends LifecycleLoggingActivity {
//
//
//    private ViewPager mViewPager;
//    private ImageButton mNextBtn;
//    private Button mSkipBtn, mFinishBtn;
//
//    private SectionsPagerAdapter mSectionsPagerAdapter;
//    private ImageView[] indicators;
//    CoordinatorLayout mCoordinator;
//    private int pageNumber = 0;
//
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setAllComponents();
////        setContentView(R.layout.activity_first_launch);
//
//        ImageView zero, one, two;
//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        mNextBtn = findViewById(R.id.intro_btn_next);
//        mSkipBtn = findViewById(R.id.intro_btn_skip);
//        mFinishBtn = findViewById(R.id.intro_btn_finish);
//
//        zero = findViewById(R.id.intro_indicator_0);
//        one = findViewById(R.id.intro_indicator_1);
//        two = findViewById(R.id.intro_indicator_2);
//
//        indicators = new ImageView[]{zero, one, two};
//
//        mViewPager = findViewById(R.id.container);
//
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_trans80));
//
//        setContentView(R.layout.activity_first_launch);
////         Create the adapter that will return a fragment for each of the three
////         primary sections of the activity.
//        mCoordinator = findViewById(R.id.first_launch_main_content);
//
//
//        // Set up the ViewPager with the sections adapter.
//        mViewPager.setAdapter(mSectionsPagerAdapter);
//        mViewPager.setCurrentItem(pageNumber);
//        updateIndicators(pageNumber);
//
//        final int color1 = ContextCompat.getColor(this, R.color.violet);
//        final int color2 = ContextCompat.getColor(this, R.color.orange);
//        final int color3 = ContextCompat.getColor(this, R.color.green);
//
//        final int[] colorList = new int[]{color1, color2, color3};
//
//        final ArgbEvaluator evaluator = new ArgbEvaluator();
//
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////                color update
//                int colorUpdate = (Integer) evaluator.evaluate(
//                        positionOffset, colorList[position], colorList[position == 2 ? position : position + 1]);
//                mViewPager.setBackgroundColor(colorUpdate);
//            }
//
//            @Override
//            public void onPageSelected(int currentPageNumber) {
//
//                pageNumber = currentPageNumber;
//
//                updateIndicators(currentPageNumber);
//
//                switch (currentPageNumber) {
//                    case 0:
//                        mViewPager.setBackgroundColor(color1);
//                        break;
//                    case 1:
//                        mViewPager.setBackgroundColor(color2);
//                        break;
//                    case 2:
//                        mViewPager.setBackgroundColor(color3);
//                        break;
//                }
//
//                mNextBtn.setVisibility(currentPageNumber == 2 ? View.GONE : View.VISIBLE);
//                mFinishBtn.setVisibility(currentPageNumber == 2 ? View.VISIBLE : View.GONE);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
//
//        mNextBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pageNumber += 1;
//                mViewPager.setCurrentItem(pageNumber, true);
//            }
//        });
//
//        mSkipBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Utility.setSharedSetting(FirstLaunchActivity.this, MainActivity.PREF_USER_FIRST_TIME, false);
//                Intent backToMain = new Intent(FirstLaunchActivity.this, MainActivity.class);
//                startActivity(backToMain);
////                finish();
//            }
//        });
//
//        mFinishBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //  update 1st time pref
//                Utility.setSharedSetting(FirstLaunchActivity.this, MainActivity.PREF_USER_FIRST_TIME, false);
//                Intent backToMain = new Intent(FirstLaunchActivity.this, MainActivity.class);
//                startActivity(backToMain);
////                finish();
//            }
//        });
//
//    }
//
//    private void updateIndicators(int currentPageNumber) {
//        for (int i = 0; i < indicators.length; i++) {
//            indicators[i].setBackgroundResource(
//                    i == currentPageNumber ? R.drawable.indicator_selected : R.drawable.intro_unselected_page_indicator
//            );
//        }
//    }
//
//    private void setAllComponents(){
//        ImageView zero, one, two;
//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        mNextBtn = findViewById(R.id.intro_btn_next);
//        mSkipBtn = findViewById(R.id.intro_btn_skip);
//        mFinishBtn = findViewById(R.id.intro_btn_finish);
//
//        zero = findViewById(R.id.intro_indicator_0);
//        one = findViewById(R.id.intro_indicator_1);
//        two = findViewById(R.id.intro_indicator_2);
//
//        indicators = new ImageView[]{zero, one, two};
//
//        mViewPager = findViewById(R.id.container);
//    }
//
//    //    A placeholder fragment containing a simple view.
//    public static class PlaceholderFragment extends Fragment {
//
//        //        The fragment argument representing the section number for this
////        fragment.
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        ImageView img;
//        TextView textView;
//        View rootView;
//
//        int[] bgs = new int[]{
//                R.drawable.ic_flight_24dp,
//                R.drawable.ic_mail_24dp,
//                R.drawable.ic_explore_24dp};
//
//        //        Returns a new instance of this fragment for the given section
////        number.
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            rootView = inflater.inflate(R.layout.fragment_first_launch, container, false);
//            textView = rootView.findViewById(R.id.intro_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//
//            img = rootView.findViewById(R.id.section_img);
//            img.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
//
//
//            return rootView;
//        }
//
//
//    }
//
//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        private SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int currentPageNumber) {
//            // getItem is called to instantiate the fragment for the given pageNumber.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(currentPageNumber + 1);
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 3;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int currentPageNumber) {
//            switch (currentPageNumber) {
//                case 0:
//                    return "SECTION 1";
//                case 1:
//                    return "SECTION 2";
//                case 2:
//                    return "SECTION 3";
//            }
//            return null;
//        }
//
//    }
//}







//menu_first_launch.xml
//<menu xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        xmlns:tools="http://schemas.android.com/tools">
//        tools:context="com.example.calendarandroid.MainActivity">
//<item
//        android:id="@+id/action_settings"
//                android:orderInCategory="100"
//                android:title="@string/action_settings"
//                app:showAsAction="never" />
//</menu>













//
//
//
////toolbar_w_shadow.xml
//<?xml version="1.0" encoding="utf-8"?>-->
//<!--<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"-->
//<!--xmlns:app="http://schemas.android.com/apk/res-auto"-->
//<!--android:layout_width="match_parent"-->
//<!--android:layout_height="wrap_content"-->
//<!--android:orientation="vertical">-->
//
//<!--&lt;!&ndash;<android.support.v7.widget.Toolbar&ndash;&gt;-->
//<!--&lt;!&ndash;android:id="@+id/toolbar_elevated"&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_width="match_parent"&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_height="?attr/actionBarSize"&ndash;&gt;-->
//<!--&lt;!&ndash;android:background="?attr/colorPrimary"&ndash;&gt;-->
//<!--&lt;!&ndash;android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"&ndash;&gt;-->
//<!--&lt;!&ndash;app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />&ndash;&gt;-->
//
//<!--&lt;!&ndash;<View&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_width="match_parent"&ndash;&gt;-->
//<!--&lt;!&ndash;android:layout_height="4dp"&ndash;&gt;-->
//<!--&lt;!&ndash;android:background="@drawable/shadow" />&ndash;&gt;-->
//
//
//<!--</LinearLayout>