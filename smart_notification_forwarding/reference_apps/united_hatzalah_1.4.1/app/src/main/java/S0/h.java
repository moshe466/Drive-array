package S0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f2091a;

    /* renamed from: b, reason: collision with root package name */
    public static final h f2092b;

    /* renamed from: c, reason: collision with root package name */
    public static final h f2093c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ h[] f2094d;

    /* JADX WARN: Type inference failed for: r0v0, types: [S0.h, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [S0.h, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [S0.h, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [S0.h, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r4v2, types: [S0.h, java.lang.Enum] */
    static {
        ?? r02 = new Enum("UNIVERSAL", 0);
        f2091a = r02;
        ?? r12 = new Enum("APPLICATION", 1);
        ?? r22 = new Enum("CONTEXT_SPECIFIC", 2);
        f2092b = r22;
        ?? r3 = new Enum("PRIVATE", 3);
        ?? r4 = new Enum("AUTOMATIC", 4);
        f2093c = r4;
        f2094d = new h[]{r02, r12, r22, r3, r4};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f2094d.clone();
    }
}
