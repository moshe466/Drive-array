package h1;

import p3.h;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: h1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0446a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnumC0446a[] f4934a;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, h1.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, h1.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, h1.a] */
    static {
        EnumC0446a[] enumC0446aArr = {new Enum("STABLE", 0), new Enum("OPTIMAL", 1), new Enum("UNIQUE", 2)};
        f4934a = enumC0446aArr;
        h.p(enumC0446aArr);
    }

    public static EnumC0446a valueOf(String str) {
        return (EnumC0446a) Enum.valueOf(EnumC0446a.class, str);
    }

    public static EnumC0446a[] values() {
        return (EnumC0446a[]) f4934a.clone();
    }
}
