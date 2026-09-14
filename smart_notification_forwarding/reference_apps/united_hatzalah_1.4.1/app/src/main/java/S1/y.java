package s1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f6328a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ y[] f6329b;

    /* JADX INFO: Fake field, exist only in values array */
    y EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, s1.y] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, s1.y] */
    static {
        ?? r02 = new Enum("UNKNOWN", 0);
        ?? r12 = new Enum("ANDROID_FIREBASE", 1);
        f6328a = r12;
        f6329b = new y[]{r02, r12};
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f6329b.clone();
    }
}
