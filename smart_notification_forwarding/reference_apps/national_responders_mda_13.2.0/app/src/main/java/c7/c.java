package c7;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private BluetoothSocket f4500a;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BluetoothDevice remoteDevice = c.this.f4500a.getRemoteDevice();
                c.this.close();
                c.this.f(remoteDevice);
            } catch (IOException e10) {
                System.out.println("Exception Thrown during runnable: " + e10.getMessage());
                e10.printStackTrace();
            }
        }
    }

    public c(BluetoothSocket bluetoothSocket) {
        this.f4500a = bluetoothSocket;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(BluetoothDevice bluetoothDevice) {
        try {
            bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // c7.e
    public OutputStream a() {
        return this.f4500a.getOutputStream();
    }

    @Override // c7.e
    public InputStream b() {
        return this.f4500a.getInputStream();
    }

    @Override // c7.e
    public void close() {
        this.f4500a.close();
    }

    public void e() {
        a aVar = new a();
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(aVar, 35000L);
        try {
            this.f4500a.connect();
        } finally {
            handler.removeCallbacks(aVar);
        }
    }
}
