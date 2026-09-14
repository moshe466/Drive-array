package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class i {
    private static final AtomicReference<k> a = new AtomicReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a() {
        return a.get();
    }

    public static void a(k kVar) {
        a.compareAndSet(null, kVar);
    }
}
