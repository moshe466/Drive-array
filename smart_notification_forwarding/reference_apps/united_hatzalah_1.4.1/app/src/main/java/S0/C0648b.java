package s0;

import F0.AbstractC0008a;
import android.os.Parcel;
import android.util.SparseIntArray;
import t.C0689e;
import t.C0694j;

/* renamed from: s0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0648b extends AbstractC0647a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f6230d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f6231e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6232f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6233g;

    /* renamed from: h, reason: collision with root package name */
    public final String f6234h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f6235j;

    /* renamed from: k, reason: collision with root package name */
    public int f6236k;

    /* JADX WARN: Type inference failed for: r5v0, types: [t.j, t.e] */
    /* JADX WARN: Type inference failed for: r6v0, types: [t.j, t.e] */
    /* JADX WARN: Type inference failed for: r7v0, types: [t.j, t.e] */
    public C0648b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0694j(0), new C0694j(0), new C0694j(0));
    }

    @Override // s0.AbstractC0647a
    public final C0648b a() {
        Parcel parcel = this.f6231e;
        int dataPosition = parcel.dataPosition();
        int i = this.f6235j;
        if (i == this.f6232f) {
            i = this.f6233g;
        }
        return new C0648b(parcel, dataPosition, i, AbstractC0008a.u(new StringBuilder(), this.f6234h, "  "), this.f6227a, this.f6228b, this.f6229c);
    }

    @Override // s0.AbstractC0647a
    public final boolean e(int i) {
        while (this.f6235j < this.f6233g) {
            int i3 = this.f6236k;
            if (i3 != i) {
                if (String.valueOf(i3).compareTo(String.valueOf(i)) <= 0) {
                    int i4 = this.f6235j;
                    Parcel parcel = this.f6231e;
                    parcel.setDataPosition(i4);
                    int readInt = parcel.readInt();
                    this.f6236k = parcel.readInt();
                    this.f6235j += readInt;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        if (this.f6236k == i) {
            return true;
        }
        return false;
    }

    @Override // s0.AbstractC0647a
    public final void h(int i) {
        int i3 = this.i;
        SparseIntArray sparseIntArray = this.f6230d;
        Parcel parcel = this.f6231e;
        if (i3 >= 0) {
            int i4 = sparseIntArray.get(i3);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i4);
            parcel.writeInt(dataPosition - i4);
            parcel.setDataPosition(dataPosition);
        }
        this.i = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public C0648b(Parcel parcel, int i, int i3, String str, C0689e c0689e, C0689e c0689e2, C0689e c0689e3) {
        super(c0689e, c0689e2, c0689e3);
        this.f6230d = new SparseIntArray();
        this.i = -1;
        this.f6236k = -1;
        this.f6231e = parcel;
        this.f6232f = i;
        this.f6233g = i3;
        this.f6235j = i;
        this.f6234h = str;
    }
}
