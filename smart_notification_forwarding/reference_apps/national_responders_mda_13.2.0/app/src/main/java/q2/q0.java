package q2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.location.LocationRequest;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class q0 extends c2.a {
    public static final Parcelable.Creator<q0> CREATOR = new r0();

    /* renamed from: f, reason: collision with root package name */
    LocationRequest f13529f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(LocationRequest locationRequest, List list, boolean z10, boolean z11, String str, boolean z12, boolean z13, String str2, long j10) {
        WorkSource workSource;
        LocationRequest.a aVar = new LocationRequest.a(locationRequest);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    b2.d dVar = (b2.d) it.next();
                    g2.p.a(workSource, dVar.f3953f, dVar.f3954g);
                }
            }
            aVar.k(workSource);
        }
        if (z10) {
            aVar.c(1);
        }
        if (z11) {
            aVar.j(2);
        }
        if (str != null) {
            aVar.i(str);
        } else if (str2 != null) {
            aVar.i(str2);
        }
        if (z12) {
            aVar.h(true);
        }
        if (z13) {
            aVar.g(true);
        }
        if (j10 != Long.MAX_VALUE) {
            aVar.d(j10);
        }
        this.f13529f = aVar.a();
    }

    @Deprecated
    public static q0 g(String str, LocationRequest locationRequest) {
        return new q0(locationRequest, null, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q0) {
            return b2.o.a(this.f13529f, ((q0) obj).f13529f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13529f.hashCode();
    }

    public final String toString() {
        return this.f13529f.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.o(parcel, 1, this.f13529f, i10, false);
        c2.c.b(parcel, a10);
    }
}
