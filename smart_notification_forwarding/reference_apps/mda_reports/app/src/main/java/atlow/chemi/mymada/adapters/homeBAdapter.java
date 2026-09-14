package atlow.chemi.mymada.adapters;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.InfoActivityKt;
import atlow.chemi.mymada.MokedPage;
import atlow.chemi.mymada.UtillitiesAndTools;
import atlow.chemi.mymada.adapters.homeBAdapter;
import atlow.chemi.mymada.classes.HomeB;
import atlow.chemi.mymada.codeRequest;
import atlow.chemi.mymada.contactChatActivity;
import atlow.chemi.mymada.lockPage;
import atlow.chemi.mymada.recieversAndServices.GrobootRec;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class homeBAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<HomeB> albumList;
    private boolean isMADA;
    private Activity mContext;
    private Typeface myTypeface;
    private float oldX1;
    private float oldY1;
    private InterstitialAd openUp;
    private boolean realM;
    private boolean isMove1 = false;
    private ArrayList<Button> btns = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: atlow.chemi.mymada.adapters.homeBAdapter$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends AdListener {
        AnonymousClass1() {
        }

        public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) codeRequest.class);
            intent.setFlags(268435456);
            homeBAdapter.this.mContext.startActivity(intent);
        }

        public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
            TextView textView = (TextView) alertDialog.findViewById(R.id.message);
            if (textView != null) {
                textView.setTypeface(homeBAdapter.this.myTypeface);
            }
            TextView textView2 = (TextView) alertDialog.findViewById(R.id.title);
            if (textView2 != null) {
                textView2.setTypeface(homeBAdapter.this.myTypeface);
            }
            Button button = alertDialog.getButton(-2);
            alertDialog.getButton(-1).setTypeface(homeBAdapter.this.myTypeface);
            button.setTypeface(homeBAdapter.this.myTypeface);
            button.setTextColor(homeBAdapter.this.mContext.getResources().getColor(atlow.chemi.mymada.R.color.OldPrimary));
        }

        public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) contactChatActivity.class);
            intent.setFlags(268435456);
            homeBAdapter.this.mContext.startActivity(intent);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            homeBAdapter.this.openUp.loadAd(new AdRequest.Builder().build());
            if (homeBAdapter.this.realM || homeBAdapter.this.isMADA) {
                Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) contactChatActivity.class);
                intent.setFlags(268435456);
                homeBAdapter.this.mContext.startActivity(intent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(homeBAdapter.this.mContext, atlow.chemi.mymada.R.style.AlertDialogStyle);
                builder.setTitle(homeBAdapter.this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNote)).setMessage(homeBAdapter.this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNoteCon)).setCancelable(true).setNegativeButton(homeBAdapter.this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNoteConCode), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.m
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.AnonymousClass1.this.a(dialogInterface, i);
                    }
                }).setPositiveButton(homeBAdapter.this.mContext.getResources().getString(atlow.chemi.mymada.R.string.title_activity_contact), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.n
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.AnonymousClass1.this.b(dialogInterface, i);
                    }
                });
                final AlertDialog create = builder.create();
                create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.adapters.o
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        homeBAdapter.AnonymousClass1.this.a(create, dialogInterface);
                    }
                });
                create.show();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLeftApplication() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private Button homeB;

        private MyViewHolder(homeBAdapter homebadapter, View view) {
            super(view);
            this.homeB = (Button) view.findViewById(atlow.chemi.mymada.R.id.buttonChange);
        }

        /* synthetic */ MyViewHolder(homeBAdapter homebadapter, View view, AnonymousClass1 anonymousClass1) {
            this(homebadapter, view);
        }
    }

    public homeBAdapter(Activity activity, List<HomeB> list) {
        this.mContext = activity;
        this.albumList = list;
    }

    private static boolean isPI(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.groboot.mdaemergency");
        return launchIntentForPackage != null && packageManager.queryIntentActivities(launchIntentForPackage, 65536).size() > 0;
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.mContext, (Class<?>) codeRequest.class);
        intent.setFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public /* synthetic */ void a(SharedPreferences sharedPreferences, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.mContext, (Class<?>) lockPage.class);
        intent.setFlags(268435456);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("realM", false);
        edit.apply();
        this.mContext.startActivity(intent);
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(this.myTypeface);
        }
        Button button = alertDialog.getButton(-2);
        alertDialog.getButton(-1).setTypeface(this.myTypeface);
        button.setTypeface(this.myTypeface);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public /* synthetic */ void a(HomeB homeB, final SharedPreferences sharedPreferences, View view) {
        char c;
        Intent intent;
        final AlertDialog create;
        DialogInterface.OnShowListener onShowListener;
        InterstitialAd interstitialAd;
        AdListener anonymousClass1;
        String intent2 = homeB.getIntent();
        switch (intent2.hashCode()) {
            case 98690:
                if (intent2.equals("con")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 104417:
                if (intent2.equals("inf")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 108297:
                if (intent2.equals("mok")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 114722:
                if (intent2.equals("tes")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 115025:
                if (intent2.equals("tol")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            this.realM = sharedPreferences.getBoolean("realM", false);
            this.isMADA = false;
            if (this.mContext.getApplication().getPackageName().contains("debug")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, atlow.chemi.mymada.R.style.AlertDialogStyle);
                builder.setMessage("זוהי גרסה לבדיקה. עמוד חסימה או עמוד דיווחים?").setCancelable(true).setPositiveButton("עמוד חסימה", new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.u
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.this.a(sharedPreferences, dialogInterface, i);
                    }
                }).setNegativeButton("עמוד דיווחים", new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.t
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.this.b(sharedPreferences, dialogInterface, i);
                    }
                });
                create = builder.create();
                onShowListener = new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.adapters.w
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        homeBAdapter.this.a(create, dialogInterface);
                    }
                };
                create.setOnShowListener(onShowListener);
                create.show();
                return;
            }
            if (!this.realM) {
                this.isMADA = isPI(this.mContext);
            }
            if (this.realM || this.isMADA) {
                intent = new Intent(this.mContext, (Class<?>) MokedPage.class);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("realM", true);
                edit.apply();
            } else {
                intent = new Intent(this.mContext, (Class<?>) lockPage.class);
            }
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
        }
        if (c != 1) {
            if (c == 2) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this.mContext, atlow.chemi.mymada.R.style.AlertDialogStyle);
                builder2.setMessage(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.TestCallMsg)).setCancelable(true).setPositiveButton(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.TestCallSMS), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.v
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.this.c(sharedPreferences, dialogInterface, i);
                    }
                }).setNegativeButton(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.TestCallApp), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.x
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.this.d(sharedPreferences, dialogInterface, i);
                    }
                });
                create = builder2.create();
                onShowListener = new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.adapters.q
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        homeBAdapter.this.b(create, dialogInterface);
                    }
                };
            } else if (c == 3) {
                this.realM = sharedPreferences.getBoolean("realM", false);
                this.isMADA = false;
                if (!this.realM) {
                    this.isMADA = isPI(this.mContext);
                }
                InterstitialAd interstitialAd2 = this.openUp;
                if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
                    interstitialAd = this.openUp;
                    anonymousClass1 = new AnonymousClass1();
                    interstitialAd.setAdListener(anonymousClass1);
                    this.openUp.show();
                    return;
                }
                if (this.realM || this.isMADA) {
                    intent = new Intent(this.mContext, (Class<?>) contactChatActivity.class);
                } else {
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(this.mContext, atlow.chemi.mymada.R.style.AlertDialogStyle);
                    builder3.setTitle(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNote)).setMessage(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNoteCon)).setCancelable(true).setNegativeButton(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNoteConCode), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.r
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            homeBAdapter.this.a(dialogInterface, i);
                        }
                    }).setPositiveButton(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.title_activity_contact), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.adapters.z
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            homeBAdapter.this.b(dialogInterface, i);
                        }
                    });
                    create = builder3.create();
                    onShowListener = new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.adapters.p
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            homeBAdapter.this.c(create, dialogInterface);
                        }
                    };
                }
            } else {
                if (c != 4) {
                    return;
                }
                InterstitialAd interstitialAd3 = this.openUp;
                if (interstitialAd3 != null && interstitialAd3.isLoaded()) {
                    interstitialAd = this.openUp;
                    anonymousClass1 = new AdListener() { // from class: atlow.chemi.mymada.adapters.homeBAdapter.2
                        @Override // com.google.android.gms.ads.AdListener
                        public void onAdClosed() {
                            homeBAdapter.this.openUp.loadAd(new AdRequest.Builder().build());
                            Intent intent3 = new Intent(homeBAdapter.this.mContext, (Class<?>) InfoActivityKt.class);
                            intent3.setFlags(268435456);
                            homeBAdapter.this.mContext.startActivity(intent3);
                        }
                    };
                    interstitialAd.setAdListener(anonymousClass1);
                    this.openUp.show();
                    return;
                }
                intent = new Intent(this.mContext, (Class<?>) InfoActivityKt.class);
            }
            create.setOnShowListener(onShowListener);
            create.show();
            return;
        }
        intent = new Intent(this.mContext, (Class<?>) UtillitiesAndTools.class);
        intent.setFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public /* synthetic */ boolean a(MyViewHolder myViewHolder, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldY1 = motionEvent.getY();
            this.oldX1 = motionEvent.getX();
            this.isMove1 = false;
            myViewHolder.homeB.setAlpha(0.4f);
            return true;
        }
        if (action == 1) {
            myViewHolder.homeB.setAlpha(1.0f);
            if (!this.isMove1) {
                myViewHolder.homeB.performClick();
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        boolean z = this.oldX1 - motionEvent.getX() > 50.0f || motionEvent.getX() - this.oldX1 > 50.0f;
        boolean z2 = this.oldY1 - motionEvent.getY() > 50.0f || motionEvent.getY() - this.oldY1 > 50.0f;
        if (z || z2) {
            this.isMove1 = true;
            myViewHolder.homeB.setAlpha(1.0f);
        }
        return true;
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.mContext, (Class<?>) contactChatActivity.class);
        intent.setFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public /* synthetic */ void b(SharedPreferences sharedPreferences, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.mContext, (Class<?>) MokedPage.class);
        intent.setFlags(268435456);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("realM", true);
        edit.apply();
        this.mContext.startActivity(intent);
    }

    public /* synthetic */ void b(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(this.myTypeface);
        }
        Button button = alertDialog.getButton(-2);
        alertDialog.getButton(-1).setTypeface(this.myTypeface);
        button.setTypeface(this.myTypeface);
        button.setTextColor(this.mContext.getResources().getColor(atlow.chemi.mymada.R.color.OldPrimary));
    }

    public /* synthetic */ void c(SharedPreferences sharedPreferences, DialogInterface dialogInterface, int i) {
        PendingIntent pendingIntent;
        Activity activity;
        Resources resources;
        int i2;
        if ((!sharedPreferences.getBoolean("not", true) && !sharedPreferences.getBoolean("win", true)) || !sharedPreferences.getBoolean("Mapp", false)) {
            activity = this.mContext;
            resources = activity.getResources();
            i2 = atlow.chemi.mymada.R.string.APP_reco_off;
        } else {
            if (!sharedPreferences.getBoolean("cut", false) || sharedPreferences.getBoolean("callT3", true)) {
                Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("com.groboot.mdaemergency");
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(8388608);
                    pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, 0);
                } else {
                    pendingIntent = null;
                }
                Intent intent = new Intent("atlow.chemi.MyMada.MADA_APP");
                intent.setAction("atlow.chemi.MyMada.MADA_APP");
                intent.putExtra("callT", 3);
                intent.putExtra("text", this.mContext.getResources().getString(atlow.chemi.mymada.R.string.TEAMTest));
                GrobootRec.madasApp(pendingIntent);
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
                return;
            }
            activity = this.mContext;
            resources = activity.getResources();
            i2 = atlow.chemi.mymada.R.string.MISHM_reco_off;
        }
        Toast.makeText(activity, resources.getString(i2), 0).show();
    }

    public /* synthetic */ void c(AlertDialog alertDialog, DialogInterface dialogInterface) {
        TextView textView = (TextView) alertDialog.findViewById(R.id.message);
        if (textView != null) {
            textView.setTypeface(this.myTypeface);
        }
        TextView textView2 = (TextView) alertDialog.findViewById(R.id.title);
        if (textView2 != null) {
            textView2.setTypeface(this.myTypeface);
        }
        Button button = alertDialog.getButton(-2);
        alertDialog.getButton(-1).setTypeface(this.myTypeface);
        button.setTypeface(this.myTypeface);
        button.setTextColor(this.mContext.getResources().getColor(atlow.chemi.mymada.R.color.OldPrimary));
    }

    public /* synthetic */ void d(SharedPreferences sharedPreferences, DialogInterface dialogInterface, int i) {
        PendingIntent pendingIntent;
        Activity activity;
        Resources resources;
        int i2;
        if ((!sharedPreferences.getBoolean("not", true) && !sharedPreferences.getBoolean("win", true)) || !sharedPreferences.getBoolean("Mapp", false)) {
            activity = this.mContext;
            resources = activity.getResources();
            i2 = atlow.chemi.mymada.R.string.APP_reco_off;
        } else {
            if (!sharedPreferences.getBoolean("cut", false) || sharedPreferences.getBoolean("callT1", true)) {
                Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("com.groboot.mdaemergency");
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(8388608);
                    pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, 0);
                } else {
                    pendingIntent = null;
                }
                Intent intent = new Intent("atlow.chemi.MyMada.MADA_APP");
                intent.setAction("atlow.chemi.MyMada.MADA_APP");
                intent.putExtra("callT", 1);
                intent.putExtra("text", this.mContext.getResources().getString(atlow.chemi.mymada.R.string.CONANTest));
                GrobootRec.madasApp(pendingIntent);
                LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
                return;
            }
            activity = this.mContext;
            resources = activity.getResources();
            i2 = atlow.chemi.mymada.R.string.CONAN_reco_off;
        }
        Toast.makeText(activity, resources.getString(i2), 0).show();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.albumList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final HomeB homeB = this.albumList.get(myViewHolder.getAdapterPosition());
        final SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("Settings", 0);
        this.myTypeface = Typeface.createFromAsset(this.mContext.getAssets(), "fonts/opensanshebrew.ttf");
        try {
            this.btns.add(myViewHolder.homeB);
        } catch (NullPointerException e) {
            Log.e("not Added btn", e.getMessage());
        }
        MobileAds.initialize(this.mContext, "ca-app-pub-7600269766434003~4255496174");
        this.openUp = new InterstitialAd(this.mContext);
        this.openUp.setAdUnitId("ca-app-pub-7600269766434003/4483563620");
        this.openUp.loadAd(new AdRequest.Builder().build());
        int width = this.mContext.getWindowManager().getDefaultDisplay().getWidth() / 2;
        double d = width;
        Double.isNaN(d);
        double d2 = width * 2;
        Double.isNaN(d2);
        int i2 = (int) (d2 * 0.409d);
        myViewHolder.homeB.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (d * 0.8d)));
        if (homeB.getIntent().equals("tol")) {
            myViewHolder.homeB.setLayoutParams(new FrameLayout.LayoutParams(-1, i2));
        }
        myViewHolder.homeB.setBackgroundResource(homeB.getBg());
        myViewHolder.homeB.setOnTouchListener(new View.OnTouchListener() { // from class: atlow.chemi.mymada.adapters.s
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return homeBAdapter.this.a(myViewHolder, view, motionEvent);
            }
        });
        myViewHolder.homeB.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.adapters.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                homeBAdapter.this.a(homeB, sharedPreferences, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(atlow.chemi.mymada.R.layout.button_change, viewGroup, false), null);
    }

    public void setBtnsAlpha() {
        Iterator<Button> it = this.btns.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
        }
    }
}
