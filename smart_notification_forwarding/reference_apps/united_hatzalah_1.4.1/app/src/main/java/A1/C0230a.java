package a1;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.lt.plugin.lt_plugin.LtPlugin;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import kotlin.jvm.internal.j;

/* renamed from: a1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0230a implements OnCompleteListener, OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2750a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f2751b;

    public /* synthetic */ C0230a(int i, MethodChannel.Result result) {
        this.f2750a = i;
        this.f2751b = result;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f2750a) {
            case 1:
                LtPlugin.lambda$onMethodCall$3(this.f2751b, task);
                return;
            case 2:
                LtPlugin.lambda$onMethodCall$4(this.f2751b, task);
                return;
            default:
                FlutterFirebaseCrashlyticsPlugin.lambda$onMethodCall$10(this.f2751b, task);
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception it) {
        j.e(it, "it");
        this.f2751b.error("TASK_FAILURE", it.getMessage(), null);
    }
}
