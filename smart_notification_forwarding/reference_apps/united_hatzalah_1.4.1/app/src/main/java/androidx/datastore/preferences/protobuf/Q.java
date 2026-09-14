package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class Q {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0234a f3126a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3127b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f3128c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3129d;

    public Q(AbstractC0253u abstractC0253u, String str, Object[] objArr) {
        this.f3126a = abstractC0253u;
        this.f3127b = str;
        this.f3128c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f3129d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            } else {
                this.f3129d = i | (charAt2 << i3);
                return;
            }
        }
    }

    public final int a() {
        int i = this.f3129d;
        if ((i & 1) != 0) {
            return 1;
        }
        if ((i & 4) == 4) {
            return 3;
        }
        return 2;
    }
}
