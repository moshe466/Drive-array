package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.Utils;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.DayPickerView;

/* loaded from: classes2.dex */
public class DayPickerGroup extends ViewGroup implements View.OnClickListener, DayPickerView.OnPageListener {
    private DatePickerController controller;
    private DayPickerView dayPickerView;
    private ImageButton nextButton;
    private ImageButton prevButton;

    public DayPickerGroup(Context context) {
        super(context);
        init();
    }

    public DayPickerGroup(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DayPickerGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public DayPickerGroup(Context context, @NonNull DatePickerController datePickerController) {
        super(context);
        this.controller = datePickerController;
        init();
    }

    private void init() {
        this.dayPickerView = new SimpleDayPickerView(getContext(), this.controller);
        addView(this.dayPickerView);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.mdtp_daypicker_group, (ViewGroup) this, false);
        while (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            viewGroup.removeViewAt(0);
            addView(childAt);
        }
        this.prevButton = (ImageButton) findViewById(R.id.mdtp_previous_month_arrow);
        this.nextButton = (ImageButton) findViewById(R.id.mdtp_next_month_arrow);
        if (this.controller.getVersion() == DatePickerDialog.Version.VERSION_1) {
            int dpToPx = Utils.dpToPx(16.0f, getResources());
            this.prevButton.setMinimumHeight(dpToPx);
            this.prevButton.setMinimumWidth(dpToPx);
            this.nextButton.setMinimumHeight(dpToPx);
            this.nextButton.setMinimumWidth(dpToPx);
        }
        if (this.controller.isThemeDark()) {
            int color = ContextCompat.getColor(getContext(), R.color.mdtp_date_picker_text_normal_dark_theme);
            this.prevButton.setColorFilter(color);
            this.nextButton.setColorFilter(color);
        }
        this.prevButton.setOnClickListener(this);
        this.nextButton.setOnClickListener(this);
        this.dayPickerView.setOnPageListener(this);
    }

    private void updateButtonVisibility(int i) {
        boolean z = this.controller.getScrollOrientation() == DatePickerDialog.ScrollOrientation.HORIZONTAL;
        boolean z2 = i > 0;
        boolean z3 = i < this.dayPickerView.getCount() - 1;
        this.prevButton.setVisibility((z && z2) ? 0 : 4);
        this.nextButton.setVisibility((z && z3) ? 0 : 4);
    }

    public int getMostVisiblePosition() {
        return this.dayPickerView.getMostVisiblePosition();
    }

    public void onChange() {
        this.dayPickerView.onChange();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        int i;
        if (this.nextButton == view) {
            i = 1;
        } else if (this.prevButton != view) {
            return;
        } else {
            i = -1;
        }
        int mostVisiblePosition = this.dayPickerView.getMostVisiblePosition() + i;
        if (mostVisiblePosition < 0 || mostVisiblePosition >= this.dayPickerView.getCount()) {
            return;
        }
        this.dayPickerView.smoothScrollToPosition(mostVisiblePosition);
        updateButtonVisibility(mostVisiblePosition);
    }

    public void onDateChanged() {
        this.dayPickerView.onDateChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageButton imageButton;
        ImageButton imageButton2;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            imageButton = this.nextButton;
            imageButton2 = this.prevButton;
        } else {
            imageButton = this.prevButton;
            imageButton2 = this.nextButton;
        }
        int dimensionPixelSize = this.controller.getVersion() == DatePickerDialog.Version.VERSION_1 ? 0 : getContext().getResources().getDimensionPixelSize(R.dimen.mdtp_date_picker_view_animator_padding_v2);
        int i5 = i3 - i;
        this.dayPickerView.layout(0, dimensionPixelSize, i5, i4 - i2);
        SimpleMonthView simpleMonthView = (SimpleMonthView) this.dayPickerView.getChildAt(0);
        int monthHeight = simpleMonthView.getMonthHeight();
        int cellWidth = simpleMonthView.getCellWidth();
        int edgePadding = simpleMonthView.getEdgePadding();
        int measuredWidth = imageButton.getMeasuredWidth();
        int measuredHeight = imageButton.getMeasuredHeight();
        int paddingTop = simpleMonthView.getPaddingTop() + dimensionPixelSize + ((monthHeight - measuredHeight) / 2);
        int i6 = ((cellWidth - measuredWidth) / 2) + edgePadding;
        imageButton.layout(i6, paddingTop, measuredWidth + i6, measuredHeight + paddingTop);
        int measuredWidth2 = imageButton2.getMeasuredWidth();
        int measuredHeight2 = imageButton2.getMeasuredHeight();
        int paddingTop2 = dimensionPixelSize + simpleMonthView.getPaddingTop() + ((monthHeight - measuredHeight2) / 2);
        int i7 = ((i5 - edgePadding) - ((cellWidth - measuredWidth2) / 2)) - 2;
        imageButton2.layout(i7 - measuredWidth2, paddingTop2, i7, measuredHeight2 + paddingTop2);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        measureChild(this.dayPickerView, i, i2);
        setMeasuredDimension(this.dayPickerView.getMeasuredWidthAndState(), this.dayPickerView.getMeasuredHeightAndState());
        int measuredWidth = this.dayPickerView.getMeasuredWidth();
        int measuredHeight = this.dayPickerView.getMeasuredHeight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE);
        this.prevButton.measure(makeMeasureSpec, makeMeasureSpec2);
        this.nextButton.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DayPickerView.OnPageListener
    public void onPageChanged(int i) {
        updateButtonVisibility(i);
        this.dayPickerView.v();
    }

    public void postSetSelection(int i) {
        this.dayPickerView.postSetSelection(i);
    }
}
