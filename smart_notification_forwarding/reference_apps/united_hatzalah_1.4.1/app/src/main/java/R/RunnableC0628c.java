package r;

import F0.RunnableC0091v;
import android.os.Bundle;
import android.os.Handler;

/* renamed from: r.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0628c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6161a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6162b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6163c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6164d;

    public /* synthetic */ RunnableC0628c() {
        this.f6161a = 2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        switch (this.f6161a) {
            case 0:
                ((BinderC0632g) this.f6164d).f6182b.extraCallback((String) this.f6162b, (Bundle) this.f6163c);
                return;
            case 1:
                ((BinderC0632g) this.f6164d).f6182b.onPostMessage((String) this.f6162b, (Bundle) this.f6163c);
                return;
            default:
                try {
                    obj = ((G.e) this.f6162b).call();
                } catch (Exception unused) {
                    obj = null;
                }
                ((Handler) this.f6164d).post(new RunnableC0091v(2, (G.f) this.f6163c, obj));
                return;
        }
    }

    public /* synthetic */ RunnableC0628c(BinderC0632g binderC0632g, String str, Bundle bundle, int i) {
        this.f6161a = i;
        this.f6164d = binderC0632g;
        this.f6162b = str;
        this.f6163c = bundle;
    }
}
