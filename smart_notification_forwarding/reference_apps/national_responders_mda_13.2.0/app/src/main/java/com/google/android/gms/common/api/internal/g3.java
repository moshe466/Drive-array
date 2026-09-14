package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class g3 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: g, reason: collision with root package name */
    protected volatile boolean f4862g;

    /* renamed from: h, reason: collision with root package name */
    protected final AtomicReference f4863h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f4864i;

    /* renamed from: j, reason: collision with root package name */
    protected final com.google.android.gms.common.b f4865j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g3(k kVar, com.google.android.gms.common.b bVar) {
        super(kVar);
        this.f4863h = new AtomicReference(null);
        this.f4864i = new m2.n(Looper.getMainLooper());
        this.f4865j = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(com.google.android.gms.common.a aVar, int i10) {
        this.f4863h.set(null);
        m(aVar, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.f4863h.set(null);
        n();
    }

    private static final int p(d3 d3Var) {
        if (d3Var == null) {
            return -1;
        }
        return d3Var.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(int i10, int i11, Intent intent) {
        d3 d3Var = (d3) this.f4863h.get();
        if (i10 != 1) {
            if (i10 == 2) {
                int i12 = this.f4865j.i(b());
                if (i12 == 0) {
                    o();
                    return;
                } else {
                    if (d3Var == null) {
                        return;
                    }
                    if (d3Var.b().g() == 18 && i12 == 18) {
                        return;
                    }
                }
            }
        } else if (i11 == -1) {
            o();
            return;
        } else if (i11 == 0) {
            if (d3Var == null) {
                return;
            }
            l(new com.google.android.gms.common.a(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, d3Var.b().toString()), p(d3Var));
            return;
        }
        if (d3Var != null) {
            l(d3Var.b(), d3Var.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f4863h.set(bundle.getBoolean("resolving_error", false) ? new d3(new com.google.android.gms.common.a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i(Bundle bundle) {
        super.i(bundle);
        d3 d3Var = (d3) this.f4863h.get();
        if (d3Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", d3Var.a());
        bundle.putInt("failed_status", d3Var.b().g());
        bundle.putParcelable("failed_resolution", d3Var.b().l());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f4862g = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f4862g = false;
    }

    protected abstract void m(com.google.android.gms.common.a aVar, int i10);

    protected abstract void n();

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        l(new com.google.android.gms.common.a(13, null), p((d3) this.f4863h.get()));
    }

    public final void s(com.google.android.gms.common.a aVar, int i10) {
        d3 d3Var = new d3(aVar, i10);
        AtomicReference atomicReference = this.f4863h;
        while (!atomicReference.compareAndSet(null, d3Var)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.f4864i.post(new f3(this, d3Var));
    }
}
