package u5;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.groboot.mdaemergency.locations.transition.TransitionRecognitionReceiver;
import java.util.ArrayList;
import s2.c;
import y8.k;
import z2.g;
import z2.h;
import z2.l;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f14386a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final String f14387b = "[Location][TransitionRecognition]";

    /* renamed from: c, reason: collision with root package name */
    public static Context f14388c;

    /* renamed from: d, reason: collision with root package name */
    public static PendingIntent f14389d;

    /* loaded from: classes.dex */
    public static final class a implements h<Void> {
        a() {
        }

        @Override // z2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r12) {
            String unused = d.f14387b;
        }
    }

    private d() {
    }

    private final void g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c.a().c(3).b(0).a());
        arrayList.add(new c.a().c(3).b(1).a());
        arrayList.add(new c.a().c(7).b(0).a());
        arrayList.add(new c.a().c(7).b(1).a());
        arrayList.add(new c.a().c(0).b(0).a());
        arrayList.add(new c.a().c(0).b(1).a());
        arrayList.add(new c.a().c(1).b(0).a());
        arrayList.add(new c.a().c(1).b(1).a());
        arrayList.add(new c.a().c(8).b(0).a());
        arrayList.add(new c.a().c(8).b(1).a());
        s2.e eVar = new s2.e(arrayList);
        s2.b a10 = s2.a.a(e());
        k.d(a10, "getClient(mContext)");
        PendingIntent broadcast = PendingIntent.getBroadcast(e(), 0, new Intent(e(), (Class<?>) TransitionRecognitionReceiver.class), Build.VERSION.SDK_INT >= 23 ? 67108864 : 0);
        k.d(broadcast, "getBroadcast(mContext, 0, intent, piFlags)");
        j(broadcast);
        l<Void> f10 = a10.f(eVar, f());
        k.d(f10, "activityRecognitionClien…(request, mPendingIntent)");
        f10.g(new a());
        f10.e(new g() { // from class: u5.b
            @Override // z2.g
            public final void d(Exception exc) {
                d.h(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Exception exc) {
        k.e(exc, "it");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Void r02) {
        f14386a.f().cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Exception exc) {
        k.e(exc, "e");
        k.j("Transitions could not be unregistered: ", exc);
    }

    public final Context e() {
        Context context = f14388c;
        if (context != null) {
            return context;
        }
        k.o("mContext");
        return null;
    }

    public final PendingIntent f() {
        PendingIntent pendingIntent = f14389d;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        k.o("mPendingIntent");
        return null;
    }

    public final void i(Context context) {
        k.e(context, "<set-?>");
        f14388c = context;
    }

    public final void j(PendingIntent pendingIntent) {
        k.e(pendingIntent, "<set-?>");
        f14389d = pendingIntent;
    }

    public void k(Context context) {
        k.e(context, "context");
        i(context);
        if (com.groboot.mdaemergency.a.q(context)) {
            g();
        }
    }

    public void l() {
        if (f14388c == null || f14389d == null) {
            return;
        }
        s2.a.a(e()).d(f()).g(new h() { // from class: u5.c
            @Override // z2.h
            public final void b(Object obj) {
                d.m((Void) obj);
            }
        }).e(new g() { // from class: u5.a
            @Override // z2.g
            public final void d(Exception exc) {
                d.n(exc);
            }
        });
    }
}
