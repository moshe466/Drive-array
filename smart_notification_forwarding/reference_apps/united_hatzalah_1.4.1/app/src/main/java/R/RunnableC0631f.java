package r;

import android.os.Bundle;

/* renamed from: r.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0631f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6174a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6175b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6176c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6177d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f6178e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Bundle f6179f;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ BinderC0632g f6180j;

    public RunnableC0631f(BinderC0632g binderC0632g, int i, int i3, int i4, int i5, int i6, Bundle bundle) {
        this.f6180j = binderC0632g;
        this.f6174a = i;
        this.f6175b = i3;
        this.f6176c = i4;
        this.f6177d = i5;
        this.f6178e = i6;
        this.f6179f = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6180j.f6182b.onActivityLayout(this.f6174a, this.f6175b, this.f6176c, this.f6177d, this.f6178e, this.f6179f);
    }
}
