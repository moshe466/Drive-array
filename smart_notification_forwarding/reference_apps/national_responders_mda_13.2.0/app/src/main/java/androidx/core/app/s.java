package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class s {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(s sVar) {
            throw null;
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static RemoteInput a(s sVar) {
        return a.b(sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] b(s[] sVarArr) {
        if (sVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[sVarArr.length];
        for (int i10 = 0; i10 < sVarArr.length; i10++) {
            remoteInputArr[i10] = a(sVarArr[i10]);
        }
        return remoteInputArr;
    }
}
