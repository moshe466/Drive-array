package com.google.android.recaptcha.internal;

import P2.C0143b0;
import P2.C0161k0;
import P2.E;
import P2.G;
import P2.O;
import T.b;
import U2.n;
import W2.e;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class zzbi {
    private final E zza;
    private final E zzb;
    private final E zzc;
    private final E zzd;

    public zzbi() {
        C0161k0 c0161k0 = new C0161k0();
        e eVar = O.f1622a;
        this.zza = new U2.e(b.F(c0161k0, n.f2372a));
        U2.e b4 = G.b(new C0143b0(Executors.newSingleThreadExecutor()));
        G.r(b4, null, new zzbh(null), 3);
        this.zzb = b4;
        this.zzc = G.b(O.f1623b);
        U2.e b5 = G.b(new C0143b0(Executors.newSingleThreadExecutor()));
        G.r(b5, null, new zzbg(null), 3);
        this.zzd = b5;
    }

    public final E zza() {
        return this.zzc;
    }

    public final E zzb() {
        return this.zza;
    }

    public final E zzc() {
        return this.zzd;
    }

    public final E zzd() {
        return this.zzb;
    }
}
