package s0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public View f13988b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f13987a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<m> f13989c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f13988b == sVar.f13988b && this.f13987a.equals(sVar.f13987a);
    }

    public int hashCode() {
        return (this.f13988b.hashCode() * 31) + this.f13987a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f13988b + "\n") + "    values:";
        for (String str2 : this.f13987a.keySet()) {
            str = str + "    " + str2 + ": " + this.f13987a.get(str2) + "\n";
        }
        return str;
    }
}
