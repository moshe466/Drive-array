package g1;

import F0.C0084t0;
import android.app.ActivityManager;
import android.os.StatFs;

/* loaded from: classes.dex */
public final class j extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4697a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0084t0 f4698b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(C0084t0 c0084t0, int i) {
        super(0);
        this.f4697a = i;
        this.f4698b = c0084t0;
    }

    @Override // F2.a
    public final Object invoke() {
        switch (this.f4697a) {
            case 0:
                StatFs statFs = (StatFs) this.f4698b.f664b;
                kotlin.jvm.internal.j.b(statFs);
                return Long.valueOf(statFs.getTotalBytes());
            default:
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ActivityManager activityManager = (ActivityManager) this.f4698b.f663a;
                kotlin.jvm.internal.j.b(activityManager);
                activityManager.getMemoryInfo(memoryInfo);
                return Long.valueOf(memoryInfo.totalMem);
        }
    }
}
