package s9;

import java.lang.annotation.Annotation;

/* loaded from: classes.dex */
public final class e extends d implements ca.c {

    /* renamed from: c, reason: collision with root package name */
    private final Annotation f14155c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(la.e eVar, Annotation annotation) {
        super(eVar);
        y8.k.e(annotation, "annotation");
        this.f14155c = annotation;
    }

    @Override // ca.c
    public ca.a b() {
        return new c(this.f14155c);
    }
}
