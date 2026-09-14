package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class s0 extends x.c implements View.OnClickListener {
    private int A;
    private int B;
    private int C;
    private int D;

    /* renamed from: q, reason: collision with root package name */
    private final SearchView f1502q;

    /* renamed from: r, reason: collision with root package name */
    private final SearchableInfo f1503r;

    /* renamed from: s, reason: collision with root package name */
    private final Context f1504s;

    /* renamed from: t, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1505t;

    /* renamed from: u, reason: collision with root package name */
    private final int f1506u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1507v;

    /* renamed from: w, reason: collision with root package name */
    private int f1508w;

    /* renamed from: x, reason: collision with root package name */
    private ColorStateList f1509x;

    /* renamed from: y, reason: collision with root package name */
    private int f1510y;

    /* renamed from: z, reason: collision with root package name */
    private int f1511z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f1512a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f1513b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f1514c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f1515d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f1516e;

        public a(View view) {
            this.f1512a = (TextView) view.findViewById(R.id.text1);
            this.f1513b = (TextView) view.findViewById(R.id.text2);
            this.f1514c = (ImageView) view.findViewById(R.id.icon1);
            this.f1515d = (ImageView) view.findViewById(R.id.icon2);
            this.f1516e = (ImageView) view.findViewById(e.f.f8946q);
        }
    }

    public s0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1507v = false;
        this.f1508w = 1;
        this.f1510y = -1;
        this.f1511z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.f1502q = searchView;
        this.f1503r = searchableInfo;
        this.f1506u = searchView.getSuggestionCommitIconResId();
        this.f1504s = context;
        this.f1505t = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1505t.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.f1505t.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f1509x == null) {
            TypedValue typedValue = new TypedValue();
            this.f1504s.getTheme().resolveAttribute(e.a.K, typedValue, true);
            this.f1509x = this.f1504s.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1509x, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f1504s.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid icon resource ");
            sb2.append(iconResource);
            sb2.append(" for ");
            sb2.append(componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.toString();
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.f1505t.containsKey(flattenToShortString)) {
            Drawable m10 = m(componentName);
            this.f1505t.put(flattenToShortString, m10 != null ? m10.getConstantState() : null);
            return m10;
        }
        Drawable.ConstantState constantState = this.f1505t.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f1504s.getResources());
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable n10 = n(this.f1503r.getSearchActivity());
        return n10 != null ? n10 : this.f1504s.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f1504s.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error closing icon stream for ");
                    sb2.append(uri);
                }
            }
        } catch (FileNotFoundException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Icon not found: ");
            sb3.append(uri);
            sb3.append(", ");
            sb3.append(e10.getMessage());
            return null;
        }
        StringBuilder sb32 = new StringBuilder();
        sb32.append("Icon not found: ");
        sb32.append(uri);
        sb32.append(", ");
        sb32.append(e10.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1504s.getPackageName() + "/" + parseInt;
            Drawable k10 = k(str2);
            if (k10 != null) {
                return k10;
            }
            Drawable f10 = androidx.core.content.a.f(this.f1504s, parseInt);
            A(str2, f10);
            return f10;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Icon resource not found: ");
            sb2.append(str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k11 = k(str);
            if (k11 != null) {
                return k11;
            }
            Drawable q10 = q(Uri.parse(str));
            A(str, q10);
            return q10;
        }
    }

    private Drawable t(Cursor cursor) {
        int i10 = this.B;
        if (i10 == -1) {
            return null;
        }
        Drawable s10 = s(cursor.getString(i10));
        return s10 != null ? s10 : p();
    }

    private Drawable u(Cursor cursor) {
        int i10 = this.C;
        if (i10 == -1) {
            return null;
        }
        return s(cursor.getString(i10));
    }

    private static String w(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception unused) {
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @Override // x.a, x.b.a
    public void a(Cursor cursor) {
        if (this.f1507v) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f1510y = cursor.getColumnIndex("suggest_text_1");
                this.f1511z = cursor.getColumnIndex("suggest_text_2");
                this.A = cursor.getColumnIndex("suggest_text_2_url");
                this.B = cursor.getColumnIndex("suggest_icon_1");
                this.C = cursor.getColumnIndex("suggest_icon_2");
                this.D = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception unused) {
        }
    }

    @Override // x.a, x.b.a
    public CharSequence c(Cursor cursor) {
        String o10;
        String o11;
        if (cursor == null) {
            return null;
        }
        String o12 = o(cursor, "suggest_intent_query");
        if (o12 != null) {
            return o12;
        }
        if (this.f1503r.shouldRewriteQueryFromData() && (o11 = o(cursor, "suggest_intent_data")) != null) {
            return o11;
        }
        if (!this.f1503r.shouldRewriteQueryFromText() || (o10 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o10;
    }

    @Override // x.b.a
    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1502q.getVisibility() == 0 && this.f1502q.getWindowVisibility() == 0) {
            try {
                Cursor v10 = v(this.f1503r, charSequence2, 50);
                if (v10 != null) {
                    v10.getCount();
                    return v10;
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    @Override // x.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i10 = this.D;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        if (aVar.f1512a != null) {
            z(aVar.f1512a, w(cursor, this.f1510y));
        }
        if (aVar.f1513b != null) {
            String w10 = w(cursor, this.A);
            CharSequence l10 = w10 != null ? l(w10) : w(cursor, this.f1511z);
            if (TextUtils.isEmpty(l10)) {
                TextView textView = aVar.f1512a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1512a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1512a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1512a.setMaxLines(1);
                }
            }
            z(aVar.f1513b, l10);
        }
        ImageView imageView = aVar.f1514c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1515d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i12 = this.f1508w;
        if (i12 != 2 && (i12 != 1 || (i11 & 1) == 0)) {
            aVar.f1516e.setVisibility(8);
            return;
        }
        aVar.f1516e.setVisibility(0);
        aVar.f1516e.setTag(aVar.f1512a.getText());
        aVar.f1516e.setOnClickListener(this);
    }

    @Override // x.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View g10 = g(this.f1504s, b(), viewGroup);
            if (g10 != null) {
                ((a) g10.getTag()).f1512a.setText(e10.toString());
            }
            return g10;
        }
    }

    @Override // x.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View h10 = h(this.f1504s, b(), viewGroup);
            if (h10 != null) {
                ((a) h10.getTag()).f1512a.setText(e10.toString());
            }
            return h10;
        }
    }

    @Override // x.c, x.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h10 = super.h(context, cursor, viewGroup);
        h10.setTag(new a(h10));
        ((ImageView) h10.findViewById(e.f.f8946q)).setImageResource(this.f1506u);
        return h10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1502q.U((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f1504s.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f1504s.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i10) {
        this.f1508w = i10;
    }
}
