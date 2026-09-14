package atlow.chemi.mymada.fragments;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.AnimatedColor;

/* loaded from: classes.dex */
public class ApgarCalc extends Fragment {
    private Spinner Activity;
    private Spinner Apperence;
    private Spinner Grimace;
    private Spinner Pulse;
    private Spinner Respirations;
    private TextView a;
    private AnimatedColor color;
    private int newer;
    private int old;

    private void Animate(int i, int i2) {
        this.old = this.newer;
        Log.e("COLORS", "start: " + i + " end: " + i2);
        int rgb = Color.rgb(191, 21, 22);
        int rgb2 = Color.rgb(191, 21, 22);
        if (i > 3) {
            rgb = Color.rgb(221, 190, 66);
        }
        if (i > 6) {
            rgb = Color.rgb(70, 178, 58);
        }
        if (i2 > 3) {
            rgb2 = Color.rgb(221, 190, 66);
        }
        if (i2 > 6) {
            rgb2 = Color.rgb(70, 178, 58);
        }
        this.color = new AnimatedColor(rgb, rgb2);
        ValueAnimator duration = ObjectAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.fragments.ApgarCalc.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Log.e("COLOR::", "r " + Color.red(ApgarCalc.this.color.with(0.4555f)));
                GradientDrawable gradientDrawable = (GradientDrawable) ApgarCalc.this.a.getBackground();
                gradientDrawable.mutate();
                gradientDrawable.setColor(ApgarCalc.this.color.with(floatValue));
                ApgarCalc.this.a.setBackground(gradientDrawable);
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calc() {
        this.newer = 0;
        this.newer += this.Apperence.getSelectedItemPosition();
        this.newer += this.Pulse.getSelectedItemPosition();
        this.newer += this.Grimace.getSelectedItemPosition();
        this.newer += this.Activity.getSelectedItemPosition();
        this.newer += this.Respirations.getSelectedItemPosition();
        String string = getActivity().getResources().getString(R.string.Apgar, Integer.valueOf(this.newer));
        GradientDrawable gradientDrawable = (GradientDrawable) this.a.getBackground();
        gradientDrawable.mutate();
        int i = this.newer;
        if (i >= 4) {
        }
        Animate(this.old, i);
        this.a.setBackground(gradientDrawable);
        this.a.setText(string);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.button_ag);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_apgar_calc, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
        TextView textView = (TextView) view.findViewById(R.id.ApperenceTxt);
        TextView textView2 = (TextView) view.findViewById(R.id.PulseTxt);
        TextView textView3 = (TextView) view.findViewById(R.id.GrimaceTxt);
        TextView textView4 = (TextView) view.findViewById(R.id.ActivityTxt);
        TextView textView5 = (TextView) view.findViewById(R.id.RespirationsTxt);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ApgarInfBG);
        TextView textView6 = (TextView) view.findViewById(R.id.ApgarInfi);
        this.a = (TextView) view.findViewById(R.id.ApgarGrade);
        this.a.setTypeface(createFromAsset);
        textView6.setTypeface(createFromAsset);
        textView.setTypeface(createFromAsset, 1);
        textView2.setTypeface(createFromAsset, 1);
        textView3.setTypeface(createFromAsset, 1);
        textView4.setTypeface(createFromAsset, 1);
        textView5.setTypeface(createFromAsset, 1);
        String[] stringArray = getActivity().getResources().getStringArray(R.array.Appes);
        String[] stringArray2 = getActivity().getResources().getStringArray(R.array.Pulss);
        String[] stringArray3 = getActivity().getResources().getStringArray(R.array.Grims);
        String[] stringArray4 = getActivity().getResources().getStringArray(R.array.Actis);
        String[] stringArray5 = getActivity().getResources().getStringArray(R.array.Resps);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray2);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray3);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray4);
        ArrayAdapter arrayAdapter5 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray5);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.Apperence = (Spinner) view.findViewById(R.id.ApperenceS);
        this.Pulse = (Spinner) view.findViewById(R.id.PulseS);
        this.Grimace = (Spinner) view.findViewById(R.id.GrimaceS);
        this.Activity = (Spinner) view.findViewById(R.id.ActivityS);
        this.Respirations = (Spinner) view.findViewById(R.id.RespirationsS);
        this.Apperence.setAdapter((SpinnerAdapter) arrayAdapter);
        this.Pulse.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.Grimace.setAdapter((SpinnerAdapter) arrayAdapter3);
        this.Activity.setAdapter((SpinnerAdapter) arrayAdapter4);
        this.Respirations.setAdapter((SpinnerAdapter) arrayAdapter5);
        this.Apperence.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.ApgarCalc.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                ApgarCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.Pulse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.ApgarCalc.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                ApgarCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.Grimace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.ApgarCalc.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                ApgarCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.Activity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.ApgarCalc.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                ApgarCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.Respirations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.ApgarCalc.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                ApgarCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        GradientDrawable gradientDrawable = (GradientDrawable) linearLayout.getBackground();
        gradientDrawable.mutate();
        gradientDrawable.setColor(getActivity().getResources().getColor(R.color.White));
        linearLayout.setBackground(gradientDrawable);
        textView6.setText(getActivity().getResources().getString(R.string.ApgarInfo));
        textView6.setMovementMethod(new ScrollingMovementMethod());
    }
}
