package U1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f2331b = new a(Collections.unmodifiableMap(new HashMap()));

    /* renamed from: a, reason: collision with root package name */
    public final Map f2332a;

    public a(Map map) {
        this.f2332a = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f2332a.equals(((a) obj).f2332a);
    }

    public final int hashCode() {
        return this.f2332a.hashCode();
    }

    public final String toString() {
        return this.f2332a.toString();
    }
}
