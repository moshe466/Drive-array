package com.google.firebase.sessions;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import android.os.Message;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s2.C0684i;
import t2.AbstractC0707i;
import t2.C0703e;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;
import y2.InterfaceC0789e;

@InterfaceC0789e(c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", f = "SessionLifecycleClient.kt", l = {151}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SessionLifecycleClient$sendLifecycleEvents$1 extends AbstractC0793i implements p {
    final /* synthetic */ List<Message> $messages;
    int label;
    final /* synthetic */ SessionLifecycleClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionLifecycleClient$sendLifecycleEvents$1(SessionLifecycleClient sessionLifecycleClient, List<Message> list, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.this$0 = sessionLifecycleClient;
        this.$messages = list;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new SessionLifecycleClient$sendLifecycleEvents$1(this.this$0, this.$messages, interfaceC0763d);
    }

    @Override // F2.p
    public final Object invoke(E e4, InterfaceC0763d interfaceC0763d) {
        return ((SessionLifecycleClient$sendLifecycleEvents$1) create(e4, interfaceC0763d)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Collection values;
        Message latestByCode;
        Message latestByCode2;
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
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
            this.label = 1;
            obj = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (obj == enumC0779a) {
                return enumC0779a;
            }
        }
        Map map = (Map) obj;
        if (!map.isEmpty() && ((values = map.values()) == null || !values.isEmpty())) {
            Iterator it = values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((SessionSubscriber) it.next()).isDataCollectionEnabled()) {
                    latestByCode = this.this$0.getLatestByCode(this.$messages, 2);
                    latestByCode2 = this.this$0.getLatestByCode(this.$messages, 1);
                    List l02 = AbstractC0707i.l0(new Comparator() { // from class: com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t3, T t4) {
                            return AbstractC0228a.d(Long.valueOf(((Message) t3).getWhen()), Long.valueOf(((Message) t4).getWhen()));
                        }
                    }, AbstractC0707i.d0(new ArrayList(new C0703e(new Message[]{latestByCode, latestByCode2}, true))));
                    SessionLifecycleClient sessionLifecycleClient = this.this$0;
                    Iterator it2 = l02.iterator();
                    while (it2.hasNext()) {
                        sessionLifecycleClient.sendMessageToServer((Message) it2.next());
                    }
                }
            }
        }
        return C0684i.f6340a;
    }
}
