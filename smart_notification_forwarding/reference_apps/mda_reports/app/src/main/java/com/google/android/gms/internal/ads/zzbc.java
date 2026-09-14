package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzbc implements zzbe {
    private static Logger zzcp = Logger.getLogger(zzbc.class.getName());
    private ThreadLocal<ByteBuffer> zzcq = new zzbb(this);

    @Override // com.google.android.gms.internal.ads.zzbe
    public final zzbf zza(zzdws zzdwsVar, zzbi zzbiVar) {
        int read;
        long size;
        long position = zzdwsVar.position();
        this.zzcq.get().rewind().limit(8);
        do {
            read = zzdwsVar.read(this.zzcq.get());
            if (read == 8) {
                this.zzcq.get().rewind();
                long zza = zzbg.zza(this.zzcq.get());
                byte[] bArr = null;
                if (zza < 8 && zza > 1) {
                    Logger logger = zzcp;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zza);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String zzf = zzbg.zzf(this.zzcq.get());
                if (zza == 1) {
                    this.zzcq.get().limit(16);
                    zzdwsVar.read(this.zzcq.get());
                    this.zzcq.get().position(8);
                    size = zzbg.zzc(this.zzcq.get()) - 16;
                } else {
                    size = zza == 0 ? zzdwsVar.size() - zzdwsVar.position() : zza - 8;
                }
                if ("uuid".equals(zzf)) {
                    this.zzcq.get().limit(this.zzcq.get().limit() + 16);
                    zzdwsVar.read(this.zzcq.get());
                    bArr = new byte[16];
                    for (int position2 = this.zzcq.get().position() - 16; position2 < this.zzcq.get().position(); position2++) {
                        bArr[position2 - (this.zzcq.get().position() - 16)] = this.zzcq.get().get(position2);
                    }
                    size -= 16;
                }
                long j = size;
                zzbf zza2 = zza(zzf, bArr, zzbiVar instanceof zzbf ? ((zzbf) zzbiVar).getType() : "");
                zza2.zza(zzbiVar);
                this.zzcq.get().rewind();
                zza2.zza(zzdwsVar, this.zzcq.get(), j, this);
                return zza2;
            }
        } while (read >= 0);
        zzdwsVar.zzfc(position);
        throw new EOFException();
    }

    public abstract zzbf zza(String str, byte[] bArr, String str2);
}
