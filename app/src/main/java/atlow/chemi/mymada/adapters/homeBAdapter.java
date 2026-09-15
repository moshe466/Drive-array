package atlow.chemi.mymada.adapters;

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
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import atlow.chemi.mymada.MokedPage;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.SettingsPage;
import atlow.chemi.mymada.UserGuideActivity;
import atlow.chemi.mymada.UtillitiesAndTools;
import atlow.chemi.mymada.classes.HomeB;
import atlow.chemi.mymada.codeRequest;
import atlow.chemi.mymada.contactChatActivity;
import atlow.chemi.mymada.lockPage;
import atlow.chemi.mymada.recieversAndServices.GrobootRec;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class homeBAdapter extends RecyclerView.Adapter<homeBAdapter.MyViewHolder> {
    private List<HomeB> albumList;
    private boolean isMADA;
    private Activity mContext;
    private Typeface myTypeface;
    private InterstitialAd openUp;
    private boolean realM;

    /* loaded from: classes.dex */
    public class AnonymousClass1 extends AdListener {
        AnonymousClass1() {
        }

        public void a(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) codeRequest.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            homeBAdapter.this.mContext.startActivity(intent);
        }

        public void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
            TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
            if (textView != null && homeBAdapter.this.myTypeface != null) {
                textView.setTypeface(homeBAdapter.this.myTypeface);
            }
            TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.title);
            if (textView2 != null && homeBAdapter.this.myTypeface != null) {
                textView2.setTypeface(homeBAdapter.this.myTypeface);
            }
            View button = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            if (button instanceof TextView && homeBAdapter.this.myTypeface != null) {
                ((TextView) button).setTypeface(homeBAdapter.this.myTypeface);
            }
        }

        public void b(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) contactChatActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            homeBAdapter.this.mContext.startActivity(intent);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            if (homeBAdapter.this.openUp != null) {
                homeBAdapter.this.openUp.loadAd(new AdRequest.Builder().build());
            }
            if (homeBAdapter.this.realM || homeBAdapter.this.isMADA) {
                Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) contactChatActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                homeBAdapter.this.mContext.startActivity(intent);
            } else {
                homeBAdapter.this.showNotVolunteerDialog();
            }
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView card;
        public ImageView ivIcon;
        public TextView tvTitle;
        public TextView tvSubtitle;

        public MyViewHolder(View view) {
            super(view);
            this.card = (CardView) view.findViewById(R.id.card);
            this.ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.tvSubtitle = (TextView) view.findViewById(R.id.tvSubtitle);
        }
    }

    public homeBAdapter(Activity activity, List<HomeB> list) {
        this.mContext = activity;
        this.albumList = list;
        try {
            this.myTypeface = Typeface.createFromAsset(activity.getAssets(), "fonts/opensanshebrew.ttf");
        } catch (Exception ignored) {
        }
    }

    private static boolean isPI(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.groboot.mdaemergency");
        return launchIntentForPackage != null && packageManager.queryIntentActivities(launchIntentForPackage, PackageManager.MATCH_DEFAULT_ONLY).size() > 0;
    }

    private void showNotVolunteerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, R.style.AlertDialogStyle);
        builder.setTitle(this.mContext.getString(R.string.plsNote))
                .setMessage(this.mContext.getString(R.string.plsNoteCon))
                .setCancelable(true)
                .setNegativeButton(this.mContext.getString(R.string.plsNoteConCode), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) codeRequest.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        homeBAdapter.this.mContext.startActivity(intent);
                    }
                })
                .setPositiveButton(this.mContext.getString(R.string.title_activity_contact), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(homeBAdapter.this.mContext, (Class<?>) contactChatActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        homeBAdapter.this.mContext.startActivity(intent);
                    }
                });
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                if (homeBAdapter.this.myTypeface != null) {
                    TextView tvMsg = (TextView) create.findViewById(android.R.id.message);
                    TextView tvTitle = (TextView) create.findViewById(android.R.id.title);
                    if (tvMsg != null) tvMsg.setTypeface(homeBAdapter.this.myTypeface);
                    if (tvTitle != null) tvTitle.setTypeface(homeBAdapter.this.myTypeface);
                }
            }
        });
        create.show();
    }

    public void handleCardClick(HomeB homeB, final SharedPreferences sharedPreferences) {
        String intent2 = homeB.getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.equals("tol")) {
            Intent intent = new Intent(this.mContext, (Class<?>) UtillitiesAndTools.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.mContext.startActivity(intent);
            return;
        }
        if (intent2.equals("mok")) {
            Intent intent = new Intent(this.mContext, (Class<?>) MokedPage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.mContext.startActivity(intent);
            return;
        }
        if (intent2.equals("tes")) {
            showSimulatePopup(sharedPreferences);
            return;
        }
        if (intent2.equals("gui")) {
            Intent intent = new Intent(this.mContext, (Class<?>) UserGuideActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.mContext.startActivity(intent);
            return;
        }
        if (intent2.equals("set")) {
            Intent intent = new Intent(this.mContext, (Class<?>) SettingsPage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.mContext.startActivity(intent);
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
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.mContext.startActivity(intent);
            } else {
                showNotVolunteerDialog();
            }
        }
    }

    public void showSimulatePopup(final SharedPreferences sharedPreferences) {
        if (this.mContext == null || this.mContext.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, R.style.AlertDialogStyle);
        View dialogView = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_simulate_popup, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        try {
            if (this.myTypeface != null) {
                TextView tvTitle = (TextView) dialogView.findViewById(R.id.tv_popup_title);
                TextView tvSubtitle = (TextView) dialogView.findViewById(R.id.tv_popup_subtitle);
                TextView tvHatzalah = (TextView) dialogView.findViewById(R.id.tv_popup_hatzalah);
                TextView tvMda = (TextView) dialogView.findViewById(R.id.tv_popup_mda);
                TextView btnClose = (TextView) dialogView.findViewById(R.id.btn_popup_close);
                if (tvTitle != null) tvTitle.setTypeface(this.myTypeface);
                if (tvSubtitle != null) tvSubtitle.setTypeface(this.myTypeface);
                if (tvHatzalah != null) tvHatzalah.setTypeface(this.myTypeface);
                if (tvMda != null) tvMda.setTypeface(this.myTypeface);
                if (btnClose != null) btnClose.setTypeface(this.myTypeface);
            }
        } catch (Exception ignored) {
        }

        View cardHatzalah = dialogView.findViewById(R.id.card_popup_hatzalah);
        if (cardHatzalah != null) {
            cardHatzalah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    simulateHatzalah(sharedPreferences);
                }
            });
        }

        View cardMda = dialogView.findViewById(R.id.card_popup_mda);
        if (cardMda != null) {
            cardMda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    simulateMda(sharedPreferences);
                }
            });
        }

        View btnClose = dialogView.findViewById(R.id.btn_popup_close);
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
            Toast.makeText(this.mContext, this.mContext.getString(R.string.APP_reco_off), Toast.LENGTH_SHORT).show();
        } else {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("com.uh.sf");
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
            } else {
                pendingIntent = null;
            }
            Intent intent = new Intent("atlow.chemi.MyMada.MADA_APP");
            intent.setAction("atlow.chemi.MyMada.MADA_APP");
            intent.putExtra("callT", 1);
            intent.putExtra("text", this.mContext.getString(R.string.UHTest));
            intent.putExtra("address", "ירושלים ירמיהו 78");
            intent.putExtra("org_title", "איחוד הצלה - קריאת חירום");
            GrobootRec.madasApp(pendingIntent);
            LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
            Toast.makeText(this.mContext, "דימוי קריאה - איחוד הצלה", Toast.LENGTH_SHORT).show();
        }
    }

    private void simulateMda(SharedPreferences sharedPreferences) {
        PendingIntent pendingIntent;
        if ((!sharedPreferences.getBoolean("not", true) && !sharedPreferences.getBoolean("win", true)) || !sharedPreferences.getBoolean("Mapp", false)) {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.APP_reco_off), Toast.LENGTH_SHORT).show();
        } else {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("il.org.mda.health");
            if (launchIntentForPackage == null) {
                launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage("com.groboot.mdaemergency");
            }
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                pendingIntent = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), launchIntentForPackage, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
            } else {
                pendingIntent = null;
            }
            Intent intent = new Intent("atlow.chemi.MyMada.MADA_APP");
            intent.setAction("atlow.chemi.MyMada.MADA_APP");
            intent.putExtra("callT", 2);
            intent.putExtra("text", this.mContext.getString(R.string.CONANTest));
            intent.putExtra("address", "ירושלים המ\"ג 7");
            intent.putExtra("org_title", "מד״א - קריאת חירום");
            GrobootRec.madasApp(pendingIntent);
            LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
            Toast.makeText(this.mContext, "דימוי קריאה - מד״א", Toast.LENGTH_SHORT).show();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.albumList != null ? this.albumList.size() : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final HomeB homeB = this.albumList.get(myViewHolder.getAdapterPosition());
        final SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("Settings", 0);

        String tag = homeB.getIntent();
        if (tag == null) tag = "";

        int titleRes;
        int subRes;
        int iconRes;

        switch (tag) {
            case "tol":
                titleRes = R.string.card_tools_title;
                subRes = R.string.card_tools_sub;
                iconRes = R.drawable.new_tol;
                break;
            case "mok":
                titleRes = R.string.card_moked_title;
                subRes = R.string.card_moked_sub;
                iconRes = R.drawable.new_mok;
                break;
            case "tes":
                titleRes = R.string.card_simulate_title;
                subRes = R.string.card_simulate_sub;
                iconRes = R.drawable.new_tes;
                break;
            case "gui":
                titleRes = R.string.card_guide_title;
                subRes = R.string.card_guide_sub;
                iconRes = R.drawable.new_inf;
                break;
            case "set":
                titleRes = R.string.card_settings_title;
                subRes = R.string.card_settings_sub;
                iconRes = R.drawable.ic_settings;
                break;
            case "con":
                titleRes = R.string.card_contact_title;
                subRes = R.string.card_contact_sub;
                iconRes = R.drawable.new_con;
                break;
            default:
                titleRes = R.string.card_tools_title;
                subRes = R.string.card_tools_sub;
                iconRes = homeB.getBg() != 0 ? homeB.getBg() : R.drawable.new_tol;
                break;
        }

        if (myViewHolder.tvTitle != null) {
            myViewHolder.tvTitle.setText(titleRes);
            if (this.myTypeface != null) {
                myViewHolder.tvTitle.setTypeface(this.myTypeface);
            }
        }
        if (myViewHolder.tvSubtitle != null) {
            myViewHolder.tvSubtitle.setText(subRes);
            if (this.myTypeface != null) {
                myViewHolder.tvSubtitle.setTypeface(this.myTypeface);
            }
        }
        if (myViewHolder.ivIcon != null) {
            myViewHolder.ivIcon.setImageResource(iconRes);
            ViewGroup.LayoutParams lp = myViewHolder.ivIcon.getLayoutParams();
            if (lp != null) {
                if ("tol".equals(tag)) {
                    // 2.5x larger for Tools & Utilities (כלי עזר) icon
                    int widthPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170, this.mContext.getResources().getDisplayMetrics());
                    int heightPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, this.mContext.getResources().getDisplayMetrics());
                    lp.width = widthPx;
                    lp.height = heightPx;
                } else {
                    int sizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, this.mContext.getResources().getDisplayMetrics());
                    lp.width = sizePx;
                    lp.height = sizePx;
                }
                myViewHolder.ivIcon.setLayoutParams(lp);
            }
        }

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeBAdapter.this.handleCardClick(homeB, sharedPreferences);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_action_home, viewGroup, false));
    }

    public void setBtnsAlpha() {
        // No-op for compatibility
    }
}
