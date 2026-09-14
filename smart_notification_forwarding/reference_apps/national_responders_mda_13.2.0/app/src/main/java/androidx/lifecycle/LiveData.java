package androidx.lifecycle;

import androidx.lifecycle.h;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: j, reason: collision with root package name */
    static final Object f3162j = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f3163a;

    /* renamed from: b, reason: collision with root package name */
    private j.b<r<? super T>, LiveData<T>.c> f3164b;

    /* renamed from: c, reason: collision with root package name */
    int f3165c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3166d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f3167e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f3168f;

    /* renamed from: g, reason: collision with root package name */
    private int f3169g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3170h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3171i;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.c implements j {

        /* renamed from: e, reason: collision with root package name */
        final l f3172e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f3173f;

        @Override // androidx.lifecycle.j
        public void d(l lVar, h.b bVar) {
            h.c b10 = this.f3172e.b().b();
            if (b10 == h.c.DESTROYED) {
                this.f3173f.i(this.f3175a);
                return;
            }
            h.c cVar = null;
            while (cVar != b10) {
                h(j());
                cVar = b10;
                b10 = this.f3172e.b().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        void i() {
            this.f3172e.b().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j() {
            return this.f3172e.b().b().isAtLeast(h.c.STARTED);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3163a) {
                obj = LiveData.this.f3168f;
                LiveData.this.f3168f = LiveData.f3162j;
            }
            LiveData.this.j(obj);
        }
    }

    /* loaded from: classes.dex */
    private class b extends LiveData<T>.c {
        b(LiveData liveData, r<? super T> rVar) {
            super(rVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final r<? super T> f3175a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3176b;

        /* renamed from: c, reason: collision with root package name */
        int f3177c = -1;

        c(r<? super T> rVar) {
            this.f3175a = rVar;
        }

        void h(boolean z10) {
            if (z10 == this.f3176b) {
                return;
            }
            this.f3176b = z10;
            LiveData.this.b(z10 ? 1 : -1);
            if (this.f3176b) {
                LiveData.this.d(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public LiveData() {
        this.f3163a = new Object();
        this.f3164b = new j.b<>();
        this.f3165c = 0;
        Object obj = f3162j;
        this.f3168f = obj;
        new a();
        this.f3167e = obj;
        this.f3169g = -1;
    }

    public LiveData(T t10) {
        this.f3163a = new Object();
        this.f3164b = new j.b<>();
        this.f3165c = 0;
        this.f3168f = f3162j;
        new a();
        this.f3167e = t10;
        this.f3169g = 0;
    }

    static void a(String str) {
        if (i.a.d().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(LiveData<T>.c cVar) {
        if (cVar.f3176b) {
            if (!cVar.j()) {
                cVar.h(false);
                return;
            }
            int i10 = cVar.f3177c;
            int i11 = this.f3169g;
            if (i10 >= i11) {
                return;
            }
            cVar.f3177c = i11;
            cVar.f3175a.a((Object) this.f3167e);
        }
    }

    void b(int i10) {
        int i11 = this.f3165c;
        this.f3165c = i10 + i11;
        if (this.f3166d) {
            return;
        }
        this.f3166d = true;
        while (true) {
            try {
                int i12 = this.f3165c;
                if (i11 == i12) {
                    return;
                }
                boolean z10 = i11 == 0 && i12 > 0;
                boolean z11 = i11 > 0 && i12 == 0;
                if (z10) {
                    g();
                } else if (z11) {
                    h();
                }
                i11 = i12;
            } finally {
                this.f3166d = false;
            }
        }
    }

    void d(LiveData<T>.c cVar) {
        if (this.f3170h) {
            this.f3171i = true;
            return;
        }
        this.f3170h = true;
        do {
            this.f3171i = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                j.b<r<? super T>, LiveData<T>.c>.d j10 = this.f3164b.j();
                while (j10.hasNext()) {
                    c((c) j10.next().getValue());
                    if (this.f3171i) {
                        break;
                    }
                }
            }
        } while (this.f3171i);
        this.f3170h = false;
    }

    public T e() {
        T t10 = (T) this.f3167e;
        if (t10 != f3162j) {
            return t10;
        }
        return null;
    }

    public void f(r<? super T> rVar) {
        a("observeForever");
        b bVar = new b(this, rVar);
        LiveData<T>.c t10 = this.f3164b.t(rVar, bVar);
        if (t10 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (t10 != null) {
            return;
        }
        bVar.h(true);
    }

    protected void g() {
    }

    protected void h() {
    }

    public void i(r<? super T> rVar) {
        a("removeObserver");
        LiveData<T>.c u10 = this.f3164b.u(rVar);
        if (u10 == null) {
            return;
        }
        u10.i();
        u10.h(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(T t10) {
        a("setValue");
        this.f3169g++;
        this.f3167e = t10;
        d(null);
    }
}
