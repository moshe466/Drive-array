package androidx.credentials.playservices;

import J0.d;
import N.c;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.credentials.playservices.HiddenActivity;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public class HiddenActivity extends Activity {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3084c = 0;

    /* renamed from: a, reason: collision with root package name */
    public ResultReceiver f3085a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3086b;

    public final void a(ResultReceiver resultReceiver, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("FAILURE_RESPONSE", true);
        bundle.putString("EXCEPTION_TYPE", str);
        bundle.putString("EXCEPTION_MESSAGE", str2);
        resultReceiver.send(Api.BaseClientBuilder.API_PRIORITY_OTHER, bundle);
        finish();
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i3, Intent intent) {
        super.onActivityResult(i, i3, intent);
        Bundle bundle = new Bundle();
        bundle.putBoolean("FAILURE_RESPONSE", false);
        bundle.putInt("ACTIVITY_REQUEST_CODE", i);
        bundle.putParcelable("RESULT_DATA", intent);
        ResultReceiver resultReceiver = this.f3085a;
        if (resultReceiver != null) {
            resultReceiver.send(i3, bundle);
        }
        this.f3086b = false;
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        String stringExtra = getIntent().getStringExtra("TYPE");
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("RESULT_RECEIVER");
        this.f3085a = resultReceiver;
        if (resultReceiver == null) {
            finish();
        }
        if (bundle != null) {
            this.f3086b = bundle.getBoolean("androidx.credentials.playservices.AWAITING_RESULT", false);
        }
        if (!this.f3086b) {
            if (stringExtra != null) {
                Task<BeginSignInResult> task = null;
                switch (stringExtra.hashCode()) {
                    case -441061071:
                        if (stringExtra.equals("BEGIN_SIGN_IN")) {
                            BeginSignInRequest beginSignInRequest = (BeginSignInRequest) getIntent().getParcelableExtra("REQUEST_TYPE");
                            int intExtra = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
                            if (beginSignInRequest != null) {
                                Task<BeginSignInResult> addOnSuccessListener = Identity.getSignInClient((Activity) this).beginSignIn(beginSignInRequest).addOnSuccessListener(new d(new c(this, intExtra, 0), 5));
                                final int i = 3;
                                task = addOnSuccessListener.addOnFailureListener(new OnFailureListener(this) { // from class: N.b

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ HiddenActivity f1418b;

                                    {
                                        this.f1418b = this;
                                    }

                                    @Override // com.google.android.gms.tasks.OnFailureListener
                                    public final void onFailure(Exception e4) {
                                        int i3 = i;
                                        String str = "CREATE_INTERRUPTED";
                                        String str2 = "GET_INTERRUPTED";
                                        HiddenActivity this$0 = this.f1418b;
                                        switch (i3) {
                                            case 0:
                                                int i4 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver2 = this$0.f3085a;
                                                j.b(resultReceiver2);
                                                this$0.a(resultReceiver2, str, "During create public key credential, fido registration failure: " + e4.getMessage());
                                                return;
                                            case 1:
                                                int i5 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver3 = this$0.f3085a;
                                                j.b(resultReceiver3);
                                                this$0.a(resultReceiver3, str, "During save password, found password failure response from one tap " + e4.getMessage());
                                                return;
                                            case 2:
                                                int i6 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver4 = this$0.f3085a;
                                                j.b(resultReceiver4);
                                                this$0.a(resultReceiver4, str2, "During get sign-in intent, failure response from one tap: " + e4.getMessage());
                                                return;
                                            default:
                                                int i7 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver5 = this$0.f3085a;
                                                j.b(resultReceiver5);
                                                this$0.a(resultReceiver5, str2, "During begin sign in, failure response from one tap: " + e4.getMessage());
                                                return;
                                        }
                                    }
                                });
                            }
                            if (task == null) {
                                finish();
                                return;
                            }
                            return;
                        }
                        break;
                    case 15545322:
                        if (stringExtra.equals("CREATE_PUBLIC_KEY_CREDENTIAL")) {
                            PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) getIntent().getParcelableExtra("REQUEST_TYPE");
                            int intExtra2 = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
                            if (publicKeyCredentialCreationOptions != null) {
                                Task<PendingIntent> addOnSuccessListener2 = Fido.getFido2ApiClient((Activity) this).getRegisterPendingIntent(publicKeyCredentialCreationOptions).addOnSuccessListener(new d(new c(this, intExtra2, 2), 2));
                                final int i3 = 0;
                                task = addOnSuccessListener2.addOnFailureListener(new OnFailureListener(this) { // from class: N.b

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ HiddenActivity f1418b;

                                    {
                                        this.f1418b = this;
                                    }

                                    @Override // com.google.android.gms.tasks.OnFailureListener
                                    public final void onFailure(Exception e4) {
                                        int i32 = i3;
                                        String str = "CREATE_INTERRUPTED";
                                        String str2 = "GET_INTERRUPTED";
                                        HiddenActivity this$0 = this.f1418b;
                                        switch (i32) {
                                            case 0:
                                                int i4 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver2 = this$0.f3085a;
                                                j.b(resultReceiver2);
                                                this$0.a(resultReceiver2, str, "During create public key credential, fido registration failure: " + e4.getMessage());
                                                return;
                                            case 1:
                                                int i5 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver3 = this$0.f3085a;
                                                j.b(resultReceiver3);
                                                this$0.a(resultReceiver3, str, "During save password, found password failure response from one tap " + e4.getMessage());
                                                return;
                                            case 2:
                                                int i6 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver4 = this$0.f3085a;
                                                j.b(resultReceiver4);
                                                this$0.a(resultReceiver4, str2, "During get sign-in intent, failure response from one tap: " + e4.getMessage());
                                                return;
                                            default:
                                                int i7 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver5 = this$0.f3085a;
                                                j.b(resultReceiver5);
                                                this$0.a(resultReceiver5, str2, "During begin sign in, failure response from one tap: " + e4.getMessage());
                                                return;
                                        }
                                    }
                                });
                            }
                            if (task == null) {
                                finish();
                                return;
                            }
                            return;
                        }
                        break;
                    case 1246634622:
                        if (stringExtra.equals("CREATE_PASSWORD")) {
                            SavePasswordRequest savePasswordRequest = (SavePasswordRequest) getIntent().getParcelableExtra("REQUEST_TYPE");
                            int intExtra3 = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
                            if (savePasswordRequest != null) {
                                Task<SavePasswordResult> addOnSuccessListener3 = Identity.getCredentialSavingClient((Activity) this).savePassword(savePasswordRequest).addOnSuccessListener(new d(new c(this, intExtra3, 1), 3));
                                final int i4 = 1;
                                task = addOnSuccessListener3.addOnFailureListener(new OnFailureListener(this) { // from class: N.b

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ HiddenActivity f1418b;

                                    {
                                        this.f1418b = this;
                                    }

                                    @Override // com.google.android.gms.tasks.OnFailureListener
                                    public final void onFailure(Exception e4) {
                                        int i32 = i4;
                                        String str = "CREATE_INTERRUPTED";
                                        String str2 = "GET_INTERRUPTED";
                                        HiddenActivity this$0 = this.f1418b;
                                        switch (i32) {
                                            case 0:
                                                int i42 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver2 = this$0.f3085a;
                                                j.b(resultReceiver2);
                                                this$0.a(resultReceiver2, str, "During create public key credential, fido registration failure: " + e4.getMessage());
                                                return;
                                            case 1:
                                                int i5 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver3 = this$0.f3085a;
                                                j.b(resultReceiver3);
                                                this$0.a(resultReceiver3, str, "During save password, found password failure response from one tap " + e4.getMessage());
                                                return;
                                            case 2:
                                                int i6 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver4 = this$0.f3085a;
                                                j.b(resultReceiver4);
                                                this$0.a(resultReceiver4, str2, "During get sign-in intent, failure response from one tap: " + e4.getMessage());
                                                return;
                                            default:
                                                int i7 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver5 = this$0.f3085a;
                                                j.b(resultReceiver5);
                                                this$0.a(resultReceiver5, str2, "During begin sign in, failure response from one tap: " + e4.getMessage());
                                                return;
                                        }
                                    }
                                });
                            }
                            if (task == null) {
                                finish();
                                return;
                            }
                            return;
                        }
                        break;
                    case 1980564212:
                        if (stringExtra.equals("SIGN_IN_INTENT")) {
                            GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) getIntent().getParcelableExtra("REQUEST_TYPE");
                            int intExtra4 = getIntent().getIntExtra("ACTIVITY_REQUEST_CODE", 1);
                            if (getSignInIntentRequest != null) {
                                Task<PendingIntent> addOnSuccessListener4 = Identity.getSignInClient((Activity) this).getSignInIntent(getSignInIntentRequest).addOnSuccessListener(new d(new c(this, intExtra4, 3), 4));
                                final int i5 = 2;
                                task = addOnSuccessListener4.addOnFailureListener(new OnFailureListener(this) { // from class: N.b

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ HiddenActivity f1418b;

                                    {
                                        this.f1418b = this;
                                    }

                                    @Override // com.google.android.gms.tasks.OnFailureListener
                                    public final void onFailure(Exception e4) {
                                        int i32 = i5;
                                        String str = "CREATE_INTERRUPTED";
                                        String str2 = "GET_INTERRUPTED";
                                        HiddenActivity this$0 = this.f1418b;
                                        switch (i32) {
                                            case 0:
                                                int i42 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver2 = this$0.f3085a;
                                                j.b(resultReceiver2);
                                                this$0.a(resultReceiver2, str, "During create public key credential, fido registration failure: " + e4.getMessage());
                                                return;
                                            case 1:
                                                int i52 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str = "CREATE_UNKNOWN";
                                                }
                                                ResultReceiver resultReceiver3 = this$0.f3085a;
                                                j.b(resultReceiver3);
                                                this$0.a(resultReceiver3, str, "During save password, found password failure response from one tap " + e4.getMessage());
                                                return;
                                            case 2:
                                                int i6 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver4 = this$0.f3085a;
                                                j.b(resultReceiver4);
                                                this$0.a(resultReceiver4, str2, "During get sign-in intent, failure response from one tap: " + e4.getMessage());
                                                return;
                                            default:
                                                int i7 = HiddenActivity.f3084c;
                                                j.e(this$0, "this$0");
                                                j.e(e4, "e");
                                                if (!(e4 instanceof ApiException) || !O.a.f1527a.contains(Integer.valueOf(((ApiException) e4).getStatusCode()))) {
                                                    str2 = "GET_NO_CREDENTIALS";
                                                }
                                                ResultReceiver resultReceiver5 = this$0.f3085a;
                                                j.b(resultReceiver5);
                                                this$0.a(resultReceiver5, str2, "During begin sign in, failure response from one tap: " + e4.getMessage());
                                                return;
                                        }
                                    }
                                });
                            }
                            if (task == null) {
                                finish();
                                return;
                            }
                            return;
                        }
                        break;
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle outState) {
        j.e(outState, "outState");
        outState.putBoolean("androidx.credentials.playservices.AWAITING_RESULT", this.f3086b);
        super.onSaveInstanceState(outState);
    }
}
