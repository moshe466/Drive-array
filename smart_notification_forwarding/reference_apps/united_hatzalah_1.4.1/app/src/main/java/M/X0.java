package m;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.uh.sf.R;

/* loaded from: classes.dex */
public final class X0 implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f5609a;

    public X0(SearchView searchView) {
        this.f5609a = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        SearchView searchView = this.f5609a;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f2909s;
        View view2 = searchView.f2877A;
        if (view2.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.f2911u.getPaddingLeft();
            Rect rect = new Rect();
            boolean a2 = z1.a(searchView);
            if (searchView.f2892P) {
                i10 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                i10 = 0;
            }
            searchAutoComplete.getDropDownBackground().getPadding(rect);
            if (a2) {
                i11 = -rect.left;
            } else {
                i11 = paddingLeft - (rect.left + i10);
            }
            searchAutoComplete.setDropDownHorizontalOffset(i11);
            searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + i10) - paddingLeft);
        }
    }
}
