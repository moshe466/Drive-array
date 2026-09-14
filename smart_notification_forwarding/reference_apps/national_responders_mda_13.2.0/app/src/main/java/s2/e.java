package s2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class e extends c2.a {
    public static final Parcelable.Creator<e> CREATOR = new w();

    /* renamed from: j, reason: collision with root package name */
    public static final Comparator<c> f14009j = new v();

    /* renamed from: f, reason: collision with root package name */
    private final List f14010f;

    /* renamed from: g, reason: collision with root package name */
    private final String f14011g;

    /* renamed from: h, reason: collision with root package name */
    private final List f14012h;

    /* renamed from: i, reason: collision with root package name */
    private String f14013i;

    public e(List<c> list) {
        this(list, null, null, null);
    }

    public e(List list, String str, List list2, String str2) {
        b2.p.l(list, "transitions can't be null");
        b2.p.b(list.size() > 0, "transitions can't be empty.");
        b2.p.k(list);
        TreeSet treeSet = new TreeSet(f14009j);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            b2.p.b(treeSet.add(cVar), String.format("Found duplicated transition: %s.", cVar));
        }
        this.f14010f = Collections.unmodifiableList(list);
        this.f14011g = str;
        this.f14012h = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f14013i = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (b2.o.a(this.f14010f, eVar.f14010f) && b2.o.a(this.f14011g, eVar.f14011g) && b2.o.a(this.f14013i, eVar.f14013i) && b2.o.a(this.f14012h, eVar.f14012h)) {
                return true;
            }
        }
        return false;
    }

    public final e g(String str) {
        this.f14013i = str;
        return this;
    }

    public int hashCode() {
        int hashCode = this.f14010f.hashCode() * 31;
        String str = this.f14011g;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f14012h;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f14013i;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ActivityTransitionRequest [mTransitions=" + String.valueOf(this.f14010f) + ", mTag='" + this.f14011g + "', mClients=" + String.valueOf(this.f14012h) + ", mAttributionTag=" + this.f14013i + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        b2.p.k(parcel);
        int a10 = c2.c.a(parcel);
        c2.c.t(parcel, 1, this.f14010f, false);
        c2.c.q(parcel, 2, this.f14011g, false);
        c2.c.t(parcel, 3, this.f14012h, false);
        c2.c.q(parcel, 4, this.f14013i, false);
        c2.c.b(parcel, a10);
    }
}
