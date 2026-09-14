package p3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class f implements n3.a {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f5985a = false;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f5986b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f5987c = new LinkedBlockingQueue();

    @Override // n3.a
    public final synchronized n3.b a(String str) {
        e eVar;
        eVar = (e) this.f5986b.get(str);
        if (eVar == null) {
            eVar = new e(str, this.f5987c, this.f5985a);
            this.f5986b.put(str, eVar);
        }
        return eVar;
    }
}
