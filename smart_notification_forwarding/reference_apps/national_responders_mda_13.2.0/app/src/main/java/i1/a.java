package i1;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f10718a;

    /* renamed from: b, reason: collision with root package name */
    private final T f10719b;

    /* renamed from: c, reason: collision with root package name */
    private final d f10720c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Integer num, T t10, d dVar) {
        this.f10718a = num;
        Objects.requireNonNull(t10, "Null payload");
        this.f10719b = t10;
        Objects.requireNonNull(dVar, "Null priority");
        this.f10720c = dVar;
    }

    @Override // i1.c
    public Integer a() {
        return this.f10718a;
    }

    @Override // i1.c
    public T b() {
        return this.f10719b;
    }

    @Override // i1.c
    public d c() {
        return this.f10720c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f10718a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.f10719b.equals(cVar.b()) && this.f10720c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f10718a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f10719b.hashCode()) * 1000003) ^ this.f10720c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f10718a + ", payload=" + this.f10719b + ", priority=" + this.f10720c + "}";
    }
}
