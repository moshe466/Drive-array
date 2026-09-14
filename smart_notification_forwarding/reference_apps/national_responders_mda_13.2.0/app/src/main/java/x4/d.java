package x4;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f15426b;

    /* renamed from: a, reason: collision with root package name */
    private final Set<f> f15427a = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = f15426b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f15426b;
                if (dVar == null) {
                    dVar = new d();
                    f15426b = dVar;
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<f> b() {
        Set<f> unmodifiableSet;
        synchronized (this.f15427a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f15427a);
        }
        return unmodifiableSet;
    }
}
