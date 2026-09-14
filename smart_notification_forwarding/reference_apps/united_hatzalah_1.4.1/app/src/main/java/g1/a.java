package g1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public final class a extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4663a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E1.e f4664b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(E1.e eVar, int i) {
        super(0);
        this.f4663a = i;
        this.f4664b = eVar;
    }

    @Override // F2.a
    public final Object invoke() {
        int i = this.f4663a;
        E1.e eVar = this.f4664b;
        switch (i) {
            case 0:
                Intent registerReceiver = eVar.f134a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                kotlin.jvm.internal.j.b(registerReceiver);
                int intExtra = registerReceiver.getIntExtra("health", -1);
                if (intExtra != -1) {
                    switch (intExtra) {
                        case 2:
                            return "good";
                        case 3:
                            return "overheat";
                        case 4:
                            return "dead";
                        case 5:
                            return "over voltage";
                        case 6:
                            return "unspecified failure";
                        case 7:
                            return "cold";
                        default:
                            return "unknown";
                    }
                }
                return "";
            default:
                Object invoke = Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(eVar.f134a), null);
                kotlin.jvm.internal.j.c(invoke, "null cannot be cast to non-null type kotlin.Double");
                return String.valueOf(((Double) invoke).doubleValue());
        }
    }
}
