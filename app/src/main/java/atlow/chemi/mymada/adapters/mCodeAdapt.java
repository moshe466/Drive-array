package atlow.chemi.mymada.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.CompoundButtonCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.classes.mCodeKid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class mCodeAdapt extends ArrayAdapter<mCodeKid> {
    private ArrayList<mCodeKid> arrayList;
    private boolean[] checked;
    private Context mContext;
    private ArrayList<mCodeKid> userKids;

    /* loaded from: classes.dex */
    private static class ViewHolder {
        TextView a;
        TextView b;
        CheckBox c;

        private ViewHolder() {
        }
    }

    public mCodeAdapt(Context context, ArrayList<mCodeKid> arrayList) {
        super(context, R.layout.m_code_row, arrayList);
        this.userKids = null;
        this.mContext = context;
        this.userKids = arrayList;
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(arrayList);
        this.checked = new boolean[this.arrayList.size()];
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        int intValue = ((Integer) compoundButton.getTag()).intValue();
        this.checked[intValue] = z;
        this.arrayList.get(intValue).setChecked(z);
    }

    public void checkItem(String str) {
        Iterator<mCodeKid> it = this.arrayList.iterator();
        while (it.hasNext()) {
            mCodeKid next = it.next();
            if (next.getId().equals(str)) {
                next.setChecked(true);
            }
        }
    }

    @Override // android.widget.ArrayAdapter
    public void clear() {
        Iterator<mCodeKid> it = this.arrayList.iterator();
        while (it.hasNext()) {
            it.next().setChecked(false);
        }
    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.userKids.clear();
        if (lowerCase.length() == 0) {
            this.userKids.addAll(this.arrayList);
        } else {
            Iterator<mCodeKid> it = this.arrayList.iterator();
            while (it.hasNext()) {
                mCodeKid next = it.next();
                String lowerCase2 = next.getName().toLowerCase(Locale.getDefault());
                String lowerCase3 = next.getId().toLowerCase(Locale.getDefault());
                if (lowerCase2.contains(lowerCase) || lowerCase3.contains(lowerCase)) {
                    this.userKids.add(next);
                }
                if (lowerCase.contains("לבבי") && next.getCategory().contains("vasc")) {
                    this.userKids.add(next);
                }
            }
        }
        notifyDataSetChanged();
    }

    public String getChecked() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.arrayList.size(); i++) {
            if (this.checked[i]) {
                sb.append(this.arrayList.get(i).getId());
                sb.append(", ");
            }
        }
        if (sb.length() > 1) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        return sb.toString();
    }

    public String getId(int i) {
        return this.userKids.get(i).getId();
    }

    public String getName(int i) {
        return this.userKids.get(i).getName();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NonNull
    public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        char c;
        ColorStateList colorStateList;
        String str;
        TextView textView;
        int parseColor;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(getContext()).inflate(R.layout.m_code_row, viewGroup, false);
            viewHolder.a = (TextView) view2.findViewById(R.id.mcId);
            viewHolder.c = (CheckBox) view2.findViewById(R.id.mcName);
            viewHolder.b = (TextView) view2.findViewById(R.id.mcSep);
            viewHolder.c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: atlow.chemi.mymada.adapters.a0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    mCodeAdapt.this.a(compoundButton, z);
                }
            });
            view2.setTag(viewHolder);
            view2.setTag(R.id.mcName, viewHolder.c);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        int order = this.userKids.get(i).getOrder();
        viewHolder.a.setText(this.arrayList.get(order).getId());
        viewHolder.c.setText(this.arrayList.get(order).getName());
        viewHolder.b.setText(this.arrayList.get(i).getName());
        viewHolder.c.setTypeface(Typeface.createFromAsset(this.mContext.getAssets(), "fonts/opensanshebrew.ttf"));
        viewHolder.c.setTag(Integer.valueOf(order));
        viewHolder.c.setChecked(this.arrayList.get(order).isChecked());
        String category = this.arrayList.get(order).getCategory();
        switch (category.hashCode()) {
            case -1253042120:
                if (category.equals("gastro")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1184180203:
                if (category.equals("infect")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -865698746:
                if (category.equals("trauma")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2998648:
                if (category.equals("ando")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3002509:
                if (category.equals("area")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3433174:
                if (category.equals("pain")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3441166:
                if (category.equals("pish")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3496912:
                if (category.equals("resp")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3612219:
                if (category.equals("vasc")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 94742677:
                if (category.equals("clali")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 104712283:
                if (category.equals("neuro")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 106964111:
                if (category.equals("pshyc")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                str = "#4bacc6";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#4bacc6"), Color.parseColor("#4bacc6")});
                break;
            case 2:
                str = "#8064a2";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#8064a2"), Color.parseColor("#8064a2")});
                break;
            case 3:
                str = "#c0504d";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#c0504d"), Color.parseColor("#c0504d")});
                break;
            case 4:
                str = "#4f81bd";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#4f81bd"), Color.parseColor("#4f81bd")});
                break;
            case 5:
                str = "#a1a30e";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#a1a30e"), Color.parseColor("#a1a30e")});
                break;
            case 6:
                str = "#d8863a";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#d8863a"), Color.parseColor("#d8863a")});
                break;
            case 7:
                str = "#829ca3";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#829ca3"), Color.parseColor("#829ca3")});
                break;
            case '\b':
                str = "#00b050";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#00b050"), Color.parseColor("#00b050")});
                break;
            case '\t':
                str = "#92d050";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#92d050"), Color.parseColor("#92d050")});
                break;
            case '\n':
                str = "#ba8280";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#ba8280"), Color.parseColor("#ba8280")});
                break;
            case 11:
            default:
                str = "#6b7177";
                colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{android.R.attr.state_checked}}, new int[]{Color.parseColor("#6b7177"), Color.parseColor("#6b7177")});
                break;
        }
        CompoundButtonCompat.setButtonTintList(viewHolder.c, colorStateList);
        textView = viewHolder.b;
        parseColor = Color.parseColor(str);
        textView.setBackgroundColor(parseColor);
        if (this.arrayList.get(order).getId().contains("sep")) {
            viewHolder.c.setVisibility(8);
            viewHolder.b.setVisibility(0);
        } else {
            viewHolder.b.setVisibility(8);
            viewHolder.c.setVisibility(0);
        }
        return view2;
    }
}
