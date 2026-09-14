package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzavn {

    @GuardedBy("this")
    private BigInteger zzdrn = BigInteger.ONE;

    @GuardedBy("this")
    private String zzdir = "0";

    public final synchronized String zzvp() {
        String bigInteger;
        bigInteger = this.zzdrn.toString();
        this.zzdrn = this.zzdrn.add(BigInteger.ONE);
        this.zzdir = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzvq() {
        return this.zzdir;
    }
}
