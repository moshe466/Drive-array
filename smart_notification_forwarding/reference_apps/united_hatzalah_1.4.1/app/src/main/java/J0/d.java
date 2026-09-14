package J0;

import A1.i;
import A1.l;
import F0.C0029f0;
import F0.C0035g2;
import F0.C0068p;
import F0.C0110z2;
import F0.G1;
import F0.b3;
import J.C0116d;
import J.InterfaceC0115c;
import J.S;
import L.h;
import a.AbstractC0228a;
import android.content.ClipData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.credentials.playservices.HiddenActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.crypto.tink.shaded.protobuf.C0332d;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.CrashlyticsRemoteConfigListener;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.google.firebase.database.android.AndroidAppCheckTokenProvider;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.ServiceStarter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.internal.Code;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.sessions.EventGDTLogger;
import com.google.firebase.sessions.SessionEvent;
import com.lt.plugin.lt_plugin.services.LocationService;
import io.flutter.Build;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import io.flutter.util.ViewUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.j;
import m.C0571u;
import org.apache.tika.metadata.HttpHeaders;
import r1.C0644b;
import s1.C0674n;
import s1.v;
import s2.C0681f;
import s2.C0684i;
import t1.k;
import w1.C0753a;
import w1.EnumC0755c;
import z1.g;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements BasicMessageChannel.Reply, OnSuccessListener, d3.b, Deferred.DeferredHandler, Continuation, SuccessContinuation, q1.e, OnCompleteListener, KeyEventChannel.EventResponseHandler, ViewUtils.ViewVisitor, B1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1048a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1049b;

    public /* synthetic */ d(C0029f0 c0029f0, String str) {
        this.f1048a = 0;
        this.f1049b = str;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [K1.m, java.lang.Object] */
    @Override // B1.a
    public Object a() {
        SQLiteDatabase a2;
        Cursor rawQuery;
        byte[] decode;
        int i = this.f1048a;
        int i3 = 2;
        Object obj = this.f1049b;
        switch (i) {
            case Build.API_LEVELS.API_26 /* 26 */:
                l lVar = (l) ((g) obj).i;
                a2 = lVar.a();
                a2.beginTransaction();
                try {
                    a2.compileStatement("DELETE FROM log_event_dropped").execute();
                    a2.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + lVar.f54b.d()).execute();
                    a2.setTransactionSuccessful();
                    return null;
                } finally {
                }
            case Build.API_LEVELS.API_27 /* 27 */:
                l lVar2 = (l) ((A1.c) obj);
                lVar2.getClass();
                int i4 = C0753a.f6704e;
                ?? obj2 = new Object();
                obj2.f1102a = null;
                obj2.f1103b = new ArrayList();
                obj2.f1104c = null;
                obj2.f1105d = "";
                HashMap hashMap = new HashMap();
                a2 = lVar2.a();
                a2.beginTransaction();
                try {
                    C0753a c0753a = (C0753a) l.h(a2.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new i(lVar2, hashMap, obj2, i3));
                    a2.setTransactionSuccessful();
                    return c0753a;
                } finally {
                }
            case Build.API_LEVELS.API_28 /* 28 */:
                l lVar3 = (l) ((A1.d) obj);
                long d2 = lVar3.f54b.d() - lVar3.f56d.f31d;
                a2 = lVar3.a();
                a2.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(d2)};
                    rawQuery = a2.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (rawQuery.moveToNext()) {
                        try {
                            lVar3.e(rawQuery.getInt(0), EnumC0755c.MESSAGE_TOO_OLD, rawQuery.getString(1));
                        } finally {
                        }
                    }
                    rawQuery.close();
                    int delete = a2.delete("events", "timestamp_ms < ?", strArr);
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                    return Integer.valueOf(delete);
                } finally {
                }
            default:
                z1.i iVar = (z1.i) obj;
                a2 = ((l) iVar.f6873b).a();
                a2.beginTransaction();
                try {
                    rawQuery = a2.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (rawQuery.moveToNext()) {
                            C0110z2 a4 = k.a();
                            a4.v(rawQuery.getString(1));
                            a4.f731d = D1.a.b(rawQuery.getInt(2));
                            String string = rawQuery.getString(3);
                            if (string == null) {
                                decode = null;
                            } else {
                                decode = Base64.decode(string, 0);
                            }
                            a4.f730c = decode;
                            arrayList.add(a4.g());
                        }
                        rawQuery.close();
                        a2.setTransactionSuccessful();
                        a2.endTransaction();
                        int size = arrayList.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Object obj3 = arrayList.get(i5);
                            i5++;
                            iVar.f6874c.a((k) obj3, 1, false);
                        }
                        return null;
                    } finally {
                    }
                } finally {
                }
        }
    }

    @Override // q1.e
    public Object apply(Object obj) {
        return EventGDTLogger.a((EventGDTLogger) this.f1049b, (SessionEvent) obj);
    }

    @Override // d3.b
    public Object b(f3.b bVar) {
        return (f3.c) this.f1049b;
    }

    public C0332d c(b3 b3Var) {
        InputStream inputStream;
        C0644b c0644b = (C0644b) this.f1049b;
        URL url = (URL) b3Var.f469b;
        if (Log.isLoggable(AbstractC0228a.v("CctTransportBackend"), 4)) {
            String.format("Making request to: %s", url);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(c0644b.f6216g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.3.0 android/");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) b3Var.f471d;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    c0644b.f6210a.encode((C0674n) b3Var.f470c, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer valueOf = Integer.valueOf(responseCode);
                    if (Log.isLoggable(AbstractC0228a.v("CctTransportBackend"), 4)) {
                        String.format("Status Code: %d", valueOf);
                    }
                    AbstractC0228a.h("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField(HttpHeaders.CONTENT_TYPE));
                    AbstractC0228a.h("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        if (responseCode != 200) {
                            return new C0332d(responseCode, null, 0L);
                        }
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            if ("gzip".equals(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING))) {
                                inputStream = new GZIPInputStream(inputStream2);
                            } else {
                                inputStream = inputStream2;
                            }
                            try {
                                C0332d c0332d = new C0332d(responseCode, null, v.a(new BufferedReader(new InputStreamReader(inputStream))).f6325a);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                return c0332d;
                            } finally {
                            }
                        } catch (Throwable th) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                    return new C0332d(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)), 0L);
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e4) {
            e = e4;
            AbstractC0228a.l(e, "CctTransportBackend", "Couldn't encode request, returning with 400");
            return new C0332d(400, null, 0L);
        } catch (ConnectException e5) {
            e = e5;
            AbstractC0228a.l(e, "CctTransportBackend", "Couldn't open connection, returning with 500");
            return new C0332d(ServiceStarter.ERROR_UNKNOWN, null, 0L);
        } catch (UnknownHostException e6) {
            e = e6;
            AbstractC0228a.l(e, "CctTransportBackend", "Couldn't open connection, returning with 500");
            return new C0332d(ServiceStarter.ERROR_UNKNOWN, null, 0L);
        } catch (IOException e7) {
            e = e7;
            AbstractC0228a.l(e, "CctTransportBackend", "Couldn't encode request, returning with 400");
            return new C0332d(400, null, 0L);
        }
    }

    public boolean d(C0035g2 c0035g2, int i, Bundle bundle) {
        InterfaceC0115c interfaceC0115c;
        C0571u c0571u = (C0571u) this.f1049b;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 25 && (i & 1) != 0) {
            try {
                ((h) c0035g2.f526b).b();
                Parcelable parcelable = (Parcelable) ((h) c0035g2.f526b).e();
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception unused) {
                return false;
            }
        }
        h hVar = (h) c0035g2.f526b;
        ClipData clipData = new ClipData(hVar.getDescription(), new ClipData.Item(hVar.a()));
        if (i3 >= 31) {
            interfaceC0115c = new G1(clipData, 2);
        } else {
            C0116d c0116d = new C0116d();
            c0116d.f977b = clipData;
            c0116d.f978c = 2;
            interfaceC0115c = c0116d;
        }
        interfaceC0115c.b(hVar.c());
        interfaceC0115c.setExtras(bundle);
        if (S.g(c0571u, interfaceC0115c.build()) == null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        switch (this.f1048a) {
            case 7:
                CrashlyticsNativeComponentDeferredProxy.b((CrashlyticsNativeComponentDeferredProxy) this.f1049b, provider);
                return;
            case 8:
                RemoteConfigDeferredProxy.a((CrashlyticsRemoteConfigListener) this.f1049b, provider);
                return;
            case 13:
                ((AndroidAppCheckTokenProvider) this.f1049b).lambda$new$0(provider);
                return;
            default:
                ((AndroidAuthTokenProvider) this.f1049b).lambda$new$0(provider);
                return;
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f1048a) {
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                LocationService.lambda$getLastLocationAsync$0((Consumer) this.f1049b, task);
                return;
            case 19:
            default:
                FlutterFirebaseCorePlugin.o((GeneratedAndroidFirebaseCore.Result) this.f1049b, task);
                return;
            case 20:
                FlutterFirebaseCorePlugin.h((GeneratedAndroidFirebaseCore.VoidResult) this.f1049b, task);
                return;
        }
    }

    @Override // io.flutter.embedding.engine.systemchannels.KeyEventChannel.EventResponseHandler
    public void onFrameworkResponse(boolean z3) {
        ((KeyboardManager.Responder.OnKeyEventHandledCallback) this.f1049b).onKeyEventHandled(z3);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        int i = this.f1048a;
        Object obj2 = this.f1049b;
        switch (i) {
            case 2:
                int i3 = HiddenActivity.f3084c;
                ((N.c) obj2).invoke(obj);
                return;
            case 3:
                int i4 = HiddenActivity.f3084c;
                ((N.c) obj2).invoke(obj);
                return;
            case 4:
                int i5 = HiddenActivity.f3084c;
                ((N.c) obj2).invoke(obj);
                return;
            case 5:
                int i6 = HiddenActivity.f3084c;
                ((N.c) obj2).invoke(obj);
                return;
            case 22:
                ((C0068p) obj2).invoke(obj);
                return;
            default:
                ((C0068p) obj2).invoke(obj);
                return;
        }
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
    public void reply(Object obj) {
        String str = (String) this.f1049b;
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() > 1) {
                Object obj2 = list.get(0);
                j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = list.get(1);
                j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                Throwable a2 = C0681f.a(AbstractC0228a.g(new a((String) obj2, (String) obj3, (String) list.get(2))));
                if (a2 == null) {
                    return;
                }
                io.flutter.Log.e("MethodCallHandlerSink", "Result ended with failure");
                throw a2;
            }
            Throwable a4 = C0681f.a(C0684i.f6340a);
            if (a4 == null) {
                return;
            }
            io.flutter.Log.e("MethodCallHandlerSink", "Result ended with failure");
            throw a4;
        }
        Throwable a5 = C0681f.a(AbstractC0228a.g(new a("channel-error", e0.a.e("Unable to establish connection on channel: '", str, "'."), "")));
        if (a5 == null) {
            return;
        }
        io.flutter.Log.e("MethodCallHandlerSink", "Result ended with failure");
        throw a5;
    }

    @Override // io.flutter.util.ViewUtils.ViewVisitor
    public boolean run(View view) {
        return ViewUtils.b((Class[]) this.f1049b, view);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task forResult;
        forResult = Tasks.forResult((ConfigFetchHandler.FetchResponse) this.f1049b);
        return forResult;
    }

    public /* synthetic */ d(Object obj, int i) {
        this.f1048a = i;
        this.f1049b = obj;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Task lambda$submit$1;
        Task lambda$submitTaskOnSuccess$5;
        FirebaseRemoteConfigInfo lambda$ensureInitialized$0;
        switch (this.f1048a) {
            case 9:
                return Boolean.valueOf(SessionReportingCoordinator.b((SessionReportingCoordinator) this.f1049b, task));
            case 10:
                return Utils.a((CountDownLatch) this.f1049b, task);
            case 11:
                lambda$submit$1 = CrashlyticsWorker.lambda$submit$1((Runnable) this.f1049b, task);
                return lambda$submit$1;
            case Code.UNIMPLEMENTED /* 12 */:
                lambda$submitTaskOnSuccess$5 = CrashlyticsWorker.lambda$submitTaskOnSuccess$5((SuccessContinuation) this.f1049b, task);
                return lambda$submitTaskOnSuccess$5;
            default:
                lambda$ensureInitialized$0 = FirebaseRemoteConfig.lambda$ensureInitialized$0((Task) this.f1049b, task);
                return lambda$ensureInitialized$0;
        }
    }
}
