package atlow.chemi.mymada.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SettingsTools extends Fragment implements View.OnClickListener {
    private SwitchCompat apgar;
    private boolean apgarB;
    private SwitchCompat dictionary;
    private boolean dictionaryB;
    private SwitchCompat glazgo;
    private boolean glazgoB;
    private SwitchCompat metro;
    private boolean metroB;
    private SwitchCompat oxy;
    private boolean oxyB;
    private SwitchCompat proto;
    private boolean protoB;
    private SwitchCompat pulse;
    private boolean pulseB;
    private SharedPreferences sp;
    private final String[] toolsS = {"contrac", "pulse", "metro", "vital", "oxy", "apgar", "glaz", "prot", "dict"};
    private SwitchCompat tzirim;
    private boolean tzirimB;
    private SwitchCompat vital;
    private boolean vitalB;

    private void setTrueOrFalse(boolean z, int i) {
        SwitchCompat switchCompat;
        SharedPreferences.Editor edit = this.sp.edit();
        switch (i) {
            case R.id.apgar_pref /* 2131362035 */:
                switchCompat = this.apgar;
                break;
            case R.id.dictionary_pref /* 2131362154 */:
                switchCompat = this.dictionary;
                break;
            case R.id.glazgo_pref /* 2131362213 */:
                switchCompat = this.glazgo;
                break;
            case R.id.metro_pref /* 2131362302 */:
                switchCompat = this.metro;
                break;
            case R.id.oxy_pref /* 2131362357 */:
                switchCompat = this.oxy;
                break;
            case R.id.proto_pref /* 2131362375 */:
                switchCompat = this.proto;
                break;
            case R.id.pulse_pref /* 2131362383 */:
                switchCompat = this.pulse;
                break;
            case R.id.tzirim_pref /* 2131362545 */:
                switchCompat = this.tzirim;
                break;
            case R.id.vital_pref /* 2131362560 */:
                switchCompat = this.vital;
                break;
            default:
                switchCompat = null;
                break;
        }
        edit.apply();
        if (switchCompat != null) {
            switchCompat.setChecked(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SwitchCompat switchCompat;
        char c;
        SharedPreferences.Editor edit = this.sp.edit();
        switch (view.getId()) {
            case R.id.apgar_pref /* 2131362035 */:
                switchCompat = this.apgar;
                this.apgarB = !switchCompat.isChecked();
                c = 5;
                break;
            case R.id.dictionary_pref /* 2131362154 */:
                switchCompat = this.dictionary;
                this.dictionaryB = !switchCompat.isChecked();
                c = '\b';
                break;
            case R.id.glazgo_pref /* 2131362213 */:
                switchCompat = this.glazgo;
                this.glazgoB = !switchCompat.isChecked();
                c = 6;
                break;
            case R.id.metro_pref /* 2131362302 */:
                switchCompat = this.metro;
                this.metroB = !switchCompat.isChecked();
                c = 2;
                break;
            case R.id.oxy_pref /* 2131362357 */:
                switchCompat = this.oxy;
                this.oxyB = !switchCompat.isChecked();
                c = 4;
                break;
            case R.id.proto_pref /* 2131362375 */:
                switchCompat = this.proto;
                this.protoB = !switchCompat.isChecked();
                c = 7;
                break;
            case R.id.pulse_pref /* 2131362383 */:
                switchCompat = this.pulse;
                this.pulseB = !switchCompat.isChecked();
                c = 1;
                break;
            case R.id.tzirim_pref /* 2131362545 */:
                switchCompat = this.tzirim;
                this.tzirimB = !switchCompat.isChecked();
                c = 0;
                break;
            case R.id.vital_pref /* 2131362560 */:
                switchCompat = this.vital;
                this.vitalB = !switchCompat.isChecked();
                c = 3;
                break;
            default:
                switchCompat = null;
                c = 0;
                break;
        }
        edit.apply();
        HashSet hashSet = new HashSet();
        if (switchCompat != null) {
            switchCompat.setChecked(!switchCompat.isChecked());
            if (this.tzirim.isChecked() || this.pulse.isChecked() || this.metro.isChecked() || this.vital.isChecked() || this.oxy.isChecked() || this.apgar.isChecked() || this.glazgo.isChecked() || this.proto.isChecked() || this.dictionary.isChecked()) {
                if (this.tzirimB) {
                    hashSet.add(this.toolsS[0]);
                }
                if (this.pulseB) {
                    hashSet.add(this.toolsS[1]);
                }
                if (this.metroB) {
                    hashSet.add(this.toolsS[2]);
                }
                if (this.vitalB) {
                    hashSet.add(this.toolsS[3]);
                }
                if (this.oxyB) {
                    hashSet.add(this.toolsS[4]);
                }
                if (this.apgarB) {
                    hashSet.add(this.toolsS[5]);
                }
                if (this.glazgoB) {
                    hashSet.add(this.toolsS[6]);
                }
                if (this.protoB) {
                    hashSet.add(this.toolsS[7]);
                }
                if (this.dictionaryB) {
                    hashSet.add(this.toolsS[8]);
                }
                SharedPreferences.Editor edit2 = this.sp.edit();
                edit2.putStringSet("Tools", hashSet);
                edit2.apply();
                return;
            }
            View findViewById = getActivity().findViewById(android.R.id.content);
            if (findViewById != null) {
                Snackbar make = Snackbar.make(findViewById, getResources().getString(R.string.NoPicked), 0);
                ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
                make.show();
            }
            switchCompat.setChecked(true);
            switch (c) {
                case 0:
                    this.tzirimB = true;
                    return;
                case 1:
                    this.pulseB = true;
                    return;
                case 2:
                    this.metroB = true;
                    return;
                case 3:
                    this.vitalB = true;
                    return;
                case 4:
                    this.oxyB = true;
                    return;
                case 5:
                    this.apgarB = true;
                    return;
                case 6:
                    this.glazgoB = true;
                    return;
                case 7:
                    this.protoB = true;
                    return;
                case '\b':
                    this.dictionaryB = true;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.pref_header_tools);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.settings_tools, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.tzirim = (SwitchCompat) view.findViewById(R.id.tzirim);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.tzirim_pref);
        this.pulse = (SwitchCompat) view.findViewById(R.id.pulse);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.pulse_pref);
        this.metro = (SwitchCompat) view.findViewById(R.id.metro);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.metro_pref);
        this.vital = (SwitchCompat) view.findViewById(R.id.vital);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.vital_pref);
        this.oxy = (SwitchCompat) view.findViewById(R.id.oxy);
        ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.oxy_pref);
        this.apgar = (SwitchCompat) view.findViewById(R.id.apgar);
        ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(R.id.apgar_pref);
        this.glazgo = (SwitchCompat) view.findViewById(R.id.glazgo);
        ConstraintLayout constraintLayout7 = (ConstraintLayout) view.findViewById(R.id.glazgo_pref);
        this.proto = (SwitchCompat) view.findViewById(R.id.proto);
        ConstraintLayout constraintLayout8 = (ConstraintLayout) view.findViewById(R.id.proto_pref);
        this.dictionary = (SwitchCompat) view.findViewById(R.id.dictionary);
        ConstraintLayout constraintLayout9 = (ConstraintLayout) view.findViewById(R.id.dictionary_pref);
        constraintLayout.setOnClickListener(this);
        constraintLayout2.setOnClickListener(this);
        constraintLayout3.setOnClickListener(this);
        constraintLayout4.setOnClickListener(this);
        constraintLayout5.setOnClickListener(this);
        constraintLayout6.setOnClickListener(this);
        constraintLayout7.setOnClickListener(this);
        constraintLayout8.setOnClickListener(this);
        constraintLayout9.setOnClickListener(this);
        this.sp = getActivity().getSharedPreferences("Settings", 0);
        Set<String> stringSet = this.sp.getStringSet("Tools", new LinkedHashSet(Arrays.asList(this.toolsS)));
        this.tzirimB = stringSet.contains("contrac");
        this.pulseB = stringSet.contains("pulse");
        this.metroB = stringSet.contains("metro");
        this.vitalB = stringSet.contains("vital");
        this.oxyB = stringSet.contains("oxy");
        this.apgarB = stringSet.contains("apgar");
        this.glazgoB = stringSet.contains("glaz");
        this.protoB = stringSet.contains("prot");
        this.dictionaryB = stringSet.contains("dict");
        setTrueOrFalse(this.tzirimB, constraintLayout.getId());
        setTrueOrFalse(this.pulseB, constraintLayout2.getId());
        setTrueOrFalse(this.metroB, constraintLayout3.getId());
        setTrueOrFalse(this.vitalB, constraintLayout4.getId());
        setTrueOrFalse(this.oxyB, constraintLayout5.getId());
        setTrueOrFalse(this.apgarB, constraintLayout6.getId());
        setTrueOrFalse(this.glazgoB, constraintLayout7.getId());
        setTrueOrFalse(this.protoB, constraintLayout8.getId());
        setTrueOrFalse(this.dictionaryB, constraintLayout9.getId());
    }
}
