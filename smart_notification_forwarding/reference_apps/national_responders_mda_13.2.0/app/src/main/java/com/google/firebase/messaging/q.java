package com.google.firebase.messaging;

import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final String f7467a = b2.p.h("MESSAGE_DELIVERED", "evenType must be non-null");

    /* renamed from: b, reason: collision with root package name */
    private final Intent f7468b;

    /* loaded from: classes.dex */
    static class a implements l4.d<q> {
        @Override // l4.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, l4.e eVar) {
            Intent b10 = qVar.b();
            eVar.d("ttl", u.q(b10));
            eVar.g("event", qVar.a());
            eVar.g("instanceId", u.e());
            eVar.d("priority", u.n(b10));
            eVar.g("packageName", u.m());
            eVar.g("sdkPlatform", "ANDROID");
            eVar.g("messageType", u.k(b10));
            String g10 = u.g(b10);
            if (g10 != null) {
                eVar.g("messageId", g10);
            }
            String p10 = u.p(b10);
            if (p10 != null) {
                eVar.g("topic", p10);
            }
            String b11 = u.b(b10);
            if (b11 != null) {
                eVar.g("collapseKey", b11);
            }
            if (u.h(b10) != null) {
                eVar.g("analyticsLabel", u.h(b10));
            }
            if (u.d(b10) != null) {
                eVar.g("composerLabel", u.d(b10));
            }
            String o10 = u.o();
            if (o10 != null) {
                eVar.g("projectNumber", o10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final q f7469a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(q qVar) {
            this.f7469a = (q) b2.p.k(qVar);
        }

        q a() {
            return this.f7469a;
        }
    }

    /* loaded from: classes.dex */
    static final class c implements l4.d<b> {
        @Override // l4.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b bVar, l4.e eVar) {
            eVar.g("messaging_client_event", bVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str, Intent intent) {
        this.f7468b = (Intent) b2.p.l(intent, "intent must be non-null");
    }

    String a() {
        return this.f7467a;
    }

    Intent b() {
        return this.f7468b;
    }
}
