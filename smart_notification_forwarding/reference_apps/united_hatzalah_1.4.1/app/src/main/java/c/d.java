package c;

import F0.RunnableC0064o;
import J.C0125m;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.L;
import androidx.lifecycle.T;
import s2.C0684i;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3816a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ L f3817b;

    public /* synthetic */ d(L l3, int i) {
        this.f3816a = i;
        this.f3817b = l3;
    }

    @Override // F2.a
    public final Object invoke() {
        Bundle bundle;
        switch (this.f3816a) {
            case 0:
                this.f3817b.reportFullyDrawn();
                return C0684i.f6340a;
            case 1:
                return m.d(this.f3817b);
            case 2:
                L l3 = this.f3817b;
                Application application = l3.getApplication();
                if (l3.getIntent() != null) {
                    bundle = l3.getIntent().getExtras();
                } else {
                    bundle = null;
                }
                return new T(application, l3, bundle);
            default:
                L l4 = this.f3817b;
                x xVar = new x(new c(l4, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (!kotlin.jvm.internal.j.a(Looper.myLooper(), Looper.getMainLooper())) {
                        new Handler(Looper.getMainLooper()).post(new RunnableC0064o(3, l4, xVar));
                    } else {
                        l4.getLifecycle().a(new C0125m(1, xVar, l4));
                    }
                }
                return xVar;
        }
    }
}
