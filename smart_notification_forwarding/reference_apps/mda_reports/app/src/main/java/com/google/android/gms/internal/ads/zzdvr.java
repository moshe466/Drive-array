package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class zzdvr implements Cloneable {
    private Object value;
    private zzdvp<?, ?> zzhtn;
    private List<zzdvv> zzhto = new ArrayList();

    private final byte[] toByteArray() {
        byte[] bArr = new byte[a()];
        a(zzdvo.zzaa(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzbcs, reason: merged with bridge method [inline-methods] */
    public final zzdvr clone() {
        Object clone;
        zzdvr zzdvrVar = new zzdvr();
        try {
            zzdvrVar.zzhtn = this.zzhtn;
            if (this.zzhto == null) {
                zzdvrVar.zzhto = null;
            } else {
                zzdvrVar.zzhto.addAll(this.zzhto);
            }
            if (this.value != null) {
                if (this.value instanceof zzdvt) {
                    clone = (zzdvt) ((zzdvt) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length];
                        zzdvrVar.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzdvt[]) {
                        zzdvt[] zzdvtVarArr = (zzdvt[]) this.value;
                        zzdvt[] zzdvtVarArr2 = new zzdvt[zzdvtVarArr.length];
                        zzdvrVar.value = zzdvtVarArr2;
                        while (i < zzdvtVarArr.length) {
                            zzdvtVarArr2[i] = (zzdvt) zzdvtVarArr[i].clone();
                            i++;
                        }
                    }
                }
                zzdvrVar.value = clone;
            }
            return zzdvrVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        Iterator<zzdvv> it = this.zzhto.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzdvo zzdvoVar) {
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        Iterator<zzdvv> it = this.zzhto.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
    }

    public final boolean equals(Object obj) {
        List<zzdvv> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdvr)) {
            return false;
        }
        zzdvr zzdvrVar = (zzdvr) obj;
        if (this.value == null || zzdvrVar.value == null) {
            List<zzdvv> list2 = this.zzhto;
            if (list2 != null && (list = zzdvrVar.zzhto) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzdvrVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        zzdvp<?, ?> zzdvpVar = this.zzhtn;
        if (zzdvpVar != zzdvrVar.zzhtn) {
            return false;
        }
        if (!zzdvpVar.a.isArray()) {
            return this.value.equals(zzdvrVar.value);
        }
        Object obj2 = this.value;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzdvrVar.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzdvrVar.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzdvrVar.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzdvrVar.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzdvrVar.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzdvrVar.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzdvrVar.value);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
