package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfz;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
abstract class zzdge<V, C> extends zzdfz<V, C> {
    private List<zzdej<V>> zzgwl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdge(zzdet<? extends zzdhe<? extends V>> zzdetVar, boolean z) {
        super(zzdetVar, true, true);
        this.zzgwl = zzdetVar.isEmpty() ? zzdeu.zzard() : zzdfc.zzdz(zzdetVar.size());
        for (int i = 0; i < zzdetVar.size(); i++) {
            this.zzgwl.add(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfz
    final void a(int i, @NullableDecl V v) {
        List<zzdej<V>> list = this.zzgwl;
        if (list != null) {
            list.set(i, zzdej.zzab(v));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdfz
    public final void a(zzdfz.zza zzaVar) {
        super.a(zzaVar);
        this.zzgwl = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdfz
    final void l() {
        List<zzdej<V>> list = this.zzgwl;
        if (list != null) {
            set(zzh(list));
        }
    }

    abstract C zzh(List<zzdej<V>> list);
}
