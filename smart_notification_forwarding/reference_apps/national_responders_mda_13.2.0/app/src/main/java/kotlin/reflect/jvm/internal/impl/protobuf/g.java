package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final g f11409b = new g(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map<a, i.f<?, ?>> f11410a;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f11411a;

        /* renamed from: b, reason: collision with root package name */
        private final int f11412b;

        a(Object obj, int i10) {
            this.f11411a = obj;
            this.f11412b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11411a == aVar.f11411a && this.f11412b == aVar.f11412b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f11411a) * 65535) + this.f11412b;
        }
    }

    g() {
        this.f11410a = new HashMap();
    }

    private g(boolean z10) {
        this.f11410a = Collections.emptyMap();
    }

    public static g c() {
        return f11409b;
    }

    public static g d() {
        return new g();
    }

    public final void a(i.f<?, ?> fVar) {
        this.f11410a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public <ContainingType extends q> i.f<ContainingType, ?> b(ContainingType containingtype, int i10) {
        return (i.f) this.f11410a.get(new a(containingtype, i10));
    }
}
