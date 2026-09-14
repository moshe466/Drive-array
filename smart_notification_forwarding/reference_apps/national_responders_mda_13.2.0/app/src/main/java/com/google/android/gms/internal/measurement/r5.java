package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
final class r5 {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<q5, List<Throwable>> f5569a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<Throwable> f5570b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z10) {
        while (true) {
            Reference<? extends Throwable> poll = this.f5570b.poll();
            if (poll == null) {
                break;
            }
            this.f5569a.remove(poll);
        }
        List<Throwable> list = this.f5569a.get(new q5(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f5569a.putIfAbsent(new q5(th, this.f5570b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
