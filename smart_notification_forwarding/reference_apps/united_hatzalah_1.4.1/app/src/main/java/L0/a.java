package L0;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f1130a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1131b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f1132c;

    public a(String str, Object... objArr) {
        this.f1130a = -1;
        this.f1131b = str;
        this.f1132c = objArr;
    }

    public Object[] a() {
        return this.f1132c;
    }

    public String toString() {
        Object[] objArr = this.f1132c;
        String str = this.f1131b;
        if (str != null) {
            return String.format(str, objArr);
        }
        StringBuilder sb = new StringBuilder("mIssueId: ");
        sb.append(this.f1130a);
        for (Object obj : objArr) {
            sb.append(", ");
            sb.append(obj.toString());
        }
        return sb.toString();
    }

    public a(int i, Object... objArr) {
        this.f1130a = i;
        this.f1131b = null;
        this.f1132c = objArr;
    }
}
