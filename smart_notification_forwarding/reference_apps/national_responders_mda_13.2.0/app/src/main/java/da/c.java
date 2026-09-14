package da;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f8757a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f8758b;

    public c(T t10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        this.f8757a = t10;
        this.f8758b = gVar;
    }

    public final T a() {
        return this.f8757a;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b() {
        return this.f8758b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return y8.k.a(this.f8757a, cVar.f8757a) && y8.k.a(this.f8758b, cVar.f8758b);
    }

    public int hashCode() {
        T t10 = this.f8757a;
        int hashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar = this.f8758b;
        return hashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public String toString() {
        return "EnhancementResult(result=" + this.f8757a + ", enhancementAnnotations=" + this.f8758b + ')';
    }
}
