package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public class d0 {
    public static int a(int i10) {
        if (i10 < 200 || i10 > 299) {
            return ((i10 < 300 || i10 > 399) && i10 >= 400 && i10 <= 499) ? 0 : 1;
        }
        return 0;
    }
}
