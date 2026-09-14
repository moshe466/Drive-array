package p5;

import com.google.firebase.messaging.FirebaseMessaging;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import z2.l;

/* loaded from: classes.dex */
public class b {
    public b() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(l lVar) {
        if (!lVar.p()) {
            lVar.k();
        } else {
            d.r(MdaEmergencyApplication.b(), (String) lVar.l());
        }
    }

    public void b() {
        FirebaseMessaging.d().e().c(new z2.f() { // from class: p5.a
            @Override // z2.f
            public final void a(l lVar) {
                b.c(lVar);
            }
        });
    }
}
