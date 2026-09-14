package atlow.chemi.mymada.fragments;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.SettingsPage;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public class SettingsAdvanced extends Fragment implements View.OnClickListener {
    private SwitchCompat VolumeApp;
    private boolean VolumeAppB;
    private TextView VolumeAppDesc;
    private int VolumeAppNumber;
    private SwitchCompat loop;
    private TextView loopDesc;
    private SwitchCompat newWin;
    private TextView newWinDesc;
    private SwitchCompat not;
    private TextView notDesc;
    private SwitchCompat ride;
    private TextView rideDesc;
    private SwitchCompat shabat;
    private TextView shabatDesc;
    private ConstraintLayout shabbatTimePref;
    private SharedPreferences sp;

    private void SetShabbatTimeDialog() {
        View inflate = View.inflate(getActivity(), R.layout.shabat_t, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.shabatT);
        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.shabatTil);
        final String string = this.sp.getString("timeK", "6");
        AlertDialog.Builder view = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle).setView(inflate);
        view.setNegativeButton(getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.v0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(getString(R.string.ok), (DialogInterface.OnClickListener) null);
        final AlertDialog create = view.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.x0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SettingsAdvanced.this.a(editText, string, create, textInputLayout, dialogInterface);
            }
        });
        create.show();
    }

    private void SetVolumeDialog() {
        View inflate = View.inflate(getActivity(), R.layout.volume_dialog, null);
        final ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.volume_app_pref);
        this.VolumeApp = (SwitchCompat) inflate.findViewById(R.id.volume_app);
        this.VolumeAppDesc = (TextView) inflate.findViewById(R.id.volume_app_Desc);
        final SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.VolumeSeekBar);
        AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
        final int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(4) : 20;
        AlertDialog.Builder view = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle).setView(inflate);
        view.setNegativeButton(getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.w0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(getString(R.string.ok), (DialogInterface.OnClickListener) null);
        final AlertDialog create = view.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.b1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SettingsAdvanced.this.a(constraintLayout, streamMaxVolume, seekBar, create, dialogInterface);
            }
        });
        create.show();
    }

    private void setTrueOrFalse(boolean z, int i) {
        String string;
        TextView textView;
        Resources resources;
        int i2;
        SharedPreferences.Editor edit = this.sp.edit();
        SwitchCompat switchCompat = null;
        switch (i) {
            case R.id.loop_pref /* 2131362257 */:
                switchCompat = this.loop;
                string = getResources().getString(!z ? R.string.pref_description_loop_off : R.string.pref_description_loop_on);
                edit.putBoolean("loop", z);
                textView = this.loopDesc;
                break;
            case R.id.newWin_pref /* 2131362332 */:
                switchCompat = this.newWin;
                string = getResources().getString(!z ? R.string.pref_description_newWin_off : R.string.pref_description_newWin_on);
                edit.putBoolean("win", z);
                textView = this.newWinDesc;
                break;
            case R.id.not_pref /* 2131362341 */:
                switchCompat = this.not;
                string = getResources().getString(!z ? R.string.pref_description_not_off : R.string.pref_description_not_on);
                edit.putBoolean("not", z);
                textView = this.notDesc;
                break;
            case R.id.ride_pref /* 2131362396 */:
                switchCompat = this.ride;
                string = getResources().getString(!z ? R.string.pref_description_ride_off : R.string.pref_description_ride_on);
                edit.putBoolean("ride", z);
                textView = this.rideDesc;
                break;
            case R.id.shabat_pref /* 2131362440 */:
                switchCompat = this.shabat;
                string = getResources().getString(!z ? R.string.pref_description_shabat_off : R.string.pref_description_shabat_on);
                edit.putBoolean("killS", z);
                textView = this.shabatDesc;
                this.shabbatTimePref.setClickable(z);
                this.shabbatTimePref.setAlpha(z ? 1.0f : 0.4f);
                break;
            case R.id.volume_app_pref /* 2131362569 */:
                switchCompat = this.VolumeApp;
                if (switchCompat.isChecked()) {
                    resources = getResources();
                    i2 = R.string.pref_description_volume_app_off;
                } else {
                    resources = getResources();
                    i2 = R.string.pref_description_volume_app_on;
                }
                string = resources.getString(i2);
                edit.putBoolean("volumeApp", !switchCompat.isChecked());
                textView = this.VolumeAppDesc;
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

    public /* synthetic */ void a(DialogInterface dialogInterface, View view) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putBoolean("volumeApp", this.VolumeApp.isChecked());
        edit.putInt("volumeAppNum", this.VolumeAppNumber);
        edit.apply();
        dialogInterface.dismiss();
    }

    public /* synthetic */ void a(EditText editText, TextInputLayout textInputLayout, DialogInterface dialogInterface, View view) {
        if (editText.getText().toString().isEmpty()) {
            textInputLayout.setError(getResources().getString(R.string.numberNone));
        }
        if (editText.getText().toString().trim().length() <= 0 || !TextUtils.isDigitsOnly(editText.getText().toString().trim())) {
            return;
        }
        String trim = editText.getText().toString().trim();
        textInputLayout.setErrorEnabled(false);
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString("timeK", trim);
        edit.apply();
        dialogInterface.dismiss();
    }

    public /* synthetic */ void a(final EditText editText, String str, AlertDialog alertDialog, final TextInputLayout textInputLayout, final DialogInterface dialogInterface) {
        editText.setText(str);
        alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdvanced.this.a(editText, textInputLayout, dialogInterface, view);
            }
        });
    }

    public /* synthetic */ void a(ConstraintLayout constraintLayout, int i, SeekBar seekBar, AlertDialog alertDialog, final DialogInterface dialogInterface) {
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdvanced.this.b(view);
            }
        });
        this.VolumeAppB = this.sp.getBoolean("volumeApp", true);
        this.VolumeAppNumber = this.sp.getInt("volumeAppNum", i);
        setTrueOrFalse(this.VolumeAppB, constraintLayout.getId());
        seekBar.setProgress(this.VolumeAppNumber);
        seekBar.setMax(i);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: atlow.chemi.mymada.fragments.SettingsAdvanced.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int i2, boolean z) {
                SettingsAdvanced.this.VolumeAppNumber = i2;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
            }
        });
        alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsAdvanced.this.a(dialogInterface, view);
            }
        });
    }

    public /* synthetic */ void b(View view) {
        Resources resources;
        int i;
        if (this.VolumeApp.isChecked()) {
            resources = getResources();
            i = R.string.pref_description_volume_app_off;
        } else {
            resources = getResources();
            i = R.string.pref_description_volume_app_on;
        }
        String string = resources.getString(i);
        this.VolumeApp.setChecked(!this.VolumeApp.isChecked());
        this.VolumeAppDesc.setText(string);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TextView textView;
        Resources resources;
        int i;
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
            case R.id.ampm_card /* 2131362031 */:
                ((SettingsPage) getActivity()).displayFragment(new SettingsAmpm(), R.id.ampm);
                str = null;
                textView = null;
                break;
            case R.id.loop_pref /* 2131362257 */:
                switchCompat = this.loop;
                if (switchCompat.isChecked()) {
                    resources = getResources();
                    i = R.string.pref_description_loop_off;
                } else {
                    resources = getResources();
                    i = R.string.pref_description_loop_on;
                }
                str = resources.getString(i);
                edit.putBoolean("loop", !switchCompat.isChecked());
                textView = this.loopDesc;
                break;
            case R.id.newWin_pref /* 2131362332 */:
                switchCompat = this.newWin;
                if (switchCompat.isChecked()) {
                    resources2 = getResources();
                    i2 = R.string.pref_description_newWin_off;
                } else {
                    resources2 = getResources();
                    i2 = R.string.pref_description_newWin_on;
                }
                str = resources2.getString(i2);
                edit.putBoolean("win", !switchCompat.isChecked());
                textView = this.newWinDesc;
                break;
            case R.id.not_pref /* 2131362341 */:
                switchCompat = this.not;
                if (switchCompat.isChecked()) {
                    resources3 = getResources();
                    i3 = R.string.pref_description_not_off;
                } else {
                    resources3 = getResources();
                    i3 = R.string.pref_description_not_on;
                }
                str = resources3.getString(i3);
                edit.putBoolean("not", !switchCompat.isChecked());
                textView = this.notDesc;
                break;
            case R.id.ride_pref /* 2131362396 */:
                switchCompat = this.ride;
                if (switchCompat.isChecked()) {
                    resources4 = getResources();
                    i4 = R.string.pref_description_ride_off;
                } else {
                    resources4 = getResources();
                    i4 = R.string.pref_description_ride_on;
                }
                str = resources4.getString(i4);
                edit.putBoolean("ride", !switchCompat.isChecked());
                textView = this.rideDesc;
                break;
            case R.id.shabatTime_pref /* 2131362436 */:
                SetShabbatTimeDialog();
                str = null;
                textView = null;
                break;
            case R.id.shabat_pref /* 2131362440 */:
                switchCompat = this.shabat;
                if (switchCompat.isChecked()) {
                    resources5 = getResources();
                    i5 = R.string.pref_description_shabat_off;
                } else {
                    resources5 = getResources();
                    i5 = R.string.pref_description_shabat_on;
                }
                str = resources5.getString(i5);
                edit.putBoolean("killS", !switchCompat.isChecked());
                textView = this.shabatDesc;
                this.shabbatTimePref.setClickable(!this.shabat.isChecked());
                this.shabbatTimePref.setAlpha(!this.shabat.isChecked() ? 1.0f : 0.4f);
                break;
            case R.id.volume_pref /* 2131362571 */:
                SetVolumeDialog();
                str = null;
                textView = null;
                break;
            default:
                str = null;
                textView = null;
                break;
        }
        edit.apply();
        if (switchCompat == null || textView == null || str.isEmpty()) {
            return;
        }
        switchCompat.setChecked(!switchCompat.isChecked());
        textView.setText(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.pref_header_advanced);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.settings_advanced, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        this.not = (SwitchCompat) view.findViewById(R.id.not);
        this.notDesc = (TextView) view.findViewById(R.id.not_Desc);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.not_pref);
        this.newWin = (SwitchCompat) view.findViewById(R.id.newWin);
        this.newWinDesc = (TextView) view.findViewById(R.id.newWin_Desc);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.newWin_pref);
        this.ride = (SwitchCompat) view.findViewById(R.id.ride);
        this.rideDesc = (TextView) view.findViewById(R.id.ride_Desc);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.ride_pref);
        this.loop = (SwitchCompat) view.findViewById(R.id.loop);
        this.loopDesc = (TextView) view.findViewById(R.id.loop_Desc);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.loop_pref);
        this.shabat = (SwitchCompat) view.findViewById(R.id.shabat);
        this.shabatDesc = (TextView) view.findViewById(R.id.shabat_Desc);
        ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.shabat_pref);
        this.shabbatTimePref = (ConstraintLayout) view.findViewById(R.id.shabatTime_pref);
        ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(R.id.volume_pref);
        CardView cardView = (CardView) view.findViewById(R.id.ampm_card);
        constraintLayout.setOnClickListener(this);
        constraintLayout2.setOnClickListener(this);
        constraintLayout3.setOnClickListener(this);
        constraintLayout4.setOnClickListener(this);
        constraintLayout5.setOnClickListener(this);
        this.shabbatTimePref.setOnClickListener(this);
        constraintLayout6.setOnClickListener(this);
        cardView.setOnClickListener(this);
        this.sp = getActivity().getSharedPreferences("Settings", 0);
        boolean z = this.sp.getBoolean("not", true);
        boolean z2 = this.sp.getBoolean("win", true);
        boolean z3 = this.sp.getBoolean("ride", false);
        boolean z4 = this.sp.getBoolean("loop", false);
        boolean z5 = this.sp.getBoolean("killS", false);
        setTrueOrFalse(z, constraintLayout.getId());
        setTrueOrFalse(z2, constraintLayout2.getId());
        setTrueOrFalse(z3, constraintLayout3.getId());
        setTrueOrFalse(z4, constraintLayout4.getId());
        setTrueOrFalse(z5, constraintLayout5.getId());
    }
}
