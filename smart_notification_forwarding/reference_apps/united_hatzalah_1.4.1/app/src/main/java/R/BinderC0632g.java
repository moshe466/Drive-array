package r;

import a.AbstractC0228a;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import b.InterfaceC0316a;
import com.google.firebase.remoteconfig.internal.Code;
import m.U;

/* renamed from: r.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0632g extends Binder implements InterfaceC0316a {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0626a f6182b;

    public BinderC0632g(AbstractC0626a abstractC0626a) {
        this.f6182b = abstractC0626a;
        attachInterface(this, InterfaceC0316a.f3794g);
        this.f6181a = new Handler(Looper.getMainLooper());
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
        Bundle extraCallbackWithResult;
        String str = InterfaceC0316a.f3794g;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        boolean z3 = false;
        Handler handler = this.f6181a;
        AbstractC0626a abstractC0626a = this.f6182b;
        switch (i) {
            case 2:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new U(readInt, bundle, this));
                    return true;
                }
                return true;
            case 3:
                String readString = parcel.readString();
                Bundle bundle2 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0628c(this, readString, bundle2, 0));
                    return true;
                }
                return true;
            case 4:
                Bundle bundle3 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0627b(1, bundle3, this));
                }
                parcel2.writeNoException();
                return true;
            case 5:
                String readString2 = parcel.readString();
                Bundle bundle4 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0628c(this, readString2, bundle4, 1));
                }
                parcel2.writeNoException();
                return true;
            case 6:
                int readInt2 = parcel.readInt();
                Uri uri = (Uri) AbstractC0228a.a(parcel, Uri.CREATOR);
                if (parcel.readInt() != 0) {
                    z3 = true;
                }
                Bundle bundle5 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0629d(this, readInt2, uri, z3, bundle5));
                    return true;
                }
                return true;
            case 7:
                String readString3 = parcel.readString();
                Bundle bundle6 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a == null) {
                    extraCallbackWithResult = null;
                } else {
                    extraCallbackWithResult = abstractC0626a.extraCallbackWithResult(readString3, bundle6);
                }
                parcel2.writeNoException();
                if (extraCallbackWithResult != null) {
                    parcel2.writeInt(1);
                    extraCallbackWithResult.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 8:
                int readInt3 = parcel.readInt();
                int readInt4 = parcel.readInt();
                Bundle bundle7 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0630e(this, readInt3, readInt4, bundle7));
                    return true;
                }
                return true;
            case 9:
                Bundle bundle8 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0627b(2, bundle8, this));
                    return true;
                }
                return true;
            case 10:
                int readInt5 = parcel.readInt();
                int readInt6 = parcel.readInt();
                int readInt7 = parcel.readInt();
                int readInt8 = parcel.readInt();
                int readInt9 = parcel.readInt();
                Bundle bundle9 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0631f(this, readInt5, readInt6, readInt7, readInt8, readInt9, bundle9));
                    return true;
                }
                return true;
            case 11:
                Bundle bundle10 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0627b(3, bundle10, this));
                    return true;
                }
                return true;
            case Code.UNIMPLEMENTED /* 12 */:
                Bundle bundle11 = (Bundle) AbstractC0228a.a(parcel, Bundle.CREATOR);
                if (abstractC0626a != null) {
                    handler.post(new RunnableC0627b(0, bundle11, this));
                    return true;
                }
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i3);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
