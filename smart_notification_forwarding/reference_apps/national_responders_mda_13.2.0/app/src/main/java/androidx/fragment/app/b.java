package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.f0;
import androidx.lifecycle.h;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    final int[] f2893f;

    /* renamed from: g, reason: collision with root package name */
    final ArrayList<String> f2894g;

    /* renamed from: h, reason: collision with root package name */
    final int[] f2895h;

    /* renamed from: i, reason: collision with root package name */
    final int[] f2896i;

    /* renamed from: j, reason: collision with root package name */
    final int f2897j;

    /* renamed from: k, reason: collision with root package name */
    final String f2898k;

    /* renamed from: l, reason: collision with root package name */
    final int f2899l;

    /* renamed from: m, reason: collision with root package name */
    final int f2900m;

    /* renamed from: n, reason: collision with root package name */
    final CharSequence f2901n;

    /* renamed from: o, reason: collision with root package name */
    final int f2902o;

    /* renamed from: p, reason: collision with root package name */
    final CharSequence f2903p;

    /* renamed from: q, reason: collision with root package name */
    final ArrayList<String> f2904q;

    /* renamed from: r, reason: collision with root package name */
    final ArrayList<String> f2905r;

    /* renamed from: s, reason: collision with root package name */
    final boolean f2906s;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    b(Parcel parcel) {
        this.f2893f = parcel.createIntArray();
        this.f2894g = parcel.createStringArrayList();
        this.f2895h = parcel.createIntArray();
        this.f2896i = parcel.createIntArray();
        this.f2897j = parcel.readInt();
        this.f2898k = parcel.readString();
        this.f2899l = parcel.readInt();
        this.f2900m = parcel.readInt();
        this.f2901n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2902o = parcel.readInt();
        this.f2903p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2904q = parcel.createStringArrayList();
        this.f2905r = parcel.createStringArrayList();
        this.f2906s = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f2994a.size();
        this.f2893f = new int[size * 6];
        if (!aVar.f3000g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2894g = new ArrayList<>(size);
        this.f2895h = new int[size];
        this.f2896i = new int[size];
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            f0.a aVar2 = aVar.f2994a.get(i10);
            int i12 = i11 + 1;
            this.f2893f[i11] = aVar2.f3011a;
            ArrayList<String> arrayList = this.f2894g;
            Fragment fragment = aVar2.f3012b;
            arrayList.add(fragment != null ? fragment.f2836k : null);
            int[] iArr = this.f2893f;
            int i13 = i12 + 1;
            iArr[i12] = aVar2.f3013c ? 1 : 0;
            int i14 = i13 + 1;
            iArr[i13] = aVar2.f3014d;
            int i15 = i14 + 1;
            iArr[i14] = aVar2.f3015e;
            int i16 = i15 + 1;
            iArr[i15] = aVar2.f3016f;
            iArr[i16] = aVar2.f3017g;
            this.f2895h[i10] = aVar2.f3018h.ordinal();
            this.f2896i[i10] = aVar2.f3019i.ordinal();
            i10++;
            i11 = i16 + 1;
        }
        this.f2897j = aVar.f2999f;
        this.f2898k = aVar.f3002i;
        this.f2899l = aVar.f2891t;
        this.f2900m = aVar.f3003j;
        this.f2901n = aVar.f3004k;
        this.f2902o = aVar.f3005l;
        this.f2903p = aVar.f3006m;
        this.f2904q = aVar.f3007n;
        this.f2905r = aVar.f3008o;
        this.f2906s = aVar.f3009p;
    }

    private void a(androidx.fragment.app.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.f2893f.length) {
                aVar.f2999f = this.f2897j;
                aVar.f3002i = this.f2898k;
                aVar.f3000g = true;
                aVar.f3003j = this.f2900m;
                aVar.f3004k = this.f2901n;
                aVar.f3005l = this.f2902o;
                aVar.f3006m = this.f2903p;
                aVar.f3007n = this.f2904q;
                aVar.f3008o = this.f2905r;
                aVar.f3009p = this.f2906s;
                return;
            }
            f0.a aVar2 = new f0.a();
            int i12 = i10 + 1;
            aVar2.f3011a = this.f2893f[i10];
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Instantiate ");
                sb2.append(aVar);
                sb2.append(" op #");
                sb2.append(i11);
                sb2.append(" base fragment #");
                sb2.append(this.f2893f[i12]);
            }
            aVar2.f3018h = h.c.values()[this.f2895h[i11]];
            aVar2.f3019i = h.c.values()[this.f2896i[i11]];
            int[] iArr = this.f2893f;
            int i13 = i12 + 1;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar2.f3013c = z10;
            int i14 = i13 + 1;
            int i15 = iArr[i13];
            aVar2.f3014d = i15;
            int i16 = i14 + 1;
            int i17 = iArr[i14];
            aVar2.f3015e = i17;
            int i18 = i16 + 1;
            int i19 = iArr[i16];
            aVar2.f3016f = i19;
            int i20 = iArr[i18];
            aVar2.f3017g = i20;
            aVar.f2995b = i15;
            aVar.f2996c = i17;
            aVar.f2997d = i19;
            aVar.f2998e = i20;
            aVar.f(aVar2);
            i11++;
            i10 = i18 + 1;
        }
    }

    public androidx.fragment.app.a b(w wVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(wVar);
        a(aVar);
        aVar.f2891t = this.f2899l;
        for (int i10 = 0; i10 < this.f2894g.size(); i10++) {
            String str = this.f2894g.get(i10);
            if (str != null) {
                aVar.f2994a.get(i10).f3012b = wVar.f0(str);
            }
        }
        aVar.t(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f2893f);
        parcel.writeStringList(this.f2894g);
        parcel.writeIntArray(this.f2895h);
        parcel.writeIntArray(this.f2896i);
        parcel.writeInt(this.f2897j);
        parcel.writeString(this.f2898k);
        parcel.writeInt(this.f2899l);
        parcel.writeInt(this.f2900m);
        TextUtils.writeToParcel(this.f2901n, parcel, 0);
        parcel.writeInt(this.f2902o);
        TextUtils.writeToParcel(this.f2903p, parcel, 0);
        parcel.writeStringList(this.f2904q);
        parcel.writeStringList(this.f2905r);
        parcel.writeInt(this.f2906s ? 1 : 0);
    }
}
