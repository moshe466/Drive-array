package X;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class h extends V.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2569a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f2570b;

    public h(EditText editText) {
        this.f2570b = new WeakReference(editText);
    }

    @Override // V.h
    public void a() {
        switch (this.f2569a) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.f2570b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // V.h
    public final void b() {
        switch (this.f2569a) {
            case 0:
                i.a((EditText) this.f2570b.get(), 1);
                return;
            default:
                SwitchCompat switchCompat = (SwitchCompat) this.f2570b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    return;
                }
                return;
        }
    }

    public h(SwitchCompat switchCompat) {
        this.f2570b = new WeakReference(switchCompat);
    }
}
