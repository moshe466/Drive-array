package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzble implements zzdxg<zzbsu<zzbrb>> {
    private final zzbkn zzfen;
    private final zzdxp<zzbqp> zzfeq;

    public zzble(zzbkn zzbknVar, zzdxp<zzbqp> zzdxpVar) {
        this.zzfen = zzbknVar;
        this.zzfeq = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        final zzbqp zzbqpVar = this.zzfeq.get();
        return (zzbsu) zzdxm.zza(new zzbsu(new zzbrb(zzbqpVar) { // from class: com.google.android.gms.internal.ads.zzbkp
            private final zzbqp zzfej;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfej = zzbqpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbrb
            public final void zzagj() {
                this.zzfej.zzahj();
            }
        }, zzazd.zzdwj), "Cannot return null from a non-@Nullable @Provides method");
    }
}
