package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes.dex */
public final class zzbk extends zzdwn {
    private Date zzct;
    private Date zzcu;
    private long zzcv;
    private long zzcw;
    private double zzcx;
    private float zzcy;
    private zzdwx zzcz;
    private long zzda;
    private int zzdb;
    private int zzdc;
    private int zzdd;
    private int zzde;
    private int zzdf;
    private int zzdg;

    public zzbk() {
        super("mvhd");
        this.zzcx = 1.0d;
        this.zzcy = 1.0f;
        this.zzcz = zzdwx.zzhzt;
    }

    public final long getDuration() {
        return this.zzcw;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzct + ";modificationTime=" + this.zzcu + ";timescale=" + this.zzcv + ";duration=" + this.zzcw + ";rate=" + this.zzcx + ";volume=" + this.zzcy + ";matrix=" + this.zzcz + ";nextTrackId=" + this.zzda + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzdwl
    public final void zzg(ByteBuffer byteBuffer) {
        long zza;
        a(byteBuffer);
        if (getVersion() == 1) {
            this.zzct = zzdwu.zzfv(zzbg.zzc(byteBuffer));
            this.zzcu = zzdwu.zzfv(zzbg.zzc(byteBuffer));
            this.zzcv = zzbg.zza(byteBuffer);
            zza = zzbg.zzc(byteBuffer);
        } else {
            this.zzct = zzdwu.zzfv(zzbg.zza(byteBuffer));
            this.zzcu = zzdwu.zzfv(zzbg.zza(byteBuffer));
            this.zzcv = zzbg.zza(byteBuffer);
            zza = zzbg.zza(byteBuffer);
        }
        this.zzcw = zza;
        this.zzcx = zzbg.zzd(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.zzcy = ((short) ((r0[1] & 255) | ((short) (0 | ((r0[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))))) / 256.0f;
        zzbg.zzb(byteBuffer);
        zzbg.zza(byteBuffer);
        zzbg.zza(byteBuffer);
        this.zzcz = zzdwx.zzp(byteBuffer);
        this.zzdb = byteBuffer.getInt();
        this.zzdc = byteBuffer.getInt();
        this.zzdd = byteBuffer.getInt();
        this.zzde = byteBuffer.getInt();
        this.zzdf = byteBuffer.getInt();
        this.zzdg = byteBuffer.getInt();
        this.zzda = zzbg.zza(byteBuffer);
    }

    public final long zzr() {
        return this.zzcv;
    }
}
