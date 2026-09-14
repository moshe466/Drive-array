package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class g implements c {
    public static final g a = new g("INSTANCE", 0);
    private static final AtomicReference<a> b;

    static {
        new g[1][0] = a;
        b = new AtomicReference<>(null);
    }

    private g(String str, int i) {
    }

    public static void a(a aVar) {
        b.compareAndSet(null, aVar);
    }

    @Override // com.google.android.play.core.splitinstall.c
    public final a a() {
        return b.get();
    }
}
