package r;

import android.os.Bundle;

/* renamed from: r.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0630e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6170a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6171b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f6172c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BinderC0632g f6173d;

    public RunnableC0630e(BinderC0632g binderC0632g, int i, int i3, Bundle bundle) {
        this.f6173d = binderC0632g;
        this.f6170a = i;
        this.f6171b = i3;
        this.f6172c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6173d.f6182b.onActivityResized(this.f6170a, this.f6171b, this.f6172c);
    }
}
