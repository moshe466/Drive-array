package ub;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.c0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<c0> f14575a = new LinkedHashSet();

    public synchronized void a(c0 c0Var) {
        this.f14575a.remove(c0Var);
    }

    public synchronized void b(c0 c0Var) {
        this.f14575a.add(c0Var);
    }

    public synchronized boolean c(c0 c0Var) {
        return this.f14575a.contains(c0Var);
    }
}
