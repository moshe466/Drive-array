package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcvz implements zzdxg<String> {
    private final zzcvw zzgih;

    public zzcvz(zzcvw zzcvwVar) {
        this.zzgih = zzcvwVar;
    }

    public static String zzc(zzcvw zzcvwVar) {
        return (String) zzdxm.zza(zzcvwVar.zzant(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzc(this.zzgih);
    }
}
