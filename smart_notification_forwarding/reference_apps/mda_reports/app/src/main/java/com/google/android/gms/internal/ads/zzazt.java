package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class zzazt {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzazs(view, onGlobalLayoutListener).attach();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzazv(view, onScrollChangedListener).attach();
    }
}
