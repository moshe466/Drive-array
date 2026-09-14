package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0304n {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0304n f3607a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0304n f3608b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0304n f3609c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0304n f3610d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnumC0304n f3611e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC0304n[] f3612f;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, androidx.lifecycle.n] */
    static {
        ?? r02 = new Enum("DESTROYED", 0);
        f3607a = r02;
        ?? r12 = new Enum("INITIALIZED", 1);
        f3608b = r12;
        ?? r22 = new Enum("CREATED", 2);
        f3609c = r22;
        ?? r3 = new Enum("STARTED", 3);
        f3610d = r3;
        ?? r4 = new Enum("RESUMED", 4);
        f3611e = r4;
        f3612f = new EnumC0304n[]{r02, r12, r22, r3, r4};
    }

    public static EnumC0304n valueOf(String str) {
        return (EnumC0304n) Enum.valueOf(EnumC0304n.class, str);
    }

    public static EnumC0304n[] values() {
        return (EnumC0304n[]) f3612f.clone();
    }
}
