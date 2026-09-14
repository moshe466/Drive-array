package U;

import F0.AbstractC0008a;
import F2.l;
import java.util.Map;
import kotlin.jvm.internal.k;
import t2.AbstractC0705g;

/* loaded from: classes.dex */
public final class a extends k implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2307a = new k(1);

    @Override // F2.l
    public final Object invoke(Object obj) {
        String valueOf;
        Map.Entry entry = (Map.Entry) obj;
        kotlin.jvm.internal.j.e(entry, "entry");
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            valueOf = AbstractC0705g.L((byte[]) value, ", ", null, 56);
        } else {
            valueOf = String.valueOf(entry.getValue());
        }
        return AbstractC0008a.v(new StringBuilder("  "), ((f) entry.getKey()).f2315a, " = ", valueOf);
    }
}
