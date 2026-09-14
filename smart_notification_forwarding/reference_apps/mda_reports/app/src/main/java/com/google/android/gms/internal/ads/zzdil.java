package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class zzdil {
    private static final CopyOnWriteArrayList<zzdim> zzgxz = new CopyOnWriteArrayList<>();

    public static zzdim zzgu(String str) {
        Iterator<zzdim> it = zzgxz.iterator();
        while (it.hasNext()) {
            zzdim next = it.next();
            if (next.zzgv(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
