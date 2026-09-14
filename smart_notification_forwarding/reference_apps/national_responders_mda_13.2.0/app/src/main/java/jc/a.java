package jc;

import java.util.Queue;
import kc.f;

/* loaded from: classes.dex */
public class a implements ic.b {

    /* renamed from: f, reason: collision with root package name */
    String f11095f;

    /* renamed from: g, reason: collision with root package name */
    f f11096g;

    /* renamed from: h, reason: collision with root package name */
    Queue<d> f11097h;

    public a(f fVar, Queue<d> queue) {
        this.f11096g = fVar;
        this.f11095f = fVar.i();
        this.f11097h = queue;
    }

    private void g(b bVar, ic.d dVar, String str, Object[] objArr, Throwable th) {
        d dVar2 = new d();
        dVar2.j(System.currentTimeMillis());
        dVar2.c(bVar);
        dVar2.d(this.f11096g);
        dVar2.e(this.f11095f);
        dVar2.f(dVar);
        dVar2.g(str);
        dVar2.h(Thread.currentThread().getName());
        dVar2.b(objArr);
        dVar2.i(th);
        this.f11097h.add(dVar2);
    }

    private void h(b bVar, ic.d dVar, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            g(bVar, dVar, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            g(bVar, dVar, str, new Object[]{obj, obj2}, null);
        }
    }

    private void i(b bVar, ic.d dVar, String str, Object[] objArr) {
        Throwable a10 = kc.b.a(objArr);
        if (a10 != null) {
            g(bVar, dVar, str, kc.b.b(objArr), a10);
        } else {
            g(bVar, dVar, str, objArr, null);
        }
    }

    private void j(b bVar, ic.d dVar, String str, Throwable th) {
        g(bVar, dVar, str, null, th);
    }

    private void k(b bVar, ic.d dVar, String str, Object obj) {
        g(bVar, dVar, str, new Object[]{obj}, null);
    }

    @Override // ic.b
    public void a(String str) {
        j(b.ERROR, null, str, null);
    }

    @Override // ic.b
    public void b(String str, Object... objArr) {
        i(b.DEBUG, null, str, objArr);
    }

    @Override // ic.b
    public void c(String str, Object obj, Object obj2) {
        h(b.DEBUG, null, str, obj, obj2);
    }

    @Override // ic.b
    public void d(String str, Throwable th) {
        j(b.DEBUG, null, str, th);
    }

    @Override // ic.b
    public void e(String str) {
        j(b.DEBUG, null, str, null);
    }

    @Override // ic.b
    public void f(String str, Object obj) {
        k(b.DEBUG, null, str, obj);
    }
}
