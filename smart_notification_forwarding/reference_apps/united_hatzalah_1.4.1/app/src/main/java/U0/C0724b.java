package u0;

import android.os.Build;

/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0724b extends AbstractC0725c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6558d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0724b(int i, String str, String str2) {
        super(str, str2);
        this.f6558d = i;
    }

    @Override // u0.AbstractC0725c
    public final boolean a() {
        switch (this.f6558d) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return false;
            case 3:
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
                return false;
            case 4:
                if (Build.VERSION.SDK_INT >= 27) {
                    return true;
                }
                return false;
            case 5:
                if (Build.VERSION.SDK_INT >= 28) {
                    return true;
                }
                return false;
            default:
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return false;
        }
    }
}
