package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    static final ThreadLocal<e> f3604j = new ThreadLocal<>();

    /* renamed from: k, reason: collision with root package name */
    static Comparator<c> f3605k = new a();

    /* renamed from: g, reason: collision with root package name */
    long f3607g;

    /* renamed from: h, reason: collision with root package name */
    long f3608h;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<RecyclerView> f3606f = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<c> f3609i = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f3617d;
            if ((recyclerView == null) != (cVar2.f3617d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f3614a;
            if (z10 != cVar2.f3614a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f3615b - cVar.f3615b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f3616c - cVar2.f3616c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        int f3610a;

        /* renamed from: b, reason: collision with root package name */
        int f3611b;

        /* renamed from: c, reason: collision with root package name */
        int[] f3612c;

        /* renamed from: d, reason: collision with root package name */
        int f3613d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i12 = this.f3613d * 2;
            int[] iArr = this.f3612c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f3612c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i12 >= iArr.length) {
                int[] iArr3 = new int[i12 * 2];
                this.f3612c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f3612c;
            iArr4[i12] = i10;
            iArr4[i12 + 1] = i11;
            this.f3613d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f3612c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3613d = 0;
        }

        void c(RecyclerView recyclerView, boolean z10) {
            this.f3613d = 0;
            int[] iArr = this.f3612c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f3328q;
            if (recyclerView.f3326p == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z10) {
                if (!recyclerView.f3312i.p()) {
                    oVar.p(recyclerView.f3326p.c(), this);
                }
            } else if (!recyclerView.o0()) {
                oVar.o(this.f3610a, this.f3611b, recyclerView.f3319l0, this);
            }
            int i10 = this.f3613d;
            if (i10 > oVar.f3418m) {
                oVar.f3418m = i10;
                oVar.f3419n = z10;
                recyclerView.f3308g.K();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i10) {
            if (this.f3612c != null) {
                int i11 = this.f3613d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f3612c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i10, int i11) {
            this.f3610a = i10;
            this.f3611b = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3614a;

        /* renamed from: b, reason: collision with root package name */
        public int f3615b;

        /* renamed from: c, reason: collision with root package name */
        public int f3616c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f3617d;

        /* renamed from: e, reason: collision with root package name */
        public int f3618e;

        c() {
        }

        public void a() {
            this.f3614a = false;
            this.f3615b = 0;
            this.f3616c = 0;
            this.f3617d = null;
            this.f3618e = 0;
        }
    }

    private void b() {
        c cVar;
        int size = this.f3606f.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = this.f3606f.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f3317k0.c(recyclerView, false);
                i10 += recyclerView.f3317k0.f3613d;
            }
        }
        this.f3609i.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = this.f3606f.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f3317k0;
                int abs = Math.abs(bVar.f3610a) + Math.abs(bVar.f3611b);
                for (int i14 = 0; i14 < bVar.f3613d * 2; i14 += 2) {
                    if (i12 >= this.f3609i.size()) {
                        cVar = new c();
                        this.f3609i.add(cVar);
                    } else {
                        cVar = this.f3609i.get(i12);
                    }
                    int[] iArr = bVar.f3612c;
                    int i15 = iArr[i14 + 1];
                    cVar.f3614a = i15 <= abs;
                    cVar.f3615b = abs;
                    cVar.f3616c = i15;
                    cVar.f3617d = recyclerView2;
                    cVar.f3618e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f3609i, f3605k);
    }

    private void c(c cVar, long j10) {
        RecyclerView.d0 i10 = i(cVar.f3617d, cVar.f3618e, cVar.f3614a ? Long.MAX_VALUE : j10);
        if (i10 == null || i10.f3376b == null || !i10.r() || i10.s()) {
            return;
        }
        h(i10.f3376b.get(), j10);
    }

    private void d(long j10) {
        for (int i10 = 0; i10 < this.f3609i.size(); i10++) {
            c cVar = this.f3609i.get(i10);
            if (cVar.f3617d == null) {
                return;
            }
            c(cVar, j10);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.f3314j.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.d0 g02 = RecyclerView.g0(recyclerView.f3314j.i(i11));
            if (g02.f3377c == i10 && !g02.s()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j10) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.H && recyclerView.f3314j.j() != 0) {
            recyclerView.W0();
        }
        b bVar = recyclerView.f3317k0;
        bVar.c(recyclerView, true);
        if (bVar.f3613d != 0) {
            try {
                androidx.core.os.k.a("RV Nested Prefetch");
                recyclerView.f3319l0.f(recyclerView.f3326p);
                for (int i10 = 0; i10 < bVar.f3613d * 2; i10 += 2) {
                    i(recyclerView, bVar.f3612c[i10], j10);
                }
            } finally {
                androidx.core.os.k.b();
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f3308g;
        try {
            recyclerView.I0();
            RecyclerView.d0 I = vVar.I(i10, false, j10);
            if (I != null) {
                if (!I.r() || I.s()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.f3375a);
                }
            }
            return I;
        } finally {
            recyclerView.K0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f3606f.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f3607g == 0) {
            this.f3607g = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f3317k0.e(i10, i11);
    }

    void g(long j10) {
        b();
        d(j10);
    }

    public void j(RecyclerView recyclerView) {
        this.f3606f.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.k.a("RV Prefetch");
            if (!this.f3606f.isEmpty()) {
                int size = this.f3606f.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = this.f3606f.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f3608h);
                }
            }
        } finally {
            this.f3607g = 0L;
            androidx.core.os.k.b();
        }
    }
}
