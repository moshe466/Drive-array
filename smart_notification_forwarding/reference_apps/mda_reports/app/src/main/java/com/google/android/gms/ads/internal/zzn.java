package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzdq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzn implements View.OnTouchListener {
    private final /* synthetic */ zzl zzblk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzl zzlVar) {
        this.zzblk = zzlVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzdq zzdqVar;
        zzdq zzdqVar2;
        zzdqVar = this.zzblk.zzblr;
        if (zzdqVar == null) {
            return false;
        }
        zzdqVar2 = this.zzblk.zzblr;
        zzdqVar2.zza(motionEvent);
        return false;
    }
}
