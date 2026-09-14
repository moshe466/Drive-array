package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import i1.g;
import java.util.Collections;
import java.util.List;
import k1.r;
import r3.d;
import r3.e;
import r3.i;
import r3.q;

@Keep
/* loaded from: classes.dex */
public class TransportRegistrar implements i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ g lambda$getComponents$0(e eVar) {
        r.f((Context) eVar.a(Context.class));
        return r.c().g(com.google.android.datatransport.cct.a.f4685g);
    }

    @Override // r3.i
    public List<d<?>> getComponents() {
        return Collections.singletonList(d.a(g.class).b(q.i(Context.class)).f(a.b()).d());
    }
}
