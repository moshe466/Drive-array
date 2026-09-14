package y1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;

/* loaded from: classes.dex */
interface c extends IInterface {

    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f15839a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(IBinder iBinder) {
            this.f15839a = iBinder;
        }

        @Override // y1.c
        public void G(Message message) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.f15839a.transact(1, obtain, null, 1);
            } finally {
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f15839a;
        }
    }

    void G(Message message);
}
