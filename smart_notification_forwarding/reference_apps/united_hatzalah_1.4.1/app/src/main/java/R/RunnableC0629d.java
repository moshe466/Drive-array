package r;

import android.net.Uri;
import android.os.Bundle;

/* renamed from: r.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0629d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6165a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f6166b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f6167c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f6168d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BinderC0632g f6169e;

    public RunnableC0629d(BinderC0632g binderC0632g, int i, Uri uri, boolean z3, Bundle bundle) {
        this.f6169e = binderC0632g;
        this.f6165a = i;
        this.f6166b = uri;
        this.f6167c = z3;
        this.f6168d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6169e.f6182b.onRelationshipValidationResult(this.f6165a, this.f6166b, this.f6167c, this.f6168d);
    }
}
