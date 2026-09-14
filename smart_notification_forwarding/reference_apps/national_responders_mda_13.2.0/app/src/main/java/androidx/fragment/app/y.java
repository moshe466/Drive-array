package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.w;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f3139f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<String> f3140g;

    /* renamed from: h, reason: collision with root package name */
    b[] f3141h;

    /* renamed from: i, reason: collision with root package name */
    int f3142i;

    /* renamed from: j, reason: collision with root package name */
    String f3143j;

    /* renamed from: k, reason: collision with root package name */
    ArrayList<String> f3144k;

    /* renamed from: l, reason: collision with root package name */
    ArrayList<c> f3145l;

    /* renamed from: m, reason: collision with root package name */
    ArrayList<w.l> f3146m;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<y> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public y createFromParcel(Parcel parcel) {
            return new y(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public y[] newArray(int i10) {
            return new y[i10];
        }
    }

    public y() {
        this.f3143j = null;
        this.f3144k = new ArrayList<>();
        this.f3145l = new ArrayList<>();
    }

    public y(Parcel parcel) {
        this.f3143j = null;
        this.f3144k = new ArrayList<>();
        this.f3145l = new ArrayList<>();
        this.f3139f = parcel.createStringArrayList();
        this.f3140g = parcel.createStringArrayList();
        this.f3141h = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f3142i = parcel.readInt();
        this.f3143j = parcel.readString();
        this.f3144k = parcel.createStringArrayList();
        this.f3145l = parcel.createTypedArrayList(c.CREATOR);
        this.f3146m = parcel.createTypedArrayList(w.l.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f3139f);
        parcel.writeStringList(this.f3140g);
        parcel.writeTypedArray(this.f3141h, i10);
        parcel.writeInt(this.f3142i);
        parcel.writeString(this.f3143j);
        parcel.writeStringList(this.f3144k);
        parcel.writeTypedList(this.f3145l);
        parcel.writeTypedList(this.f3146m);
    }
}
