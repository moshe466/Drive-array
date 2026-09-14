package c1;

import androidx.lifecycle.N;
import p3.h;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final N f3867a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f3868b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f3869c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f3870d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ b[] f3871e;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, c1.b] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, c1.b] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Enum, c1.b] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Enum, c1.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Enum, c1.b] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, c1.b] */
    static {
        ?? r02 = new Enum("V_1", 0);
        f3868b = r02;
        ?? r12 = new Enum("V_2", 1);
        f3869c = r12;
        ?? r22 = new Enum("V_3", 2);
        f3870d = r22;
        b[] bVarArr = {r02, r12, r22, new Enum("V_4", 3), new Enum("V_5", 4), new Enum("V_6", 5)};
        f3871e = bVarArr;
        h.p(bVarArr);
        f3867a = new N(3);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f3871e.clone();
    }
}
