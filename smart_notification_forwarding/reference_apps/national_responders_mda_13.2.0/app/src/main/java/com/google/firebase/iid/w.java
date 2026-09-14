package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class w {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f7328a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Pair<String, String>, z2.l<q>> f7329b = new l.a();

    /* loaded from: classes.dex */
    interface a {
        z2.l<q> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Executor executor) {
        this.f7328a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized z2.l<q> a(String str, String str2, a aVar) {
        final Pair pair = new Pair(str, str2);
        z2.l<q> lVar = this.f7329b.get(pair);
        if (lVar != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 29);
                sb2.append("Joining ongoing request for: ");
                sb2.append(valueOf);
            }
            return lVar;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 24);
            sb3.append("Making new request for: ");
            sb3.append(valueOf2);
        }
        z2.l j10 = aVar.start().j(this.f7328a, new z2.c(this, pair) { // from class: com.google.firebase.iid.v

            /* renamed from: a, reason: collision with root package name */
            private final w f7326a;

            /* renamed from: b, reason: collision with root package name */
            private final Pair f7327b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7326a = this;
                this.f7327b = pair;
            }

            @Override // z2.c
            public Object a(z2.l lVar2) {
                this.f7326a.b(this.f7327b, lVar2);
                return lVar2;
            }
        });
        this.f7329b.put(pair, j10);
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ z2.l b(Pair pair, z2.l lVar) {
        synchronized (this) {
            this.f7329b.remove(pair);
        }
        return lVar;
    }
}
