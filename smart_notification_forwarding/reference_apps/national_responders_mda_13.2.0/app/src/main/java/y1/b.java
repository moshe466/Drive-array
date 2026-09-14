package y1;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f15835a = n2.a.a().a(new h2.b("firebase-iid-executor"), n2.f.f12176a);

    private final int e(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            d(context, extras);
            return -1;
        }
        if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            return 500;
        }
        c(context, extras);
        return -1;
    }

    private final int g(Context context, Intent intent) {
        z2.l<Void> d10;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            d10 = z2.o.e(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            d10 = i.c(context).d(2, bundle);
        }
        int b10 = b(context, new a(intent));
        try {
            z2.o.b(d10, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Message ack failed: ");
            sb2.append(valueOf);
        }
        return b10;
    }

    protected Executor a() {
        return this.f15835a;
    }

    protected abstract int b(Context context, a aVar);

    protected abstract void c(Context context, Bundle bundle);

    protected abstract void d(Context context, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f(Intent intent, Context context, boolean z10, BroadcastReceiver.PendingResult pendingResult) {
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            int e10 = intent2 != null ? e(context, intent2) : g(context, intent);
            if (z10) {
                pendingResult.setResultCode(e10);
            }
        } finally {
            pendingResult.finish();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        a().execute(new Runnable(this, intent, context, isOrderedBroadcast, goAsync) { // from class: y1.h

            /* renamed from: f, reason: collision with root package name */
            private final b f15854f;

            /* renamed from: g, reason: collision with root package name */
            private final Intent f15855g;

            /* renamed from: h, reason: collision with root package name */
            private final Context f15856h;

            /* renamed from: i, reason: collision with root package name */
            private final boolean f15857i;

            /* renamed from: j, reason: collision with root package name */
            private final BroadcastReceiver.PendingResult f15858j;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f15854f = this;
                this.f15855g = intent;
                this.f15856h = context;
                this.f15857i = isOrderedBroadcast;
                this.f15858j = goAsync;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f15854f.f(this.f15855g, this.f15856h, this.f15857i, this.f15858j);
            }
        });
    }
}
