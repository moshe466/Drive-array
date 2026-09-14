package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class k3<T> implements Serializable {
    public static <T> k3<T> a(T t10) {
        return new m3(n3.b(t10));
    }

    public static <T> k3<T> d() {
        return g3.f5327f;
    }

    public abstract boolean b();

    public abstract T c();
}
