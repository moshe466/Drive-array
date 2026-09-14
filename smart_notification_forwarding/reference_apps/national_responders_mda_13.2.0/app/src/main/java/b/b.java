package b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import b.a;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    final Handler f3902f = null;

    /* renamed from: g, reason: collision with root package name */
    b.a f3903g;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    /* renamed from: b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class BinderC0066b extends a.AbstractBinderC0064a {
        BinderC0066b() {
        }

        @Override // b.a
        public void s0(int i10, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f3902f;
            if (handler != null) {
                handler.post(new c(i10, bundle));
            } else {
                bVar.a(i10, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final int f3905f;

        /* renamed from: g, reason: collision with root package name */
        final Bundle f3906g;

        c(int i10, Bundle bundle) {
            this.f3905f = i10;
            this.f3906g = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f3905f, this.f3906g);
        }
    }

    b(Parcel parcel) {
        this.f3903g = a.AbstractBinderC0064a.i(parcel.readStrongBinder());
    }

    protected void a(int i10, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f3903g == null) {
                this.f3903g = new BinderC0066b();
            }
            parcel.writeStrongBinder(this.f3903g.asBinder());
        }
    }
}
