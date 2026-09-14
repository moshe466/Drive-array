package com.google.android.recaptcha.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbp extends AbstractC0787c {
    Object zza;
    Object zzb;
    long zzc;
    long zzd;
    double zze;
    /* synthetic */ Object zzf;
    final /* synthetic */ zzbq zzg;
    int zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbp(zzbq zzbqVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzg = zzbqVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.zzf = obj;
        this.zzh |= Integer.MIN_VALUE;
        return this.zzg.zza(null, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, this);
    }
}
