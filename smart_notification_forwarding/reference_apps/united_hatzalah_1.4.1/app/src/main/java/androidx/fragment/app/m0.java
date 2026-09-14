package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class m0 implements Parcelable {
    public static final Parcelable.Creator<m0> CREATOR = new G0.i(6);

    /* renamed from: a, reason: collision with root package name */
    public final String f3440a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3441b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3442c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3443d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3444e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3445f;

    /* renamed from: j, reason: collision with root package name */
    public final String f3446j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3447k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3448l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3449m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3450n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3451o;
    public final String p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3452q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f3453r;

    public m0(G g3) {
        this.f3440a = g3.getClass().getName();
        this.f3441b = g3.mWho;
        this.f3442c = g3.mFromLayout;
        this.f3443d = g3.mInDynamicContainer;
        this.f3444e = g3.mFragmentId;
        this.f3445f = g3.mContainerId;
        this.f3446j = g3.mTag;
        this.f3447k = g3.mRetainInstance;
        this.f3448l = g3.mRemoving;
        this.f3449m = g3.mDetached;
        this.f3450n = g3.mHidden;
        this.f3451o = g3.mMaxState.ordinal();
        this.p = g3.mTargetWho;
        this.f3452q = g3.mTargetRequestCode;
        this.f3453r = g3.mUserVisibleHint;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3440a);
        sb.append(" (");
        sb.append(this.f3441b);
        sb.append(")}:");
        if (this.f3442c) {
            sb.append(" fromLayout");
        }
        if (this.f3443d) {
            sb.append(" dynamicContainer");
        }
        int i = this.f3445f;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.f3446j;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f3447k) {
            sb.append(" retainInstance");
        }
        if (this.f3448l) {
            sb.append(" removing");
        }
        if (this.f3449m) {
            sb.append(" detached");
        }
        if (this.f3450n) {
            sb.append(" hidden");
        }
        String str2 = this.p;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.f3452q);
        }
        if (this.f3453r) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3440a);
        parcel.writeString(this.f3441b);
        parcel.writeInt(this.f3442c ? 1 : 0);
        parcel.writeInt(this.f3443d ? 1 : 0);
        parcel.writeInt(this.f3444e);
        parcel.writeInt(this.f3445f);
        parcel.writeString(this.f3446j);
        parcel.writeInt(this.f3447k ? 1 : 0);
        parcel.writeInt(this.f3448l ? 1 : 0);
        parcel.writeInt(this.f3449m ? 1 : 0);
        parcel.writeInt(this.f3450n ? 1 : 0);
        parcel.writeInt(this.f3451o);
        parcel.writeString(this.p);
        parcel.writeInt(this.f3452q);
        parcel.writeInt(this.f3453r ? 1 : 0);
    }

    public m0(Parcel parcel) {
        this.f3440a = parcel.readString();
        this.f3441b = parcel.readString();
        this.f3442c = parcel.readInt() != 0;
        this.f3443d = parcel.readInt() != 0;
        this.f3444e = parcel.readInt();
        this.f3445f = parcel.readInt();
        this.f3446j = parcel.readString();
        this.f3447k = parcel.readInt() != 0;
        this.f3448l = parcel.readInt() != 0;
        this.f3449m = parcel.readInt() != 0;
        this.f3450n = parcel.readInt() != 0;
        this.f3451o = parcel.readInt();
        this.p = parcel.readString();
        this.f3452q = parcel.readInt();
        this.f3453r = parcel.readInt() != 0;
    }
}
