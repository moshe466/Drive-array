package com.opentok.android;

import android.os.Handler;
import com.opentok.android.Session;
import com.opentok.android.i;
import com.opentok.android.j;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public class PublisherKit implements Observer {

    /* renamed from: a, reason: collision with root package name */
    protected Handler f8513a;

    /* renamed from: b, reason: collision with root package name */
    protected d f8514b;

    /* renamed from: c, reason: collision with root package name */
    boolean f8515c;

    /* renamed from: d, reason: collision with root package name */
    boolean f8516d;

    /* renamed from: e, reason: collision with root package name */
    com.opentok.otc.a f8517e;

    /* renamed from: f, reason: collision with root package name */
    private final j.a f8518f;

    /* loaded from: classes.dex */
    static class a extends HashMap<c, z6.c> {
        a() {
            put(c.PublisherKitVideoTypeCamera, z6.c.f16243b);
            put(c.PublisherKitVideoTypeScreen, z6.c.f16244c);
        }
    }

    /* loaded from: classes.dex */
    static class b extends HashMap<z6.c, c> {
        b() {
            put(z6.c.f16243b, c.PublisherKitVideoTypeCamera);
            put(z6.c.f16244c, c.PublisherKitVideoTypeScreen);
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        PublisherKitVideoTypeCamera(1),
        PublisherKitVideoTypeScreen(2);

        private int videoType;

        c(int i10) {
            this.videoType = i10;
        }

        static c fromType(int i10) {
            for (c cVar : values()) {
                if (cVar.getVideoType() == i10) {
                    return cVar;
                }
            }
            throw new IllegalArgumentException("unknown type " + i10);
        }

        public int getVideoType() {
            return this.videoType;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(PublisherKit publisherKit, i iVar);
    }

    static {
        g.a();
        new a();
        new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(i iVar) {
        d dVar = this.f8514b;
        if (dVar != null) {
            dVar.a(this, iVar);
        }
    }

    public boolean e() {
        this.f8518f.b("getPublishVideo() called", new Object[0]);
        return Utils.c(com.opentok.otc.d.m(this.f8517e));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void c(i iVar) {
    }

    protected void finalize() {
        this.f8518f.b("finalize()", new Object[0]);
        super.finalize();
    }

    void g(String str, int i10) {
        final i iVar = new i(i.a.PublisherErrorDomain, i10, str);
        this.f8513a.post(new Runnable() { // from class: com.opentok.android.l
            @Override // java.lang.Runnable
            public final void run() {
                PublisherKit.this.c(iVar);
            }
        });
        if (this.f8514b != null) {
            this.f8513a.post(new Runnable() { // from class: com.opentok.android.m
                @Override // java.lang.Runnable
                public final void run() {
                    PublisherKit.this.d(iVar);
                }
            });
        }
    }

    public void h() {
        this.f8518f.b("onPause() called", new Object[0]);
        this.f8515c = e();
        j(false);
        this.f8516d = true;
    }

    public void i() {
        this.f8518f.b("onResume() called", new Object[0]);
        if (this.f8516d) {
            this.f8516d = false;
            j(this.f8515c);
        }
    }

    public void j(boolean z10) {
        this.f8518f.b("setPublishVideo(" + z10 + ") called", new Object[0]);
        com.opentok.otc.d.k(this.f8517e, Utils.a(z10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(i iVar) {
        g(iVar.f8595c, iVar.f8594b.ordinal());
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof Session) && (obj instanceof Session.e)) {
            if (((Session.e) obj).a()) {
                h();
            } else {
                i();
            }
        }
    }
}
