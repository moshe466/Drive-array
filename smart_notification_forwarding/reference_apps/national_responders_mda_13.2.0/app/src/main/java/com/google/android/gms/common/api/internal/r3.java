package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class r3 extends Fragment implements k {

    /* renamed from: i, reason: collision with root package name */
    private static final WeakHashMap f4973i = new WeakHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Map f4974f = Collections.synchronizedMap(new l.a());

    /* renamed from: g, reason: collision with root package name */
    private int f4975g = 0;

    /* renamed from: h, reason: collision with root package name */
    private Bundle f4976h;

    public static r3 d(Activity activity) {
        r3 r3Var;
        WeakHashMap weakHashMap = f4973i;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (r3Var = (r3) weakReference.get()) != null) {
            return r3Var;
        }
        try {
            r3 r3Var2 = (r3) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (r3Var2 == null || r3Var2.isRemoving()) {
                r3Var2 = new r3();
                activity.getFragmentManager().beginTransaction().add(r3Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(r3Var2));
            return r3Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final void c(String str, LifecycleCallback lifecycleCallback) {
        if (this.f4974f.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f4974f.put(str, lifecycleCallback);
        if (this.f4975g > 0) {
            new o2.i(Looper.getMainLooper()).post(new q3(this, lifecycleCallback, str));
        }
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f4974f.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final <T extends LifecycleCallback> T i(String str, Class<T> cls) {
        return cls.cast(this.f4974f.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final Activity j() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Iterator it = this.f4974f.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i10, i11, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4975g = 1;
        this.f4976h = bundle;
        for (Map.Entry entry : this.f4974f.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f4975g = 5;
        Iterator it = this.f4974f.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f4975g = 3;
        Iterator it = this.f4974f.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f4974f.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f4975g = 2;
        Iterator it = this.f4974f.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f4975g = 4;
        Iterator it = this.f4974f.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }
}
