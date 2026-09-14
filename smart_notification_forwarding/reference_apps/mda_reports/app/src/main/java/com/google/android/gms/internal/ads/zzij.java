package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes.dex */
public final class zzij extends zzkw implements zzog {
    private int zzafo;
    private int zzafq;
    private final zzhr zzakq;
    private final zzhw zzakr;
    private boolean zzaks;
    private boolean zzakt;
    private MediaFormat zzaku;
    private long zzakv;
    private boolean zzakw;

    public zzij(zzky zzkyVar) {
        this(zzkyVar, null, true);
    }

    private zzij(zzky zzkyVar, zzja<zzjc> zzjaVar, boolean z) {
        this(zzkyVar, null, true, null, null);
    }

    private zzij(zzky zzkyVar, zzja<zzjc> zzjaVar, boolean z, zzddu zzdduVar, zzho zzhoVar) {
        this(zzkyVar, null, true, null, null, null, new zzhm[0]);
    }

    private zzij(zzky zzkyVar, zzja<zzjc> zzjaVar, boolean z, zzddu zzdduVar, zzho zzhoVar, zzhn zzhnVar, zzhm... zzhmVarArr) {
        super(1, zzkyVar, zzjaVar, z);
        this.zzakr = new zzhw(null, zzhmVarArr, new zzil(this));
        this.zzakq = new zzhr(null, null);
    }

    public static void a(int i) {
    }

    public static void a(int i, long j, long j2) {
    }

    public static /* synthetic */ boolean a(zzij zzijVar, boolean z) {
        zzijVar.zzakw = true;
        return true;
    }

    public static void l() {
    }

    private final boolean zzbc(String str) {
        return this.zzakr.zzba(str);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final int a(zzky zzkyVar, zzgw zzgwVar) {
        int i;
        int i2;
        String str = zzgwVar.zzafe;
        if (!zzof.zzbh(str)) {
            return 0;
        }
        int i3 = zzoq.SDK_INT >= 21 ? 16 : 0;
        if (zzbc(str) && zzkyVar.zzhb() != null) {
            return i3 | 4 | 3;
        }
        zzkt zzb = zzkyVar.zzb(str, false);
        boolean z = true;
        if (zzb == null) {
            return 1;
        }
        if (zzoq.SDK_INT >= 21 && (((i = zzgwVar.zzafp) != -1 && !zzb.zzaq(i)) || ((i2 = zzgwVar.zzafo) != -1 && !zzb.zzar(i2)))) {
            z = false;
        }
        return i3 | 4 | (z ? 3 : 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw
    public final zzkt a(zzky zzkyVar, zzgw zzgwVar, boolean z) {
        zzkt zzhb;
        if (!zzbc(zzgwVar.zzafe) || (zzhb = zzkyVar.zzhb()) == null) {
            this.zzaks = false;
            return super.a(zzkyVar, zzgwVar, z);
        }
        this.zzaks = true;
        return zzhb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void a(long j, boolean z) {
        super.a(j, z);
        this.zzakr.reset();
        this.zzakv = j;
        this.zzakw = true;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int[] iArr;
        int i;
        boolean z = this.zzaku != null;
        String string = z ? this.zzaku.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzaku;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.zzakt && integer == 6 && (i = this.zzafo) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzafo; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        try {
            this.zzakr.zza(string, integer, integer2, this.zzafq, 0, iArr);
        } catch (zzia e) {
            throw zzgl.zza(e, a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw
    public final void a(zzgw zzgwVar) {
        super.a(zzgwVar);
        this.zzakq.zzc(zzgwVar);
        this.zzafq = "audio/raw".equals(zzgwVar.zzafe) ? zzgwVar.zzafq : 2;
        this.zzafo = zzgwVar.zzafo;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void a(zzkt zzktVar, MediaCodec mediaCodec, zzgw zzgwVar, MediaCrypto mediaCrypto) {
        this.zzakt = zzoq.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzktVar.name) && "samsung".equals(zzoq.MANUFACTURER) && (zzoq.DEVICE.startsWith("zeroflte") || zzoq.DEVICE.startsWith("herolte") || zzoq.DEVICE.startsWith("heroqlte"));
        if (!this.zzaks) {
            mediaCodec.configure(zzgwVar.zzeq(), (Surface) null, (MediaCrypto) null, 0);
            this.zzaku = null;
        } else {
            this.zzaku = zzgwVar.zzeq();
            this.zzaku.setString("mime", "audio/raw");
            mediaCodec.configure(this.zzaku, (Surface) null, (MediaCrypto) null, 0);
            this.zzaku.setString("mime", zzgwVar.zzafe);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void a(String str, long j, long j2) {
        this.zzakq.zzb(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void a(boolean z) {
        super.a(z);
        this.zzakq.zzc(this.a);
        int i = e().zzagh;
        if (i != 0) {
            this.zzakr.zzt(i);
        } else {
            this.zzakr.zzfj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.zzaks && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.a.zzamj++;
            this.zzakr.zzfe();
            return true;
        }
        try {
            if (!this.zzakr.zza(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.a.zzami++;
            return true;
        } catch (zzid | zzie e) {
            throw zzgl.zza(e, a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void b() {
        super.b();
        this.zzakr.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void c() {
        this.zzakr.pause();
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void d() {
        try {
            this.zzakr.release();
            try {
                super.d();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.d();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void g() {
        try {
            this.zzakr.zzff();
        } catch (zzie e) {
            throw zzgl.zza(e, a());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzhf
    public final boolean isReady() {
        return this.zzakr.zzfh() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzgj, com.google.android.gms.internal.ads.zzgm
    public final void zza(int i, Object obj) {
        if (i == 2) {
            this.zzakr.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzakr.setStreamType(((Integer) obj).intValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final zzhc zzb(zzhc zzhcVar) {
        return this.zzakr.zzb(zzhcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgj, com.google.android.gms.internal.ads.zzhf
    public final zzog zzdq() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzhf
    public final boolean zzeu() {
        return super.zzeu() && this.zzakr.zzeu();
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final zzhc zzfi() {
        return this.zzakr.zzfi();
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final long zzfp() {
        long zzj = this.zzakr.zzj(zzeu());
        if (zzj != Long.MIN_VALUE) {
            if (!this.zzakw) {
                zzj = Math.max(this.zzakv, zzj);
            }
            this.zzakv = zzj;
            this.zzakw = false;
        }
        return this.zzakv;
    }
}
