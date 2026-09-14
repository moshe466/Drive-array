package androidx.profileinstaller;

import F0.C0035g2;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import i0.e;
import java.io.File;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        File codeCacheDir;
        if (intent != null) {
            String action = intent.getAction();
            if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
                e.t(context, new Object(), new C0035g2(this, 15), true);
                return;
            }
            if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                    if ("WRITE_SKIP_FILE".equals(string)) {
                        C0035g2 c0035g2 = new C0035g2(this, 15);
                        try {
                            e.e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                            c0035g2.g(10, null);
                            return;
                        } catch (PackageManager.NameNotFoundException e4) {
                            c0035g2.g(7, e4);
                            return;
                        }
                    }
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                return;
            }
            if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
                Process.sendSignal(Process.myPid(), 10);
                setResultCode(12);
                return;
            }
            if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
                String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
                C0035g2 c0035g22 = new C0035g2(this, 15);
                if ("DROP_SHADER_CACHE".equals(string2)) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        codeCacheDir = context.createDeviceProtectedStorageContext().getCacheDir();
                    } else {
                        codeCacheDir = context.createDeviceProtectedStorageContext().getCodeCacheDir();
                    }
                    if (e.c(codeCacheDir)) {
                        c0035g22.g(14, null);
                        return;
                    } else {
                        c0035g22.g(15, null);
                        return;
                    }
                }
                c0035g22.g(16, null);
            }
        }
    }
}
