package xa;

/* loaded from: classes.dex */
public final class r<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f15627a;

    /* renamed from: b, reason: collision with root package name */
    private final T f15628b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15629c;

    /* renamed from: d, reason: collision with root package name */
    private final la.a f15630d;

    public r(T t10, T t11, String str, la.a aVar) {
        y8.k.e(str, "filePath");
        y8.k.e(aVar, "classId");
        this.f15627a = t10;
        this.f15628b = t11;
        this.f15629c = str;
        this.f15630d = aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return y8.k.a(this.f15627a, rVar.f15627a) && y8.k.a(this.f15628b, rVar.f15628b) && y8.k.a(this.f15629c, rVar.f15629c) && y8.k.a(this.f15630d, rVar.f15630d);
    }

    public int hashCode() {
        T t10 = this.f15627a;
        int hashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f15628b;
        return ((((hashCode + (t11 != null ? t11.hashCode() : 0)) * 31) + this.f15629c.hashCode()) * 31) + this.f15630d.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f15627a + ", expectedVersion=" + this.f15628b + ", filePath=" + this.f15629c + ", classId=" + this.f15630d + ')';
    }
}
