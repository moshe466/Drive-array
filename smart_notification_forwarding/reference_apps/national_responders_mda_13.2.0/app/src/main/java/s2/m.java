package s2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import q2.u0;

/* loaded from: classes.dex */
public class m extends c2.a {
    public static final Parcelable.Creator<m> CREATOR = new a0();

    /* renamed from: f, reason: collision with root package name */
    private final List f14046f;

    /* renamed from: g, reason: collision with root package name */
    private final int f14047g;

    /* renamed from: h, reason: collision with root package name */
    private final String f14048h;

    /* renamed from: i, reason: collision with root package name */
    private final String f14049i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List f14050a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private int f14051b = 5;

        /* renamed from: c, reason: collision with root package name */
        private String f14052c = "";

        public a a(i iVar) {
            b2.p.l(iVar, "geofence can't be null.");
            b2.p.b(iVar instanceof u0, "Geofence must be created using Geofence.Builder.");
            this.f14050a.add((u0) iVar);
            return this;
        }

        public a b(List<i> list) {
            if (list != null && !list.isEmpty()) {
                for (i iVar : list) {
                    if (iVar != null) {
                        a(iVar);
                    }
                }
            }
            return this;
        }

        public m c() {
            b2.p.b(!this.f14050a.isEmpty(), "No geofence has been added to this request.");
            return new m(this.f14050a, this.f14051b, this.f14052c, null);
        }

        public a d(int i10) {
            this.f14051b = i10 & 7;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(List list, int i10, String str, String str2) {
        this.f14046f = list;
        this.f14047g = i10;
        this.f14048h = str;
        this.f14049i = str2;
    }

    public int g() {
        return this.f14047g;
    }

    public final m j(String str) {
        return new m(this.f14046f, this.f14047g, this.f14048h, str);
    }

    public String toString() {
        return "GeofencingRequest[geofences=" + this.f14046f + ", initialTrigger=" + this.f14047g + ", tag=" + this.f14048h + ", attributionTag=" + this.f14049i + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c2.c.a(parcel);
        c2.c.t(parcel, 1, this.f14046f, false);
        c2.c.k(parcel, 2, g());
        c2.c.q(parcel, 3, this.f14048h, false);
        c2.c.q(parcel, 4, this.f14049i, false);
        c2.c.b(parcel, a10);
    }
}
