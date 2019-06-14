package com.example.calendarandroid.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.example.calendarandroid.MainActivity;
import com.example.calendarandroid.R;

public class Utility {

    private String mName;
    private String mDescription;
    private String mGuests;
    private String mLocation;

    private static final String PREFERENCES_FILE = "first_launch_settings";

    public static int getToolbarHeight(Context context) {
        int height = (int) context.getResources().getDimension(R.dimen.abc_action_bar_default_height_material);
        return height;
    }

    public static int getStatusBarHeight(Context context) {
        int height = (int) context.getResources().getDimension(R.dimen.statusbar_size);
        return height;
    }

    public static Drawable tintMyDrawable(Drawable drawable, int color) {
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, color);
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static void setSharedSetting(Context ctx, String settingName, boolean settingValue) {
        SharedPreferences sharedPref2 = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref2.edit();
        editor.putBoolean(settingName, settingValue);
        editor.apply();

    }

    public static Boolean getSharedSetting(Context ctx, String settingName, boolean defaultValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return sharedPref.getBoolean(settingName, defaultValue);
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getGuests() {
        return mGuests;
    }

    public void setGuests(String guests) {
        this.mGuests = guests;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

}
