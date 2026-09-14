package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* loaded from: classes.dex */
final class s5 extends o5 {

    /* renamed from: a, reason: collision with root package name */
    private final r5 f5586a = new r5();

    @Override // com.google.android.gms.internal.measurement.o5
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
        this.f5586a.a(th, true).add(th2);
    }
}
