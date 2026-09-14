package c6;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.groboot.mdaemergency.models.RowAdapter;
import com.groboot.mdaemergency.models.SettingItem;
import com.groboot.mdaemergency.models.Settings;
import com.groboot.mdaemergency.models.SettingsList;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import w6.l0;

/* loaded from: classes.dex */
public class t extends ArrayAdapter<RowAdapter> {

    /* renamed from: f, reason: collision with root package name */
    private Context f4464f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<RowAdapter> f4465g;

    /* renamed from: h, reason: collision with root package name */
    private LayoutInflater f4466h;

    /* renamed from: i, reason: collision with root package name */
    h f4467i;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RowAdapter f4468f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f4469g;

        a(RowAdapter rowAdapter, int i10) {
            this.f4468f = rowAdapter;
            this.f4469g = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.this.f4467i.b(this.f4468f.type, view.getTag(), t.this.e(this.f4469g));
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SettingItem f4471f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ TextView f4472g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ RowAdapter f4473h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f4474i;

        b(SettingItem settingItem, TextView textView, RowAdapter rowAdapter, int i10) {
            this.f4471f = settingItem;
            this.f4472g = textView;
            this.f4473h = rowAdapter;
            this.f4474i = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.groboot.mdaemergency.enums.j jVar;
            com.groboot.mdaemergency.enums.j jVar2 = this.f4471f.type;
            if (jVar2 != null && jVar2 != (jVar = com.groboot.mdaemergency.enums.j.MultiSelect)) {
                this.f4472g.setSelected(!r6.isSelected());
                t.this.h(this.f4472g, this.f4471f.type == jVar);
                Iterator it = t.this.f4465g.iterator();
                while (it.hasNext()) {
                    RowAdapter rowAdapter = (RowAdapter) it.next();
                    if (rowAdapter.type == RowAdapter.eRowAdapterType.settingItem && rowAdapter.section == this.f4473h.section) {
                        ((SettingItem) rowAdapter.object).setValue(false);
                    }
                }
                this.f4471f.setValue(true);
                t.this.notifyDataSetChanged();
                t tVar = t.this;
                tVar.f4467i.b(RowAdapter.eRowAdapterType.checkbox, this.f4473h.object, tVar.e(this.f4474i));
                return;
            }
            this.f4472g.setSelected(!r6.isSelected());
            t.this.h(this.f4472g, this.f4471f.type == com.groboot.mdaemergency.enums.j.MultiSelect);
            this.f4471f.setValue(this.f4472g.isSelected());
            t.this.notifyDataSetChanged();
            t tVar2 = t.this;
            tVar2.f4467i.b(RowAdapter.eRowAdapterType.checkbox, this.f4473h.object, tVar2.e(this.f4474i));
            if (this.f4471f.CheckAll) {
                Iterator it2 = t.this.f4465g.iterator();
                while (it2.hasNext()) {
                    RowAdapter rowAdapter2 = (RowAdapter) it2.next();
                    if (rowAdapter2.type == RowAdapter.eRowAdapterType.settingItem && rowAdapter2.section == this.f4473h.section) {
                        ((SettingItem) rowAdapter2.object).setValue(this.f4472g.isSelected());
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f4476f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f4477g;

        c(TextView textView, int i10) {
            this.f4476f = textView;
            this.f4477g = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4476f.setSelected(!r5.isSelected());
            t.this.h(this.f4476f, true);
            t.this.f4467i.b(RowAdapter.eRowAdapterType.checkbox, Boolean.valueOf(this.f4476f.isSelected()), t.this.e(this.f4477g));
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Switch f4479f;

        d(t tVar, Switch r22) {
            this.f4479f = r22;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f4479f.setChecked(!r2.isChecked());
        }
    }

    /* loaded from: classes.dex */
    class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RowAdapter f4480a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Switch f4481b;

        e(RowAdapter rowAdapter, Switch r32) {
            this.f4480a = rowAdapter;
            this.f4481b = r32;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            t.this.f4467i.a((SettingItem) this.f4480a.object, this.f4481b.isChecked());
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RowAdapter f4483f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f4484g;

        f(RowAdapter rowAdapter, int i10) {
            this.f4483f = rowAdapter;
            this.f4484g = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t tVar = t.this;
            h hVar = tVar.f4467i;
            RowAdapter rowAdapter = this.f4483f;
            hVar.b(rowAdapter.type, rowAdapter.object, tVar.e(this.f4484g));
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4486a;

        static {
            int[] iArr = new int[RowAdapter.eRowAdapterType.values().length];
            f4486a = iArr;
            try {
                iArr[RowAdapter.eRowAdapterType.settingList.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.settingItem.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.permissions.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.checkbox.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.ExternalLinkItem.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.switchBox.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.shortcut.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.sendLogs.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.dialog.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4486a[RowAdapter.eRowAdapterType.sound.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(SettingItem settingItem, boolean z10);

        void b(RowAdapter.eRowAdapterType erowadaptertype, Object obj, String str);
    }

    public t(Context context, ArrayList<RowAdapter> arrayList, h hVar) {
        super(context, 0, arrayList);
        this.f4464f = context;
        this.f4467i = hVar;
        this.f4465g = arrayList;
        this.f4466h = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(SettingItem settingItem, View view) {
        this.f4467i.b(RowAdapter.eRowAdapterType.ExternalLinkItem, settingItem.Key, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(RowAdapter rowAdapter, int i10, View view) {
        this.f4467i.b(rowAdapter.type, null, e(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(TextView textView, boolean z10) {
        if (!textView.isSelected()) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(z10 ? R.drawable.setting_unchecked : R.drawable.radio_button_not_choose, 0, 0, 0);
            return;
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(z10 ? R.drawable.setting_checked : R.drawable.radio_button_choose, 0, 0, 0);
        textView.setVisibility(0);
        textView.setFocusable(true);
        textView.requestFocus();
    }

    public String e(int i10) {
        for (int i11 = i10 - 1; i11 >= 0 && this.f4465g.get(i11).section == this.f4465g.get(i10).section; i11--) {
            if (this.f4465g.get(i11).isSection && (this.f4465g.get(i11).object instanceof String)) {
                return (String) this.f4465g.get(i11).object;
            }
        }
        return "";
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i10, View view, ViewGroup viewGroup) {
        View.OnClickListener bVar;
        com.groboot.mdaemergency.enums.e byCode;
        com.groboot.mdaemergency.enums.k byKey;
        com.groboot.mdaemergency.enums.i byKey2;
        Context context;
        int i11;
        Context context2;
        int imageResId;
        final RowAdapter rowAdapter = this.f4465g.get(i10);
        View inflate = this.f4466h.inflate(R.layout.setting_list_item, (ViewGroup) null);
        inflate.setTag(rowAdapter.object);
        inflate.setOnClickListener(new a(rowAdapter, i10));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_text);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_caption);
        int i12 = 0;
        if (rowAdapter.isSection) {
            linearLayout.setVisibility(8);
            textView.setVisibility(0);
            inflate.setOnClickListener(null);
            inflate.setLongClickable(false);
            inflate.setOnLongClickListener(null);
            inflate.findViewById(R.id.ll_text).setVisibility(8);
            textView.setText((String) rowAdapter.object);
            return inflate;
        }
        linearLayout.setVisibility(0);
        textView.setVisibility(8);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_text);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_value);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_description);
        switch (g.f4486a[rowAdapter.type.ordinal()]) {
            case 1:
                textView4.setVisibility(8);
                SettingsList settingsList = (SettingsList) rowAdapter.object;
                textView2.setText(settingsList.Description);
                textView2.setTypeface(null, 0);
                String str = "";
                ArrayList<SettingItem> arrayList = settingsList.ItemList;
                if (arrayList != null) {
                    Iterator<SettingItem> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            SettingItem next = it.next();
                            if (next.Value) {
                                if (i12 > 4) {
                                    str = l0.u0(str, ", ") + "...";
                                } else {
                                    str = str + next.Description + ", ";
                                    i12++;
                                    if (!settingsList.MultiSelect) {
                                    }
                                }
                            }
                        }
                    }
                }
                textView3.setText(l0.u0(str, ", "));
                return inflate;
            case 2:
                SettingItem settingItem = (SettingItem) rowAdapter.object;
                inflate = this.f4466h.inflate(R.layout.setting_checkbox_item, (ViewGroup) null);
                TextView textView5 = (TextView) inflate.findViewById(R.id.tv_text);
                textView5.setText(settingItem.Description);
                textView5.setSelected(settingItem.Value);
                h(textView5, settingItem.type == com.groboot.mdaemergency.enums.j.MultiSelect);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.image_view);
                if (settingItem.type == com.groboot.mdaemergency.enums.j.SoundSetting && (byKey2 = com.groboot.mdaemergency.enums.i.getByKey(settingItem.Key)) != null && byKey2.getDescription(this.f4464f).equals(settingItem.Description)) {
                    imageView.setImageDrawable(androidx.core.content.a.f(this.f4464f, com.groboot.mdaemergency.enums.i.getByKey(settingItem.Key).getImageResId()));
                }
                if (settingItem.type == com.groboot.mdaemergency.enums.j.VibrateSetting && (byKey = com.groboot.mdaemergency.enums.k.getByKey(settingItem.Key)) != null && byKey.getDescription(this.f4464f).equals(settingItem.Description)) {
                    imageView.setImageDrawable(androidx.core.content.a.f(this.f4464f, com.groboot.mdaemergency.enums.k.getByKey(settingItem.Key).getImageResId()));
                }
                if (settingItem.type == com.groboot.mdaemergency.enums.j.Language && (byCode = com.groboot.mdaemergency.enums.e.getByCode(settingItem.Key)) != null && byCode.getCode().equals(settingItem.Key)) {
                    imageView.setImageDrawable(androidx.core.content.a.f(this.f4464f, byCode.getImageResId()));
                }
                bVar = new b(settingItem, textView5, rowAdapter, i10);
                break;
            case 3:
                w6.t tVar = (w6.t) rowAdapter.object;
                textView2.setText(tVar.f15258b);
                textView2.setTypeface(null, 1);
                textView4.setVisibility(0);
                textView4.setText(tVar.f15257a);
                if (tVar.b(this.f4464f)) {
                    context = this.f4464f;
                    i11 = R.string.has_permission;
                } else {
                    context = this.f4464f;
                    i11 = R.string.allow_permission;
                }
                textView3.setText(context.getString(i11));
                Context context3 = this.f4464f;
                textView3.setTextColor(androidx.core.content.a.d(context3, tVar.b(context3) ? R.color.blue_text : R.color.mada_red));
                return inflate;
            case 4:
                View inflate2 = this.f4466h.inflate(R.layout.setting_checkbox_item, (ViewGroup) null);
                TextView textView6 = (TextView) inflate2.findViewById(R.id.tv_text);
                textView6.setText((String) rowAdapter.object);
                textView6.setSelected(w6.m.A());
                h(textView6, true);
                inflate2.setOnClickListener(new c(textView6, i10));
                return inflate2;
            case 5:
                View inflate3 = this.f4466h.inflate(R.layout.settings_link_item, (ViewGroup) null);
                if (inflate3 == null) {
                    return inflate3;
                }
                TextView textView7 = (TextView) inflate3.findViewById(R.id.txv_link);
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate3.findViewById(R.id.ctr_wrapper);
                final SettingItem settingItem2 = (SettingItem) rowAdapter.object;
                SpannableString spannableString = new SpannableString(settingItem2.Description);
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                textView7.setText(spannableString);
                constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: c6.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        t.this.f(settingItem2, view2);
                    }
                });
                return inflate3;
            case 6:
                View inflate4 = this.f4466h.inflate(R.layout.setting_switch_item, (ViewGroup) null);
                TextView textView8 = (TextView) inflate4.findViewById(R.id.tv_text);
                SettingItem settingItem3 = (SettingItem) rowAdapter.object;
                textView8.setText(settingItem3.Description);
                Switch r12 = (Switch) inflate4.findViewById(R.id.btnSwitch);
                r12.setChecked(settingItem3.Value);
                inflate4.setOnClickListener(new d(this, r12));
                r12.setOnCheckedChangeListener(new e(rowAdapter, r12));
                return inflate4;
            case 7:
            case 8:
            case 9:
                textView2.setText((String) rowAdapter.object);
                textView4.setVisibility(8);
                textView3.setVisibility(8);
                bVar = new View.OnClickListener() { // from class: c6.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        t.this.g(rowAdapter, i10, view2);
                    }
                };
                break;
            case 10:
                inflate = this.f4466h.inflate(R.layout.setting_sound_item, (ViewGroup) null);
                TextView textView9 = (TextView) inflate.findViewById(R.id.tv_text);
                TextView textView10 = (TextView) inflate.findViewById(R.id.tv_value);
                SettingsList settingsList2 = (SettingsList) rowAdapter.object;
                textView9.setText(settingsList2.Description);
                ArrayList<SettingItem> arrayList2 = settingsList2.ItemList;
                if (arrayList2 != null) {
                    Iterator<SettingItem> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        SettingItem next2 = it2.next();
                        if (next2.Value) {
                            textView10.setText(next2.Description);
                        }
                    }
                }
                Settings.AlertSound alertSound = w6.m.J().alertSounds.get(Integer.valueOf(settingsList2.Type));
                if (alertSound == null) {
                    alertSound = new Settings.AlertSound();
                    Settings J = w6.m.J();
                    J.alertSounds.put(Integer.valueOf(settingsList2.Type), alertSound);
                    w6.m.V(J);
                }
                textView10.setText(this.f4464f.getString(alertSound.sound.getsoundNameResId()));
                com.groboot.mdaemergency.enums.i byKey3 = com.groboot.mdaemergency.enums.i.getByKey(alertSound.settingSound);
                com.groboot.mdaemergency.enums.k byKey4 = com.groboot.mdaemergency.enums.k.getByKey(alertSound.settingVibrate);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_sound);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.img_vibrate);
                if (byKey4 == com.groboot.mdaemergency.enums.k.onlyVibrate) {
                    imageView3.setImageDrawable(androidx.core.content.a.f(this.f4464f, R.drawable.vibrate));
                    context2 = this.f4464f;
                    imageResId = R.drawable.no_speaker;
                } else {
                    imageView3.setImageDrawable(androidx.core.content.a.f(this.f4464f, byKey4.getImageResId()));
                    context2 = this.f4464f;
                    imageResId = byKey3.getImageResId();
                }
                imageView2.setImageDrawable(androidx.core.content.a.f(context2, imageResId));
                bVar = new f(rowAdapter, i10);
                break;
            default:
                return inflate;
        }
        inflate.setOnClickListener(bVar);
        return inflate;
    }
}
