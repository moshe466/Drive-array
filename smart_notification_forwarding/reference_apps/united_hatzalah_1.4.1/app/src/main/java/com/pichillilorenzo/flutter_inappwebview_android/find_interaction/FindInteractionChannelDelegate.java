package com.pichillilorenzo.flutter_inappwebview_android.find_interaction;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.FindSession;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FindInteractionChannelDelegate extends ChannelDelegateImpl {
    private FindInteractionController findInteractionController;

    public FindInteractionChannelDelegate(FindInteractionController findInteractionController, MethodChannel methodChannel) {
        super(methodChannel);
        this.findInteractionController = findInteractionController;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.findInteractionController = null;
    }

    public void onFindResultReceived(int i, int i3, boolean z3) {
        FindInteractionController findInteractionController;
        MethodChannel channel = getChannel();
        if (channel == null) {
            return;
        }
        if (z3 && (findInteractionController = this.findInteractionController) != null && findInteractionController.webView != null) {
            findInteractionController.activeFindSession = new FindSession(i3, i);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("activeMatchOrdinal", Integer.valueOf(i));
        hashMap.put("numberOfMatches", Integer.valueOf(i3));
        hashMap.put("isDoneCounting", Boolean.valueOf(z3));
        channel.invokeMethod("onFindResultReceived", hashMap);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        FindSession findSession;
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1008221461:
                if (str.equals("getSearchText")) {
                    c4 = 0;
                    break;
                }
                break;
            case -853211864:
                if (str.equals("findAll")) {
                    c4 = 1;
                    break;
                }
                break;
            case -679382964:
                if (str.equals("findNext")) {
                    c4 = 2;
                    break;
                }
                break;
            case -234090249:
                if (str.equals("setSearchText")) {
                    c4 = 3;
                    break;
                }
                break;
            case 817048102:
                if (str.equals("clearMatches")) {
                    c4 = 4;
                    break;
                }
                break;
            case 2137531137:
                if (str.equals("getActiveFindSession")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                FindInteractionController findInteractionController = this.findInteractionController;
                if (findInteractionController != null) {
                    result.success(findInteractionController.searchText);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 1:
                if (this.findInteractionController != null) {
                    this.findInteractionController.findAll((String) methodCall.argument("find"));
                }
                result.success(Boolean.TRUE);
                return;
            case 2:
                if (this.findInteractionController != null) {
                    this.findInteractionController.findNext(((Boolean) methodCall.argument("forward")).booleanValue());
                }
                result.success(Boolean.TRUE);
                return;
            case 3:
                FindInteractionController findInteractionController2 = this.findInteractionController;
                if (findInteractionController2 != null) {
                    findInteractionController2.searchText = (String) methodCall.argument("searchText");
                    result.success(Boolean.TRUE);
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 4:
                FindInteractionController findInteractionController3 = this.findInteractionController;
                if (findInteractionController3 != null) {
                    findInteractionController3.clearMatches();
                }
                result.success(Boolean.TRUE);
                return;
            case 5:
                FindInteractionController findInteractionController4 = this.findInteractionController;
                if (findInteractionController4 != null && (findSession = findInteractionController4.activeFindSession) != null) {
                    result.success(findSession.toMap());
                    return;
                } else {
                    result.success(null);
                    return;
                }
            default:
                result.notImplemented();
                return;
        }
    }
}
