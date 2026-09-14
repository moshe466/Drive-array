package com.google.android.recaptcha.internal;

import T.b;
import java.util.Collections;
import java.util.Map;
import kotlin.jvm.internal.j;
import s2.C0682g;
import s2.C0684i;
import s2.InterfaceC0678c;
import w2.InterfaceC0763d;

/* loaded from: classes.dex */
public final class zzp implements zzy {
    private final zzek zza;
    private final InterfaceC0678c zzb;
    private boolean zzc;

    public zzp(zzek zzekVar) {
        this.zza = zzekVar;
        int i = zzav.zza;
        this.zzb = b.A(zzo.zza);
        this.zzc = true;
    }

    private final zzbf zzg() {
        return (zzbf) ((C0682g) this.zzb).a();
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final int zza() {
        return 25;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final zzek zzb() {
        return this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzc(String str, InterfaceC0763d interfaceC0763d) {
        zzen zzb = zzz.zzb(this, str);
        String zza = zzg().zza();
        zzb.zza();
        zztf zzf = zzti.zzf();
        zztg zzf2 = zzth.zzf();
        zzf2.zzw(zza);
        zzf.zze(b.B(zzf2.zzk()));
        return zzz.zza(this, (zzti) zzf.zzk());
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzd(zzse zzseVar, InterfaceC0763d interfaceC0763d) {
        zzen zzc = zzz.zzc(this);
        int length = zzseVar.zzl().length();
        C0684i c0684i = C0684i.f6340a;
        if (length == 0) {
            this.zzc = false;
            zzc.zzb(new zzbd(zzbb.zzb, zzba.zzab, null));
            return c0684i;
        }
        zzbf zzg = zzg();
        Map singletonMap = Collections.singletonMap("_GRECAPTCHA_KC", zzseVar.zzl());
        j.d(singletonMap, "singletonMap(...)");
        zzg.zzb(singletonMap);
        zzc.zza();
        return c0684i;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final void zze(zzsr zzsrVar) {
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final boolean zzf() {
        return this.zzc;
    }
}
