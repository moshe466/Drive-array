package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import org.apache.tika.parser.AbstractExternalProcessParser;
import org.apache.tika.utils.ProcessUtils;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4238a;

    public /* synthetic */ b(int i) {
        this.f4238a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4238a) {
            case 0:
                CrashlyticsWorker.c();
                return;
            case 1:
                FlutterFirebaseCrashlyticsPlugin.d();
                return;
            case 2:
                AbstractExternalProcessParser.a();
                return;
            case 3:
                ProcessUtils.a();
                return;
            default:
                int i = AlarmManagerSchedulerBroadcastReceiver.f3885a;
                return;
        }
    }
}
