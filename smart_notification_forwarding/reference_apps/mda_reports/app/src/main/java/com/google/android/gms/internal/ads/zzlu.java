package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlu implements Runnable {
    private final /* synthetic */ zzlp zzbat;
    private final /* synthetic */ zzlv zzbav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlu(zzlp zzlpVar, zzlv zzlvVar) {
        this.zzbat = zzlpVar;
        this.zzbav = zzlvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        this.zzbav.release();
        sparseArray = this.zzbat.zzbad;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray2 = this.zzbat.zzbad;
            ((zzmj) sparseArray2.valueAt(i)).disable();
        }
    }
}
