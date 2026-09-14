package y;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* renamed from: f, reason: collision with root package name */
    private final Parcelable f15830f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f15829g = new C0335a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: y.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0335a extends a {
        C0335a() {
            super((C0335a) null);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f15829g;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    private a() {
        this.f15830f = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f15830f = readParcelable == null ? f15829g : readParcelable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f15830f = parcelable == f15829g ? null : parcelable;
    }

    /* synthetic */ a(C0335a c0335a) {
        this();
    }

    public final Parcelable a() {
        return this.f15830f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f15830f, i10);
    }
}
