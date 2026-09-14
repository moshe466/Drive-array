package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f493a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f494b = new CopyOnWriteArrayList<>();

    public g(boolean z10) {
        this.f493a = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f494b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f493a;
    }

    public final void d() {
        Iterator<a> it = this.f494b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f494b.remove(aVar);
    }

    public final void f(boolean z10) {
        this.f493a = z10;
    }
}
