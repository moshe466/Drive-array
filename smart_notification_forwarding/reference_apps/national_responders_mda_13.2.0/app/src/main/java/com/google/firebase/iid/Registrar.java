package com.google.firebase.iid;

import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public final class Registrar implements r3.i {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements q4.a {
        public a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(r3.e eVar) {
        return new FirebaseInstanceId((o3.c) eVar.a(o3.c.class), eVar.c(x4.i.class), eVar.c(p4.f.class), (com.google.firebase.installations.g) eVar.a(com.google.firebase.installations.g.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ q4.a lambda$getComponents$1$Registrar(r3.e eVar) {
        return new a((FirebaseInstanceId) eVar.a(FirebaseInstanceId.class));
    }

    @Override // r3.i
    @Keep
    public List<r3.d<?>> getComponents() {
        return Arrays.asList(r3.d.a(FirebaseInstanceId.class).b(r3.q.i(o3.c.class)).b(r3.q.h(x4.i.class)).b(r3.q.h(p4.f.class)).b(r3.q.i(com.google.firebase.installations.g.class)).f(t.f7324a).c().d(), r3.d.a(q4.a.class).b(r3.q.i(FirebaseInstanceId.class)).f(u.f7325a).d(), x4.h.a("fire-iid", "21.0.1"));
    }
}
