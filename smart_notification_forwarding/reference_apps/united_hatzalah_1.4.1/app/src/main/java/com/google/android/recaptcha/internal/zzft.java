package com.google.android.recaptcha.internal;

import P2.E;
import P2.G;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class zzft implements zzfo {
    private final E zza;
    private final zzgf zzb;
    private final zzhx zzc;
    private final Map zzd;

    public zzft(E e4, zzgf zzgfVar, zzhx zzhxVar, Map map) {
        this.zza = e4;
        this.zzb = zzgfVar;
        this.zzc = zzhxVar;
        this.zzd = map;
    }

    public static final /* synthetic */ void zzf(zzft zzftVar, zzuf zzufVar, zzgd zzgdVar) {
        zzjh zzb = zzjh.zzb();
        int zza = zzgdVar.zza();
        zzgx zzgxVar = (zzgx) zzftVar.zzd.get(Integer.valueOf(zzufVar.zzf()));
        if (zzgxVar != null) {
            int zzg = zzufVar.zzg();
            zzue[] zzueVarArr = (zzue[]) zzufVar.zzj().toArray(new zzue[0]);
            zzgxVar.zza(zzg, zzgdVar, (zzue[]) Arrays.copyOf(zzueVarArr, zzueVarArr.length));
            if (zza == zzgdVar.zza()) {
                zzgdVar.zzg(zzgdVar.zza() + 1);
            }
            zzb.zzf();
            long zza2 = zzb.zza(TimeUnit.MICROSECONDS);
            int i = zzbk.zza;
            int zzk = zzufVar.zzk();
            if (zzk != 1) {
                zzbk.zza(zzk - 2, zza2);
                return;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        throw new zzce(5, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzg(List list, zzgd zzgdVar, InterfaceC0763d interfaceC0763d) {
        Object g3 = G.g(new zzfq(zzgdVar, list, this, null), interfaceC0763d);
        if (g3 == EnumC0779a.f6740a) {
            return g3;
        }
        return C0684i.f6340a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzh(Exception exc, zzgd zzgdVar, InterfaceC0763d interfaceC0763d) {
        Object g3 = G.g(new zzfr(exc, zzgdVar, this, null), interfaceC0763d);
        if (g3 == EnumC0779a.f6740a) {
            return g3;
        }
        return C0684i.f6340a;
    }

    @Override // com.google.android.recaptcha.internal.zzfo
    public final void zza(String str) {
        G.r(this.zza, null, new zzfs(new zzgd(this.zzb), this, str, null), 3);
    }
}
