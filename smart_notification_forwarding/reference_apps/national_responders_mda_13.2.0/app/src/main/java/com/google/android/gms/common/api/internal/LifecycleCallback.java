package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: f, reason: collision with root package name */
    protected final k f4772f;

    /* JADX INFO: Access modifiers changed from: protected */
    public LifecycleCallback(k kVar) {
        this.f4772f = kVar;
    }

    public static k c(Activity activity) {
        return d(new j(activity));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static k d(j jVar) {
        if (jVar.d()) {
            return t3.V1(jVar.b());
        }
        if (jVar.c()) {
            return r3.d(jVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static k getChimeraLifecycleFragmentImpl(j jVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity j10 = this.f4772f.j();
        b2.p.k(j10);
        return j10;
    }

    public void e(int i10, int i11, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
