package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcrf implements zzcub<zzcrc> {
    private final zzdhd zzfov;
    private final Context zzup;

    public zzcrf(zzdhd zzdhdVar, Context context) {
        this.zzfov = zzdhdVar;
        this.zzup = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcrc a() {
        AudioManager audioManager = (AudioManager) this.zzup.getSystemService("audio");
        return new zzcrc(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), com.google.android.gms.ads.internal.zzq.zzkv().zzpe(), com.google.android.gms.ads.internal.zzq.zzkv().zzpf());
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcrc> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcre
            private final zzcrf zzgfk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfk = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgfk.a();
            }
        });
    }
}
