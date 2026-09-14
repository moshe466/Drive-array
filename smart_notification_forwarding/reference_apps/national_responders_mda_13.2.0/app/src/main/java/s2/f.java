package s2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class f extends c2.a {
    public static final Parcelable.Creator<f> CREATOR = new x();

    /* renamed from: f, reason: collision with root package name */
    private final List f14014f;

    /* renamed from: g, reason: collision with root package name */
    private Bundle f14015g;

    public f(List<d> list) {
        this.f14015g = null;
        b2.p.l(list, "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i10 = 1; i10 < list.size(); i10++) {
                b2.p.a(list.get(i10).j() >= list.get(i10 + (-1)).j());
            }
        }
        this.f14014f = Collections.unmodifiableList(list);
    }

    public f(List list, Bundle bundle) {
        this(list);
        this.f14015g = bundle;
    }

    public static f g(Intent intent) {
        if (l(intent)) {
            return (f) c2.e.b(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT", CREATOR);
        }
        return null;
    }

    public static boolean l(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return this.f14014f.equals(((f) obj).f14014f);
    }

    public int hashCode() {
        return this.f14014f.hashCode();
    }

    public List<d> j() {
        return this.f14014f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        b2.p.k(parcel);
        int a10 = c2.c.a(parcel);
        c2.c.t(parcel, 1, j(), false);
        c2.c.e(parcel, 2, this.f14015g, false);
        c2.c.b(parcel, a10);
    }
}
