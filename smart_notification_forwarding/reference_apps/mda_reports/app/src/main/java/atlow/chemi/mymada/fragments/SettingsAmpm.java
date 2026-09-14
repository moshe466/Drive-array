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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sleep(int r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "sleepDay"
            java.lang.String r1 = "sleepNight"
            if (r15 != 0) goto L8
            r2 = r0
            goto L9
        L8:
            r2 = r1
        L9:
            r3 = 8
            r4 = 7
            r5 = 6
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 0
            r10 = 2
            r11 = 1
            if (r15 != r11) goto L48
            android.content.SharedPreferences r12 = r13.sp
            int r0 = r12.getInt(r0, r9)
            if (r0 == 0) goto L3d
            if (r0 == r11) goto L30
            if (r0 == r10) goto L22
            goto L48
        L22:
            if (r14 == 0) goto L2e
            if (r14 == r11) goto L2c
            if (r14 == r10) goto L29
            goto L48
        L29:
            r0 = 8
            goto L49
        L2c:
            r0 = 7
            goto L49
        L2e:
            r0 = 6
            goto L49
        L30:
            if (r14 == 0) goto L3b
            if (r14 == r11) goto L39
            if (r14 == r10) goto L37
            goto L48
        L37:
            r0 = 5
            goto L49
        L39:
            r0 = 4
            goto L49
        L3b:
            r0 = 3
            goto L49
        L3d:
            if (r14 == 0) goto L48
            if (r14 == r11) goto L46
            if (r14 == r10) goto L44
            goto L48
        L44:
            r0 = 2
            goto L49
        L46:
            r0 = 1
            goto L49
        L48:
            r0 = 0
        L49:
            if (r15 != 0) goto L7d
            android.content.SharedPreferences r15 = r13.sp
            int r15 = r15.getInt(r1, r9)
            if (r15 == 0) goto L70
            if (r15 == r11) goto L63
            if (r15 == r10) goto L58
            goto L7d
        L58:
            if (r14 == 0) goto L61
            if (r14 == r11) goto L5f
            if (r14 == r10) goto L7e
            goto L7d
        L5f:
            r3 = 5
            goto L7e
        L61:
            r3 = 2
            goto L7e
        L63:
            if (r14 == 0) goto L6e
            if (r14 == r11) goto L6c
            if (r14 == r10) goto L6a
            goto L7d
        L6a:
            r3 = 7
            goto L7e
        L6c:
            r3 = 4
            goto L7e
        L6e:
            r3 = 1
            goto L7e
        L70:
            if (r14 == 0) goto L7b
            if (r14 == r11) goto L79
            if (r14 == r10) goto L77
            goto L7d
        L77:
            r3 = 6
            goto L7e
        L79:
            r3 = 3
            goto L7e
        L7b:
            r3 = 0
            goto L7e
        L7d:
            r3 = r0
        L7e:
            android.content.SharedPreferences r15 = r13.sp
            android.content.SharedPreferences$Editor r15 = r15.edit()
            r15.putInt(r2, r14)
            java.lang.String r14 = "sleep"
            r15.putInt(r14, r3)
            r15.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: atlow.chemi.mymada.fragments.SettingsAmpm.Sleep(int, int):void");
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
