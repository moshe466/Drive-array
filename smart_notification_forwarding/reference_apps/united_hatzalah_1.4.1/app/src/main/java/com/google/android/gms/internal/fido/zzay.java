package com.google.android.gms.internal.fido;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzay extends zzaz {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaz zzc;

    public zzay(zzaz zzazVar, int i, int i3) {
        this.zzc = zzazVar;
        this.zza = i;
        this.zzb = i3;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzap.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzav
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.fido.zzaz, java.util.List
    /* renamed from: zzg */
    public final zzaz subList(int i, int i3) {
        zzap.zze(i, i3, this.zzb);
        zzaz zzazVar = this.zzc;
        int i4 = this.zza;
        return zzazVar.subList(i + i4, i3 + i4);
    }
}
