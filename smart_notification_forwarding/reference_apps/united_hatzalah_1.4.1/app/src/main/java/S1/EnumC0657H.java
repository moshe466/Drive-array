package s1;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: s1.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0657H {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f6239a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0657H[] f6240b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0657H EF1;

    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Enum, s1.H] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, java.lang.Object, s1.H] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Enum, java.lang.Object, s1.H] */
    static {
        ?? r12 = new Enum("UNKNOWN_MOBILE_SUBTYPE", 0);
        ?? r22 = new Enum("GPRS", 1);
        ?? r3 = new Enum("EDGE", 2);
        ?? r4 = new Enum("UMTS", 3);
        ?? r5 = new Enum("CDMA", 4);
        ?? r6 = new Enum("EVDO_0", 5);
        ?? r7 = new Enum("EVDO_A", 6);
        ?? r8 = new Enum("RTT", 7);
        ?? r9 = new Enum("HSDPA", 8);
        ?? r10 = new Enum("HSUPA", 9);
        ?? r11 = new Enum("HSPA", 10);
        ?? r122 = new Enum("IDEN", 11);
        ?? r13 = new Enum("EVDO_B", 12);
        ?? r14 = new Enum("LTE", 13);
        ?? r15 = new Enum("EHRPD", 14);
        ?? r02 = new Enum("HSPAP", 15);
        ?? r16 = new Enum("GSM", 16);
        ?? r23 = new Enum("TD_SCDMA", 17);
        ?? r03 = new Enum("IWLAN", 18);
        ?? r17 = new Enum("LTE_CA", 19);
        f6240b = new EnumC0657H[]{r12, r22, r3, r4, r5, r6, r7, r8, r9, r10, r11, r122, r13, r14, r15, r02, r16, r23, r03, r17, new Enum("COMBINED", 20)};
        SparseArray sparseArray = new SparseArray();
        f6239a = sparseArray;
        sparseArray.put(0, r12);
        sparseArray.put(1, r22);
        sparseArray.put(2, r3);
        sparseArray.put(3, r4);
        sparseArray.put(4, r5);
        sparseArray.put(5, r6);
        sparseArray.put(6, r7);
        sparseArray.put(7, r8);
        sparseArray.put(8, r9);
        sparseArray.put(9, r10);
        sparseArray.put(10, r11);
        sparseArray.put(11, r122);
        sparseArray.put(12, r13);
        sparseArray.put(13, r14);
        sparseArray.put(14, r15);
        sparseArray.put(15, r02);
        sparseArray.put(16, r16);
        sparseArray.put(17, r23);
        sparseArray.put(18, r03);
        sparseArray.put(19, r17);
    }

    public static EnumC0657H valueOf(String str) {
        return (EnumC0657H) Enum.valueOf(EnumC0657H.class, str);
    }

    public static EnumC0657H[] values() {
        return (EnumC0657H[]) f6240b.clone();
    }
}
