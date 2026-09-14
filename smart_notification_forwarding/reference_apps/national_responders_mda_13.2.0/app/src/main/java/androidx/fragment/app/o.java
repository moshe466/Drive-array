package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class o<E> extends l {

    /* renamed from: f, reason: collision with root package name */
    private final Activity f3083f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f3084g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f3085h;

    /* renamed from: i, reason: collision with root package name */
    final w f3086i;

    o(Activity activity, Context context, Handler handler, int i10) {
        this.f3086i = new x();
        this.f3083f = activity;
        this.f3084g = (Context) androidx.core.util.h.g(context, "context == null");
        this.f3085h = (Handler) androidx.core.util.h.g(handler, "handler == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this(jVar, jVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.l
    public View d(int i10) {
        return null;
    }

    @Override // androidx.fragment.app.l
    public boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity i() {
        return this.f3083f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context j() {
        return this.f3084g;
    }

    public Handler k() {
        return this.f3085h;
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E n();

    public LayoutInflater o() {
        return LayoutInflater.from(this.f3084g);
    }

    public boolean p(String str) {
        return false;
    }

    public void q(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (i10 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.i(this.f3084g, intent, bundle);
    }

    public void s() {
    }
}
