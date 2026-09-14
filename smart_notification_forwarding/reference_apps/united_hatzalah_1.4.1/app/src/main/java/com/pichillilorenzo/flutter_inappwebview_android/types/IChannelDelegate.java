package com.pichillilorenzo.flutter_inappwebview_android.types;

import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes.dex */
public interface IChannelDelegate extends MethodChannel.MethodCallHandler, Disposable {
    MethodChannel getChannel();
}
