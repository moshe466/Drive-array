package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class FirebaseMessagingService extends g {

    /* renamed from: k, reason: collision with root package name */
    private static final Queue<String> f7399k = new ArrayDeque(10);

    private boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = f7399k;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() == 0) {
            return true;
        }
        "Received duplicate message: ".concat(valueOf);
        return true;
    }

    private void k(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (v.t(extras)) {
            v vVar = new v(extras);
            ExecutorService d10 = h.d();
            try {
                if (new c(this, vVar, d10).a()) {
                    return;
                }
                if (u.B(intent)) {
                    u.u(intent);
                }
            } finally {
                d10.shutdown();
            }
        }
        p(new w(extras));
    }

    private String l(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    private void m(Intent intent) {
        if (j(intent.getStringExtra("google.message_id"))) {
            return;
        }
        t(intent);
    }

    private void n(Intent intent) {
        if (u.B(intent)) {
            u.v(intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void t(Intent intent) {
        char c10;
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        if (c10 == 0) {
            u.w(intent);
            k(intent);
            return;
        }
        if (c10 == 1) {
            o();
            return;
        }
        if (c10 == 2) {
            q(intent.getStringExtra("google.message_id"));
        } else if (c10 == 3) {
            s(l(intent), new y(intent.getStringExtra("error")));
        } else if (stringExtra.length() != 0) {
            "Received message with unknown type: ".concat(stringExtra);
        }
    }

    @Override // com.google.firebase.messaging.g
    protected Intent c(Intent intent) {
        return com.google.firebase.iid.x.b().c();
    }

    @Override // com.google.firebase.messaging.g
    public void d(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            m(intent);
            return;
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
            if (u.B(intent)) {
                u.t(intent);
            }
        } else {
            if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                r(intent.getStringExtra("token"));
                return;
            }
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown intent action: ".concat(valueOf);
            }
        }
    }

    @Override // com.google.firebase.messaging.g
    public boolean e(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        n(intent);
        return true;
    }

    public void o() {
    }

    public void p(w wVar) {
    }

    public void q(String str) {
    }

    public void r(String str) {
    }

    public void s(String str, Exception exc) {
    }
}
