package x7;

import android.telephony.PhoneStateListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h extends PhoneStateListener {

    /* renamed from: c, reason: collision with root package name */
    private static final ic.b f15525c = ic.c.i(h.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    private int f15526a = 0;

    /* renamed from: b, reason: collision with root package name */
    private List<a> f15527b = Collections.synchronizedList(new ArrayList());

    /* loaded from: classes.dex */
    protected interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.f15527b.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar) {
        this.f15527b.remove(aVar);
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i10, String str) {
        super.onCallStateChanged(i10, str);
        if (this.f15526a != i10) {
            if (i10 == 0) {
                f15525c.c("PhoneCallEndDetector.onCallStateChanged({}, {})", Integer.valueOf(i10), str);
                Iterator<a> it = this.f15527b.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
            this.f15526a = i10;
        }
    }
}
