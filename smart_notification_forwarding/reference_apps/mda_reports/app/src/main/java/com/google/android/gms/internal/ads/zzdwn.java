package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class zzdwn extends zzdwl implements zzbf {
    private int flags;
    private int version;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdwn(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long a(ByteBuffer byteBuffer) {
        this.version = zzbg.zza(byteBuffer.get());
        this.flags = (zzbg.zzb(byteBuffer) << 8) + 0 + zzbg.zza(byteBuffer.get());
        return 4L;
    }

    public final int getVersion() {
        if (!this.a) {
            zzbdj();
        }
        return this.version;
    }
}
