package u0;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* loaded from: classes.dex */
public abstract class m {
    public static ServiceInfo a(PackageManager packageManager, ComponentName componentName, PackageManager.ComponentInfoFlags componentInfoFlags) {
        ServiceInfo serviceInfo;
        serviceInfo = packageManager.getServiceInfo(componentName, componentInfoFlags);
        return serviceInfo;
    }

    public static PackageManager.ComponentInfoFlags b(long j2) {
        PackageManager.ComponentInfoFlags of;
        of = PackageManager.ComponentInfoFlags.of(j2);
        return of;
    }
}
