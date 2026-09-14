package z1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import b2.p;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    boolean f16063a = false;

    /* renamed from: b, reason: collision with root package name */
    private final BlockingQueue f16064b = new LinkedBlockingQueue();

    public IBinder a(long j10, TimeUnit timeUnit) {
        p.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f16063a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f16063a = true;
        IBinder iBinder = (IBinder) this.f16064b.poll(j10, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f16064b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
