package y1;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* loaded from: classes.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Messenger f15878a;

    /* renamed from: b, reason: collision with root package name */
    private final e f15879b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f15878a = new Messenger(iBinder);
            this.f15879b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f15879b = new e(iBinder);
            this.f15878a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                "Invalid interface descriptor: ".concat(valueOf);
            }
            throw new RemoteException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) {
        Messenger messenger = this.f15878a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        e eVar = this.f15879b;
        if (eVar == null) {
            throw new IllegalStateException("Both messengers are null");
        }
        eVar.b(message);
    }
}
