package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* loaded from: classes.dex */
public final /* synthetic */ class h2 {
    public static <V> V a(k2<V> k2Var) {
        try {
            return k2Var.zza();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return k2Var.zza();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
