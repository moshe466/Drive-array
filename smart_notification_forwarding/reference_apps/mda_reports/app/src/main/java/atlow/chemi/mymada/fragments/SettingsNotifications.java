package atlow.chemi.mymada.fragments;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.SettingsPage;

/* loaded from: classes.dex */
public class SettingsNotifications extends Fragment implements View.OnClickListener {
    private SwitchCompat T6;
    private TextView T6Desc;
    private ConstraintLayout T6Pref;
    boolean X;
    boolean Y;
    boolean Z;
    boolean a0;
    boolean b0;
    private SwitchCompat cutA;
    private TextView cutADesc;
    private ConstraintLayout cutAPref;
    private SwitchCompat findT4;
    private TextView findT4Desc;
    private ConstraintLayout findT4Pref;
    private SharedPreferences sp;
    private SwitchCompat stat;
    private TextView statDesc;
    private ConstraintLayout statPref;
    private SwitchCompat statVib;
    private TextView statVibDesc;
    private ConstraintLayout statVibPref;

    private void setTrueOrFalse(boolean z, int i) {
        String string;
        TextView textView;
        SharedPreferences.Editor edit = this.sp.edit();
        SwitchCompat switchCompat = null;
        switch (i) {
            case R.id.T6_pref /* 2131361949 */:
                switchCompat = this.T6;
                string = getResources().getString(!z ? R.string.findT6_off : R.string.findT6_on);
                edit.putBoolean("callT6", z);
                textView = this.T6Desc;
                break;
            case R.id.cutA_pref /* 2131362135 */:
                switchCompat = this.cutA;
                string = getResources().getString(!z ? R.string.pref_description_cutA_off : R.string.pref_description_cutA_on);
                edit.putBoolean("cut", z);
                textView = this.cutADesc;
                break;
            case R.id.findT4_pref /* 2131362201 */:
                switchCompat = this.findT4;
                string = getResources().getString(!z ? R.string.findT4_off : R.string.findT4_on);
                edit.putBoolean("callT4", z);
                textView = this.findT4Desc;
                break;
            case R.id.statVib_pref /* 2131362480 */:
                switchCompat = this.statVib;
                string = getResources().getString(!z ? R.string.pref_description_stateVib_off : R.string.pref_description_stateVib_on);
                edit.putBoolean("statVib", z);
                textView = this.statVibDesc;
                break;
            case R.id.stat_pref /* 2131362484 */:
                switchCompat = this.stat;
                string = getResources().getString(!z ? R.string.pref_description_state_off : R.string.pref_description_state_on);
                edit.putBoolean("stat", z);
                textView = this.statDesc;
                break;
            default:
                string = null;
                textView = null;
                break;
        }
        edit.apply();
        if (switchCompat == null || textView == null || string.isEmpty()) {
            return;
        }
        switchCompat.setChecked(z);
        textView.setText(string);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Resources resources;
        int i;
        String string;
        TextView textView;
        Resources resources2;
        int i2;
        Resources resources3;
        int i3;
        Resources resources4;
        int i4;
        Resources resources5;
        int i5;
        SharedPreferences.Editor edit = this.sp.edit();
        SwitchCompat switchCompat = null;
        switch (view.getId()) {
            case R.id.T6_pref /* 2131361949 */:
                switchCompat = this.T6;
                if (switchCompat.isChecked()) {
                    resources = getResources();
                    i = R.string.findT6_off;
                } else {
                    resources = getResources();
                    i = R.string.findT6_on;
                }
                string = resources.getString(i);
                edit.putBoolean("callT6", !switchCompat.isChecked());
                textView = this.T6Desc;
                break;
            case R.id.cutA_pref /* 2131362135 */:
                switchCompat = this.cutA;
                if (switchCompat.isChecked()) {
                    resources2 = getResources();
                    i2 = R.string.pref_description_cutA_off;
                } else {
                    resources2 = getResources();
                    i2 = R.string.pref_description_cutA_on;
                }
                string = resources2.getString(i2);
                edit.putBoolean("cut", !switchCompat.isChecked());
                textView = this.cutADesc;
                break;
            case R.id.findT4_pref /* 2131362201 */:
                switchCompat = this.findT4;
                if (switchCompat.isChecked()) {
                    resources3 = getResources();
                    i3 = R.string.findT4_off;
                } else {
                    resources3 = getResources();
                    i3 = R.string.findT4_on;
                }
                string = resources3.getString(i3);
                edit.putBoolean("callT4", !switchCompat.isChecked());
                textView = this.findT4Desc;
                break;
            case R.id.sound_vib_card /* 2131362459 */:
                ((SettingsPage) getActivity()).displayFragment(new SettingsNotificationsSounds(), R.id.soundAndVib);
                string = null;
                textView = null;
                break;
            case R.id.statVib_pref /* 2131362480 */:
                switchCompat = this.statVib;
                if (switchCompat.isChecked()) {
                    resources4 = getResources();
                    i4 = R.string.pref_description_stateVib_off;
                } else {
                    resources4 = getResources();
                    i4 = R.string.pref_description_stateVib_on;
                }
                string = resources4.getString(i4);
                edit.putBoolean("statVib", !switchCompat.isChecked());
                textView = this.statVibDesc;
                break;
            case R.id.stat_pref /* 2131362484 */:
                switchCompat = this.stat;
                if (switchCompat.isChecked()) {
                    resources5 = getResources();
                    i5 = R.string.pref_description_state_off;
                } else {
                    resources5 = getResources();
                    i5 = R.string.pref_description_state_on;
                }
                string = resources5.getString(i5);
                edit.putBoolean("stat", !switchCompat.isChecked());
                textView = this.statDesc;
                break;
            default:
                string = null;
                textView = null;
                break;
        }
        edit.apply();
        if (switchCompat == null || textView == null || string.isEmpty()) {
            return;
        }
        switchCompat.setChecked(!switchCompat.isChecked());
        textView.setText(string);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.pref_header_notifications);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.settings_notifications, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cutA = (SwitchCompat) view.findViewById(R.id.cutAlarm);
        this.cutADesc = (TextView) view.findViewById(R.id.cutA_Desc);
        this.cutAPref = (ConstraintLayout) view.findViewById(R.id.cutA_pref);
        this.stat = (SwitchCompat) view.findViewById(R.id.stat);
        this.statDesc = (TextView) view.findViewById(R.id.stat_Desc);
        this.statPref = (ConstraintLayout) view.findViewById(R.id.stat_pref);
        this.statVib = (SwitchCompat) view.findViewById(R.id.statVib);
        this.statVibDesc = (TextView) view.findViewById(R.id.statVib_Desc);
        this.statVibPref = (ConstraintLayout) view.findViewById(R.id.statVib_pref);
        this.T6 = (SwitchCompat) view.findViewById(R.id.T6);
        this.T6Desc = (TextView) view.findViewById(R.id.T6_Desc);
        this.T6Pref = (ConstraintLayout) view.findViewById(R.id.T6_pref);
        this.findT4 = (SwitchCompat) view.findViewById(R.id.findT4);
        this.findT4Desc = (TextView) view.findViewById(R.id.findT4_Desc);
        this.findT4Pref = (ConstraintLayout) view.findViewById(R.id.findT4_pref);
        CardView cardView = (CardView) view.findViewById(R.id.sound_vib_card);
        this.cutAPref.setOnClickListener(this);
        this.statPref.setOnClickListener(this);
        this.statVibPref.setOnClickListener(this);
        this.T6Pref.setOnClickListener(this);
        this.findT4Pref.setOnClickListener(this);
        cardView.setOnClickListener(this);
        this.sp = getActivity().getSharedPreferences("Settings", 0);
        this.X = this.sp.getBoolean("cut", false);
        this.Y = this.sp.getBoolean("stat", false);
        this.Z = this.sp.getBoolean("statVib", false);
        this.a0 = this.sp.getBoolean("callT6", true);
        this.b0 = this.sp.getBoolean("callT4", true);
        setTrueOrFalse(this.X, this.cutAPref.getId());
        setTrueOrFalse(this.Y, this.statPref.getId());
        setTrueOrFalse(this.Z, this.statVibPref.getId());
        setTrueOrFalse(this.a0, this.T6Pref.getId());
        setTrueOrFalse(this.b0, this.findT4Pref.getId());
    }
}
