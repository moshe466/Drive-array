package r8;

import java.io.Serializable;
import l8.o;
import l8.p;
import y8.k;

/* loaded from: classes.dex */
public abstract class a implements p8.d<Object>, d, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final p8.d<Object> f13792f;

    @Override // r8.d
    public d a() {
        p8.d<Object> dVar = this.f13792f;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p8.d
    public final void b(Object obj) {
        Object d10;
        Object b10;
        p8.d dVar = this;
        while (true) {
            g.a(dVar);
            a aVar = (a) dVar;
            p8.d dVar2 = aVar.f13792f;
            k.b(dVar2);
            try {
                d10 = aVar.d(obj);
                b10 = q8.d.b();
            } catch (Throwable th) {
                o.a aVar2 = o.f11812f;
                obj = o.a(p.a(th));
            }
            if (d10 == b10) {
                return;
            }
            o.a aVar3 = o.f11812f;
            obj = o.a(d10);
            aVar.f();
            if (!(dVar2 instanceof a)) {
                dVar2.b(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    protected abstract Object d(Object obj);

    @Override // r8.d
    public StackTraceElement e() {
        return f.d(this);
    }

    protected void f() {
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object e10 = e();
        if (e10 == null) {
            e10 = getClass().getName();
        }
        sb2.append(e10);
        return sb2.toString();
    }
}
