package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class zzbj extends zzdwl {
    private ByteBuffer zzcs;

    public zzbj(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public final void zzg(ByteBuffer byteBuffer) {
        this.zzcs = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
