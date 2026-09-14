package F0;

import java.util.concurrent.locks.ReentrantLock;

/* renamed from: F0.k2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0051k2 implements Z1 {

    /* renamed from: e, reason: collision with root package name */
    public static C0051k2 f555e;

    /* renamed from: f, reason: collision with root package name */
    public static final ReentrantLock f556f = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final G0.l f557a;

    /* renamed from: b, reason: collision with root package name */
    public final C0043i2 f558b = new C0043i2(this);

    /* renamed from: c, reason: collision with root package name */
    public final C0035g2 f559c = new C0035g2(this, 0);

    /* renamed from: d, reason: collision with root package name */
    public final C0047j2 f560d = new C0047j2(this, 0);

    public C0051k2(G0.l lVar) {
        this.f557a = lVar;
    }

    public final C0035g2 a() {
        return this.f559c;
    }

    public final C0043i2 b() {
        return this.f558b;
    }

    public final boolean c() {
        return this.f557a.f832f;
    }
}
