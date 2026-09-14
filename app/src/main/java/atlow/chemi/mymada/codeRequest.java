package atlow.chemi.mymada;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.internal.view.SupportMenu;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import atlow.chemi.mymada.helpers.LocalHelper;
import atlow.chemi.mymada.helpers.MyFirebaseMessagingService;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes.dex */
public class codeRequest extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private MenuItem Detect;
    private EditText codeA;
    private TextInputLayout codeATIL;
    private EditText codeN;
    private TextInputLayout codeNTIL;
    private EditText codeT;
    private TextInputLayout codeTTIL;
    private DatabaseReference mFirebaseDatabase;
    private float oldX1;
    private float oldY1;
    private ProgressDialog pdialog;
    private Button sendCR;
    private String token;
    private boolean isMove = false;
    private boolean isConnected = true;

    /* loaded from: classes.dex */
    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout;
            TextInputLayout textInputLayout2;
            Resources resources;
            int i;
            int id = this.view.getId();
            if (id == R.id.codeA) {
                if (codeRequest.this.codeA.getText().toString().isEmpty()) {
                    textInputLayout2 = codeRequest.this.codeATIL;
                    resources = codeRequest.this.getResources();
                    i = R.string.emailNone;
                } else {
                    codeRequest coderequest = codeRequest.this;
                    if (coderequest.isEmailValid(coderequest.codeA.getText().toString())) {
                        codeRequest coderequest2 = codeRequest.this;
                        if (coderequest2.isEmailValid(coderequest2.codeA.getText().toString())) {
                            textInputLayout = codeRequest.this.codeATIL;
                            textInputLayout.setErrorEnabled(false);
                        }
                        return;
                    }
                    textInputLayout2 = codeRequest.this.codeATIL;
                    resources = codeRequest.this.getResources();
                    i = R.string.emailInvalid;
                }
                textInputLayout2.setError(resources.getString(i));
            }
            if (id == R.id.codeN) {
                if (!codeRequest.this.codeN.getText().toString().isEmpty()) {
                    textInputLayout = codeRequest.this.codeNTIL;
                    textInputLayout.setErrorEnabled(false);
                } else {
                    textInputLayout2 = codeRequest.this.codeNTIL;
                    resources = codeRequest.this.getResources();
                    i = R.string.emailNameNone;
                    textInputLayout2.setError(resources.getString(i));
                }
            }
            if (id != R.id.codeT) {
                return;
            }
            if (!codeRequest.this.codeT.getText().toString().isEmpty()) {
                textInputLayout = codeRequest.this.codeTTIL;
                textInputLayout.setErrorEnabled(false);
            } else {
                textInputLayout2 = codeRequest.this.codeTTIL;
                resources = codeRequest.this.getResources();
                i = R.string.emailMsgNone;
                textInputLayout2.setError(resources.getString(i));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    private void di(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle(getResources().getString(R.string.err)).setMessage(str).setCancelable(false).setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.v1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    private void gooddi(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(str).setCancelable(false).setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.w1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    private boolean isCallable(Intent intent) {
        try {
            return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void resetTitle() {
        try {
            int i = getPackageManager().getActivityInfo(getComponentName(), 128).labelRes;
            if (i != 0) {
                setTitle(i);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Crashlytics.log(e.getMessage());
        }
    }

    private void sms(final String str, final String str2, final String str3) {
        String str4 = getResources().getString(R.string.emailAlert) + "\n\n";
        String str5 = str4 + getResources().getString(R.string.sender) + str2 + " - " + str + "\n";
        SpannableString spannableString = new SpannableString(str5 + "\n" + getResources().getString(R.string.msg) + "\n" + str3);
        spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, str4.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(35, 139, 173)), str4.length(), str4.length() + 5, 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(35, 139, 173)), str5.length(), str5.length() + 7, 0);
        final AlertDialog create = new AlertDialog.Builder(this, R.style.AlertDialogStyle).setTitle(getResources().getString(R.string.suc)).setMessage(spannableString).setCancelable(false).setNegativeButton(getResources().getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.n1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.y1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                codeRequest.this.a(str, str2, str3, dialogInterface, i);
            }
        }).create();
        TextView textView = (TextView) create.findViewById(android.R.id.message);
        final Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        if (textView != null) {
            textView.setTypeface(createFromAsset);
        }
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.j1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                codeRequest.this.a(create, createFromAsset, dialogInterface);
            }
        });
        create.show();
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    public /* synthetic */ void a(View view) {
        String email = this.codeA.getText().toString().trim();
        String name = this.codeN.getText().toString().trim();
        String phone = this.codeT.getText().toString().trim();

        boolean valid = true;
        if (email.length() < 1) {
            this.codeATIL.setError(getResources().getString(R.string.err_empty));
            valid = false;
        } else if (!isEmailValid(email)) {
            this.codeATIL.setError(getResources().getString(R.string.err_email));
            valid = false;
        } else {
            this.codeATIL.setErrorEnabled(false);
        }

        if (name.length() < 1) {
            this.codeNTIL.setError(getResources().getString(R.string.err_name));
            valid = false;
        } else {
            this.codeNTIL.setErrorEnabled(false);
        }

        if (phone.length() < 1) {
            this.codeTTIL.setError(getResources().getString(R.string.err_phone));
            valid = false;
        } else {
            this.codeTTIL.setErrorEnabled(false);
        }

        if (valid && isEmailValid(email) && !email.isEmpty() && !name.isEmpty() && !phone.isEmpty()) {
            sms(email, name, phone);
        }
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void a(AlertDialog alertDialog, Typeface typeface, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-2);
        Button button2 = alertDialog.getButton(-1);
        button.setTypeface(typeface);
        button2.setTypeface(typeface);
        button.setTextColor(getResources().getColor(R.color.OldPrimary));
    }

    public /* synthetic */ void a(Exception exc) {
        this.sendCR.setEnabled(false);
        this.pdialog.cancel();
        di(getResources().getString(R.string.emailBad));
    }

    public /* synthetic */ void a(String str, String str2, String str3, DialogInterface dialogInterface, int i) {
        this.sendCR.setEnabled(false);
        this.pdialog = new ProgressDialog(this);
        this.pdialog.setIndeterminate(true);
        this.pdialog.setMessage(getResources().getString(R.string.load));
        this.pdialog.setProgressStyle(0);
        this.pdialog.setCancelable(false);
        this.pdialog.show();
        sendMailNew(str, str2, str3);
        dialogInterface.cancel();
    }

    public /* synthetic */ void a(Void r3) {
        try {
            gooddi(getResources().getString(R.string.requestGood));
        } catch (WindowManager.BadTokenException e) {
            Crashlytics.log("gooddi called after window closed.");
            Crashlytics.logException(e);
        }
        this.pdialog.cancel();
        SharedPreferences.Editor edit = getApplication().getSharedPreferences("Settings", 0).edit();
        edit.putString("firebaseGenratedKey", this.mFirebaseDatabase.getKey());
        edit.apply();
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldY1 = motionEvent.getY();
            this.oldX1 = motionEvent.getX();
            this.isMove = false;
            this.sendCR.setAlpha(0.4f);
            return true;
        }
        if (action == 1) {
            this.sendCR.setAlpha(1.0f);
            if (!this.isMove) {
                this.sendCR.performClick();
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        boolean z = this.oldX1 - motionEvent.getX() > 10.0f || motionEvent.getX() - this.oldX1 > 10.0f;
        boolean z2 = this.oldY1 - motionEvent.getY() > 50.0f || motionEvent.getY() - this.oldY1 > 50.0f;
        if (z || z2) {
            this.isMove = true;
            this.sendCR.setAlpha(1.0f);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public /* synthetic */ void b(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
    }

    public /* synthetic */ void c(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public boolean isEmailValid(CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_code_request);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle(getResources().getString(R.string.plsNote)).setMessage(getResources().getString(R.string.plsNoteT)).setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.i1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
        MyFirebaseMessagingService.getToken(getApplicationContext());
        this.token = getSharedPreferences("Settings", 0).getString("fcm", "empty");
        this.pdialog = new ProgressDialog(this);
        this.pdialog.setIndeterminate(true);
        this.pdialog.setMessage(getResources().getString(R.string.load));
        this.pdialog.setProgressStyle(0);
        this.pdialog.setCancelable(false);
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        TextView textView = (TextView) findViewById(R.id.declare);
        try {
            TextView textView2 = (TextView) this.pdialog.findViewById(android.R.id.message);
            if (textView2 != null) {
                textView2.setTypeface(createFromAsset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        textView.setTypeface(createFromAsset);
        this.codeA = (EditText) findViewById(R.id.codeA);
        this.codeN = (EditText) findViewById(R.id.codeN);
        this.codeT = (EditText) findViewById(R.id.codeT);
        this.codeATIL = (TextInputLayout) findViewById(R.id.codeATIL);
        this.codeNTIL = (TextInputLayout) findViewById(R.id.codeNTIL);
        this.codeTTIL = (TextInputLayout) findViewById(R.id.codeTTIL);
        EditText editText = this.codeA;
        editText.addTextChangedListener(new MyTextWatcher(editText));
        EditText editText2 = this.codeN;
        editText2.addTextChangedListener(new MyTextWatcher(editText2));
        EditText editText3 = this.codeT;
        editText3.addTextChangedListener(new MyTextWatcher(editText3));
        this.codeA.setTypeface(createFromAsset);
        this.codeN.setTypeface(createFromAsset);
        this.codeT.setTypeface(createFromAsset);
        this.codeATIL.setTypeface(createFromAsset);
        this.codeNTIL.setTypeface(createFromAsset);
        this.codeTTIL.setTypeface(createFromAsset);
        this.sendCR = (Button) findViewById(R.id.sendCR);
        this.sendCR.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, VectorDrawableCompat.create(getResources(), R.drawable.ic_send, null), (Drawable) null);
        this.sendCR.setOnTouchListener(new View.OnTouchListener() { // from class: atlow.chemi.mymada.h1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return codeRequest.this.a(view, motionEvent);
            }
        });
        this.sendCR.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                codeRequest.this.a(view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        int i = sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off;
        this.Detect = menu.findItem(R.id.one);
        menu.findItem(R.id.one).setCheckable(true).setChecked(sharedPreferences.getBoolean("Mapp", false)).setIcon(i);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.action_settings) {
            startActivity(new Intent(this, (Class<?>) SettingsPage.class));
            return true;
        }
        if (itemId == R.id.one) {
            SharedPreferences sp = getSharedPreferences("Settings", 0);
            boolean newState = !sp.getBoolean("Mapp", false);
            sp.edit().putBoolean("Mapp", newState).apply();
            menuItem.setChecked(newState);
            menuItem.setIcon(newState ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        if (this.Detect != null) {
            this.Detect.setIcon(sharedPreferences.getBoolean("Mapp", false) ? R.drawable.ic_detect_on : R.drawable.ic_detect_off);
        }
    }

    public void sendMailNew(String str, String str2, String str3) {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append("0123456789".charAt(new Random().nextInt(10)));
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting())) {
            this.isConnected = false;
        }
        if (!this.isConnected) {
            this.pdialog.cancel();
            this.sendCR.setEnabled(false);
            di(getResources().getString(R.string.emailBad));
            return;
        }
        this.mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        HashMap hashMap = new HashMap();
        hashMap.put("email", str);
        hashMap.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        hashMap.put("reason", str3);
        hashMap.put("code", sb.toString());
        hashMap.put("token", this.token);
        hashMap.put("allowed", false);
        hashMap.put("used", false);
        hashMap.put("time", "" + currentTimeMillis);
        this.mFirebaseDatabase = this.mFirebaseDatabase.child("codes");
        this.mFirebaseDatabase = this.mFirebaseDatabase.push();
        this.mFirebaseDatabase.setValue(hashMap).addOnSuccessListener(new OnSuccessListener() { // from class: atlow.chemi.mymada.k1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                codeRequest.this.a((Void) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: atlow.chemi.mymada.t1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                codeRequest.this.a(exc);
            }
        });
    }
}
