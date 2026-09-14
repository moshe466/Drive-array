package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;

/* loaded from: classes.dex */
public final class zzacj extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzcvn;
    private final zzaci zzcvs;
    private final Drawable zzcvt;

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(2:2|3)|(15:5|6|7|8|9|10|11|12|13|14|15|16|17|18|19)|34|6|7|8|9|10|11|12|13|14|15|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        com.google.android.gms.internal.ads.zzayu.zzc("", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        com.google.android.gms.internal.ads.zzayu.zzc("", r1);
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0034, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0035, code lost:
    
        com.google.android.gms.internal.ads.zzayu.zzc("", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0025, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0026, code lost:
    
        com.google.android.gms.internal.ads.zzayu.zzc("", r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzacj(com.google.android.gms.internal.ads.zzaci r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r3.<init>()
            r3.zzcvs = r4
            r4 = 0
            com.google.android.gms.internal.ads.zzaci r1 = r3.zzcvs     // Catch: android.os.RemoteException -> L17
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzrc()     // Catch: android.os.RemoteException -> L17
            if (r1 == 0) goto L1b
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r1)     // Catch: android.os.RemoteException -> L17
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1     // Catch: android.os.RemoteException -> L17
            goto L1c
        L17:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
        L1b:
            r1 = r4
        L1c:
            r3.zzcvt = r1
            com.google.android.gms.internal.ads.zzaci r1 = r3.zzcvs     // Catch: android.os.RemoteException -> L25
            android.net.Uri r4 = r1.getUri()     // Catch: android.os.RemoteException -> L25
            goto L29
        L25:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
        L29:
            r3.uri = r4
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.google.android.gms.internal.ads.zzaci r4 = r3.zzcvs     // Catch: android.os.RemoteException -> L34
            double r1 = r4.getScale()     // Catch: android.os.RemoteException -> L34
            goto L38
        L34:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r4)
        L38:
            r3.zzcvn = r1
            r4 = -1
            com.google.android.gms.internal.ads.zzaci r1 = r3.zzcvs     // Catch: android.os.RemoteException -> L42
            int r1 = r1.getWidth()     // Catch: android.os.RemoteException -> L42
            goto L47
        L42:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
            r1 = -1
        L47:
            r3.width = r1
            com.google.android.gms.internal.ads.zzaci r1 = r3.zzcvs     // Catch: android.os.RemoteException -> L50
            int r4 = r1.getHeight()     // Catch: android.os.RemoteException -> L50
            goto L54
        L50:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzayu.zzc(r0, r1)
        L54:
            r3.height = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacj.<init>(com.google.android.gms.internal.ads.zzaci):void");
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzcvt;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getHeight() {
        return this.height;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzcvn;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getWidth() {
        return this.width;
    }
}
