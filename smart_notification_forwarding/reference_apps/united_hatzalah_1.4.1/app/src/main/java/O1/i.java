package o1;

import io.flutter.plugin.common.EventChannel;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f5930a;

    public i(j jVar) {
        this.f5930a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f5930a;
        if (jVar.f5939l) {
            EventChannel.EventSink eventSink = jVar.f5937j;
            if (eventSink != null) {
                eventSink.success(jVar.f5938k);
            }
            jVar.f5939l = false;
        }
        jVar.f5936f.postDelayed(this, 1000L);
    }
}
