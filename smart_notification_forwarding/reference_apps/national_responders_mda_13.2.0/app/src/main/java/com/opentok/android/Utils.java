package com.opentok.android;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    static boolean f8543a;

    static {
        g.a();
        f8543a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(boolean z10) {
        return z10 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, BaseAudioDevice baseAudioDevice, boolean z10, boolean z11, boolean z12, boolean z13) {
        if (f8543a) {
            return;
        }
        init_otc_engine(context, baseAudioDevice, z10, z11, z12, z13);
        f8543a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(int i10) {
        return i10 != 0;
    }

    static native void init_otc_engine(Context context, BaseAudioDevice baseAudioDevice, boolean z10, boolean z11, boolean z12, boolean z13);
}
