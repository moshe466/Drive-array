package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class b implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f3012a;

    public b(SearchView searchView) {
        this.f3012a = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        int length;
        SearchView searchView = this.f3012a;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f2909s;
        if (searchView.f2904e0 != null) {
            if (searchAutoComplete.isPopupShowing() && searchAutoComplete.getListSelection() != -1) {
                if (searchView.f2904e0 != null && searchView.f2894R != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                    if (i != 66 && i != 84 && i != 61) {
                        if (i != 21 && i != 22) {
                            if (i == 19) {
                                searchAutoComplete.getListSelection();
                                return false;
                            }
                        } else {
                            if (i == 21) {
                                length = 0;
                            } else {
                                length = searchAutoComplete.length();
                            }
                            searchAutoComplete.setSelection(length);
                            searchAutoComplete.setListSelection(0);
                            searchAutoComplete.clearListSelection();
                            searchAutoComplete.a();
                            return true;
                        }
                    } else {
                        searchView.m(searchAutoComplete.getListSelection());
                        return true;
                    }
                }
            } else if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) != 0 && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i == 66) {
                view.cancelLongPress();
                searchView.getContext().startActivity(searchView.i(null, "android.intent.action.SEARCH", null, searchAutoComplete.getText().toString()));
                return true;
            }
        }
        return false;
    }
}
