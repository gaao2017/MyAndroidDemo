package com.gao.myandroiddemo.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gao.myandroiddemo.R;

/**
 * Created by gao on 2017/6/15.
 */

public class ToastUtils {
    private static int GRAVITY = Gravity.CENTER;

    public static void showLong(Context context, String message) {
        show(context, message, Toast.LENGTH_LONG);
    }

    public static void showShort(Context context, String message) {
        show(context, message, Toast.LENGTH_SHORT);
    }

    public static void showLong(Context context, int textId) {
        show(context, textId, Toast.LENGTH_LONG);
    }

    public static void showShort(Context context, int textId) {
        show(context, textId, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, String text, int duration) {
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(GRAVITY, 80, 80);
        toast.show();
    }

    public static void show(Context context, int textId, int duration) {
        Toast toast = Toast.makeText(context, textId, duration);
        toast.setGravity(GRAVITY, 80, 80);
        toast.show();
    }

    public static void showSuccess(Context context, int textId) {
        showIconToast(context, textId, R.drawable.ic_success, R.color.blue);
    }

    public static void showFailure(Context context, int textId) {
        showIconToast(context, textId, R.drawable.ic_failure, R.color.white);
    }

    public static void showIconToast(Context context, int textId, int iconId,
                                     int colorId) {
        LayoutInflater
                inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast, null);
        ((TextView) layout).setText(textId);
        ((TextView) layout).setTextColor(context.getResources().getColor(
                colorId));
        ((TextView) layout).setCompoundDrawablesWithIntrinsicBounds(iconId, 0,
                0, 0);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
