package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes.dex */
public final class zzox extends zzkw {
    private static final int[] zzbhk = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    zzpc b;
    private int zzagh;
    private boolean zzajo;
    private final zzpb zzbhl;
    private final zzpg zzbhm;
    private final long zzbhn;
    private final int zzbho;
    private final boolean zzbhp;
    private final long[] zzbhq;
    private zzgw[] zzbhr;
    private zzoz zzbhs;
    private Surface zzbht;
    private Surface zzbhu;
    private int zzbhv;
    private boolean zzbhw;
    private long zzbhx;
    private long zzbhy;
    private int zzbhz;
    private int zzbia;
    private int zzbib;
    private float zzbic;
    private int zzbid;
    private int zzbie;
    private int zzbif;
    private float zzbig;
    private int zzbih;
    private int zzbii;
    private int zzbij;
    private float zzbik;
    private long zzbim;
    private int zzbin;
    private final Context zzup;

    public zzox(Context context, zzky zzkyVar, long j, zzddu zzdduVar, zzpd zzpdVar, int i) {
        this(context, zzkyVar, 0L, null, false, zzdduVar, zzpdVar, -1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzox(Context context, zzky zzkyVar, long j, zzja<zzjc> zzjaVar, boolean z, zzddu zzdduVar, zzpd zzpdVar, int i) {
        super(2, zzkyVar, null, false);
        boolean z2 = false;
        this.zzbhn = 0L;
        this.zzbho = -1;
        this.zzup = context.getApplicationContext();
        this.zzbhl = new zzpb(context);
        this.zzbhm = new zzpg(zzdduVar, zzpdVar);
        if (zzoq.SDK_INT <= 22 && "foster".equals(zzoq.DEVICE) && "NVIDIA".equals(zzoq.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbhp = z2;
        this.zzbhq = new long[10];
        this.zzbim = -9223372036854775807L;
        this.zzbhx = -9223372036854775807L;
        this.zzbid = -1;
        this.zzbie = -1;
        this.zzbig = -1.0f;
        this.zzbic = -1.0f;
        this.zzbhv = 1;
        zzjc();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zza(String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0 && c != 1) {
            if (c == 2) {
                if ("BRAVIA 4K 2015".equals(zzoq.MODEL)) {
                    return -1;
                }
                i3 = ((zzoq.zzf(i, 16) * zzoq.zzf(i2, 16)) << 4) << 4;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            }
            if (c != 3) {
                if (c != 4 && c != 5) {
                    return -1;
                }
                i3 = i * i2;
                return (i3 * 3) / (i4 * 2);
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzon.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzon.endSection();
        this.a.zzamj++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjd();
        zzon.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzon.endSection();
        this.a.zzami++;
        this.zzbia = 0;
        l();
    }

    private static boolean zza(boolean z, zzgw zzgwVar, zzgw zzgwVar2) {
        if (!zzgwVar.zzafe.equals(zzgwVar2.zzafe) || zzj(zzgwVar) != zzj(zzgwVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzgwVar.width == zzgwVar2.width && zzgwVar.height == zzgwVar2.height;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjd();
        zzon.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzon.endSection();
        this.a.zzami++;
        this.zzbia = 0;
        l();
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    private static int zzi(zzgw zzgwVar) {
        int i = zzgwVar.zzaff;
        return i != -1 ? i : zza(zzgwVar.zzafe, zzgwVar.width, zzgwVar.height);
    }

    private final void zziz() {
        this.zzbhx = this.zzbhn > 0 ? SystemClock.elapsedRealtime() + this.zzbhn : -9223372036854775807L;
    }

    private static int zzj(zzgw zzgwVar) {
        int i = zzgwVar.zzafj;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private final void zzja() {
        MediaCodec i;
        this.zzbhw = false;
        if (zzoq.SDK_INT < 23 || !this.zzajo || (i = i()) == null) {
            return;
        }
        this.b = new zzpc(this, i);
    }

    private final void zzjc() {
        this.zzbih = -1;
        this.zzbii = -1;
        this.zzbik = -1.0f;
        this.zzbij = -1;
    }

    private final void zzjd() {
        if (this.zzbih == this.zzbid && this.zzbii == this.zzbie && this.zzbij == this.zzbif && this.zzbik == this.zzbig) {
            return;
        }
        this.zzbhm.zzb(this.zzbid, this.zzbie, this.zzbif, this.zzbig);
        this.zzbih = this.zzbid;
        this.zzbii = this.zzbie;
        this.zzbij = this.zzbif;
        this.zzbik = this.zzbig;
    }

    private final void zzje() {
        if (this.zzbih == -1 && this.zzbii == -1) {
            return;
        }
        this.zzbhm.zzb(this.zzbid, this.zzbie, this.zzbif, this.zzbig);
    }

    private final void zzjf() {
        if (this.zzbhz > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbhm.zzf(this.zzbhz, elapsedRealtime - this.zzbhy);
            this.zzbhz = 0;
            this.zzbhy = elapsedRealtime;
        }
    }

    private final boolean zzn(boolean z) {
        if (zzoq.SDK_INT < 23 || this.zzajo) {
            return false;
        }
        return !z || zzot.zzc(this.zzup);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final int a(zzky zzkyVar, zzgw zzgwVar) {
        boolean z;
        int i;
        int i2;
        String str = zzgwVar.zzafe;
        if (!zzof.zzbi(str)) {
            return 0;
        }
        zziv zzivVar = zzgwVar.zzafh;
        if (zzivVar != null) {
            z = false;
            for (int i3 = 0; i3 < zzivVar.zzamn; i3++) {
                z |= zzivVar.zzaa(i3).zzamo;
            }
        } else {
            z = false;
        }
        zzkt zzb = zzkyVar.zzb(str, z);
        if (zzb == null) {
            return 1;
        }
        boolean zzbe = zzb.zzbe(zzgwVar.zzafb);
        if (zzbe && (i = zzgwVar.width) > 0 && (i2 = zzgwVar.height) > 0) {
            if (zzoq.SDK_INT >= 21) {
                zzbe = zzb.zza(i, i2, zzgwVar.zzafi);
            } else {
                zzbe = i * i2 <= zzla.zzhc();
                if (!zzbe) {
                    int i4 = zzgwVar.width;
                    int i5 = zzgwVar.height;
                    String str2 = zzoq.zzbgv;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i4);
                    sb.append("x");
                    sb.append(i5);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        return (zzbe ? 3 : 2) | (zzb.zzaxn ? 8 : 4) | (zzb.zzajo ? 16 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void a(long j, boolean z) {
        super.a(j, z);
        zzja();
        this.zzbia = 0;
        int i = this.zzbin;
        if (i != 0) {
            this.zzbim = this.zzbhq[i - 1];
            this.zzbin = 0;
        }
        if (z) {
            zziz();
        } else {
            this.zzbhx = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.zzbid = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(SettingsJsonConstants.ICON_WIDTH_KEY);
        this.zzbie = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(SettingsJsonConstants.ICON_HEIGHT_KEY);
        this.zzbig = this.zzbic;
        if (zzoq.SDK_INT >= 21) {
            int i = this.zzbib;
            if (i == 90 || i == 270) {
                int i2 = this.zzbid;
                this.zzbid = this.zzbie;
                this.zzbie = i2;
                this.zzbig = 1.0f / this.zzbig;
            }
        } else {
            this.zzbif = this.zzbib;
        }
        mediaCodec.setVideoScalingMode(this.zzbhv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw
    public final void a(zzgw zzgwVar) {
        super.a(zzgwVar);
        this.zzbhm.zzc(zzgwVar);
        float f = zzgwVar.zzafk;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.zzbic = f;
        this.zzbib = zzj(zzgwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void a(zzis zzisVar) {
        if (zzoq.SDK_INT >= 23 || !this.zzajo) {
            return;
        }
        l();
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void a(zzkt zzktVar, MediaCodec mediaCodec, zzgw zzgwVar, MediaCrypto mediaCrypto) {
        zzoz zzozVar;
        int i;
        Point point;
        float f;
        zzgw[] zzgwVarArr = this.zzbhr;
        int i2 = zzgwVar.width;
        int i3 = zzgwVar.height;
        int zzi = zzi(zzgwVar);
        if (zzgwVarArr.length == 1) {
            zzozVar = new zzoz(i2, i3, zzi);
        } else {
            int i4 = i3;
            int i5 = zzi;
            boolean z = false;
            int i6 = i2;
            for (zzgw zzgwVar2 : zzgwVarArr) {
                if (zza(zzktVar.zzaxn, zzgwVar, zzgwVar2)) {
                    z |= zzgwVar2.width == -1 || zzgwVar2.height == -1;
                    i6 = Math.max(i6, zzgwVar2.width);
                    int max = Math.max(i4, zzgwVar2.height);
                    i5 = Math.max(i5, zzi(zzgwVar2));
                    i4 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i6);
                sb.append("x");
                sb.append(i4);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzgwVar.height > zzgwVar.width;
                int i7 = z2 ? zzgwVar.height : zzgwVar.width;
                int i8 = z2 ? zzgwVar.width : zzgwVar.height;
                float f2 = i8 / i7;
                int[] iArr = zzbhk;
                int length = iArr.length;
                int i9 = 0;
                while (i9 < length) {
                    int i10 = length;
                    int i11 = iArr[i9];
                    int[] iArr2 = iArr;
                    int i12 = (int) (i11 * f2);
                    if (i11 <= i7 || i12 <= i8) {
                        break;
                    }
                    int i13 = i7;
                    int i14 = i8;
                    if (zzoq.SDK_INT >= 21) {
                        int i15 = z2 ? i12 : i11;
                        if (z2) {
                            i12 = i11;
                        }
                        Point zzd = zzktVar.zzd(i15, i12);
                        i = i5;
                        f = f2;
                        if (zzktVar.zza(zzd.x, zzd.y, zzgwVar.zzafi)) {
                            point = zzd;
                            break;
                        }
                        i9++;
                        length = i10;
                        iArr = iArr2;
                        i7 = i13;
                        i8 = i14;
                        i5 = i;
                        f2 = f;
                    } else {
                        i = i5;
                        f = f2;
                        int zzf = zzoq.zzf(i11, 16) << 4;
                        int zzf2 = zzoq.zzf(i12, 16) << 4;
                        if (zzf * zzf2 <= zzla.zzhc()) {
                            int i16 = z2 ? zzf2 : zzf;
                            if (z2) {
                                zzf2 = zzf;
                            }
                            point = new Point(i16, zzf2);
                        } else {
                            i9++;
                            length = i10;
                            iArr = iArr2;
                            i7 = i13;
                            i8 = i14;
                            i5 = i;
                            f2 = f;
                        }
                    }
                }
                i = i5;
                point = null;
                if (point != null) {
                    i6 = Math.max(i6, point.x);
                    i4 = Math.max(i4, point.y);
                    i5 = Math.max(i, zza(zzgwVar.zzafe, i6, i4));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i6);
                    sb2.append("x");
                    sb2.append(i4);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                } else {
                    i5 = i;
                }
            }
            zzozVar = new zzoz(i6, i4, i5);
        }
        this.zzbhs = zzozVar;
        zzoz zzozVar2 = this.zzbhs;
        boolean z3 = this.zzbhp;
        int i17 = this.zzagh;
        MediaFormat zzeq = zzgwVar.zzeq();
        zzeq.setInteger("max-width", zzozVar2.width);
        zzeq.setInteger("max-height", zzozVar2.height);
        int i18 = zzozVar2.zzbio;
        if (i18 != -1) {
            zzeq.setInteger("max-input-size", i18);
        }
        if (z3) {
            zzeq.setInteger("auto-frc", 0);
        }
        if (i17 != 0) {
            zzeq.setFeatureEnabled("tunneled-playback", true);
            zzeq.setInteger("audio-session-id", i17);
        }
        if (this.zzbht == null) {
            zzoc.checkState(zzn(zzktVar.zzaxo));
            if (this.zzbhu == null) {
                this.zzbhu = zzot.zzc(this.zzup, zzktVar.zzaxo);
            }
            this.zzbht = this.zzbhu;
        }
        mediaCodec.configure(zzeq, this.zzbht, (MediaCrypto) null, 0);
        if (zzoq.SDK_INT < 23 || !this.zzajo) {
            return;
        }
        this.b = new zzpc(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final void a(String str, long j, long j2) {
        this.zzbhm.zzb(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void a(boolean z) {
        super.a(z);
        this.zzagh = e().zzagh;
        this.zzajo = this.zzagh != 0;
        this.zzbhm.zzc(this.a);
        this.zzbhl.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgj
    public final void a(zzgw[] zzgwVarArr, long j) {
        this.zzbhr = zzgwVarArr;
        if (this.zzbim == -9223372036854775807L) {
            this.zzbim = j;
        } else {
            int i = this.zzbin;
            long[] jArr = this.zzbhq;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbin = i + 1;
            }
            this.zzbhq[this.zzbin - 1] = j;
        }
        super.a(zzgwVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.zzbin;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.zzbhq;
            if (j3 < jArr[0]) {
                break;
            }
            this.zzbim = jArr[0];
            this.zzbin = i3 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.zzbin);
        }
        long j4 = j3 - this.zzbim;
        if (z) {
            zza(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.zzbht == this.zzbhu) {
            if (!zzem(j5)) {
                return false;
            }
            zza(mediaCodec, i, j4);
            return true;
        }
        if (!this.zzbhw) {
            if (zzoq.SDK_INT >= 21) {
                zza(mediaCodec, i, j4, System.nanoTime());
            } else {
                zzb(mediaCodec, i, j4);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime();
        long zzf = this.zzbhl.zzf(j3, (elapsedRealtime * 1000) + nanoTime);
        long j6 = (zzf - nanoTime) / 1000;
        if (zzem(j6)) {
            zzon.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzon.endSection();
            zzit zzitVar = this.a;
            zzitVar.zzamk++;
            this.zzbhz++;
            this.zzbia++;
            zzitVar.zzaml = Math.max(this.zzbia, zzitVar.zzaml);
            if (this.zzbhz == this.zzbho) {
                zzjf();
            }
            return true;
        }
        if (zzoq.SDK_INT >= 21) {
            if (j6 < 50000) {
                zza(mediaCodec, i, j4, zzf);
                return true;
            }
        } else if (j6 < 30000) {
            if (j6 > 11000) {
                try {
                    Thread.sleep((j6 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            zzb(mediaCodec, i, j4);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final boolean a(MediaCodec mediaCodec, boolean z, zzgw zzgwVar, zzgw zzgwVar2) {
        if (!zza(z, zzgwVar, zzgwVar2)) {
            return false;
        }
        int i = zzgwVar2.width;
        zzoz zzozVar = this.zzbhs;
        return i <= zzozVar.width && zzgwVar2.height <= zzozVar.height && zzgwVar2.zzaff <= zzozVar.zzbio;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    protected final boolean a(zzkt zzktVar) {
        return this.zzbht != null || zzn(zzktVar.zzaxo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void b() {
        super.b();
        this.zzbhz = 0;
        this.zzbhy = SystemClock.elapsedRealtime();
        this.zzbhx = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void c() {
        zzjf();
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzgj
    public final void d() {
        this.zzbid = -1;
        this.zzbie = -1;
        this.zzbig = -1.0f;
        this.zzbic = -1.0f;
        this.zzbim = -9223372036854775807L;
        this.zzbin = 0;
        zzjc();
        zzja();
        this.zzbhl.disable();
        this.b = null;
        this.zzajo = false;
        try {
            super.d();
        } finally {
            this.a.zzge();
            this.zzbhm.zzd(this.a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw, com.google.android.gms.internal.ads.zzhf
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzbhw || (((surface = this.zzbhu) != null && this.zzbht == surface) || i() == null))) {
            this.zzbhx = -9223372036854775807L;
            return true;
        }
        if (this.zzbhx == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.zzbhx) {
            return true;
        }
        this.zzbhx = -9223372036854775807L;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzkw
    public final void k() {
        try {
            super.k();
        } finally {
            Surface surface = this.zzbhu;
            if (surface != null) {
                if (this.zzbht == surface) {
                    this.zzbht = null;
                }
                this.zzbhu.release();
                this.zzbhu = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l() {
        if (this.zzbhw) {
            return;
        }
        this.zzbhw = true;
        this.zzbhm.zzb(this.zzbht);
    }

    @Override // com.google.android.gms.internal.ads.zzgj, com.google.android.gms.internal.ads.zzgm
    public final void zza(int i, Object obj) {
        if (i != 1) {
            if (i != 4) {
                super.zza(i, obj);
                return;
            }
            this.zzbhv = ((Integer) obj).intValue();
            MediaCodec i2 = i();
            if (i2 != null) {
                i2.setVideoScalingMode(this.zzbhv);
                return;
            }
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.zzbhu;
            if (surface2 != null) {
                surface = surface2;
            } else {
                zzkt j = j();
                if (j != null && zzn(j.zzaxo)) {
                    this.zzbhu = zzot.zzc(this.zzup, j.zzaxo);
                    surface = this.zzbhu;
                }
            }
        }
        if (this.zzbht == surface) {
            if (surface == null || surface == this.zzbhu) {
                return;
            }
            zzje();
            if (this.zzbhw) {
                this.zzbhm.zzb(this.zzbht);
                return;
            }
            return;
        }
        this.zzbht = surface;
        int state = getState();
        if (state == 1 || state == 2) {
            MediaCodec i3 = i();
            if (zzoq.SDK_INT < 23 || i3 == null || surface == null) {
                k();
                h();
            } else {
                i3.setOutputSurface(surface);
            }
        }
        if (surface == null || surface == this.zzbhu) {
            zzjc();
            zzja();
            return;
        }
        zzje();
        zzja();
        if (state == 2) {
            zziz();
        }
    }
}
