package g0;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* renamed from: g0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0426b {

    /* renamed from: a, reason: collision with root package name */
    public final IntentFilter f4652a;

    /* renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f4653b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4654c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4655d;

    public C0426b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.f4652a = intentFilter;
        this.f4653b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f4653b);
        sb.append(" filter=");
        sb.append(this.f4652a);
        if (this.f4655d) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}
