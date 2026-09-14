package v6;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class a extends rb.c {
    private RunnableC0303a C;

    /* renamed from: v6.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0303a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private boolean f14665f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f14666g = false;

        /* renamed from: h, reason: collision with root package name */
        private Handler f14667h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<rb.c> f14668i;

        public RunnableC0303a(a aVar, Handler handler, rb.c cVar) {
            this.f14665f = false;
            this.f14667h = handler;
            this.f14665f = false;
            this.f14668i = new WeakReference<>(cVar);
        }

        public void a() {
            this.f14666g = true;
            this.f14667h.post(this);
        }

        public void b() {
            this.f14666g = false;
            this.f14668i.clear();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            if (!this.f14666g || this.f14668i.get() == null) {
                return;
            }
            if (this.f14665f) {
                this.f14668i.get().setAutoFocus(this.f14665f);
                i10 = 20000;
            } else {
                this.f14668i.get().setAutoFocus(this.f14665f);
                i10 = 2000;
            }
            this.f14665f = !this.f14665f;
            this.f14667h.postDelayed(this, i10);
        }
    }

    public a(Context context) {
        super(context);
        setAutoFocus(true);
        setFormats(rb.a.f13844s);
        setAspectTolerance(0.1f);
        this.C = new RunnableC0303a(this, new Handler(), this);
    }

    @Override // qb.a
    public void g(int i10) {
        super.g(i10);
        this.C.a();
    }

    @Override // qb.a
    public void h() {
        super.h();
        this.C.b();
    }
}
