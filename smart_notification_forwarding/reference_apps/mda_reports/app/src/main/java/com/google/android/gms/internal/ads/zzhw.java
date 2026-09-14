package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class zzhw {
    private static boolean zzahp = false;
    private static boolean zzahq = false;
    private int streamType;
    private zzhc zzadi;
    private int zzafp;
    private final zzih zzahs;
    private final zzim zzaht;
    private final zzhm[] zzahu;
    private final zzic zzahv;
    private final long[] zzahx;
    private final zzhy zzahy;
    private final LinkedList<zzif> zzahz;
    private AudioTrack zzaia;
    private int zzaib;
    private int zzaic;
    private int zzaid;
    private boolean zzaie;
    private int zzaif;
    private long zzaig;
    private zzhc zzaih;
    private long zzaii;
    private long zzaij;
    private ByteBuffer zzaik;
    private int zzail;
    private int zzaim;
    private int zzain;
    private long zzaio;
    private long zzaip;
    private boolean zzaiq;
    private long zzair;
    private Method zzais;
    private int zzait;
    private long zzaiu;
    private long zzaiv;
    private int zzaiw;
    private long zzaix;
    private long zzaiy;
    private int zzaiz;
    private int zzaja;
    private long zzajb;
    private long zzajc;
    private long zzajd;
    private zzhm[] zzaje;
    private ByteBuffer[] zzajf;
    private ByteBuffer zzajg;
    private ByteBuffer zzajh;
    private byte[] zzaji;
    private int zzajj;
    private int zzajk;
    private boolean zzajl;
    private boolean zzajm;
    private int zzajn;
    private boolean zzajo;
    private boolean zzajp;
    private long zzajq;
    private float zzcy;
    private final zzhn zzahr = null;
    private final ConditionVariable zzahw = new ConditionVariable(true);

    public zzhw(zzhn zzhnVar, zzhm[] zzhmVarArr, zzic zzicVar) {
        zzhz zzhzVar = null;
        this.zzahv = zzicVar;
        if (zzoq.SDK_INT >= 18) {
            try {
                this.zzais = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzoq.SDK_INT >= 19) {
            this.zzahy = new zzib();
        } else {
            this.zzahy = new zzhy(zzhzVar);
        }
        this.zzahs = new zzih();
        this.zzaht = new zzim();
        this.zzahu = new zzhm[zzhmVarArr.length + 3];
        this.zzahu[0] = new zzik();
        zzhm[] zzhmVarArr2 = this.zzahu;
        zzhmVarArr2[1] = this.zzahs;
        System.arraycopy(zzhmVarArr, 0, zzhmVarArr2, 2, zzhmVarArr.length);
        this.zzahu[zzhmVarArr.length + 2] = this.zzaht;
        this.zzahx = new long[10];
        this.zzcy = 1.0f;
        this.zzaja = 0;
        this.streamType = 3;
        this.zzajn = 0;
        this.zzadi = zzhc.zzagb;
        this.zzajk = -1;
        this.zzaje = new zzhm[0];
        this.zzajf = new ByteBuffer[0];
        this.zzahz = new LinkedList<>();
    }

    private final boolean isInitialized() {
        return this.zzaia != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:
    
        if (r11 < r10) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzb(java.nio.ByteBuffer r9, long r10) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhw.zzb(java.nio.ByteBuffer, long):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zzbb(String str) {
        char c;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 5;
        }
        if (c == 1) {
            return 6;
        }
        if (c != 2) {
            return c != 3 ? 0 : 8;
        }
        return 7;
    }

    private final void zzdv(long j) {
        ByteBuffer byteBuffer;
        int length = this.zzaje.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzajf[i - 1];
            } else {
                byteBuffer = this.zzajg;
                if (byteBuffer == null) {
                    byteBuffer = zzhm.zzaha;
                }
            }
            if (i == length) {
                zzb(byteBuffer, j);
            } else {
                zzhm zzhmVar = this.zzaje[i];
                zzhmVar.zzi(byteBuffer);
                ByteBuffer zzfc = zzhmVar.zzfc();
                this.zzajf[i] = zzfc;
                if (zzfc.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private final long zzdw(long j) {
        return (j * 1000000) / this.zzafp;
    }

    private final long zzdx(long j) {
        return (j * this.zzafp) / 1000000;
    }

    private final void zzfd() {
        ArrayList arrayList = new ArrayList();
        for (zzhm zzhmVar : this.zzahu) {
            if (zzhmVar.isActive()) {
                arrayList.add(zzhmVar);
            } else {
                zzhmVar.flush();
            }
        }
        int size = arrayList.size();
        this.zzaje = (zzhm[]) arrayList.toArray(new zzhm[size]);
        this.zzajf = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzhm zzhmVar2 = this.zzaje[i];
            zzhmVar2.flush();
            this.zzajf[i] = zzhmVar2.zzfc();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0032 -> B:6:0x0010). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzfg() {
        /*
            r9 = this;
            int r0 = r9.zzajk
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.zzaie
            if (r0 == 0) goto Lf
            com.google.android.gms.internal.ads.zzhm[] r0 = r9.zzaje
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r9.zzajk = r0
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.zzajk
            com.google.android.gms.internal.ads.zzhm[] r5 = r9.zzaje
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L36
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.zzfb()
        L28:
            r9.zzdv(r7)
            boolean r0 = r4.zzeu()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.zzajk
            int r0 = r0 + r2
            goto L10
        L36:
            java.nio.ByteBuffer r0 = r9.zzajh
            if (r0 == 0) goto L42
            r9.zzb(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzajh
            if (r0 == 0) goto L42
            return r3
        L42:
            r9.zzajk = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhw.zzfg():boolean");
    }

    private final void zzfk() {
        if (isInitialized()) {
            if (zzoq.SDK_INT >= 21) {
                this.zzaia.setVolume(this.zzcy);
                return;
            }
            AudioTrack audioTrack = this.zzaia;
            float f = this.zzcy;
            audioTrack.setStereoVolume(f, f);
        }
    }

    private final long zzfl() {
        return this.zzaie ? this.zzaiy : this.zzaix / this.zzaiw;
    }

    private final void zzfm() {
        this.zzaio = 0L;
        this.zzain = 0;
        this.zzaim = 0;
        this.zzaip = 0L;
        this.zzaiq = false;
        this.zzair = 0L;
    }

    private final boolean zzfn() {
        if (zzoq.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzaid;
        return i == 5 || i == 6;
    }

    public final void pause() {
        this.zzajm = false;
        if (isInitialized()) {
            zzfm();
            this.zzahy.pause();
        }
    }

    public final void play() {
        this.zzajm = true;
        if (isInitialized()) {
            this.zzajc = System.nanoTime() / 1000;
            this.zzaia.play();
        }
    }

    public final void release() {
        reset();
        for (zzhm zzhmVar : this.zzahu) {
            zzhmVar.reset();
        }
        this.zzajn = 0;
        this.zzajm = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzaiu = 0L;
            this.zzaiv = 0L;
            this.zzaix = 0L;
            this.zzaiy = 0L;
            this.zzaiz = 0;
            zzhc zzhcVar = this.zzaih;
            if (zzhcVar != null) {
                this.zzadi = zzhcVar;
                this.zzaih = null;
            } else if (!this.zzahz.isEmpty()) {
                this.zzadi = zzif.a(this.zzahz.getLast());
            }
            this.zzahz.clear();
            this.zzaii = 0L;
            this.zzaij = 0L;
            this.zzajg = null;
            this.zzajh = null;
            int i = 0;
            while (true) {
                zzhm[] zzhmVarArr = this.zzaje;
                if (i >= zzhmVarArr.length) {
                    break;
                }
                zzhm zzhmVar = zzhmVarArr[i];
                zzhmVar.flush();
                this.zzajf[i] = zzhmVar.zzfc();
                i++;
            }
            this.zzajl = false;
            this.zzajk = -1;
            this.zzaik = null;
            this.zzail = 0;
            this.zzaja = 0;
            this.zzajd = 0L;
            zzfm();
            if (this.zzaia.getPlayState() == 3) {
                this.zzaia.pause();
            }
            AudioTrack audioTrack = this.zzaia;
            this.zzaia = null;
            this.zzahy.zza(null, false);
            this.zzahw.close();
            new zzhz(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i) {
        if (this.streamType == i) {
            return;
        }
        this.streamType = i;
        if (this.zzajo) {
            return;
        }
        reset();
        this.zzajn = 0;
    }

    public final void setVolume(float f) {
        if (this.zzcy != f) {
            this.zzcy = f;
            zzfk();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhw.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(java.nio.ByteBuffer r25, long r26) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhw.zza(java.nio.ByteBuffer, long):boolean");
    }

    public final zzhc zzb(zzhc zzhcVar) {
        if (this.zzaie) {
            this.zzadi = zzhc.zzagb;
            return this.zzadi;
        }
        zzhc zzhcVar2 = new zzhc(this.zzaht.zza(zzhcVar.zzagc), this.zzaht.zzb(zzhcVar.zzagd));
        zzhc zzhcVar3 = this.zzaih;
        if (zzhcVar3 == null) {
            zzhcVar3 = !this.zzahz.isEmpty() ? zzif.a(this.zzahz.getLast()) : this.zzadi;
        }
        if (!zzhcVar2.equals(zzhcVar3)) {
            if (isInitialized()) {
                this.zzaih = zzhcVar2;
            } else {
                this.zzadi = zzhcVar2;
            }
        }
        return this.zzadi;
    }

    public final boolean zzba(String str) {
        zzhn zzhnVar = this.zzahr;
        return zzhnVar != null && zzhnVar.zzq(zzbb(str));
    }

    public final boolean zzeu() {
        if (isInitialized()) {
            return this.zzajl && !zzfh();
        }
        return true;
    }

    public final void zzfe() {
        if (this.zzaja == 1) {
            this.zzaja = 2;
        }
    }

    public final void zzff() {
        if (!this.zzajl && isInitialized() && zzfg()) {
            this.zzahy.zzdy(zzfl());
            this.zzail = 0;
            this.zzajl = true;
        }
    }

    public final boolean zzfh() {
        if (isInitialized()) {
            if (zzfl() <= this.zzahy.zzfo()) {
                if (zzfn() && this.zzaia.getPlayState() == 2 && this.zzaia.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzhc zzfi() {
        return this.zzadi;
    }

    public final void zzfj() {
        if (this.zzajo) {
            this.zzajo = false;
            this.zzajn = 0;
            reset();
        }
    }

    public final long zzj(boolean z) {
        long zzfp;
        long j;
        long j2;
        long j3;
        StringBuilder sb;
        String str;
        if (!(isInitialized() && this.zzaja != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzaia.getPlayState() == 3) {
            long zzfp2 = this.zzahy.zzfp();
            if (zzfp2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzaip >= 30000) {
                    long[] jArr = this.zzahx;
                    int i = this.zzaim;
                    jArr[i] = zzfp2 - nanoTime;
                    this.zzaim = (i + 1) % 10;
                    int i2 = this.zzain;
                    if (i2 < 10) {
                        this.zzain = i2 + 1;
                    }
                    this.zzaip = nanoTime;
                    this.zzaio = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzain;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzaio += this.zzahx[i3] / i4;
                        i3++;
                    }
                }
                if (!zzfn() && nanoTime - this.zzair >= 500000) {
                    this.zzaiq = this.zzahy.zzfq();
                    if (this.zzaiq) {
                        long zzfr = this.zzahy.zzfr() / 1000;
                        long zzfs = this.zzahy.zzfs();
                        if (zzfr >= this.zzajc) {
                            if (Math.abs(zzfr - nanoTime) > 5000000) {
                                sb = new StringBuilder(136);
                                str = "Spurious audio timestamp (system clock mismatch): ";
                            } else if (Math.abs(zzdw(zzfs) - zzfp2) > 5000000) {
                                sb = new StringBuilder(138);
                                str = "Spurious audio timestamp (frame position mismatch): ";
                            }
                            sb.append(str);
                            sb.append(zzfs);
                            sb.append(", ");
                            sb.append(zzfr);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzfp2);
                            Log.w("AudioTrack", sb.toString());
                        }
                        this.zzaiq = false;
                    }
                    if (this.zzais != null && !this.zzaie) {
                        try {
                            this.zzajd = (((Integer) r1.invoke(this.zzaia, null)).intValue() * 1000) - this.zzaig;
                            this.zzajd = Math.max(this.zzajd, 0L);
                            if (this.zzajd > 5000000) {
                                long j4 = this.zzajd;
                                StringBuilder sb2 = new StringBuilder(61);
                                sb2.append("Ignoring impossibly large audio latency: ");
                                sb2.append(j4);
                                Log.w("AudioTrack", sb2.toString());
                                this.zzajd = 0L;
                            }
                        } catch (Exception unused) {
                            this.zzais = null;
                        }
                    }
                    this.zzair = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzaiq) {
            zzfp = zzdw(this.zzahy.zzfs() + zzdx(nanoTime2 - (this.zzahy.zzfr() / 1000)));
        } else {
            zzfp = this.zzain == 0 ? this.zzahy.zzfp() : nanoTime2 + this.zzaio;
            if (!z) {
                zzfp -= this.zzajd;
            }
        }
        long j5 = this.zzajb;
        while (!this.zzahz.isEmpty() && zzfp >= zzif.b(this.zzahz.getFirst())) {
            zzif remove = this.zzahz.remove();
            this.zzadi = zzif.a(remove);
            this.zzaij = zzif.b(remove);
            this.zzaii = zzif.c(remove) - this.zzajb;
        }
        if (this.zzadi.zzagc == 1.0f) {
            j3 = (zzfp + this.zzaii) - this.zzaij;
        } else {
            if (!this.zzahz.isEmpty() || this.zzaht.zzfw() < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                j = this.zzaii;
                double d = this.zzadi.zzagc;
                double d2 = zzfp - this.zzaij;
                Double.isNaN(d);
                Double.isNaN(d2);
                j2 = (long) (d * d2);
            } else {
                j = this.zzaii;
                j2 = zzoq.zza(zzfp - this.zzaij, this.zzaht.zzfv(), this.zzaht.zzfw());
            }
            j3 = j2 + j;
        }
        return j5 + j3;
    }

    public final void zzt(int i) {
        zzoc.checkState(zzoq.SDK_INT >= 21);
        if (this.zzajo && this.zzajn == i) {
            return;
        }
        this.zzajo = true;
        this.zzajn = i;
        reset();
    }
}
