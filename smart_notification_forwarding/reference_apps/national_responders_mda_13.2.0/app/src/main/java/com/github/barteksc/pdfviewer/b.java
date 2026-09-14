package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import h1.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final PriorityQueue<e1.b> f4607a;

    /* renamed from: b, reason: collision with root package name */
    private final PriorityQueue<e1.b> f4608b;

    /* renamed from: c, reason: collision with root package name */
    private final List<e1.b> f4609c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f4610d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private final a f4611e;

    /* loaded from: classes.dex */
    class a implements Comparator<e1.b> {
        a(b bVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e1.b bVar, e1.b bVar2) {
            if (bVar.a() == bVar2.a()) {
                return 0;
            }
            return bVar.a() > bVar2.a() ? 1 : -1;
        }
    }

    public b() {
        a aVar = new a(this);
        this.f4611e = aVar;
        this.f4608b = new PriorityQueue<>(a.C0186a.f10427a, aVar);
        this.f4607a = new PriorityQueue<>(a.C0186a.f10427a, aVar);
        this.f4609c = new ArrayList();
    }

    private void a(Collection<e1.b> collection, e1.b bVar) {
        Iterator<e1.b> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next().equals(bVar)) {
                bVar.d().recycle();
                return;
            }
        }
        collection.add(bVar);
    }

    private static e1.b e(PriorityQueue<e1.b> priorityQueue, e1.b bVar) {
        Iterator<e1.b> it = priorityQueue.iterator();
        while (it.hasNext()) {
            e1.b next = it.next();
            if (next.equals(bVar)) {
                return next;
            }
        }
        return null;
    }

    private void h() {
        synchronized (this.f4610d) {
            while (this.f4608b.size() + this.f4607a.size() >= a.C0186a.f10427a && !this.f4607a.isEmpty()) {
                this.f4607a.poll().d().recycle();
            }
            while (this.f4608b.size() + this.f4607a.size() >= a.C0186a.f10427a && !this.f4608b.isEmpty()) {
                this.f4608b.poll().d().recycle();
            }
        }
    }

    public void b(e1.b bVar) {
        synchronized (this.f4610d) {
            h();
            this.f4608b.offer(bVar);
        }
    }

    public void c(e1.b bVar) {
        synchronized (this.f4609c) {
            while (this.f4609c.size() >= a.C0186a.f10428b) {
                this.f4609c.remove(0).d().recycle();
            }
            a(this.f4609c, bVar);
        }
    }

    public boolean d(int i10, RectF rectF) {
        e1.b bVar = new e1.b(i10, null, rectF, true, 0);
        synchronized (this.f4609c) {
            Iterator<e1.b> it = this.f4609c.iterator();
            while (it.hasNext()) {
                if (it.next().equals(bVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<e1.b> f() {
        ArrayList arrayList;
        synchronized (this.f4610d) {
            arrayList = new ArrayList(this.f4607a);
            arrayList.addAll(this.f4608b);
        }
        return arrayList;
    }

    public List<e1.b> g() {
        List<e1.b> list;
        synchronized (this.f4609c) {
            list = this.f4609c;
        }
        return list;
    }

    public void i() {
        synchronized (this.f4610d) {
            this.f4607a.addAll(this.f4608b);
            this.f4608b.clear();
        }
    }

    public void j() {
        synchronized (this.f4610d) {
            Iterator<e1.b> it = this.f4607a.iterator();
            while (it.hasNext()) {
                it.next().d().recycle();
            }
            this.f4607a.clear();
            Iterator<e1.b> it2 = this.f4608b.iterator();
            while (it2.hasNext()) {
                it2.next().d().recycle();
            }
            this.f4608b.clear();
        }
        synchronized (this.f4609c) {
            Iterator<e1.b> it3 = this.f4609c.iterator();
            while (it3.hasNext()) {
                it3.next().d().recycle();
            }
            this.f4609c.clear();
        }
    }

    public boolean k(int i10, RectF rectF, int i11) {
        e1.b bVar = new e1.b(i10, null, rectF, false, 0);
        synchronized (this.f4610d) {
            e1.b e10 = e(this.f4607a, bVar);
            boolean z10 = true;
            if (e10 == null) {
                if (e(this.f4608b, bVar) == null) {
                    z10 = false;
                }
                return z10;
            }
            this.f4607a.remove(e10);
            e10.f(i11);
            this.f4608b.offer(e10);
            return true;
        }
    }
}
