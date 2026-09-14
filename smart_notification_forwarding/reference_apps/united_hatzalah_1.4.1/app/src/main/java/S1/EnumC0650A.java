package s1;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: s1.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0650A {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0650A f6237a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0650A[] f6238b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0650A EF0;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, s1.A, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, s1.A, java.lang.Object] */
    static {
        ?? r02 = new Enum("NOT_SET", 0);
        ?? r12 = new Enum("EVENT_OVERRIDE", 1);
        f6237a = r12;
        f6238b = new EnumC0650A[]{r02, r12};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, r02);
        sparseArray.put(5, r12);
    }

    public static EnumC0650A valueOf(String str) {
        return (EnumC0650A) Enum.valueOf(EnumC0650A.class, str);
    }

    public static EnumC0650A[] values() {
        return (EnumC0650A[]) f6238b.clone();
    }
}
