package k1;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements i1.g {

    /* renamed from: a, reason: collision with root package name */
    private final Set<i1.b> f11174a;

    /* renamed from: b, reason: collision with root package name */
    private final m f11175b;

    /* renamed from: c, reason: collision with root package name */
    private final q f11176c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Set<i1.b> set, m mVar, q qVar) {
        this.f11174a = set;
        this.f11175b = mVar;
        this.f11176c = qVar;
    }

    @Override // i1.g
    public <T> i1.f<T> a(String str, Class<T> cls, i1.b bVar, i1.e<T, byte[]> eVar) {
        if (this.f11174a.contains(bVar)) {
            return new p(this.f11175b, str, bVar, eVar, this.f11176c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.f11174a));
    }
}
