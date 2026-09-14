package com.groboot.mdaemergency.async;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Environment;
import androidx.core.app.k;
import il.org.mda.health.R;
import java.io.File;
import java.util.UUID;
import w6.h;
import w6.l0;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    Context f7593a;

    /* renamed from: c, reason: collision with root package name */
    public String f7595c;

    /* renamed from: d, reason: collision with root package name */
    public String f7596d;

    /* renamed from: e, reason: collision with root package name */
    public String f7597e;

    /* renamed from: h, reason: collision with root package name */
    String f7600h;

    /* renamed from: i, reason: collision with root package name */
    public String f7601i;

    /* renamed from: g, reason: collision with root package name */
    public b f7599g = b.none;

    /* renamed from: f, reason: collision with root package name */
    public UUID f7598f = UUID.randomUUID();

    /* renamed from: b, reason: collision with root package name */
    int f7594b = t6.d.a();

    /* renamed from: com.groboot.mdaemergency.async.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0097a implements h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k.e f7602a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NotificationManager f7603b;

        C0097a(k.e eVar, NotificationManager notificationManager) {
            this.f7602a = eVar;
            this.f7603b = notificationManager;
        }

        @Override // w6.h.a
        public void a(h hVar, int i10, int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("downloading... ");
            sb2.append(i10);
            sb2.append("/");
            sb2.append(i11);
            this.f7602a.u(i11, i10, false);
            this.f7603b.notify(a.this.f7594b, this.f7602a.b());
        }

        @Override // w6.h.a
        public void b(h hVar, String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("download failed. ");
            sb2.append(str);
            a aVar = a.this;
            aVar.f7599g = b.error;
            this.f7602a.j(aVar.f7593a.getString(R.string.download_failed)).u(0, 0, false).w(R.drawable.icon_15_gray);
            this.f7603b.notify(a.this.f7594b, this.f7602a.b());
        }

        @Override // w6.h.a
        public void c(h hVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("download to:");
            sb2.append(a.this.f7601i);
            sb2.append("success");
            a.this.f7599g = b.success;
            this.f7602a.j("ההורדה הושלמה").u(0, 0, false);
            this.f7603b.notify(a.this.f7594b, this.f7602a.b());
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        none,
        downloading,
        success,
        error
    }

    public a(Context context, String str, String str2, String str3, String str4) {
        this.f7595c = str3;
        this.f7596d = str2;
        this.f7597e = str;
        this.f7593a = context;
        l0.l0(str4);
        this.f7600h = Environment.getExternalStorageDirectory() + "/" + str4;
        this.f7601i = this.f7600h + "/" + str3;
    }

    public void a() {
        this.f7599g = b.downloading;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("start:");
        sb2.append(this.f7595c);
        NotificationManager notificationManager = (NotificationManager) this.f7593a.getSystemService("notification");
        k.e eVar = new k.e(this.f7593a);
        eVar.k(this.f7596d).j("מוריד קובץ  " + this.f7595c).w(R.drawable.icon_15);
        File file = new File(this.f7600h);
        if (!(!file.exists() ? file.mkdir() : true)) {
            eVar.j(this.f7593a.getString(R.string.error_access_to) + this.f7600h).u(0, 0, false);
            notificationManager.notify(this.f7594b, eVar.b());
            this.f7599g = b.error;
            return;
        }
        File file2 = new File(this.f7601i);
        while (file2.exists()) {
            this.f7601i = this.f7601i.replace("/" + file + "/", "/" + file + "/_");
            file2 = new File(this.f7601i);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("download to:");
        sb3.append(this.f7601i);
        new h(this.f7601i, this.f7597e, false, new C0097a(eVar, notificationManager)).g();
    }
}
