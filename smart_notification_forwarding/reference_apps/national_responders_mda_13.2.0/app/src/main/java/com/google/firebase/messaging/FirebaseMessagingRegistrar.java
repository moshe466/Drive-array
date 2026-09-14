package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class FirebaseMessagingRegistrar implements r3.i {

    /* loaded from: classes.dex */
    private static class b<T> implements i1.f<T> {
        private b() {
        }

        @Override // i1.f
        public void a(i1.c<T> cVar) {
        }

        @Override // i1.f
        public void b(i1.c<T> cVar, i1.h hVar) {
            hVar.a(null);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements i1.g {
        @Override // i1.g
        public <T> i1.f<T> a(String str, Class<T> cls, i1.b bVar, i1.e<T, byte[]> eVar) {
            return new b();
        }
    }

    static i1.g determineFactory(i1.g gVar) {
        if (gVar == null) {
            return new c();
        }
        try {
            gVar.a("test", String.class, i1.b.b("json"), p.f7466a);
            return gVar;
        } catch (IllegalArgumentException unused) {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(r3.e eVar) {
        return new FirebaseMessaging((o3.c) eVar.a(o3.c.class), (FirebaseInstanceId) eVar.a(FirebaseInstanceId.class), eVar.c(x4.i.class), eVar.c(p4.f.class), (com.google.firebase.installations.g) eVar.a(com.google.firebase.installations.g.class), determineFactory((i1.g) eVar.a(i1.g.class)), (o4.d) eVar.a(o4.d.class));
    }

    @Override // r3.i
    @Keep
    public List<r3.d<?>> getComponents() {
        return Arrays.asList(r3.d.a(FirebaseMessaging.class).b(r3.q.i(o3.c.class)).b(r3.q.i(FirebaseInstanceId.class)).b(r3.q.h(x4.i.class)).b(r3.q.h(p4.f.class)).b(r3.q.g(i1.g.class)).b(r3.q.i(com.google.firebase.installations.g.class)).b(r3.q.i(o4.d.class)).f(o.f7465a).c().d(), x4.h.a("fire-fcm", "20.1.7_1p"));
    }
}
