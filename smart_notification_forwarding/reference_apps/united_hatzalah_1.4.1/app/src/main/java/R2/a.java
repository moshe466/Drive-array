package R2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2018a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f2019b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f2020c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f2021d;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, R2.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, R2.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, R2.a] */
    static {
        ?? r02 = new Enum("SUSPEND", 0);
        f2018a = r02;
        ?? r12 = new Enum("DROP_OLDEST", 1);
        f2019b = r12;
        ?? r22 = new Enum("DROP_LATEST", 2);
        f2020c = r22;
        a[] aVarArr = {r02, r12, r22};
        f2021d = aVarArr;
        p3.h.p(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f2021d.clone();
    }
}
