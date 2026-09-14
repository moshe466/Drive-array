package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvq;

/* loaded from: classes.dex */
public class zzdvq<M extends zzdvq<M>> extends zzdvt {
    protected zzdvs b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvt
    public int a() {
        if (this.b != null) {
            for (int i = 0; i < this.b.a(); i++) {
                this.b.a(i).a();
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdvt
    public /* synthetic */ Object clone() {
        zzdvq zzdvqVar = (zzdvq) super.clone();
        zzdvu.zza(this, zzdvqVar);
        return zzdvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdvt
    public void zza(zzdvo zzdvoVar) {
        if (this.b == null) {
            return;
        }
        for (int i = 0; i < this.b.a(); i++) {
            this.b.a(i).a(zzdvoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvt
    /* renamed from: zzbcr */
    public final /* synthetic */ zzdvt clone() {
        return (zzdvq) clone();
    }
}
