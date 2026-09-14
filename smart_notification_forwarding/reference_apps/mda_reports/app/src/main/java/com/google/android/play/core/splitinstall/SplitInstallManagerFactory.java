package com.google.android.play.core.splitinstall;

import android.content.Context;

/* loaded from: classes.dex */
public class SplitInstallManagerFactory {
    public static SplitInstallManager create(Context context) {
        return new p(new r(context), context);
    }
}
