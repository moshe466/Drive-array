package atlow.chemi.mymada.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import atlow.chemi.mymada.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public class OxyCalc extends Fragment {
    private EditText atm;
    private Spinner oxyType;
    private EditText psi;
    private TextView time;

    /* loaded from: classes.dex */
    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EditText editText;
            String string;
            int id = this.view.getId();
            if (id == R.id.ATM) {
                String trim = OxyCalc.this.atm.getText().toString().trim();
                if (trim.isEmpty() || !trim.matches("[0-9]+")) {
                    OxyCalc.this.time.setText("0");
                    return;
                }
                double parseInt = Integer.parseInt(trim.replaceAll("[\\D]", ""));
                double d = OxyCalc.this.oxyType.getSelectedItemPosition() == 0 ? 2.4d : 20.0d;
                TextView textView = OxyCalc.this.time;
                FragmentActivity activity = OxyCalc.this.getActivity();
                Double.isNaN(parseInt);
                textView.setText(activity.getString(R.string.oxyCalc, new Object[]{Integer.valueOf(((int) (d * parseInt)) / 10)}));
                if (!OxyCalc.this.atm.hasFocus()) {
                    return;
                }
                editText = OxyCalc.this.psi;
                string = OxyCalc.this.getActivity().getString(R.string.oxyCalc, new Object[]{Integer.valueOf(((int) parseInt) * 15)});
            } else {
                if (id != R.id.PSI) {
                    return;
                }
                String trim2 = OxyCalc.this.psi.getText().toString().trim();
                if (trim2.isEmpty() || !trim2.matches("[0-9]+")) {
                    return;
                }
                double parseInt2 = Integer.parseInt(trim2.replaceAll("[\\D]", ""));
                if (!OxyCalc.this.psi.hasFocus()) {
                    return;
                }
                editText = OxyCalc.this.atm;
                string = OxyCalc.this.getActivity().getString(R.string.oxyCalc, new Object[]{Integer.valueOf(((int) parseInt2) / 15)});
            }
            editText.setText(string);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getActivity() != null) {
            getActivity().setTitle(R.string.button_g);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_oxy_calc, viewGroup, false);
        this.oxyType = (Spinner) inflate.findViewById(R.id.OxyTypeS);
        this.psi = (EditText) inflate.findViewById(R.id.PSI);
        this.atm = (EditText) inflate.findViewById(R.id.ATM);
        this.time = (TextView) inflate.findViewById(R.id.txtOxyMin);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.refreshDrawableState();
        Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
        EditText editText = this.atm;
        editText.addTextChangedListener(new MyTextWatcher(editText));
        EditText editText2 = this.psi;
        editText2.addTextChangedListener(new MyTextWatcher(editText2));
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.ATM_TIL);
        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.PSI_TIL);
        TextView textView = (TextView) view.findViewById(R.id.txt_TimerSecond);
        TextView textView2 = (TextView) view.findViewById(R.id.twoOxy);
        textView.setFocusable(true);
        textView2.setClickable(true);
        this.atm.setText(getActivity().getResources().getString(R.string.atm_100));
        this.psi.setText(getActivity().getResources().getString(R.string.psi_1500));
        this.psi.setTypeface(createFromAsset);
        this.atm.setTypeface(createFromAsset);
        this.time.setTypeface(createFromAsset);
        textInputLayout.setTypeface(createFromAsset);
        textInputLayout2.setTypeface(createFromAsset);
        textView.setTypeface(createFromAsset);
        textView2.setTypeface(createFromAsset);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, getActivity().getResources().getStringArray(R.array.oxySizes));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.oxyType.setAdapter((SpinnerAdapter) arrayAdapter);
        this.oxyType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: atlow.chemi.mymada.fragments.OxyCalc.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                OxyCalc.this.atm.setText(OxyCalc.this.atm.getText().toString());
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
