package Q;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.F;
import k0.C0471B;
import m.c1;
import m.q1;

/* loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1719a;

    public /* synthetic */ b(int i) {
        this.f1719a = i;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f1719a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return c.f1720b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new F(parcel, classLoader);
            case 2:
                return new C0471B(parcel, classLoader);
            case 3:
                return new c1(parcel, classLoader);
            default:
                return new q1(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f1719a) {
            case 0:
                return new c[i];
            case 1:
                return new F[i];
            case 2:
                return new C0471B[i];
            case 3:
                return new c1[i];
            default:
                return new q1[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1719a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return c.f1720b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new F(parcel, null);
            case 2:
                return new C0471B(parcel, null);
            case 3:
                return new c1(parcel, null);
            default:
                return new q1(parcel, null);
        }
    }
}
