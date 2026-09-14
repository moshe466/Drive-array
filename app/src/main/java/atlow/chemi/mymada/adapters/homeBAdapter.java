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
import atlow.chemi.mymada.SimulatePage;
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
public class homeBAdapter extends RecyclerView.Adapter<homeBAdapter.MyViewHolder> {
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


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private Button homeB;

        public MyViewHolder(View view) {
            super(view);
            this.homeB = (Button) view.findViewById(atlow.chemi.mymada.R.id.buttonChange);
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
        String intent2 = homeB.getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.equals("mok")) {
            Intent intent = new Intent(this.mContext, (Class<?>) MokedPage.class);
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
            return;
        }
        if (intent2.equals("tes")) {
            showSimulatePopup(sharedPreferences);
            return;
        }
        if (intent2.equals("con")) {
            this.realM = sharedPreferences.getBoolean("realM", false);
            this.isMADA = false;
            if (!this.realM) {
                this.isMADA = isPI(this.mContext);
            }
            if (this.openUp != null && this.openUp.isLoaded()) {
                this.openUp.setAdListener(new AnonymousClass1());
                this.openUp.show();
                return;
            }
            if (this.realM || this.isMADA) {
                Intent intent = new Intent(this.mContext, (Class<?>) contactChatActivity.class);
                intent.setFlags(268435456);
                this.mContext.startActivity(intent);
            } else {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this.mContext, atlow.chemi.mymada.R.style.AlertDialogStyle);
                builder3.setTitle(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNote)).setMessage(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNoteCon)).setCancelable(true).setNegativeButton(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.plsNoteConCode), new DialogInterface.OnClickListener() {
                    @Override
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.this.a(dialogInterface, i);
                    }
                }).setPositiveButton(this.mContext.getResources().getString(atlow.chemi.mymada.R.string.title_activity_contact), new DialogInterface.OnClickListener() {
                    @Override
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        homeBAdapter.this.b(dialogInterface, i);
                    }
                });
                final AlertDialog create3 = builder3.create();
                create3.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public final void onShow(DialogInterface dialogInterface) {
                        homeBAdapter.this.c(create3, dialogInterface);
                    }
                });
                create3.show();
            }
            return;
        }
        if (intent2.equals("inf")) {
            Intent intent3 = new Intent(this.mContext, (Class<?>) InfoActivityKt.class);
            intent3.setFlags(268435456);
            this.mContext.startActivity(intent3);
            return;
        }
        if (intent2.equals("tol")) {
            Intent intent = new Intent(this.mContext, (Class<?>) UtillitiesAndTools.class);
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
            return;
        }
    }

    private void showSimulatePopup(final SharedPreferences sharedPreferences) {
        if (this.mContext == null || this.mContext.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, atlow.chemi.mymada.R.style.AlertDialogStyle);
        View dialogView = LayoutInflater.from(this.mContext).inflate(atlow.chemi.mymada.R.layout.dialog_simulate_popup, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        try {
            if (this.myTypeface != null) {
                TextView tvTitle = (TextView) dialogView.findViewById(atlow.chemi.mymada.R.id.tv_popup_title);
                TextView tvSubtitle = (TextView) dialogView.findViewById(atlow.chemi.mymada.R.id.tv_popup_subtitle);
                TextView tvHatzalah = (TextView) dialogView.findViewById(atlow.chemi.mymada.R.id.tv_popup_hatzalah);
                TextView tvMda = (TextView) dialogView.findViewById(atlow.chemi.mymada.R.id.tv_popup_mda);
                TextView btnClose = (TextView) dialogView.findViewById(atlow.chemi.mymada.R.id.btn_popup_close);
                if (tvTitle != null) tvTitle.setTypeface(this.myTypeface);
                if (tvSubtitle != null) tvSubtitle.setTypeface(this.myTypeface);
                if (tvHatzalah != null) tvHatzalah.setTypeface(this.myTypeface);
                if (tvMda != null) tvMda.setTypeface(this.myTypeface);
                if (btnClose != null) btnClose.setTypeface(this.myTypeface);
            }
        } catch (Exception ignored) {
        }

        View cardHatzalah = dialogView.findViewById(atlow.chemi.mymada.R.id.card_popup_hatzalah);
        if (cardHatzalah != null) {
            cardHatzalah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    simulateHatzalah(sharedPreferences);
                }
            });
        }

        View cardMda = dialogView.findViewById(atlow.chemi.mymada.R.id.card_popup_mda);
        if (cardMda != null) {
            cardMda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    simulateMda(sharedPreferences);
                }
            });
        }

        View btnClose = dialogView.findViewById(atlow.chemi.mymada.R.id.btn_popup_close);
        if (btnClose != null) {
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        dialog.show();
    }

    private void simulateHatzalah(SharedPreferences sharedPreferences) {
        PendingIntent pendingIntent;
        if ((!sharedPreferences.getBoolean("not", true) && !sharedPreferences.getBoolean("win", true)) || !sharedPreferences.getBoolean("Mapp", false)) {
            Toast.makeText(this.mContext, this.mContext.getResources().getString(atlow.chemi.mymada.R.string.APP_reco_off), Toast.LENGTH_SHORT).show();
        } else {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("com.uh.sf");
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(8388608);
                pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
            } else {
                pendingIntent = null;
            }
            Intent intent = new Intent("atlow.chemi.MyMada.MADA_APP");
            intent.setAction("atlow.chemi.MyMada.MADA_APP");
            intent.putExtra("callT", 1);
            intent.putExtra("text", "איחוד הצלה: קריאת חירום כוננים - בדיקה ודימוי מקרה");
            GrobootRec.madasApp(pendingIntent);
            LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
            Toast.makeText(this.mContext, "דימוי קריאה - איחוד הצלה", Toast.LENGTH_SHORT).show();
        }
    }

    private void simulateMda(SharedPreferences sharedPreferences) {
        PendingIntent pendingIntent;
        if ((!sharedPreferences.getBoolean("not", true) && !sharedPreferences.getBoolean("win", true)) || !sharedPreferences.getBoolean("Mapp", false)) {
            Toast.makeText(this.mContext, this.mContext.getResources().getString(atlow.chemi.mymada.R.string.APP_reco_off), Toast.LENGTH_SHORT).show();
        } else {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("il.org.mda.health");
            if (launchIntentForPackage == null) {
                launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("com.groboot.mdaemergency");
            }
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(8388608);
                pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
            } else {
                pendingIntent = null;
            }
            Intent intent = new Intent("atlow.chemi.MyMada.MADA_APP");
            intent.setAction("atlow.chemi.MyMada.MADA_APP");
            intent.putExtra("callT", 2);
            intent.putExtra("text", this.mContext.getResources().getString(atlow.chemi.mymada.R.string.CONANTest));
            GrobootRec.madasApp(pendingIntent);
            LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
            Toast.makeText(this.mContext, "דימוי קריאה - מד״א", Toast.LENGTH_SHORT).show();
        }
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
                    pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
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
                    pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
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
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(atlow.chemi.mymada.R.layout.button_change, viewGroup, false));
    }

    public void setBtnsAlpha() {
        Iterator<Button> it = this.btns.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
        }
    }
}
