package N0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f1445a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1446b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1447c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1448d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1449e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f1450f = new ArrayList();

    public final void a(int i, Object... objArr) {
        this.f1449e.add(new L0.a(i, objArr));
    }

    public boolean b() {
        return !this.f1450f.isEmpty();
    }

    public boolean c() {
        return !this.f1449e.isEmpty();
    }

    public ArrayList d() {
        return this.f1450f;
    }

    public ArrayList e() {
        return this.f1449e;
    }
}
