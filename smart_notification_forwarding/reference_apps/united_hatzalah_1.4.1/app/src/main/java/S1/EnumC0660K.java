package s1;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: s1.K, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0660K {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0660K f6243a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumC0660K[] f6244b;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, java.lang.Object, s1.K] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, java.lang.Object, s1.K] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Enum, java.lang.Object, s1.K] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, java.lang.Object, s1.K] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, java.lang.Object, s1.K] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, java.lang.Object, s1.K] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f6243a = r02;
        ?? r12 = new Enum("UNMETERED_ONLY", 1);
        ?? r22 = new Enum("UNMETERED_OR_DAILY", 2);
        ?? r3 = new Enum("FAST_IF_RADIO_AWAKE", 3);
        ?? r4 = new Enum("NEVER", 4);
        ?? r5 = new Enum("UNRECOGNIZED", 5);
        f6244b = new EnumC0660K[]{r02, r12, r22, r3, r4, r5};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, r02);
        sparseArray.put(1, r12);
        sparseArray.put(2, r22);
        sparseArray.put(3, r3);
        sparseArray.put(4, r4);
        sparseArray.put(-1, r5);
    }

    public static EnumC0660K valueOf(String str) {
        return (EnumC0660K) Enum.valueOf(EnumC0660K.class, str);
    }

    public static EnumC0660K[] values() {
        return (EnumC0660K[]) f6244b.clone();
    }
}
