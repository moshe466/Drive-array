package y1;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import y1.c;

/* loaded from: classes.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new g();

    /* renamed from: f, reason: collision with root package name */
    private Messenger f15852f;

    /* renamed from: g, reason: collision with root package name */
    private c f15853g;

    /* loaded from: classes.dex */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z10) {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z10);
            }
            if (Log.isLoggable("CloudMessengerCompat", 3)) {
                return e.class;
            }
            int i10 = Build.VERSION.SDK_INT;
            return e.class;
        }
    }

    public e(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f15852f = new Messenger(iBinder);
        } else {
            this.f15853g = new c.a(iBinder);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.f15852f;
        return messenger != null ? messenger.getBinder() : this.f15853g.asBinder();
    }

    public final void b(Message message) {
        Messenger messenger = this.f15852f;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f15853g.G(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((e) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Messenger messenger = this.f15852f;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.f15853g.asBinder());
    }
}
