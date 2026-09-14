package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbo;
import com.google.android.gms.internal.ads.zzbs;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class zzex extends zzfw {
    private static final zzfv<zzcl> zzzm = new zzfv<>();
    private final Context zzzn;
    private zzbo.zza zzzo;

    public zzex(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2, Context context, zzbo.zza zzaVar) {
        super(zzeiVar, str, str2, zzbVar, i, 27);
        this.zzzo = null;
        this.zzzn = context;
        this.zzzo = zzaVar;
    }

    private static String zza(zzbo.zza zzaVar) {
        if (zzaVar == null || !zzaVar.zzy() || zzep.zzau(zzaVar.zzz().zzag())) {
            return null;
        }
        return zzaVar.zzz().zzag();
    }

    private final String zzco() {
        try {
            if (this.a.zzcg() != null) {
                this.a.zzcg().get();
            }
            zzbs.zza zzcf = this.a.zzcf();
            if (zzcf == null || !zzcf.zzaj()) {
                return null;
            }
            return zzcf.zzag();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d6, code lost:
    
        if (com.google.android.gms.internal.ads.zzep.zzau(r1) == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x011d, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001f, B:10:0x0029, B:15:0x0039, B:17:0x0045, B:18:0x0082, B:21:0x0091, B:23:0x00b7, B:25:0x00e6, B:26:0x00c1, B:30:0x00ce, B:32:0x00d8, B:33:0x00db, B:34:0x0048, B:37:0x0056, B:39:0x005c, B:42:0x006b, B:44:0x0075, B:46:0x007d, B:47:0x0080, B:49:0x00e9, B:50:0x00ef), top: B:3:0x000d }] */
    @Override // com.google.android.gms.internal.ads.zzfw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void a() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzex.a():void");
    }
}
