package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzakh {
    private zzais zzdbc;
    private zzdhe<zzajq> zzdbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakh(zzais zzaisVar) {
        this.zzdbc = zzaisVar;
    }

    private final void zzsi() {
        if (this.zzdbd == null) {
            final zzazl zzazlVar = new zzazl();
            this.zzdbd = zzazlVar;
            this.zzdbc.zzb(null).zza(new zzazp(zzazlVar) { // from class: com.google.android.gms.internal.ads.zzakk
                private final zzazl zzbru;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbru = zzazlVar;
                }

                @Override // com.google.android.gms.internal.ads.zzazp
                public final void zzh(Object obj) {
                    this.zzbru.set((zzajq) obj);
                }
            }, new zzazn(zzazlVar) { // from class: com.google.android.gms.internal.ads.zzakj
                private final zzazl zzbru;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbru = zzazlVar;
                }

                @Override // com.google.android.gms.internal.ads.zzazn
                public final void run() {
                    this.zzbru.setException(new zzajr("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final <I, O> zzako<I, O> zzb(String str, zzajv<I> zzajvVar, zzajw<O> zzajwVar) {
        zzsi();
        return new zzako<>(this.zzdbd, str, zzajvVar, zzajwVar);
    }

    public final void zzc(final String str, final zzafn<? super zzajq> zzafnVar) {
        zzsi();
        this.zzdbd = zzdgs.zzb(this.zzdbd, new zzdgf(str, zzafnVar) { // from class: com.google.android.gms.internal.ads.zzakm
            private final zzafn zzcyv;
            private final String zzcyz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyz = str;
                this.zzcyv = zzafnVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                zzajq zzajqVar = (zzajq) obj;
                zzajqVar.zza(this.zzcyz, this.zzcyv);
                return zzdgs.zzaj(zzajqVar);
            }
        }, zzazd.zzdwj);
    }

    public final void zzd(final String str, final zzafn<? super zzajq> zzafnVar) {
        this.zzdbd = zzdgs.zzb(this.zzdbd, new zzded(str, zzafnVar) { // from class: com.google.android.gms.internal.ads.zzakl
            private final zzafn zzcyv;
            private final String zzcyz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyz = str;
                this.zzcyv = zzafnVar;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                zzajq zzajqVar = (zzajq) obj;
                zzajqVar.zzb(this.zzcyz, this.zzcyv);
                return zzajqVar;
            }
        }, zzazd.zzdwj);
    }
}
