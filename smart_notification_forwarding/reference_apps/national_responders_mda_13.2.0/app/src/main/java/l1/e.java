package l1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
class e implements b {

    /* renamed from: a, reason: collision with root package name */
    private final a f11774a;

    /* renamed from: b, reason: collision with root package name */
    private final c f11775b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, g> f11776c;

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f11777a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, String> f11778b = null;

        a(Context context) {
            this.f11777a = context;
        }

        private Map<String, String> a(Context context) {
            Bundle d10 = d(context);
            if (d10 == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : d10.keySet()) {
                Object obj = d10.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String trim = str2.trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map<String, String> c() {
            if (this.f11778b == null) {
                this.f11778b = a(this.f11777a);
            }
            return this.f11778b;
        }

        private static Bundle d(Context context) {
            ServiceInfo serviceInfo;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128)) == null) {
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        l1.a b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (l1.a) Class.forName(str2).asSubclass(l1.a.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                String.format("Class %s is not found.", str2);
                return null;
            } catch (IllegalAccessException unused2) {
                String.format("Could not instantiate %s.", str2);
                return null;
            } catch (InstantiationException unused3) {
                String.format("Could not instantiate %s.", str2);
                return null;
            } catch (NoSuchMethodException unused4) {
                String.format("Could not instantiate %s", str2);
                return null;
            } catch (InvocationTargetException unused5) {
                String.format("Could not instantiate %s", str2);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, c cVar) {
        this(new a(context), cVar);
    }

    e(a aVar, c cVar) {
        this.f11776c = new HashMap();
        this.f11774a = aVar;
        this.f11775b = cVar;
    }

    @Override // l1.b
    public synchronized g a(String str) {
        if (this.f11776c.containsKey(str)) {
            return this.f11776c.get(str);
        }
        l1.a b10 = this.f11774a.b(str);
        if (b10 == null) {
            return null;
        }
        g create = b10.create(this.f11775b.a(str));
        this.f11776c.put(str, create);
        return create;
    }
}
