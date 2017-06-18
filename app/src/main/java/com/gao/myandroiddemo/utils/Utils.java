package com.gao.myandroiddemo.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by gao on 2017/6/15.
 */

public class Utils {
    // Toast
    private static Toast toast;


    enum Type {
        key, value;

    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }


    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (null == toast) {
            toast = Toast.makeText(context, message, duration);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        if (null == toast) {
            toast = Toast.makeText(context, message, duration);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * Hide the toast, if any.
     */
    public static void hideToast() {
        if (null != toast) {
            toast.cancel();
        }
    }

    public static void showMsg() {
        //https://github.com/johnkil/Android-AppMsg
    }

//    public static void showShort(String message) {
//        if (null == toast) {
//            toast = Toast.makeText(AppApplication.getApp(), message, Toast.LENGTH_SHORT);
//            // toast.setGravity(Gravity.CENTER, 0, 0);
//        } else {
//            toast.setText(message);
//        }
//        toast.show();
//    }
//
//    public static void showShort(int message) {
//        if (null == toast) {
//            toast = Toast.makeText(AppApplication.getApp(), message, Toast.LENGTH_SHORT);
//            // toast.setGravity(Gravity.CENTER, 0, 0);
//        } else {
//            toast.setText(message);
//        }
//        toast.show();
//    }

}



