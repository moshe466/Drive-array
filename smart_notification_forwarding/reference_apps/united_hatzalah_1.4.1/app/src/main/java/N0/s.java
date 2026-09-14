package N0;

/* loaded from: classes.dex */
public enum s {
    CHUNKED_SHA256(1, "SHA-256", 32),
    CHUNKED_SHA512(2, "SHA-512", 64),
    VERITY_CHUNKED_SHA256(3, "SHA-256", 32),
    SHA256(4, "SHA-256", 32);


    /* renamed from: a, reason: collision with root package name */
    public final int f1490a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1491b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1492c;

    s(int i, String str, int i3) {
        this.f1490a = i;
        this.f1491b = str;
        this.f1492c = i3;
    }
}
