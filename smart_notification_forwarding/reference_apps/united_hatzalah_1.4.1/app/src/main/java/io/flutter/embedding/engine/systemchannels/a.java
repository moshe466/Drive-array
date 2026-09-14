package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements PlatformViewsChannel.PlatformViewBufferResized, BasicMessageChannel.Reply {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f5035a;

    public /* synthetic */ a(Object obj) {
        this.f5035a = obj;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public void reply(Object obj) {
        KeyEventChannel.lambda$createReplyHandler$0((KeyEventChannel.EventResponseHandler) this.f5035a, obj);
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewBufferResized
    public void run(PlatformViewsChannel.PlatformViewBufferSize platformViewBufferSize) {
        PlatformViewsChannel.AnonymousClass1.a((MethodChannel.Result) this.f5035a, platformViewBufferSize);
    }
}
