package atlow.chemi.mymada.fragments;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.AnimatedColor;

/* loaded from: classes.dex */
public class GlazgoCalc extends Fragment {
    private TextView a;
    private AnimatedColor color;
    private Spinner eye;
    private Spinner motor;
    private int newer;
    private int old;
    private Spinner verb;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private void Animate(int i, int i2) {
        this.old = this.newer;
        Log.e("COLORS", "start: " + i + " end: " + i2);
        int rgb = Color.rgb(193, 21, 22);
        int rgb2 = Color.rgb(193, 21, 22);
        if (i >= 9) {
            rgb = Color.rgb(221, 190, 66);
        }
        if (i > 12) {
            rgb = Color.rgb(70, 178, 58);
        }
        if (i2 >= 9) {
            rgb2 = Color.rgb(221, 190, 66);
        }
        if (i2 > 12) {
            rgb2 = Color.rgb(70, 178, 58);
        }
        this.color = new AnimatedColor(rgb, rgb2);
        ValueAnimator duration = ObjectAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: atlow.chemi.mymada.fragments.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GlazgoCalc.this.a(valueAnimator);
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calc() {
        StringBuilder sb;
        Resources resources;
        int i;
        this.newer = 0;
        this.newer += this.eye.getSelectedItemPosition() + 1;
        this.newer += this.verb.getSelectedItemPosition() + 1;
        this.newer += this.motor.getSelectedItemPosition() + 1;
        ((GradientDrawable) this.a.getBackground()).mutate();
        int i2 = this.newer;
        if (i2 < 9) {
            Animate(this.old, i2);
            sb = new StringBuilder();
            sb.append(" (");
            resources = getActivity().getResources();
            i = R.string.GlasgowHigh;
        } else if (i2 > 12) {
            Animate(this.old, i2);
            sb = new StringBuilder();
            sb.append(" (");
            resources = getActivity().getResources();
            i = R.string.GlasgowLow;
        } else {
            Animate(this.old, i2);
            sb = new StringBuilder();
            sb.append(" (");
            resources = getActivity().getResources();
            i = R.string.GlasgowMed;
        }
        sb.append(resources.getString(i));
        sb.append(")");
        String sb2 = sb.toString();
        this.a.setText(getActivity().getResources().getString(R.string.Glasgow, this.newer + sb2));
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Log.e("COLOR::", "r " + Color.red(this.color.with(0.4555f)));
        GradientDrawable gradientDrawable = (GradientDrawable) this.a.getBackground();
        gradientDrawable.mutate();
        gradientDrawable.setColor(this.color.with(floatValue));
        this.a.setBackground(gradientDrawable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.button_gl);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_glazgo_calc, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
        TextView textView = (TextView) view.findViewById(R.id.EyeTxt);
        TextView textView2 = (TextView) view.findViewById(R.id.VerbalTxt);
        TextView textView3 = (TextView) view.findViewById(R.id.MotorTxt);
        TextView textView4 = (TextView) view.findViewById(R.id.GLZInf);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.GLZInfBG);
        this.a = (TextView) view.findViewById(R.id.GLZGrade);
        this.a.setTypeface(createFromAsset);
        GradientDrawable gradientDrawable = (GradientDrawable) this.a.getBackground();
        gradientDrawable.mutate();
        gradientDrawable.setColor(ContextCompat.getColor(getActivity(), R.color.calcB));
        this.a.setBackground(gradientDrawable);
        this.old = 3;
        textView4.setTypeface(createFromAsset);
        textView.setTypeface(createFromAsset, 1);
        textView2.setTypeface(createFromAsset, 1);
        textView3.setTypeface(createFromAsset, 1);
        String[] stringArray = getActivity().getResources().getStringArray(R.array.eyes);
        String[] stringArray2 = getActivity().getResources().getStringArray(R.array.verb);
        String[] stringArray3 = getActivity().getResources().getStringArray(R.array.moto);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray2);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, stringArray3);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.eye = (Spinner) view.findViewById(R.id.EyeS);
        this.verb = (Spinner) view.findViewById(R.id.VerbalS);
        this.motor = (Spinner) view.findViewById(R.id.MotorS);
        this.eye.setAdapter((SpinnerAdapter) arrayAdapter);
        this.verb.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.motor.setAdapter((SpinnerAdapter) arrayAdapter3);
        this.eye.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.GlazgoCalc.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                GlazgoCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.verb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.GlazgoCalc.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                GlazgoCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.motor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.GlazgoCalc.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                GlazgoCalc.this.calc();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        GradientDrawable gradientDrawable2 = (GradientDrawable) linearLayout.getBackground();
        gradientDrawable2.mutate();
        gradientDrawable2.setColor(getActivity().getResources().getColor(R.color.White));
        linearLayout.setBackground(gradientDrawable2);
        textView4.setText(getActivity().getResources().getString(R.string.GlasgowInfo));
        textView4.setMovementMethod(new ScrollingMovementMethod());
    }
}
