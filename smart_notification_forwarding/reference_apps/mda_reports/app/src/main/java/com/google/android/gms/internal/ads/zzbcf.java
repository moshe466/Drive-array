package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzbcf {
    private long zzcw;

    public final long zzl(ByteBuffer byteBuffer) {
        zzbk zzbkVar;
        zzbh zzbhVar;
        long j = this.zzcw;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbf> it = new zzbd(new zzbcc(duplicate), zzbch.a).zzbdl().iterator();
            while (true) {
                zzbkVar = null;
                if (!it.hasNext()) {
                    zzbhVar = null;
                    break;
                }
                zzbf next = it.next();
                if (next instanceof zzbh) {
                    zzbhVar = (zzbh) next;
                    break;
                }
            }
            Iterator<zzbf> it2 = zzbhVar.zzbdl().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbf next2 = it2.next();
                if (next2 instanceof zzbk) {
                    zzbkVar = (zzbk) next2;
                    break;
                }
            }
            this.zzcw = (zzbkVar.getDuration() * 1000) / zzbkVar.zzr();
            return this.zzcw;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
