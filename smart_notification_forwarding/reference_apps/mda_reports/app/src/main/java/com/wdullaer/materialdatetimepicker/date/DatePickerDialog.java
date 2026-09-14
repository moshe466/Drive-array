package com.wdullaer.materialdatetimepicker.date;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.wdullaer.materialdatetimepicker.HapticFeedbackController;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.Utils;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DatePickerDialog extends AppCompatDialogFragment implements View.OnClickListener, DatePickerController {
    private static final int ANIMATION_DELAY = 500;
    private static final int ANIMATION_DURATION = 300;
    private static final String KEY_ACCENT = "accent";
    private static final String KEY_AUTO_DISMISS = "auto_dismiss";
    private static final String KEY_CANCEL_COLOR = "cancel_color";
    private static final String KEY_CANCEL_RESID = "cancel_resid";
    private static final String KEY_CANCEL_STRING = "cancel_string";
    private static final String KEY_CURRENT_VIEW = "current_view";
    private static final String KEY_DATERANGELIMITER = "daterangelimiter";
    private static final String KEY_DEFAULT_VIEW = "default_view";
    private static final String KEY_DISMISS = "dismiss";
    private static final String KEY_HIGHLIGHTED_DAYS = "highlighted_days";
    private static final String KEY_LIST_POSITION = "list_position";
    private static final String KEY_LIST_POSITION_OFFSET = "list_position_offset";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_OK_COLOR = "ok_color";
    private static final String KEY_OK_RESID = "ok_resid";
    private static final String KEY_OK_STRING = "ok_string";
    private static final String KEY_SCROLL_ORIENTATION = "scrollorientation";
    private static final String KEY_SELECTED_DAY = "day";
    private static final String KEY_SELECTED_MONTH = "month";
    private static final String KEY_SELECTED_YEAR = "year";
    private static final String KEY_THEME_DARK = "theme_dark";
    private static final String KEY_THEME_DARK_CHANGED = "theme_dark_changed";
    private static final String KEY_TIMEZONE = "timezone";
    private static final String KEY_TITLE = "title";
    private static final String KEY_VERSION = "version";
    private static final String KEY_VIBRATE = "vibrate";
    private static final String KEY_WEEK_START = "week_start";
    private static final int MONTH_AND_DAY_VIEW = 0;
    private static final int UNINITIALIZED = -1;
    private static SimpleDateFormat VERSION_2_FORMAT = null;
    private static final int YEAR_VIEW = 1;
    private AccessibleDateAnimator mAnimator;
    private OnDateSetListener mCallBack;
    private String mCancelString;
    private TextView mDatePickerHeaderView;
    private String mDayPickerDescription;
    private DayPickerGroup mDayPickerView;
    private HapticFeedbackController mHapticFeedbackController;
    private LinearLayout mMonthAndDayView;
    private String mOkString;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private ScrollOrientation mScrollOrientation;
    private String mSelectDay;
    private String mSelectYear;
    private TextView mSelectedDayTextView;
    private TextView mSelectedMonthTextView;
    private TimeZone mTimezone;
    private String mTitle;
    private Version mVersion;
    private String mYearPickerDescription;
    private YearPickerView mYearPickerView;
    private TextView mYearView;
    private static SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy", Locale.getDefault());
    private static SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMM", Locale.getDefault());
    private static SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("dd", Locale.getDefault());
    private Calendar mCalendar = Utils.trimToMidnight(Calendar.getInstance(getTimeZone()));
    private HashSet<OnDateChangedListener> mListeners = new HashSet<>();
    private int mCurrentView = -1;
    private int mWeekStart = this.mCalendar.getFirstDayOfWeek();
    private HashSet<Calendar> highlightedDays = new HashSet<>();
    private boolean mThemeDark = false;
    private boolean mThemeDarkChanged = false;
    private int mAccentColor = -1;
    private boolean mVibrate = true;
    private boolean mDismissOnPause = false;
    private boolean mAutoDismiss = false;
    private int mDefaultView = 0;
    private int mOkResid = R.string.mdtp_ok;
    private int mOkColor = -1;
    private int mCancelResid = R.string.mdtp_cancel;
    private int mCancelColor = -1;
    private Locale mLocale = Locale.getDefault();
    private DefaultDateRangeLimiter mDefaultLimiter = new DefaultDateRangeLimiter();
    private DateRangeLimiter mDateRangeLimiter = this.mDefaultLimiter;
    private boolean mDelayAnimation = true;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface OnDateChangedListener {
        void onDateChanged();
    }

    /* loaded from: classes2.dex */
    public interface OnDateSetListener {
        void onDateSet(DatePickerDialog datePickerDialog, int i, int i2, int i3);
    }

    /* loaded from: classes2.dex */
    public enum ScrollOrientation {
        HORIZONTAL,
        VERTICAL
    }

    /* loaded from: classes2.dex */
    public enum Version {
        VERSION_1,
        VERSION_2
    }

    private Calendar adjustDayInMonthIfNeeded(Calendar calendar) {
        int i = calendar.get(5);
        int actualMaximum = calendar.getActualMaximum(5);
        if (i > actualMaximum) {
            calendar.set(5, actualMaximum);
        }
        return this.mDateRangeLimiter.setToNearestDate(calendar);
    }

    public static DatePickerDialog newInstance(OnDateSetListener onDateSetListener) {
        return newInstance(onDateSetListener, Calendar.getInstance());
    }

    public static DatePickerDialog newInstance(OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        DatePickerDialog datePickerDialog = new DatePickerDialog();
        datePickerDialog.initialize(onDateSetListener, i, i2, i3);
        return datePickerDialog;
    }

    public static DatePickerDialog newInstance(OnDateSetListener onDateSetListener, Calendar calendar) {
        DatePickerDialog datePickerDialog = new DatePickerDialog();
        datePickerDialog.initialize(onDateSetListener, calendar);
        return datePickerDialog;
    }

    private void setCurrentView(int i) {
        AccessibleDateAnimator accessibleDateAnimator;
        String str;
        long timeInMillis = this.mCalendar.getTimeInMillis();
        if (i == 0) {
            if (this.mVersion == Version.VERSION_1) {
                ObjectAnimator pulseAnimator = Utils.getPulseAnimator(this.mMonthAndDayView, 0.9f, 1.05f);
                if (this.mDelayAnimation) {
                    pulseAnimator.setStartDelay(500L);
                    this.mDelayAnimation = false;
                }
                if (this.mCurrentView != i) {
                    this.mMonthAndDayView.setSelected(true);
                    this.mYearView.setSelected(false);
                    this.mAnimator.setDisplayedChild(0);
                    this.mCurrentView = i;
                }
                this.mDayPickerView.onDateChanged();
                pulseAnimator.start();
            } else {
                if (this.mCurrentView != i) {
                    this.mMonthAndDayView.setSelected(true);
                    this.mYearView.setSelected(false);
                    this.mAnimator.setDisplayedChild(0);
                    this.mCurrentView = i;
                }
                this.mDayPickerView.onDateChanged();
            }
            String formatDateTime = DateUtils.formatDateTime(getActivity(), timeInMillis, 16);
            this.mAnimator.setContentDescription(this.mDayPickerDescription + ": " + formatDateTime);
            accessibleDateAnimator = this.mAnimator;
            str = this.mSelectDay;
        } else {
            if (i != 1) {
                return;
            }
            if (this.mVersion == Version.VERSION_1) {
                ObjectAnimator pulseAnimator2 = Utils.getPulseAnimator(this.mYearView, 0.85f, 1.1f);
                if (this.mDelayAnimation) {
                    pulseAnimator2.setStartDelay(500L);
                    this.mDelayAnimation = false;
                }
                this.mYearPickerView.onDateChanged();
                if (this.mCurrentView != i) {
                    this.mMonthAndDayView.setSelected(false);
                    this.mYearView.setSelected(true);
                    this.mAnimator.setDisplayedChild(1);
                    this.mCurrentView = i;
                }
                pulseAnimator2.start();
            } else {
                this.mYearPickerView.onDateChanged();
                if (this.mCurrentView != i) {
                    this.mMonthAndDayView.setSelected(false);
                    this.mYearView.setSelected(true);
                    this.mAnimator.setDisplayedChild(1);
                    this.mCurrentView = i;
                }
            }
            String format = YEAR_FORMAT.format(Long.valueOf(timeInMillis));
            this.mAnimator.setContentDescription(this.mYearPickerDescription + ": " + ((Object) format));
            accessibleDateAnimator = this.mAnimator;
            str = this.mSelectYear;
        }
        Utils.tryAccessibilityAnnounce(accessibleDateAnimator, str);
    }

    private void updateDisplay(boolean z) {
        this.mYearView.setText(YEAR_FORMAT.format(this.mCalendar.getTime()));
        if (this.mVersion == Version.VERSION_1) {
            TextView textView = this.mDatePickerHeaderView;
            if (textView != null) {
                String str = this.mTitle;
                if (str == null) {
                    str = this.mCalendar.getDisplayName(7, 2, this.mLocale);
                }
                textView.setText(str);
            }
            this.mSelectedMonthTextView.setText(MONTH_FORMAT.format(this.mCalendar.getTime()));
            this.mSelectedDayTextView.setText(DAY_FORMAT.format(this.mCalendar.getTime()));
        }
        if (this.mVersion == Version.VERSION_2) {
            this.mSelectedDayTextView.setText(VERSION_2_FORMAT.format(this.mCalendar.getTime()));
            String str2 = this.mTitle;
            if (str2 != null) {
                this.mDatePickerHeaderView.setText(str2.toUpperCase(this.mLocale));
            } else {
                this.mDatePickerHeaderView.setVisibility(8);
            }
        }
        long timeInMillis = this.mCalendar.getTimeInMillis();
        this.mAnimator.setDateMillis(timeInMillis);
        this.mMonthAndDayView.setContentDescription(DateUtils.formatDateTime(getActivity(), timeInMillis, 24));
        if (z) {
            Utils.tryAccessibilityAnnounce(this.mAnimator, DateUtils.formatDateTime(getActivity(), timeInMillis, 20));
        }
    }

    private void updatePickers() {
        Iterator<OnDateChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onDateChanged();
        }
    }

    public void autoDismiss(boolean z) {
        this.mAutoDismiss = z;
    }

    public /* synthetic */ void b(View view) {
        tryVibrate();
        notifyOnDateListener();
        dismiss();
    }

    public /* synthetic */ void c(View view) {
        tryVibrate();
        if (getDialog() != null) {
            getDialog().cancel();
        }
    }

    public void dismissOnPause(boolean z) {
        this.mDismissOnPause = z;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getAccentColor() {
        return this.mAccentColor;
    }

    public Calendar[] getDisabledDays() {
        return this.mDefaultLimiter.a();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Calendar getEndDate() {
        return this.mDateRangeLimiter.getEndDate();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getFirstDayOfWeek() {
        return this.mWeekStart;
    }

    public Calendar[] getHighlightedDays() {
        if (this.highlightedDays.isEmpty()) {
            return null;
        }
        Calendar[] calendarArr = (Calendar[]) this.highlightedDays.toArray(new Calendar[0]);
        Arrays.sort(calendarArr);
        return calendarArr;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Locale getLocale() {
        return this.mLocale;
    }

    public Calendar getMaxDate() {
        return this.mDefaultLimiter.b();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getMaxYear() {
        return this.mDateRangeLimiter.getMaxYear();
    }

    public Calendar getMinDate() {
        return this.mDefaultLimiter.c();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getMinYear() {
        return this.mDateRangeLimiter.getMinYear();
    }

    public OnDateSetListener getOnDateSetListener() {
        return this.mCallBack;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public ScrollOrientation getScrollOrientation() {
        return this.mScrollOrientation;
    }

    public Calendar[] getSelectableDays() {
        return this.mDefaultLimiter.d();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public MonthAdapter.CalendarDay getSelectedDay() {
        return new MonthAdapter.CalendarDay(this.mCalendar, getTimeZone());
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Calendar getStartDate() {
        return this.mDateRangeLimiter.getStartDate();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public TimeZone getTimeZone() {
        TimeZone timeZone = this.mTimezone;
        return timeZone == null ? TimeZone.getDefault() : timeZone;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Version getVersion() {
        return this.mVersion;
    }

    public void initialize(OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        initialize(onDateSetListener, calendar);
    }

    public void initialize(OnDateSetListener onDateSetListener, Calendar calendar) {
        this.mCallBack = onDateSetListener;
        this.mCalendar = Utils.trimToMidnight((Calendar) calendar.clone());
        this.mScrollOrientation = null;
        setTimeZone(this.mCalendar.getTimeZone());
        this.mVersion = Build.VERSION.SDK_INT < 23 ? Version.VERSION_1 : Version.VERSION_2;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public boolean isHighlighted(int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        Utils.trimToMidnight(calendar);
        return this.highlightedDays.contains(calendar);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public boolean isOutOfRange(int i, int i2, int i3) {
        return this.mDateRangeLimiter.isOutOfRange(i, i2, i3);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public boolean isThemeDark() {
        return this.mThemeDark;
    }

    public void notifyOnDateListener() {
        OnDateSetListener onDateSetListener = this.mCallBack;
        if (onDateSetListener != null) {
            onDateSetListener.onDateSet(this, this.mCalendar.get(1), this.mCalendar.get(2), this.mCalendar.get(5));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        DialogInterface.OnCancelListener onCancelListener = this.mOnCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        tryVibrate();
        if (view.getId() == R.id.mdtp_date_picker_year) {
            i = 1;
        } else if (view.getId() != R.id.mdtp_date_picker_month_and_day) {
            return;
        } else {
            i = 0;
        }
        setCurrentView(i);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            viewGroup.addView(onCreateView(requireActivity().getLayoutInflater(), viewGroup, null));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        requireActivity.getWindow().setSoftInputMode(3);
        setStyle(1, 0);
        this.mCurrentView = -1;
        if (bundle != null) {
            this.mCalendar.set(1, bundle.getInt(KEY_SELECTED_YEAR));
            this.mCalendar.set(2, bundle.getInt(KEY_SELECTED_MONTH));
            this.mCalendar.set(5, bundle.getInt(KEY_SELECTED_DAY));
            this.mDefaultView = bundle.getInt(KEY_DEFAULT_VIEW);
        }
        VERSION_2_FORMAT = Build.VERSION.SDK_INT < 18 ? new SimpleDateFormat(requireActivity.getResources().getString(R.string.mdtp_date_v2_daymonthyear), this.mLocale) : new SimpleDateFormat(DateFormat.getBestDateTimePattern(this.mLocale, "EEEMMMdd"), this.mLocale);
        VERSION_2_FORMAT.setTimeZone(getTimeZone());
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        int i3 = this.mDefaultView;
        if (this.mScrollOrientation == null) {
            this.mScrollOrientation = this.mVersion == Version.VERSION_1 ? ScrollOrientation.VERTICAL : ScrollOrientation.HORIZONTAL;
        }
        if (bundle != null) {
            this.mWeekStart = bundle.getInt(KEY_WEEK_START);
            i3 = bundle.getInt(KEY_CURRENT_VIEW);
            i = bundle.getInt(KEY_LIST_POSITION);
            i2 = bundle.getInt(KEY_LIST_POSITION_OFFSET);
            this.highlightedDays = (HashSet) bundle.getSerializable(KEY_HIGHLIGHTED_DAYS);
            this.mThemeDark = bundle.getBoolean(KEY_THEME_DARK);
            this.mThemeDarkChanged = bundle.getBoolean(KEY_THEME_DARK_CHANGED);
            this.mAccentColor = bundle.getInt(KEY_ACCENT);
            this.mVibrate = bundle.getBoolean(KEY_VIBRATE);
            this.mDismissOnPause = bundle.getBoolean(KEY_DISMISS);
            this.mAutoDismiss = bundle.getBoolean(KEY_AUTO_DISMISS);
            this.mTitle = bundle.getString("title");
            this.mOkResid = bundle.getInt(KEY_OK_RESID);
            this.mOkString = bundle.getString(KEY_OK_STRING);
            this.mOkColor = bundle.getInt(KEY_OK_COLOR);
            this.mCancelResid = bundle.getInt(KEY_CANCEL_RESID);
            this.mCancelString = bundle.getString(KEY_CANCEL_STRING);
            this.mCancelColor = bundle.getInt(KEY_CANCEL_COLOR);
            this.mVersion = (Version) bundle.getSerializable(KEY_VERSION);
            this.mScrollOrientation = (ScrollOrientation) bundle.getSerializable(KEY_SCROLL_ORIENTATION);
            this.mTimezone = (TimeZone) bundle.getSerializable(KEY_TIMEZONE);
            this.mDateRangeLimiter = (DateRangeLimiter) bundle.getParcelable(KEY_DATERANGELIMITER);
            setLocale((Locale) bundle.getSerializable(KEY_LOCALE));
            DateRangeLimiter dateRangeLimiter = this.mDateRangeLimiter;
            this.mDefaultLimiter = dateRangeLimiter instanceof DefaultDateRangeLimiter ? (DefaultDateRangeLimiter) dateRangeLimiter : new DefaultDateRangeLimiter();
        } else {
            i = -1;
            i2 = 0;
        }
        this.mDefaultLimiter.a(this);
        View inflate = layoutInflater.inflate(this.mVersion == Version.VERSION_1 ? R.layout.mdtp_date_picker_dialog : R.layout.mdtp_date_picker_dialog_v2, viewGroup, false);
        this.mCalendar = this.mDateRangeLimiter.setToNearestDate(this.mCalendar);
        this.mDatePickerHeaderView = (TextView) inflate.findViewById(R.id.mdtp_date_picker_header);
        this.mMonthAndDayView = (LinearLayout) inflate.findViewById(R.id.mdtp_date_picker_month_and_day);
        this.mMonthAndDayView.setOnClickListener(this);
        this.mSelectedMonthTextView = (TextView) inflate.findViewById(R.id.mdtp_date_picker_month);
        this.mSelectedDayTextView = (TextView) inflate.findViewById(R.id.mdtp_date_picker_day);
        this.mYearView = (TextView) inflate.findViewById(R.id.mdtp_date_picker_year);
        this.mYearView.setOnClickListener(this);
        FragmentActivity requireActivity = requireActivity();
        this.mDayPickerView = new DayPickerGroup(requireActivity, this);
        this.mYearPickerView = new YearPickerView(requireActivity, this);
        if (!this.mThemeDarkChanged) {
            this.mThemeDark = Utils.isDarkTheme(requireActivity, this.mThemeDark);
        }
        Resources resources = getResources();
        this.mDayPickerDescription = resources.getString(R.string.mdtp_day_picker_description);
        this.mSelectDay = resources.getString(R.string.mdtp_select_day);
        this.mYearPickerDescription = resources.getString(R.string.mdtp_year_picker_description);
        this.mSelectYear = resources.getString(R.string.mdtp_select_year);
        inflate.setBackgroundColor(ContextCompat.getColor(requireActivity, this.mThemeDark ? R.color.mdtp_date_picker_view_animator_dark_theme : R.color.mdtp_date_picker_view_animator));
        this.mAnimator = (AccessibleDateAnimator) inflate.findViewById(R.id.mdtp_animator);
        this.mAnimator.addView(this.mDayPickerView);
        this.mAnimator.addView(this.mYearPickerView);
        this.mAnimator.setDateMillis(this.mCalendar.getTimeInMillis());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        this.mAnimator.setInAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300L);
        this.mAnimator.setOutAnimation(alphaAnimation2);
        Button button = (Button) inflate.findViewById(R.id.mdtp_ok);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.date.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DatePickerDialog.this.b(view);
            }
        });
        button.setTypeface(ResourcesCompat.getFont(requireActivity, R.font.robotomedium));
        String str = this.mOkString;
        if (str != null) {
            button.setText(str);
        } else {
            button.setText(this.mOkResid);
        }
        Button button2 = (Button) inflate.findViewById(R.id.mdtp_cancel);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.date.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DatePickerDialog.this.c(view);
            }
        });
        button2.setTypeface(ResourcesCompat.getFont(requireActivity, R.font.robotomedium));
        String str2 = this.mCancelString;
        if (str2 != null) {
            button2.setText(str2);
        } else {
            button2.setText(this.mCancelResid);
        }
        button2.setVisibility(isCancelable() ? 0 : 8);
        if (this.mAccentColor == -1) {
            this.mAccentColor = Utils.getAccentColorFromThemeIfAvailable(getActivity());
        }
        TextView textView = this.mDatePickerHeaderView;
        if (textView != null) {
            textView.setBackgroundColor(Utils.darkenColor(this.mAccentColor));
        }
        inflate.findViewById(R.id.mdtp_day_picker_selected_date_layout).setBackgroundColor(this.mAccentColor);
        int i4 = this.mOkColor;
        if (i4 == -1) {
            i4 = this.mAccentColor;
        }
        button.setTextColor(i4);
        int i5 = this.mCancelColor;
        if (i5 == -1) {
            i5 = this.mAccentColor;
        }
        button2.setTextColor(i5);
        if (getDialog() == null) {
            inflate.findViewById(R.id.mdtp_done_background).setVisibility(8);
        }
        updateDisplay(false);
        setCurrentView(i3);
        if (i != -1) {
            if (i3 == 0) {
                this.mDayPickerView.postSetSelection(i);
            } else if (i3 == 1) {
                this.mYearPickerView.postSetSelectionFromTop(i, i2);
            }
        }
        this.mHapticFeedbackController = new HapticFeedbackController(requireActivity);
        return inflate;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void onDayOfMonthSelected(int i, int i2, int i3) {
        this.mCalendar.set(1, i);
        this.mCalendar.set(2, i2);
        this.mCalendar.set(5, i3);
        updatePickers();
        updateDisplay(true);
        if (this.mAutoDismiss) {
            notifyOnDateListener();
            dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHapticFeedbackController.stop();
        if (this.mDismissOnPause) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mHapticFeedbackController.start();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        int i;
        super.onSaveInstanceState(bundle);
        bundle.putInt(KEY_SELECTED_YEAR, this.mCalendar.get(1));
        bundle.putInt(KEY_SELECTED_MONTH, this.mCalendar.get(2));
        bundle.putInt(KEY_SELECTED_DAY, this.mCalendar.get(5));
        bundle.putInt(KEY_WEEK_START, this.mWeekStart);
        bundle.putInt(KEY_CURRENT_VIEW, this.mCurrentView);
        int i2 = this.mCurrentView;
        if (i2 == 0) {
            i = this.mDayPickerView.getMostVisiblePosition();
        } else if (i2 == 1) {
            i = this.mYearPickerView.getFirstVisiblePosition();
            bundle.putInt(KEY_LIST_POSITION_OFFSET, this.mYearPickerView.getFirstPositionOffset());
        } else {
            i = -1;
        }
        bundle.putInt(KEY_LIST_POSITION, i);
        bundle.putSerializable(KEY_HIGHLIGHTED_DAYS, this.highlightedDays);
        bundle.putBoolean(KEY_THEME_DARK, this.mThemeDark);
        bundle.putBoolean(KEY_THEME_DARK_CHANGED, this.mThemeDarkChanged);
        bundle.putInt(KEY_ACCENT, this.mAccentColor);
        bundle.putBoolean(KEY_VIBRATE, this.mVibrate);
        bundle.putBoolean(KEY_DISMISS, this.mDismissOnPause);
        bundle.putBoolean(KEY_AUTO_DISMISS, this.mAutoDismiss);
        bundle.putInt(KEY_DEFAULT_VIEW, this.mDefaultView);
        bundle.putString("title", this.mTitle);
        bundle.putInt(KEY_OK_RESID, this.mOkResid);
        bundle.putString(KEY_OK_STRING, this.mOkString);
        bundle.putInt(KEY_OK_COLOR, this.mOkColor);
        bundle.putInt(KEY_CANCEL_RESID, this.mCancelResid);
        bundle.putString(KEY_CANCEL_STRING, this.mCancelString);
        bundle.putInt(KEY_CANCEL_COLOR, this.mCancelColor);
        bundle.putSerializable(KEY_VERSION, this.mVersion);
        bundle.putSerializable(KEY_SCROLL_ORIENTATION, this.mScrollOrientation);
        bundle.putSerializable(KEY_TIMEZONE, this.mTimezone);
        bundle.putParcelable(KEY_DATERANGELIMITER, this.mDateRangeLimiter);
        bundle.putSerializable(KEY_LOCALE, this.mLocale);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void onYearSelected(int i) {
        this.mCalendar.set(1, i);
        this.mCalendar = adjustDayInMonthIfNeeded(this.mCalendar);
        updatePickers();
        setCurrentView(0);
        updateDisplay(true);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void registerOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mListeners.add(onDateChangedListener);
    }

    public void setAccentColor(@ColorInt int i) {
        this.mAccentColor = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
    }

    public void setAccentColor(String str) {
        this.mAccentColor = Color.parseColor(str);
    }

    public void setCancelColor(@ColorInt int i) {
        this.mCancelColor = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
    }

    public void setCancelColor(String str) {
        this.mCancelColor = Color.parseColor(str);
    }

    public void setCancelText(@StringRes int i) {
        this.mCancelString = null;
        this.mCancelResid = i;
    }

    public void setCancelText(String str) {
        this.mCancelString = str;
    }

    public void setDateRangeLimiter(DateRangeLimiter dateRangeLimiter) {
        this.mDateRangeLimiter = dateRangeLimiter;
    }

    public void setDisabledDays(Calendar[] calendarArr) {
        this.mDefaultLimiter.a(calendarArr);
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void setFirstDayOfWeek(int i) {
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Value must be between Calendar.SUNDAY and Calendar.SATURDAY");
        }
        this.mWeekStart = i;
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void setHighlightedDays(Calendar[] calendarArr) {
        for (Calendar calendar : calendarArr) {
            this.highlightedDays.add(Utils.trimToMidnight((Calendar) calendar.clone()));
        }
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void setLocale(Locale locale) {
        this.mLocale = locale;
        this.mWeekStart = Calendar.getInstance(this.mTimezone, this.mLocale).getFirstDayOfWeek();
        YEAR_FORMAT = new SimpleDateFormat("yyyy", locale);
        MONTH_FORMAT = new SimpleDateFormat("MMM", locale);
        DAY_FORMAT = new SimpleDateFormat("dd", locale);
    }

    public void setMaxDate(Calendar calendar) {
        this.mDefaultLimiter.a(calendar);
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void setMinDate(Calendar calendar) {
        this.mDefaultLimiter.b(calendar);
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void setOkColor(@ColorInt int i) {
        this.mOkColor = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
    }

    public void setOkColor(String str) {
        this.mOkColor = Color.parseColor(str);
    }

    public void setOkText(@StringRes int i) {
        this.mOkString = null;
        this.mOkResid = i;
    }

    public void setOkText(String str) {
        this.mOkString = str;
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
    }

    public void setOnDateSetListener(OnDateSetListener onDateSetListener) {
        this.mCallBack = onDateSetListener;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setScrollOrientation(ScrollOrientation scrollOrientation) {
        this.mScrollOrientation = scrollOrientation;
    }

    public void setSelectableDays(Calendar[] calendarArr) {
        this.mDefaultLimiter.b(calendarArr);
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void setThemeDark(boolean z) {
        this.mThemeDark = z;
        this.mThemeDarkChanged = true;
    }

    @Deprecated
    public void setTimeZone(TimeZone timeZone) {
        this.mTimezone = timeZone;
        this.mCalendar.setTimeZone(timeZone);
        YEAR_FORMAT.setTimeZone(timeZone);
        MONTH_FORMAT.setTimeZone(timeZone);
        DAY_FORMAT.setTimeZone(timeZone);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVersion(Version version) {
        this.mVersion = version;
    }

    public void setYearRange(int i, int i2) {
        this.mDefaultLimiter.a(i, i2);
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void showYearPickerFirst(boolean z) {
        this.mDefaultView = z ? 1 : 0;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void tryVibrate() {
        if (this.mVibrate) {
            this.mHapticFeedbackController.tryVibrate();
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void unregisterOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mListeners.remove(onDateChangedListener);
    }

    public void vibrate(boolean z) {
        this.mVibrate = z;
    }
}
