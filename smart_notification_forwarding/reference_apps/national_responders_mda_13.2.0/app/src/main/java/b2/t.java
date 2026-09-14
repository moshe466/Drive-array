package b2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class t extends c2.a {
    public static final Parcelable.Creator<t> CREATOR = new x();

    /* renamed from: f, reason: collision with root package name */
    private final int f4076f;

    /* renamed from: g, reason: collision with root package name */
    private List f4077g;

    public t(int i10, List list) {
        this.f4076f = i10;
        this.f4077g = list;
    }

    public final int g() {
        return this.f4076f;
    }

    public final List j() {
        return this.f4077g;
    }

    public final void l(n nVar) {
        if (this.f4077g == null) {
            this.f4077g = new ArrayList();
        }
        this.f4077g.add(nVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.k(parcel, 1, this.f4076f);
        c2.c.t(parcel, 2, this.f4077g, false);
        c2.c.b(parcel, a10);
    }
}
