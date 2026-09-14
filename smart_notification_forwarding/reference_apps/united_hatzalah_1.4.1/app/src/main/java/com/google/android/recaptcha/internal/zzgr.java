package com.google.android.recaptcha.internal;

import F2.p;
import kotlin.jvm.internal.k;
import s2.C0684i;

/* loaded from: classes.dex */
final class zzgr extends k implements p {
    final /* synthetic */ zzgd zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgr(zzgd zzgdVar, String str, int i) {
        super(2);
        this.zza = zzgdVar;
        this.zzb = str;
        this.zzc = i;
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        this.zza.zzi().zzb(this.zzb, (String) obj2);
        int i = this.zzc;
        if (i != -1) {
            this.zza.zzc().zze(i, objArr);
        }
        return C0684i.f6340a;
    }
}
