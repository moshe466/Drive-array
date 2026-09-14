package com.google.android.play.core.appupdate;

import android.content.Context;

/* loaded from: classes.dex */
public class AppUpdateManagerFactory {
    public static AppUpdateManager create(Context context) {
        return new b(new c(context), context);
    }
}
