package n0;

import a.AbstractC0228a;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.uh.sf.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0592a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C0592a f5879d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f5880e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f5883c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f5882b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f5881a = new HashMap();

    public C0592a(Context context) {
        this.f5883c = context.getApplicationContext();
    }

    public static C0592a c(Context context) {
        if (f5879d == null) {
            synchronized (f5880e) {
                try {
                    if (f5879d == null) {
                        f5879d = new C0592a(context);
                    }
                } finally {
                }
            }
        }
        return f5879d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f5883c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f5882b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (InterfaceC0593b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        HashMap hashMap = this.f5881a;
        if (AbstractC0228a.x()) {
            try {
                Trace.beginSection(AbstractC0228a.D(cls.getSimpleName()));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!hashSet.contains(cls)) {
            if (!hashMap.containsKey(cls)) {
                hashSet.add(cls);
                try {
                    InterfaceC0593b interfaceC0593b = (InterfaceC0593b) cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class> dependencies = interfaceC0593b.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class cls2 : dependencies) {
                            if (!hashMap.containsKey(cls2)) {
                                b(cls2, hashSet);
                            }
                        }
                    }
                    obj = interfaceC0593b.a(this.f5883c);
                    hashSet.remove(cls);
                    hashMap.put(cls, obj);
                } catch (Throwable th2) {
                    throw new RuntimeException(th2);
                }
            } else {
                obj = hashMap.get(cls);
            }
            Trace.endSection();
            return obj;
        }
        throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
    }
}
