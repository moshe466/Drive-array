package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wdullaer.materialdatetimepicker.date.MonthView;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public abstract class MonthAdapter extends RecyclerView.Adapter<MonthViewHolder> implements MonthView.OnDayClickListener {
    protected final DatePickerController a;
    private CalendarDay mSelectedDay;

    /* loaded from: classes2.dex */
    public static class CalendarDay {
        int a;
        int b;
        int c;
        private Calendar calendar;
        TimeZone d;

        public CalendarDay(int i, int i2, int i3) {
            setDay(i, i2, i3);
        }

        public CalendarDay(int i, int i2, int i3, TimeZone timeZone) {
            this.d = timeZone;
            setDay(i, i2, i3);
        }

        public CalendarDay(long j, TimeZone timeZone) {
            this.d = timeZone;
            setTime(j);
        }

        public CalendarDay(Calendar calendar, TimeZone timeZone) {
            this.d = timeZone;
            this.a = calendar.get(1);
            this.b = calendar.get(2);
            this.c = calendar.get(5);
        }

        public CalendarDay(TimeZone timeZone) {
            this.d = timeZone;
            setTime(System.currentTimeMillis());
        }

        private void setTime(long j) {
            if (this.calendar == null) {
                this.calendar = Calendar.getInstance(this.d);
            }
            this.calendar.setTimeInMillis(j);
            this.b = this.calendar.get(2);
            this.a = this.calendar.get(1);
            this.c = this.calendar.get(5);
        }

        public int getDay() {
            return this.c;
        }

        public int getMonth() {
            return this.b;
        }

        public int getYear() {
            return this.a;
        }

        public void set(CalendarDay calendarDay) {
            this.a = calendarDay.a;
            this.b = calendarDay.b;
            this.c = calendarDay.c;
        }

        public void setDay(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class MonthViewHolder extends RecyclerView.ViewHolder {
        public MonthViewHolder(MonthView monthView) {
            super(monthView);
        }

        private boolean isSelectedDayInMonth(CalendarDay calendarDay, int i, int i2) {
            return calendarDay.a == i && calendarDay.b == i2;
        }

        void a(int i, DatePickerController datePickerController, CalendarDay calendarDay) {
            int i2 = (datePickerController.getStartDate().get(2) + i) % 12;
            int minYear = ((i + datePickerController.getStartDate().get(2)) / 12) + datePickerController.getMinYear();
            ((MonthView) this.itemView).setMonthParams(isSelectedDayInMonth(calendarDay, minYear, i2) ? calendarDay.c : -1, minYear, i2, datePickerController.getFirstDayOfWeek());
            this.itemView.invalidate();
        }
    }

    public MonthAdapter(DatePickerController datePickerController) {
        this.a = datePickerController;
        a();
        setSelectedDay(this.a.getSelectedDay());
        setHasStableIds(true);
    }

    protected void a() {
        this.mSelectedDay = new CalendarDay(System.currentTimeMillis(), this.a.getTimeZone());
    }

    protected void a(CalendarDay calendarDay) {
        this.a.tryVibrate();
        this.a.onDayOfMonthSelected(calendarDay.a, calendarDay.b, calendarDay.c);
        setSelectedDay(calendarDay);
    }

    public abstract MonthView createMonthView(Context context);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Calendar endDate = this.a.getEndDate();
        Calendar startDate = this.a.getStartDate();
        return (((endDate.get(1) * 12) + endDate.get(2)) - ((startDate.get(1) * 12) + startDate.get(2))) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public CalendarDay getSelectedDay() {
        return this.mSelectedDay;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull MonthViewHolder monthViewHolder, int i) {
        monthViewHolder.a(i, this.a, this.mSelectedDay);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public MonthViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MonthView createMonthView = createMonthView(viewGroup.getContext());
        createMonthView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        createMonthView.setClickable(true);
        createMonthView.setOnDayClickListener(this);
        return new MonthViewHolder(createMonthView);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthView.OnDayClickListener
    public void onDayClick(MonthView monthView, CalendarDay calendarDay) {
        if (calendarDay != null) {
            a(calendarDay);
        }
    }

    public void setSelectedDay(CalendarDay calendarDay) {
        this.mSelectedDay = calendarDay;
        notifyDataSetChanged();
    }
}
