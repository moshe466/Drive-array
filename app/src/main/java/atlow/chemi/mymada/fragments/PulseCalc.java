package atlow.chemi.mymada.fragments;

import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.AudioGenerator;
import com.crashlytics.android.Crashlytics;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public class PulseCalc extends Fragment {
    private static float vo;
    private CountDownTimer aCounter;
    private int currentVolume;
    private EditText fullPulse;
    private EditText pulse;
    private TextInputLayout pulseTIL;
    private boolean running = false;
    private TextView seconds;

    /* loaded from: classes.dex */
    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.view.getId() == R.id.fifteenPulseA) {
                if (PulseCalc.this.pulse.getText().toString().trim().isEmpty() || !PulseCalc.this.pulse.getText().toString().trim().matches("[0-9]+")) {
                    PulseCalc.this.pulseTIL.setError(PulseCalc.this.getString(R.string.err_pulse));
                    return;
                }
                PulseCalc.this.pulseTIL.setErrorEnabled(false);
                try {
                    PulseCalc.this.fullPulse.setText("" + (Integer.parseInt(PulseCalc.this.pulse.getText().toString().trim().replaceAll("[\\D]", "")) * 4));
                } catch (IndexOutOfBoundsException e) {
                    Crashlytics.log("error with pulse calculation");
                    Crashlytics.logException(e);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public /* synthetic */ void b(View view) {
        boolean z;
        if (this.running) {
            this.aCounter.cancel();
            this.seconds.setText("15");
            z = false;
        } else {
            this.aCounter.start();
            z = true;
        }
        this.running = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.button_c);
        }
        this.aCounter = new CountDownTimer(15000L, 1000L) { // from class: atlow.chemi.mymada.fragments.PulseCalc.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                try {
                    if (PulseCalc.this.seconds != null) {
                        PulseCalc.this.seconds.setText("0");
                    }
                    AudioGenerator audioGenerator = new AudioGenerator(8000);
                    double[] sineWave = audioGenerator.getSineWave(3000, 8000, 0.0d);
                    double[] sineWave2 = audioGenerator.getSineWave(3000, 8000, 9000.25d);
                    AudioManager audioManager = (AudioManager) PulseCalc.this.getActivity().getSystemService("audio");
                    int streamMaxVolume = audioManager.getStreamMaxVolume(4);
                    PulseCalc.this.currentVolume = audioManager.getStreamVolume(4);
                    float unused = PulseCalc.vo = audioManager.getStreamVolume(4);
                    audioManager.setStreamVolume(4, streamMaxVolume / 2, 0);
                    audioGenerator.createPlayer();
                    audioGenerator.writeSound(sineWave2);
                    audioGenerator.writeSound(sineWave);
                    audioGenerator.destroyAudioTrack();
                    audioManager.setStreamVolume(4, PulseCalc.this.currentVolume, 0);
                    PulseCalc.this.running = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String str = (j / 1000) + "";
                if (PulseCalc.this.seconds != null) {
                    PulseCalc.this.seconds.setText(str);
                }
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_pulse_calc, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.pulse = (EditText) view.findViewById(R.id.fifteenPulseA);
        this.fullPulse = (EditText) view.findViewById(R.id.fullPulseA);
        this.pulseTIL = (TextInputLayout) view.findViewById(R.id.shortPulseATIL);
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.fullPulseATIL);
        this.fullPulse.setInputType(0);
        EditText editText = this.pulse;
        editText.addTextChangedListener(new MyTextWatcher(editText));
        this.seconds = (TextView) view.findViewById(R.id.txtTimerSecond);
        TextView textView = (TextView) view.findViewById(R.id.txt_TimerSecond);
        TextView textView2 = (TextView) view.findViewById(R.id.txt_nothing);
        Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
        this.pulseTIL.setTypeface(createFromAsset);
        textInputLayout.setTypeface(createFromAsset);
        this.fullPulse.setTypeface(createFromAsset);
        this.pulse.setTypeface(createFromAsset);
        this.seconds.setTypeface(createFromAsset);
        textView.setTypeface(createFromAsset);
        textView2.setTypeface(createFromAsset);
        ((RelativeLayout) view.findViewById(R.id.clickableTimer)).setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PulseCalc.this.b(view2);
            }
        });
    }
}
