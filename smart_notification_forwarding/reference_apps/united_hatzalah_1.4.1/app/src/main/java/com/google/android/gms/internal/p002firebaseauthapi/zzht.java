package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
abstract class zzht {
    int[] zza;
    private final int zzb;

    public zzht(byte[] bArr, int i) {
        if (bArr.length == 32) {
            this.zza = zzhs.zza(bArr);
            this.zzb = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public abstract int zza();

    public final ByteBuffer zza(byte[] bArr, int i) {
        int[] zza = zza(zzhs.zza(bArr), i);
        int[] iArr = (int[]) zza.clone();
        zzhs.zza(iArr);
        for (int i3 = 0; i3 < zza.length; i3++) {
            zza[i3] = zza[i3] + iArr[i3];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zza, 0, 16);
        return order;
    }

    public abstract int[] zza(int[] iArr, int i);

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() >= bArr2.length) {
            zza(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    private final void zza(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (bArr.length == zza()) {
            int remaining = byteBuffer2.remaining();
            int i = remaining / 64;
            int i3 = i + 1;
            for (int i4 = 0; i4 < i3; i4++) {
                ByteBuffer zza = zza(bArr, this.zzb + i4);
                if (i4 == i) {
                    zzyt.zza(byteBuffer, byteBuffer2, zza, remaining % 64);
                } else {
                    zzyt.zza(byteBuffer, byteBuffer2, zza, 64);
                }
            }
            return;
        }
        throw new GeneralSecurityException(a.c(zza(), "The nonce length (in bytes) must be "));
    }

    public byte[] zza(byte[] bArr, ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        zza(bArr, allocate, byteBuffer);
        return allocate.array();
    }
}
