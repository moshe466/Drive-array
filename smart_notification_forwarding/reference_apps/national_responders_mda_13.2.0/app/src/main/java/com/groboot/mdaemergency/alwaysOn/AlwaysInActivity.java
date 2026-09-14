package com.groboot.mdaemergency.alwaysOn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.groboot.mdaemergency.alwaysOn.c;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Objects;
import w6.m;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class AlwaysInActivity extends androidx.appcompat.app.c implements c {
    public static final String E;
    private String A;
    private String B;
    private d C;
    public com.groboot.mdaemergency.alwaysOn.b D;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements d {
        b() {
        }

        @Override // com.groboot.mdaemergency.alwaysOn.d
        public void close() {
            AlwaysInActivity.this.z0();
        }
    }

    static {
        new a(null);
        E = "extraViewType";
    }

    public AlwaysInActivity() {
        new LinkedHashMap();
        this.A = "[AlwaysInActivity]";
        this.B = k.j(p5.d.f13074j, "[AlwaysInActivity]");
        this.C = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(AlwaysInActivity alwaysInActivity) {
        k.e(alwaysInActivity, "this$0");
        String str = alwaysInActivity.B;
        LockPatternActivity.B();
        alwaysInActivity.z0();
    }

    public final com.groboot.mdaemergency.alwaysOn.b A0() {
        com.groboot.mdaemergency.alwaysOn.b bVar = this.D;
        if (bVar != null) {
            return bVar;
        }
        k.o("alwaysOnBaseView");
        return null;
    }

    @Override // com.groboot.mdaemergency.alwaysOn.c
    public d B() {
        return this.C;
    }

    public com.groboot.mdaemergency.alwaysOn.b B0(e eVar) {
        return c.a.b(this, eVar);
    }

    public com.groboot.mdaemergency.alwaysOn.b C0(e eVar) {
        return c.a.c(this, eVar);
    }

    public final void E0(com.groboot.mdaemergency.alwaysOn.b bVar) {
        k.e(bVar, "<set-?>");
        this.D = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.groboot.mdaemergency.alwaysOn.b B0;
        super.onCreate(bundle);
        if (!m.i()) {
            getWindow().setFlags(8192, 8192);
        }
        requestWindowFeature(1);
        Intent intent = getIntent();
        String str = E;
        if (intent.hasExtra(str)) {
            Serializable serializableExtra = getIntent().getSerializableExtra(str);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.groboot.mdaemergency.alwaysOn.eAlwaysOnViewType");
            e eVar = (e) serializableExtra;
            if (eVar != e.TRAVEL_NOTIFICATION) {
                if (eVar == e.EXTERNAL_MESSAGE) {
                    B0 = B0(eVar);
                }
                setContentView(A0());
                getWindow().setLayout(eVar.getWidth(this), eVar.getHeight(this));
                new Handler().postDelayed(new Runnable() { // from class: com.groboot.mdaemergency.alwaysOn.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AlwaysInActivity.D0(AlwaysInActivity.this);
                    }
                }, m.z());
            }
            B0 = C0(eVar);
            E0(B0);
            setContentView(A0());
            getWindow().setLayout(eVar.getWidth(this), eVar.getHeight(this));
            new Handler().postDelayed(new Runnable() { // from class: com.groboot.mdaemergency.alwaysOn.a
                @Override // java.lang.Runnable
                public final void run() {
                    AlwaysInActivity.D0(AlwaysInActivity.this);
                }
            }, m.z());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.groboot.mdaemergency.alwaysOn.c
    public com.groboot.mdaemergency.alwaysOn.b t(e eVar) {
        return c.a.a(this, eVar);
    }

    public final void z0() {
        finish();
    }
}
