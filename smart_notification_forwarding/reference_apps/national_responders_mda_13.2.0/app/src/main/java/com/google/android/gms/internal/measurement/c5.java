package com.google.android.gms.internal.measurement;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c5<K, V> extends p4<K, V> {

    /* renamed from: l, reason: collision with root package name */
    static final p4<Object, Object> f5229l = new c5(null, new Object[0], 0);

    /* renamed from: i, reason: collision with root package name */
    private final transient Object f5230i;

    /* renamed from: j, reason: collision with root package name */
    private final transient Object[] f5231j;

    /* renamed from: k, reason: collision with root package name */
    private final transient int f5232k;

    private c5(Object obj, Object[] objArr, int i10) {
        this.f5230i = obj;
        this.f5231j = objArr;
        this.f5232k = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0097, code lost:
    
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:
    
        r2[r7] = r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <K, V> com.google.android.gms.internal.measurement.c5<K, V> d(int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c5.d(int, java.lang.Object[]):com.google.android.gms.internal.measurement.c5");
    }

    private static IllegalArgumentException e(Object obj, Object obj2, Object[] objArr, int i10) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i10]);
        String valueOf4 = String.valueOf(objArr[i10 ^ 1]);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
        sb2.append("Multiple entries with same key: ");
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        sb2.append(" and ");
        sb2.append(valueOf3);
        sb2.append("=");
        sb2.append(valueOf4);
        return new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.p4
    final t4<Map.Entry<K, V>> a() {
        return new b5(this, this.f5231j, 0, this.f5232k);
    }

    @Override // com.google.android.gms.internal.measurement.p4
    final t4<K> b() {
        return new d5(this, new g5(this.f5231j, 0, this.f5232k));
    }

    @Override // com.google.android.gms.internal.measurement.p4
    final k4<V> c() {
        return new g5(this.f5231j, 1, this.f5232k);
    }

    @Override // com.google.android.gms.internal.measurement.p4, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.f5230i;
        Object[] objArr = this.f5231j;
        int i10 = this.f5232k;
        if (obj == null) {
            return null;
        }
        if (i10 == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int a10 = l4.a(obj.hashCode());
            while (true) {
                int i11 = a10 & length;
                int i12 = bArr[i11] & 255;
                if (i12 == 255) {
                    return null;
                }
                if (objArr[i12].equals(obj)) {
                    return (V) objArr[i12 ^ 1];
                }
                a10 = i11 + 1;
            }
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int a11 = l4.a(obj.hashCode());
            while (true) {
                int i13 = a11 & length2;
                int i14 = sArr[i13] & 65535;
                if (i14 == 65535) {
                    return null;
                }
                if (objArr[i14].equals(obj)) {
                    return (V) objArr[i14 ^ 1];
                }
                a11 = i13 + 1;
            }
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int a12 = l4.a(obj.hashCode());
            while (true) {
                int i15 = a12 & length3;
                int i16 = iArr[i15];
                if (i16 == -1) {
                    return null;
                }
                if (objArr[i16].equals(obj)) {
                    return (V) objArr[i16 ^ 1];
                }
                a12 = i15 + 1;
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.f5232k;
    }
}
