package o5;

import android.content.Context;
import android.content.Intent;
import com.groboot.mdaemergency.models.NotificationData;
import com.groboot.mdaemergency.models.Request;
import com.groboot.mdaemergency.ptt.p;
import f6.a3;
import x5.m;

/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12498a;

        static {
            int[] iArr = new int[com.groboot.mdaemergency.enums.f.values().length];
            iArr[com.groboot.mdaemergency.enums.f.registerPtt.ordinal()] = 1;
            iArr[com.groboot.mdaemergency.enums.f.request.ordinal()] = 2;
            iArr[com.groboot.mdaemergency.enums.f.whatApp.ordinal()] = 3;
            f12498a = iArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e5.a<m> {
        b() {
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends e5.a<Request> {
        c() {
        }
    }

    public final void a(Context context, NotificationData notificationData) {
        y8.k.e(context, "context");
        y8.k.e(notificationData, "notificationData");
        com.groboot.mdaemergency.enums.f byId = com.groboot.mdaemergency.enums.f.getById(notificationData.messageData.Type);
        int i10 = byId == null ? -1 : a.f12498a[byId.ordinal()];
        if (i10 == 1) {
            p.c0().L0();
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            a3.a aVar = a3.L0;
            Intent intent = new Intent(aVar.b());
            intent.putExtra(aVar.a(), new com.google.gson.e().r(notificationData));
            context.sendBroadcast(intent);
            return;
        }
        Request request = (Request) new com.google.gson.e().j(notificationData.messageData.Payload, new c().e());
        if (y8.k.a(request.getRequestHeader().getModule(), g.f12499a.a()) && y8.k.a(request.getRequestHeader().getFunction(), d.f12496a.a())) {
            request.getRequestData();
            m mVar = (m) new com.google.gson.e().j(request.getRequestData(), new b().e());
            if (mVar == null) {
                return;
            }
            p.c0().M(mVar);
        }
    }
}
