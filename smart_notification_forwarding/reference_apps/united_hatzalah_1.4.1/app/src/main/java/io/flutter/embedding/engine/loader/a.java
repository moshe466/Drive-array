package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;
import com.lt.plugin.lt_plugin.LtPlugin;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5024a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5025b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5026c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f5027d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Handler f5028e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5029f;

    public /* synthetic */ a(Object obj, Object obj2, Serializable serializable, Handler handler, Object obj3, int i) {
        this.f5024a = i;
        this.f5025b = obj;
        this.f5026c = obj2;
        this.f5027d = serializable;
        this.f5028e = handler;
        this.f5029f = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5024a) {
            case 0:
                FlutterLoader.b((FlutterLoader) this.f5025b, (Context) this.f5026c, (String[]) this.f5027d, this.f5028e, (Runnable) this.f5029f);
                return;
            case 1:
                FlutterLoader.a((FlutterLoader) this.f5025b, (Context) this.f5026c, (String[]) this.f5027d, this.f5028e, (Runnable) this.f5029f);
                return;
            default:
                LtPlugin.f((LtPlugin) this.f5025b, (String) this.f5026c, (String) this.f5027d, this.f5028e, (MethodChannel.Result) this.f5029f);
                return;
        }
    }
}
