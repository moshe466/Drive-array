package X2;

import p3.h;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f2625a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f2626b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f2627c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f2628d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ d[] f2629e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, X2.d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, X2.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, X2.d] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, X2.d] */
    static {
        ?? r02 = new Enum("SUCCESSFUL", 0);
        f2625a = r02;
        ?? r12 = new Enum("REREGISTER", 1);
        f2626b = r12;
        ?? r22 = new Enum("CANCELLED", 2);
        f2627c = r22;
        ?? r3 = new Enum("ALREADY_SELECTED", 3);
        f2628d = r3;
        d[] dVarArr = {r02, r12, r22, r3};
        f2629e = dVarArr;
        h.p(dVarArr);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f2629e.clone();
    }
}
