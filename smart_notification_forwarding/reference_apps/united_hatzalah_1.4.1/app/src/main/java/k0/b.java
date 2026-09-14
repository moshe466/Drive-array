package K0;

import F0.RunnableC0064o;
import V.m;
import V.n;
import V.r;
import V.s;
import a.AbstractC0228a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0267e;
import androidx.fragment.app.C0279n;
import androidx.fragment.app.E0;
import androidx.fragment.app.G;
import androidx.fragment.app.s0;
import androidx.fragment.app.x0;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.j;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.external.ExternalParser;
import p3.h;
import s2.C0680e;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1065a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1066b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1067c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1068d;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i) {
        this.f1065a = i;
        this.f1066b = obj;
        this.f1067c = obj2;
        this.f1068d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object g3;
        int i;
        Bitmap bitmap;
        switch (this.f1065a) {
            case 0:
                d dVar = (d) this.f1066b;
                String str = (String) this.f1067c;
                MethodChannel.Result result = (MethodChannel.Result) this.f1068d;
                Context context = dVar.f1070a;
                if (context != null) {
                    int i3 = 2;
                    try {
                        Drawable applicationIcon = context.getPackageManager().getApplicationIcon(str);
                        j.d(applicationIcon, "getApplicationIcon(...)");
                        if (applicationIcon instanceof BitmapDrawable) {
                            bitmap = ((BitmapDrawable) applicationIcon).getBitmap();
                            j.d(bitmap, "getBitmap(...)");
                        } else {
                            int i4 = 1;
                            if (applicationIcon.getIntrinsicWidth() > 0) {
                                i = applicationIcon.getIntrinsicWidth();
                            } else {
                                i = 1;
                            }
                            if (applicationIcon.getIntrinsicHeight() > 0) {
                                i4 = applicationIcon.getIntrinsicHeight();
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(i, i4, Bitmap.Config.ARGB_8888);
                            j.d(createBitmap, "createBitmap(...)");
                            Canvas canvas = new Canvas(createBitmap);
                            applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            applicationIcon.draw(canvas);
                            bitmap = createBitmap;
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 10, byteArrayOutputStream);
                        g3 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                        j.d(g3, "encodeToString(...)");
                    } catch (Throwable th) {
                        g3 = AbstractC0228a.g(th);
                    }
                    if (g3 instanceof C0680e) {
                        g3 = null;
                    }
                    dVar.f1075f.post(new RunnableC0064o(i3, result, (String) g3));
                    return;
                }
                return;
            case 1:
                n nVar = (n) this.f1066b;
                h hVar = (h) this.f1067c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f1068d;
                try {
                    s j2 = m3.b.j(nVar.f2408a);
                    if (j2 != null) {
                        r rVar = (r) j2.f2428a;
                        synchronized (rVar.f2422d) {
                            rVar.f2424f = threadPoolExecutor;
                        }
                        j2.f2428a.a(new m(hVar, threadPoolExecutor));
                        return;
                    }
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                } catch (Throwable th2) {
                    hVar.x(th2);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 2:
                ViewGroup container = (ViewGroup) this.f1066b;
                View view = (View) this.f1067c;
                C0267e this$0 = (C0267e) this.f1068d;
                j.e(container, "$container");
                j.e(this$0, "this$0");
                container.endViewTransition(view);
                this$0.f3361c.f3425a.c(this$0);
                return;
            case 3:
                E0 e02 = (E0) this.f1066b;
                E0 e03 = (E0) this.f1067c;
                C0279n c0279n = (C0279n) this.f1068d;
                G inFragment = e02.f3291c;
                G outFragment = e03.f3291c;
                boolean z3 = c0279n.f3465o;
                x0 x0Var = s0.f3512a;
                j.e(inFragment, "inFragment");
                j.e(outFragment, "outFragment");
                if (z3) {
                    outFragment.getEnterTransitionCallback();
                    return;
                } else {
                    inFragment.getEnterTransitionCallback();
                    return;
                }
            case 4:
                ((CrashlyticsCore) this.f1066b).lambda$logException$1((Throwable) this.f1067c, (Map) this.f1068d);
                return;
            case 5:
                ConfigGetParameterHandler.a((BiConsumer) this.f1066b, (String) this.f1067c, (ConfigContainer) this.f1068d);
                return;
            case 6:
                ((FlutterFirebaseCorePlugin) this.f1066b).lambda$firebaseAppToMap$0((FirebaseApp) this.f1067c, (TaskCompletionSource) this.f1068d);
                return;
            case 7:
                ((FlutterFirebaseCrashlyticsPlugin) this.f1066b).lambda$getPluginConstantsForFirebaseApp$11((TaskCompletionSource) this.f1067c, (FirebaseApp) this.f1068d);
                return;
            default:
                ((ExternalParser) this.f1066b).lambda$extractMetadata$2((InputStream) this.f1067c, (Metadata) this.f1068d);
                return;
        }
    }
}
