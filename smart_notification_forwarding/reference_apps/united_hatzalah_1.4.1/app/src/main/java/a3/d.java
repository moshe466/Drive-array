package a3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f2766a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f2767b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ d[] f2768c;

    /* JADX INFO: Fake field, exist only in values array */
    d EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, a3.d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, a3.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, a3.d] */
    static {
        ?? r02 = new Enum("CR", 0);
        ?? r12 = new Enum("CRLF", 1);
        f2766a = r12;
        ?? r22 = new Enum("LF", 2);
        f2767b = r22;
        f2768c = new d[]{r02, r12, r22};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f2768c.clone();
    }
}
