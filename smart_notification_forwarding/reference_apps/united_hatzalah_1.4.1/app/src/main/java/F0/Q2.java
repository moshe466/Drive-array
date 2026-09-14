package F0;

import a.AbstractC0228a;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.widget.Toast;
import androidx.fragment.app.C0278m;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0303m;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.remoteconfig.internal.Code;
import com.lt.plugin.lt_plugin.services.ActiveDispatchOverlayService;
import com.lt.plugin.lt_plugin.utils.FirebaseHelper;
import com.uh.sf.TransparencyView;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentLinkedQueue;
import l2.C0519b;
import o1.RunnableC0598a;
import org.apache.tika.parser.external.ExternalParser;
import q2.C0625c;
import s2.C0679d;

/* loaded from: classes.dex */
public final /* synthetic */ class Q2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f369b;

    public /* synthetic */ Q2(Object obj, int i) {
        this.f368a = i;
        this.f369b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [int] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v20 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        w.c cVar;
        Application application;
        C0679d c0679d = null;
        ?? r5 = 7;
        char c4 = 7;
        int i = 8;
        boolean z3 = true;
        switch (this.f368a) {
            case 0:
                R2 r22 = (R2) this.f369b;
                byte[] bArr = {1, 115, 70, -71, -45, 48};
                R2.e(bArr, new byte[]{25, ((((~R2.class.getName().length()) | (-677558710)) & (-2071724021)) + ((R2.class.getName().length() & 33554469) | 34177060)) ^ (-2037546998), -99, 1303423341 ^ ((((~R2.class.getName().length()) | 708359140) & 1167098113) + ((R2.class.getName().length() & 1166018561) | 136325120)), -9, 0, 89, -28});
                kotlin.jvm.internal.j.e(r22, new String(bArr, StandardCharsets.UTF_8).intern());
                while (true) {
                    char c5 = 40251;
                    while (c5 == 40251) {
                        c0679d = (C0679d) ((ConcurrentLinkedQueue) r22.f376e).poll();
                        if (c0679d != null) {
                            c5 = 44002;
                        } else {
                            c5 = 54880;
                        }
                    }
                    if (c5 != 44002) {
                        if (c5 == 54880) {
                            return;
                        }
                    } else {
                        r22.d((k3) c0679d.f6332a, (String) c0679d.f6333b);
                    }
                }
            case 1:
                V.r rVar = (V.r) this.f369b;
                synchronized (rVar.f2422d) {
                    try {
                        if (rVar.f2426h != null) {
                            try {
                                G.i c6 = rVar.c();
                                int i3 = c6.f796f;
                                if (i3 == 2) {
                                    synchronized (rVar.f2422d) {
                                    }
                                }
                                if (i3 == 0) {
                                    try {
                                        int i4 = F.h.f164a;
                                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                        A.n nVar = rVar.f2421c;
                                        Context context = rVar.f2419a;
                                        nVar.getClass();
                                        G.i[] iVarArr = {c6};
                                        E1.b bVar = A.g.f7a;
                                        Trace.beginSection(AbstractC0228a.D("TypefaceCompat.createFromFontInfo"));
                                        try {
                                            Typeface f4 = A.g.f7a.f(context, iVarArr, 0);
                                            Trace.endSection();
                                            MappedByteBuffer E3 = T.b.E(rVar.f2419a, c6.f791a);
                                            if (E3 != null && f4 != null) {
                                                try {
                                                    Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                                    K1.m mVar = new K1.m(f4, E1.b.w(E3));
                                                    Trace.endSection();
                                                    synchronized (rVar.f2422d) {
                                                        try {
                                                            p3.h hVar = rVar.f2426h;
                                                            if (hVar != null) {
                                                                hVar.y(mVar);
                                                            }
                                                        } finally {
                                                        }
                                                    }
                                                    rVar.b();
                                                    return;
                                                } finally {
                                                    int i5 = F.h.f164a;
                                                }
                                            }
                                            throw new RuntimeException("Unable to open file.");
                                        } finally {
                                            Trace.endSection();
                                        }
                                    } finally {
                                    }
                                }
                                throw new RuntimeException("fetchFonts result is not OK. (" + i3 + ")");
                            } catch (Throwable th) {
                                synchronized (rVar.f2422d) {
                                    try {
                                        p3.h hVar2 = rVar.f2426h;
                                        if (hVar2 != null) {
                                            hVar2.x(th);
                                        }
                                        rVar.b();
                                        return;
                                    } finally {
                                    }
                                }
                            }
                        }
                        return;
                    } finally {
                    }
                }
            case 2:
                androidx.lifecycle.G g3 = (androidx.lifecycle.G) this.f369b;
                C0311v c0311v = g3.f3555f;
                if (g3.f3551b == 0) {
                    g3.f3552c = true;
                    c0311v.e(EnumC0303m.ON_PAUSE);
                }
                if (g3.f3550a == 0 && g3.f3552c) {
                    c0311v.e(EnumC0303m.ON_STOP);
                    g3.f3553d = true;
                    return;
                }
                return;
            case 3:
                c.j jVar = (c.j) this.f369b;
                Runnable runnable = jVar.f3824b;
                if (runnable != null) {
                    runnable.run();
                    jVar.f3824b = null;
                    return;
                }
                return;
            case 4:
                c.n.a((c.n) this.f369b);
                return;
            case 5:
                FirebaseInstallations.d((FirebaseInstallations) this.f369b);
                return;
            case 6:
                ((ActiveDispatchOverlayService) this.f369b).restoreBubbleIfNeeded();
                return;
            case 7:
                FirebaseHelper.j((FirebaseHelper) this.f369b);
                return;
            case 8:
                ((MethodChannel.Result) this.f369b).notImplemented();
                return;
            case 9:
                ((i2.i) this.f369b).f5005a.notImplemented();
                return;
            case 10:
                PlatformViewsController.b((PlatformViewsController) this.f369b);
                return;
            case 11:
                TransparencyView transparencyView = (TransparencyView) this.f369b;
                int i6 = TransparencyView.f4407b;
                try {
                    Thread.sleep(60000L);
                    transparencyView.finishAndRemoveTask();
                    return;
                } catch (Exception unused) {
                    return;
                }
            case Code.UNIMPLEMENTED /* 12 */:
                C0519b c0519b = (C0519b) this.f369b;
                EventChannel.EventSink eventSink = c0519b.f5486b;
                ConnectivityManager connectivityManager = (ConnectivityManager) c0519b.f5485a.f218b;
                eventSink.success(G1.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())));
                return;
            case 13:
                ((C0278m) this.f369b).invoke();
                return;
            case 14:
                o1.j jVar2 = (o1.j) this.f369b;
                boolean z4 = jVar2.c().getBoolean("is_screenshot_on", false);
                boolean z5 = jVar2.c().getBoolean("is_image_overlay_mode_enabled", false);
                boolean z6 = jVar2.c().getBoolean("is_blur_overlay_mode_enabled", false);
                boolean z7 = jVar2.c().getBoolean("is_color_overlay_mode_enabled", false);
                jVar2.f5940m = z5;
                jVar2.f5941n = z6;
                jVar2.f5942o = z7;
                jVar2.f5945s = jVar2.c().getFloat("blur_radius", 30.0f);
                jVar2.f5946t = jVar2.c().getInt("color_value", -16777216);
                Activity activity = jVar2.f5933c;
                if (activity != null) {
                    activity.runOnUiThread(new RunnableC0598a(jVar2, z4, 3));
                    return;
                }
                return;
            case 15:
                ExternalParser.a((InputStream) this.f369b);
                return;
            case 16:
                Toast toast = ((C0625c) this.f369b).f6157b;
                if (toast != null) {
                    toast.show();
                    return;
                }
                return;
            case 17:
                Activity activity2 = (Activity) this.f369b;
                if (!activity2.isFinishing()) {
                    Handler handler = w.d.f6634g;
                    Method method = w.d.f6633f;
                    ?? r4 = Build.VERSION.SDK_INT;
                    if (r4 >= 28) {
                        activity2.recreate();
                        return;
                    }
                    if (((r4 != 26 && r4 != 27) || method != null) && (w.d.f6632e != null || w.d.f6631d != null)) {
                        try {
                            Object obj2 = w.d.f6630c.get(activity2);
                            if (obj2 != null && (obj = w.d.f6629b.get(activity2)) != null) {
                                Application application2 = activity2.getApplication();
                                w.c cVar2 = new w.c(activity2);
                                application2.registerActivityLifecycleCallbacks(cVar2);
                                handler.post(new RunnableC0091v(c4, cVar2, obj2));
                                if (r4 != 26 && r4 != 27) {
                                    z3 = false;
                                }
                                try {
                                    if (z3) {
                                        try {
                                            Boolean bool = Boolean.FALSE;
                                            r4 = application2;
                                            r5 = cVar2;
                                            method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            application = application2;
                                            cVar = cVar2;
                                            handler.post(new RunnableC0091v(i, application, cVar));
                                            throw th;
                                        }
                                    } else {
                                        r4 = application2;
                                        r5 = cVar2;
                                        activity2.recreate();
                                    }
                                    handler.post(new RunnableC0091v(i, r4, r5));
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    application = r4;
                                    cVar = r5;
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    activity2.recreate();
                    return;
                }
                return;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                ((T0.a) this.f369b).getClass();
                return;
            default:
                z1.i iVar = (z1.i) this.f369b;
                ((A1.l) iVar.f6875d).f(new J0.d(iVar, 29));
                return;
        }
    }
}
