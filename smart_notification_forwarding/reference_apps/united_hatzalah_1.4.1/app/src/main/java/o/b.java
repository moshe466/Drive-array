package o;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f5896a;

    /* renamed from: b, reason: collision with root package name */
    public c f5897b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5898c;

    public b(c cVar, c cVar2, int i) {
        this.f5898c = i;
        this.f5896a = cVar2;
        this.f5897b = cVar;
    }

    @Override // o.e
    public final void a(c cVar) {
        c cVar2;
        c cVar3 = null;
        if (this.f5896a == cVar && cVar == this.f5897b) {
            this.f5897b = null;
            this.f5896a = null;
        }
        c cVar4 = this.f5896a;
        if (cVar4 == cVar) {
            switch (this.f5898c) {
                case 0:
                    cVar2 = cVar4.f5902d;
                    break;
                default:
                    cVar2 = cVar4.f5901c;
                    break;
            }
            this.f5896a = cVar2;
        }
        c cVar5 = this.f5897b;
        if (cVar5 == cVar) {
            c cVar6 = this.f5896a;
            if (cVar5 != cVar6 && cVar6 != null) {
                cVar3 = b(cVar5);
            }
            this.f5897b = cVar3;
        }
    }

    public final c b(c cVar) {
        switch (this.f5898c) {
            case 0:
                return cVar.f5901c;
            default:
                return cVar.f5902d;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5897b != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar;
        c cVar2 = this.f5897b;
        c cVar3 = this.f5896a;
        if (cVar2 != cVar3 && cVar3 != null) {
            cVar = b(cVar2);
        } else {
            cVar = null;
        }
        this.f5897b = cVar;
        return cVar2;
    }
}
