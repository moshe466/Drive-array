package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    public int f420f;

    /* renamed from: g, reason: collision with root package name */
    public int f421g;

    /* renamed from: h, reason: collision with root package name */
    public int f422h;

    /* renamed from: i, reason: collision with root package name */
    public int f423i;

    /* renamed from: j, reason: collision with root package name */
    public int f424j;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f420f = parcel.readInt();
        this.f422h = parcel.readInt();
        this.f423i = parcel.readInt();
        this.f424j = parcel.readInt();
        this.f421g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f420f);
        parcel.writeInt(this.f422h);
        parcel.writeInt(this.f423i);
        parcel.writeInt(this.f424j);
        parcel.writeInt(this.f421g);
    }
}
