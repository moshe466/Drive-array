package j5;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/* loaded from: classes.dex */
public class a extends DeviceAdminReceiver {
    void a(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public CharSequence onDisableRequested(Context context, Intent intent) {
        return "onDisableRequested";
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onDisabled(Context context, Intent intent) {
        a(context, "DAReceiver: onDisabled");
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onEnabled(Context context, Intent intent) {
    }
}
