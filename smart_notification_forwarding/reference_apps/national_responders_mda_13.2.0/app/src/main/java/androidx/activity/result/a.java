package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0017a();

    /* renamed from: f, reason: collision with root package name */
    private final int f500f;

    /* renamed from: g, reason: collision with root package name */
    private final Intent f501g;

    /* renamed from: androidx.activity.result.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0017a implements Parcelable.Creator<a> {
        C0017a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(int i10, Intent intent) {
        this.f500f = i10;
        this.f501g = intent;
    }

    a(Parcel parcel) {
        this.f500f = parcel.readInt();
        this.f501g = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String c(int i10) {
        return i10 != -1 ? i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f501g;
    }

    public int b() {
        return this.f500f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f500f) + ", data=" + this.f501g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f500f);
        parcel.writeInt(this.f501g == null ? 0 : 1);
        Intent intent = this.f501g;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }
}
