package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* loaded from: classes.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private static final a f4713f = new a();

    private a() {
    }

    public static Runnable a() {
        return f4713f;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}
