package x4;

import java.util.Iterator;
import java.util.Set;
import r3.q;

/* loaded from: classes.dex */
public class c implements i {

    /* renamed from: a, reason: collision with root package name */
    private final String f15424a;

    /* renamed from: b, reason: collision with root package name */
    private final d f15425b;

    c(Set<f> set, d dVar) {
        this.f15424a = d(set);
        this.f15425b = dVar;
    }

    public static r3.d<i> b() {
        return r3.d.a(i.class).b(q.j(f.class)).f(b.b()).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ i c(r3.e eVar) {
        return new c(eVar.b(f.class), d.a());
    }

    private static String d(Set<f> set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb2.append(next.b());
            sb2.append('/');
            sb2.append(next.c());
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    @Override // x4.i
    public String a() {
        if (this.f15425b.b().isEmpty()) {
            return this.f15424a;
        }
        return this.f15424a + ' ' + d(this.f15425b.b());
    }
}
