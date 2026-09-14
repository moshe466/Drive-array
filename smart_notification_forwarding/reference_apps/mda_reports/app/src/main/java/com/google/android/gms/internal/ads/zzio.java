package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* loaded from: classes.dex */
public final class zzio {
    public byte[] iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzalx;
    private int zzaly;
    private final MediaCodec.CryptoInfo zzalz;
    private final zziq zzama;

    public zzio() {
        this.zzalz = zzoq.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzama = zzoq.SDK_INT >= 24 ? new zziq(this.zzalz) : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.zzalx = 0;
        this.zzaly = 0;
        int i3 = zzoq.SDK_INT;
        if (i3 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzalz;
            cryptoInfo.numSubSamples = this.numSubSamples;
            cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
            cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            cryptoInfo.key = this.key;
            cryptoInfo.iv = this.iv;
            cryptoInfo.mode = this.mode;
            if (i3 >= 24) {
                this.zzama.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzfz() {
        return this.zzalz;
    }
}
