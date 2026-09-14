package x2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class b extends c2.a implements a2.j {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* renamed from: f, reason: collision with root package name */
    final int f15403f;

    /* renamed from: g, reason: collision with root package name */
    private int f15404g;

    /* renamed from: h, reason: collision with root package name */
    private Intent f15405h;

    public b() {
        this(2, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i10, int i11, Intent intent) {
        this.f15403f = i10;
        this.f15404g = i11;
        this.f15405h = intent;
    }

    @Override // a2.j
    public final Status c() {
        return this.f15404g == 0 ? Status.f4747k : Status.f4750n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f15403f);
        c2.c.k(parcel, 2, this.f15404g);
        c2.c.o(parcel, 3, this.f15405h, i10, false);
        c2.c.b(parcel, a10);
    }
}
