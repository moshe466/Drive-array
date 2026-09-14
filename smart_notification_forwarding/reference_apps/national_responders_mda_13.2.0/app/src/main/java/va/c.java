package va;

import bb.i0;
import y8.k;

/* loaded from: classes.dex */
public class c implements d, f {

    /* renamed from: a, reason: collision with root package name */
    private final n9.e f14848a;

    /* renamed from: b, reason: collision with root package name */
    private final n9.e f14849b;

    public c(n9.e eVar, c cVar) {
        k.e(eVar, "classDescriptor");
        this.f14848a = eVar;
        this.f14849b = eVar;
    }

    @Override // va.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i0 b() {
        i0 s10 = this.f14848a.s();
        k.d(s10, "classDescriptor.defaultType");
        return s10;
    }

    public boolean equals(Object obj) {
        n9.e eVar = this.f14848a;
        c cVar = obj instanceof c ? (c) obj : null;
        return k.a(eVar, cVar != null ? cVar.f14848a : null);
    }

    public int hashCode() {
        return this.f14848a.hashCode();
    }

    @Override // va.f
    public final n9.e n() {
        return this.f14848a;
    }

    public String toString() {
        return "Class{" + b() + '}';
    }
}
