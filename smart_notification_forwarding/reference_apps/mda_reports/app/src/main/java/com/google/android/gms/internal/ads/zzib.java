package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(19)
/* loaded from: classes.dex */
public final class zzib extends zzhy {
    private final AudioTimestamp zzakb;
    private long zzakc;
    private long zzakd;
    private long zzake;

    public zzib() {
        super(null);
        this.zzakb = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzakc = 0L;
        this.zzakd = 0L;
        this.zzake = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final boolean zzfq() {
        boolean timestamp = this.a.getTimestamp(this.zzakb);
        if (timestamp) {
            long j = this.zzakb.framePosition;
            if (this.zzakd > j) {
                this.zzakc++;
            }
            this.zzakd = j;
            this.zzake = j + (this.zzakc << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final long zzfr() {
        return this.zzakb.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final long zzfs() {
        return this.zzake;
    }
}
