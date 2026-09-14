package h;

import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import k.AbstractC0458b;
import m.n1;

/* renamed from: h.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0433c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4780b;

    public /* synthetic */ ViewOnClickListenerC0433c(Object obj, int i) {
        this.f4779a = i;
        this.f4780b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        Message message4;
        l.o oVar;
        switch (this.f4779a) {
            case 0:
                C0437g c0437g = (C0437g) this.f4780b;
                if (view == c0437g.i && (message4 = c0437g.f4813k) != null) {
                    message = Message.obtain(message4);
                } else if (view == c0437g.f4814l && (message3 = c0437g.f4816n) != null) {
                    message = Message.obtain(message3);
                } else if (view == c0437g.f4817o && (message2 = c0437g.f4818q) != null) {
                    message = Message.obtain(message2);
                } else {
                    message = null;
                }
                if (message != null) {
                    message.sendToTarget();
                }
                c0437g.f4802E.obtainMessage(1, c0437g.f4805b).sendToTarget();
                return;
            case 1:
                ((AbstractC0458b) this.f4780b).a();
                return;
            default:
                n1 n1Var = ((Toolbar) this.f4780b).f2978P;
                if (n1Var == null) {
                    oVar = null;
                } else {
                    oVar = n1Var.f5731b;
                }
                if (oVar != null) {
                    oVar.collapseActionView();
                    return;
                }
                return;
        }
    }
}
