package com.google.firebase.installations;

import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;
import r3.q;

@Keep
/* loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements r3.i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ g lambda$getComponents$0(r3.e eVar) {
        return new f((o3.c) eVar.a(o3.c.class), eVar.c(x4.i.class), eVar.c(p4.f.class));
    }

    @Override // r3.i
    public List<r3.d<?>> getComponents() {
        return Arrays.asList(r3.d.a(g.class).b(q.i(o3.c.class)).b(q.h(p4.f.class)).b(q.h(x4.i.class)).f(i.b()).d(), x4.h.a("fire-installations", "16.3.5"));
    }
}
