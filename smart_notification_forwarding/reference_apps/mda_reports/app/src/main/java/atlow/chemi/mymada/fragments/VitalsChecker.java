package atlow.chemi.mymada.fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.SettingsPage;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class VitalsChecker extends Fragment {
    private String bad;
    private String bpS;
    private EditText breathing;
    private String breathingS;
    private TextInputLayout breathingTIL;
    private EditText diastolic;
    private TextInputLayout diastolicTIL;
    private boolean goodB;
    private boolean goodDIA;
    private boolean goodLD;
    private boolean goodP;
    private String goodS;
    private boolean goodSYS;
    private int lowB;
    private int lowDIA;
    private int lowP;
    private int lowSYS;
    private EditText pulsa;
    private TextInputLayout pulsaTIL;
    private String pulseS;
    private EditText systolic;
    private TextInputLayout systolicTIL;
    private int topB;
    private int topDIA;
    private int topP;
    private int topSYS;
    private TextView vitalInf;
    private LinearLayout vitalInfBG;
    private TextView vitalMsg;
    private LinearLayout vitalMsgBG;
    private TextView vitalR;
    private int ageRank = 0;
    private int[][][] correct = (int[][][]) Array.newInstance((Class<?>) int.class, 4, 6, 6);

    /* loaded from: classes.dex */
    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.view.getId() == R.id.systolic && (!VitalsChecker.this.systolic.getText().toString().trim().isEmpty() || VitalsChecker.this.systolic.getText().toString().trim().matches("[0-9]+"))) {
                VitalsChecker.this.systolicTIL.setErrorEnabled(false);
                if ((VitalsChecker.this.systolic.getText().toString().length() == 2 && !VitalsChecker.this.systolic.getText().toString().startsWith("1")) || VitalsChecker.this.systolic.getText().toString().length() == 3) {
                    VitalsChecker.this.diastolic.requestFocus();
                }
            }
            VitalsChecker.this.calc();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    private void SetNums() {
        int i = this.ageRank;
        this.topP = i == 0 ? this.correct[3][0][2] : i == 1 ? this.correct[3][0][1] : this.correct[3][0][0];
        int i2 = this.ageRank;
        this.lowP = i2 == 0 ? this.correct[3][1][2] : i2 == 1 ? this.correct[3][1][1] : this.correct[3][1][0];
        int i3 = this.ageRank;
        this.topB = i3 == 0 ? this.correct[2][0][2] : i3 == 1 ? this.correct[2][0][1] : this.correct[2][0][0];
        int i4 = this.ageRank;
        this.lowB = i4 == 0 ? this.correct[2][1][2] : i4 == 1 ? this.correct[2][1][1] : this.correct[2][1][0];
        int i5 = this.ageRank;
        this.topSYS = i5 == 0 ? this.correct[0][0][2] : i5 == 1 ? this.correct[0][0][1] : this.correct[0][0][0];
        int i6 = this.ageRank;
        this.lowSYS = i6 == 0 ? this.correct[0][1][2] : i6 == 1 ? this.correct[0][1][1] : this.correct[0][1][0];
        int i7 = this.ageRank;
        this.topDIA = i7 == 0 ? this.correct[1][0][2] : i7 == 1 ? this.correct[1][0][1] : this.correct[1][0][0];
        int i8 = this.ageRank;
        this.lowDIA = i8 == 0 ? this.correct[1][1][2] : i8 == 1 ? this.correct[1][1][1] : this.correct[1][1][0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calc() {
        Drawable background;
        Drawable background2;
        Drawable background3;
        TextInputLayout textInputLayout;
        Drawable background4;
        TextInputLayout textInputLayout2;
        int i = this.ageRank;
        this.topP = i == 0 ? this.correct[3][0][2] : i == 1 ? this.correct[3][0][1] : this.correct[3][0][0];
        int i2 = this.ageRank;
        this.lowP = i2 == 0 ? this.correct[3][1][2] : i2 == 1 ? this.correct[3][1][1] : this.correct[3][1][0];
        if (!this.pulsa.getText().toString().trim().isEmpty() || this.pulsa.getText().toString().trim().matches("[0-9]+")) {
            int parseInt = Integer.parseInt(this.pulsa.getText().toString().trim().replaceAll("[\\D]", ""));
            this.goodP = parseInt >= this.lowP && parseInt <= this.topP;
        }
        int i3 = this.ageRank;
        this.topB = i3 == 0 ? this.correct[2][0][2] : i3 == 1 ? this.correct[2][0][1] : this.correct[2][0][0];
        int i4 = this.ageRank;
        this.lowB = i4 == 0 ? this.correct[2][1][2] : i4 == 1 ? this.correct[2][1][1] : this.correct[2][1][0];
        if (!this.breathing.getText().toString().trim().isEmpty() || this.breathing.getText().toString().trim().matches("[0-9]+")) {
            int parseInt2 = Integer.parseInt(this.breathing.getText().toString().trim().replaceAll("[\\D]", ""));
            this.goodB = parseInt2 >= this.lowB && parseInt2 <= this.topB;
        }
        int i5 = this.ageRank;
        this.topSYS = i5 == 0 ? this.correct[0][0][2] : i5 == 1 ? this.correct[0][0][1] : this.correct[0][0][0];
        int i6 = this.ageRank;
        this.lowSYS = i6 == 0 ? this.correct[0][1][2] : i6 == 1 ? this.correct[0][1][1] : this.correct[0][1][0];
        if (!this.systolic.getText().toString().trim().isEmpty() || this.systolic.getText().toString().trim().matches("[0-9]+")) {
            int parseInt3 = Integer.parseInt(this.systolic.getText().toString().trim().replaceAll("[\\D]", ""));
            this.goodSYS = parseInt3 >= this.lowSYS && parseInt3 <= this.topSYS;
        }
        int i7 = this.ageRank;
        this.topDIA = i7 == 0 ? this.correct[1][0][2] : i7 == 1 ? this.correct[1][0][1] : this.correct[1][0][0];
        int i8 = this.ageRank;
        this.lowDIA = i8 == 0 ? this.correct[1][1][2] : i8 == 1 ? this.correct[1][1][1] : this.correct[1][1][0];
        if (!this.diastolic.getText().toString().trim().isEmpty() || this.diastolic.getText().toString().trim().matches("[0-9]+")) {
            int parseInt4 = Integer.parseInt(this.diastolic.getText().toString().trim().replaceAll("[\\D]", ""));
            this.goodDIA = parseInt4 >= this.lowDIA && parseInt4 <= this.topDIA;
        }
        if ((!this.systolic.getText().toString().trim().isEmpty() || this.systolic.getText().toString().trim().matches("[0-9]+")) && (!this.diastolic.getText().toString().trim().isEmpty() || this.diastolic.getText().toString().trim().matches("[0-9]+"))) {
            int parseInt5 = Integer.parseInt(this.systolic.getText().toString().trim().replaceAll("[\\D]", "")) - Integer.parseInt(this.diastolic.getText().toString().trim().replaceAll("[\\D]", ""));
            this.goodLD = parseInt5 < 61 && parseInt5 > 29;
        }
        this.vitalInf.setText(getActivity().getResources().getString(R.string.goodVitalsOLD, Integer.valueOf(this.lowP), Integer.valueOf(this.topP), Integer.valueOf(this.lowB), Integer.valueOf(this.topB), Integer.valueOf(this.lowSYS), Integer.valueOf(this.topSYS), Integer.valueOf(this.lowDIA), Integer.valueOf(this.topDIA), getActivity().getResources().getStringArray(R.array.goodVitals)[this.ageRank]));
        int rgb = Color.rgb(70, 178, 58);
        int rgb2 = Color.rgb(191, 21, 22);
        int rgb3 = Color.rgb(50, 167, 195);
        if (this.pulsa.getText().toString().trim().isEmpty() || !this.goodP) {
            if (this.pulsa.getText().toString().trim().isEmpty() || this.goodP) {
                this.pulsa.setTextColor(rgb3);
                this.pulsaTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb3}));
                background = this.pulsaTIL.getEditText().getBackground();
                DrawableCompat.setTint(background, rgb3);
            } else {
                this.pulsa.setTextColor(rgb2);
                this.pulsaTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb2}));
                background = this.pulsaTIL.getEditText().getBackground();
                DrawableCompat.setTint(background, rgb2);
            }
            this.pulsaTIL.getEditText().setBackground(background);
        } else {
            this.pulsa.setTextColor(rgb);
            this.pulsaTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb}));
            Drawable background5 = this.pulsaTIL.getEditText().getBackground();
            DrawableCompat.setTint(background5, rgb);
            this.pulsaTIL.getEditText().setBackground(background5);
            this.pulsaTIL.setErrorEnabled(true);
        }
        if (!this.breathing.getText().toString().trim().isEmpty() && this.goodB) {
            this.breathing.setTextColor(rgb);
            this.breathingTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb}));
            background2 = this.breathingTIL.getEditText().getBackground();
            DrawableCompat.setTint(background2, rgb);
        } else if (this.breathing.getText().toString().trim().isEmpty() || this.goodB) {
            this.breathing.setTextColor(rgb3);
            this.breathingTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb3}));
            background2 = this.breathingTIL.getEditText().getBackground();
            DrawableCompat.setTint(background2, rgb3);
        } else {
            this.breathing.setTextColor(rgb2);
            this.breathingTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb2}));
            background2 = this.breathingTIL.getEditText().getBackground();
            DrawableCompat.setTint(background2, rgb2);
        }
        this.breathingTIL.getEditText().setBackground(background2);
        if (this.systolic.getText().toString().trim().isEmpty() || this.diastolic.getText().toString().trim().isEmpty()) {
            if (this.systolic.getText().toString().trim().isEmpty() || !this.diastolic.getText().toString().trim().isEmpty()) {
                this.systolic.setTextColor(rgb3);
                this.diastolic.setTextColor(rgb3);
                this.systolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb3}));
                this.diastolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb3}));
                background3 = this.systolicTIL.getEditText().getBackground();
                DrawableCompat.setTint(background3, rgb3);
                this.systolicTIL.getEditText().setBackground(background3);
                textInputLayout = this.diastolicTIL;
            } else {
                if (this.goodSYS) {
                    this.systolic.setTextColor(rgb);
                    this.systolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb}));
                    background4 = this.systolicTIL.getEditText().getBackground();
                    DrawableCompat.setTint(background4, rgb);
                    textInputLayout2 = this.systolicTIL;
                    textInputLayout2.getEditText().setBackground(background4);
                    return;
                }
                this.systolic.setTextColor(rgb2);
                this.systolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb2}));
                background3 = this.systolicTIL.getEditText().getBackground();
                DrawableCompat.setTint(background3, rgb2);
                textInputLayout = this.systolicTIL;
            }
        } else {
            if (this.goodSYS && this.goodDIA && this.goodLD) {
                this.systolic.setTextColor(rgb);
                this.diastolic.setTextColor(rgb);
                this.systolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb}));
                this.diastolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb}));
                background4 = this.systolicTIL.getEditText().getBackground();
                DrawableCompat.setTint(background4, rgb);
                this.systolicTIL.getEditText().setBackground(background4);
                textInputLayout2 = this.diastolicTIL;
                textInputLayout2.getEditText().setBackground(background4);
                return;
            }
            this.systolic.setTextColor(rgb2);
            this.diastolic.setTextColor(rgb2);
            this.systolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb2}));
            this.diastolicTIL.setDefaultHintTextColor(new ColorStateList(new int[][]{new int[]{0}}, new int[]{rgb2}));
            background3 = this.systolicTIL.getEditText().getBackground();
            DrawableCompat.setTint(background3, rgb2);
            this.systolicTIL.getEditText().setBackground(background3);
            textInputLayout = this.diastolicTIL;
        }
        textInputLayout.getEditText().setBackground(background3);
    }

    public /* synthetic */ void a(RadioGroup radioGroup, RadioGroup radioGroup2, int i) {
        this.ageRank = radioGroup.indexOfChild(radioGroup.findViewById(i));
        calc();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.button_e);
        }
        int[][][] iArr = this.correct;
        iArr[0][0] = new int[]{90, 110, 140};
        iArr[0][1] = new int[]{60, 90, 90};
        iArr[1][0] = new int[]{60, 80, 90};
        iArr[1][1] = new int[]{40, 50, 60};
        iArr[2][0] = new int[]{60, 30, 20};
        iArr[2][1] = new int[]{22, 18, 12};
        iArr[3][0] = new int[]{130, 120, 100};
        iArr[3][1] = new int[]{125, 90, 60};
        FirebaseDatabase.getInstance().getReference().child("Vitals").addListenerForSingleValueEvent(new ValueEventListener() { // from class: atlow.chemi.mymada.fragments.VitalsChecker.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                VitalsChecker.this.correct[1][0][0] = ((Integer) dataSnapshot.child("BloodPressure").child("Diastolic").child("Baby_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[1][0][1] = ((Integer) dataSnapshot.child("BloodPressure").child("Diastolic").child("Child_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[1][0][2] = ((Integer) dataSnapshot.child("BloodPressure").child("Diastolic").child("Old_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[1][1][0] = ((Integer) dataSnapshot.child("BloodPressure").child("Diastolic").child("Baby_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[1][1][1] = ((Integer) dataSnapshot.child("BloodPressure").child("Diastolic").child("Child_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[1][1][2] = ((Integer) dataSnapshot.child("BloodPressure").child("Diastolic").child("Old_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[0][0][0] = ((Integer) dataSnapshot.child("BloodPressure").child("Systolic").child("Baby_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[0][0][1] = ((Integer) dataSnapshot.child("BloodPressure").child("Systolic").child("Child_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[0][0][2] = ((Integer) dataSnapshot.child("BloodPressure").child("Systolic").child("Old_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[0][1][0] = ((Integer) dataSnapshot.child("BloodPressure").child("Systolic").child("Baby_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[0][1][1] = ((Integer) dataSnapshot.child("BloodPressure").child("Systolic").child("Child_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[0][1][2] = ((Integer) dataSnapshot.child("BloodPressure").child("Systolic").child("Old_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[2][0][0] = ((Integer) dataSnapshot.child("Breathing").child("Baby_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[2][0][1] = ((Integer) dataSnapshot.child("Breathing").child("Child_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[2][0][2] = ((Integer) dataSnapshot.child("Breathing").child("Old_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[2][1][0] = ((Integer) dataSnapshot.child("Breathing").child("Baby_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[2][1][1] = ((Integer) dataSnapshot.child("Breathing").child("Child_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[2][1][2] = ((Integer) dataSnapshot.child("Breathing").child("Old_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[3][0][0] = ((Integer) dataSnapshot.child("Pulse").child("Baby_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[3][0][1] = ((Integer) dataSnapshot.child("Pulse").child("Child_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[3][0][2] = ((Integer) dataSnapshot.child("Pulse").child("Old_high").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[3][1][0] = ((Integer) dataSnapshot.child("Pulse").child("Baby_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[3][1][1] = ((Integer) dataSnapshot.child("Pulse").child("Child_low").getValue(Integer.class)).intValue();
                VitalsChecker.this.correct[3][1][2] = ((Integer) dataSnapshot.child("Pulse").child("Old_low").getValue(Integer.class)).intValue();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_vital, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.breathingS = getActivity().getResources().getString(R.string.vitalsBreath);
        this.bpS = getActivity().getResources().getString(R.string.vitalsBP);
        this.pulseS = getActivity().getResources().getString(R.string.vitalsPulse);
        this.goodS = getActivity().getResources().getString(R.string.vitalsTakin);
        this.bad = getActivity().getResources().getString(R.string.vitalsNotTakin);
        Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.old);
        RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.kid);
        RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.baby);
        radioButton.setTypeface(createFromAsset);
        radioButton2.setTypeface(createFromAsset);
        radioButton3.setTypeface(createFromAsset);
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioAge);
        if (!SettingsPage.isRTL()) {
            radioGroup.setLayoutDirection(0);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: atlow.chemi.mymada.fragments.i1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                VitalsChecker.this.a(radioGroup, radioGroup2, i);
            }
        });
        this.pulsa = (EditText) view.findViewById(R.id.pulsa);
        this.breathing = (EditText) view.findViewById(R.id.breathing);
        this.systolic = (EditText) view.findViewById(R.id.systolic);
        this.diastolic = (EditText) view.findViewById(R.id.diastolic);
        this.pulsa.setTypeface(createFromAsset);
        this.breathing.setTypeface(createFromAsset);
        this.systolic.setTypeface(createFromAsset);
        this.diastolic.setTypeface(createFromAsset);
        this.pulsaTIL = (TextInputLayout) view.findViewById(R.id.pulsaTIL);
        this.breathingTIL = (TextInputLayout) view.findViewById(R.id.breathingTIL);
        this.systolicTIL = (TextInputLayout) view.findViewById(R.id.systolicTIL);
        this.diastolicTIL = (TextInputLayout) view.findViewById(R.id.diastolicTIL);
        this.pulsaTIL.setTypeface(createFromAsset);
        this.breathingTIL.setTypeface(createFromAsset);
        this.systolicTIL.setTypeface(createFromAsset);
        this.diastolicTIL.setTypeface(createFromAsset);
        EditText editText = this.pulsa;
        editText.addTextChangedListener(new MyTextWatcher(editText));
        EditText editText2 = this.breathing;
        editText2.addTextChangedListener(new MyTextWatcher(editText2));
        EditText editText3 = this.systolic;
        editText3.addTextChangedListener(new MyTextWatcher(editText3));
        EditText editText4 = this.diastolic;
        editText4.addTextChangedListener(new MyTextWatcher(editText4));
        this.vitalR = (TextView) view.findViewById(R.id.vitalsResult);
        this.vitalR.setMovementMethod(new ScrollingMovementMethod());
        this.vitalR.setTypeface(createFromAsset);
        this.vitalInf = (TextView) view.findViewById(R.id.VitalInf);
        this.vitalInf.setTypeface(createFromAsset);
        this.vitalMsg = (TextView) view.findViewById(R.id.VitalMsg);
        this.vitalMsg.setTypeface(createFromAsset);
        this.vitalInfBG = (LinearLayout) view.findViewById(R.id.VitalInfBG);
        this.vitalMsgBG = (LinearLayout) view.findViewById(R.id.VitalMsgBG);
        if (SettingsPage.isRTL()) {
            this.vitalInfBG.setLayoutDirection(1);
            this.vitalMsgBG.setLayoutDirection(1);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) this.vitalInfBG.getBackground();
        gradientDrawable.mutate();
        gradientDrawable.setColor(getActivity().getResources().getColor(R.color.White));
        this.vitalInfBG.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = (GradientDrawable) this.vitalMsgBG.getBackground();
        gradientDrawable2.mutate();
        gradientDrawable2.setColor(getActivity().getResources().getColor(R.color.White));
        this.vitalMsgBG.setBackground(gradientDrawable2);
        SetNums();
        this.vitalInf.setText(getActivity().getResources().getString(R.string.goodVitalsOLD, Integer.valueOf(this.lowP), Integer.valueOf(this.topP), Integer.valueOf(this.lowB), Integer.valueOf(this.topB), Integer.valueOf(this.lowSYS), Integer.valueOf(this.topSYS), Integer.valueOf(this.lowDIA), Integer.valueOf(this.topDIA), getActivity().getResources().getStringArray(R.array.goodVitals)[this.ageRank]));
        this.vitalMsg.setText(getActivity().getResources().getString(R.string.vitalsAlert));
        this.vitalInf.setMovementMethod(new ScrollingMovementMethod());
        this.vitalMsg.setMovementMethod(new ScrollingMovementMethod());
    }
}
