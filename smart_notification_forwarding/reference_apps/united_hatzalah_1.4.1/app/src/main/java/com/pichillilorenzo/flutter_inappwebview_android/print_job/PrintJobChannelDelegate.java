package com.pichillilorenzo.flutter_inappwebview_android.print_job;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.PrintJobInfoExt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

/* loaded from: classes.dex */
public class PrintJobChannelDelegate extends ChannelDelegateImpl {
    private PrintJobController printJobController;

    public PrintJobChannelDelegate(PrintJobController printJobController, MethodChannel methodChannel) {
        super(methodChannel);
        this.printJobController = printJobController;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.printJobController = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    c4 = 0;
                    break;
                }
                break;
            case -75444956:
                if (str.equals("getInfo")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1097506319:
                if (str.equals("restart")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1671767583:
                if (str.equals("dispose")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                PrintJobController printJobController = this.printJobController;
                if (printJobController != null) {
                    printJobController.cancel();
                    result.success(Boolean.TRUE);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 1:
                PrintJobController printJobController2 = this.printJobController;
                Map<String, Object> map = null;
                if (printJobController2 != null) {
                    PrintJobInfoExt info = printJobController2.getInfo();
                    if (info != null) {
                        map = info.toMap();
                    }
                    result.success(map);
                    return;
                }
                result.success(null);
                return;
            case 2:
                PrintJobController printJobController3 = this.printJobController;
                if (printJobController3 != null) {
                    printJobController3.restart();
                    result.success(Boolean.TRUE);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 3:
                PrintJobController printJobController4 = this.printJobController;
                if (printJobController4 != null) {
                    printJobController4.dispose();
                    result.success(Boolean.TRUE);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            default:
                result.notImplemented();
                return;
        }
    }
}
