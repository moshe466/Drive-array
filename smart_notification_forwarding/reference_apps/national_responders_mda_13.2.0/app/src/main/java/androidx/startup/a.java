package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import q0.b;
import q0.c;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f3664d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f3665e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f3668c;

    /* renamed from: b, reason: collision with root package name */
    final Set<Class<? extends q0.a<?>>> f3667b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map<Class<?>, Object> f3666a = new HashMap();

    a(Context context) {
        this.f3668c = context.getApplicationContext();
    }

    private <T> T d(Class<? extends q0.a<?>> cls, Set<Class<?>> set) {
        T t10;
        if (r0.a.d()) {
            try {
                r0.a.a(cls.getSimpleName());
            } finally {
                r0.a.b();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f3666a.containsKey(cls)) {
            t10 = (T) this.f3666a.get(cls);
        } else {
            set.add(cls);
            try {
                q0.a<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends q0.a<?>>> a10 = newInstance.a();
                if (!a10.isEmpty()) {
                    for (Class<? extends q0.a<?>> cls2 : a10) {
                        if (!this.f3666a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t10 = (T) newInstance.b(this.f3668c);
                set.remove(cls);
                this.f3666a.put(cls, t10);
            } catch (Throwable th) {
                throw new c(th);
            }
        }
        return t10;
    }

    public static a e(Context context) {
        if (f3664d == null) {
            synchronized (f3665e) {
                if (f3664d == null) {
                    f3664d = new a(context);
                }
            }
        }
        return f3664d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            try {
                r0.a.a("Startup");
                b(this.f3668c.getPackageManager().getProviderInfo(new ComponentName(this.f3668c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new c(e10);
            }
        } finally {
            r0.a.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(Bundle bundle) {
        String string = this.f3668c.getString(b.f13418a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (q0.a.class.isAssignableFrom(cls)) {
                            this.f3667b.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends q0.a<?>>> it = this.f3667b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new c(e10);
            }
        }
    }

    <T> T c(Class<? extends q0.a<?>> cls) {
        T t10;
        synchronized (f3665e) {
            t10 = (T) this.f3666a.get(cls);
            if (t10 == null) {
                t10 = (T) d(cls, new HashSet());
            }
        }
        return t10;
    }

    public <T> T f(Class<? extends q0.a<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(Class<? extends q0.a<?>> cls) {
        return this.f3667b.contains(cls);
    }
}
