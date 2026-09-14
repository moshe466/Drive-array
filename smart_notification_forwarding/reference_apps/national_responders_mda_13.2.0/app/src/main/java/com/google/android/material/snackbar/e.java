package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class e {

    /* renamed from: e, reason: collision with root package name */
    private static e f6945e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f6946a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f6947b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    private c f6948c;

    /* renamed from: d, reason: collision with root package name */
    private c f6949d;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e.this.c((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<b> f6951a;

        /* renamed from: b, reason: collision with root package name */
        int f6952b;

        /* renamed from: c, reason: collision with root package name */
        boolean f6953c;

        boolean a(b bVar) {
            return bVar != null && this.f6951a.get() == bVar;
        }
    }

    private e() {
    }

    private boolean a(c cVar, int i10) {
        b bVar = cVar.f6951a.get();
        if (bVar == null) {
            return false;
        }
        this.f6947b.removeCallbacksAndMessages(cVar);
        bVar.a(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        if (f6945e == null) {
            f6945e = new e();
        }
        return f6945e;
    }

    private boolean d(b bVar) {
        c cVar = this.f6948c;
        return cVar != null && cVar.a(bVar);
    }

    private void g(c cVar) {
        int i10 = cVar.f6952b;
        if (i10 == -2) {
            return;
        }
        if (i10 <= 0) {
            i10 = i10 == -1 ? 1500 : 2750;
        }
        this.f6947b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f6947b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
    }

    void c(c cVar) {
        synchronized (this.f6946a) {
            if (this.f6948c == cVar || this.f6949d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public void e(b bVar) {
        synchronized (this.f6946a) {
            if (d(bVar)) {
                c cVar = this.f6948c;
                if (!cVar.f6953c) {
                    cVar.f6953c = true;
                    this.f6947b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f6946a) {
            if (d(bVar)) {
                c cVar = this.f6948c;
                if (cVar.f6953c) {
                    cVar.f6953c = false;
                    g(cVar);
                }
            }
        }
    }
}
