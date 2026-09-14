package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhz extends Thread {
    private final /* synthetic */ AudioTrack zzajz;
    private final /* synthetic */ zzhw zzaka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhz(zzhw zzhwVar, AudioTrack audioTrack) {
        this.zzaka = zzhwVar;
        this.zzajz = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.zzajz.flush();
            this.zzajz.release();
        } finally {
            conditionVariable = this.zzaka.zzahw;
            conditionVariable.open();
        }
    }
}
