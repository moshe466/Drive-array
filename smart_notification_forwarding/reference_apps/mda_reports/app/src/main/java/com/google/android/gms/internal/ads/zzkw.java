package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(19)
@TargetApi(19)
/* loaded from: classes.dex */
public abstract class zzkw extends zzgj {
    private static final byte[] zzaxu = zzoq.zzbo("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    protected zzit a;
    private zzgw zzafz;
    private ByteBuffer[] zzajf;
    private final zzky zzaxv;
    private final zzja<zzjc> zzaxw;
    private final boolean zzaxx;
    private final zzis zzaxy;
    private final zzis zzaxz;
    private final zzgy zzaya;
    private final List<Long> zzayb;
    private final MediaCodec.BufferInfo zzayc;
    private zziy<zzjc> zzayd;
    private zziy<zzjc> zzaye;
    private MediaCodec zzayf;
    private zzkt zzayg;
    private boolean zzayh;
    private boolean zzayi;
    private boolean zzayj;
    private boolean zzayk;
    private boolean zzayl;
    private boolean zzaym;
    private boolean zzayn;
    private boolean zzayo;
    private boolean zzayp;
    private ByteBuffer[] zzayq;
    private long zzayr;
    private int zzays;
    private int zzayt;
    private boolean zzayu;
    private boolean zzayv;
    private int zzayw;
    private int zzayx;
    private boolean zzayy;
    private boolean zzayz;
    private boolean zzaza;
    private boolean zzazb;
    private boolean zzazc;
    private boolean zzazd;

    public zzkw(int i, zzky zzkyVar, zzja<zzjc> zzjaVar, boolean z) {
        super(i);
        zzoc.checkState(zzoq.SDK_INT >= 16);
        this.zzaxv = (zzky) zzoc.checkNotNull(zzkyVar);
        this.zzaxw = zzjaVar;
        this.zzaxx = z;
        this.zzaxy = new zzis(0);
        this.zzaxz = new zzis(0);
        this.zzaya = new zzgy();
        this.zzayb = new ArrayList();
        this.zzayc = new MediaCodec.BufferInfo();
        this.zzayw = 0;
        this.zzayx = 0;
    }

    private final void zza(zzkv zzkvVar) {
        throw zzgl.zza(zzkvVar, a());
    }

    private final boolean zzd(long j, long j2) {
        boolean a;
        boolean z;
        if (this.zzayt < 0) {
            if (this.zzaym && this.zzayz) {
                try {
                    this.zzayt = this.zzayf.dequeueOutputBuffer(this.zzayc, 0L);
                } catch (IllegalStateException unused) {
                    zzha();
                    if (this.zzazb) {
                        k();
                    }
                    return false;
                }
            } else {
                this.zzayt = this.zzayf.dequeueOutputBuffer(this.zzayc, 0L);
            }
            int i = this.zzayt;
            if (i < 0) {
                if (i != -2) {
                    if (i == -3) {
                        this.zzajf = this.zzayf.getOutputBuffers();
                        return true;
                    }
                    if (this.zzayk && (this.zzaza || this.zzayx == 2)) {
                        zzha();
                    }
                    return false;
                }
                MediaFormat outputFormat = this.zzayf.getOutputFormat();
                if (this.zzayj && outputFormat.getInteger(SettingsJsonConstants.ICON_WIDTH_KEY) == 32 && outputFormat.getInteger(SettingsJsonConstants.ICON_HEIGHT_KEY) == 32) {
                    this.zzayp = true;
                } else {
                    if (this.zzayn) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    a(this.zzayf, outputFormat);
                }
                return true;
            }
            if (this.zzayp) {
                this.zzayp = false;
                this.zzayf.releaseOutputBuffer(i, false);
                this.zzayt = -1;
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.zzayc;
            if ((bufferInfo.flags & 4) != 0) {
                zzha();
                this.zzayt = -1;
                return false;
            }
            ByteBuffer byteBuffer = this.zzajf[i];
            if (byteBuffer != null) {
                byteBuffer.position(bufferInfo.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.zzayc;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            long j3 = this.zzayc.presentationTimeUs;
            int size = this.zzayb.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                if (this.zzayb.get(i2).longValue() == j3) {
                    this.zzayb.remove(i2);
                    z = true;
                    break;
                }
                i2++;
            }
            this.zzayu = z;
        }
        if (this.zzaym && this.zzayz) {
            try {
                a = a(j, j2, this.zzayf, this.zzajf[this.zzayt], this.zzayt, this.zzayc.flags, this.zzayc.presentationTimeUs, this.zzayu);
            } catch (IllegalStateException unused2) {
                zzha();
                if (this.zzazb) {
                    k();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec = this.zzayf;
            ByteBuffer[] byteBufferArr = this.zzajf;
            int i3 = this.zzayt;
            ByteBuffer byteBuffer2 = byteBufferArr[i3];
            MediaCodec.BufferInfo bufferInfo3 = this.zzayc;
            a = a(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzayu);
        }
        if (!a) {
            return false;
        }
        long j4 = this.zzayc.presentationTimeUs;
        this.zzayt = -1;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x014b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzgz() {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkw.zzgz():boolean");
    }

    private final void zzha() {
        if (this.zzayx == 2) {
            k();
            h();
        } else {
            this.zzazb = true;
            g();
        }
    }

    protected abstract int a(zzky zzkyVar, zzgw zzgwVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzkt a(zzky zzkyVar, zzgw zzgwVar, boolean z) {
        return zzkyVar.zzb(zzgwVar.zzafe, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgj
    public void a(long j, boolean z) {
        this.zzaza = false;
        this.zzazb = false;
        if (this.zzayf != null) {
            this.zzayr = -9223372036854775807L;
            this.zzays = -1;
            this.zzayt = -1;
            this.zzazd = true;
            this.zzazc = false;
            this.zzayu = false;
            this.zzayb.clear();
            this.zzayo = false;
            this.zzayp = false;
            if (this.zzayi || ((this.zzayl && this.zzayz) || this.zzayx != 0)) {
                k();
                h();
            } else {
                this.zzayf.flush();
                this.zzayy = false;
            }
            if (!this.zzayv || this.zzafz == null) {
                return;
            }
            this.zzayw = 1;
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r5.height == r0.height) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.google.android.gms.internal.ads.zzgw r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzgw r0 = r4.zzafz
            r4.zzafz = r5
            com.google.android.gms.internal.ads.zzgw r5 = r4.zzafz
            com.google.android.gms.internal.ads.zziv r5 = r5.zzafh
            r1 = 0
            if (r0 != 0) goto Ld
            r2 = r1
            goto Lf
        Ld:
            com.google.android.gms.internal.ads.zziv r2 = r0.zzafh
        Lf:
            boolean r5 = com.google.android.gms.internal.ads.zzoq.zza(r5, r2)
            r2 = 1
            r5 = r5 ^ r2
            if (r5 == 0) goto L4d
            com.google.android.gms.internal.ads.zzgw r5 = r4.zzafz
            com.google.android.gms.internal.ads.zziv r5 = r5.zzafh
            if (r5 == 0) goto L4b
            com.google.android.gms.internal.ads.zzja<com.google.android.gms.internal.ads.zzjc> r5 = r4.zzaxw
            if (r5 == 0) goto L3b
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.google.android.gms.internal.ads.zzgw r3 = r4.zzafz
            com.google.android.gms.internal.ads.zziv r3 = r3.zzafh
            com.google.android.gms.internal.ads.zziy r5 = r5.zza(r1, r3)
            r4.zzaye = r5
            com.google.android.gms.internal.ads.zziy<com.google.android.gms.internal.ads.zzjc> r5 = r4.zzaye
            com.google.android.gms.internal.ads.zziy<com.google.android.gms.internal.ads.zzjc> r1 = r4.zzayd
            if (r5 != r1) goto L4d
            com.google.android.gms.internal.ads.zzja<com.google.android.gms.internal.ads.zzjc> r1 = r4.zzaxw
            r1.zza(r5)
            goto L4d
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.a()
            com.google.android.gms.internal.ads.zzgl r5 = com.google.android.gms.internal.ads.zzgl.zza(r5, r0)
            throw r5
        L4b:
            r4.zzaye = r1
        L4d:
            com.google.android.gms.internal.ads.zziy<com.google.android.gms.internal.ads.zzjc> r5 = r4.zzaye
            com.google.android.gms.internal.ads.zziy<com.google.android.gms.internal.ads.zzjc> r1 = r4.zzayd
            if (r5 != r1) goto L7e
            android.media.MediaCodec r5 = r4.zzayf
            if (r5 == 0) goto L7e
            com.google.android.gms.internal.ads.zzkt r1 = r4.zzayg
            boolean r1 = r1.zzaxn
            com.google.android.gms.internal.ads.zzgw r3 = r4.zzafz
            boolean r5 = r4.a(r5, r1, r0, r3)
            if (r5 == 0) goto L7e
            r4.zzayv = r2
            r4.zzayw = r2
            boolean r5 = r4.zzayj
            if (r5 == 0) goto L7a
            com.google.android.gms.internal.ads.zzgw r5 = r4.zzafz
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L7a
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L7a
            goto L7b
        L7a:
            r2 = 0
        L7b:
            r4.zzayo = r2
            return
        L7e:
            boolean r5 = r4.zzayy
            if (r5 == 0) goto L85
            r4.zzayx = r2
            return
        L85:
            r4.k()
            r4.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkw.a(com.google.android.gms.internal.ads.zzgw):void");
    }

    protected void a(zzis zzisVar) {
    }

    protected abstract void a(zzkt zzktVar, MediaCodec mediaCodec, zzgw zzgwVar, MediaCrypto mediaCrypto);

    protected void a(String str, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgj
    public void a(boolean z) {
        this.a = new zzit();
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    protected boolean a(MediaCodec mediaCodec, boolean z, zzgw zzgwVar, zzgw zzgwVar2) {
        return false;
    }

    protected boolean a(zzkt zzktVar) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgj
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgj
    public void c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgj
    public void d() {
        this.zzafz = null;
        try {
            k();
            try {
                if (this.zzayd != null) {
                    this.zzaxw.zza(this.zzayd);
                }
                try {
                    if (this.zzaye != null && this.zzaye != this.zzayd) {
                        this.zzaxw.zza(this.zzaye);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.zzaye != null && this.zzaye != this.zzayd) {
                        this.zzaxw.zza(this.zzaye);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.zzayd != null) {
                    this.zzaxw.zza(this.zzayd);
                }
                try {
                    if (this.zzaye != null && this.zzaye != this.zzayd) {
                        this.zzaxw.zza(this.zzaye);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.zzaye != null && this.zzaye != this.zzayd) {
                        this.zzaxw.zza(this.zzaye);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    protected void g() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        zzgw zzgwVar;
        if (this.zzayf != null || (zzgwVar = this.zzafz) == null) {
            return;
        }
        this.zzayd = this.zzaye;
        String str = zzgwVar.zzafe;
        zziy<zzjc> zziyVar = this.zzayd;
        if (zziyVar != null) {
            int state = zziyVar.getState();
            if (state == 0) {
                throw zzgl.zza(this.zzayd.zzgg(), a());
            }
            if (state == 3 || state == 4) {
                this.zzayd.zzgf();
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.zzayg == null) {
            try {
                this.zzayg = a(this.zzaxv, zzgwVar, false);
                zzkt zzktVar = this.zzayg;
            } catch (zzlb e) {
                zza(new zzkv(this.zzafz, (Throwable) e, false, -49998));
            }
            if (this.zzayg == null) {
                zza(new zzkv(this.zzafz, (Throwable) null, false, -49999));
            }
        }
        if (a(this.zzayg)) {
            String str2 = this.zzayg.name;
            this.zzayh = zzoq.SDK_INT < 21 && this.zzafz.zzafg.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            int i = zzoq.SDK_INT;
            this.zzayi = i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzoq.SDK_INT == 19 && zzoq.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            this.zzayj = zzoq.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzoq.DEVICE) || "flounder_lte".equals(zzoq.DEVICE) || "grouper".equals(zzoq.DEVICE) || "tilapia".equals(zzoq.DEVICE));
            this.zzayk = zzoq.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.zzayl = (zzoq.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzoq.SDK_INT <= 19 && "hb2000".equals(zzoq.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.zzaym = zzoq.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
            this.zzayn = zzoq.SDK_INT <= 18 && this.zzafz.zzafo == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String valueOf = String.valueOf(str2);
                zzon.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                this.zzayf = MediaCodec.createByCodecName(str2);
                zzon.endSection();
                zzon.beginSection("configureCodec");
                a(this.zzayg, this.zzayf, this.zzafz, (MediaCrypto) null);
                zzon.endSection();
                zzon.beginSection("startCodec");
                this.zzayf.start();
                zzon.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.zzayq = this.zzayf.getInputBuffers();
                this.zzajf = this.zzayf.getOutputBuffers();
            } catch (Exception e2) {
                zza(new zzkv(this.zzafz, (Throwable) e2, false, str2));
            }
            this.zzayr = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            this.zzays = -1;
            this.zzayt = -1;
            this.zzazd = true;
            this.a.zzamf++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec i() {
        return this.zzayf;
    }

    public boolean isReady() {
        if (this.zzafz == null || this.zzazc) {
            return false;
        }
        if (f() || this.zzayt >= 0) {
            return true;
        }
        return this.zzayr != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzayr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzkt j() {
        return this.zzayg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        this.zzayr = -9223372036854775807L;
        this.zzays = -1;
        this.zzayt = -1;
        this.zzazc = false;
        this.zzayu = false;
        this.zzayb.clear();
        this.zzayq = null;
        this.zzajf = null;
        this.zzayg = null;
        this.zzayv = false;
        this.zzayy = false;
        this.zzayh = false;
        this.zzayi = false;
        this.zzayj = false;
        this.zzayk = false;
        this.zzayl = false;
        this.zzayn = false;
        this.zzayo = false;
        this.zzayp = false;
        this.zzayz = false;
        this.zzayw = 0;
        this.zzayx = 0;
        this.zzaxy.zzcs = null;
        MediaCodec mediaCodec = this.zzayf;
        if (mediaCodec != null) {
            this.a.zzamg++;
            try {
                mediaCodec.stop();
                try {
                    this.zzayf.release();
                    this.zzayf = null;
                    zziy<zzjc> zziyVar = this.zzayd;
                    if (zziyVar == null || this.zzaye == zziyVar) {
                        return;
                    }
                    try {
                        this.zzaxw.zza(zziyVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.zzayf = null;
                    zziy<zzjc> zziyVar2 = this.zzayd;
                    if (zziyVar2 != null && this.zzaye != zziyVar2) {
                        try {
                            this.zzaxw.zza(zziyVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.zzayf.release();
                    this.zzayf = null;
                    zziy<zzjc> zziyVar3 = this.zzayd;
                    if (zziyVar3 != null && this.zzaye != zziyVar3) {
                        try {
                            this.zzaxw.zza(zziyVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.zzayf = null;
                    zziy<zzjc> zziyVar4 = this.zzayd;
                    if (zziyVar4 != null && this.zzaye != zziyVar4) {
                        try {
                            this.zzaxw.zza(zziyVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int zza(zzgw zzgwVar) {
        try {
            return a(this.zzaxv, zzgwVar);
        } catch (zzlb e) {
            throw zzgl.zza(e, a());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public final void zzb(long j, long j2) {
        if (this.zzazb) {
            g();
            return;
        }
        if (this.zzafz == null) {
            this.zzaxz.clear();
            int a = a(this.zzaya, this.zzaxz, true);
            if (a != -5) {
                if (a == -4) {
                    zzoc.checkState(this.zzaxz.zzgb());
                    this.zzaza = true;
                    zzha();
                    return;
                }
                return;
            }
            a(this.zzaya.zzafz);
        }
        h();
        if (this.zzayf != null) {
            zzon.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzgz());
            zzon.endSection();
        } else {
            a(j);
            this.zzaxz.clear();
            int a2 = a(this.zzaya, this.zzaxz, false);
            if (a2 == -5) {
                a(this.zzaya.zzafz);
            } else if (a2 == -4) {
                zzoc.checkState(this.zzaxz.zzgb());
                this.zzaza = true;
                zzha();
            }
        }
        this.a.zzge();
    }

    @Override // com.google.android.gms.internal.ads.zzgj, com.google.android.gms.internal.ads.zzhe
    public final int zzdw() {
        return 4;
    }

    public boolean zzeu() {
        return this.zzazb;
    }
}
