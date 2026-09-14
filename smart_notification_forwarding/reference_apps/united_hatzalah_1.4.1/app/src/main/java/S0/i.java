package S0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f2095a;

    /* renamed from: b, reason: collision with root package name */
    public static final i f2096b;

    /* renamed from: c, reason: collision with root package name */
    public static final i f2097c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ i[] f2098d;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, S0.i] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, S0.i] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, S0.i] */
    static {
        ?? r02 = new Enum("NORMAL", 0);
        f2095a = r02;
        ?? r12 = new Enum("EXPLICIT", 1);
        f2096b = r12;
        ?? r22 = new Enum("IMPLICIT", 2);
        f2097c = r22;
        f2098d = new i[]{r02, r12, r22};
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f2098d.clone();
    }
}
