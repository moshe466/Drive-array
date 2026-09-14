package o;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f5903a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5904b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f5905c;

    public d(f fVar) {
        this.f5905c = fVar;
    }

    @Override // o.e
    public final void a(c cVar) {
        boolean z3;
        c cVar2 = this.f5903a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f5902d;
            this.f5903a = cVar3;
            if (cVar3 == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f5904b = z3;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5904b) {
            if (this.f5905c.f5906a == null) {
                return false;
            }
            return true;
        }
        c cVar = this.f5903a;
        if (cVar == null || cVar.f5901c == null) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar;
        if (this.f5904b) {
            this.f5904b = false;
            this.f5903a = this.f5905c.f5906a;
        } else {
            c cVar2 = this.f5903a;
            if (cVar2 != null) {
                cVar = cVar2.f5901c;
            } else {
                cVar = null;
            }
            this.f5903a = cVar;
        }
        return this.f5903a;
    }
}
