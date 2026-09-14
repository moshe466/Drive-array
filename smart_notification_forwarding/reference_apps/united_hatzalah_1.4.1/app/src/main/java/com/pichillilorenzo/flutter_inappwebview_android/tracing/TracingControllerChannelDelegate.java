package com.pichillilorenzo.flutter_inappwebview_android.tracing;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import t0.d;
import t0.k;
import t0.m;
import u0.AbstractC0733k;
import u0.C0724b;
import u0.F;
import u0.H;
import u0.y;

/* loaded from: classes.dex */
public class TracingControllerChannelDelegate extends ChannelDelegateImpl {
    private TracingControllerManager tracingControllerManager;

    public TracingControllerChannelDelegate(TracingControllerManager tracingControllerManager, MethodChannel methodChannel) {
        super(methodChannel);
        this.tracingControllerManager = tracingControllerManager;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.tracingControllerManager = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        boolean isTracing;
        FileOutputStream fileOutputStream;
        boolean stop;
        TracingControllerManager.init();
        m mVar = TracingControllerManager.tracingController;
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1647175624:
                if (str.equals("isTracing")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c4 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                if (mVar != null) {
                    y yVar = (y) mVar;
                    C0724b c0724b = F.f6547z;
                    if (c0724b.a()) {
                        if (yVar.f6581a == null) {
                            yVar.f6581a = AbstractC0733k.a();
                        }
                        isTracing = AbstractC0733k.d(yVar.f6581a);
                    } else if (c0724b.b()) {
                        if (yVar.f6582b == null) {
                            yVar.f6582b = H.f6549a.getTracingController();
                        }
                        isTracing = yVar.f6582b.isTracing();
                    } else {
                        throw F.a();
                    }
                    result.success(Boolean.valueOf(isTracing));
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 1:
                if (mVar != null && d.a("TRACING_CONTROLLER_BASIC_USAGE")) {
                    String str2 = (String) methodCall.argument("filePath");
                    if (str2 != null) {
                        try {
                            fileOutputStream = new FileOutputStream(str2);
                        } catch (FileNotFoundException e4) {
                            e4.printStackTrace();
                            result.success(Boolean.FALSE);
                            return;
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    y yVar2 = (y) mVar;
                    C0724b c0724b2 = F.f6547z;
                    if (c0724b2.a()) {
                        if (yVar2.f6581a == null) {
                            yVar2.f6581a = AbstractC0733k.a();
                        }
                        stop = AbstractC0733k.g(yVar2.f6581a, fileOutputStream, newSingleThreadExecutor);
                    } else if (c0724b2.b()) {
                        if (yVar2.f6582b == null) {
                            yVar2.f6582b = H.f6549a.getTracingController();
                        }
                        stop = yVar2.f6582b.stop(fileOutputStream, newSingleThreadExecutor);
                    } else {
                        throw F.a();
                    }
                    result.success(Boolean.valueOf(stop));
                    return;
                }
                result.success(Boolean.FALSE);
                return;
            case 2:
                if (mVar != null && d.a("TRACING_CONTROLLER_BASIC_USAGE")) {
                    Map<String, Object> map = (Map) methodCall.argument("settings");
                    TracingSettings tracingSettings = new TracingSettings();
                    tracingSettings.parse2(map);
                    k buildTracingConfig = TracingControllerManager.buildTracingConfig(tracingSettings);
                    y yVar3 = (y) mVar;
                    if (buildTracingConfig != null) {
                        C0724b c0724b3 = F.f6547z;
                        if (c0724b3.a()) {
                            if (yVar3.f6581a == null) {
                                yVar3.f6581a = AbstractC0733k.a();
                            }
                            AbstractC0733k.f(yVar3.f6581a, buildTracingConfig);
                        } else if (c0724b3.b()) {
                            if (yVar3.f6582b == null) {
                                yVar3.f6582b = H.f6549a.getTracingController();
                            }
                            yVar3.f6582b.start(buildTracingConfig.f6374a, buildTracingConfig.f6375b, buildTracingConfig.f6376c);
                        } else {
                            throw F.a();
                        }
                        result.success(Boolean.TRUE);
                        return;
                    }
                    throw new IllegalArgumentException("Tracing config must be non null");
                }
                result.success(Boolean.FALSE);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
