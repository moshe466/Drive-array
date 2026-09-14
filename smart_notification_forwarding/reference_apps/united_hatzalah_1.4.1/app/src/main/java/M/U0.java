package m;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class U0 implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f5605a;

    public U0(SearchView searchView) {
        this.f5605a = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        SearchView searchView = this.f5605a;
        Editable text = searchView.f2909s.getText();
        searchView.f2901b0 = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        searchView.u(!isEmpty);
        int i5 = 8;
        if (searchView.f2900a0 && !searchView.f2893Q && isEmpty) {
            searchView.f2914x.setVisibility(8);
            i5 = 0;
        }
        searchView.f2915z.setVisibility(i5);
        searchView.q();
        searchView.t();
        charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i4) {
    }
}
