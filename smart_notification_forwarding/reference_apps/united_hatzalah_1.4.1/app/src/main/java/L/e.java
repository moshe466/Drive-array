package L;

import F0.C0035g2;
import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class e extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J0.d f1127a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InputConnection inputConnection, J0.d dVar) {
        super(inputConnection, false);
        this.f1127a = dVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        C0035g2 c0035g2 = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            c0035g2 = new C0035g2(new g(inputContentInfo), 4);
        }
        if (this.f1127a.d(c0035g2, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
