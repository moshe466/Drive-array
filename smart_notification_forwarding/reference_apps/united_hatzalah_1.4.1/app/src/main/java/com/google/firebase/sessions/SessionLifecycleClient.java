package com.google.firebase.sessions;

import P2.G;
import P2.InterfaceC0157i0;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class SessionLifecycleClient {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_QUEUED_MESSAGES = 20;
    public static final String TAG = "SessionLifecycleClient";
    private final InterfaceC0768i backgroundDispatcher;
    private final LinkedBlockingDeque<Message> queuedMessages;
    private Messenger service;
    private boolean serviceBound;
    private final SessionLifecycleClient$serviceConnection$1 serviceConnection;

    /* loaded from: classes.dex */
    public static final class ClientUpdateHandler extends Handler {
        private final InterfaceC0768i backgroundDispatcher;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(InterfaceC0768i backgroundDispatcher) {
            super(Looper.getMainLooper());
            j.e(backgroundDispatcher, "backgroundDispatcher");
            this.backgroundDispatcher = backgroundDispatcher;
        }

        private final void handleSessionUpdate(String str) {
            G.r(G.b(this.backgroundDispatcher), null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(str, null), 3);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            String str;
            j.e(msg, "msg");
            if (msg.what == 3) {
                Bundle data = msg.getData();
                if (data == null || (str = data.getString(SessionLifecycleService.SESSION_UPDATE_EXTRA)) == null) {
                    str = "";
                }
                handleSessionUpdate(str);
                return;
            }
            msg.toString();
            super.handleMessage(msg);
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1] */
    public SessionLifecycleClient(InterfaceC0768i backgroundDispatcher) {
        j.e(backgroundDispatcher, "backgroundDispatcher");
        this.backgroundDispatcher = backgroundDispatcher;
        this.queuedMessages = new LinkedBlockingDeque<>(20);
        this.serviceConnection = new ServiceConnection() { // from class: com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LinkedBlockingDeque linkedBlockingDeque;
                List drainQueue;
                linkedBlockingDeque = SessionLifecycleClient.this.queuedMessages;
                linkedBlockingDeque.size();
                SessionLifecycleClient.this.service = new Messenger(iBinder);
                SessionLifecycleClient.this.serviceBound = true;
                SessionLifecycleClient sessionLifecycleClient = SessionLifecycleClient.this;
                drainQueue = sessionLifecycleClient.drainQueue();
                sessionLifecycleClient.sendLifecycleEvents(drainQueue);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                SessionLifecycleClient.this.service = null;
                SessionLifecycleClient.this.serviceBound = false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Message> drainQueue() {
        ArrayList arrayList = new ArrayList();
        this.queuedMessages.drainTo(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Message getLatestByCode(List<Message> list, int i) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        return (Message) obj;
    }

    private final void queueMessage(Message message) {
        if (this.queuedMessages.offer(message)) {
            int i = message.what;
            this.queuedMessages.size();
        } else {
            int i3 = message.what;
        }
    }

    private final void sendLifecycleEvent(int i) {
        List<Message> drainQueue = drainQueue();
        Message obtain = Message.obtain(null, i, 0, 0);
        j.d(obtain, "obtain(null, messageCode, 0, 0)");
        drainQueue.add(obtain);
        sendLifecycleEvents(drainQueue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC0157i0 sendLifecycleEvents(List<Message> list) {
        return G.r(G.b(this.backgroundDispatcher), null, new SessionLifecycleClient$sendLifecycleEvents$1(this, list, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMessageToServer(Message message) {
        Messenger messenger = this.service;
        if (messenger != null) {
            try {
                int i = message.what;
                if (messenger != null) {
                    messenger.send(message);
                    return;
                }
                return;
            } catch (RemoteException unused) {
                int i3 = message.what;
                queueMessage(message);
                return;
            }
        }
        queueMessage(message);
    }

    public final void backgrounded() {
        sendLifecycleEvent(2);
    }

    public final void bindToService(SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        j.e(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.bindToService(new Messenger(new ClientUpdateHandler(this.backgroundDispatcher)), this.serviceConnection);
    }

    public final void foregrounded() {
        sendLifecycleEvent(1);
    }
}
