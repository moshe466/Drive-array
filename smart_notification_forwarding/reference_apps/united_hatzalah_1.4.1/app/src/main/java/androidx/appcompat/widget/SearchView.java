package androidx.appcompat.widget;

import F0.C0110z2;
import F0.b3;
import J.S;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.uh.sf.R;
import g.AbstractC0424a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k.InterfaceC0459c;
import m.B0;
import m.C0;
import m.C0556m;
import m.M;
import m.U0;
import m.V0;
import m.W0;
import m.X0;
import m.Y0;
import m.Z0;
import m.a1;
import m.b1;
import m.c1;
import m.d1;
import m.f1;
import p3.h;

/* loaded from: classes.dex */
public class SearchView extends B0 implements InterfaceC0459c {

    /* renamed from: j0, reason: collision with root package name */
    public static final C0110z2 f2876j0;

    /* renamed from: A, reason: collision with root package name */
    public final View f2877A;

    /* renamed from: B, reason: collision with root package name */
    public d1 f2878B;

    /* renamed from: C, reason: collision with root package name */
    public final Rect f2879C;

    /* renamed from: D, reason: collision with root package name */
    public final Rect f2880D;

    /* renamed from: E, reason: collision with root package name */
    public final int[] f2881E;

    /* renamed from: F, reason: collision with root package name */
    public final int[] f2882F;

    /* renamed from: G, reason: collision with root package name */
    public final ImageView f2883G;

    /* renamed from: H, reason: collision with root package name */
    public final Drawable f2884H;

    /* renamed from: I, reason: collision with root package name */
    public final int f2885I;

    /* renamed from: J, reason: collision with root package name */
    public final int f2886J;

    /* renamed from: K, reason: collision with root package name */
    public final Intent f2887K;

    /* renamed from: L, reason: collision with root package name */
    public final Intent f2888L;

    /* renamed from: M, reason: collision with root package name */
    public final CharSequence f2889M;

    /* renamed from: N, reason: collision with root package name */
    public View.OnFocusChangeListener f2890N;

    /* renamed from: O, reason: collision with root package name */
    public View.OnClickListener f2891O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f2892P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f2893Q;

    /* renamed from: R, reason: collision with root package name */
    public P.c f2894R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f2895S;

    /* renamed from: T, reason: collision with root package name */
    public CharSequence f2896T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f2897U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f2898V;

    /* renamed from: W, reason: collision with root package name */
    public int f2899W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f2900a0;

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f2901b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2902c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f2903d0;

    /* renamed from: e0, reason: collision with root package name */
    public SearchableInfo f2904e0;

    /* renamed from: f0, reason: collision with root package name */
    public Bundle f2905f0;

    /* renamed from: g0, reason: collision with root package name */
    public final V0 f2906g0;

    /* renamed from: h0, reason: collision with root package name */
    public final V0 f2907h0;

    /* renamed from: i0, reason: collision with root package name */
    public final WeakHashMap f2908i0;

    /* renamed from: s, reason: collision with root package name */
    public final SearchAutoComplete f2909s;

    /* renamed from: t, reason: collision with root package name */
    public final View f2910t;

    /* renamed from: u, reason: collision with root package name */
    public final View f2911u;

    /* renamed from: v, reason: collision with root package name */
    public final View f2912v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f2913w;

    /* renamed from: x, reason: collision with root package name */
    public final ImageView f2914x;
    public final ImageView y;

    /* renamed from: z, reason: collision with root package name */
    public final ImageView f2915z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends C0556m {

        /* renamed from: e, reason: collision with root package name */
        public int f2916e;

        /* renamed from: f, reason: collision with root package name */
        public SearchView f2917f;

        /* renamed from: j, reason: collision with root package name */
        public boolean f2918j;

        /* renamed from: k, reason: collision with root package name */
        public final d f2919k;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2919k = new d(this);
            this.f2916e = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return UserVerificationMethods.USER_VERIFY_HANDPRINT;
            }
            if (i < 600) {
                if (i < 640 || i3 < 480) {
                    return 160;
                }
                return 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            C0110z2 c0110z2 = SearchView.f2876j0;
            c0110z2.getClass();
            C0110z2.s();
            Method method = (Method) c0110z2.f731d;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            if (this.f2916e > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        @Override // m.C0556m, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2918j) {
                d dVar = this.f2919k;
                removeCallbacks(dVar);
                post(dVar);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z3, int i, Rect rect) {
            super.onFocusChanged(z3, i, rect);
            SearchView searchView = this.f2917f;
            searchView.v(searchView.f2893Q);
            searchView.post(searchView.f2906g0);
            if (searchView.f2909s.hasFocus()) {
                searchView.k();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2917f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z3) {
            super.onWindowFocusChanged(z3);
            if (z3 && this.f2917f.hasFocus() && getVisibility() == 0) {
                this.f2918j = true;
                Context context = getContext();
                C0110z2 c0110z2 = SearchView.f2876j0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z3) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.f2919k;
            if (!z3) {
                this.f2918j = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f2918j = false;
                    removeCallbacks(dVar);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f2918j = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f2917f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f2916e = i;
        }
    }

    static {
        C0110z2 c0110z2 = null;
        if (Build.VERSION.SDK_INT < 29) {
            C0110z2 c0110z22 = new C0110z2(11);
            c0110z22.f729b = null;
            c0110z22.f730c = null;
            c0110z22.f731d = null;
            C0110z2.s();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                c0110z22.f729b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                c0110z22.f730c = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                c0110z22.f731d = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            c0110z2 = c0110z22;
        }
        f2876j0 = c0110z2;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        int length;
        SearchAutoComplete searchAutoComplete = this.f2909s;
        searchAutoComplete.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        searchAutoComplete.setSelection(length);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f2898V = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f2909s;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f2898V = false;
    }

    public int getImeOptions() {
        return this.f2909s.getImeOptions();
    }

    public int getInputType() {
        return this.f2909s.getInputType();
    }

    public int getMaxWidth() {
        return this.f2899W;
    }

    public CharSequence getQuery() {
        return this.f2909s.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f2896T;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f2904e0;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.f2904e0.getHintId());
        }
        return this.f2889M;
    }

    public int getSuggestionCommitIconResId() {
        return this.f2886J;
    }

    public int getSuggestionRowLayout() {
        return this.f2885I;
    }

    public P.c getSuggestionsAdapter() {
        return this.f2894R;
    }

    public final Intent i(Uri uri, String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2901b0);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2905f0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f2904e0.getSearchActivity());
        return intent;
    }

    public final Intent j(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2905f0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        } else {
            i = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void k() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f2909s;
        if (i >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        C0110z2 c0110z2 = f2876j0;
        c0110z2.getClass();
        C0110z2.s();
        Method method = (Method) c0110z2.f729b;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        c0110z2.getClass();
        C0110z2.s();
        Method method2 = (Method) c0110z2.f730c;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void l() {
        SearchAutoComplete searchAutoComplete = this.f2909s;
        if (TextUtils.isEmpty(searchAutoComplete.getText())) {
            if (this.f2892P) {
                clearFocus();
                v(true);
                return;
            }
            return;
        }
        searchAutoComplete.setText("");
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
    }

    public final void m(int i) {
        Uri parse;
        String h2;
        Cursor cursor = this.f2894R.f1554c;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent intent = null;
            try {
                try {
                    int i3 = f1.f5649A;
                    String h3 = f1.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                    if (h3 == null) {
                        h3 = this.f2904e0.getSuggestIntentAction();
                    }
                    if (h3 == null) {
                        h3 = "android.intent.action.SEARCH";
                    }
                    String h4 = f1.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                    if (h4 == null) {
                        h4 = this.f2904e0.getSuggestIntentData();
                    }
                    if (h4 != null && (h2 = f1.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                        h4 = h4 + RemoteSettings.FORWARD_SLASH_STRING + Uri.encode(h2);
                    }
                    if (h4 == null) {
                        parse = null;
                    } else {
                        parse = Uri.parse(h4);
                    }
                    intent = i(parse, h3, f1.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), f1.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
                } catch (RuntimeException unused) {
                }
            } catch (RuntimeException unused2) {
                cursor.getPosition();
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e4) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e4);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f2909s;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void n(int i) {
        Editable text = this.f2909s.getText();
        Cursor cursor = this.f2894R.f1554c;
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                String c4 = this.f2894R.c(cursor);
                if (c4 != null) {
                    setQuery(c4);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    public final void o(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // k.InterfaceC0459c
    public final void onActionViewCollapsed() {
        SearchAutoComplete searchAutoComplete = this.f2909s;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f2901b0 = "";
        clearFocus();
        v(true);
        searchAutoComplete.setImeOptions(this.f2903d0);
        this.f2902c0 = false;
    }

    @Override // k.InterfaceC0459c
    public final void onActionViewExpanded() {
        if (this.f2902c0) {
            return;
        }
        this.f2902c0 = true;
        SearchAutoComplete searchAutoComplete = this.f2909s;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f2903d0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f2906g0);
        post(this.f2907h0);
        super.onDetachedFromWindow();
    }

    @Override // m.B0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        super.onLayout(z3, i, i3, i4, i5);
        if (z3) {
            SearchAutoComplete searchAutoComplete = this.f2909s;
            int[] iArr = this.f2881E;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f2882F;
            getLocationInWindow(iArr2);
            int i6 = iArr[1] - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i7;
            int height = searchAutoComplete.getHeight() + i6;
            Rect rect = this.f2879C;
            rect.set(i7, i6, width, height);
            int i8 = rect.left;
            int i9 = rect.right;
            int i10 = i5 - i3;
            Rect rect2 = this.f2880D;
            rect2.set(i8, 0, i9, i10);
            d1 d1Var = this.f2878B;
            if (d1Var == null) {
                d1 d1Var2 = new d1(rect2, rect, searchAutoComplete);
                this.f2878B = d1Var2;
                setTouchDelegate(d1Var2);
            } else {
                d1Var.f5636b.set(rect2);
                Rect rect3 = d1Var.f5638d;
                rect3.set(rect2);
                int i11 = -d1Var.f5639e;
                rect3.inset(i11, i11);
                d1Var.f5637c.set(rect);
            }
        }
    }

    @Override // m.B0, android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        if (this.f2893Q) {
            super.onMeasure(i, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (i4 = this.f2899W) > 0) {
                    size = Math.min(i4, size);
                }
            } else {
                size = this.f2899W;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int i5 = this.f2899W;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
        } else {
            size2 = Math.min(getPreferredHeight(), size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c1 c1Var = (c1) parcelable;
        super.onRestoreInstanceState(c1Var.f1721a);
        v(c1Var.f5634c);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, Q.c, m.c1] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? cVar = new Q.c(super.onSaveInstanceState());
        cVar.f5634c = this.f2893Q;
        return cVar;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        post(this.f2906g0);
    }

    public final void p() {
        SearchAutoComplete searchAutoComplete = this.f2909s;
        Editable text = searchAutoComplete.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f2904e0 != null) {
                getContext().startActivity(i(null, "android.intent.action.SEARCH", null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    public final void q() {
        int i;
        int[] iArr;
        boolean isEmpty = TextUtils.isEmpty(this.f2909s.getText());
        if (isEmpty && (!this.f2892P || this.f2902c0)) {
            i = 8;
        } else {
            i = 0;
        }
        ImageView imageView = this.y;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            if (!isEmpty) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    public final void r() {
        int[] iArr;
        if (this.f2909s.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f2911u.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2912v.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (this.f2898V || !isFocusable()) {
            return false;
        }
        if (!this.f2893Q) {
            boolean requestFocus = this.f2909s.requestFocus(i, rect);
            if (requestFocus) {
                v(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i, rect);
    }

    public final void s() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z3 = this.f2892P;
        SearchAutoComplete searchAutoComplete = this.f2909s;
        if (z3 && (drawable = this.f2884H) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2905f0 = bundle;
    }

    public void setIconified(boolean z3) {
        if (z3) {
            l();
            return;
        }
        v(false);
        SearchAutoComplete searchAutoComplete = this.f2909s;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f2891O;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z3) {
        if (this.f2892P == z3) {
            return;
        }
        this.f2892P = z3;
        v(z3);
        s();
    }

    public void setImeOptions(int i) {
        this.f2909s.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f2909s.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f2899W = i;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f2890N = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f2891O = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2896T = charSequence;
        s();
    }

    public void setQueryRefinementEnabled(boolean z3) {
        int i;
        this.f2897U = z3;
        P.c cVar = this.f2894R;
        if (cVar instanceof f1) {
            f1 f1Var = (f1) cVar;
            if (z3) {
                i = 2;
            } else {
                i = 1;
            }
            f1Var.f5657s = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        if (getContext().getPackageManager().resolveActivity(r0, 65536) != null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f2904e0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.f2909s
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f2904e0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f2904e0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f2904e0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            P.c r7 = r6.f2894R
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f2904e0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            m.f1 r7 = new m.f1
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f2904e0
            java.util.WeakHashMap r5 = r6.f2908i0
            r7.<init>(r3, r6, r4, r5)
            r6.f2894R = r7
            r2.setAdapter(r7)
            P.c r7 = r6.f2894R
            m.f1 r7 = (m.f1) r7
            boolean r3 = r6.f2897U
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.f5657s = r3
        L62:
            r6.s()
        L65:
            android.app.SearchableInfo r7 = r6.f2904e0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f2904e0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.f2887K
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f2904e0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.f2888L
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = r3
        L99:
            r6.f2900a0 = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.f2893Q
            r6.v(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z3) {
        this.f2895S = z3;
        v(this.f2893Q);
    }

    public void setSuggestionsAdapter(P.c cVar) {
        this.f2894R = cVar;
        this.f2909s.setAdapter(cVar);
    }

    public final void t() {
        int i;
        if ((this.f2895S || this.f2900a0) && !this.f2893Q && (this.f2914x.getVisibility() == 0 || this.f2915z.getVisibility() == 0)) {
            i = 0;
        } else {
            i = 8;
        }
        this.f2912v.setVisibility(i);
    }

    public final void u(boolean z3) {
        int i;
        boolean z4 = this.f2895S;
        if (z4 && ((z4 || this.f2900a0) && !this.f2893Q && hasFocus() && (z3 || !this.f2900a0))) {
            i = 0;
        } else {
            i = 8;
        }
        this.f2914x.setVisibility(i);
    }

    public final void v(boolean z3) {
        int i;
        int i3;
        int i4;
        this.f2893Q = z3;
        int i5 = 8;
        if (z3) {
            i = 0;
        } else {
            i = 8;
        }
        boolean isEmpty = TextUtils.isEmpty(this.f2909s.getText());
        this.f2913w.setVisibility(i);
        u(!isEmpty);
        if (z3) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        this.f2910t.setVisibility(i3);
        ImageView imageView = this.f2883G;
        if (imageView.getDrawable() != null && !this.f2892P) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        q();
        if (this.f2900a0 && !this.f2893Q && isEmpty) {
            this.f2914x.setVisibility(8);
            i5 = 0;
        }
        this.f2915z.setVisibility(i5);
        t();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2879C = new Rect();
        this.f2880D = new Rect();
        this.f2881E = new int[2];
        this.f2882F = new int[2];
        this.f2906g0 = new V0(this, 0);
        this.f2907h0 = new V0(this, 1);
        this.f2908i0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        Y0 y02 = new Y0(this);
        M m4 = new M(this, 1);
        C0 c02 = new C0(this, 1);
        U0 u02 = new U0(this);
        int[] iArr = AbstractC0424a.f4645u;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        b3 b3Var = new b3(context, obtainStyledAttributes);
        S.h(this, context, iArr, attributeSet, obtainStyledAttributes, i);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f2909s = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f2910t = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.f2911u = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.f2912v = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f2913w = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f2914x = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.y = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f2915z = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f2883G = imageView5;
        findViewById.setBackground(b3Var.o(10));
        findViewById2.setBackground(b3Var.o(14));
        imageView.setImageDrawable(b3Var.o(13));
        imageView2.setImageDrawable(b3Var.o(7));
        imageView3.setImageDrawable(b3Var.o(4));
        imageView4.setImageDrawable(b3Var.o(16));
        imageView5.setImageDrawable(b3Var.o(13));
        this.f2884H = b3Var.o(12);
        h.D(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f2885I = obtainStyledAttributes.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.f2886J = obtainStyledAttributes.getResourceId(5, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(u02);
        searchAutoComplete.setOnEditorActionListener(y02);
        searchAutoComplete.setOnItemClickListener(m4);
        searchAutoComplete.setOnItemSelectedListener(c02);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new W0(this));
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(8, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f2889M = obtainStyledAttributes.getText(6);
        this.f2896T = obtainStyledAttributes.getText(11);
        int i3 = obtainStyledAttributes.getInt(3, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = obtainStyledAttributes.getInt(2, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(obtainStyledAttributes.getBoolean(0, true));
        b3Var.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f2887K = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f2888L = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2877A = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new X0(this));
        }
        v(this.f2892P);
        s();
    }

    public void setOnCloseListener(Z0 z02) {
    }

    public void setOnQueryTextListener(a1 a1Var) {
    }

    public void setOnSuggestionListener(b1 b1Var) {
    }
}
