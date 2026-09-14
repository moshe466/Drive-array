package q1;

import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f13458a;

    /* renamed from: b, reason: collision with root package name */
    private final r1.c f13459b;

    /* renamed from: c, reason: collision with root package name */
    private final n f13460c;

    /* renamed from: d, reason: collision with root package name */
    private final s1.b f13461d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Executor executor, r1.c cVar, n nVar, s1.b bVar) {
        this.f13458a = executor;
        this.f13459b = cVar;
        this.f13460c = nVar;
        this.f13461d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(l lVar) {
        Iterator<k1.m> it = lVar.f13459b.C().iterator();
        while (it.hasNext()) {
            lVar.f13460c.a(it.next(), 1);
        }
        return null;
    }

    public void a() {
        this.f13458a.execute(j.a(this));
    }
}
