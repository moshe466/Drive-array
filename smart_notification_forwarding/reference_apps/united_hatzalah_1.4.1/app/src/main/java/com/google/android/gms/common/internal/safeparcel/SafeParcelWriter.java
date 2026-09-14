package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel parcel) {
        return zzb(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i) {
        zzc(parcel, i);
    }

    public static void writeBigDecimal(Parcel parcel, int i, BigDecimal bigDecimal, boolean z3) {
        if (bigDecimal == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzc(parcel, zzb);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i, BigDecimal[] bigDecimalArr, boolean z3) {
        if (bigDecimalArr == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i3 = 0; i3 < length; i3++) {
            parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i3].scale());
        }
        zzc(parcel, zzb);
    }

    public static void writeBigInteger(Parcel parcel, int i, BigInteger bigInteger, boolean z3) {
        if (bigInteger == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzc(parcel, zzb);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i, BigInteger[] bigIntegerArr, boolean z3) {
        if (bigIntegerArr == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        zzc(parcel, zzb);
    }

    public static void writeBoolean(Parcel parcel, int i, boolean z3) {
        zza(parcel, i, 4);
        parcel.writeInt(z3 ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel parcel, int i, boolean[] zArr, boolean z3) {
        if (zArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeBooleanArray(zArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i, List<Boolean> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).booleanValue() ? 1 : 0);
        }
        zzc(parcel, zzb);
    }

    public static void writeBooleanObject(Parcel parcel, int i, Boolean bool, boolean z3) {
        if (bool == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            zza(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle, boolean z3) {
        if (bundle == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeBundle(bundle);
            zzc(parcel, zzb);
        }
    }

    public static void writeByte(Parcel parcel, int i, byte b4) {
        zza(parcel, i, 4);
        parcel.writeInt(b4);
    }

    public static void writeByteArray(Parcel parcel, int i, byte[] bArr, boolean z3) {
        if (bArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeByteArray(bArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i, byte[][] bArr, boolean z3) {
        if (bArr == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        zzc(parcel, zzb);
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i, SparseArray<byte[]> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeByteArray(sparseArray.valueAt(i3));
        }
        zzc(parcel, zzb);
    }

    public static void writeChar(Parcel parcel, int i, char c4) {
        zza(parcel, i, 4);
        parcel.writeInt(c4);
    }

    public static void writeCharArray(Parcel parcel, int i, char[] cArr, boolean z3) {
        if (cArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeCharArray(cArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeDouble(Parcel parcel, int i, double d2) {
        zza(parcel, i, 8);
        parcel.writeDouble(d2);
    }

    public static void writeDoubleArray(Parcel parcel, int i, double[] dArr, boolean z3) {
        if (dArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeDoubleArray(dArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i, List<Double> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeDouble(list.get(i3).doubleValue());
        }
        zzc(parcel, zzb);
    }

    public static void writeDoubleObject(Parcel parcel, int i, Double d2, boolean z3) {
        if (d2 == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            zza(parcel, i, 8);
            parcel.writeDouble(d2.doubleValue());
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i, SparseArray<Double> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeDouble(sparseArray.valueAt(i3).doubleValue());
        }
        zzc(parcel, zzb);
    }

    public static void writeFloat(Parcel parcel, int i, float f4) {
        zza(parcel, i, 4);
        parcel.writeFloat(f4);
    }

    public static void writeFloatArray(Parcel parcel, int i, float[] fArr, boolean z3) {
        if (fArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeFloatArray(fArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeFloatList(Parcel parcel, int i, List<Float> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeFloat(list.get(i3).floatValue());
        }
        zzc(parcel, zzb);
    }

    public static void writeFloatObject(Parcel parcel, int i, Float f4, boolean z3) {
        if (f4 == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            zza(parcel, i, 4);
            parcel.writeFloat(f4.floatValue());
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i, SparseArray<Float> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeFloat(sparseArray.valueAt(i3).floatValue());
        }
        zzc(parcel, zzb);
    }

    public static void writeIBinder(Parcel parcel, int i, IBinder iBinder, boolean z3) {
        if (iBinder == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeStrongBinder(iBinder);
            zzc(parcel, zzb);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i, IBinder[] iBinderArr, boolean z3) {
        if (iBinderArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i, List<IBinder> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeBinderList(list);
            zzc(parcel, zzb);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i, SparseArray<IBinder> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeStrongBinder(sparseArray.valueAt(i3));
        }
        zzc(parcel, zzb);
    }

    public static void writeInt(Parcel parcel, int i, int i3) {
        zza(parcel, i, 4);
        parcel.writeInt(i3);
    }

    public static void writeIntArray(Parcel parcel, int i, int[] iArr, boolean z3) {
        if (iArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeIntArray(iArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i, List<Integer> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).intValue());
        }
        zzc(parcel, zzb);
    }

    public static void writeIntegerObject(Parcel parcel, int i, Integer num, boolean z3) {
        if (num == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            zza(parcel, i, 4);
            parcel.writeInt(num.intValue());
        }
    }

    public static void writeList(Parcel parcel, int i, List list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeList(list);
            zzc(parcel, zzb);
        }
    }

    public static void writeLong(Parcel parcel, int i, long j2) {
        zza(parcel, i, 8);
        parcel.writeLong(j2);
    }

    public static void writeLongArray(Parcel parcel, int i, long[] jArr, boolean z3) {
        if (jArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeLongArray(jArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeLongList(Parcel parcel, int i, List<Long> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeLong(list.get(i3).longValue());
        }
        zzc(parcel, zzb);
    }

    public static void writeLongObject(Parcel parcel, int i, Long l3, boolean z3) {
        if (l3 == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            zza(parcel, i, 8);
            parcel.writeLong(l3.longValue());
        }
    }

    public static void writeParcel(Parcel parcel, int i, Parcel parcel2, boolean z3) {
        if (parcel2 == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzc(parcel, zzb);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i, Parcel[] parcelArr, boolean z3) {
        if (parcelArr == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzc(parcel, zzb);
    }

    public static void writeParcelList(Parcel parcel, int i, List<Parcel> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcel parcel2 = list.get(i3);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzc(parcel, zzb);
    }

    public static void writeParcelSparseArray(Parcel parcel, int i, SparseArray<Parcel> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            Parcel valueAt = sparseArray.valueAt(i3);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzc(parcel, zzb);
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i3, boolean z3) {
        if (parcelable == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcelable.writeToParcel(parcel, i3);
            zzc(parcel, zzb);
        }
    }

    public static void writePendingIntent(Parcel parcel, int i, PendingIntent pendingIntent, boolean z3) {
        if (pendingIntent == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzc(parcel, zzb);
        }
    }

    public static void writeShort(Parcel parcel, int i, short s3) {
        zza(parcel, i, 4);
        parcel.writeInt(s3);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i, SparseBooleanArray sparseBooleanArray, boolean z3) {
        if (sparseBooleanArray == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzc(parcel, zzb);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i, SparseIntArray sparseIntArray, boolean z3) {
        if (sparseIntArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseIntArray.keyAt(i3));
            parcel.writeInt(sparseIntArray.valueAt(i3));
        }
        zzc(parcel, zzb);
    }

    public static void writeSparseLongArray(Parcel parcel, int i, SparseLongArray sparseLongArray, boolean z3) {
        if (sparseLongArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseLongArray.keyAt(i3));
            parcel.writeLong(sparseLongArray.valueAt(i3));
        }
        zzc(parcel, zzb);
    }

    public static void writeString(Parcel parcel, int i, String str, boolean z3) {
        if (str == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeString(str);
            zzc(parcel, zzb);
        }
    }

    public static void writeStringArray(Parcel parcel, int i, String[] strArr, boolean z3) {
        if (strArr == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeStringArray(strArr);
            zzc(parcel, zzb);
        }
    }

    public static void writeStringList(Parcel parcel, int i, List<String> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
            }
        } else {
            int zzb = zzb(parcel, i);
            parcel.writeStringList(list);
            zzc(parcel, zzb);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i, SparseArray<String> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            parcel.writeString(sparseArray.valueAt(i3));
        }
        zzc(parcel, zzb);
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i, T[] tArr, int i3, boolean z3) {
        if (tArr == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t3 : tArr) {
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t3, i3);
            }
        }
        zzc(parcel, zzb);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i, List<T> list, boolean z3) {
        if (list == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t3 = list.get(i3);
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t3, 0);
            }
        }
        zzc(parcel, zzb);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i, SparseArray<T> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int zzb = zzb(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(sparseArray.keyAt(i3));
            T valueAt = sparseArray.valueAt(i3);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, valueAt, 0);
            }
        }
        zzc(parcel, zzb);
    }

    private static void zza(Parcel parcel, int i, int i3) {
        parcel.writeInt(i | (i3 << 16));
    }

    private static int zzb(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzc(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
