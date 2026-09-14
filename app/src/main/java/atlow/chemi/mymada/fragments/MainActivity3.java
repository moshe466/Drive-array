package atlow.chemi.mymada.fragments;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.SettingsPage;
import com.crashlytics.android.Crashlytics;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public class MainActivity3 extends Fragment implements View.OnTouchListener {
    private TextInputLayout freeMsg;
    private boolean isMove = false;
    private Button newSendButton;
    private float oldX1;
    private float oldY1;

    private void sms(final String str) {
        final String[] strArr = {"+972523993348", "+972523993345", "+972523993339", "+972523993338", "+972523993342", "+972523993337", "+972523993343", "+972523993340", "+972523993346", "+972523993356", "+972523993341", "+972586309592"};
        final int i = getActivity().getSharedPreferences("Settings", 0).getInt("merhav", 0);
        String str2 = str.length() + " " + getResources().getString(R.string.smsCountChar) + " " + ((str.length() / 70) + 1) + " " + getResources().getString(R.string.smsCountMsg);
        String str3 = getActivity().getResources().getString(R.string.toDispatch) + new String[]{"ירושלים", "איילון", "אשר", "גלבוע", "דן", "ירדן", "ירקון", "כרמל", "לכיש", "נגב", "שרון", "מוקד 4"}[i] + ".";
        String str4 = str3 + "\n\n" + str + "\n\n";
        SpannableString spannableString = new SpannableString(str4 + str2);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 0, str3.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(-7829368), str4.length(), spannableString.length(), 0);
        final AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle).setTitle(getActivity().getResources().getString(R.string.suc)).setMessage(spannableString).setCancelable(false).setNegativeButton(getResources().getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.q0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        }).setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.o0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MainActivity3.this.a(strArr, i, str, dialogInterface, i2);
            }
        }).create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.p0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                MainActivity3.this.a(create, dialogInterface);
            }
        });
        create.show();
    }

    public /* synthetic */ void a(EditText editText, View view) {
        if (editText.getText().toString().trim().length() >= 1) {
            sms(editText.getText().toString());
        } else {
            this.freeMsg.setError(getResources().getString(R.string.customMsgErr));
        }
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.getButton(-2).setTextColor(ContextCompat.getColor(getActivity(), R.color.OldPrimary));
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_main3, viewGroup, false);
        if (SettingsPage.isRTL()) {
            inflate.setRotationY(180.0f);
        }
        return inflate;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldY1 = motionEvent.getY();
            this.oldX1 = motionEvent.getX();
            this.isMove = false;
            this.newSendButton.setAlpha(0.4f);
            return true;
        }
        if (action == 1) {
            this.newSendButton.setAlpha(1.0f);
            if (!this.isMove) {
                this.newSendButton.performClick();
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        boolean z = this.oldX1 - motionEvent.getX() > 10.0f || motionEvent.getX() - this.oldX1 > 10.0f;
        boolean z2 = this.oldY1 - motionEvent.getY() > 50.0f || motionEvent.getY() - this.oldY1 > 50.0f;
        if (z || z2) {
            this.isMove = true;
            this.newSendButton.setAlpha(1.0f);
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final EditText editText = (EditText) view.findViewById(R.id.yourMsg);
        this.freeMsg = (TextInputLayout) view.findViewById(R.id.freeMsg);
        this.newSendButton = (Button) view.findViewById(R.id.yourMsgBtnNew);
        if (getActivity() != null) {
            VectorDrawableCompat create = VectorDrawableCompat.create(getResources(), R.drawable.ic_send, null);
            if (Build.VERSION.SDK_INT > 17) {
                this.newSendButton.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, create, (Drawable) null);
            } else if (getResources().getConfiguration().getLayoutDirection() == 128) {
                this.newSendButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, create, (Drawable) null);
            } else {
                this.newSendButton.setCompoundDrawablesWithIntrinsicBounds(create, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.newSendButton.setOnTouchListener(this);
        this.newSendButton.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity3.this.a(editText, view2);
            }
        });
    }
}
