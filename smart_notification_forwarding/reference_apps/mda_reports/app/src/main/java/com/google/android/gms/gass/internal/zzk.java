package com.google.android.gms.gass.internal;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzfz;
import java.io.File;

/* loaded from: classes.dex */
public final class zzk {
    private final SharedPreferences zzcgc;

    @VisibleForTesting
    private final File zzgtk;

    @VisibleForTesting
    private final File zzgtl;

    public zzk(@NonNull Context context) {
        this.zzcgc = context.getSharedPreferences("pcvmspf", 0);
        this.zzgtk = zzj.zza(context.getDir("pccache", 0), false);
        this.zzgtl = zzj.zza(context.getDir("tmppccache", 0), true);
    }

    @VisibleForTesting
    private static String zza(@NonNull zzfz zzfzVar) {
        return Hex.bytesToStringLowercase(zzfzVar.zzaxk().toByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.ads.zzfz zzds(int r6) {
        /*
            r5 = this;
            int r0 = com.google.android.gms.gass.internal.zzp.zzgtn
            r1 = 0
            if (r6 != r0) goto Le
            android.content.SharedPreferences r6 = r5.zzcgc
            java.lang.String r0 = "LATMTD"
        L9:
            java.lang.String r6 = r6.getString(r0, r1)
            goto L18
        Le:
            int r0 = com.google.android.gms.gass.internal.zzp.zzgto
            if (r6 != r0) goto L17
            android.content.SharedPreferences r6 = r5.zzcgc
            java.lang.String r0 = "FBAMTD"
            goto L9
        L17:
            r6 = r1
        L18:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L1f
            return r1
        L1f:
            byte[] r6 = com.google.android.gms.common.util.Hex.stringToBytes(r6)     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            com.google.android.gms.internal.ads.zzdqk r6 = com.google.android.gms.internal.ads.zzdqk.zzu(r6)     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            com.google.android.gms.internal.ads.zzfz r6 = com.google.android.gms.internal.ads.zzfz.zzl(r6)     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            java.lang.String r0 = r6.zzcx()     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            java.lang.String r2 = "pcam"
            java.io.File r3 = r5.zzgtk     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            java.io.File r2 = com.google.android.gms.gass.internal.zzj.zza(r0, r2, r3)     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            java.lang.String r3 = "pcbc"
            java.io.File r4 = r5.zzgtk     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            java.io.File r0 = com.google.android.gms.gass.internal.zzj.zza(r0, r3, r4)     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            boolean r2 = r2.exists()     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            if (r2 == 0) goto L4d
            boolean r0 = r0.exists()     // Catch: com.google.android.gms.internal.ads.zzdse -> L51
            if (r0 == 0) goto L4d
            r0 = 1
            goto L4e
        L4d:
            r0 = 0
        L4e:
            if (r0 == 0) goto L51
            return r6
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gass.internal.zzk.zzds(int):com.google.android.gms.internal.ads.zzfz");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0119, code lost:
    
        if (r0.commit() != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzfy r8, @androidx.annotation.Nullable com.google.android.gms.gass.internal.zzq r9) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gass.internal.zzk.zza(com.google.android.gms.internal.ads.zzfy, com.google.android.gms.gass.internal.zzq):boolean");
    }

    public final Program zzdr(int i) {
        zzfz zzds = zzds(i);
        if (zzds == null) {
            return null;
        }
        String zzcx = zzds.zzcx();
        return new Program(zzds, zzj.zza(zzcx, "pcam", this.zzgtk), zzj.zza(zzcx, "pcbc", this.zzgtk), zzj.zza(zzcx, "pcopt", this.zzgtk));
    }
}
