package atlow.chemi.mymada.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.SettingsPage;
import atlow.chemi.mymada.adapters.mCodeAdapt;
import atlow.chemi.mymada.classes.mCodeKid;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class MainActivity1 extends Fragment {
    private TextInputLayout ambulance;
    private boolean bool;
    private TextInputLayout code;
    private mCodeAdapt codeAdapter;
    private Dialog dialog;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    private EditText edit5;
    private EditText edit6;
    private EditText edita;
    private EditText editv;
    private TextInputLayout first;
    private TextInputLayout hn;
    private TextInputLayout ht;
    private TextInputLayout last;
    private Typeface myTypeface;
    private float oldX1;
    private float oldY1;
    private EditText sp;
    private SharedPreferences sp2;
    private TextInputLayout sum;
    private String txt;
    private boolean isMove = false;
    private boolean yishuv = true;
    private CharSequence[] _options = {"מצבי חירום סביבתיים", "2000 גוף זר באוזניים", "2001 גוף זר באף", "2002 גוף זר בעיניים", "2003 הכשת נחש", "2004 הרעלות", "2005 התייבשות", "2006 מכת ברק", "2007 עקיצת עקרב", "2008 פגיעה מבע\"ח", "2009 פגיעות חום", "2010 פגיעות קור", "2011 רגישות יתר / אלרגיה", "2012 שאיפת חומרים רעילים", "2013 שאיפת עשן", "2014 תגובה אנפילקטית", "2015 צריכת יתר אלכוהול", "2016 צריכת יתר סמים", "2017 צריכת יתר תרופות", "2018 תליה", "2099 אחר", "טראומה", "3000 חבלה בגפיים", "3001 חבלה בצוואר", "3002 חבלה רב מערכתית", "3003 חבלת חזה", "3004 חבלת ראש", "3005 חבלת אגן", "3006 חבלת בטן", "3007 חבלת עמ\"ש", "3008 חבלת פנים", "3009 חשד לשבר צוואר ירך", "3010 חשד לשבר בגפיים עליונות", "3011  חשד לשבר בגפיים תחתונות", "3012 כוויה", "3017 כוויה דרגה 1", "3018 כוויה דרגה 2", "3019 כוויה דרגה 3", "3013 כוויה כימית", "3014 פגיעת מעיכה", "3015 קטיעת אצבעות", "3016 קטיעת גפיים", "3099 אחר", "כאבים", "4000 כאב/לחץ בחזה שאינו ממקור לבבי", "4001 כאבי אוזניים", "4002 כאבי בטן", "4003 כאבי גב", "4004 כאבי עיניים", "4005 כאבי ראש", "4006 כאבים באיבר מין", "4007 כאבים בגרון", "4008 כאבים בידיים", "4009 כאבים בכל הגוף", "4010 כאבים בצוואר", "4011 כאבים ברגליים", "4012 כאבי שיניים", "4099 אחר", "מערכת הלב וכלי הדם", "5010 בעיות בקוצב לב / דפיברילטור מושתל", "5000 בצקת ריאות / החמרה באי ספיקת לב", "5001 ברדיקרדיה", "5002 דום לב ונשימה", "5003 דפיקות לב", "5011  הלם קרדיוגני", "5004 הפרעות קצב אחרות", "5012 חסם עלייתי - חדרי", "5013 חשד לאוטם בשריר הלב", "5009 חשד למוות בעריסה", "5005 חשד לתסמונת כלילית חריפה", "5014 טאכיקרדיה חדרית (VT)", "5015 טאכיקרדיה על חדרית (PSVT)", "5006 יתר לחץ דם", "5007 לחץ דם נמוך", "5016 פרפור / רפרוף פרוזדורים", "5008 שינויים בא.ק.ג", "5099 אחר", "מערכת הנשימה", "6000 דום נשימה", "6004 החמרה ב- COPD", "6005 התקף אסטמה", "6001 חנק / אספירציה / גוף זר", "6006 חשד לדלקת ריאות", "6007 חשד לתסחיף ריאתי", "6008 סטרידור", "6002 קוצר נשימה", "6003 שיעול / שיעול דמי", "6099 אחר", "נוירולוגיה", "7001 בלבול", "7002 התעלפות", "7003 לאחר התעלפות", "7004 חולשה כללית", "7005 חוסר הכרה", "7006 ירידה בתפקוד", "7007  לאחר פרכוס", "7008 סחרחורות", "7009 פרכוסים", "7010 שבץ מוחי / שבץ מוחי חולף (TIA / CVA)", "7011 שינוי במצב ההכרה", "7099 אחר", "מערכת העיכול", "8000 בחילות ו/ או הקאות", "8001 דימום רקטאלי", "8002 הקאות דמיות", "8005  חשד לגסטרואנטריטיס", "8006 חשד לחסימת מעיים", "8007 חשד למצב חירום בטני", "8008 כיב פפטי", "8009 מלנה", "8003 עצירות", "8004 שלשולים", "8099 אחר", "זיהומי", "9000 חום גבוה", "9001 חשד למנינגיטיס", "9002 חשד לספסיס / הלם ספטי", "9003 צלוליטיס", "9099 אחר", "פסיכיאטריה", "1001 חולה משתולל", "1005 חשד להפרעות נפשיות", "1006 חשד להתקף פסיכוטי", "1002 חשד לניסיון אובדני", "1003 חשד לתגובת חרדה", "1004 מחשבות אובדניות", "1099 אחר", "אנדוקרינולוגיה", "1102 בעיות בבלוטת התריס", "1100 היפוגליקמיה", "1101 היפרגליקמיה", "1199 אחר", "מערכת המין והשתן", "1200 אצירת שתן", "1201 בעיות גניקולוגיות", "1202 דימום וגינאלי", "1203 דלקת בדרכי השתן", "1204  דם בשתן", "1205 חשד להפלה", "1206 חשד לעווית כלייתית (colic renal)", "1207 ירידת מים", "1208 צירי לידה", "1209 קבלת לידה", "1299 אחר", "כללי", "1300  אירוע ללא נפגעים", "1305 המטופל מסרב לפינוי", "1306 המטופל מסרב לקבל טיפול", "1307 המשפחה מסרבת טיפול", "1308 המשפחה מסרבת לפינוי", "1312 ללא מחלה או פגיעה", "1313 מוות ודאי - לא בוצעה החייאה", "1314 קריאת שווא", "1315  חשש לחיי אדם", "1316 בדיקות דם לא תקינות", "1317 ההעברה מבי\"ח לבי\"ח", "1318 העברה מהבית למתקן רפואי", "1319 העברה ממתקן רפואי הביתה", "1320 העברה ממתקן רפואי לבית אבות", "1350 קביעת מוות / הכרזה על מוות", "1399 אחר"};
    private CharSequence[] _optionsNum = {"sep", "2000", NativeAppInstallAd.ASSET_HEADLINE, NativeAppInstallAd.ASSET_CALL_TO_ACTION, NativeAppInstallAd.ASSET_ICON, NativeAppInstallAd.ASSET_BODY, NativeAppInstallAd.ASSET_STORE, NativeAppInstallAd.ASSET_PRICE, NativeAppInstallAd.ASSET_IMAGE, NativeAppInstallAd.ASSET_STAR_RATING, NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE, "2010", NativeAppInstallAd.ASSET_MEDIA_VIDEO, "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2099", "sep", "3000", UnifiedNativeAdAssetNames.ASSET_HEADLINE, UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, UnifiedNativeAdAssetNames.ASSET_ICON, UnifiedNativeAdAssetNames.ASSET_BODY, UnifiedNativeAdAssetNames.ASSET_ADVERTISER, UnifiedNativeAdAssetNames.ASSET_STORE, UnifiedNativeAdAssetNames.ASSET_PRICE, UnifiedNativeAdAssetNames.ASSET_IMAGE, UnifiedNativeAdAssetNames.ASSET_STAR_RATING, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, "3012", "3017", "3018", "3019", "3013", "3014", "3015", "3016", "3099", "sep", "4000", "4001", "4002", "4003", "4004", "4005", "4006", "4007", "4008", "4009", "4010", "4011", "4012", "4099", "sep", "5010", "5000", "5001", "5002", "5003", "5011", "5004", "5012", "5013", "5009", "5005", "5014", "5015", "5006", "5007", "5016", "5008", "5099", "sep", "6000", "6004", "6005", "6001", "6006", "6007", "6008", "6002", "6003", "6099", "sep", "7001", "7002", "7003", "7004", "7005", "7006", "7007", "7008", "7009", "7010", "7011", "7099", "sep", "8000", "8001", "8002", "8005", "8006", "8007", "8008", "8009", "8003", "8004", "8099", "sep", "9000", "9001", "9002", "9003", "9099", "sep", NativeContentAd.ASSET_HEADLINE, NativeContentAd.ASSET_IMAGE, NativeContentAd.ASSET_LOGO, NativeContentAd.ASSET_BODY, NativeContentAd.ASSET_CALL_TO_ACTION, NativeContentAd.ASSET_ADVERTISER, "1099", "sep", "1102", "1100", "1101", "1199", "sep", "1200", "1201", "1202", "1203", "1204", "1205", "1206", "1207", "1208", "1209", "1299", "sep", "1300", "1305", "1306", "1307", "1308", "1312", "1313", "1314", "1315", "1316", "1317", "1318", "1319", "1320", "1350", "1399"};
    private String[] _optionsCat = {"area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "area", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "trauma", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "pain", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "vasc", "resp", "resp", "resp", "resp", "resp", "resp", "resp", "resp", "resp", "resp", "resp", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "neuro", "gastro", "gastro", "gastro", "gastro", "gastro", "gastro", "gastro", "gastro", "gastro", "gastro", "gastro", "gastro", "infect", "infect", "infect", "infect", "infect", "infect", "pshyc", "pshyc", "pshyc", "pshyc", "pshyc", "pshyc", "pshyc", "pshyc", "ando", "ando", "ando", "ando", "ando", "pish", "pish", "pish", "pish", "pish", "pish", "pish", "pish", "pish", "pish", "pish", "pish", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali", "clali"};
    private String kodR = "";

    /* loaded from: classes.dex */
    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(Button button, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        button.performClick();
        return false;
    }

    private void sms(final String str) {
        final String[] strArr = {"+972523993348", "+972523993345", "+972523993339", "+972523993338", "+972523993342", "+972523993337", "+972523993343", "+972523993340", "+972523993346", "+972523993356", "+972523993341", "+972586309592"};
        final int i = this.sp2.getInt("merhav", 0);
        String str2 = str.length() + " " + getResources().getString(R.string.smsCountChar) + " " + ((str.length() / 70) + 1) + " " + getResources().getString(R.string.smsCountMsg);
        String str3 = getActivity().getResources().getString(R.string.toDispatch) + new String[]{"ירושלים", "איילון", "אשר", "גלבוע", "דן", "ירדן", "ירקון", "כרמל", "לכיש", "נגב", "שרון", "מוקד 4"}[i] + ".";
        String str4 = str3 + "\n\n" + str + "\n\n";
        SpannableString spannableString = new SpannableString(str4 + str2);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 0, str3.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(-7829368), str4.length(), spannableString.length(), 0);
        final AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle).setTitle(getActivity().getResources().getString(R.string.suc)).setMessage(spannableString).setCancelable(false).setNegativeButton(getResources().getString(R.string.ret), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        }).setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MainActivity1.this.a(strArr, i, str, dialogInterface, i2);
            }
        }).create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: atlow.chemi.mymada.fragments.s
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                MainActivity1.this.a(create, dialogInterface);
            }
        });
        create.show();
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        if (this.codeAdapter.getId(i).equals("sep")) {
            return;
        }
        CheckBox cb = (CheckBox) view.findViewById(R.id.mcName);
        if (cb != null) {
            cb.setChecked(!cb.isChecked());
        }
        String checked = this.codeAdapter.getChecked();
        this.kodR = checked;
        this.sp.setText(checked);
    }

    public /* synthetic */ void a(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-2);
        Button button2 = alertDialog.getButton(-1);
        button.setTypeface(this.myTypeface);
        button2.setTypeface(this.myTypeface);
        button.setTextColor(getActivity().getResources().getColor(R.color.OldPrimary));
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

    public /* synthetic */ boolean a(Button button, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oldY1 = motionEvent.getY();
            this.oldX1 = motionEvent.getX();
            this.isMove = false;
            button.setAlpha(0.4f);
            return true;
        }
        if (action == 1) {
            button.setAlpha(1.0f);
            if (!this.isMove) {
                button.performClick();
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
            button.setAlpha(1.0f);
        }
        return true;
    }

    public /* synthetic */ boolean a(EditText editText, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            this.sp.performClick();
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        return false;
    }

    public /* synthetic */ void b(View view) {
        View inflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.list_medical, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.userListView);
        this.codeAdapter.filter("");
        listView.setAdapter((ListAdapter) this.codeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: atlow.chemi.mymada.fragments.t
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                MainActivity1.this.a(adapterView, view2, i, j);
            }
        });
        ((EditText) inflate.findViewById(R.id.userSearch)).addTextChangedListener(new TextWatcher() { // from class: atlow.chemi.mymada.fragments.MainActivity1.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MainActivity1.this.codeAdapter.filter(charSequence.toString().toLowerCase(Locale.getDefault()));
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
        builder.setTitle("בחר קודים רפואיים");
        builder.setView(inflate);
        builder.setPositiveButton(getActivity().getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: atlow.chemi.mymada.fragments.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        this.dialog = builder.create();
        this.dialog.show();
    }

    public /* synthetic */ void c(View view) {
        StringBuilder sb;
        this.bool = true;
        this.ambulance = (TextInputLayout) getActivity().findViewById(R.id.M1ambulanceNumber);
        this.hn = (TextInputLayout) getActivity().findViewById(R.id.M1HoleNifga);
        this.ht = (TextInputLayout) getActivity().findViewById(R.id.M1Hitchayvut);
        this.first = (TextInputLayout) getActivity().findViewById(R.id.M1firstName);
        this.last = (TextInputLayout) getActivity().findViewById(R.id.M1familyName);
        this.sum = (TextInputLayout) getActivity().findViewById(R.id.M1Schum);
        this.code = (TextInputLayout) getActivity().findViewById(R.id.M1MedicalCode);
        this.edit1 = (EditText) getActivity().findViewById(R.id.M1txt1E);
        this.editv = (EditText) getActivity().findViewById(R.id.M1visaT);
        this.edita = (EditText) getActivity().findViewById(R.id.M1addressT);
        this.edit2 = (EditText) getActivity().findViewById(R.id.M1txt2E);
        this.edit3 = (EditText) getActivity().findViewById(R.id.M1txt3);
        this.edit4 = (EditText) getActivity().findViewById(R.id.M1txt4E);
        this.edit5 = (EditText) getActivity().findViewById(R.id.M1txt5);
        this.edit6 = (EditText) getActivity().findViewById(R.id.M1txt6E);
        EditText editText = this.sp;
        editText.addTextChangedListener(new MyTextWatcher(editText));
        EditText editText2 = this.edit1;
        editText2.addTextChangedListener(new MyTextWatcher(editText2));
        EditText editText3 = this.editv;
        editText3.addTextChangedListener(new MyTextWatcher(editText3));
        EditText editText4 = this.edita;
        editText4.addTextChangedListener(new MyTextWatcher(editText4));
        EditText editText5 = this.edit2;
        editText5.addTextChangedListener(new MyTextWatcher(editText5));
        EditText editText6 = this.edit3;
        editText6.addTextChangedListener(new MyTextWatcher(editText6));
        EditText editText7 = this.edit4;
        editText7.addTextChangedListener(new MyTextWatcher(editText7));
        EditText editText8 = this.edit5;
        editText8.addTextChangedListener(new MyTextWatcher(editText8));
        EditText editText9 = this.edit6;
        editText9.addTextChangedListener(new MyTextWatcher(editText9));
        this.sp.setTypeface(this.myTypeface);
        this.edit1.setTypeface(this.myTypeface);
        this.editv.setTypeface(this.myTypeface);
        this.edita.setTypeface(this.myTypeface);
        this.edit2.setTypeface(this.myTypeface);
        this.edit3.setTypeface(this.myTypeface);
        this.edit4.setTypeface(this.myTypeface);
        this.edit5.setTypeface(this.myTypeface);
        this.edit6.setTypeface(this.myTypeface);
        this.ambulance.setTypeface(this.myTypeface);
        this.hn.setTypeface(this.myTypeface);
        this.ht.setTypeface(this.myTypeface);
        this.first.setTypeface(this.myTypeface);
        this.last.setTypeface(this.myTypeface);
        this.sum.setTypeface(this.myTypeface);
        this.code.setTypeface(this.myTypeface);
        if (this.edit1.getText().toString().trim().isEmpty()) {
            this.ambulance.setError(getString(R.string.err_amb));
            this.bool = false;
        } else {
            this.ambulance.setErrorEnabled(false);
        }
        if (this.edit2.getText().toString().length() < 1) {
            this.hn.setError(getString(R.string.err_hn));
            this.bool = false;
        } else {
            this.hn.setErrorEnabled(false);
        }
        if (this.edit4.getText().toString().length() < 1) {
            this.first.setError(getString(R.string.err_fn));
            this.bool = false;
        } else {
            this.first.setErrorEnabled(false);
        }
        if (this.edit5.getText().toString().length() < 1) {
            this.last.setError(getString(R.string.err_ln));
            this.bool = false;
        } else {
            this.last.setErrorEnabled(false);
        }
        if (this.kodR.length() < 1 || !this.kodR.matches("^[0-9]{1,4}(\\s*,\\s*[0-9]{1,4})*$")) {
            this.code.setError(getString(R.string.err_mc));
            this.bool = false;
        } else {
            this.code.setErrorEnabled(false);
        }
        if (this.edit6.getText().toString().length() > 0 || this.edit3.getText().toString().length() > 0) {
            this.yishuv = false;
            if (this.edit3.getText().toString().length() < 1) {
                this.ht.setError(getString(R.string.err_ht));
                this.bool = false;
            } else {
                this.ht.setErrorEnabled(false);
            }
            if (this.edit6.getText().toString().length() < 1) {
                this.sum.setError(getString(R.string.err_sum));
                this.bool = false;
            } else {
                this.sum.setErrorEnabled(false);
            }
        }
        if (this.bool) {
            if (this.yishuv) {
                this.txt = "אמב' " + this.edit1.getText().toString();
                if (this.editv.getText().length() > 1) {
                    this.txt += "\nויזה: " + this.editv.getText().toString();
                }
                if (this.edita.getText().length() > 1) {
                    this.txt += "\nכתובת: " + this.edita.getText().toString();
                }
                this.txt += "\nחולה נפגע " + this.edit2.getText().toString();
                this.txt += "\nקוד " + this.kodR;
                sb = new StringBuilder();
            } else {
                this.txt = "אמב' " + this.edit1.getText().toString();
                if (this.editv.getText().length() > 1) {
                    this.txt += "\nויזה: " + this.editv.getText().toString();
                }
                if (this.edita.getText().length() > 1) {
                    this.txt += "\nכתובת: " + this.edita.getText().toString();
                }
                this.txt += "\nחולה נפגע " + this.edit2.getText().toString();
                this.txt += "\nהתחייבות " + this.edit3.getText().toString();
                this.txt += "\nסכום " + this.edit6.getText().toString();
                this.txt += "\nקוד " + this.kodR;
                sb = new StringBuilder();
            }
            sb.append(this.txt);
            sb.append("\nשם: ");
            sb.append(this.edit4.getText().toString());
            sb.append(" ");
            sb.append(this.edit5.getText().toString());
            this.txt = sb.toString();
            sms(this.txt);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/opensanshebrew.ttf");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (SettingsPage.isRTL()) {
            inflate.setRotationY(180.0f);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.sp2 = getContext().getSharedPreferences("Settings", 0);
        ArrayList arrayList = new ArrayList();
        boolean[] zArr = new boolean[this._options.length];
        for (int i = 0; i < this._options.length; i++) {
            arrayList.add(new mCodeKid(((Object) this._options[i]) + "", ((Object) this._optionsNum[i]) + "", this._optionsCat[i], i));
            zArr[i] = this._optionsNum[i].equals("sep");
        }
        this.codeAdapter = new mCodeAdapt(getContext(), arrayList);
        this.sp = (EditText) view.findViewById(R.id.M1button2);
        final Button button = (Button) view.findViewById(R.id.M1btnN);
        final EditText editText = (EditText) view.findViewById(R.id.M1txt5);
        VectorDrawableCompat create = VectorDrawableCompat.create(getResources(), R.drawable.ic_send, null);
        if (Build.VERSION.SDK_INT > 17) {
            button.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, create, (Drawable) null);
        } else if (getResources().getConfiguration().getLayoutDirection() == 128) {
            button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, create, (Drawable) null);
        } else {
            button.setCompoundDrawablesWithIntrinsicBounds(create, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.sp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: atlow.chemi.mymada.fragments.y
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return MainActivity1.a(button, textView, i2, keyEvent);
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: atlow.chemi.mymada.fragments.z
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return MainActivity1.this.a(editText, textView, i2, keyEvent);
            }
        });
        this.sp.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity1.this.b(view2);
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() { // from class: atlow.chemi.mymada.fragments.v
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return MainActivity1.this.a(button, view2, motionEvent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: atlow.chemi.mymada.fragments.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainActivity1.this.c(view2);
            }
        });
    }
}
