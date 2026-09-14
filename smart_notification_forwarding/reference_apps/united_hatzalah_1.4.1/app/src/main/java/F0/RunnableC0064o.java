package F0;

import J.C0125m;
import android.app.job.JobParameters;
import android.content.Context;
import android.graphics.Typeface;
import android.location.Location;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.database.android.AndroidAppCheckTokenProvider;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import com.google.firebase.remoteconfig.internal.Code;
import com.lt.plugin.lt_plugin.LtPlugin;
import com.lt.plugin.lt_plugin.utils.FirebaseHelper;
import f2.C0421b;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import l2.C0519b;
import org.apache.tika.embedder.ExternalEmbedder;
import org.apache.tika.parser.external.ExternalParser;
import org.apache.tika.pipes.async.AsyncProcessor;
import org.apache.tika.pipes.pipesiterator.TotalCounter;

/* renamed from: F0.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0064o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f595a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f596b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f597c;

    public /* synthetic */ RunnableC0064o(int i, Object obj, Object obj2) {
        this.f595a = i;
        this.f596b = obj;
        this.f597c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        int i = this.f595a;
        Object obj = this.f597c;
        Object obj2 = this.f596b;
        switch (i) {
            case 0:
                r.c((Context) obj2, (r) obj);
                return;
            case 1:
                C0077r1.b((String) obj2, (C0077r1) obj);
                return;
            case 2:
                ((MethodChannel.Result) obj2).success((String) obj);
                return;
            case 3:
                androidx.fragment.app.L l3 = (androidx.fragment.app.L) obj2;
                l3.getLifecycle().a(new C0125m(1, (c.x) obj, l3));
                return;
            case 4:
                ((UserMetadata) obj2).lambda$updateRolloutsState$1((List) obj);
                return;
            case 5:
                AndroidAppCheckTokenProvider.f((TokenProvider.TokenChangeListener) obj2, (AppCheckTokenResult) obj);
                return;
            case 6:
                AndroidAuthTokenProvider.c((TokenProvider.TokenChangeListener) obj2, (InternalTokenResult) obj);
                return;
            case 7:
                LtPlugin.e((Location) obj2, (MethodChannel.Result) obj);
                return;
            case 8:
                FirebaseHelper.h((FirebaseHelper) obj2, (FirebaseUser) obj);
                return;
            case 9:
                ((C0421b) obj2).f4604a.success(obj);
                return;
            case 10:
                h.E e4 = (h.E) obj2;
                Runnable runnable = (Runnable) obj;
                e4.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    e4.a();
                }
            case 11:
                ExternalEmbedder.a((InputStream) obj2, (OutputStream) obj);
                return;
            case Code.UNIMPLEMENTED /* 12 */:
                ((i2.i) obj2).f5005a.success(obj);
                return;
            case 13:
                FlutterFirebaseCorePlugin.m((String) obj2, (TaskCompletionSource) obj);
                return;
            case 14:
                FlutterFirebasePluginRegistry.b((FirebaseApp) obj2, (TaskCompletionSource) obj);
                return;
            case 15:
                ((C0519b) obj2).f5486b.success((ArrayList) obj);
                return;
            case 16:
                View view = (View) obj2;
                o1.j jVar = (o1.j) obj;
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
                jVar.f5944r = null;
                return;
            case 17:
                ImageView imageView = (ImageView) obj2;
                o1.j jVar2 = (o1.j) obj;
                ViewParent parent2 = imageView.getParent();
                if (parent2 instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) parent2;
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 != null) {
                    viewGroup2.removeView(imageView);
                }
                jVar2.p = null;
                return;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                ExternalParser.b((Process) obj2, (InputStream) obj);
                return;
            case 19:
                AsyncProcessor.a((AsyncProcessor) obj2, (TotalCounter) obj);
                return;
            case 20:
                ((T0.a) obj2).b((Typeface) obj);
                return;
            default:
                int i3 = JobInfoSchedulerService.f3886a;
                ((JobInfoSchedulerService) obj2).jobFinished((JobParameters) obj, false);
                return;
        }
    }
}
