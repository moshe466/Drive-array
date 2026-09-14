package y1;

import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
abstract class u<T> {

    /* renamed from: a, reason: collision with root package name */
    final int f15880a;

    /* renamed from: b, reason: collision with root package name */
    final z2.m<T> f15881b = new z2.m<>();

    /* renamed from: c, reason: collision with root package name */
    final int f15882c;

    /* renamed from: d, reason: collision with root package name */
    final Bundle f15883d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(int i10, int i11, Bundle bundle) {
        this.f15880a = i10;
        this.f15882c = i11;
        this.f15883d = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(T t10) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16 + valueOf2.length());
            sb2.append("Finishing ");
            sb2.append(valueOf);
            sb2.append(" with ");
            sb2.append(valueOf2);
        }
        this.f15881b.c(t10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(t tVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(tVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb2.append("Failing ");
            sb2.append(valueOf);
            sb2.append(" with ");
            sb2.append(valueOf2);
        }
        this.f15881b.b(tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean d();

    public String toString() {
        int i10 = this.f15882c;
        int i11 = this.f15880a;
        boolean d10 = d();
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Request { what=");
        sb2.append(i10);
        sb2.append(" id=");
        sb2.append(i11);
        sb2.append(" oneWay=");
        sb2.append(d10);
        sb2.append("}");
        return sb2.toString();
    }
}
