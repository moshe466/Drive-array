package m;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.uh.sf.R;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f1 extends P.c implements View.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    public static final /* synthetic */ int f5649A = 0;

    /* renamed from: k, reason: collision with root package name */
    public final int f5650k;

    /* renamed from: l, reason: collision with root package name */
    public final int f5651l;

    /* renamed from: m, reason: collision with root package name */
    public final LayoutInflater f5652m;

    /* renamed from: n, reason: collision with root package name */
    public final SearchView f5653n;

    /* renamed from: o, reason: collision with root package name */
    public final SearchableInfo f5654o;
    public final Context p;

    /* renamed from: q, reason: collision with root package name */
    public final WeakHashMap f5655q;

    /* renamed from: r, reason: collision with root package name */
    public final int f5656r;

    /* renamed from: s, reason: collision with root package name */
    public int f5657s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f5658t;

    /* renamed from: u, reason: collision with root package name */
    public int f5659u;

    /* renamed from: v, reason: collision with root package name */
    public int f5660v;

    /* renamed from: w, reason: collision with root package name */
    public int f5661w;

    /* renamed from: x, reason: collision with root package name */
    public int f5662x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public int f5663z;

    public f1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f1553b = true;
        this.f1554c = null;
        this.f1552a = false;
        this.f1555d = -1;
        this.f1556e = new P.a(this);
        this.f1557f = new P.b(this, 0);
        this.f5651l = suggestionRowLayout;
        this.f5650k = suggestionRowLayout;
        this.f5652m = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5657s = 1;
        this.f5659u = -1;
        this.f5660v = -1;
        this.f5661w = -1;
        this.f5662x = -1;
        this.y = -1;
        this.f5663z = -1;
        this.f5653n = searchView;
        this.f5654o = searchableInfo;
        this.f5656r = searchView.getSuggestionCommitIconResId();
        this.p = context;
        this.f5655q = weakHashMap;
    }

    public static String h(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e4);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011a  */
    @Override // P.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f1.a(android.view.View, android.database.Cursor):void");
    }

    @Override // P.c
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f5659u = cursor.getColumnIndex("suggest_text_1");
                this.f5660v = cursor.getColumnIndex("suggest_text_2");
                this.f5661w = cursor.getColumnIndex("suggest_text_2_url");
                this.f5662x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.f5663z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e4);
        }
    }

    @Override // P.c
    public final String c(Cursor cursor) {
        String h2;
        String h3;
        if (cursor != null) {
            String h4 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
            if (h4 != null) {
                return h4;
            }
            SearchableInfo searchableInfo = this.f5654o;
            if (searchableInfo.shouldRewriteQueryFromData() && (h3 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
                return h3;
            }
            if (searchableInfo.shouldRewriteQueryFromText() && (h2 = h(cursor, cursor.getColumnIndex("suggest_text_1"))) != null) {
                return h2;
            }
            return null;
        }
        return null;
    }

    @Override // P.c
    public final View d(ViewGroup viewGroup) {
        View inflate = this.f5652m.inflate(this.f5650k, viewGroup, false);
        inflate.setTag(new e1(inflate));
        ((ImageView) inflate.findViewById(R.id.edit_query)).setImageResource(this.f5656r);
        return inflate;
    }

    public final Drawable e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.p.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable f(java.lang.String r11) {
        /*
            r10 = this;
            java.util.WeakHashMap r0 = r10.f5655q
            android.content.Context r1 = r10.p
            java.lang.String r2 = "android.resource://"
            r3 = 0
            if (r11 == 0) goto Lf1
            boolean r4 = r11.isEmpty()
            if (r4 != 0) goto Lf1
            java.lang.String r4 = "0"
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L19
            goto Lf1
        L19:
            int r4 = java.lang.Integer.parseInt(r11)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            r5.<init>(r2)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            java.lang.String r2 = r1.getPackageName()     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            r5.append(r2)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            java.lang.String r2 = "/"
            r5.append(r2)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            r5.append(r4)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            java.lang.String r2 = r5.toString()     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            java.lang.Object r5 = r0.get(r2)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            android.graphics.drawable.Drawable$ConstantState r5 = (android.graphics.drawable.Drawable.ConstantState) r5     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            if (r5 != 0) goto L3f
            r5 = r3
            goto L43
        L3f:
            android.graphics.drawable.Drawable r5 = r5.newDrawable()     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
        L43:
            if (r5 == 0) goto L46
            return r5
        L46:
            android.graphics.drawable.Drawable r4 = r1.getDrawable(r4)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            if (r4 == 0) goto L53
            android.graphics.drawable.Drawable$ConstantState r5 = r4.getConstantState()     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
            r0.put(r2, r5)     // Catch: java.lang.NumberFormatException -> L54 android.content.res.Resources.NotFoundException -> Lf1
        L53:
            return r4
        L54:
            java.lang.Object r2 = r0.get(r11)
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2
            if (r2 != 0) goto L5e
            r2 = r3
            goto L62
        L5e:
            android.graphics.drawable.Drawable r2 = r2.newDrawable()
        L62:
            if (r2 == 0) goto L65
            return r2
        L65:
            android.net.Uri r2 = android.net.Uri.parse(r11)
            java.lang.String r4 = "SuggestionsAdapter"
            java.lang.String r5 = "Error closing icon stream for "
            java.lang.String r6 = "Failed to open "
            java.lang.String r7 = "Resource does not exist: "
            java.lang.String r8 = r2.getScheme()     // Catch: java.io.FileNotFoundException -> L82
            java.lang.String r9 = "android.resource"
            boolean r8 = r9.equals(r8)     // Catch: java.io.FileNotFoundException -> L82
            if (r8 == 0) goto L96
            android.graphics.drawable.Drawable r3 = r10.e(r2)     // Catch: java.io.FileNotFoundException -> L82 android.content.res.Resources.NotFoundException -> L84
            goto Le8
        L82:
            r1 = move-exception
            goto Le2
        L84:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch: java.io.FileNotFoundException -> L82
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L82
            r4.<init>(r7)     // Catch: java.io.FileNotFoundException -> L82
            r4.append(r2)     // Catch: java.io.FileNotFoundException -> L82
            java.lang.String r4 = r4.toString()     // Catch: java.io.FileNotFoundException -> L82
            r1.<init>(r4)     // Catch: java.io.FileNotFoundException -> L82
            throw r1     // Catch: java.io.FileNotFoundException -> L82
        L96:
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.io.FileNotFoundException -> L82
            java.io.InputStream r1 = r1.openInputStream(r2)     // Catch: java.io.FileNotFoundException -> L82
            if (r1 == 0) goto Ld0
            android.graphics.drawable.Drawable r6 = android.graphics.drawable.Drawable.createFromStream(r1, r3)     // Catch: java.lang.Throwable -> Lba
            r1.close()     // Catch: java.io.IOException -> La9
        La7:
            r3 = r6
            goto Le8
        La9:
            r1 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L82
            r7.<init>(r5)     // Catch: java.io.FileNotFoundException -> L82
            r7.append(r2)     // Catch: java.io.FileNotFoundException -> L82
            java.lang.String r5 = r7.toString()     // Catch: java.io.FileNotFoundException -> L82
            android.util.Log.e(r4, r5, r1)     // Catch: java.io.FileNotFoundException -> L82
            goto La7
        Lba:
            r6 = move-exception
            r1.close()     // Catch: java.io.IOException -> Lbf
            goto Lcf
        Lbf:
            r1 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L82
            r7.<init>(r5)     // Catch: java.io.FileNotFoundException -> L82
            r7.append(r2)     // Catch: java.io.FileNotFoundException -> L82
            java.lang.String r5 = r7.toString()     // Catch: java.io.FileNotFoundException -> L82
            android.util.Log.e(r4, r5, r1)     // Catch: java.io.FileNotFoundException -> L82
        Lcf:
            throw r6     // Catch: java.io.FileNotFoundException -> L82
        Ld0:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch: java.io.FileNotFoundException -> L82
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L82
            r4.<init>(r6)     // Catch: java.io.FileNotFoundException -> L82
            r4.append(r2)     // Catch: java.io.FileNotFoundException -> L82
            java.lang.String r4 = r4.toString()     // Catch: java.io.FileNotFoundException -> L82
            r1.<init>(r4)     // Catch: java.io.FileNotFoundException -> L82
            throw r1     // Catch: java.io.FileNotFoundException -> L82
        Le2:
            java.util.Objects.toString(r2)
            r1.getMessage()
        Le8:
            if (r3 == 0) goto Lf1
            android.graphics.drawable.Drawable$ConstantState r1 = r3.getConstantState()
            r0.put(r11, r1)
        Lf1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f1.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
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
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.p.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // P.c, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e4) {
            View inflate = this.f5652m.inflate(this.f5651l, viewGroup, false);
            if (inflate != null) {
                ((e1) inflate.getTag()).f5643a.setText(e4.toString());
            }
            return inflate;
        }
    }

    @Override // P.c, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e4) {
            View d2 = d(viewGroup);
            ((e1) d2.getTag()).f5643a.setText(e4.toString());
            return d2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = this.f1554c;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f1554c;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f5653n.o((CharSequence) tag);
        }
    }
}
