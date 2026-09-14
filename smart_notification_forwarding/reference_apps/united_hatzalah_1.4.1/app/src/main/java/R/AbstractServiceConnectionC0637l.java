package r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import b.AbstractBinderC0318c;
import b.InterfaceC0319d;

/* renamed from: r.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractServiceConnectionC0637l implements ServiceConnection {
    private Context mApplicationContext;

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, AbstractC0633h abstractC0633h);

    /* JADX WARN: Type inference failed for: r1v3, types: [b.b, java.lang.Object] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC0319d interfaceC0319d;
        if (this.mApplicationContext != null) {
            int i = AbstractBinderC0318c.f3796a;
            if (iBinder == null) {
                interfaceC0319d = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(InterfaceC0319d.f3797h);
                if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC0319d)) {
                    interfaceC0319d = (InterfaceC0319d) queryLocalInterface;
                } else {
                    ?? obj = new Object();
                    obj.f3795a = iBinder;
                    interfaceC0319d = obj;
                }
            }
            onCustomTabsServiceConnected(componentName, new AbstractC0633h(interfaceC0319d, componentName));
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}
