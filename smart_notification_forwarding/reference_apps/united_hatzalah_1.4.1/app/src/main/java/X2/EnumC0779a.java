package x2;

import p3.h;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: x2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0779a {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0779a f6740a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0779a[] f6741b;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, x2.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, x2.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, x2.a] */
    static {
        ?? r02 = new Enum("COROUTINE_SUSPENDED", 0);
        f6740a = r02;
        EnumC0779a[] enumC0779aArr = {r02, new Enum("UNDECIDED", 1), new Enum("RESUMED", 2)};
        f6741b = enumC0779aArr;
        h.p(enumC0779aArr);
    }

    public static EnumC0779a valueOf(String str) {
        return (EnumC0779a) Enum.valueOf(EnumC0779a.class, str);
    }

    public static EnumC0779a[] values() {
        return (EnumC0779a[]) f6741b.clone();
    }
}
