package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0261b implements Parcelable {
    public static final Parcelable.Creator<C0261b> CREATOR = new G0.i(2);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3339a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3340b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f3341c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f3342d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3343e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3344f;

    /* renamed from: j, reason: collision with root package name */
    public final int f3345j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3346k;

    /* renamed from: l, reason: collision with root package name */
    public final CharSequence f3347l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3348m;

    /* renamed from: n, reason: collision with root package name */
    public final CharSequence f3349n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f3350o;
    public final ArrayList p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3351q;

    public C0261b(C0259a c0259a) {
        int size = c0259a.f3497a.size();
        this.f3339a = new int[size * 6];
        if (c0259a.f3503g) {
            this.f3340b = new ArrayList(size);
            this.f3341c = new int[size];
            this.f3342d = new int[size];
            int i = 0;
            for (int i3 = 0; i3 < size; i3++) {
                q0 q0Var = (q0) c0259a.f3497a.get(i3);
                int i4 = i + 1;
                this.f3339a[i] = q0Var.f3488a;
                ArrayList arrayList = this.f3340b;
                G g3 = q0Var.f3489b;
                arrayList.add(g3 != null ? g3.mWho : null);
                int[] iArr = this.f3339a;
                iArr[i4] = q0Var.f3490c ? 1 : 0;
                iArr[i + 2] = q0Var.f3491d;
                iArr[i + 3] = q0Var.f3492e;
                int i5 = i + 5;
                iArr[i + 4] = q0Var.f3493f;
                i += 6;
                iArr[i5] = q0Var.f3494g;
                this.f3341c[i3] = q0Var.f3495h.ordinal();
                this.f3342d[i3] = q0Var.i.ordinal();
            }
            this.f3343e = c0259a.f3502f;
            this.f3344f = c0259a.f3504h;
            this.f3345j = c0259a.f3337s;
            this.f3346k = c0259a.i;
            this.f3347l = c0259a.f3505j;
            this.f3348m = c0259a.f3506k;
            this.f3349n = c0259a.f3507l;
            this.f3350o = c0259a.f3508m;
            this.p = c0259a.f3509n;
            this.f3351q = c0259a.f3510o;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f3339a);
        parcel.writeStringList(this.f3340b);
        parcel.writeIntArray(this.f3341c);
        parcel.writeIntArray(this.f3342d);
        parcel.writeInt(this.f3343e);
        parcel.writeString(this.f3344f);
        parcel.writeInt(this.f3345j);
        parcel.writeInt(this.f3346k);
        TextUtils.writeToParcel(this.f3347l, parcel, 0);
        parcel.writeInt(this.f3348m);
        TextUtils.writeToParcel(this.f3349n, parcel, 0);
        parcel.writeStringList(this.f3350o);
        parcel.writeStringList(this.p);
        parcel.writeInt(this.f3351q ? 1 : 0);
    }

    public C0261b(Parcel parcel) {
        this.f3339a = parcel.createIntArray();
        this.f3340b = parcel.createStringArrayList();
        this.f3341c = parcel.createIntArray();
        this.f3342d = parcel.createIntArray();
        this.f3343e = parcel.readInt();
        this.f3344f = parcel.readString();
        this.f3345j = parcel.readInt();
        this.f3346k = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f3347l = (CharSequence) creator.createFromParcel(parcel);
        this.f3348m = parcel.readInt();
        this.f3349n = (CharSequence) creator.createFromParcel(parcel);
        this.f3350o = parcel.createStringArrayList();
        this.p = parcel.createStringArrayList();
        this.f3351q = parcel.readInt() != 0;
    }
}
