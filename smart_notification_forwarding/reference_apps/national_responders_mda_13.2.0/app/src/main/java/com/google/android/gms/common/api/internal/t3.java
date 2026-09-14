package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class t3 extends Fragment implements k {

    /* renamed from: h0, reason: collision with root package name */
    private static final WeakHashMap f4992h0 = new WeakHashMap();

    /* renamed from: e0, reason: collision with root package name */
    private final Map f4993e0 = Collections.synchronizedMap(new l.a());

    /* renamed from: f0, reason: collision with root package name */
    private int f4994f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    private Bundle f4995g0;

    public static t3 V1(androidx.fragment.app.j jVar) {
        t3 t3Var;
        WeakHashMap weakHashMap = f4992h0;
        WeakReference weakReference = (WeakReference) weakHashMap.get(jVar);
        if (weakReference != null && (t3Var = (t3) weakReference.get()) != null) {
            return t3Var;
        }
        try {
            t3 t3Var2 = (t3) jVar.d0().i0("SupportLifecycleFragmentImpl");
            if (t3Var2 == null || t3Var2.r0()) {
                t3Var2 = new t3();
                jVar.d0().o().e(t3Var2, "SupportLifecycleFragmentImpl").i();
            }
            weakHashMap.put(jVar, new WeakReference(t3Var2));
            return t3Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void B0(Bundle bundle) {
        super.B0(bundle);
        this.f4994f0 = 1;
        this.f4995g0 = bundle;
        for (Map.Entry entry : this.f4993e0.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void G0() {
        super.G0();
        this.f4994f0 = 5;
        Iterator it = this.f4993e0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void W0() {
        super.W0();
        this.f4994f0 = 3;
        Iterator it = this.f4993e0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void X0(Bundle bundle) {
        super.X0(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f4993e0.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void Y0() {
        super.Y0();
        this.f4994f0 = 2;
        Iterator it = this.f4993e0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void Z0() {
        super.Z0();
        this.f4994f0 = 4;
        Iterator it = this.f4993e0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final void c(String str, LifecycleCallback lifecycleCallback) {
        if (this.f4993e0.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f4993e0.put(str, lifecycleCallback);
        if (this.f4994f0 > 0) {
            new o2.i(Looper.getMainLooper()).post(new s3(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final <T extends LifecycleCallback> T i(String str, Class<T> cls) {
        return cls.cast(this.f4993e0.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final /* synthetic */ Activity j() {
        return t();
    }

    @Override // androidx.fragment.app.Fragment
    public final void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.p(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f4993e0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void w0(int i10, int i11, Intent intent) {
        super.w0(i10, i11, intent);
        Iterator it = this.f4993e0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i10, i11, intent);
        }
    }
}
