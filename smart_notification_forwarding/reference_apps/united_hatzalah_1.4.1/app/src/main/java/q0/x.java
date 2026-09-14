package q0;

import F0.AbstractC0008a;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: b, reason: collision with root package name */
    public final View f6137b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6136a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f6138c = new ArrayList();

    public x(View view) {
        this.f6137b = view;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f6137b == xVar.f6137b && this.f6136a.equals(xVar.f6136a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6136a.hashCode() + (this.f6137b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder i = e0.a.i("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        i.append(this.f6137b);
        i.append("\n");
        String n4 = AbstractC0008a.n(i.toString(), "    values:");
        HashMap hashMap = this.f6136a;
        for (String str : hashMap.keySet()) {
            n4 = n4 + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return n4;
    }
}
