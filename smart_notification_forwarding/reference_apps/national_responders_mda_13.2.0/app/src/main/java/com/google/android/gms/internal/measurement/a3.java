package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a3 implements i2 {

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, a3> f5169f = new l.a();

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f5170a;

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f5171b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f5172c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Map<String, ?> f5173d;

    /* renamed from: e, reason: collision with root package name */
    private final List<f2> f5174e;

    private a3(SharedPreferences sharedPreferences) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.d3

            /* renamed from: a, reason: collision with root package name */
            private final a3 f5252a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5252a = this;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.f5252a.c(sharedPreferences2, str);
            }
        };
        this.f5171b = onSharedPreferenceChangeListener;
        this.f5172c = new Object();
        this.f5174e = new ArrayList();
        this.f5170a = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a3 a(Context context, String str) {
        a3 a3Var;
        if (c2.a()) {
            throw null;
        }
        synchronized (a3.class) {
            Map<String, a3> map = f5169f;
            a3Var = map.get(null);
            if (a3Var == null) {
                a3Var = new a3(d(context, null));
                map.put(null, a3Var);
            }
        }
        return a3Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b() {
        synchronized (a3.class) {
            for (a3 a3Var : f5169f.values()) {
                a3Var.f5170a.unregisterOnSharedPreferenceChangeListener(a3Var.f5171b);
            }
            f5169f.clear();
        }
    }

    private static SharedPreferences d(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!str.startsWith("direct_boot:")) {
                return context.getSharedPreferences(str, 0);
            }
            if (c2.a()) {
                context = context.createDeviceProtectedStorageContext();
            }
            return context.getSharedPreferences(str.substring(12), 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f5172c) {
            this.f5173d = null;
            t2.g();
        }
        synchronized (this) {
            Iterator<f2> it = this.f5174e.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.i2
    public final Object e(String str) {
        Map<String, ?> map = this.f5173d;
        if (map == null) {
            synchronized (this.f5172c) {
                map = this.f5173d;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f5170a.getAll();
                        this.f5173d = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
