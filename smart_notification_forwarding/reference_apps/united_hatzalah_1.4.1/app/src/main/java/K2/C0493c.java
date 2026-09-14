package k2;

import com.google.android.play.core.install.zza;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

/* renamed from: k2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0493c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5289a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0496f f5290b;

    public /* synthetic */ C0493c(C0496f c0496f, int i) {
        this.f5289a = i;
        this.f5290b = c0496f;
    }

    public final void a(zza zzaVar) {
        switch (this.f5289a) {
            case 0:
                int i = zzaVar.f3889a;
                EventChannel.EventSink eventSink = this.f5290b.f5296d;
                if (eventSink != null) {
                    eventSink.success(Integer.valueOf(i));
                    return;
                }
                return;
            default:
                int i3 = zzaVar.f3889a;
                C0496f c0496f = this.f5290b;
                EventChannel.EventSink eventSink2 = c0496f.f5296d;
                if (eventSink2 != null) {
                    eventSink2.success(Integer.valueOf(i3));
                }
                if (i3 == 11) {
                    MethodChannel.Result result = c0496f.f5298f;
                    if (result != null) {
                        result.success(null);
                    }
                    c0496f.f5298f = null;
                    return;
                }
                int i4 = zzaVar.f3892d;
                if (i4 != 0) {
                    MethodChannel.Result result2 = c0496f.f5298f;
                    if (result2 != null) {
                        result2.error("Error during installation", String.valueOf(i4), null);
                    }
                    c0496f.f5298f = null;
                    return;
                }
                return;
        }
    }
}
