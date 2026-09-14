package l2;

import F0.G1;
import android.net.ConnectivityManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;

/* renamed from: l2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0520c implements MethodChannel.MethodCallHandler {

    /* renamed from: a, reason: collision with root package name */
    public final G1 f5489a;

    public C0520c(G1 g12) {
        this.f5489a = g12;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (ExternalParsersConfigReaderMetKeys.CHECK_TAG.equals(methodCall.method)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f5489a.f218b;
            result.success(G1.j(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())));
        } else {
            result.notImplemented();
        }
    }
}
