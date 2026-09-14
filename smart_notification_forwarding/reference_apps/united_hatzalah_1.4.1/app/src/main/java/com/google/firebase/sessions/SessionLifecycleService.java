package com.google.firebase.sessions;

import O2.c;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import com.google.firebase.sessions.SessionGenerator;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class SessionLifecycleService extends Service {
    public static final int BACKGROUNDED = 2;
    private static final int CLIENT_BOUND = 4;
    public static final String CLIENT_CALLBACK_MESSENGER = "ClientCallbackMessenger";
    public static final Companion Companion = new Companion(null);
    public static final int FOREGROUNDED = 1;
    public static final int SESSION_UPDATED = 3;
    public static final String SESSION_UPDATE_EXTRA = "SessionUpdateExtra";
    public static final String TAG = "SessionLifecycleService";
    private final HandlerThread handlerThread = new HandlerThread("FirebaseSessions_HandlerThread");
    private MessageHandler messageHandler;
    private Messenger messenger;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class MessageHandler extends Handler {
        private final ArrayList<Messenger> boundClients;
        private boolean hasForegrounded;
        private long lastMsgTimeMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(Looper looper) {
            super(looper);
            j.e(looper, "looper");
            this.boundClients = new ArrayList<>();
        }

        private final void broadcastSession() {
            SessionFirelogPublisher.Companion.getInstance().logSession(SessionGenerator.Companion.getInstance().getCurrentSession());
            ArrayList arrayList = new ArrayList(this.boundClients);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Messenger it = (Messenger) obj;
                j.d(it, "it");
                maybeSendSessionToClient(it);
            }
        }

        private final void handleBackgrounding(Message message) {
            message.getWhen();
            this.lastMsgTimeMs = message.getWhen();
        }

        private final void handleClientBound(Message message) {
            this.boundClients.add(message.replyTo);
            Messenger messenger = message.replyTo;
            j.d(messenger, "msg.replyTo");
            maybeSendSessionToClient(messenger);
            Objects.toString(message.replyTo);
            message.getWhen();
            this.boundClients.size();
        }

        private final void handleForegrounding(Message message) {
            message.getWhen();
            if (!this.hasForegrounded) {
                this.hasForegrounded = true;
                newSession();
            } else if (isSessionRestart(message.getWhen())) {
                newSession();
            }
            this.lastMsgTimeMs = message.getWhen();
        }

        private final boolean isSessionRestart(long j2) {
            long c4;
            long j3 = j2 - this.lastMsgTimeMs;
            long m14getSessionRestartTimeoutUwyO8pc = SessionsSettings.Companion.getInstance().m14getSessionRestartTimeoutUwyO8pc();
            int i = O2.a.f1537d;
            if ((((int) m14getSessionRestartTimeoutUwyO8pc) & 1) == 1 && !O2.a.b(m14getSessionRestartTimeoutUwyO8pc)) {
                c4 = m14getSessionRestartTimeoutUwyO8pc >> 1;
            } else {
                c4 = O2.a.c(m14getSessionRestartTimeoutUwyO8pc, c.f1541c);
            }
            if (j3 > c4) {
                return true;
            }
            return false;
        }

        private final void maybeSendSessionToClient(Messenger messenger) {
            try {
                if (this.hasForegrounded) {
                    sendSessionToClient(messenger, SessionGenerator.Companion.getInstance().getCurrentSession().getSessionId());
                    return;
                }
                String currentSessionId = SessionDatastore.Companion.getInstance().getCurrentSessionId();
                if (currentSessionId != null) {
                    sendSessionToClient(messenger, currentSessionId);
                }
            } catch (IllegalStateException unused) {
            }
        }

        private final void newSession() {
            try {
                SessionGenerator.Companion companion = SessionGenerator.Companion;
                companion.getInstance().generateNewSession();
                broadcastSession();
                SessionDatastore.Companion.getInstance().updateSessionId(companion.getInstance().getCurrentSession().getSessionId());
            } catch (IllegalStateException unused) {
            }
        }

        private final void sendSessionToClient(Messenger messenger, String str) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(SessionLifecycleService.SESSION_UPDATE_EXTRA, str);
                Message obtain = Message.obtain(null, 3, 0, 0);
                obtain.setData(bundle);
                messenger.send(obtain);
            } catch (DeadObjectException unused) {
                Objects.toString(messenger);
                this.boundClients.remove(messenger);
            } catch (Exception unused2) {
                Objects.toString(messenger);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            j.e(msg, "msg");
            if (this.lastMsgTimeMs > msg.getWhen()) {
                msg.getWhen();
                return;
            }
            int i = msg.what;
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        msg.toString();
                        super.handleMessage(msg);
                        return;
                    } else {
                        handleClientBound(msg);
                        return;
                    }
                }
                handleBackgrounding(msg);
                return;
            }
            handleForegrounding(msg);
        }
    }

    private final Messenger getClientCallback(Intent intent) {
        Object parcelableExtra;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelableExtra = intent.getParcelableExtra(CLIENT_CALLBACK_MESSENGER, Messenger.class);
            return (Messenger) parcelableExtra;
        }
        return (Messenger) intent.getParcelableExtra(CLIENT_CALLBACK_MESSENGER);
    }

    public final HandlerThread getHandlerThread$com_google_firebase_firebase_sessions() {
        return this.handlerThread;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            return null;
        }
        intent.getAction();
        Messenger clientCallback = getClientCallback(intent);
        if (clientCallback != null) {
            Message obtain = Message.obtain(null, 4, 0, 0);
            obtain.replyTo = clientCallback;
            MessageHandler messageHandler = this.messageHandler;
            if (messageHandler != null) {
                messageHandler.sendMessage(obtain);
            }
        }
        Messenger messenger = this.messenger;
        if (messenger == null) {
            return null;
        }
        return messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.handlerThread.start();
        Looper looper = this.handlerThread.getLooper();
        j.d(looper, "handlerThread.looper");
        this.messageHandler = new MessageHandler(looper);
        this.messenger = new Messenger(this.messageHandler);
        Process.myPid();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handlerThread.quit();
    }
}
