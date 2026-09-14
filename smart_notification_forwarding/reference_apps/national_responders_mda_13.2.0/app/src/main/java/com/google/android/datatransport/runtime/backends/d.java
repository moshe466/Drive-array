package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.a;
import com.google.auto.value.AutoValue;
import k1.h;

@AutoValue
/* loaded from: classes.dex */
public abstract class d {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract d a();

        public abstract a b(Iterable<h> iterable);

        public abstract a c(byte[] bArr);
    }

    public static a a() {
        return new a.b();
    }

    public abstract Iterable<h> b();

    public abstract byte[] c();
}
