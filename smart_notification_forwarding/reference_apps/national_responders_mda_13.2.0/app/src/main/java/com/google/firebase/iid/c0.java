package com.google.firebase.iid;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import com.google.firebase.iid.f0;

/* loaded from: classes.dex */
public class c0 extends Binder {

    /* renamed from: a, reason: collision with root package name */
    private final a f7278a;

    /* loaded from: classes.dex */
    public interface a {
        z2.l<Void> a(Intent intent);
    }

    public c0(a aVar) {
        this.f7278a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final f0.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        this.f7278a.a(aVar.f7293a).b(h.a(), new z2.f(aVar) { // from class: com.google.firebase.iid.b0

            /* renamed from: a, reason: collision with root package name */
            private final f0.a f7275a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7275a = aVar;
            }

            @Override // z2.f
            public void a(z2.l lVar) {
                this.f7275a.b();
            }
        });
    }
}
