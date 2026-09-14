package com.google.android.gms.internal.ads;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class zzdej<T> implements Serializable {
    public static <T> zzdej<T> zzab(@NullableDecl T t) {
        return t == null ? zzddy.a : new zzdel(t);
    }

    @NullableDecl
    public abstract T zzaqt();
}
