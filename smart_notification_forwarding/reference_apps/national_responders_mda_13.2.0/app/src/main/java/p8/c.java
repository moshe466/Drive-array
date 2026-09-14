package p8;

import java.io.Serializable;
import p8.f;
import x8.p;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class c implements f, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final f f13122f;

    /* renamed from: g, reason: collision with root package name */
    private final f.b f13123g;

    /* loaded from: classes.dex */
    static final class a extends l implements p<String, f.b, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f13124f = new a();

        a() {
            super(2);
        }

        @Override // x8.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String g(String str, f.b bVar) {
            k.e(str, "acc");
            k.e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public c(f fVar, f.b bVar) {
        k.e(fVar, "left");
        k.e(bVar, "element");
        this.f13122f = fVar;
        this.f13123g = bVar;
    }

    private final boolean a(f.b bVar) {
        return k.a(get(bVar.getKey()), bVar);
    }

    private final boolean b(c cVar) {
        while (a(cVar.f13123g)) {
            f fVar = cVar.f13122f;
            if (!(fVar instanceof c)) {
                k.c(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((f.b) fVar);
            }
            cVar = (c) fVar;
        }
        return false;
    }

    private final int c() {
        int i10 = 2;
        c cVar = this;
        while (true) {
            f fVar = cVar.f13122f;
            cVar = fVar instanceof c ? (c) fVar : null;
            if (cVar == null) {
                return i10;
            }
            i10++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.c() != c() || !cVar.b(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // p8.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> pVar) {
        k.e(pVar, "operation");
        return pVar.g((Object) this.f13122f.fold(r10, pVar), this.f13123g);
    }

    @Override // p8.f
    public <E extends f.b> E get(f.c<E> cVar) {
        k.e(cVar, "key");
        c cVar2 = this;
        while (true) {
            E e10 = (E) cVar2.f13123g.get(cVar);
            if (e10 != null) {
                return e10;
            }
            f fVar = cVar2.f13122f;
            if (!(fVar instanceof c)) {
                return (E) fVar.get(cVar);
            }
            cVar2 = (c) fVar;
        }
    }

    public int hashCode() {
        return this.f13122f.hashCode() + this.f13123g.hashCode();
    }

    @Override // p8.f
    public f minusKey(f.c<?> cVar) {
        k.e(cVar, "key");
        if (this.f13123g.get(cVar) != null) {
            return this.f13122f;
        }
        f minusKey = this.f13122f.minusKey(cVar);
        return minusKey == this.f13122f ? this : minusKey == g.f13128f ? this.f13123g : new c(minusKey, this.f13123g);
    }

    public String toString() {
        return '[' + ((String) fold("", a.f13124f)) + ']';
    }
}
