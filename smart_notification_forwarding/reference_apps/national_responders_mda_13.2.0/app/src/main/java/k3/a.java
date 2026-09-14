package k3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import l.g;

/* loaded from: classes.dex */
public class a extends y.a {
    public static final Parcelable.Creator<a> CREATOR = new C0227a();

    /* renamed from: h, reason: collision with root package name */
    public final g<String, Bundle> f11195h;

    /* renamed from: k3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0227a implements Parcelable.ClassLoaderCreator<a> {
        C0227a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f11195h = new g<>(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f11195h.put(strArr[i10], bundleArr[i10]);
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0227a c0227a) {
        this(parcel, classLoader);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f11195h = new g<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f11195h + "}";
    }

    @Override // y.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        int size = this.f11195h.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = this.f11195h.i(i11);
            bundleArr[i11] = this.f11195h.n(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
