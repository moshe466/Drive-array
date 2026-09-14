package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class g implements ic.a {

    /* renamed from: a, reason: collision with root package name */
    boolean f11349a = false;

    /* renamed from: b, reason: collision with root package name */
    final Map<String, f> f11350b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue<jc.d> f11351c = new LinkedBlockingQueue<>();

    @Override // ic.a
    public synchronized ic.b a(String str) {
        f fVar;
        fVar = this.f11350b.get(str);
        if (fVar == null) {
            fVar = new f(str, this.f11351c, this.f11349a);
            this.f11350b.put(str, fVar);
        }
        return fVar;
    }

    public void b() {
        this.f11350b.clear();
        this.f11351c.clear();
    }

    public LinkedBlockingQueue<jc.d> c() {
        return this.f11351c;
    }

    public List<f> d() {
        return new ArrayList(this.f11350b.values());
    }

    public void e() {
        this.f11349a = true;
    }
}
