package atlow.chemi.mymada.fragments;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.SettingsPage;
import atlow.chemi.mymada.adapters.VolunteerAdapter;
import atlow.chemi.mymada.classes.Volunteer;
import com.crashlytics.android.Crashlytics;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MainActivity2 extends Fragment implements View.OnTouchListener {
    private VolunteerAdapter adapter;
    private EditText addManName;
    private TextInputLayout addManTIL;
    private List<Volunteer> albumList;
    private TextInputLayout ambNum;
    private TextView explain;
    private LayoutInflater inflater;
    private int job;
    private Typeface myTypeface;
    private String name;
    private Button newPplBtn;
    private float oldX;
    private float oldY;
    private EditText txtboxN;
    private String[] colors = {"נהג", "חובש", "פראמדיק", "רופא", "מתנדב", "משתלם", "שירות לאומי"};
    private boolean isMove = false;

    /* loaded from: classes.dex */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private boolean includeEdge;
        private int spacing;
        private int spanCount;

        GridSpacingItemDecoration(MainActivity2 mainActivity2, int i, int i2, boolean z) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.spanCount;
            int i2 = childAdapterPosition % i;
            if (this.includeEdge) {
                int i3 = this.spacing;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (childAdapterPosition < i) {
                    rect.top = i3;
                }
                rect.bottom = this.spacing;
                return;
            }
            int i4 = this.spacing;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition >= i) {
                rect.top = i4;
            }
        }
    }

    /* loaded from: classes.dex */
    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout;
            TextInputLayout textInputLayout2;
            String string;
            int id = this.view.getId();
            if (id == R.id.M2txt1E) {
                if (!MainActivity2.this.txtboxN.getText().toString().isEmpty()) {
                    textInputLayout = MainActivity2.this.ambNum;
                    textInputLayout.setErrorEnabled(false);
                } else {
                    textInputLayout2 = MainActivity2.this.ambNum;
                    string = MainActivity2.this.getActivity().getResources().getString(R.string.err_amb);
                    textInputLayout2.setError(string);
                }
            }
            if (id != R.id.addManName) {
                return;
            }
            if (!MainActivity2.this.addManName.getText().toString().isEmpty()) {
                textInputLayout = MainActivity2.this.addManTIL;
                textInputLayout.setErrorEnabled(false);
            } else {
                textInputLayout2 = MainActivity2.this.addManTIL;
                string = MainActivity2.this.getActivity().getString(R.string.emailNameNone);
                textInputLayout2.setError(string);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteVol(int i) {
        this.albumList.remove(i);
        this.adapter.notifyDataSetChanged();
        if (this.newPplBtn.getVisibility() != 0) {
            this.newPplBtn.setVisibility(0);
        }
    }

    private void di(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
        builder.setTitle(getResources().getString(R.string.err)).setMessage(str).setCancelable(false).setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.j0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    private int dpToPx(int i) {
        return Math.round(TypedValue.applyDimension(1, i, getResources().getDisplayMetrics()));
    }

    private void sms(final String str) {
        final String[] strArr = {"+972523993348", "+972523993345", "+972523993339", "+972523993338", "+972523993342", "+972523993337", "+972523993343", "+972523993340", "+972523993346", "+972523993356", "+972523993341", "+972586309592"};
        final int i = getActivity().getSharedPreferences("Settings", 0).getInt("merhav", 0);
        String str2 = str.length() + " " + getResources().getString(R.string.smsCountChar) + " " + ((str.length() / 70) + 1) + " " + getResources().getString(R.string.smsCountMsg);
        String str3 = getActivity().getResources().getString(R.string.toDispatch) + new String[]{"ירושלים", "איילון", "אשר", "גלבוע", "דן", "ירדן", "ירקון", "כרמל", "לכיש", "נגב", "שרון", "מוקד 4"}[i] + ".";
        String str4 = str3 + "\n\n" + str + "\n\n";
        SpannableString spannableString = new SpannableString(str4 + str2);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 0, str3.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(-7829368), str4.length(), spannableString.length(), 0);
        final AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle).setTitle(getActivity().getResources().getString(R.string.suc)).setMessage(spannableString).setCancelable(false).setNegativeButton(getResources().getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.b0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        }).setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.i0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MainActivity2.this.a(strArr, i, str, dialogInterface, i2);
            }
        }).create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.h0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                MainActivity2.this.a(create, dialogInterface);
            }
        });
        create.show();
    }

    public /* synthetic */ void a(ArrayAdapter arrayAdapter, View view) {
        this.inflater = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        View inflate = this.inflater.inflate(R.layout.add_human, (ViewGroup) null);
        final Spinner spinner = (Spinner) inflate.findViewById(R.id.addManSpinner);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.addManName = (EditText) inflate.findViewById(R.id.addManName);
        this.addManTIL = (TextInputLayout) inflate.findViewById(R.id.addManTIL);
        EditText editText = this.addManName;
        editText.addTextChangedListener(new MyTextWatcher(editText));
        this.addManName.setTypeface(this.myTypeface);
        this.addManTIL.setTypeface(this.myTypeface);
        final AlertDialog create = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle).setTitle(getActivity().getResources().getString(R.string.Nteam)).setView(inflate).setCancelable(false).setNegativeButton(getActivity().getResources().getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.c0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(getActivity().getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.l0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                MainActivity2.this.a(create, spinner, dialogInterface);
            }
        });
        create.show();
    }

    public /* synthetic */ void a(Spinner spinner, int i, AlertDialog alertDialog, View view) {
        if (this.addManName.getText().toString().isEmpty()) {
            this.addManTIL.setError(getContext().getResources().getString(R.string.emailNameNone));
        }
        if (this.addManName.getText().toString().trim().length() > 0) {
            this.addManTIL.setErrorEnabled(false);
            this.name = this.addManName.getText().toString();
            this.job = spinner.getSelectedItemPosition();
            this.albumList.get(i).setName(this.name);
            this.albumList.get(i).setJob(this.job);
            this.adapter.notifyDataSetChanged();
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void a(Spinner spinner, AlertDialog alertDialog, View view) {
        if (this.addManName.getText().toString().isEmpty()) {
            this.addManTIL.setError(getActivity().getResources().getString(R.string.emailNameNone));
        }
        if (this.addManName.getText().toString().trim().length() > 0) {
            this.addManTIL.setErrorEnabled(false);
            this.albumList.add(new Volunteer(this.addManName.getText().toString(), spinner.getSelectedItemPosition()));
            this.adapter.notifyDataSetChanged();
            int size = this.albumList.size();
            if (size == 1) {
                this.explain.setVisibility(8);
            } else if (size == 4) {
                this.newPplBtn.setVisibility(8);
            }
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-2);
        Button button2 = alertDialog.getButton(-1);
        button.setTypeface(this.myTypeface);
        button2.setTypeface(this.myTypeface);
        button.setTextColor(getActivity().getResources().getColor(R.color.OldPrimary));
    }

    public /* synthetic */ void a(final AlertDialog alertDialog, final Spinner spinner, final int i, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getContext().getResources().getColor(R.color.OldPrimary));
        alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity2.this.a(spinner, i, alertDialog, view);
            }
        });
    }

    public /* synthetic */ void a(final AlertDialog alertDialog, final Spinner spinner, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(getActivity().getResources().getColor(R.color.OldPrimary));
        alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity2.this.a(spinner, alertDialog, view);
            }
        });
    }

    public /* synthetic */ void a(String[] strArr, int i, String str, DialogInterface dialogInterface, int i2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + strArr[i]));
        intent.putExtra("sms_body", str);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Crashlytics.log("sms not sent!");
            Crashlytics.logException(e);
        }
        dialogInterface.cancel();
    }

    public /* synthetic */ void b(View view) {
        if (this.txtboxN.getText().toString().trim().isEmpty()) {
            this.ambNum.setError(getActivity().getResources().getString(R.string.err_amb));
            return;
        }
        this.ambNum.setErrorEnabled(false);
        int i = getActivity().getSharedPreferences("Settings", 0).getInt("merhav", 0);
        StringBuilder sb = new StringBuilder("צוות אמבולנס ");
        sb.append(new String[]{"י-ם", "איילון", "אשר", "גלבוע", "דן", "ירדן", "ירקון", "כרמל", "לכיש", "נגב", "שרון", "מוקד 4"}[i]);
        sb.append(" ");
        sb.append((CharSequence) this.txtboxN.getText());
        sb.append(":\n");
        if (this.albumList.size() == 0) {
            di(getActivity().getResources().getString(R.string.SendNoNames));
            return;
        }
        for (int i2 = 0; i2 < this.albumList.size(); i2++) {
            if (i2 != 0) {
                sb.append("\n");
            }
            sb.append(this.colors[this.albumList.get(i2).getJob()]);
            sb.append(" - ");
            sb.append(this.albumList.get(i2).getName());
        }
        sms(sb.toString());
    }

    public void editVol(final int i) {
        View inflate = this.inflater.inflate(R.layout.add_human, (ViewGroup) null);
        final Spinner spinner = (Spinner) inflate.findViewById(R.id.addManSpinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, this.colors);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.addManName = (EditText) inflate.findViewById(R.id.addManName);
        this.addManName.setText(this.albumList.get(i).getName());
        spinner.setSelection(this.albumList.get(i).getJob());
        this.addManTIL = (TextInputLayout) inflate.findViewById(R.id.addManTIL);
        final AlertDialog create = new AlertDialog.Builder(getContext(), R.style.AlertDialogStyle).setTitle(getContext().getResources().getString(R.string.Nteam)).setView(inflate).setCancelable(false).setNegativeButton(getContext().getResources().getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.d0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(getContext().getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.m0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                MainActivity2.this.a(create, spinner, i, dialogInterface);
            }
        });
        create.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_main2, viewGroup, false);
        if (SettingsPage.isRTL()) {
            inflate.setRotationY(180.0f);
        }
        return inflate;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldY = motionEvent.getY();
            this.oldX = motionEvent.getX();
            this.isMove = false;
            view.setAlpha(0.4f);
            return true;
        }
        if (action == 1) {
            view.setAlpha(1.0f);
            if (!this.isMove) {
                view.performClick();
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        boolean z = this.oldX - motionEvent.getX() > 10.0f || motionEvent.getX() - this.oldX > 10.0f;
        boolean z2 = this.oldY - motionEvent.getY() > 50.0f || motionEvent.getY() - this.oldY > 50.0f;
        if (z || z2) {
            this.isMove = true;
            view.setAlpha(1.0f);
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
        Button button = (Button) view.findViewById(R.id.M2btn1ENew);
        this.newPplBtn = (Button) view.findViewById(R.id.newManNew);
        GradientDrawable gradientDrawable = (GradientDrawable) this.newPplBtn.getBackground();
        gradientDrawable.mutate();
        gradientDrawable.setColor(ContextCompat.getColor(getActivity(), R.color.White));
        this.newPplBtn.setBackground(gradientDrawable);
        this.newPplBtn.setTextColor(ContextCompat.getColor(getActivity(), R.color.ColorNice));
        if (!SettingsPage.isRTL()) {
            ((LinearLayout) view.findViewById(R.id.LinBtns)).setLayoutDirection(0);
        }
        VectorDrawableCompat create = VectorDrawableCompat.create(getResources(), R.drawable.ic_send, null);
        if (Build.VERSION.SDK_INT > 17) {
            button.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, create, (Drawable) null);
        } else if (getResources().getConfiguration().getLayoutDirection() == 128) {
            button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, create, (Drawable) null);
        } else {
            button.setCompoundDrawablesWithIntrinsicBounds(create, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.albumList = new ArrayList();
        this.adapter = new VolunteerAdapter(getActivity(), this.albumList);
        this.adapter.DeleteVolunteerEvent.addListener(new VolunteerAdapter.ChangeVolunteer() { // from class: atlow.chemi.mymada.fragments.k0
            @Override // atlow.chemi.mymada.adapters.VolunteerAdapter.ChangeVolunteer
            public final void invoke(int i) {
                MainActivity2.this.deleteVol(i);
            }
        });
        this.adapter.EditVolunteerEvent.addListener(new VolunteerAdapter.ChangeVolunteer() { // from class: atlow.chemi.mymada.fragments.j1
            @Override // atlow.chemi.mymada.adapters.VolunteerAdapter.ChangeVolunteer
            public final void invoke(int i) {
                MainActivity2.this.editVol(i);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setRotationY(180.0f);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(this, 2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.adapter);
        this.explain = (TextView) view.findViewById(R.id.explain);
        this.explain.setTypeface(this.myTypeface);
        this.txtboxN = (EditText) view.findViewById(R.id.M2txt1E);
        this.txtboxN.setTypeface(this.myTypeface);
        EditText editText = this.txtboxN;
        editText.addTextChangedListener(new MyTextWatcher(editText));
        this.ambNum = (TextInputLayout) view.findViewById(R.id.M2ambulance);
        this.ambNum.setTypeface(this.myTypeface);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, this.colors);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.newPplBtn.setOnTouchListener(this);
        this.newPplBtn.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity2.this.a(arrayAdapter, view2);
            }
        });
        button.setOnTouchListener(this);
        button.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity2.this.b(view2);
            }
        });
    }
}
