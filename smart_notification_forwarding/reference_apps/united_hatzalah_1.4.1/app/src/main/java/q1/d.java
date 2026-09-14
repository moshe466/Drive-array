package q1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6150a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f6151b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f6152c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ d[] f6153d;

    /* JADX WARN: Type inference failed for: r0v0, types: [q1.d, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [q1.d, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [q1.d, java.lang.Enum] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f6150a = r02;
        ?? r12 = new Enum("VERY_LOW", 1);
        f6151b = r12;
        ?? r22 = new Enum("HIGHEST", 2);
        f6152c = r22;
        f6153d = new d[]{r02, r12, r22};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f6153d.clone();
    }
}
