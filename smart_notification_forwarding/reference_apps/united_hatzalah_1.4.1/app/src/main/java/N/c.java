package N;

import F2.l;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.ResultReceiver;
import androidx.credentials.playservices.HiddenActivity;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import s2.C0684i;

/* loaded from: classes.dex */
public final class c extends k implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1419a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HiddenActivity f1420b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1421c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(HiddenActivity hiddenActivity, int i, int i3) {
        super(1);
        this.f1419a = i3;
        this.f1420b = hiddenActivity;
        this.f1421c = i;
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        switch (this.f1419a) {
            case 0:
                HiddenActivity hiddenActivity = this.f1420b;
                BeginSignInResult beginSignInResult = (BeginSignInResult) obj;
                try {
                    hiddenActivity.f3086b = true;
                    hiddenActivity.startIntentSenderForResult(beginSignInResult.getPendingIntent().getIntentSender(), this.f1421c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e4) {
                    ResultReceiver resultReceiver = hiddenActivity.f3085a;
                    j.b(resultReceiver);
                    hiddenActivity.a(resultReceiver, "GET_UNKNOWN", "During begin sign in, one tap ui intent sender failure: " + e4.getMessage());
                }
                return C0684i.f6340a;
            case 1:
                HiddenActivity hiddenActivity2 = this.f1420b;
                SavePasswordResult savePasswordResult = (SavePasswordResult) obj;
                try {
                    hiddenActivity2.f3086b = true;
                    hiddenActivity2.startIntentSenderForResult(savePasswordResult.getPendingIntent().getIntentSender(), this.f1421c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e5) {
                    ResultReceiver resultReceiver2 = hiddenActivity2.f3085a;
                    j.b(resultReceiver2);
                    hiddenActivity2.a(resultReceiver2, "CREATE_UNKNOWN", "During save password, found UI intent sender failure: " + e5.getMessage());
                }
                return C0684i.f6340a;
            case 2:
                HiddenActivity hiddenActivity3 = this.f1420b;
                PendingIntent result = (PendingIntent) obj;
                j.e(result, "result");
                try {
                    hiddenActivity3.f3086b = true;
                    hiddenActivity3.startIntentSenderForResult(result.getIntentSender(), this.f1421c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e6) {
                    ResultReceiver resultReceiver3 = hiddenActivity3.f3085a;
                    j.b(resultReceiver3);
                    hiddenActivity3.a(resultReceiver3, "CREATE_UNKNOWN", "During public key credential, found IntentSender failure on public key creation: " + e6.getMessage());
                }
                return C0684i.f6340a;
            default:
                HiddenActivity hiddenActivity4 = this.f1420b;
                PendingIntent pendingIntent = (PendingIntent) obj;
                try {
                    hiddenActivity4.f3086b = true;
                    hiddenActivity4.startIntentSenderForResult(pendingIntent.getIntentSender(), this.f1421c, null, 0, 0, 0, null);
                } catch (IntentSender.SendIntentException e7) {
                    ResultReceiver resultReceiver4 = hiddenActivity4.f3085a;
                    j.b(resultReceiver4);
                    hiddenActivity4.a(resultReceiver4, "GET_UNKNOWN", "During get sign-in intent, one tap ui intent sender failure: " + e7.getMessage());
                }
                return C0684i.f6340a;
        }
    }
}
