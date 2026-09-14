package com.google.firebase.crashlytics.internal.metadata;

import A1.l;
import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.lt.plugin.lt_plugin.FCMNotificationIntentService;
import com.lt.plugin.lt_plugin.LtPlugin;
import com.lt.plugin.lt_plugin.utils.PushRedactionReporter;
import f2.C0421b;
import i2.i;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import q1.h;
import r1.C0644b;
import t1.j;
import t1.k;
import u1.g;
import y1.C0784a;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4239a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4240b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4241c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4242d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f4243e;

    public /* synthetic */ a(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, GeneratedAndroidFirebaseCore.CoreFirebaseOptions coreFirebaseOptions, String str, TaskCompletionSource taskCompletionSource) {
        this.f4239a = 6;
        this.f4241c = flutterFirebaseCorePlugin;
        this.f4242d = coreFirebaseOptions;
        this.f4240b = str;
        this.f4243e = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4239a) {
            case 0:
                ((UserMetadata) this.f4241c).lambda$setNewSession$0((String) this.f4240b, (Map) this.f4242d, (List) this.f4243e);
                return;
            case 1:
                FCMNotificationIntentService.c((String) this.f4240b, (String) this.f4241c, (String) this.f4242d, (String) this.f4243e);
                return;
            case 2:
                LtPlugin.d((LtPlugin) this.f4241c, (String) this.f4240b, (String) this.f4242d, (MethodChannel.Result) this.f4243e);
                return;
            case 3:
                PushRedactionReporter.lambda$reportAsync$0((Context) this.f4241c, (String) this.f4240b, (String) this.f4242d, (String) this.f4243e);
                return;
            case 4:
                ((C0421b) this.f4241c).f4604a.error((String) this.f4240b, (String) this.f4242d, this.f4243e);
                return;
            case 5:
                ((i) this.f4241c).f5005a.error((String) this.f4240b, (String) this.f4242d, this.f4243e);
                return;
            case 6:
                FlutterFirebaseCorePlugin.k((FlutterFirebaseCorePlugin) this.f4241c, (GeneratedAndroidFirebaseCore.CoreFirebaseOptions) this.f4242d, (String) this.f4240b, (TaskCompletionSource) this.f4243e);
                return;
            default:
                C0784a c0784a = (C0784a) this.f4241c;
                k kVar = (k) this.f4240b;
                String str = kVar.f6431a;
                h hVar = (h) this.f4242d;
                j jVar = (j) this.f4243e;
                c0784a.getClass();
                Logger logger = C0784a.f6750f;
                try {
                    g a2 = c0784a.f6753c.a(str);
                    if (a2 == null) {
                        String str2 = "Transport backend '" + str + "' is not registered";
                        logger.warning(str2);
                        hVar.a(new IllegalArgumentException(str2));
                    } else {
                        ((l) c0784a.f6755e).f(new A1.i(c0784a, kVar, ((C0644b) a2).a(jVar)));
                        hVar.a(null);
                    }
                    return;
                } catch (Exception e4) {
                    logger.warning("Error scheduling event " + e4.getMessage());
                    hVar.a(e4);
                    return;
                }
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f4239a = i;
        this.f4241c = obj;
        this.f4240b = obj2;
        this.f4242d = obj3;
        this.f4243e = obj4;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4) {
        this.f4239a = 1;
        this.f4240b = str;
        this.f4241c = str2;
        this.f4242d = str3;
        this.f4243e = str4;
    }
}
