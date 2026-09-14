package com.google.firebase.sessions;

import F2.p;
import P2.E;
import P2.G;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

/* loaded from: classes.dex */
public final class FirebaseSessions {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "FirebaseSessions";
    private final FirebaseApp firebaseApp;
    private final SessionsSettings settings;

    @InterfaceC0789e(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {51, 55}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends AbstractC0793i implements p {
        final /* synthetic */ InterfaceC0768i $backgroundDispatcher;
        final /* synthetic */ SessionLifecycleServiceBinder $lifecycleServiceBinder;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0768i interfaceC0768i, SessionLifecycleServiceBinder sessionLifecycleServiceBinder, InterfaceC0763d interfaceC0763d) {
            super(2, interfaceC0763d);
            this.$backgroundDispatcher = interfaceC0768i;
            this.$lifecycleServiceBinder = sessionLifecycleServiceBinder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(String str, FirebaseOptions firebaseOptions) {
            SessionsActivityLifecycleCallbacks.INSTANCE.setLifecycleClient(null);
        }

        @Override // y2.AbstractC0785a
        public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
            return new AnonymousClass1(this.$backgroundDispatcher, this.$lifecycleServiceBinder, interfaceC0763d);
        }

        @Override // F2.p
        public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
            return ((AnonymousClass1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
        
            if (r5.updateSettings(r4) == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0027, code lost:
        
            if (r5 == r0) goto L25;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.google.firebase.FirebaseAppLifecycleListener, java.lang.Object] */
        @Override // y2.AbstractC0785a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                x2.a r0 = x2.EnumC0779a.f6740a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                a.AbstractC0228a.C(r5)
                goto L5e
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L18:
                a.AbstractC0228a.C(r5)
                goto L2a
            L1c:
                a.AbstractC0228a.C(r5)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r5 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
                r4.label = r3
                java.lang.Object r5 = r5.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r4)
                if (r5 != r0) goto L2a
                goto L5d
            L2a:
                java.util.Map r5 = (java.util.Map) r5
                java.util.Collection r5 = r5.values()
                if (r5 == 0) goto L39
                boolean r1 = r5.isEmpty()
                if (r1 == 0) goto L39
                goto L8a
            L39:
                java.util.Iterator r5 = r5.iterator()
            L3d:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L8a
                java.lang.Object r1 = r5.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.isDataCollectionEnabled()
                if (r1 == 0) goto L3d
                com.google.firebase.sessions.FirebaseSessions r5 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r5 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r5)
                r4.label = r2
                java.lang.Object r5 = r5.updateSettings(r4)
                if (r5 != r0) goto L5e
            L5d:
                return r0
            L5e:
                com.google.firebase.sessions.FirebaseSessions r5 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r5 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r5)
                boolean r5 = r5.getSessionsEnabled()
                if (r5 != 0) goto L6b
                goto L8a
            L6b:
                com.google.firebase.sessions.SessionLifecycleClient r5 = new com.google.firebase.sessions.SessionLifecycleClient
                w2.i r0 = r4.$backgroundDispatcher
                r5.<init>(r0)
                com.google.firebase.sessions.SessionLifecycleServiceBinder r0 = r4.$lifecycleServiceBinder
                r5.bindToService(r0)
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks r0 = com.google.firebase.sessions.SessionsActivityLifecycleCallbacks.INSTANCE
                r0.setLifecycleClient(r5)
                com.google.firebase.sessions.FirebaseSessions r5 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.FirebaseApp r5 = com.google.firebase.sessions.FirebaseSessions.access$getFirebaseApp$p(r5)
                com.google.firebase.sessions.a r0 = new com.google.firebase.sessions.a
                r0.<init>()
                r5.addLifecycleEventListener(r0)
            L8a:
                s2.i r5 = s2.C0684i.f6340a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final FirebaseSessions getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessions.class);
            j.d(obj, "Firebase.app[FirebaseSessions::class.java]");
            return (FirebaseSessions) obj;
        }

        private Companion() {
        }
    }

    public FirebaseSessions(FirebaseApp firebaseApp, SessionsSettings settings, @Background InterfaceC0768i backgroundDispatcher, SessionLifecycleServiceBinder lifecycleServiceBinder) {
        j.e(firebaseApp, "firebaseApp");
        j.e(settings, "settings");
        j.e(backgroundDispatcher, "backgroundDispatcher");
        j.e(lifecycleServiceBinder, "lifecycleServiceBinder");
        this.firebaseApp = firebaseApp;
        this.settings = settings;
        Context applicationContext = firebaseApp.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.INSTANCE);
            G.r(G.b(backgroundDispatcher), null, new AnonymousClass1(backgroundDispatcher, lifecycleServiceBinder, null), 3);
        } else {
            Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
        }
    }
}
