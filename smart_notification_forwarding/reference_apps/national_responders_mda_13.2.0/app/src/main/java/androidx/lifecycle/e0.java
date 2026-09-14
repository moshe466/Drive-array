package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, a0> f3202a = new HashMap<>();

    public final void a() {
        Iterator<a0> it = this.f3202a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f3202a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a0 b(String str) {
        return this.f3202a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f3202a.keySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str, a0 a0Var) {
        a0 put = this.f3202a.put(str, a0Var);
        if (put != null) {
            put.d();
        }
    }
}
