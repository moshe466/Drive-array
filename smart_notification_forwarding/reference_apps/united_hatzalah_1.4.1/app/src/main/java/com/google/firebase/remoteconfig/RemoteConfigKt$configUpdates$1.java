package com.google.firebase.remoteconfig;

import F2.p;
import a.AbstractC0228a;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.remoteconfig.RemoteConfigKt$configUpdates$1", f = "RemoteConfig.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RemoteConfigKt$configUpdates$1 extends AbstractC0793i implements p {
    final /* synthetic */ FirebaseRemoteConfig $this_configUpdates;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: com.google.firebase.remoteconfig.RemoteConfigKt$configUpdates$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends k implements F2.a {
        final /* synthetic */ ConfigUpdateListenerRegistration $registration;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConfigUpdateListenerRegistration configUpdateListenerRegistration) {
            super(0);
            this.$registration = configUpdateListenerRegistration;
        }

        @Override // F2.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m9invoke();
            return C0684i.f6340a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m9invoke() {
            this.$registration.remove();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteConfigKt$configUpdates$1(FirebaseRemoteConfig firebaseRemoteConfig, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.$this_configUpdates = firebaseRemoteConfig;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        RemoteConfigKt$configUpdates$1 remoteConfigKt$configUpdates$1 = new RemoteConfigKt$configUpdates$1(this.$this_configUpdates, interfaceC0763d);
        remoteConfigKt$configUpdates$1.L$0 = obj;
        return remoteConfigKt$configUpdates$1;
    }

    @Override // F2.p
    public final Object invoke(R2.p pVar, InterfaceC0763d interfaceC0763d) {
        return ((RemoteConfigKt$configUpdates$1) create(pVar, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
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
            R2.p pVar = (R2.p) this.L$0;
            FirebaseRemoteConfig firebaseRemoteConfig = this.$this_configUpdates;
            ConfigUpdateListenerRegistration addOnConfigUpdateListener = firebaseRemoteConfig.addOnConfigUpdateListener(new RemoteConfigKt$configUpdates$1$registration$1(firebaseRemoteConfig, pVar));
            j.d(addOnConfigUpdateListener, "FirebaseRemoteConfig.con…      }\n        }\n      )");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(addOnConfigUpdateListener);
            this.label = 1;
            if (AbstractC0228a.c(pVar, anonymousClass1, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
