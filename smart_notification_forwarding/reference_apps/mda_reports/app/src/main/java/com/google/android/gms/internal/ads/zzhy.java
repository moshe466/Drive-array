package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzhy {
    protected AudioTrack a;
    private int zzafp;
    private boolean zzajs;
    private long zzajt;
    private long zzaju;
    private long zzajv;
    private long zzajw;
    private long zzajx;
    private long zzajy;

    private zzhy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhy(zzhz zzhzVar) {
        this();
    }

    public final void pause() {
        if (this.zzajw != -9223372036854775807L) {
            return;
        }
        this.a.pause();
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.a = audioTrack;
        this.zzajs = z;
        this.zzajw = -9223372036854775807L;
        this.zzajt = 0L;
        this.zzaju = 0L;
        this.zzajv = 0L;
        if (audioTrack != null) {
            this.zzafp = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzajx = zzfo();
        this.zzajw = SystemClock.elapsedRealtime() * 1000;
        this.zzajy = j;
        this.a.stop();
    }

    public final long zzfo() {
        if (this.zzajw != -9223372036854775807L) {
            return Math.min(this.zzajy, this.zzajx + ((((SystemClock.elapsedRealtime() * 1000) - this.zzajw) * this.zzafp) / 1000000));
        }
        int playState = this.a.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.a.getPlaybackHeadPosition();
        if (this.zzajs) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzajv = this.zzajt;
            }
            playbackHeadPosition += this.zzajv;
        }
        if (this.zzajt > playbackHeadPosition) {
            this.zzaju++;
        }
        this.zzajt = playbackHeadPosition;
        return playbackHeadPosition + (this.zzaju << 32);
    }

    public final long zzfp() {
        return (zzfo() * 1000000) / this.zzafp;
    }

    public boolean zzfq() {
        return false;
    }

    public long zzfr() {
        throw new UnsupportedOperationException();
    }

    public long zzfs() {
        throw new UnsupportedOperationException();
    }
}
