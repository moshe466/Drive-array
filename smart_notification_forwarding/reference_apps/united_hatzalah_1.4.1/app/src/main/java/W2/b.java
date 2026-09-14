package W2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2514a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f2515b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f2516c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f2517d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f2518e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ b[] f2519f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, W2.b] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, W2.b] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, W2.b] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, W2.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, W2.b] */
    static {
        ?? r02 = new Enum("CPU_ACQUIRED", 0);
        f2514a = r02;
        ?? r12 = new Enum("BLOCKING", 1);
        f2515b = r12;
        ?? r22 = new Enum("PARKING", 2);
        f2516c = r22;
        ?? r3 = new Enum("DORMANT", 3);
        f2517d = r3;
        ?? r4 = new Enum("TERMINATED", 4);
        f2518e = r4;
        b[] bVarArr = {r02, r12, r22, r3, r4};
        f2519f = bVarArr;
        p3.h.p(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f2519f.clone();
    }
}
