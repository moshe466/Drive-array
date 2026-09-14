package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final d3 f4837f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ g3 f4838g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f3(g3 g3Var, d3 d3Var) {
        this.f4838g = g3Var;
        this.f4837f = d3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4838g.f4862g) {
            com.google.android.gms.common.a b10 = this.f4837f.b();
            if (b10.s()) {
                g3 g3Var = this.f4838g;
                g3Var.f4772f.startActivityForResult(GoogleApiActivity.a(g3Var.b(), (PendingIntent) b2.p.k(b10.l()), this.f4837f.a(), false), 1);
                return;
            }
            g3 g3Var2 = this.f4838g;
            if (g3Var2.f4865j.d(g3Var2.b(), b10.g(), null) != null) {
                g3 g3Var3 = this.f4838g;
                g3Var3.f4865j.y(g3Var3.b(), this.f4838g.f4772f, b10.g(), 2, this.f4838g);
            } else {
                if (b10.g() != 18) {
                    this.f4838g.l(b10, this.f4837f.a());
                    return;
                }
                g3 g3Var4 = this.f4838g;
                Dialog t10 = g3Var4.f4865j.t(g3Var4.b(), this.f4838g);
                g3 g3Var5 = this.f4838g;
                g3Var5.f4865j.u(g3Var5.b().getApplicationContext(), new e3(this, t10));
            }
        }
    }
}
