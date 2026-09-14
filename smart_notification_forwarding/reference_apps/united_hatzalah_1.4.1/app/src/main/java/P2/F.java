package P2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static final F f1598a;

    /* renamed from: b, reason: collision with root package name */
    public static final F f1599b;

    /* renamed from: c, reason: collision with root package name */
    public static final F f1600c;

    /* renamed from: d, reason: collision with root package name */
    public static final F f1601d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ F[] f1602e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, P2.F] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, P2.F] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, P2.F] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, P2.F] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f1598a = r02;
        ?? r12 = new Enum("LAZY", 1);
        f1599b = r12;
        ?? r22 = new Enum("ATOMIC", 2);
        f1600c = r22;
        ?? r3 = new Enum("UNDISPATCHED", 3);
        f1601d = r3;
        F[] fArr = {r02, r12, r22, r3};
        f1602e = fArr;
        p3.h.p(fArr);
    }

    public static F valueOf(String str) {
        return (F) Enum.valueOf(F.class, str);
    }

    public static F[] values() {
        return (F[]) f1602e.clone();
    }
}
