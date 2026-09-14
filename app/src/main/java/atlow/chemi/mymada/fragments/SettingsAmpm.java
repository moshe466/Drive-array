package atlow.chemi.mymada.fragments;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

/* loaded from: classes.dex */
public class SettingsAmpm extends Fragment implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {
    private TextView dayDesc;
    private TextView nightDesc;
    private int nightEndI;
    private int nightStartI;
    private int sleepDayI;
    private int sleepNightI;
    private SharedPreferences sp;
    private String[] sounds = {"צליל ורטט", "רטט", "שקט"};
    private boolean nightStart = false;

    private void SetSleepDialog(final int i) {
        final int i2 = i == 0 ? this.sleepDayI : this.sleepNightI;
        final TextView textView = i == 0 ? this.dayDesc : this.nightDesc;
        String string = getString(i == 0 ? R.string.notifDay : R.string.notifNight);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
        builder.setTitle(string);
        builder.setNegativeButton(getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.d1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        });
        builder.setSingleChoiceItems(this.sounds, i2, new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.c1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SettingsAmpm.this.a(i2, i, textView, dialogInterface, i3);
            }
        });
        builder.create().show();
    }

    private void SetStartAndEndDialog(int i) {
        int i2 = i == 0 ? this.nightStartI : this.nightEndI;
        this.nightStart = i == 0;
        String string = getString(i == 0 ? R.string.nightStart : R.string.nightEnd);
        TimePickerDialog newInstance = TimePickerDialog.newInstance(this, i2, 25, 0, true);
        newInstance.enableMinutes(false);
        newInstance.setTitle(string);
        newInstance.show(getChildFragmentManager(), "tAg");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r14 != 2) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    private void Sleep(int r14, int r15) {
        String key = r15 == 0 ? "sleepDay" : "sleepNight";
        int otherKeyVal = r15 == 0 ? this.sp.getInt("sleepNight", 0) : this.sp.getInt("sleepDay", 0);
        int sleep;
        if (r15 == 0) {
            sleep = r14 * 3 + otherKeyVal;
        } else {
            sleep = otherKeyVal * 3 + r14;
        }
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putInt(key, r14);
        edit.putInt("sleep", sleep);
        edit.apply();
    }

    private void setInfo(int i) {
        TextView textView;
        String str = null;
        if (i == R.id.sleepDay_pref) {
            str = this.sounds[this.sleepDayI];
            textView = this.dayDesc;
        } else if (i != R.id.sleepNight_pref) {
            textView = null;
        } else {
            str = this.sounds[this.sleepNightI];
            textView = this.nightDesc;
        }
        if (textView == null || str.isEmpty()) {
            return;
        }
        textView.setText(str);
    }

    public /* synthetic */ void a(int i, int i2, TextView textView, DialogInterface dialogInterface, int i3) {
        if (i != i3) {
            Sleep(i3, i2);
            textView.setText(this.sounds[i3]);
            if (i2 == 0) {
                this.sleepDayI = i3;
            } else {
                this.sleepNightI = i3;
            }
        }
        dialogInterface.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.end_night_pref /* 2131362167 */:
                SetStartAndEndDialog(1);
                return;
            case R.id.sleepDay_pref /* 2131362449 */:
                SetSleepDialog(0);
                return;
            case R.id.sleepNight_pref /* 2131362452 */:
                SetSleepDialog(1);
                return;
            case R.id.start_night_pref /* 2131362473 */:
                SetStartAndEndDialog(0);
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.sounds = getResources().getStringArray(R.array.ampm);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.pref_header_ampm);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.settings_ampm, viewGroup, false);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePickerDialog timePickerDialog, int i, int i2, int i3) {
        SharedPreferences.Editor edit = this.sp.edit();
        String str = this.nightStart ? "nightStart" : "nightEnd";
        if (this.nightStart) {
            this.nightStartI = i;
        } else {
            this.nightEndI = i;
        }
        edit.putInt(str, i);
        edit.apply();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.start_night_pref);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.end_night_pref);
        this.dayDesc = (TextView) view.findViewById(R.id.sleepDay_Desc);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.sleepDay_pref);
        this.nightDesc = (TextView) view.findViewById(R.id.sleepNight_Desc);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.sleepNight_pref);
        constraintLayout.setOnClickListener(this);
        constraintLayout2.setOnClickListener(this);
        constraintLayout3.setOnClickListener(this);
        constraintLayout4.setOnClickListener(this);
        this.sp = getActivity().getSharedPreferences("Settings", 0);
        this.nightStartI = this.sp.getInt("nightStart", 23);
        this.nightEndI = this.sp.getInt("nightEnd", 7);
        this.sleepDayI = this.sp.getInt("sleepDay", 0);
        this.sleepNightI = this.sp.getInt("sleepNight", 0);
        setInfo(constraintLayout3.getId());
        setInfo(constraintLayout4.getId());
    }
}
