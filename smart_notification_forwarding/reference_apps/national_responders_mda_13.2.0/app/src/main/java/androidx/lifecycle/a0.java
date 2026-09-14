package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f3193a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set<Closeable> f3194b = new LinkedHashSet();

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Map<String, Object> map = this.f3193a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f3193a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        Set<Closeable> set = this.f3194b;
        if (set != null) {
            synchronized (set) {
                Iterator<Closeable> it2 = this.f3194b.iterator();
                while (it2.hasNext()) {
                    b(it2.next());
                }
            }
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T c(String str) {
        T t10;
        Map<String, Object> map = this.f3193a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t10 = (T) this.f3193a.get(str);
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }
}
