package p2;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<j, List<Throwable>> f13044a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<Throwable> f13045b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z10) {
        while (true) {
            Reference<? extends Throwable> poll = this.f13045b.poll();
            if (poll == null) {
                break;
            }
            this.f13044a.remove(poll);
        }
        List<Throwable> list = this.f13044a.get(new j(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f13044a.putIfAbsent(new j(th, this.f13045b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
