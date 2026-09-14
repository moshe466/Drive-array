package h8;

import d8.b;
import e8.c;
import java.util.concurrent.atomic.AtomicReference;
import y7.d;

/* loaded from: classes.dex */
public final class a<T> extends AtomicReference<c8.a> implements d<T>, c8.a {

    /* renamed from: f, reason: collision with root package name */
    final c<? super T> f10497f;

    /* renamed from: g, reason: collision with root package name */
    final c<? super Throwable> f10498g;

    /* renamed from: h, reason: collision with root package name */
    final e8.a f10499h;

    /* renamed from: i, reason: collision with root package name */
    final c<? super c8.a> f10500i;

    public a(c<? super T> cVar, c<? super Throwable> cVar2, e8.a aVar, c<? super c8.a> cVar3) {
        this.f10497f = cVar;
        this.f10498g = cVar2;
        this.f10499h = aVar;
        this.f10500i = cVar3;
    }

    @Override // y7.d
    public void a(Throwable th) {
        if (e()) {
            return;
        }
        dispose();
        try {
            this.f10498g.a(th);
        } catch (Throwable th2) {
            b.b(th2);
            j8.a.c(new d8.a(th, th2));
        }
    }

    @Override // y7.d
    public void b() {
        if (e()) {
            return;
        }
        dispose();
        try {
            this.f10499h.run();
        } catch (Throwable th) {
            b.b(th);
            j8.a.c(th);
        }
    }

    @Override // y7.d
    public void c(c8.a aVar) {
        if (f8.a.setOnce(this, aVar)) {
            try {
                this.f10500i.a(this);
            } catch (Throwable th) {
                b.b(th);
                a(th);
            }
        }
    }

    @Override // y7.d
    public void d(T t10) {
        if (e()) {
            return;
        }
        try {
            this.f10497f.a(t10);
        } catch (Throwable th) {
            b.b(th);
            a(th);
        }
    }

    @Override // c8.a
    public void dispose() {
        f8.a.dispose(this);
    }

    public boolean e() {
        return get() == f8.a.DISPOSED;
    }
}
