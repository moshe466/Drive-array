package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcsn implements zzcub<zzcsk> {
    private final PackageInfo zzdip;
    private final zzavu zzdrk;
    private final zzczu zzfgl;
    private final zzdhd zzfov;

    public zzcsn(zzdhd zzdhdVar, zzczu zzczuVar, @Nullable PackageInfo packageInfo, zzavu zzavuVar) {
        this.zzfov = zzdhdVar;
        this.zzfgl = zzczuVar;
        this.zzdip = packageInfo;
        this.zzdrk = zzavuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcsk a() {
        final ArrayList<String> arrayList = this.zzfgl.zzgmn;
        return arrayList == null ? zzcsp.a : arrayList.isEmpty() ? zzcso.a : new zzcsk(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzcsr
            private final zzcsn zzgfz;
            private final ArrayList zzggb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfz = this;
                this.zzggb = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzcty
            public final void zzr(Bundle bundle) {
                this.zzgfz.a(this.zzggb, bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f5, code lost:
    
        if (r9 == 3) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void a(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcsn.a(java.util.ArrayList, android.os.Bundle):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcsk> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcsm
            private final zzcsn zzgfz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfz = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgfz.a();
            }
        });
    }
}
