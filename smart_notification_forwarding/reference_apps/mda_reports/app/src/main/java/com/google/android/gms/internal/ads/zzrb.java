package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class zzrb implements Comparator<zzqp> {
    public zzrb(zzqy zzqyVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzqp zzqpVar, zzqp zzqpVar2) {
        zzqp zzqpVar3 = zzqpVar;
        zzqp zzqpVar4 = zzqpVar2;
        if (zzqpVar3.b() < zzqpVar4.b()) {
            return -1;
        }
        if (zzqpVar3.b() > zzqpVar4.b()) {
            return 1;
        }
        if (zzqpVar3.a() < zzqpVar4.a()) {
            return -1;
        }
        if (zzqpVar3.a() > zzqpVar4.a()) {
            return 1;
        }
        float d = (zzqpVar3.d() - zzqpVar3.b()) * (zzqpVar3.c() - zzqpVar3.a());
        float d2 = (zzqpVar4.d() - zzqpVar4.b()) * (zzqpVar4.c() - zzqpVar4.a());
        if (d > d2) {
            return -1;
        }
        return d < d2 ? 1 : 0;
    }
}
