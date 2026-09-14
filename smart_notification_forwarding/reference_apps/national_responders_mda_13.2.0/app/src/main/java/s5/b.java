package s5;

import android.app.Service;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;

/* loaded from: classes.dex */
public class b extends Service {

    /* renamed from: h, reason: collision with root package name */
    public static String f14093h = "Enabled";

    /* renamed from: f, reason: collision with root package name */
    private LocationManager f14094f = null;

    /* renamed from: g, reason: collision with root package name */
    private a f14095g;

    /* loaded from: classes.dex */
    private class a implements LocationListener {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LocationManager locationManager = this.f14094f;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.f14095g);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        return 1;
    }
}
