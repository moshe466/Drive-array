package a0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: a0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0229a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0229a f2740a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0229a f2741b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0229a f2742c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0229a f2743d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0229a f2744e;

    /* renamed from: f, reason: collision with root package name */
    public static final EnumC0229a f2745f;

    /* renamed from: j, reason: collision with root package name */
    public static final EnumC0229a f2746j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ EnumC0229a[] f2747k;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0229a EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, a0.a] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum, a0.a] */
    static {
        ?? r02 = new Enum("PENALTY_LOG", 0);
        ?? r12 = new Enum("PENALTY_DEATH", 1);
        ?? r22 = new Enum("DETECT_FRAGMENT_REUSE", 2);
        f2740a = r22;
        ?? r3 = new Enum("DETECT_FRAGMENT_TAG_USAGE", 3);
        f2741b = r3;
        ?? r4 = new Enum("DETECT_WRONG_NESTED_HIERARCHY", 4);
        f2742c = r4;
        ?? r5 = new Enum("DETECT_RETAIN_INSTANCE_USAGE", 5);
        f2743d = r5;
        ?? r6 = new Enum("DETECT_SET_USER_VISIBLE_HINT", 6);
        f2744e = r6;
        ?? r7 = new Enum("DETECT_TARGET_FRAGMENT_USAGE", 7);
        f2745f = r7;
        ?? r8 = new Enum("DETECT_WRONG_FRAGMENT_CONTAINER", 8);
        f2746j = r8;
        f2747k = new EnumC0229a[]{r02, r12, r22, r3, r4, r5, r6, r7, r8};
    }

    public static EnumC0229a valueOf(String str) {
        return (EnumC0229a) Enum.valueOf(EnumC0229a.class, str);
    }

    public static EnumC0229a[] values() {
        return (EnumC0229a[]) f2747k.clone();
    }
}
