package com.google.firebase.installations;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.a;

@AutoValue
/* loaded from: classes.dex */
public abstract class l {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract l a();

        public abstract a b(String str);

        public abstract a c(long j10);

        public abstract a d(long j10);
    }

    public static a a() {
        return new a.b();
    }

    public abstract String b();

    public abstract long c();

    public abstract long d();
}
