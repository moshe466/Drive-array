package b2;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    private Object f4086a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4087b = false;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f4088c;

    public z0(c cVar, Object obj) {
        this.f4088c = cVar;
        this.f4086a = obj;
    }

    protected abstract void a(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            obj = this.f4086a;
            if (this.f4087b) {
                String obj2 = toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Callback proxy ");
                sb2.append(obj2);
                sb2.append(" being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e10) {
                throw e10;
            }
        }
        synchronized (this) {
            this.f4087b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f4086a = null;
        }
    }

    public final void e() {
        ArrayList arrayList;
        ArrayList arrayList2;
        d();
        arrayList = this.f4088c.f3937q;
        synchronized (arrayList) {
            arrayList2 = this.f4088c.f3937q;
            arrayList2.remove(this);
        }
    }
}
