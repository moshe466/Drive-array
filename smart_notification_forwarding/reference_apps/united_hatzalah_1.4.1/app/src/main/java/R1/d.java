package R1;

import F0.AbstractC0083t;
import W1.X;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1984a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1985b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f1986c;

    public d(Class cls, L1.g... gVarArr) {
        this.f1984a = cls;
        HashMap hashMap = new HashMap();
        for (L1.g gVar : gVarArr) {
            Class cls2 = gVar.f1289a;
            if (!hashMap.containsKey(cls2)) {
                hashMap.put(cls2, gVar);
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls2.getCanonicalName());
            }
        }
        if (gVarArr.length > 0) {
            this.f1986c = gVarArr[0].f1289a;
        } else {
            this.f1986c = Void.class;
        }
        this.f1985b = Collections.unmodifiableMap(hashMap);
    }

    public int a() {
        return 1;
    }

    public abstract String b();

    public final Object c(AbstractC0329a abstractC0329a, Class cls) {
        L1.g gVar = (L1.g) this.f1985b.get(cls);
        if (gVar != null) {
            return gVar.a(abstractC0329a);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract AbstractC0083t d();

    public abstract X e();

    public abstract AbstractC0329a f(AbstractC0337i abstractC0337i);

    public abstract void g(AbstractC0329a abstractC0329a);
}
