package h;

import F0.b3;
import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;

/* loaded from: classes.dex */
public final class v extends M1.f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4853c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y f4854d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4855e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(y yVar, b3 b3Var) {
        super(yVar);
        this.f4854d = yVar;
        this.f4855e = b3Var;
    }

    @Override // M1.f
    public final IntentFilter d() {
        switch (this.f4853c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARN: Type inference failed for: r3v11, types: [h.J, java.lang.Object] */
    @Override // M1.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.v.g():int");
    }

    @Override // M1.f
    public final void k() {
        switch (this.f4853c) {
            case 0:
                this.f4854d.n(true, true);
                return;
            default:
                this.f4854d.n(true, true);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(y yVar, Context context) {
        super(yVar);
        this.f4854d = yVar;
        this.f4855e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
