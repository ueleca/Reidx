package com.uele.reidx.android.utils;

import android.app.Activity;
import android.content.Context;

import com.uele.reidx.android.R;

public class ThemeUtils {

    public static void changTheme(Activity activity, Theme theme) {
        if (activity == null)
            return;
        int style = R.style.BlueTheme;
        switch (theme) {
            case BLUE:
                style = R.style.BlueTheme;
                break;
            case BLUE_GREY:
                style = R.style.BlueGreyTheme;
                break;
            default:
                break;
        }
        activity.setTheme(style);
    }

    public static Theme getCurrentTheme(Context context) {
        int value = PreferenceUtils.getInstance(context)
                .getIntParam(context.getString(R.string.change_theme_key), 0);
        return ThemeUtils.Theme.mapValueToTheme(value);
    }

    public enum Theme {

        BLUE(0x00),
        BLUE_GREY(0x01);

        private int mValue;

        Theme(int value) {
            this.mValue = value;
        }

        public static Theme mapValueToTheme(final int value) {
            for (Theme theme : Theme.values()) {
                if (value == theme.getIntValue()) {
                    return theme;
                }
            }
            // If run here, return default
            return BLUE;
        }

        static Theme getDefault() {
            return BLUE;
        }

        public int getIntValue() {
            return mValue;
        }
    }
}