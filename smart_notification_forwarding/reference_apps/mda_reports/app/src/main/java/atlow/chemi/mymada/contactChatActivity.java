package atlow.chemi.mymada;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import atlow.chemi.mymada.adapters.ChatAdapter;
import atlow.chemi.mymada.classes.Chat;
import atlow.chemi.mymada.helpers.ChatEventCallback;
import atlow.chemi.mymada.helpers.FixedTextInputEditText;
import atlow.chemi.mymada.helpers.LocalHelper;
import atlow.chemi.mymada.helpers.MyFirebaseMessagingService;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class contactChatActivity extends AppCompatActivity {
    private EditText ChatT;
    private MenuItem Detect;
    private ChatAdapter adapter;
    private ArrayList<Chat> chats;
    private String fcmToken;
    private String name;
    private float oldX1;
    private float oldY1;
    private DatabaseReference root;
    private Button sendChat;
    private final int REQUEST_PERMISSION_SETTING = 101;
    private boolean isMove = false;

    /* loaded from: classes.dex */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private boolean includeEdge;
        private int spacing;
        private int spanCount;

        GridSpacingItemDecoration(contactChatActivity contactchatactivity, int i, int i2, boolean z) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.spanCount;
            int i2 = childAdapterPosition % i;
            if (this.includeEdge) {
                int i3 = this.spacing;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (childAdapterPosition < i) {
                    rect.top = i3;
                }
                rect.bottom = this.spacing / 9;
                return;
            }
            int i4 = this.spacing;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition >= i) {
                rect.top = i4 / 9;
            }
        }
    }

    private void PermissionDialog(final boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(getResources().getString(R.string.dialog_help)).setCancelable(false).setPositiveButton(getResources().getString(R.string.dialog_yes), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.d2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                contactChatActivity.this.a(z, dialogInterface, i);
            }
        }).setNegativeButton(getResources().getString(R.string.dialog_no), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.k2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.a2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                contactChatActivity.this.a(create, dialogInterface);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(AlertDialog alertDialog, Typeface typeface, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setTypeface(typeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(typeface);
        }
        alertDialog.getButton(-2).setTypeface(typeface);
    }

    private void di(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle(getResources().getString(R.string.err)).setMessage(str).setCancelable(false).setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.e2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    private int dpToPx(int i) {
        return Math.round(TypedValue.applyDimension(1, i, getResources().getDisplayMetrics()));
    }

    private boolean isCallable(Intent intent) {
        try {
            return getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            Crashlytics.logException(e);
            return false;
        }
    }

    private void makeAnnouncement() {
        final Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setMessage(R.string.contactMsg).setCancelable(false).setTitle(R.string.plsNote).setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.i2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.f2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                contactChatActivity.a(AlertDialog.this, createFromAsset, dialogInterface);
            }
        });
        create.show();
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

    public /* synthetic */ void a(View view) {
        if (this.name.trim().length() < 1) {
            askForName(false);
            return;
        }
        String trim = this.ChatT.getText().toString().trim();
        if (trim.length() <= 0) {
            di(getString(R.string.emailMsgNone));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Name", this.name);
        hashMap.put("LastSent", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("SeenByAdmin", false);
        String key = this.root.push().getKey();
        this.root.updateChildren(hashMap);
        DatabaseReference child = this.root.child(key);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sender", this.fcmToken);
        hashMap2.put(NotificationCompat.CATEGORY_MESSAGE, trim);
        hashMap2.put("time", Long.valueOf(System.currentTimeMillis()));
        child.updateChildren(hashMap2).addOnSuccessListener(new OnSuccessListener() { // from class: atlow.chemi.mymada.g2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                contactChatActivity.this.a((Void) obj);
            }
        });
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getApplicationContext().getResources().getColor(R.color.ColorPrimary));
    }

    public /* synthetic */ void a(FixedTextInputEditText fixedTextInputEditText, TextInputLayout textInputLayout, SharedPreferences sharedPreferences, DialogInterface dialogInterface, View view) {
        int i;
        String trim = fixedTextInputEditText.getText() != null ? fixedTextInputEditText.getText().toString().trim() : "";
        if (trim.isEmpty()) {
            i = R.string.emailNameNone;
        } else {
            if (!TextUtils.isDigitsOnly(trim)) {
                textInputLayout.setErrorEnabled(false);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("UserName", trim);
                this.name = trim;
                edit.apply();
                dialogInterface.dismiss();
                this.adapter.notifyDataSetChanged();
                FirebaseDatabase.getInstance().getReference().child("chats").child(this.fcmToken).child("Name").setValue(trim);
                return;
            }
            i = R.string.chatNameNum;
        }
        textInputLayout.setError(getString(i));
    }

    public /* synthetic */ void a(final FixedTextInputEditText fixedTextInputEditText, String str, AlertDialog alertDialog, final TextInputLayout textInputLayout, final SharedPreferences sharedPreferences, final DialogInterface dialogInterface) {
        fixedTextInputEditText.setText(str);
        alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                contactChatActivity.this.a(fixedTextInputEditText, textInputLayout, sharedPreferences, dialogInterface, view);
            }
        });
    }

    public /* synthetic */ void a(Void r2) {
        this.ChatT.setText("");
    }

    public /* synthetic */ void a(boolean z, DialogInterface dialogInterface, int i) {
        if (z) {
            startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 101);
        } else {
            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldY1 = motionEvent.getY();
            this.oldX1 = motionEvent.getX();
            this.isMove = false;
            this.sendChat.setAlpha(0.4f);
            return true;
        }
        if (action == 1) {
            this.sendChat.setAlpha(1.0f);
            if (!this.isMove) {
                this.sendChat.performClick();
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        boolean z = this.oldX1 - motionEvent.getX() > 60.0f || motionEvent.getX() - this.oldX1 > 60.0f;
        boolean z2 = this.oldY1 - motionEvent.getY() > 50.0f || motionEvent.getY() - this.oldY1 > 50.0f;
        if (z || z2) {
            this.isMove = true;
            this.sendChat.setAlpha(1.0f);
        }
        return true;
    }

    public void askForName(boolean z) {
        View inflate = View.inflate(this, R.layout.shabat_t, null);
        final FixedTextInputEditText fixedTextInputEditText = (FixedTextInputEditText) inflate.findViewById(R.id.shabatT);
        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.shabatTil);
        textInputLayout.setHint(getString(R.string.name));
        fixedTextInputEditText.setInputType(97);
        final SharedPreferences sharedPreferences = getSharedPreferences("Settings", 0);
        final String string = sharedPreferences.getString("UserName", "");
        AlertDialog.Builder cancelable = new AlertDialog.Builder(this, R.style.AlertDialogStyle).setView(inflate).setTitle(R.string.writeName).setCancelable(z);
        cancelable.setPositiveButton(getString(R.string.ok), (DialogInterface.OnClickListener) null);
        final AlertDialog create = cancelable.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.z1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                contactChatActivity.this.a(fixedTextInputEditText, string, create, textInputLayout, sharedPreferences, dialogInterface);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(LocalHelper.onAttach(context));
    }

    public /* synthetic */ void b() {
        askForName(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        resetTitle();
        setContentView(R.layout.activity_contact_chat);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (bundle == null) {
            makeAnnouncement();
        }
        this.chats = new ArrayList<>();
        this.adapter = new ChatAdapter(this.chats, this);
        this.adapter.nameChangeRequestCallback.addListener(new ChatEventCallback() { // from class: atlow.chemi.mymada.j2
            @Override // atlow.chemi.mymada.helpers.ChatEventCallback
            public final void invoke() {
                contactChatActivity.this.b();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chatMsg);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(this, 1, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.adapter);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000L);
        defaultItemAnimator.setRemoveDuration(1000L);
        recyclerView.setItemAnimator(defaultItemAnimator);
        MyFirebaseMessagingService.getToken(getApplicationContext());
        this.fcmToken = getSharedPreferences("Settings", 0).getString("fcm", "empty");
        this.root = FirebaseDatabase.getInstance().getReference().child("chats").child(this.fcmToken);
        this.ChatT = (EditText) findViewById(R.id.chatT);
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.chatTil);
        this.sendChat = (Button) findViewById(R.id.sendChat);
        this.name = getSharedPreferences("Settings", 0).getString("UserName", "");
        if (this.name.trim().length() < 1) {
            askForName(false);
        }
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/opensanshebrew.ttf");
        this.ChatT.setTypeface(createFromAsset);
        textInputLayout.setTypeface(createFromAsset);
        this.sendChat.setTypeface(createFromAsset);
        this.sendChat.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, VectorDrawableCompat.create(getResources(), R.drawable.ic_send, null), (Drawable) null);
        this.sendChat.setOnTouchListener(new View.OnTouchListener() { // from class: atlow.chemi.mymada.h2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return contactChatActivity.this.a(view, motionEvent);
            }
        });
        this.sendChat.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                contactChatActivity.this.a(view);
            }
        });
        this.chats.add(new Chat("NAME_CHANGE", "NAME_CHANGE", "NAME_CHANGE", false));
        this.root.addChildEventListener(new ChildEventListener() { // from class: atlow.chemi.mymada.contactChatActivity.1
            @Override // com.google.firebase.database.ChildEventListener
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String str) {
                contactChatActivity contactchatactivity;
                int i;
                boolean z;
                String str2;
                if (dataSnapshot.getKey() == null || dataSnapshot.getKey().equals("Name") || dataSnapshot.getKey().equals("LastSent") || dataSnapshot.getKey().equals("SeenByAdmin")) {
                    if (dataSnapshot.getKey() == null || dataSnapshot.getValue() == null || !dataSnapshot.getKey().equals("SeenByAdmin")) {
                        return;
                    }
                    boolean booleanValue = ((Boolean) dataSnapshot.getValue()).booleanValue();
                    TextView textView = (TextView) contactChatActivity.this.findViewById(R.id.msgSeen);
                    if (booleanValue) {
                        contactchatactivity = contactChatActivity.this;
                        i = R.string.msgSeen;
                    } else {
                        contactchatactivity = contactChatActivity.this;
                        i = R.string.msgNotSeen;
                    }
                    textView.setText(contactchatactivity.getString(i));
                    return;
                }
                String str3 = (String) dataSnapshot.child("sender").getValue(String.class);
                String str4 = (String) dataSnapshot.child(NotificationCompat.CATEGORY_MESSAGE).getValue(String.class);
                try {
                    z = ((Boolean) dataSnapshot.child("WhatsApp").getValue()).booleanValue();
                } catch (NullPointerException unused) {
                    z = false;
                }
                try {
                    str2 = dataSnapshot.child("time").getValue(Long.class) + "";
                } catch (NullPointerException unused2) {
                    str2 = (System.currentTimeMillis() / 1000) + "";
                }
                contactChatActivity.this.chats.add(new Chat(str3, str4, str2, z));
                if (contactChatActivity.this.adapter != null) {
                    contactChatActivity.this.adapter.notifyDataSetChanged();
                    recyclerView.smoothScrollToPosition(contactChatActivity.this.adapter.getItemCount());
                }
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String str) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String str) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
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

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
    
        if (atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.isAccessibilitySettingsOn(getApplicationContext()) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0096, code lost:
    
        PermissionDialog(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
    
        if (r2.contains(r3) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b6, code lost:
    
        if (atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.isAccessibilitySettingsOn(getApplicationContext()) == false) goto L23;
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onOptionsItemSelected(@androidx.annotation.NonNull android.view.MenuItem r9) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "Settings"
            android.content.SharedPreferences r1 = r8.getSharedPreferences(r1, r0)
            int r2 = r9.getItemId()
            r3 = 16908332(0x102002c, float:2.3877352E-38)
            r4 = 1
            if (r2 == r3) goto Le2
            r3 = 2131362013(0x7f0a00dd, float:1.8343795E38)
            if (r2 == r3) goto Ld7
            r3 = 2131362351(0x7f0a022f, float:1.834448E38)
            if (r2 == r3) goto L20
            boolean r9 = super.onOptionsItemSelected(r9)
            return r9
        L20:
            android.content.SharedPreferences$Editor r1 = r1.edit()
            android.content.Context r2 = r8.getApplicationContext()
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.lang.String r3 = "enabled_notification_listeners"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)
            android.content.Context r3 = r8.getApplicationContext()
            java.lang.String r3 = r3.getPackageName()
            boolean r5 = r9.isChecked()
            java.lang.String r6 = "Mapp"
            if (r5 != 0) goto Lbd
            r9.setChecked(r4)
            r5 = 2131230873(0x7f080099, float:1.8077811E38)
            r9.setIcon(r5)
            android.content.Intent r9 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.SMSMonitorService> r5 = atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class
            r9.<init>(r8, r5)
            androidx.core.content.ContextCompat.startForegroundService(r8, r9)
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r5 = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            r9.<init>(r5)
            boolean r9 = r8.isCallable(r9)
            int r5 = android.os.Build.VERSION.SDK_INT
            r7 = 18
            if (r5 < r7) goto Lb9
            if (r9 == 0) goto L9a
            if (r2 == 0) goto L70
            boolean r9 = r2.contains(r3)     // Catch: android.content.ActivityNotFoundException -> L77
            if (r9 != 0) goto L73
        L70:
            r8.PermissionDialog(r0)     // Catch: android.content.ActivityNotFoundException -> L77
        L73:
            r1.putBoolean(r6, r4)     // Catch: android.content.ActivityNotFoundException -> L77
            goto Ld3
        L77:
            android.content.Intent r9 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.NotificationService> r0 = atlow.chemi.mymada.NotificationService.class
            r9.<init>(r8, r0)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.NotificationServiceOld> r2 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.class
            r0.<init>(r8, r2)
            r8.stopService(r9)
            r8.startService(r0)
            android.content.Context r9 = r8.getApplicationContext()
            boolean r9 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.isAccessibilitySettingsOn(r9)
            if (r9 != 0) goto Lb9
        L96:
            r8.PermissionDialog(r4)
            goto Lb9
        L9a:
            android.content.Intent r9 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.NotificationService> r0 = atlow.chemi.mymada.NotificationService.class
            r9.<init>(r8, r0)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.NotificationServiceOld> r2 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.class
            r0.<init>(r8, r2)
            r8.stopService(r9)
            r8.startService(r0)
            android.content.Context r9 = r8.getApplicationContext()
            boolean r9 = atlow.chemi.mymada.recieversAndServices.NotificationServiceOld.isAccessibilitySettingsOn(r9)
            if (r9 != 0) goto Lb9
            goto L96
        Lb9:
            r1.putBoolean(r6, r4)
            goto Ld3
        Lbd:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.recieversAndServices.SMSMonitorService> r3 = atlow.chemi.mymada.recieversAndServices.SMSMonitorService.class
            r2.<init>(r8, r3)
            r8.stopService(r2)
            r9.setChecked(r0)
            r1.putBoolean(r6, r0)
            r0 = 2131230872(0x7f080098, float:1.807781E38)
            r9.setIcon(r0)
        Ld3:
            r1.apply()
            return r4
        Ld7:
            android.content.Intent r9 = new android.content.Intent
            java.lang.Class<atlow.chemi.mymada.SettingsPage> r0 = atlow.chemi.mymada.SettingsPage.class
            r9.<init>(r8, r0)
            r8.startActivity(r9)
            return r4
        Le2:
            r8.finish()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.contactChatActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
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
}
