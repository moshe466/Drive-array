package com.google.android.play.core.internal;

/* loaded from: classes.dex */
final class bm extends bi {
    private final bl a = new bl();

    @Override // com.google.android.play.core.internal.bi
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.a.a(th, true).add(th2);
    }
}
