package t0;

import android.content.Context;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import u0.AbstractC0725c;
import u0.C0724b;
import u0.F;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final u0.s f6372a = new Object();

    public static boolean a(String str) {
        C0724b c0724b = F.f6525a;
        Set<u0.n> unmodifiableSet = Collections.unmodifiableSet(AbstractC0725c.f6559c);
        HashSet hashSet = new HashSet();
        for (u0.n nVar : unmodifiableSet) {
            if (((AbstractC0725c) nVar).f6560a.equals(str)) {
                hashSet.add(nVar);
            }
        }
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AbstractC0725c abstractC0725c = (AbstractC0725c) ((u0.n) it.next());
                if (abstractC0725c.a() || abstractC0725c.b()) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException(e0.a.d("Unknown feature ", str));
    }

    public static boolean b(Context context, String str) {
        C0724b c0724b = F.f6525a;
        Set<u0.x> unmodifiableSet = Collections.unmodifiableSet(u0.x.f6577d);
        HashSet hashSet = new HashSet();
        for (u0.x xVar : unmodifiableSet) {
            if (xVar.f6578a.equals(str)) {
                hashSet.add(xVar);
            }
        }
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((u0.x) it.next()).a(context)) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException(e0.a.d("Unknown feature ", str));
    }
}
