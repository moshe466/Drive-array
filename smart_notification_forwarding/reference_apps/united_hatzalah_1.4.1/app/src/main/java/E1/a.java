package E1;

import android.app.PendingIntent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f116a;

    /* renamed from: b, reason: collision with root package name */
    public final int f117b;

    /* renamed from: c, reason: collision with root package name */
    public final int f118c;

    /* renamed from: d, reason: collision with root package name */
    public final int f119d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f120e;

    /* renamed from: f, reason: collision with root package name */
    public final int f121f;

    /* renamed from: g, reason: collision with root package name */
    public final PendingIntent f122g;

    /* renamed from: h, reason: collision with root package name */
    public final PendingIntent f123h;
    public final HashMap i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f124j = false;

    public a(String str, int i, int i3, int i4, Integer num, int i5, long j2, long j3, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, HashMap hashMap) {
        this.f116a = str;
        this.f117b = i;
        this.f118c = i3;
        this.f119d = i4;
        this.f120e = num;
        this.f121f = i5;
        this.f122g = pendingIntent;
        this.f123h = pendingIntent2;
        this.i = hashMap;
    }

    public final Set a(m mVar) {
        int i = mVar.f152a;
        HashMap hashMap = this.i;
        if (i == 0) {
            Set set = (Set) hashMap.get("nonblocking.intent");
            if (set == null) {
                return new HashSet();
            }
            return set;
        }
        Set set2 = (Set) hashMap.get("blocking.intent");
        if (set2 == null) {
            return new HashSet();
        }
        return set2;
    }

    public final PendingIntent b(m mVar) {
        PendingIntent pendingIntent;
        int i = mVar.f152a;
        if (i == 0) {
            PendingIntent pendingIntent2 = this.f123h;
            if (pendingIntent2 == null) {
                return null;
            }
            return pendingIntent2;
        }
        if (i != 1 || (pendingIntent = this.f122g) == null) {
            return null;
        }
        return pendingIntent;
    }
}
