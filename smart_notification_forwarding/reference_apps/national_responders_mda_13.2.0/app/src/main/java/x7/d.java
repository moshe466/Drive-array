package x7;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private e f15514a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, AtomicInteger atomicInteger) {
        this.f15514a = new e(context, atomicInteger);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled() && (defaultAdapter.getProfileConnectionState(1) == 2 || defaultAdapter.getProfileConnectionState(2) == 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f15514a.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f15514a.h();
    }
}
