package q;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class z implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6050a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6051b;

    public z(C0601A c0601a) {
        this.f6051b = new WeakReference(c0601a);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f6050a) {
            case 0:
                WeakReference weakReference = (WeakReference) this.f6051b;
                if (weakReference.get() != null) {
                    ((C0601A) weakReference.get()).g(true);
                    return;
                }
                return;
            default:
                ((I) this.f6051b).f6013c.g(true);
                return;
        }
    }

    public z(I i) {
        this.f6051b = i;
    }
}
