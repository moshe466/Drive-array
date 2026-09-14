package F0;

import android.view.View;
import com.google.crypto.tink.shaded.protobuf.AbstractC0329a;
import com.google.crypto.tink.shaded.protobuf.AbstractC0337i;
import java.util.Collections;
import java.util.Map;
import k0.C0490n;

/* renamed from: F0.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0083t {

    /* renamed from: a, reason: collision with root package name */
    public Object f662a;

    public AbstractC0083t(Class cls) {
        this.f662a = cls;
    }

    public static AbstractC0083t d(k0.t tVar, int i) {
        if (i != 0) {
            if (i == 1) {
                return new C0490n(tVar, 1);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new C0490n(tVar, 0);
    }

    public abstract void a(w.o oVar);

    public abstract InterfaceC0056m b();

    public abstract AbstractC0329a c(AbstractC0329a abstractC0329a);

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract int h(View view);

    public abstract int i(View view);

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public Map m() {
        return Collections.EMPTY_MAP;
    }

    public abstract AbstractC0329a n(AbstractC0337i abstractC0337i);

    public abstract void o(AbstractC0329a abstractC0329a);
}
