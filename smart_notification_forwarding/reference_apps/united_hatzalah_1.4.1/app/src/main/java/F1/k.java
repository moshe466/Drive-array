package F1;

import F0.C0035g2;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.install.zza;
import com.uh.sf.TransparencyView;
import java.util.HashSet;
import java.util.Iterator;
import k2.C0493c;

/* loaded from: classes.dex */
public final class k extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f740a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f741b;

    public /* synthetic */ k(Object obj, int i) {
        this.f740a = i;
        this.f741b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f740a) {
            case 0:
                E1.c cVar = (E1.c) this.f741b;
                if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
                    cVar.f126a.w("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
                    return;
                }
                cVar.f126a.w("List of extras in received intent:", new Object[0]);
                for (String str : intent.getExtras().keySet()) {
                    cVar.f126a.w("Key: %s; value: %s", str, intent.getExtras().get(str));
                }
                C0035g2 c0035g2 = cVar.f126a;
                c0035g2.w("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
                c0035g2.w("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
                c0035g2.w("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
                zza zzaVar = new zza(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
                cVar.f126a.w("ListenerRegistryBroadcastReceiver.onReceive: %s", zzaVar);
                synchronized (cVar) {
                    Iterator it = new HashSet(cVar.f129d).iterator();
                    while (it.hasNext()) {
                        ((C0493c) it.next()).a(zzaVar);
                    }
                }
                return;
            case 1:
                ((M1.f) this.f741b).k();
                return;
            default:
                kotlin.jvm.internal.j.e(context, "context");
                kotlin.jvm.internal.j.e(intent, "intent");
                TransparencyView transparencyView = (TransparencyView) this.f741b;
                int i = TransparencyView.f4407b;
                transparencyView.finishAndRemoveTask();
                return;
        }
    }
}
