package io.flutter.embedding.android;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.embedding.android.KeyboardMap;
import o1.j;
import org.json.JSONObject;
import s2.C0679d;
import t2.u;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5010a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5011b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5012c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f5013d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f5014e;

    public /* synthetic */ c(Object obj, Object obj2, long j2, Object obj3, int i) {
        this.f5010a = i;
        this.f5011b = obj;
        this.f5012c = obj2;
        this.f5013d = j2;
        this.f5014e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        boolean z3;
        Window window;
        WindowManager.LayoutParams attributes;
        switch (this.f5010a) {
            case 0:
                KeyEmbedderResponder.b((KeyEmbedderResponder) this.f5011b, (KeyboardMap.KeyPair) this.f5012c, this.f5013d, (KeyEvent) this.f5014e);
                return;
            case 1:
                KeyEmbedderResponder.a((KeyEmbedderResponder) this.f5011b, (KeyboardMap.KeyPair) this.f5012c, this.f5013d, (KeyEvent) this.f5014e);
                return;
            default:
                j jVar = (j) this.f5011b;
                String str = (String) this.f5012c;
                String str2 = (String) this.f5014e;
                Activity activity = jVar.f5933c;
                boolean z4 = false;
                if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                    i = attributes.flags;
                } else {
                    i = 0;
                }
                if ((i & UserMetadata.MAX_INTERNAL_KEY_SIZE) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                C0679d c0679d = new C0679d("is_screenshot_on", Boolean.valueOf(z3));
                C0679d c0679d2 = new C0679d("screenshot_path", str);
                if (str.length() > 0) {
                    z4 = true;
                }
                String jSONObject = new JSONObject(u.G(c0679d, c0679d2, new C0679d("was_screenshot_taken", Boolean.valueOf(z4)), new C0679d("is_screen_recording", Boolean.valueOf(jVar.f5948v)), new C0679d("timestamp", Long.valueOf(this.f5013d)), new C0679d("source_app", str2))).toString();
                kotlin.jvm.internal.j.d(jSONObject, "toString(...)");
                if (!kotlin.jvm.internal.j.a(jVar.f5938k, jSONObject)) {
                    jVar.f5939l = true;
                    jVar.f5938k = jSONObject;
                    return;
                }
                return;
        }
    }
}
