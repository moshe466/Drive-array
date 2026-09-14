package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    final l.a<RecyclerView.d0, a> f3656a = new l.a<>();

    /* renamed from: b, reason: collision with root package name */
    final l.d<RecyclerView.d0> f3657b = new l.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        static androidx.core.util.e<a> f3658d = new androidx.core.util.f(20);

        /* renamed from: a, reason: collision with root package name */
        int f3659a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.l.c f3660b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.l.c f3661c;

        private a() {
        }

        static void a() {
            do {
            } while (f3658d.b() != null);
        }

        static a b() {
            a b10 = f3658d.b();
            return b10 == null ? new a() : b10;
        }

        static void c(a aVar) {
            aVar.f3659a = 0;
            aVar.f3660b = null;
            aVar.f3661c = null;
            f3658d.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    private RecyclerView.l.c l(RecyclerView.d0 d0Var, int i10) {
        a n10;
        RecyclerView.l.c cVar;
        int f10 = this.f3656a.f(d0Var);
        if (f10 >= 0 && (n10 = this.f3656a.n(f10)) != null) {
            int i11 = n10.f3659a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                n10.f3659a = i12;
                if (i10 == 4) {
                    cVar = n10.f3660b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = n10.f3661c;
                }
                if ((i12 & 12) == 0) {
                    this.f3656a.k(f10);
                    a.c(n10);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f3656a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3656a.put(d0Var, aVar);
        }
        aVar.f3659a |= 2;
        aVar.f3660b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.d0 d0Var) {
        a aVar = this.f3656a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3656a.put(d0Var, aVar);
        }
        aVar.f3659a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j10, RecyclerView.d0 d0Var) {
        this.f3657b.m(j10, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f3656a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3656a.put(d0Var, aVar);
        }
        aVar.f3661c = cVar;
        aVar.f3659a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f3656a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f3656a.put(d0Var, aVar);
        }
        aVar.f3660b = cVar;
        aVar.f3659a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f3656a.clear();
        this.f3657b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.d0 g(long j10) {
        return this.f3657b.h(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.f3656a.get(d0Var);
        return (aVar == null || (aVar.f3659a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.f3656a.get(d0Var);
        return (aVar == null || (aVar.f3659a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        RecyclerView.l.c cVar;
        RecyclerView.l.c cVar2;
        for (int size = this.f3656a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 i10 = this.f3656a.i(size);
            a k10 = this.f3656a.k(size);
            int i11 = k10.f3659a;
            if ((i11 & 3) != 3) {
                if ((i11 & 1) != 0) {
                    cVar = k10.f3660b;
                    cVar2 = cVar != null ? k10.f3661c : null;
                } else {
                    if ((i11 & 14) != 14) {
                        if ((i11 & 12) == 12) {
                            bVar.d(i10, k10.f3660b, k10.f3661c);
                        } else if ((i11 & 4) != 0) {
                            cVar = k10.f3660b;
                        } else if ((i11 & 8) == 0) {
                        }
                        a.c(k10);
                    }
                    bVar.b(i10, k10.f3660b, k10.f3661c);
                    a.c(k10);
                }
                bVar.c(i10, cVar, cVar2);
                a.c(k10);
            }
            bVar.a(i10);
            a.c(k10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.d0 d0Var) {
        a aVar = this.f3656a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f3659a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.d0 d0Var) {
        int p10 = this.f3657b.p() - 1;
        while (true) {
            if (p10 < 0) {
                break;
            }
            if (d0Var == this.f3657b.q(p10)) {
                this.f3657b.o(p10);
                break;
            }
            p10--;
        }
        a remove = this.f3656a.remove(d0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
