package com.groboot.mdaemergency.ptt;

import android.content.Context;
import com.groboot.mdaemergency.ptt.p;
import java.util.Date;
import w6.g0;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f7787a;

    /* renamed from: b, reason: collision with root package name */
    public w6.p f7788b;

    /* renamed from: c, reason: collision with root package name */
    public w6.p f7789c;

    /* renamed from: d, reason: collision with root package name */
    private j7.a f7790d;

    /* renamed from: e, reason: collision with root package name */
    public Date f7791e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.groboot.mdaemergency.ptt.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0107a implements p.b0 {
        C0107a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(p pVar) {
            pVar.m0(a.this);
        }
    }

    public w6.p a() {
        w6.p pVar = this.f7789c;
        return pVar != null ? pVar : this.f7788b;
    }

    public String b() {
        return this.f7787a;
    }

    public j7.a c() {
        return this.f7790d;
    }

    public j7.a d(Context context) {
        if (this.f7790d == null) {
            p.d0(context, new C0107a());
        }
        return this.f7790d;
    }

    public void e(Context context) {
        this.f7790d = null;
        d(context);
    }

    public boolean f() {
        Date date = this.f7791e;
        return date == null || g0.a(date).f15161e > 2.0d;
    }

    public void g() {
        this.f7791e = new Date();
    }

    public void h(j7.a aVar) {
        this.f7790d = aVar;
    }
}
