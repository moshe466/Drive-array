package s9;

import ca.a0;
import java.lang.annotation.Annotation;
import java.util.List;

/* loaded from: classes.dex */
public final class y extends n implements a0 {

    /* renamed from: a, reason: collision with root package name */
    private final w f14184a;

    /* renamed from: b, reason: collision with root package name */
    private final Annotation[] f14185b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14186c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f14187d;

    public y(w wVar, Annotation[] annotationArr, String str, boolean z10) {
        y8.k.e(wVar, "type");
        y8.k.e(annotationArr, "reflectAnnotations");
        this.f14184a = wVar;
        this.f14185b = annotationArr;
        this.f14186c = str;
        this.f14187d = z10;
    }

    @Override // ca.d
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public c e(la.b bVar) {
        y8.k.e(bVar, "fqName");
        return g.a(this.f14185b, bVar);
    }

    @Override // ca.d
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public List<c> u() {
        return g.b(this.f14185b);
    }

    @Override // ca.a0
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public w b() {
        return this.f14184a;
    }

    @Override // ca.a0
    public la.e c() {
        String str = this.f14186c;
        if (str == null) {
            return null;
        }
        return la.e.o(str);
    }

    @Override // ca.a0
    public boolean g() {
        return this.f14187d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y.class.getName());
        sb2.append(": ");
        sb2.append(g() ? "vararg " : "");
        sb2.append(c());
        sb2.append(": ");
        sb2.append(b());
        return sb2.toString();
    }

    @Override // ca.d
    public boolean v() {
        return false;
    }
}
