package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* loaded from: classes.dex */
final class q5 extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f5551a;

    public q5(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.f5551a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == q5.class) {
            if (this == obj) {
                return true;
            }
            q5 q5Var = (q5) obj;
            if (this.f5551a == q5Var.f5551a && get() == q5Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5551a;
    }
}
