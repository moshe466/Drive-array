package c2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Bundle a(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + v10);
        return readBundle;
    }

    public static int[] b(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + v10);
        return createIntArray;
    }

    public static <T extends Parcelable> T c(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + v10);
        return createFromParcel;
    }

    public static String d(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + v10);
        return readString;
    }

    public static ArrayList<String> e(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + v10);
        return createStringArrayList;
    }

    public static <T> T[] f(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + v10);
        return tArr;
    }

    public static <T> ArrayList<T> g(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + v10);
        return createTypedArrayList;
    }

    public static void h(Parcel parcel, int i10) {
        if (parcel.dataPosition() == i10) {
            return;
        }
        throw new a("Overread allowed size end=" + i10, parcel);
    }

    public static int i(int i10) {
        return (char) i10;
    }

    public static boolean j(Parcel parcel, int i10) {
        z(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean k(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        if (v10 == 0) {
            return null;
        }
        y(parcel, i10, v10, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double l(Parcel parcel, int i10) {
        z(parcel, i10, 8);
        return parcel.readDouble();
    }

    public static Double m(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        if (v10 == 0) {
            return null;
        }
        y(parcel, i10, v10, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float n(Parcel parcel, int i10) {
        z(parcel, i10, 4);
        return parcel.readFloat();
    }

    public static Float o(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        if (v10 == 0) {
            return null;
        }
        y(parcel, i10, v10, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int p(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder q(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (v10 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + v10);
        return readStrongBinder;
    }

    public static int r(Parcel parcel, int i10) {
        z(parcel, i10, 4);
        return parcel.readInt();
    }

    public static long s(Parcel parcel, int i10) {
        z(parcel, i10, 8);
        return parcel.readLong();
    }

    public static Long t(Parcel parcel, int i10) {
        int v10 = v(parcel, i10);
        if (v10 == 0) {
            return null;
        }
        y(parcel, i10, v10, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short u(Parcel parcel, int i10) {
        z(parcel, i10, 4);
        return (short) parcel.readInt();
    }

    public static int v(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static void w(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + v(parcel, i10));
    }

    public static int x(Parcel parcel) {
        int p10 = p(parcel);
        int v10 = v(parcel, p10);
        int dataPosition = parcel.dataPosition();
        if (i(p10) != 20293) {
            throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(p10))), parcel);
        }
        int i10 = v10 + dataPosition;
        if (i10 >= dataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        throw new a("Size read is invalid start=" + dataPosition + " end=" + i10, parcel);
    }

    private static void y(Parcel parcel, int i10, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        throw new a("Expected size " + i12 + " got " + i11 + " (0x" + Integer.toHexString(i11) + ")", parcel);
    }

    private static void z(Parcel parcel, int i10, int i11) {
        int v10 = v(parcel, i10);
        if (v10 == i11) {
            return;
        }
        throw new a("Expected size " + i11 + " got " + v10 + " (0x" + Integer.toHexString(v10) + ")", parcel);
    }
}
