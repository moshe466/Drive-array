package com.google.android.recaptcha.internal;

import T.b;
import android.os.Build;
import s2.C0684i;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class zzab implements zzy {
    private final zzek zza;

    public zzab(zzek zzekVar) {
        this.zza = zzekVar;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final zzek zzb() {
        return this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzc(String str, InterfaceC0763d interfaceC0763d) {
        zzen zzb = zzz.zzb(this, str);
        int i = Build.VERSION.SDK_INT;
        zzb.zza();
        zztf zzf = zzti.zzf();
        zztg zzf2 = zzth.zzf();
        zzf2.zzw(String.valueOf(i));
        zzf.zze(b.B(zzf2.zzk()));
        return zzz.zza(this, (zzti) zzf.zzk());
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzd(zzse zzseVar, InterfaceC0763d interfaceC0763d) {
        zzz.zzc(this).zza();
        return C0684i.f6340a;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final void zze(zzsr zzsrVar) {
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final boolean zzf() {
        return true;
    }
}
