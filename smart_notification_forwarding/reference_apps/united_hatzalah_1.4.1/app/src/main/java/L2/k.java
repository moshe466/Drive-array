package L2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ k[] f1353a;

    /* JADX WARN: Type inference failed for: r0v0, types: [L2.k, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [L2.k, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v2, types: [L2.k, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v2, types: [L2.k, java.lang.Enum] */
    static {
        k[] kVarArr = {new Enum("PUBLIC", 0), new Enum("PROTECTED", 1), new Enum("INTERNAL", 2), new Enum("PRIVATE", 3)};
        f1353a = kVarArr;
        p3.h.p(kVarArr);
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f1353a.clone();
    }
}
