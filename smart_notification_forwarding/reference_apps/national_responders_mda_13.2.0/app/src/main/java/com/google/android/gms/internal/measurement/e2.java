package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e2 implements i2 {

    /* renamed from: g, reason: collision with root package name */
    private static final Map<Uri, e2> f5275g = new l.a();

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f5276h = {"key", "value"};

    /* renamed from: a, reason: collision with root package name */
    private final ContentResolver f5277a;

    /* renamed from: b, reason: collision with root package name */
    private final Uri f5278b;

    /* renamed from: c, reason: collision with root package name */
    private final ContentObserver f5279c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f5280d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Map<String, String> f5281e;

    /* renamed from: f, reason: collision with root package name */
    private final List<f2> f5282f;

    private e2(ContentResolver contentResolver, Uri uri) {
        g2 g2Var = new g2(this, null);
        this.f5279c = g2Var;
        this.f5280d = new Object();
        this.f5282f = new ArrayList();
        n3.b(contentResolver);
        n3.b(uri);
        this.f5277a = contentResolver;
        this.f5278b = uri;
        contentResolver.registerContentObserver(uri, false, g2Var);
    }

    public static e2 a(ContentResolver contentResolver, Uri uri) {
        e2 e2Var;
        synchronized (e2.class) {
            Map<Uri, e2> map = f5275g;
            e2Var = map.get(uri);
            if (e2Var == null) {
                try {
                    e2 e2Var2 = new e2(contentResolver, uri);
                    try {
                        map.put(uri, e2Var2);
                    } catch (SecurityException unused) {
                    }
                    e2Var = e2Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return e2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void d() {
        synchronized (e2.class) {
            for (e2 e2Var : f5275g.values()) {
                e2Var.f5277a.unregisterContentObserver(e2Var.f5279c);
            }
            f5275g.clear();
        }
    }

    private final Map<String, String> g() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) h2.a(new k2(this) { // from class: com.google.android.gms.internal.measurement.d2

                /* renamed from: a, reason: collision with root package name */
                private final e2 f5251a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f5251a = this;
                }

                @Override // com.google.android.gms.internal.measurement.k2
                public final Object zza() {
                    return this.f5251a.f();
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    public final Map<String, String> b() {
        Map<String, String> map = this.f5281e;
        if (map == null) {
            synchronized (this.f5280d) {
                map = this.f5281e;
                if (map == null) {
                    map = g();
                    this.f5281e = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void c() {
        synchronized (this.f5280d) {
            this.f5281e = null;
            t2.g();
        }
        synchronized (this) {
            Iterator<f2> it = this.f5282f.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.i2
    public final /* synthetic */ Object e(String str) {
        return b().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map f() {
        Cursor query = this.f5277a.query(this.f5278b, f5276h, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map aVar = count <= 256 ? new l.a(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                aVar.put(query.getString(0), query.getString(1));
            }
            return aVar;
        } finally {
            query.close();
        }
    }
}
