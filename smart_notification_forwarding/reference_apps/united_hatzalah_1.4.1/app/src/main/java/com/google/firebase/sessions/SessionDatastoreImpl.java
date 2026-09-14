package com.google.firebase.sessions;

import F2.p;
import P2.E;
import P2.G;
import R.InterfaceC0183h;
import S2.d;
import S2.e;
import S2.k;
import U.h;
import a.AbstractC0228a;
import com.google.firebase.annotations.concurrent.Background;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;
import x2.EnumC0779a;
import y2.AbstractC0787c;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

/* loaded from: classes.dex */
public final class SessionDatastoreImpl implements SessionDatastore {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "FirebaseSessionsRepo";
    private final InterfaceC0768i backgroundDispatcher;
    private final AtomicReference<FirebaseSessionsData> currentSessionFromDatastore;
    private final InterfaceC0183h dataStore;
    private final d firebaseSessionDataFlow;

    @InterfaceC0789e(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {84}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends AbstractC0793i implements p {
        int label;

        public AnonymousClass1(InterfaceC0763d interfaceC0763d) {
            super(2, interfaceC0763d);
        }

        @Override // y2.AbstractC0785a
        public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
            return new AnonymousClass1(interfaceC0763d);
        }

        @Override // F2.p
        public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
            return ((AnonymousClass1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
        }

        @Override // y2.AbstractC0785a
        public final Object invokeSuspend(Object obj) {
            EnumC0779a enumC0779a = EnumC0779a.f6740a;
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    AbstractC0228a.C(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                AbstractC0228a.C(obj);
                d dVar = SessionDatastoreImpl.this.firebaseSessionDataFlow;
                final SessionDatastoreImpl sessionDatastoreImpl = SessionDatastoreImpl.this;
                e eVar = new e() { // from class: com.google.firebase.sessions.SessionDatastoreImpl.1.1
                    @Override // S2.e
                    public final Object emit(FirebaseSessionsData firebaseSessionsData, InterfaceC0763d interfaceC0763d) {
                        SessionDatastoreImpl.this.currentSessionFromDatastore.set(firebaseSessionsData);
                        return C0684i.f6340a;
                    }
                };
                this.label = 1;
                if (dVar.collect(eVar, this) == enumC0779a) {
                    return enumC0779a;
                }
            }
            return C0684i.f6340a;
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

    /* loaded from: classes.dex */
    public static final class FirebaseSessionDataKeys {
        public static final FirebaseSessionDataKeys INSTANCE = new FirebaseSessionDataKeys();
        private static final U.f SESSION_ID = T.b.K("session_id");

        private FirebaseSessionDataKeys() {
        }

        public final U.f getSESSION_ID() {
            return SESSION_ID;
        }
    }

    public SessionDatastoreImpl(@Background InterfaceC0768i backgroundDispatcher, @SessionDetailsDataStore InterfaceC0183h dataStore) {
        j.e(backgroundDispatcher, "backgroundDispatcher");
        j.e(dataStore, "dataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.dataStore = dataStore;
        this.currentSessionFromDatastore = new AtomicReference<>();
        final k kVar = new k(dataStore.getData(), new SessionDatastoreImpl$firebaseSessionDataFlow$1(null));
        this.firebaseSessionDataFlow = new d() { // from class: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1

            /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements e {
                final /* synthetic */ e $this_unsafeFlow;
                final /* synthetic */ SessionDatastoreImpl this$0;

                @InterfaceC0789e(c = "com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2", f = "SessionDatastore.kt", l = {223}, m = "emit")
                /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends AbstractC0787c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC0763d interfaceC0763d) {
                        super(interfaceC0763d);
                    }

                    @Override // y2.AbstractC0785a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(e eVar, SessionDatastoreImpl sessionDatastoreImpl) {
                    this.$this_unsafeFlow = eVar;
                    this.this$0 = sessionDatastoreImpl;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // S2.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, w2.InterfaceC0763d r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = (com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = new com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        x2.a r1 = x2.EnumC0779a.f6740a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        a.AbstractC0228a.C(r6)
                        goto L45
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        a.AbstractC0228a.C(r6)
                        S2.e r6 = r4.$this_unsafeFlow
                        U.h r5 = (U.h) r5
                        com.google.firebase.sessions.SessionDatastoreImpl r2 = r4.this$0
                        com.google.firebase.sessions.FirebaseSessionsData r5 = com.google.firebase.sessions.SessionDatastoreImpl.access$mapSessionsData(r2, r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        s2.i r5 = s2.C0684i.f6340a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w2.d):java.lang.Object");
                }
            }

            @Override // S2.d
            public Object collect(e eVar, InterfaceC0763d interfaceC0763d) {
                Object collect = d.this.collect(new AnonymousClass2(eVar, this), interfaceC0763d);
                if (collect == EnumC0779a.f6740a) {
                    return collect;
                }
                return C0684i.f6340a;
            }
        };
        G.r(G.b(backgroundDispatcher), null, new AnonymousClass1(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FirebaseSessionsData mapSessionsData(h hVar) {
        return new FirebaseSessionsData((String) hVar.b(FirebaseSessionDataKeys.INSTANCE.getSESSION_ID()));
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public String getCurrentSessionId() {
        FirebaseSessionsData firebaseSessionsData = this.currentSessionFromDatastore.get();
        if (firebaseSessionsData != null) {
            return firebaseSessionsData.getSessionId();
        }
        return null;
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public void updateSessionId(String sessionId) {
        j.e(sessionId, "sessionId");
        G.r(G.b(this.backgroundDispatcher), null, new SessionDatastoreImpl$updateSessionId$1(this, sessionId, null), 3);
    }
}
