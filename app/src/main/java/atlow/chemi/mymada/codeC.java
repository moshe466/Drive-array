package atlow.chemi.mymada;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import atlow.chemi.mymada.helpers.LocalHelper;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class codeC extends AppCompatActivity {
    private static final String BASE_URL = "http://atlowapps.tzevethatzolah.org/codeC.php";
    private OkHttpClient client = new OkHttpClient();
    private DatabaseReference mFirebaseDatabase;
    private ProgressDialog pdialog;
    private Button send;

    /* JADX INFO: Access modifiers changed from: private */
    public void di(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle(getResources().getString(R.string.err)).setMessage(str).setCancelable(false).setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.f1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        final AlertDialog create = builder.create();
        TextView textView = (TextView) create.findViewById(android.R.id.message);
        final Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        if (textView != null) {
            textView.setTypeface(createFromAsset);
        }
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.e1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                create.getButton(-2).setTypeface(createFromAsset);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gooddi(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(str).setCancelable(false).setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.d1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                codeC.this.a(dialogInterface, i);
            }
        });
        builder.create().show();
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

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) MokedPage.class);
        intent.setFlags(268435456);
        finish();
        startActivity(intent);
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public void newSendCode(final String str, String str2) {
        if (str2.length() <= 0) {
            str2 = getApplication().getSharedPreferences("Settings", 0).getString("firebaseGenratedKey", "");
        }
        if (str2.trim().length() == 0) {
            di(getString(R.string.codeNotExist));
            return;
        }
        this.pdialog.show();
        this.mFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        this.mFirebaseDatabase = this.mFirebaseDatabase.child("codes");
        this.mFirebaseDatabase = this.mFirebaseDatabase.child(str2);
        this.mFirebaseDatabase.addListenerForSingleValueEvent(new ValueEventListener() { // from class: atlow.chemi.mymada.codeC.6
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                codeC.this.pdialog.cancel();
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean z;
                boolean z2;
                codeC codec;
                String string;
                String str3 = (String) dataSnapshot.child("code").getValue(String.class);
                try {
                    z = ((Boolean) dataSnapshot.child("allowed").getValue(Boolean.class)).booleanValue();
                } catch (NullPointerException e) {
                    Crashlytics.log(e.getMessage());
                    z = false;
                }
                try {
                    z2 = ((Boolean) dataSnapshot.child("used").getValue(Boolean.class)).booleanValue();
                } catch (NullPointerException e2) {
                    Crashlytics.log(e2.getMessage());
                    z2 = true;
                }
                if (!str.equals(str3)) {
                    codec = codeC.this;
                    string = codec.getString(R.string.codeBad);
                } else if (z2) {
                    codec = codeC.this;
                    string = codec.getString(R.string.codeUsed, new Object[]{str});
                } else {
                    codec = codeC.this;
                    if (z) {
                        codec.mFirebaseDatabase.child("used").setValue(true);
                        codeC codec2 = codeC.this;
                        codec2.gooddi(codec2.getResources().getString(R.string.codeGood));
                        SharedPreferences.Editor edit = codeC.this.getSharedPreferences("Settings", 0).edit();
                        edit.putBoolean("realM", true);
                        edit.apply();
                        codeC.this.pdialog.cancel();
                    }
                    string = codec.getString(R.string.codeNotAllowed, new Object[]{str});
                }
                codec.di(string);
                codeC.this.pdialog.cancel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_code_c);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        Log.d("KEYERG", "the key is: " + getApplication().getSharedPreferences("Settings", 0).getString("firebaseGenratedKey", ""));
        boolean booleanExtra = getIntent().getBooleanExtra("toCode", false);
        String stringExtra = getIntent().getStringExtra("code");
        String stringExtra2 = getIntent().getStringExtra("fireKey");
        this.pdialog = new ProgressDialog(this);
        this.pdialog.setIndeterminate(true);
        this.pdialog.setMessage("טוען. אנא המתן...");
        this.pdialog.setProgressStyle(0);
        this.pdialog.setCancelable(false);
        final EditText editText = (EditText) findViewById(R.id.code1);
        final EditText editText2 = (EditText) findViewById(R.id.code2);
        final EditText editText3 = (EditText) findViewById(R.id.code3);
        final EditText editText4 = (EditText) findViewById(R.id.code4);
        this.send = (Button) findViewById(R.id.okBBB);
        this.send.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.codeC.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().length() == 0 || editText2.getText().length() == 0 || editText3.getText().length() == 0 || editText4.getText().length() == 0) {
                    codeC.this.di("לא הזנת את הקוד במלואו!");
                    return;
                }
                String string = codeC.this.getApplication().getSharedPreferences("Settings", 0).getString("firebaseGenratedKey", "");
                codeC.this.newSendCode(editText.getText().toString() + editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString(), string);
            }
        });
        if (booleanExtra) {
            newSendCode(stringExtra, stringExtra2);
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i3 == 1) {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editText2.requestFocus();
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i3 == 1) {
                    editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editText3.requestFocus();
                }
                if (i3 == 0) {
                    editText.requestFocus();
                }
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i3 == 1) {
                    editText3.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editText4.requestFocus();
                }
                if (i3 == 0) {
                    editText2.requestFocus();
                }
            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i3 == 0) {
                    editText3.requestFocus();
                }
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
