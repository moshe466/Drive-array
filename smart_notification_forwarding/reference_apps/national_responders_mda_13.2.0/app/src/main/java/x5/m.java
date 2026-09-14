package x5;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private String f15450a;

    /* renamed from: b, reason: collision with root package name */
    private String f15451b;

    /* renamed from: c, reason: collision with root package name */
    private long f15452c;

    /* renamed from: d, reason: collision with root package name */
    private long f15453d;

    public m() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(String str, String str2, long j10, String str3, String str4, long j11) {
        this();
        y8.k.e(str3, "senderId");
        y8.k.e(str4, "receiverId");
        this.f15451b = str;
        this.f15450a = str2;
        this.f15453d = j10;
        this.f15452c = j11;
    }

    public final String a() {
        return this.f15450a;
    }

    public final String b() {
        return this.f15451b;
    }

    public final long c() {
        return this.f15452c;
    }

    public final long d() {
        return this.f15453d;
    }
}
