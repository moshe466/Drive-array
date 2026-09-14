package com.groboot.mdaemergency.ptt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import w6.d0;
import w6.l0;
import w6.r;
import w6.v;
import w6.x;
import w6.y;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    String f7824a = "PTTContactsManager";

    /* renamed from: b, reason: collision with root package name */
    Context f7825b;

    /* renamed from: c, reason: collision with root package name */
    public w6.r f7826c;

    /* renamed from: d, reason: collision with root package name */
    public w6.s f7827d;

    /* renamed from: e, reason: collision with root package name */
    InterfaceC0112d f7828e;

    /* renamed from: f, reason: collision with root package name */
    Hashtable<String, v> f7829f;

    /* renamed from: g, reason: collision with root package name */
    boolean f7830g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("userId");
            String stringExtra2 = intent.getStringExtra("status");
            String stringExtra3 = intent.getStringExtra("ts");
            String str = d.this.f7824a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContactsStatusChange userId:");
            sb2.append(stringExtra);
            sb2.append(" status:");
            sb2.append(stringExtra2);
            sb2.append(" ts:");
            sb2.append(stringExtra3);
            if (l0.l0(stringExtra)) {
                return;
            }
            Iterator<w6.p> it = d.this.f7826c.iterator();
            while (it.hasNext()) {
                w6.p next = it.next();
                if (l0.l(next.f15235a, stringExtra)) {
                    next.f15241g = Integer.valueOf(l0.U(stringExtra2));
                    d.this.f7828e.b(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements d.t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7832a;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d0.a(10000L);
                b bVar = b.this;
                d.this.r(bVar.f7832a + 1);
            }
        }

        b(int i10) {
            this.f7832a = i10;
        }

        @Override // com.groboot.mdaemergency.async.d.t
        public void a(y.a aVar) {
            d dVar = d.this;
            dVar.f7830g = false;
            String str = dVar.f7824a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("received contacts:");
            sb2.append(d.this.f7826c.size());
            sb2.append(" favorites:");
            throw null;
        }

        @Override // com.groboot.mdaemergency.async.d.t
        public void b() {
            w6.r rVar;
            if (this.f7832a > 3 || ((rVar = d.this.f7826c) != null && rVar.size() > 0)) {
                d dVar = d.this;
                dVar.f7830g = false;
                String str = dVar.f7824a;
                return;
            }
            String str2 = d.this.f7824a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("received no contacts. try again. num:");
            sb2.append(this.f7832a + 1);
            new Thread(new a()).start();
            w6.r rVar2 = d.this.f7826c;
            if (rVar2 == null || rVar2.size() == 0) {
                d dVar2 = d.this;
                dVar2.f7828e.a(dVar2.f7825b.getString(R.string.missing_contacts_list_try_again));
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements r.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r.b f7835a;

        c(r.b bVar) {
            this.f7835a = bVar;
        }

        @Override // w6.r.b
        public void a(w6.r rVar) {
            if (rVar.size() > 10) {
                this.f7835a.a(rVar);
                return;
            }
            w6.r rVar2 = new w6.r();
            ArrayList arrayList = new ArrayList();
            Iterator<w6.p> it = rVar.iterator();
            while (it.hasNext()) {
                w6.p next = it.next();
                rVar2.add(next);
                arrayList.add(next.f15235a);
            }
            w6.r f10 = d.this.f();
            if (f10.size() > 0) {
                w6.p pVar = new w6.p();
                pVar.f15239e = 21;
                pVar.f15238d = "תכיפות קשר גבוהה";
                rVar2.add(pVar);
            }
            Iterator<w6.p> it2 = f10.iterator();
            while (it2.hasNext()) {
                w6.p next2 = it2.next();
                if (!arrayList.contains(next2.f15235a)) {
                    rVar2.add(next2);
                }
            }
            this.f7835a.a(rVar2);
        }
    }

    /* renamed from: com.groboot.mdaemergency.ptt.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0112d {
        void a(String str);

        void b(w6.p pVar);
    }

    /* loaded from: classes.dex */
    public enum e {
        None,
        Alwaze,
        minutes_2
    }

    public d(Context context, x7.a aVar, InterfaceC0112d interfaceC0112d) {
        this.f7825b = context;
        this.f7828e = interfaceC0112d;
        w6.s sVar = new w6.s();
        this.f7827d = sVar;
        sVar.addAll(x.H().D());
        this.f7829f = new Hashtable<>();
        this.f7826c = new w6.r();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w6.r f() {
        w6.q[] qVarArr = new w6.q[3];
        for (int i10 = 0; i10 < 3; i10++) {
            qVarArr[i10] = new w6.q();
        }
        Iterator<w6.q> it = this.f7827d.iterator();
        while (it.hasNext()) {
            w6.q next = it.next();
            for (int i11 = 0; i11 < 3; i11++) {
                if (qVarArr[i11].f15246j < next.f15244h) {
                    w6.q qVar = qVarArr[i11];
                    qVarArr[i11] = next;
                    next = qVar;
                }
            }
        }
        w6.r rVar = new w6.r();
        for (int i12 = 0; i12 < 3; i12++) {
            if (!l0.l0(qVarArr[i12].f15235a)) {
                rVar.add(qVarArr[i12]);
            }
        }
        return rVar;
    }

    private d.t m(int i10) {
        return new b(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(int i10) {
        com.groboot.mdaemergency.async.d.v().H(x.H().v(), k(), m(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final int i10) {
        if (this.f7830g) {
            return;
        }
        this.f7830g = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("tryNumber:");
        sb2.append(i10);
        new Thread(new Runnable() { // from class: x5.b
            @Override // java.lang.Runnable
            public final void run() {
                com.groboot.mdaemergency.ptt.d.this.o(i10);
            }
        }).start();
    }

    private void s() {
        if (this.f7829f == null) {
            this.f7829f = new Hashtable<>();
            Iterator<v> it = x.H().j().iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (!this.f7829f.containsKey(next.f15263a)) {
                    this.f7829f.put(next.f15263a, next);
                }
            }
        }
    }

    private void t() {
        this.f7825b.registerReceiver(new a(), new IntentFilter("il.org.mda.ptt.sdk.mada.android.USER_STATUS"));
    }

    public void e(w6.p pVar, int i10) {
        w6.q qVar = new w6.q();
        qVar.f15235a = pVar.f15235a;
        qVar.f15238d = pVar.f15238d;
        qVar.f15236b = pVar.f15236b;
        qVar.f15237c = pVar.f15237c;
        qVar.f15244h = i10;
        qVar.f15245i = l0.w();
        Iterator<w6.q> it = this.f7827d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            w6.q next = it.next();
            if (next.f15235a.equals(qVar.f15235a)) {
                qVar.f15246j = next.f15246j + 1;
                this.f7827d.remove(next);
                break;
            }
        }
        this.f7827d.add(0, qVar);
        x.H().d(qVar);
    }

    public w6.p g(String str) {
        Iterator<w6.p> it = this.f7826c.iterator();
        while (it.hasNext()) {
            w6.p next = it.next();
            if (next.f15235a.indexOf(str) > -1) {
                return next;
            }
        }
        return null;
    }

    public w6.p h(String str) {
        Iterator<w6.p> it = this.f7826c.iterator();
        while (it.hasNext()) {
            w6.p next = it.next();
            if (next.f15238d.indexOf(str) > -1 || next.f15237c.indexOf(str) > -1) {
                return next;
            }
        }
        return null;
    }

    public w6.q i(String str) {
        if (l0.l0(str)) {
            return null;
        }
        Iterator<w6.q> it = this.f7827d.iterator();
        while (it.hasNext()) {
            w6.q next = it.next();
            if (l0.l(next.f15235a, str)) {
                return next;
            }
        }
        return null;
    }

    public w6.q j(w6.p pVar) {
        w6.s sVar = this.f7827d;
        if (sVar != null && pVar != null) {
            Iterator<w6.q> it = sVar.iterator();
            while (it.hasNext()) {
                w6.q next = it.next();
                if (l0.l(next.f15235a, pVar.f15235a)) {
                    return next;
                }
            }
        }
        return null;
    }

    public w6.r k() {
        w6.r rVar = new w6.r();
        Iterator<w6.q> it = this.f7827d.iterator();
        while (it.hasNext()) {
            rVar.add(it.next());
        }
        return rVar;
    }

    public void l(r.b bVar) {
        this.f7826c.l(new c(bVar));
    }

    public boolean n(String str) {
        if (l0.l0(str)) {
            return false;
        }
        s();
        if (!this.f7829f.containsKey(str)) {
            return false;
        }
        if (!this.f7829f.get(str).e()) {
            return true;
        }
        u(str, e.None);
        return false;
    }

    public void q() {
        r(0);
    }

    public void u(String str, e eVar) {
        if (this.f7829f.containsKey(str)) {
            this.f7829f.remove(str);
            x.H().a0(str);
        }
        if (eVar == e.None) {
            return;
        }
        v c10 = eVar == e.minutes_2 ? v.c(str, 2) : v.b(str);
        this.f7829f.put(str, c10);
        x.H().f(c10);
    }

    public void v(w6.p pVar, boolean z10) {
        pVar.f15240f = z10;
        com.groboot.mdaemergency.async.d.v().v0(pVar.f15235a, z10, new b.InterfaceC0098b() { // from class: x5.a
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                aVar.f7614b;
            }
        });
        if (!z10) {
            x.H().b0(pVar);
            return;
        }
        this.f7826c.x(pVar.f15235a);
        this.f7826c.add(pVar);
        x.H().c0(pVar);
    }

    public void w(w6.p pVar, String str, Date date) {
        w6.q i10 = i(pVar.f15235a);
        if (i10 == null) {
            return;
        }
        i10.f15247k = date;
        i10.f15250n = str;
        i10.f15248l = 0;
        x.H().d(i10);
    }

    public boolean x(String str, String str2) {
        w6.q i10 = i(str);
        if (i10 == null || i10.f15247k == null) {
            return false;
        }
        if (i10.f15250n.equals(str2)) {
            i10.f15248l++;
            x.H().d(i10);
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("updateContactHeard() messageId not match, lastMessageId: ");
        sb2.append(i10.f15250n);
        sb2.append(", messageId:");
        sb2.append(str2);
        return false;
    }
}
