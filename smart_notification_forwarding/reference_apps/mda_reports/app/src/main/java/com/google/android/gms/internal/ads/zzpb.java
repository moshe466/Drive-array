package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
/* loaded from: classes.dex */
public final class zzpb {
    private final zzpe zzbip;
    private final boolean zzbiq;
    private final long zzbir;
    private final long zzbis;
    private long zzbit;
    private long zzbiu;
    private long zzbiv;
    private boolean zzbiw;
    private long zzbix;
    private long zzbiy;
    private long zzbiz;

    public zzpb() {
        this(-1.0d);
    }

    private zzpb(double d) {
        long j;
        this.zzbiq = d != -1.0d;
        if (this.zzbiq) {
            this.zzbip = zzpe.zzjg();
            this.zzbir = (long) (1.0E9d / d);
            j = (this.zzbir * 80) / 100;
        } else {
            this.zzbip = null;
            j = -1;
            this.zzbir = -1L;
        }
        this.zzbis = j;
    }

    public zzpb(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private final boolean zzg(long j, long j2) {
        return Math.abs((j2 - this.zzbix) - (j - this.zzbiy)) > 20000000;
    }

    public final void disable() {
        if (this.zzbiq) {
            this.zzbip.zzji();
        }
    }

    public final void enable() {
        this.zzbiw = false;
        if (this.zzbiq) {
            this.zzbip.zzjh();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x003c, code lost:
    
        if (zzg(r0, r14) != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzf(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.zzbiw
            if (r2 == 0) goto L40
            long r2 = r11.zzbit
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L19
            long r2 = r11.zzbiz
            r4 = 1
            long r2 = r2 + r4
            r11.zzbiz = r2
            long r2 = r11.zzbiv
            r11.zzbiu = r2
        L19:
            long r2 = r11.zzbiz
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L38
            long r4 = r11.zzbiy
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.zzbiu
            long r2 = r2 + r4
            boolean r4 = r11.zzg(r2, r14)
            if (r4 == 0) goto L31
            goto L3e
        L31:
            long r4 = r11.zzbix
            long r4 = r4 + r2
            long r6 = r11.zzbiy
            long r4 = r4 - r6
            goto L42
        L38:
            boolean r2 = r11.zzg(r0, r14)
            if (r2 == 0) goto L40
        L3e:
            r11.zzbiw = r6
        L40:
            r4 = r14
            r2 = r0
        L42:
            boolean r6 = r11.zzbiw
            r7 = 0
            if (r6 != 0) goto L51
            r11.zzbiy = r0
            r11.zzbix = r14
            r11.zzbiz = r7
            r14 = 1
            r11.zzbiw = r14
        L51:
            r11.zzbit = r12
            r11.zzbiv = r2
            com.google.android.gms.internal.ads.zzpe r12 = r11.zzbip
            if (r12 == 0) goto L84
            long r12 = r12.zzbjb
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L60
            goto L84
        L60:
            com.google.android.gms.internal.ads.zzpe r12 = r11.zzbip
            long r12 = r12.zzbjb
            long r14 = r11.zzbir
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L73
            long r14 = r12 - r14
            goto L77
        L73:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L77:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L7f
            goto L80
        L7f:
            r12 = r14
        L80:
            long r14 = r11.zzbis
            long r12 = r12 - r14
            return r12
        L84:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpb.zzf(long, long):long");
    }
}
