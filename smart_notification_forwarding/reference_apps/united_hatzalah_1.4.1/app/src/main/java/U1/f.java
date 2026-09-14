package u1;

import F0.C0084t0;
import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final C0084t0 f6596a;

    /* renamed from: b, reason: collision with root package name */
    public final d f6597b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6598c;

    public f(Context context, d dVar) {
        C0084t0 c0084t0 = new C0084t0(context, 7);
        this.f6598c = new HashMap();
        this.f6596a = c0084t0;
        this.f6597b = dVar;
    }

    public final synchronized g a(String str) {
        if (this.f6598c.containsKey(str)) {
            return (g) this.f6598c.get(str);
        }
        CctBackendFactory i = this.f6596a.i(str);
        if (i == null) {
            return null;
        }
        d dVar = this.f6597b;
        g create = i.create(new C0736b(dVar.f6591a, dVar.f6592b, dVar.f6593c, str));
        this.f6598c.put(str, create);
        return create;
    }
}
