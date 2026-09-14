package l2;

import F0.G1;
import F0.Q2;
import F0.RunnableC0064o;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0518a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0519b f5484a;

    public C0518a(C0519b c0519b) {
        this.f5484a = c0519b;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        C0519b c0519b = this.f5484a;
        c0519b.f5487c.post(new RunnableC0064o(15, c0519b, G1.j(((ConnectivityManager) c0519b.f5485a.f218b).getNetworkCapabilities(network))));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        C0519b c0519b = this.f5484a;
        c0519b.f5485a.getClass();
        c0519b.f5487c.post(new RunnableC0064o(15, c0519b, G1.j(networkCapabilities)));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        C0519b c0519b = this.f5484a;
        c0519b.f5487c.postDelayed(new Q2(c0519b, 12), 500L);
    }
}
