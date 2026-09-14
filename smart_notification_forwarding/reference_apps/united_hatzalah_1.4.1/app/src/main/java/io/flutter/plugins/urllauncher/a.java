package io.flutter.plugins.urllauncher;

import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.urllauncher.Messages;
import io.flutter.plugins.urllauncher.UrlLauncher;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler, UrlLauncher.IntentResolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5095a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5096b;

    public /* synthetic */ a(Object obj, int i) {
        this.f5095a = i;
        this.f5096b = obj;
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncher.IntentResolver
    public String getHandlerComponentName(Intent intent) {
        return UrlLauncher.f((Context) this.f5096b, intent);
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        switch (this.f5095a) {
            case 0:
                Messages.UrlLauncherApi.c((Messages.UrlLauncherApi) this.f5096b, obj, reply);
                return;
            case 1:
                Messages.UrlLauncherApi.b((Messages.UrlLauncherApi) this.f5096b, obj, reply);
                return;
            case 2:
                Messages.UrlLauncherApi.a((Messages.UrlLauncherApi) this.f5096b, obj, reply);
                return;
            case 3:
                Messages.UrlLauncherApi.e((Messages.UrlLauncherApi) this.f5096b, obj, reply);
                return;
            default:
                Messages.UrlLauncherApi.d((Messages.UrlLauncherApi) this.f5096b, obj, reply);
                return;
        }
    }
}
