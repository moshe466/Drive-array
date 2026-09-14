package r9;

import java.lang.annotation.Annotation;
import n9.v0;
import n9.w0;

/* loaded from: classes.dex */
public final class b implements v0 {

    /* renamed from: b, reason: collision with root package name */
    private final Annotation f13805b;

    public b(Annotation annotation) {
        y8.k.e(annotation, "annotation");
        this.f13805b = annotation;
    }

    @Override // n9.v0
    public w0 a() {
        w0 w0Var = w0.f12327a;
        y8.k.d(w0Var, "NO_SOURCE_FILE");
        return w0Var;
    }

    public final Annotation d() {
        return this.f13805b;
    }
}
