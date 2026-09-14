package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0277l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3433a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3434b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3435c;

    public /* synthetic */ RunnableC0277l(z0 z0Var, View view, Rect rect) {
        this.f3434b = view;
        this.f3435c = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3433a) {
            case 0:
                E0 operation = (E0) this.f3434b;
                C0279n this$0 = (C0279n) this.f3435c;
                kotlin.jvm.internal.j.e(operation, "$operation");
                kotlin.jvm.internal.j.e(this$0, "this$0");
                if (AbstractC0272g0.J(2)) {
                    operation.toString();
                }
                operation.c(this$0);
                return;
            default:
                z0.g((View) this.f3434b, (Rect) this.f3435c);
                return;
        }
    }

    public /* synthetic */ RunnableC0277l(E0 e02, C0279n c0279n) {
        this.f3434b = e02;
        this.f3435c = c0279n;
    }
}
