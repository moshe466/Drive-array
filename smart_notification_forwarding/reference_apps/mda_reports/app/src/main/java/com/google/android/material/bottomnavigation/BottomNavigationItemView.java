package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public static final int INVALID_ITEM_POSITION = -1;
    private final int defaultMargin;
    private ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private MenuItemImpl itemData;
    private int itemPosition;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;

    public BottomNavigationItemView(@NonNull Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itemPosition = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(com.google.android.material.R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(com.google.android.material.R.id.icon);
        this.smallLabel = (TextView) findViewById(com.google.android.material.R.id.smallLabel);
        this.largeLabel = (TextView) findViewById(com.google.android.material.R.id.largeLabel);
        ViewCompat.setImportantForAccessibility(this.smallLabel, 2);
        ViewCompat.setImportantForAccessibility(this.largeLabel, 2);
        setFocusable(true);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    private void calculateTextScaleFactors(float f, float f2) {
        this.shiftAmount = f - f2;
        this.scaleUpFactor = (f2 * 1.0f) / f;
        this.scaleDownFactor = (f * 1.0f) / f2;
    }

    private void setViewLayoutParams(@NonNull View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void setViewValues(@NonNull View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:
    
        if (r10 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0059, code lost:
    
        setViewLayoutParams(r9.icon, (int) (r9.defaultMargin + r9.shiftAmount), 49);
        setViewValues(r9.largeLabel, 1.0f, 1.0f, 0);
        r0 = r9.smallLabel;
        r1 = r9.scaleUpFactor;
        setViewValues(r0, r1, r1, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0072, code lost:
    
        setViewLayoutParams(r9.icon, r9.defaultMargin, 49);
        r0 = r9.largeLabel;
        r1 = r9.scaleDownFactor;
        setViewValues(r0, r1, r1, 4);
        setViewValues(r9.smallLabel, 1.0f, 1.0f, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008a, code lost:
    
        if (r10 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008c, code lost:
    
        setViewLayoutParams(r0, r1, 49);
        setViewValues(r9.largeLabel, 1.0f, 1.0f, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009d, code lost:
    
        r9.smallLabel.setVisibility(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
    
        setViewLayoutParams(r0, r1, 17);
        setViewValues(r9.largeLabel, 0.5f, 0.5f, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
    
        if (r10 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ae, code lost:
    
        if (r10 != false) goto L11;
     */
    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setChecked(boolean r10) {
        /*
            r9 = this;
            android.widget.TextView r0 = r9.largeLabel
            int r1 = r0.getWidth()
            r2 = 2
            int r1 = r1 / r2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r9.largeLabel
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            android.widget.TextView r0 = r9.smallLabel
            int r1 = r0.getWidth()
            int r1 = r1 / r2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r9.smallLabel
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            int r0 = r9.labelVisibilityMode
            r1 = -1
            r3 = 17
            r4 = 1056964608(0x3f000000, float:0.5)
            r5 = 0
            r6 = 49
            r7 = 4
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r0 == r1) goto La3
            if (r0 == 0) goto L86
            r1 = 1
            if (r0 == r1) goto L57
            if (r0 == r2) goto L43
            goto Lb1
        L43:
            android.widget.ImageView r0 = r9.icon
            int r1 = r9.defaultMargin
            r9.setViewLayoutParams(r0, r1, r3)
            android.widget.TextView r0 = r9.largeLabel
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r9.smallLabel
            r0.setVisibility(r1)
            goto Lb1
        L57:
            if (r10 == 0) goto L72
        L59:
            android.widget.ImageView r0 = r9.icon
            int r1 = r9.defaultMargin
            float r1 = (float) r1
            float r2 = r9.shiftAmount
            float r1 = r1 + r2
            int r1 = (int) r1
            r9.setViewLayoutParams(r0, r1, r6)
            android.widget.TextView r0 = r9.largeLabel
            r9.setViewValues(r0, r8, r8, r5)
            android.widget.TextView r0 = r9.smallLabel
            float r1 = r9.scaleUpFactor
            r9.setViewValues(r0, r1, r1, r7)
            goto Lb1
        L72:
            android.widget.ImageView r0 = r9.icon
            int r1 = r9.defaultMargin
            r9.setViewLayoutParams(r0, r1, r6)
            android.widget.TextView r0 = r9.largeLabel
            float r1 = r9.scaleDownFactor
            r9.setViewValues(r0, r1, r1, r7)
            android.widget.TextView r0 = r9.smallLabel
            r9.setViewValues(r0, r8, r8, r5)
            goto Lb1
        L86:
            android.widget.ImageView r0 = r9.icon
            int r1 = r9.defaultMargin
            if (r10 == 0) goto L95
        L8c:
            r9.setViewLayoutParams(r0, r1, r6)
            android.widget.TextView r0 = r9.largeLabel
            r9.setViewValues(r0, r8, r8, r5)
            goto L9d
        L95:
            r9.setViewLayoutParams(r0, r1, r3)
            android.widget.TextView r0 = r9.largeLabel
            r9.setViewValues(r0, r4, r4, r7)
        L9d:
            android.widget.TextView r0 = r9.smallLabel
            r0.setVisibility(r7)
            goto Lb1
        La3:
            boolean r0 = r9.isShifting
            if (r0 == 0) goto Lae
            android.widget.ImageView r0 = r9.icon
            int r1 = r9.defaultMargin
            if (r10 == 0) goto L95
            goto L8c
        Lae:
            if (r10 == 0) goto L72
            goto L59
        Lb1:
            r9.refreshDrawableState()
            r9.setSelected(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomnavigation.BottomNavigationItemView.setChecked(boolean):void");
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.icon.setEnabled(z);
        ViewCompat.setPointerIcon(this, z ? PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND) : null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, this.iconTint);
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTint = colorStateList;
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        ViewCompat.setBackground(this, drawable);
    }

    public void setItemPosition(int i) {
        this.itemPosition = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.labelVisibilityMode != i) {
            this.labelVisibilityMode = i;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.isShifting != z) {
            this.isShifting = z;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearanceActive(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.largeLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.smallLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}
