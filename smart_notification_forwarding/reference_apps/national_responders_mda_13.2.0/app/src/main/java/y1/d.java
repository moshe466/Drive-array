package y1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import y1.e;

/* loaded from: classes.dex */
public class d {

    /* renamed from: h, reason: collision with root package name */
    private static int f15841h;

    /* renamed from: i, reason: collision with root package name */
    private static PendingIntent f15842i;

    /* renamed from: j, reason: collision with root package name */
    private static final Executor f15843j = d0.f15851f;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15845b;

    /* renamed from: c, reason: collision with root package name */
    private final v f15846c;

    /* renamed from: d, reason: collision with root package name */
    private final ScheduledExecutorService f15847d;

    /* renamed from: f, reason: collision with root package name */
    private Messenger f15849f;

    /* renamed from: g, reason: collision with root package name */
    private e f15850g;

    /* renamed from: a, reason: collision with root package name */
    private final l.g<String, z2.m<Bundle>> f15844a = new l.g<>();

    /* renamed from: e, reason: collision with root package name */
    private Messenger f15848e = new Messenger(new c0(this, Looper.getMainLooper()));

    public d(Context context) {
        this.f15845b = context;
        this.f15846c = new v(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f15847d = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Bundle b(z2.l lVar) {
        if (lVar.p()) {
            return (Bundle) lVar.l();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(lVar.k());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
            sb2.append("Error making request: ");
            sb2.append(valueOf);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", lVar.k());
    }

    private static synchronized String c() {
        String num;
        synchronized (d.class) {
            int i10 = f15841h;
            f15841h = i10 + 1;
            num = Integer.toString(i10);
        }
        return num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ z2.l d(Bundle bundle) {
        return l(bundle) ? z2.o.e(null) : z2.o.e(bundle);
    }

    private static synchronized void f(Context context, Intent intent) {
        synchronized (d.class) {
            if (f15842i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f15842i = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", f15842i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new e.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof e) {
                        this.f15850g = (e) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f15849f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String valueOf = String.valueOf(action);
                        if (valueOf.length() != 0) {
                            "Unexpected response action: ".concat(valueOf);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (!Log.isLoggable("Rpc", 3) || stringExtra.length() == 0) {
                            return;
                        }
                        "Unexpected response string: ".concat(stringExtra);
                        return;
                    }
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (group != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", group2);
                        h(group, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 49);
                    sb2.append("Unexpected response, no error or registration id ");
                    sb2.append(valueOf2);
                    return;
                }
                if (Log.isLoggable("Rpc", 3) && stringExtra2.length() != 0) {
                    "Received InstanceID error ".concat(stringExtra2);
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (this.f15844a) {
                        for (int i10 = 0; i10 < this.f15844a.size(); i10++) {
                            h(this.f15844a.i(i10), intent2.getExtras());
                        }
                    }
                    return;
                }
                String[] split = stringExtra2.split("\\|");
                if (split.length <= 2 || !"ID".equals(split[1])) {
                    if (stringExtra2.length() != 0) {
                        "Unexpected structured response ".concat(stringExtra2);
                    }
                } else {
                    String str = split[2];
                    String str2 = split[3];
                    if (str2.startsWith(":")) {
                        str2 = str2.substring(1);
                    }
                    h(str, intent2.putExtra("error", str2).getExtras());
                }
            }
        }
    }

    private final void h(String str, Bundle bundle) {
        synchronized (this.f15844a) {
            z2.m<Bundle> remove = this.f15844a.remove(str);
            if (remove != null) {
                remove.c(bundle);
                return;
            }
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Missing callback for ".concat(valueOf);
            }
        }
    }

    private static boolean l(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    private final z2.l<Bundle> m(Bundle bundle) {
        final String c10 = c();
        final z2.m<Bundle> mVar = new z2.m<>();
        synchronized (this.f15844a) {
            this.f15844a.put(c10, mVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(this.f15846c.a() == 2 ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
        intent.putExtras(bundle);
        f(this.f15845b, intent);
        StringBuilder sb2 = new StringBuilder(String.valueOf(c10).length() + 5);
        sb2.append("|ID|");
        sb2.append(c10);
        sb2.append("|");
        intent.putExtra("kid", sb2.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 8);
            sb3.append("Sending ");
            sb3.append(valueOf);
        }
        intent.putExtra("google.messenger", this.f15848e);
        if (this.f15849f != null || this.f15850g != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f15849f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f15850g.b(obtain);
                }
            } catch (RemoteException unused) {
            }
            final ScheduledFuture<?> schedule = this.f15847d.schedule(new Runnable(mVar) { // from class: y1.y

                /* renamed from: f, reason: collision with root package name */
                private final z2.m f15888f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f15888f = mVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f15888f.d(new IOException("TIMEOUT"));
                }
            }, 30L, TimeUnit.SECONDS);
            mVar.a().b(f15843j, new z2.f(this, c10, schedule) { // from class: y1.b0

                /* renamed from: a, reason: collision with root package name */
                private final d f15836a;

                /* renamed from: b, reason: collision with root package name */
                private final String f15837b;

                /* renamed from: c, reason: collision with root package name */
                private final ScheduledFuture f15838c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f15836a = this;
                    this.f15837b = c10;
                    this.f15838c = schedule;
                }

                @Override // z2.f
                public final void a(z2.l lVar) {
                    this.f15836a.i(this.f15837b, this.f15838c, lVar);
                }
            });
            return mVar.a();
        }
        if (this.f15846c.a() == 2) {
            this.f15845b.sendBroadcast(intent);
        } else {
            this.f15845b.startService(intent);
        }
        final ScheduledFuture schedule2 = this.f15847d.schedule(new Runnable(mVar) { // from class: y1.y

            /* renamed from: f, reason: collision with root package name */
            private final z2.m f15888f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15888f = mVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f15888f.d(new IOException("TIMEOUT"));
            }
        }, 30L, TimeUnit.SECONDS);
        mVar.a().b(f15843j, new z2.f(this, c10, schedule2) { // from class: y1.b0

            /* renamed from: a, reason: collision with root package name */
            private final d f15836a;

            /* renamed from: b, reason: collision with root package name */
            private final String f15837b;

            /* renamed from: c, reason: collision with root package name */
            private final ScheduledFuture f15838c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15836a = this;
                this.f15837b = c10;
                this.f15838c = schedule2;
            }

            @Override // z2.f
            public final void a(z2.l lVar) {
                this.f15836a.i(this.f15837b, this.f15838c, lVar);
            }
        });
        return mVar.a();
    }

    public z2.l<Bundle> a(final Bundle bundle) {
        if (this.f15846c.c() >= 12000000) {
            return i.c(this.f15845b).g(1, bundle).h(f15843j, x.f15887a);
        }
        return !(this.f15846c.a() != 0) ? z2.o.d(new IOException("MISSING_INSTANCEID_SERVICE")) : m(bundle).j(f15843j, new z2.c(this, bundle) { // from class: y1.z

            /* renamed from: a, reason: collision with root package name */
            private final d f15889a;

            /* renamed from: b, reason: collision with root package name */
            private final Bundle f15890b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15889a = this;
                this.f15890b = bundle;
            }

            @Override // z2.c
            public final Object a(z2.l lVar) {
                return this.f15889a.e(this.f15890b, lVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ z2.l e(Bundle bundle, z2.l lVar) {
        return (lVar.p() && l((Bundle) lVar.l())) ? m(bundle).q(f15843j, a0.f15834a) : lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(String str, ScheduledFuture scheduledFuture, z2.l lVar) {
        synchronized (this.f15844a) {
            this.f15844a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
