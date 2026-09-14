package U0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f2322a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2323b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2324c;

    /* renamed from: d, reason: collision with root package name */
    public final List f2325d;

    public b(ArrayList arrayList, int i, int i3) {
        String str;
        this.f2322a = i;
        this.f2323b = i3;
        if (!arrayList.isEmpty()) {
            a aVar = (a) arrayList.get(0);
            if ("Name".equalsIgnoreCase(aVar.f2320a)) {
                str = aVar.f2321b;
                this.f2324c = str;
                this.f2325d = Collections.unmodifiableList(new ArrayList(arrayList));
            }
        }
        str = null;
        this.f2324c = str;
        this.f2325d = Collections.unmodifiableList(new ArrayList(arrayList));
    }

    public final String a(String str) {
        for (a aVar : this.f2325d) {
            if (aVar.f2320a.equalsIgnoreCase(str)) {
                return aVar.f2321b;
            }
        }
        return null;
    }
}
