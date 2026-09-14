package com.google.firebase.crashlytics;

import com.google.firebase.installations.g;
import java.util.Arrays;
import java.util.List;
import r3.d;
import r3.e;
import r3.i;
import r3.q;
import x4.h;

/* loaded from: classes.dex */
public class CrashlyticsRegistrar implements i {
    /* JADX INFO: Access modifiers changed from: private */
    public c b(e eVar) {
        return c.b((o3.c) eVar.a(o3.c.class), (g) eVar.a(g.class), (s3.a) eVar.a(s3.a.class), (p3.a) eVar.a(p3.a.class));
    }

    @Override // r3.i
    public List<d<?>> getComponents() {
        return Arrays.asList(d.a(c.class).b(q.i(o3.c.class)).b(q.i(g.class)).b(q.g(p3.a.class)).b(q.g(s3.a.class)).f(b.b(this)).e().d(), h.a("fire-cls", "17.3.0"));
    }
}
