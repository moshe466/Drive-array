package atlow.chemi.mymada.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class SettingsNotificationsSounds extends Fragment implements View.OnClickListener {
    private static final int PERMISSION_T = 100;
    private static final int PERMISSION_T1 = 101;
    private static final int PERMISSION_T2 = 102;
    private static final int PERMISSION_T3 = 103;
    private static final int PERMISSION_T4 = 104;
    private SwitchCompat NappT;
    private SwitchCompat NappT1;
    private TextView NappT1_Desc;
    private ConstraintLayout NappT1_Pref;
    private SwitchCompat NappT2;
    private TextView NappT2_Desc;
    private ConstraintLayout NappT2_Pref;
    private SwitchCompat NappT3;
    private TextView NappT3_Desc;
    private ConstraintLayout NappT3_Pref;
    private SwitchCompat NappT4;
    private TextView NappT4_Desc;
    private ConstraintLayout NappT4_Pref;
    private TextView NappT_Desc;
    private ConstraintLayout NappT_Pref;
    private ConstraintLayout NrinT1_Pref;
    private ConstraintLayout NrinT2_Pref;
    private ConstraintLayout NrinT3_Pref;
    private ConstraintLayout NrinT4_Pref;
    private ConstraintLayout NrinT_Pref;
    private SwitchCompat NsouT;
    private SwitchCompat NsouT1;
    private TextView NsouT1_Desc;
    private ConstraintLayout NsouT1_Pref;
    private SwitchCompat NsouT2;
    private TextView NsouT2_Desc;
    private ConstraintLayout NsouT2_Pref;
    private SwitchCompat NsouT3;
    private TextView NsouT3_Desc;
    private ConstraintLayout NsouT3_Pref;
    private SwitchCompat NsouT4;
    private TextView NsouT4_Desc;
    private TextView NsouT_Desc;
    private SwitchCompat NvibT;
    private SwitchCompat NvibT1;
    private TextView NvibT1_Desc;
    private ConstraintLayout NvibT1_Pref;
    private SwitchCompat NvibT2;
    private TextView NvibT2_Desc;
    private ConstraintLayout NvibT2_Pref;
    private SwitchCompat NvibT3;
    private TextView NvibT3_Desc;
    private ConstraintLayout NvibT3_Pref;
    private SwitchCompat NvibT4;
    private TextView NvibT4_Desc;
    private TextView NvibT_Desc;
    private SwitchCompat findT1;
    private TextView findT1_Desc;
    private SwitchCompat findT2;
    private TextView findT2_Desc;
    private SwitchCompat findT3;
    private TextView findT3_Desc;
    private SharedPreferences permissionStatus;
    private String[] permissionsRequired = {"android.permission.READ_EXTERNAL_STORAGE"};
    private int retPer = 100;
    private boolean sentToSettings = false;
    private SharedPreferences sp;

    private void getAllowed(int i) {
        AlertDialog.Builder builder;
        String string;
        DialogInterface.OnClickListener onClickListener;
        this.retPer = i == 0 ? 100 : i == 1 ? 101 : i == 2 ? 102 : i == 3 ? 103 : 104;
        if (ContextCompat.checkSelfPermission(getActivity(), this.permissionsRequired[0]) != 0) {
            if (shouldShowRequestPermissionRationale(this.permissionsRequired[0])) {
                builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
                builder.setTitle(getActivity().getResources().getString(R.string.permTitle));
                builder.setMessage(getActivity().getResources().getString(R.string.permDesSD));
                builder.setPositiveButton(getActivity().getResources().getString(R.string.permYes), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.e1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        SettingsNotificationsSounds.this.a(dialogInterface, i2);
                    }
                });
                string = getActivity().getString(R.string.ret);
                onClickListener = new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.h1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        SettingsNotificationsSounds.this.b(dialogInterface, i2);
                    }
                };
            } else {
                if (!this.permissionStatus.getBoolean(this.permissionsRequired[0], false)) {
                    requestPermissions(this.permissionsRequired, this.retPer);
                    SharedPreferences.Editor edit = this.permissionStatus.edit();
                    edit.putBoolean(this.permissionsRequired[0], true);
                    edit.apply();
                }
                builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
                builder.setTitle(getActivity().getResources().getString(R.string.permTitle));
                builder.setMessage(getActivity().getResources().getString(R.string.permDesSD));
                builder.setPositiveButton(getActivity().getResources().getString(R.string.permYes), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.g1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        SettingsNotificationsSounds.this.c(dialogInterface, i2);
                    }
                });
                string = getActivity().getString(R.string.ret);
                onClickListener = new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.f1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        SettingsNotificationsSounds.this.d(dialogInterface, i2);
                    }
                };
            }
            builder.setNegativeButton(string, onClickListener);
            builder.show();
            SharedPreferences.Editor edit2 = this.permissionStatus.edit();
            edit2.putBoolean(this.permissionsRequired[0], true);
            edit2.apply();
        }
    }

    private void ringtoner(int i) {
        String str;
        if (ContextCompat.checkSelfPermission(getActivity(), this.permissionsRequired[0]) != 0) {
            getAllowed(i);
            return;
        }
        if (i > 0) {
            str = "NuRiT" + i;
        } else {
            str = "NuRi";
        }
        Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
        intent.putExtra("android.intent.extra.ringtone.TITLE", getString(R.string.pick_sound));
        intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", false);
        intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        intent.putExtra("android.intent.extra.ringtone.TYPE", 7);
        intent.putExtra("android.intent.extra.ringtone.PICKED_URI", Uri.parse(this.sp.getString(str, RingtoneManager.getDefaultUri(7).toString())));
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(this.sp.getString(str, RingtoneManager.getDefaultUri(7).toString())));
        startActivityForResult(intent, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        if (r14 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ea, code lost:
    
        r3.setVisibility(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e9, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
    
        if (r14 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e7, code lost:
    
        if (r14 != false) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setTrueOrFalse(boolean r14, int r15) {
        /*
            Method dump skipped, instructions count: 1234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.fragments.SettingsNotificationsSounds.setTrueOrFalse(boolean, int):void");
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        requestPermissions(this.permissionsRequired, this.retPer);
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        int i2 = this.retPer;
        (i2 == 100 ? this.NappT_Pref : i2 == 101 ? this.NappT1_Pref : i2 == 102 ? this.NappT2_Pref : i2 == 103 ? this.NappT3_Pref : this.NappT4_Pref).performClick();
    }

    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.sentToSettings = true;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getActivity().getPackageName(), null));
        startActivityForResult(intent, this.retPer);
    }

    public /* synthetic */ void d(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        int i2 = this.retPer;
        (i2 == 100 ? this.NappT_Pref : i2 == 101 ? this.NappT1_Pref : i2 == 102 ? this.NappT2_Pref : i2 == 103 ? this.NappT3_Pref : this.NappT4_Pref).performClick();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        String uri;
        Uri parse = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.alert);
        if (i < 6 && i2 == -1) {
            try {
                parse = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
            } catch (Exception e) {
                Crashlytics.log("didn't parce the ringtone!");
                Crashlytics.logException(e);
            }
            SharedPreferences.Editor edit = this.sp.edit();
            if (parse != null) {
                if (i == 0) {
                    uri = parse.toString();
                    str = "NuRi";
                } else {
                    if (i == 1 || i == 2 || i == 3 || i == 4) {
                        str = "NuRiT" + i;
                        uri = parse.toString();
                    }
                    edit.apply();
                }
                edit.putString(str, uri);
                edit.apply();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SwitchCompat switchCompat;
        String string;
        TextView textView;
        String str;
        TextView textView2;
        SwitchCompat switchCompat2;
        TextView textView3;
        SwitchCompat switchCompat3;
        String string2;
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        Resources resources3;
        int i3;
        SharedPreferences.Editor edit = this.sp.edit();
        boolean z = false;
        r12 = false;
        boolean z2 = false;
        r12 = false;
        boolean z3 = false;
        r12 = false;
        boolean z4 = false;
        r12 = false;
        boolean z5 = false;
        z = false;
        switch (view.getId()) {
            case R.id.NappT1_pref /* 2131361851 */:
                switchCompat = this.NappT1;
                boolean z6 = !switchCompat.isChecked();
                if (z6) {
                    getAllowed(1);
                }
                Resources resources4 = getResources();
                string = !z6 ? resources4.getString(R.string.pref_description_app_off) : resources4.getString(R.string.pref_description_app_on);
                edit.putBoolean("NappT1", z6);
                this.NrinT1_Pref.setClickable(z6);
                this.NrinT1_Pref.setAlpha(z6 ? 1.0f : 0.4f);
                textView = this.NappT1_Desc;
                str = string;
                SwitchCompat switchCompat4 = switchCompat;
                textView2 = textView;
                switchCompat2 = switchCompat4;
                break;
            case R.id.NappT2_pref /* 2131361856 */:
                switchCompat = this.NappT2;
                boolean z7 = !switchCompat.isChecked();
                if (z7) {
                    getAllowed(2);
                }
                Resources resources5 = getResources();
                string = !z7 ? resources5.getString(R.string.pref_description_app_off) : resources5.getString(R.string.pref_description_app_on);
                edit.putBoolean("NappT2", z7);
                this.NrinT2_Pref.setClickable(z7);
                this.NrinT2_Pref.setAlpha(z7 ? 1.0f : 0.4f);
                textView = this.NappT2_Desc;
                str = string;
                SwitchCompat switchCompat42 = switchCompat;
                textView2 = textView;
                switchCompat2 = switchCompat42;
                break;
            case R.id.NappT3_pref /* 2131361861 */:
                switchCompat = this.NappT3;
                boolean z8 = !switchCompat.isChecked();
                if (z8) {
                    getAllowed(3);
                }
                Resources resources6 = getResources();
                string = !z8 ? resources6.getString(R.string.pref_description_app_off) : resources6.getString(R.string.pref_description_app_on);
                edit.putBoolean("NappT3", z8);
                this.NrinT3_Pref.setClickable(z8);
                this.NrinT3_Pref.setAlpha(z8 ? 1.0f : 0.4f);
                textView = this.NappT3_Desc;
                str = string;
                SwitchCompat switchCompat422 = switchCompat;
                textView2 = textView;
                switchCompat2 = switchCompat422;
                break;
            case R.id.NappT4_pref /* 2131361866 */:
                switchCompat = this.NappT4;
                boolean z9 = !switchCompat.isChecked();
                if (z9) {
                    getAllowed(4);
                }
                string = this.NappT4.isChecked() ? getResources().getString(R.string.pref_description_app_off) : getResources().getString(R.string.pref_description_app_on);
                edit.putBoolean("NappT4", z9);
                this.NrinT4_Pref.setClickable(z9);
                this.NrinT4_Pref.setAlpha(z9 ? 1.0f : 0.4f);
                textView = this.NappT4_Desc;
                str = string;
                SwitchCompat switchCompat4222 = switchCompat;
                textView2 = textView;
                switchCompat2 = switchCompat4222;
                break;
            case R.id.NappT_pref /* 2131361870 */:
                switchCompat2 = this.NappT;
                boolean z10 = !switchCompat2.isChecked();
                if (z10) {
                    getAllowed(0);
                }
                Resources resources7 = getResources();
                String string3 = !z10 ? resources7.getString(R.string.pref_description_app_off) : resources7.getString(R.string.pref_description_app_on);
                edit.putBoolean("Napp", z10);
                this.NrinT_Pref.setClickable(z10);
                this.NrinT_Pref.setAlpha(z10 ? 1.0f : 0.4f);
                textView3 = this.NappT_Desc;
                str = string3;
                textView2 = textView3;
                break;
            case R.id.NrinT1_pref /* 2131361872 */:
                ringtoner(1);
                switchCompat2 = null;
                str = null;
                textView2 = null;
                break;
            case R.id.NrinT2_pref /* 2131361874 */:
                ringtoner(2);
                switchCompat2 = null;
                str = null;
                textView2 = null;
                break;
            case R.id.NrinT3_pref /* 2131361876 */:
                ringtoner(3);
                switchCompat2 = null;
                str = null;
                textView2 = null;
                break;
            case R.id.NrinT4_pref /* 2131361878 */:
                ringtoner(4);
                switchCompat2 = null;
                str = null;
                textView2 = null;
                break;
            case R.id.NrinT_pref /* 2131361880 */:
                ringtoner(0);
                switchCompat2 = null;
                str = null;
                textView2 = null;
                break;
            case R.id.NsouT1_pref /* 2131361886 */:
                switchCompat2 = this.NsouT1;
                boolean z11 = !switchCompat2.isChecked();
                Resources resources8 = getResources();
                str = !z11 ? resources8.getString(R.string.pref_description_ringtone_off) : resources8.getString(R.string.pref_description_ringtone_on);
                edit.putBoolean("NsouT1", z11);
                ConstraintLayout constraintLayout = this.NrinT1_Pref;
                if (z11 && this.NappT1.isChecked()) {
                    z = true;
                }
                constraintLayout.setClickable(z);
                this.NrinT1_Pref.setAlpha((z11 && this.NappT1.isChecked()) ? 1.0f : 0.4f);
                this.NappT1_Pref.setClickable(z11);
                this.NappT1_Pref.setAlpha(z11 ? 1.0f : 0.4f);
                textView2 = this.NsouT1_Desc;
                break;
            case R.id.NsouT2_pref /* 2131361891 */:
                switchCompat2 = this.NsouT2;
                boolean z12 = !switchCompat2.isChecked();
                Resources resources9 = getResources();
                str = !z12 ? resources9.getString(R.string.pref_description_ringtone_off) : resources9.getString(R.string.pref_description_ringtone_on);
                edit.putBoolean("NsouT2", z12);
                ConstraintLayout constraintLayout2 = this.NrinT2_Pref;
                if (z12 && this.NappT2.isChecked()) {
                    z5 = true;
                }
                constraintLayout2.setClickable(z5);
                this.NrinT2_Pref.setAlpha((z12 && this.NappT2.isChecked()) ? 1.0f : 0.4f);
                this.NappT2_Pref.setClickable(z12);
                this.NappT2_Pref.setAlpha(z12 ? 1.0f : 0.4f);
                textView2 = this.NsouT2_Desc;
                break;
            case R.id.NsouT3_pref /* 2131361896 */:
                switchCompat2 = this.NsouT3;
                boolean z13 = !switchCompat2.isChecked();
                Resources resources10 = getResources();
                str = !z13 ? resources10.getString(R.string.pref_description_ringtone_off) : resources10.getString(R.string.pref_description_ringtone_on);
                edit.putBoolean("NsouT3", z13);
                ConstraintLayout constraintLayout3 = this.NrinT3_Pref;
                if (z13 && this.NappT3.isChecked()) {
                    z4 = true;
                }
                constraintLayout3.setClickable(z4);
                this.NrinT3_Pref.setAlpha((z13 && this.NappT3.isChecked()) ? 1.0f : 0.4f);
                this.NappT3_Pref.setClickable(z13);
                this.NappT3_Pref.setAlpha(z13 ? 1.0f : 0.4f);
                textView2 = this.NsouT3_Desc;
                break;
            case R.id.NsouT4_pref /* 2131361901 */:
                switchCompat2 = this.NsouT4;
                boolean z14 = !switchCompat2.isChecked();
                str = this.NsouT4.isChecked() ? getResources().getString(R.string.pref_description_ringtone_off) : getResources().getString(R.string.pref_description_ringtone_on);
                edit.putBoolean("NsouT4", z14);
                ConstraintLayout constraintLayout4 = this.NrinT4_Pref;
                if (z14 && this.NappT4.isChecked()) {
                    z3 = true;
                }
                constraintLayout4.setClickable(z3);
                this.NrinT4_Pref.setAlpha((z14 && this.NappT4.isChecked()) ? 1.0f : 0.4f);
                this.NappT4_Pref.setClickable(z14);
                this.NappT4_Pref.setAlpha(z14 ? 1.0f : 0.4f);
                textView2 = this.NsouT4_Desc;
                break;
            case R.id.NsouT_pref /* 2131361905 */:
                switchCompat2 = this.NsouT;
                boolean z15 = !switchCompat2.isChecked();
                Resources resources11 = getResources();
                str = !z15 ? resources11.getString(R.string.pref_description_ringtone_off) : resources11.getString(R.string.pref_description_ringtone_on);
                edit.putBoolean("Nsou", z15);
                ConstraintLayout constraintLayout5 = this.NrinT_Pref;
                if (z15 && this.NappT.isChecked()) {
                    z2 = true;
                }
                constraintLayout5.setClickable(z2);
                this.NrinT_Pref.setAlpha((z15 && this.NappT.isChecked()) ? 1.0f : 0.4f);
                this.NappT_Pref.setClickable(z15);
                this.NappT_Pref.setAlpha(z15 ? 1.0f : 0.4f);
                textView2 = this.NsouT_Desc;
                break;
            case R.id.NvibT1_pref /* 2131361911 */:
                switchCompat3 = this.NvibT1;
                string2 = switchCompat3.isChecked() ? getResources().getString(R.string.pref_description_vibrate_off) : getResources().getString(R.string.pref_description_vibrate_on);
                edit.putBoolean("NvibT1", !switchCompat3.isChecked());
                textView3 = this.NvibT1_Desc;
                str = string2;
                switchCompat2 = switchCompat3;
                textView2 = textView3;
                break;
            case R.id.NvibT2_pref /* 2131361916 */:
                switchCompat3 = this.NvibT2;
                string2 = switchCompat3.isChecked() ? getResources().getString(R.string.pref_description_vibrate_off) : getResources().getString(R.string.pref_description_vibrate_on);
                edit.putBoolean("NvibT2", !switchCompat3.isChecked());
                textView3 = this.NvibT2_Desc;
                str = string2;
                switchCompat2 = switchCompat3;
                textView2 = textView3;
                break;
            case R.id.NvibT3_pref /* 2131361921 */:
                switchCompat3 = this.NvibT3;
                string2 = switchCompat3.isChecked() ? getResources().getString(R.string.pref_description_vibrate_off) : getResources().getString(R.string.pref_description_vibrate_on);
                edit.putBoolean("NvibT3", !switchCompat3.isChecked());
                textView3 = this.NvibT3_Desc;
                str = string2;
                switchCompat2 = switchCompat3;
                textView2 = textView3;
                break;
            case R.id.NvibT4_pref /* 2131361926 */:
                switchCompat3 = this.NvibT4;
                string2 = switchCompat3.isChecked() ? getResources().getString(R.string.pref_description_vibrate_off) : getResources().getString(R.string.pref_description_vibrate_on);
                edit.putBoolean("NvibT4", !switchCompat3.isChecked());
                textView3 = this.NvibT4_Desc;
                str = string2;
                switchCompat2 = switchCompat3;
                textView2 = textView3;
                break;
            case R.id.NvibT_pref /* 2131361930 */:
                switchCompat3 = this.NvibT;
                string2 = switchCompat3.isChecked() ? getResources().getString(R.string.pref_description_vibrate_off) : getResources().getString(R.string.pref_description_vibrate_on);
                edit.putBoolean("Nvib", !switchCompat3.isChecked());
                textView3 = this.NvibT_Desc;
                str = string2;
                switchCompat2 = switchCompat3;
                textView2 = textView3;
                break;
            case R.id.findT1_pref /* 2131362186 */:
                switchCompat2 = this.findT1;
                boolean z16 = !switchCompat2.isChecked();
                if (this.findT1.isChecked()) {
                    resources = getResources();
                    i = R.string.findT1_off;
                } else {
                    resources = getResources();
                    i = R.string.findT1_on;
                }
                str = resources.getString(i);
                edit.putBoolean("callT1", !switchCompat2.isChecked());
                this.NvibT1_Pref.setVisibility(z16 ? 0 : 8);
                this.NsouT1_Pref.setVisibility(z16 ? 0 : 8);
                this.NappT1_Pref.setVisibility(z16 ? 0 : 8);
                this.NrinT1_Pref.setVisibility(z16 ? 0 : 8);
                textView2 = this.findT1_Desc;
                break;
            case R.id.findT2_pref /* 2131362191 */:
                switchCompat2 = this.findT2;
                boolean z17 = !switchCompat2.isChecked();
                if (this.findT2.isChecked()) {
                    resources2 = getResources();
                    i2 = R.string.findT2_off;
                } else {
                    resources2 = getResources();
                    i2 = R.string.findT2_on;
                }
                str = resources2.getString(i2);
                edit.putBoolean("callT2", !switchCompat2.isChecked());
                this.NvibT2_Pref.setVisibility(z17 ? 0 : 8);
                this.NsouT2_Pref.setVisibility(z17 ? 0 : 8);
                this.NappT2_Pref.setVisibility(z17 ? 0 : 8);
                this.NrinT2_Pref.setVisibility(z17 ? 0 : 8);
                textView2 = this.findT2_Desc;
                break;
            case R.id.findT3_pref /* 2131362196 */:
                switchCompat2 = this.findT3;
                boolean z18 = !switchCompat2.isChecked();
                if (this.findT3.isChecked()) {
                    resources3 = getResources();
                    i3 = R.string.findT3_off;
                } else {
                    resources3 = getResources();
                    i3 = R.string.findT3_on;
                }
                str = resources3.getString(i3);
                edit.putBoolean("callT3", !switchCompat2.isChecked());
                this.NvibT3_Pref.setVisibility(z18 ? 0 : 8);
                this.NsouT3_Pref.setVisibility(z18 ? 0 : 8);
                this.NappT3_Pref.setVisibility(z18 ? 0 : 8);
                this.NrinT3_Pref.setVisibility(z18 ? 0 : 8);
                textView2 = this.findT3_Desc;
                break;
            default:
                switchCompat2 = null;
                str = null;
                textView2 = null;
                break;
        }
        edit.apply();
        if (switchCompat2 == null || textView2 == null || str.isEmpty()) {
            return;
        }
        switchCompat2.setChecked(!switchCompat2.isChecked());
        textView2.setText(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.pref_header_sound_and_vib);
            this.permissionStatus = getActivity().getSharedPreferences("permissionStatus", 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.settings_notifications_sounds, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i <= 99 || i >= 105) {
            return;
        }
        Crashlytics.log("return from permission - return code is: " + i);
        if (iArr[0] != 0) {
            Crashlytics.log("return from permission - return permission denied");
            (i == 100 ? this.NappT_Pref : i == 101 ? this.NappT1_Pref : i == 102 ? this.NappT2_Pref : i == 103 ? this.NappT3_Pref : this.NappT4_Pref).performClick();
        } else {
            Crashlytics.log("return from permission - return was true");
            SharedPreferences.Editor edit = this.sp.edit();
            edit.putBoolean("allowed", true);
            edit.apply();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        ConstraintLayout constraintLayout;
        boolean z;
        boolean z2;
        boolean z3;
        View view2;
        super.onViewCreated(view, bundle);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.true_cut);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.false_cut);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.non_critical);
        this.sp = getActivity().getSharedPreferences("Settings", 0);
        boolean z4 = this.sp.getBoolean("cut", false);
        boolean z5 = this.sp.getBoolean("callT6", true);
        boolean z6 = this.sp.getBoolean("callT4", true);
        if (z4) {
            constraintLayout2.setVisibility(0);
            constraintLayout3.setVisibility(8);
            ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.findT1_pref);
            this.NvibT1_Pref = (ConstraintLayout) view.findViewById(R.id.NvibT1_pref);
            this.NsouT1_Pref = (ConstraintLayout) view.findViewById(R.id.NsouT1_pref);
            this.NappT1_Pref = (ConstraintLayout) view.findViewById(R.id.NappT1_pref);
            this.NrinT1_Pref = (ConstraintLayout) view.findViewById(R.id.NrinT1_pref);
            this.findT1_Desc = (TextView) view.findViewById(R.id.findT1_Desc);
            this.NvibT1_Desc = (TextView) view.findViewById(R.id.NvibT1_Desc);
            this.NsouT1_Desc = (TextView) view.findViewById(R.id.NsouT1_Desc);
            this.NappT1_Desc = (TextView) view.findViewById(R.id.NappT1_Desc);
            this.findT1 = (SwitchCompat) view.findViewById(R.id.findT1);
            this.NvibT1 = (SwitchCompat) view.findViewById(R.id.NvibT1);
            this.NsouT1 = (SwitchCompat) view.findViewById(R.id.NsouT1);
            this.NappT1 = (SwitchCompat) view.findViewById(R.id.NappT1);
            ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(R.id.findT2_pref);
            this.NvibT2_Pref = (ConstraintLayout) view.findViewById(R.id.NvibT2_pref);
            this.NsouT2_Pref = (ConstraintLayout) view.findViewById(R.id.NsouT2_pref);
            this.NappT2_Pref = (ConstraintLayout) view.findViewById(R.id.NappT2_pref);
            this.NrinT2_Pref = (ConstraintLayout) view.findViewById(R.id.NrinT2_pref);
            this.findT2_Desc = (TextView) view.findViewById(R.id.findT2_Desc);
            this.NvibT2_Desc = (TextView) view.findViewById(R.id.NvibT2_Desc);
            this.NsouT2_Desc = (TextView) view.findViewById(R.id.NsouT2_Desc);
            this.NappT2_Desc = (TextView) view.findViewById(R.id.NappT2_Desc);
            this.findT2 = (SwitchCompat) view.findViewById(R.id.findT2);
            this.NvibT2 = (SwitchCompat) view.findViewById(R.id.NvibT2);
            this.NsouT2 = (SwitchCompat) view.findViewById(R.id.NsouT2);
            this.NappT2 = (SwitchCompat) view.findViewById(R.id.NappT2);
            ConstraintLayout constraintLayout7 = (ConstraintLayout) view.findViewById(R.id.findT3_pref);
            this.NvibT3_Pref = (ConstraintLayout) view.findViewById(R.id.NvibT3_pref);
            this.NsouT3_Pref = (ConstraintLayout) view.findViewById(R.id.NsouT3_pref);
            this.NappT3_Pref = (ConstraintLayout) view.findViewById(R.id.NappT3_pref);
            this.NrinT3_Pref = (ConstraintLayout) view.findViewById(R.id.NrinT3_pref);
            this.findT3_Desc = (TextView) view.findViewById(R.id.findT3_Desc);
            this.NvibT3_Desc = (TextView) view.findViewById(R.id.NvibT3_Desc);
            this.NsouT3_Desc = (TextView) view.findViewById(R.id.NsouT3_Desc);
            this.NappT3_Desc = (TextView) view.findViewById(R.id.NappT3_Desc);
            this.findT3 = (SwitchCompat) view.findViewById(R.id.findT3);
            this.NvibT3 = (SwitchCompat) view.findViewById(R.id.NvibT3);
            this.NsouT3 = (SwitchCompat) view.findViewById(R.id.NsouT3);
            this.NappT3 = (SwitchCompat) view.findViewById(R.id.NappT3);
            constraintLayout5.setOnClickListener(this);
            this.NvibT1_Pref.setOnClickListener(this);
            this.NsouT1_Pref.setOnClickListener(this);
            this.NappT1_Pref.setOnClickListener(this);
            this.NrinT1_Pref.setOnClickListener(this);
            constraintLayout6.setOnClickListener(this);
            this.NvibT2_Pref.setOnClickListener(this);
            this.NsouT2_Pref.setOnClickListener(this);
            this.NappT2_Pref.setOnClickListener(this);
            this.NrinT2_Pref.setOnClickListener(this);
            constraintLayout7.setOnClickListener(this);
            this.NvibT3_Pref.setOnClickListener(this);
            this.NsouT3_Pref.setOnClickListener(this);
            this.NappT3_Pref.setOnClickListener(this);
            this.NrinT3_Pref.setOnClickListener(this);
            boolean z7 = this.sp.getBoolean("callT1", true);
            boolean z8 = this.sp.getBoolean("NvibT1", true);
            boolean z9 = this.sp.getBoolean("NsouT1", true);
            z = z4;
            boolean z10 = this.sp.getBoolean("NappT1", false);
            constraintLayout = constraintLayout4;
            boolean z11 = this.sp.getBoolean("callT2", true);
            z3 = z6;
            boolean z12 = this.sp.getBoolean("NvibT2", true);
            z2 = z5;
            boolean z13 = this.sp.getBoolean("NsouT2", true);
            boolean z14 = this.sp.getBoolean("NappT2", false);
            boolean z15 = this.sp.getBoolean("callT3", true);
            boolean z16 = this.sp.getBoolean("NvibT3", true);
            boolean z17 = this.sp.getBoolean("NsouT3", true);
            boolean z18 = this.sp.getBoolean("NappT3", false);
            setTrueOrFalse(z7, constraintLayout5.getId());
            setTrueOrFalse(z8, this.NvibT1_Pref.getId());
            setTrueOrFalse(z9, this.NsouT1_Pref.getId());
            setTrueOrFalse(z10, this.NappT1_Pref.getId());
            setTrueOrFalse(z11, constraintLayout6.getId());
            setTrueOrFalse(z12, this.NvibT2_Pref.getId());
            setTrueOrFalse(z13, this.NsouT2_Pref.getId());
            setTrueOrFalse(z14, this.NappT2_Pref.getId());
            setTrueOrFalse(z15, constraintLayout7.getId());
            setTrueOrFalse(z16, this.NvibT3_Pref.getId());
            setTrueOrFalse(z17, this.NsouT3_Pref.getId());
            setTrueOrFalse(z18, this.NappT3_Pref.getId());
            view2 = view;
            constraintLayout3 = constraintLayout3;
            constraintLayout2 = constraintLayout2;
        } else {
            constraintLayout = constraintLayout4;
            z = z4;
            z2 = z5;
            z3 = z6;
            constraintLayout2.setVisibility(8);
            constraintLayout3.setVisibility(0);
            view2 = view;
            ConstraintLayout constraintLayout8 = (ConstraintLayout) view2.findViewById(R.id.NvibT_pref);
            ConstraintLayout constraintLayout9 = (ConstraintLayout) view2.findViewById(R.id.NsouT_pref);
            this.NappT_Pref = (ConstraintLayout) view2.findViewById(R.id.NappT_pref);
            this.NrinT_Pref = (ConstraintLayout) view2.findViewById(R.id.NrinT_pref);
            this.NvibT_Desc = (TextView) view2.findViewById(R.id.NvibT_Desc);
            this.NsouT_Desc = (TextView) view2.findViewById(R.id.NsouT_Desc);
            this.NappT_Desc = (TextView) view2.findViewById(R.id.NappT_Desc);
            this.NvibT = (SwitchCompat) view2.findViewById(R.id.NvibT);
            this.NsouT = (SwitchCompat) view2.findViewById(R.id.NsouT);
            this.NappT = (SwitchCompat) view2.findViewById(R.id.NappT);
            constraintLayout8.setOnClickListener(this);
            constraintLayout9.setOnClickListener(this);
            this.NappT_Pref.setOnClickListener(this);
            this.NrinT_Pref.setOnClickListener(this);
            boolean z19 = this.sp.getBoolean("Nvib", true);
            boolean z20 = this.sp.getBoolean("Nsou", true);
            boolean z21 = this.sp.getBoolean("Napp", false);
            setTrueOrFalse(z19, constraintLayout8.getId());
            setTrueOrFalse(z20, constraintLayout9.getId());
            setTrueOrFalse(z21, this.NappT_Pref.getId());
        }
        if (!z2 && !z3) {
            constraintLayout.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout10 = constraintLayout;
        ((ConstraintLayout.LayoutParams) constraintLayout10.getLayoutParams()).topToBottom = z ? constraintLayout2.getId() : constraintLayout3.getId();
        constraintLayout10.requestLayout();
        ConstraintLayout constraintLayout11 = (ConstraintLayout) view2.findViewById(R.id.NvibT4_pref);
        ConstraintLayout constraintLayout12 = (ConstraintLayout) view2.findViewById(R.id.NsouT4_pref);
        this.NappT4_Pref = (ConstraintLayout) view2.findViewById(R.id.NappT4_pref);
        this.NrinT4_Pref = (ConstraintLayout) view2.findViewById(R.id.NrinT4_pref);
        this.NvibT4_Desc = (TextView) view2.findViewById(R.id.NvibT4_Desc);
        this.NsouT4_Desc = (TextView) view2.findViewById(R.id.NsouT4_Desc);
        this.NappT4_Desc = (TextView) view2.findViewById(R.id.NappT4_Desc);
        this.NvibT4 = (SwitchCompat) view2.findViewById(R.id.NvibT4);
        this.NsouT4 = (SwitchCompat) view2.findViewById(R.id.NsouT4);
        this.NappT4 = (SwitchCompat) view2.findViewById(R.id.NappT4);
        constraintLayout11.setOnClickListener(this);
        constraintLayout12.setOnClickListener(this);
        this.NappT4_Pref.setOnClickListener(this);
        this.NrinT4_Pref.setOnClickListener(this);
        boolean z22 = this.sp.getBoolean("NvibT4", true);
        boolean z23 = this.sp.getBoolean("NsouT4", true);
        boolean z24 = this.sp.getBoolean("NappT4", false);
        setTrueOrFalse(z22, constraintLayout11.getId());
        setTrueOrFalse(z23, constraintLayout12.getId());
        setTrueOrFalse(z24, this.NappT4_Pref.getId());
    }
}
