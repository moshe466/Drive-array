package com.wdullaer.materialdatetimepicker.time;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.wdullaer.materialdatetimepicker.HapticFeedbackController;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.Utils;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.Timepoint;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TimePickerDialog extends AppCompatDialogFragment implements RadialPickerLayout.OnValueSelectedListener, TimePickerController {
    public static final int AM = 0;
    public static final int HOUR_INDEX = 0;
    private static final String KEY_ACCENT = "accent";
    private static final String KEY_CANCEL_COLOR = "cancel_color";
    private static final String KEY_CANCEL_RESID = "cancel_resid";
    private static final String KEY_CANCEL_STRING = "cancel_string";
    private static final String KEY_CURRENT_ITEM_SHOWING = "current_item_showing";
    private static final String KEY_DISMISS = "dismiss";
    private static final String KEY_ENABLE_MINUTES = "enable_minutes";
    private static final String KEY_ENABLE_SECONDS = "enable_seconds";
    private static final String KEY_INITIAL_TIME = "initial_time";
    private static final String KEY_IN_KB_MODE = "in_kb_mode";
    private static final String KEY_IS_24_HOUR_VIEW = "is_24_hour_view";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_OK_COLOR = "ok_color";
    private static final String KEY_OK_RESID = "ok_resid";
    private static final String KEY_OK_STRING = "ok_string";
    private static final String KEY_THEME_DARK = "theme_dark";
    private static final String KEY_THEME_DARK_CHANGED = "theme_dark_changed";
    private static final String KEY_TIMEPOINTLIMITER = "timepoint_limiter";
    private static final String KEY_TITLE = "dialog_title";
    private static final String KEY_TYPED_TIMES = "typed_times";
    private static final String KEY_VERSION = "version";
    private static final String KEY_VIBRATE = "vibrate";
    public static final int MINUTE_INDEX = 1;
    public static final int PM = 1;
    private static final int PULSE_ANIMATOR_DELAY = 300;
    public static final int SECOND_INDEX = 2;
    private static final String TAG = "TimePickerDialog";
    private boolean mAllowAutoAdvance;
    private int mAmKeyCode;
    private View mAmPmLayout;
    private String mAmText;
    private TextView mAmTextView;
    private OnTimeSetListener mCallback;
    private Button mCancelButton;
    private int mCancelColor;
    private int mCancelResid;
    private String mCancelString;
    private String mDeletedKeyFormat;
    private boolean mDismissOnPause;
    private String mDoublePlaceholderText;
    private boolean mEnableMinutes;
    private boolean mEnableSeconds;
    private HapticFeedbackController mHapticFeedbackController;
    private String mHourPickerDescription;
    private TextView mHourSpaceView;
    private TextView mHourView;
    private boolean mInKbMode;
    private Timepoint mInitialTime;
    private boolean mIs24HourMode;
    private Node mLegalTimesTree;
    private String mMinutePickerDescription;
    private TextView mMinuteSpaceView;
    private TextView mMinuteView;
    private Button mOkButton;
    private int mOkColor;
    private int mOkResid;
    private String mOkString;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private char mPlaceholderText;
    private int mPmKeyCode;
    private String mPmText;
    private TextView mPmTextView;
    private String mSecondPickerDescription;
    private TextView mSecondSpaceView;
    private TextView mSecondView;
    private String mSelectHours;
    private String mSelectMinutes;
    private String mSelectSeconds;
    private int mSelectedColor;
    private boolean mThemeDark;
    private boolean mThemeDarkChanged;
    private RadialPickerLayout mTimePicker;
    private String mTitle;
    private ArrayList<Integer> mTypedTimes;
    private int mUnselectedColor;
    private Version mVersion;
    private boolean mVibrate;
    private int mAccentColor = -1;
    private DefaultTimepointLimiter mDefaultLimiter = new DefaultTimepointLimiter();
    private TimepointLimiter mLimiter = this.mDefaultLimiter;
    private Locale mLocale = Locale.getDefault();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class KeyboardListener implements View.OnKeyListener {
        private KeyboardListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 1) {
                return TimePickerDialog.this.processKeyUp(i);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Node {
        private ArrayList<Node> mChildren = new ArrayList<>();
        private int[] mLegalKeys;

        public Node(int... iArr) {
            this.mLegalKeys = iArr;
        }

        public void addChild(Node node) {
            this.mChildren.add(node);
        }

        public Node canReach(int i) {
            ArrayList<Node> arrayList = this.mChildren;
            if (arrayList == null) {
                return null;
            }
            Iterator<Node> it = arrayList.iterator();
            while (it.hasNext()) {
                Node next = it.next();
                if (next.containsKey(i)) {
                    return next;
                }
            }
            return null;
        }

        public boolean containsKey(int i) {
            for (int i2 : this.mLegalKeys) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnTimeSetListener {
        void onTimeSet(TimePickerDialog timePickerDialog, int i, int i2, int i3);
    }

    /* loaded from: classes2.dex */
    public enum Version {
        VERSION_1,
        VERSION_2
    }

    private boolean addKeyIfLegal(int i) {
        int i2 = (!this.mEnableMinutes || this.mEnableSeconds) ? 6 : 4;
        if (!this.mEnableMinutes && !this.mEnableSeconds) {
            i2 = 2;
        }
        if ((this.mIs24HourMode && this.mTypedTimes.size() == i2) || (!this.mIs24HourMode && isTypedTimeFullyLegal())) {
            return false;
        }
        this.mTypedTimes.add(Integer.valueOf(i));
        if (!isTypedTimeLegalSoFar()) {
            deleteLastTypedKey();
            return false;
        }
        Utils.tryAccessibilityAnnounce(this.mTimePicker, String.format(this.mLocale, "%d", Integer.valueOf(getValFromKeyCode(i))));
        if (isTypedTimeFullyLegal()) {
            if (!this.mIs24HourMode && this.mTypedTimes.size() <= i2 - 1) {
                ArrayList<Integer> arrayList = this.mTypedTimes;
                arrayList.add(arrayList.size() - 1, 7);
                ArrayList<Integer> arrayList2 = this.mTypedTimes;
                arrayList2.add(arrayList2.size() - 1, 7);
            }
            this.mOkButton.setEnabled(true);
        }
        return true;
    }

    private int deleteLastTypedKey() {
        int intValue = this.mTypedTimes.remove(r0.size() - 1).intValue();
        if (!isTypedTimeFullyLegal()) {
            this.mOkButton.setEnabled(false);
        }
        return intValue;
    }

    private void finishKbMode(boolean z) {
        this.mInKbMode = false;
        if (!this.mTypedTimes.isEmpty()) {
            int[] enteredTime = getEnteredTime(new Boolean[]{false, false, false});
            this.mTimePicker.setTime(new Timepoint(enteredTime[0], enteredTime[1], enteredTime[2]));
            if (!this.mIs24HourMode) {
                this.mTimePicker.setAmOrPm(enteredTime[3]);
            }
            this.mTypedTimes.clear();
        }
        if (z) {
            updateDisplay(false);
            this.mTimePicker.trySettingInputEnabled(true);
        }
    }

    private void generateLegalTimesTree() {
        this.mLegalTimesTree = new Node(new int[0]);
        if (!this.mEnableMinutes && this.mIs24HourMode) {
            Node node = new Node(7, 8);
            this.mLegalTimesTree.addChild(node);
            node.addChild(new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            Node node2 = new Node(9);
            this.mLegalTimesTree.addChild(node2);
            node2.addChild(new Node(7, 8, 9, 10));
            return;
        }
        if (!this.mEnableMinutes && !this.mIs24HourMode) {
            Node node3 = new Node(getAmOrPmKeyCode(0), getAmOrPmKeyCode(1));
            Node node4 = new Node(8);
            this.mLegalTimesTree.addChild(node4);
            node4.addChild(node3);
            Node node5 = new Node(7, 8, 9);
            node4.addChild(node5);
            node5.addChild(node3);
            Node node6 = new Node(9, 10, 11, 12, 13, 14, 15, 16);
            this.mLegalTimesTree.addChild(node6);
            node6.addChild(node3);
            return;
        }
        if (this.mIs24HourMode) {
            Node node7 = new Node(7, 8, 9, 10, 11, 12);
            Node node8 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            node7.addChild(node8);
            if (this.mEnableSeconds) {
                Node node9 = new Node(7, 8, 9, 10, 11, 12);
                node9.addChild(new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
                node8.addChild(node9);
            }
            Node node10 = new Node(7, 8);
            this.mLegalTimesTree.addChild(node10);
            Node node11 = new Node(7, 8, 9, 10, 11, 12);
            node10.addChild(node11);
            node11.addChild(node7);
            node11.addChild(new Node(13, 14, 15, 16));
            Node node12 = new Node(13, 14, 15, 16);
            node10.addChild(node12);
            node12.addChild(node7);
            Node node13 = new Node(9);
            this.mLegalTimesTree.addChild(node13);
            Node node14 = new Node(7, 8, 9, 10);
            node13.addChild(node14);
            node14.addChild(node7);
            Node node15 = new Node(11, 12);
            node13.addChild(node15);
            node15.addChild(node8);
            Node node16 = new Node(10, 11, 12, 13, 14, 15, 16);
            this.mLegalTimesTree.addChild(node16);
            node16.addChild(node7);
            return;
        }
        Node node17 = new Node(getAmOrPmKeyCode(0), getAmOrPmKeyCode(1));
        Node node18 = new Node(7, 8, 9, 10, 11, 12);
        Node node19 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node19.addChild(node17);
        node18.addChild(node19);
        Node node20 = new Node(8);
        this.mLegalTimesTree.addChild(node20);
        node20.addChild(node17);
        Node node21 = new Node(7, 8, 9);
        node20.addChild(node21);
        node21.addChild(node17);
        Node node22 = new Node(7, 8, 9, 10, 11, 12);
        node21.addChild(node22);
        node22.addChild(node17);
        Node node23 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node22.addChild(node23);
        node23.addChild(node17);
        if (this.mEnableSeconds) {
            node23.addChild(node18);
        }
        Node node24 = new Node(13, 14, 15, 16);
        node21.addChild(node24);
        node24.addChild(node17);
        if (this.mEnableSeconds) {
            node24.addChild(node18);
        }
        Node node25 = new Node(10, 11, 12);
        node20.addChild(node25);
        Node node26 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node25.addChild(node26);
        node26.addChild(node17);
        if (this.mEnableSeconds) {
            node26.addChild(node18);
        }
        Node node27 = new Node(9, 10, 11, 12, 13, 14, 15, 16);
        this.mLegalTimesTree.addChild(node27);
        node27.addChild(node17);
        Node node28 = new Node(7, 8, 9, 10, 11, 12);
        node27.addChild(node28);
        Node node29 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node28.addChild(node29);
        node29.addChild(node17);
        if (this.mEnableSeconds) {
            node29.addChild(node18);
        }
    }

    private int getAmOrPmKeyCode(int i) {
        if (this.mAmKeyCode == -1 || this.mPmKeyCode == -1) {
            KeyCharacterMap load = KeyCharacterMap.load(-1);
            int i2 = 0;
            while (true) {
                if (i2 >= Math.max(this.mAmText.length(), this.mPmText.length())) {
                    break;
                }
                char charAt = this.mAmText.toLowerCase(this.mLocale).charAt(i2);
                char charAt2 = this.mPmText.toLowerCase(this.mLocale).charAt(i2);
                if (charAt != charAt2) {
                    KeyEvent[] events = load.getEvents(new char[]{charAt, charAt2});
                    if (events == null || events.length != 4) {
                        Log.e(TAG, "Unable to find keycodes for AM and PM.");
                    } else {
                        this.mAmKeyCode = events[0].getKeyCode();
                        this.mPmKeyCode = events[2].getKeyCode();
                    }
                } else {
                    i2++;
                }
            }
        }
        if (i == 0) {
            return this.mAmKeyCode;
        }
        if (i == 1) {
            return this.mPmKeyCode;
        }
        return -1;
    }

    @NonNull
    private int[] getEnteredTime(@NonNull Boolean[] boolArr) {
        int i;
        int i2;
        if (this.mIs24HourMode || !isTypedTimeFullyLegal()) {
            i = 1;
            i2 = -1;
        } else {
            ArrayList<Integer> arrayList = this.mTypedTimes;
            int intValue = arrayList.get(arrayList.size() - 1).intValue();
            i2 = intValue == getAmOrPmKeyCode(0) ? 0 : intValue == getAmOrPmKeyCode(1) ? 1 : -1;
            i = 2;
        }
        int i3 = this.mEnableSeconds ? 2 : 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        for (int i7 = i; i7 <= this.mTypedTimes.size(); i7++) {
            ArrayList<Integer> arrayList2 = this.mTypedTimes;
            int valFromKeyCode = getValFromKeyCode(arrayList2.get(arrayList2.size() - i7).intValue());
            if (this.mEnableSeconds) {
                if (i7 == i) {
                    i6 = valFromKeyCode;
                } else if (i7 == i + 1) {
                    i6 += valFromKeyCode * 10;
                    if (boolArr != null && valFromKeyCode == 0) {
                        boolArr[2] = true;
                    }
                }
            }
            if (this.mEnableMinutes) {
                int i8 = i + i3;
                if (i7 == i8) {
                    i5 = valFromKeyCode;
                } else if (i7 == i8 + 1) {
                    i5 += valFromKeyCode * 10;
                    if (boolArr != null && valFromKeyCode == 0) {
                        boolArr[1] = true;
                    }
                } else {
                    if (i7 != i8 + 2) {
                        if (i7 == i8 + 3) {
                            i4 += valFromKeyCode * 10;
                            if (boolArr != null && valFromKeyCode == 0) {
                                boolArr[0] = true;
                            }
                        }
                    }
                    i4 = valFromKeyCode;
                }
            } else {
                int i9 = i + i3;
                if (i7 != i9) {
                    if (i7 == i9 + 1) {
                        i4 += valFromKeyCode * 10;
                        if (boolArr != null && valFromKeyCode == 0) {
                            boolArr[0] = true;
                        }
                    }
                }
                i4 = valFromKeyCode;
            }
        }
        return new int[]{i4, i5, i6, i2};
    }

    private static int getValFromKeyCode(int i) {
        switch (i) {
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 9;
            default:
                return -1;
        }
    }

    private boolean isTypedTimeFullyLegal() {
        if (!this.mIs24HourMode) {
            return this.mTypedTimes.contains(Integer.valueOf(getAmOrPmKeyCode(0))) || this.mTypedTimes.contains(Integer.valueOf(getAmOrPmKeyCode(1)));
        }
        int[] enteredTime = getEnteredTime(new Boolean[]{false, false, false});
        return enteredTime[0] >= 0 && enteredTime[1] >= 0 && enteredTime[1] < 60 && enteredTime[2] >= 0 && enteredTime[2] < 60;
    }

    private boolean isTypedTimeLegalSoFar() {
        Node node = this.mLegalTimesTree;
        Iterator<Integer> it = this.mTypedTimes.iterator();
        while (it.hasNext()) {
            node = node.canReach(it.next().intValue());
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    public static TimePickerDialog newInstance(OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z) {
        TimePickerDialog timePickerDialog = new TimePickerDialog();
        timePickerDialog.initialize(onTimeSetListener, i, i2, i3, z);
        return timePickerDialog;
    }

    public static TimePickerDialog newInstance(OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        return newInstance(onTimeSetListener, i, i2, 0, z);
    }

    public static TimePickerDialog newInstance(OnTimeSetListener onTimeSetListener, boolean z) {
        Calendar calendar = Calendar.getInstance();
        return newInstance(onTimeSetListener, calendar.get(11), calendar.get(12), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processKeyUp(int i) {
        if (i == 61) {
            if (this.mInKbMode) {
                if (isTypedTimeFullyLegal()) {
                    finishKbMode(true);
                }
                return true;
            }
        } else {
            if (i == 66) {
                if (this.mInKbMode) {
                    if (!isTypedTimeFullyLegal()) {
                        return true;
                    }
                    finishKbMode(false);
                }
                OnTimeSetListener onTimeSetListener = this.mCallback;
                if (onTimeSetListener != null) {
                    onTimeSetListener.onTimeSet(this, this.mTimePicker.getHours(), this.mTimePicker.getMinutes(), this.mTimePicker.getSeconds());
                }
                dismiss();
                return true;
            }
            if (i == 67) {
                if (this.mInKbMode && !this.mTypedTimes.isEmpty()) {
                    int deleteLastTypedKey = deleteLastTypedKey();
                    Utils.tryAccessibilityAnnounce(this.mTimePicker, String.format(this.mDeletedKeyFormat, deleteLastTypedKey == getAmOrPmKeyCode(0) ? this.mAmText : deleteLastTypedKey == getAmOrPmKeyCode(1) ? this.mPmText : String.format(this.mLocale, "%d", Integer.valueOf(getValFromKeyCode(deleteLastTypedKey)))));
                    updateDisplay(true);
                }
            } else if (i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || (!this.mIs24HourMode && (i == getAmOrPmKeyCode(0) || i == getAmOrPmKeyCode(1)))) {
                if (this.mInKbMode) {
                    if (addKeyIfLegal(i)) {
                        updateDisplay(false);
                    }
                    return true;
                }
                if (this.mTimePicker == null) {
                    Log.e(TAG, "Unable to initiate keyboard mode, TimePicker was null.");
                    return true;
                }
                this.mTypedTimes.clear();
                tryStartingKbMode(i);
                return true;
            }
        }
        return false;
    }

    private Timepoint roundToNearest(@NonNull Timepoint timepoint) {
        return roundToNearest(timepoint, null);
    }

    private void setCurrentItemShowing(int i, boolean z, boolean z2, boolean z3) {
        TextView textView;
        this.mTimePicker.setCurrentItemShowing(i, z);
        RadialPickerLayout radialPickerLayout = this.mTimePicker;
        if (i == 0) {
            int hours = radialPickerLayout.getHours();
            if (!this.mIs24HourMode) {
                hours %= 12;
            }
            this.mTimePicker.setContentDescription(this.mHourPickerDescription + ": " + hours);
            if (z3) {
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectHours);
            }
            textView = this.mHourView;
        } else if (i != 1) {
            int seconds = radialPickerLayout.getSeconds();
            this.mTimePicker.setContentDescription(this.mSecondPickerDescription + ": " + seconds);
            if (z3) {
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectSeconds);
            }
            textView = this.mSecondView;
        } else {
            int minutes = radialPickerLayout.getMinutes();
            this.mTimePicker.setContentDescription(this.mMinutePickerDescription + ": " + minutes);
            if (z3) {
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectMinutes);
            }
            textView = this.mMinuteView;
        }
        int i2 = i == 0 ? this.mSelectedColor : this.mUnselectedColor;
        int i3 = i == 1 ? this.mSelectedColor : this.mUnselectedColor;
        int i4 = i == 2 ? this.mSelectedColor : this.mUnselectedColor;
        this.mHourView.setTextColor(i2);
        this.mMinuteView.setTextColor(i3);
        this.mSecondView.setTextColor(i4);
        ObjectAnimator pulseAnimator = Utils.getPulseAnimator(textView, 0.85f, 1.1f);
        if (z2) {
            pulseAnimator.setStartDelay(300L);
        }
        pulseAnimator.start();
    }

    private void setHour(int i, boolean z) {
        String str = "%d";
        if (this.mIs24HourMode) {
            str = "%02d";
        } else {
            i %= 12;
            if (i == 0) {
                i = 12;
            }
        }
        String format = String.format(this.mLocale, str, Integer.valueOf(i));
        this.mHourView.setText(format);
        this.mHourSpaceView.setText(format);
        if (z) {
            Utils.tryAccessibilityAnnounce(this.mTimePicker, format);
        }
    }

    private void setMinute(int i) {
        if (i == 60) {
            i = 0;
        }
        String format = String.format(this.mLocale, "%02d", Integer.valueOf(i));
        Utils.tryAccessibilityAnnounce(this.mTimePicker, format);
        this.mMinuteView.setText(format);
        this.mMinuteSpaceView.setText(format);
    }

    private void setSecond(int i) {
        if (i == 60) {
            i = 0;
        }
        String format = String.format(this.mLocale, "%02d", Integer.valueOf(i));
        Utils.tryAccessibilityAnnounce(this.mTimePicker, format);
        this.mSecondView.setText(format);
        this.mSecondSpaceView.setText(format);
    }

    private void tryStartingKbMode(int i) {
        if (this.mTimePicker.trySettingInputEnabled(false)) {
            if (i == -1 || addKeyIfLegal(i)) {
                this.mInKbMode = true;
                this.mOkButton.setEnabled(false);
                updateDisplay(false);
            }
        }
    }

    private void updateAmPmDisplay(int i) {
        TextView textView;
        String str;
        RadialPickerLayout radialPickerLayout;
        String str2;
        if (this.mVersion == Version.VERSION_2) {
            if (i == 0) {
                this.mAmTextView.setTextColor(this.mSelectedColor);
                this.mPmTextView.setTextColor(this.mUnselectedColor);
                radialPickerLayout = this.mTimePicker;
                str2 = this.mAmText;
            } else {
                this.mAmTextView.setTextColor(this.mUnselectedColor);
                this.mPmTextView.setTextColor(this.mSelectedColor);
                radialPickerLayout = this.mTimePicker;
                str2 = this.mPmText;
            }
            Utils.tryAccessibilityAnnounce(radialPickerLayout, str2);
            return;
        }
        if (i == 0) {
            this.mPmTextView.setText(this.mAmText);
            Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mAmText);
            textView = this.mPmTextView;
            str = this.mAmText;
        } else {
            if (i != 1) {
                this.mPmTextView.setText(this.mDoublePlaceholderText);
                return;
            }
            this.mPmTextView.setText(this.mPmText);
            Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mPmText);
            textView = this.mPmTextView;
            str = this.mPmText;
        }
        textView.setContentDescription(str);
    }

    private void updateDisplay(boolean z) {
        if (!z && this.mTypedTimes.isEmpty()) {
            int hours = this.mTimePicker.getHours();
            int minutes = this.mTimePicker.getMinutes();
            int seconds = this.mTimePicker.getSeconds();
            setHour(hours, true);
            setMinute(minutes);
            setSecond(seconds);
            if (!this.mIs24HourMode) {
                updateAmPmDisplay(hours >= 12 ? 1 : 0);
            }
            setCurrentItemShowing(this.mTimePicker.getCurrentItemShowing(), true, true, true);
            this.mOkButton.setEnabled(true);
            return;
        }
        Boolean[] boolArr = {false, false, false};
        int[] enteredTime = getEnteredTime(boolArr);
        String str = boolArr[0].booleanValue() ? "%02d" : "%2d";
        String str2 = boolArr[1].booleanValue() ? "%02d" : "%2d";
        String str3 = boolArr[1].booleanValue() ? "%02d" : "%2d";
        String replace = enteredTime[0] == -1 ? this.mDoublePlaceholderText : String.format(str, Integer.valueOf(enteredTime[0])).replace(' ', this.mPlaceholderText);
        String replace2 = enteredTime[1] == -1 ? this.mDoublePlaceholderText : String.format(str2, Integer.valueOf(enteredTime[1])).replace(' ', this.mPlaceholderText);
        String replace3 = enteredTime[2] == -1 ? this.mDoublePlaceholderText : String.format(str3, Integer.valueOf(enteredTime[1])).replace(' ', this.mPlaceholderText);
        this.mHourView.setText(replace);
        this.mHourSpaceView.setText(replace);
        this.mHourView.setTextColor(this.mUnselectedColor);
        this.mMinuteView.setText(replace2);
        this.mMinuteSpaceView.setText(replace2);
        this.mMinuteView.setTextColor(this.mUnselectedColor);
        this.mSecondView.setText(replace3);
        this.mSecondSpaceView.setText(replace3);
        this.mSecondView.setTextColor(this.mUnselectedColor);
        if (this.mIs24HourMode) {
            return;
        }
        updateAmPmDisplay(enteredTime[3]);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.OnValueSelectedListener
    public void advancePicker(int i) {
        StringBuilder sb;
        int seconds;
        if (this.mAllowAutoAdvance) {
            if (i == 0 && this.mEnableMinutes) {
                setCurrentItemShowing(1, true, true, false);
                sb = new StringBuilder();
                sb.append(this.mSelectHours);
                sb.append(". ");
                seconds = this.mTimePicker.getMinutes();
            } else {
                if (i != 1 || !this.mEnableSeconds) {
                    return;
                }
                setCurrentItemShowing(2, true, true, false);
                sb = new StringBuilder();
                sb.append(this.mSelectMinutes);
                sb.append(". ");
                seconds = this.mTimePicker.getSeconds();
            }
            sb.append(seconds);
            Utils.tryAccessibilityAnnounce(this.mTimePicker, sb.toString());
        }
    }

    public /* synthetic */ void b(View view) {
        setCurrentItemShowing(0, true, false, true);
        tryVibrate();
    }

    public /* synthetic */ void c(View view) {
        setCurrentItemShowing(1, true, false, true);
        tryVibrate();
    }

    public /* synthetic */ void d(View view) {
        setCurrentItemShowing(2, true, false, true);
        tryVibrate();
    }

    public void dismissOnPause(boolean z) {
        this.mDismissOnPause = z;
    }

    public /* synthetic */ void e(View view) {
        if (this.mInKbMode && isTypedTimeFullyLegal()) {
            finishKbMode(false);
        } else {
            tryVibrate();
        }
        notifyOnDateListener();
        dismiss();
    }

    public void enableMinutes(boolean z) {
        if (!z) {
            this.mEnableSeconds = false;
        }
        this.mEnableMinutes = z;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.OnValueSelectedListener
    public void enablePicker() {
        if (!isTypedTimeFullyLegal()) {
            this.mTypedTimes.clear();
        }
        finishKbMode(true);
    }

    public void enableSeconds(boolean z) {
        if (z) {
            this.mEnableMinutes = true;
        }
        this.mEnableSeconds = z;
    }

    public /* synthetic */ void f(View view) {
        tryVibrate();
        if (getDialog() != null) {
            getDialog().cancel();
        }
    }

    public /* synthetic */ void g(View view) {
        if (isAmDisabled() || isPmDisabled()) {
            return;
        }
        tryVibrate();
        int isCurrentlyAmOrPm = this.mTimePicker.getIsCurrentlyAmOrPm();
        if (isCurrentlyAmOrPm == 0) {
            isCurrentlyAmOrPm = 1;
        } else if (isCurrentlyAmOrPm == 1) {
            isCurrentlyAmOrPm = 0;
        }
        this.mTimePicker.setAmOrPm(isCurrentlyAmOrPm);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public int getAccentColor() {
        return this.mAccentColor;
    }

    public OnTimeSetListener getOnTimeSetListener() {
        return this.mCallback;
    }

    public Timepoint getSelectedTime() {
        return this.mTimePicker.getTime();
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public Version getVersion() {
        return this.mVersion;
    }

    public void initialize(OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z) {
        this.mCallback = onTimeSetListener;
        this.mInitialTime = new Timepoint(i, i2, i3);
        this.mIs24HourMode = z;
        this.mInKbMode = false;
        this.mTitle = "";
        this.mThemeDark = false;
        this.mThemeDarkChanged = false;
        this.mAccentColor = -1;
        this.mVibrate = true;
        this.mDismissOnPause = false;
        this.mEnableSeconds = false;
        this.mEnableMinutes = true;
        this.mOkResid = R.string.mdtp_ok;
        this.mOkColor = -1;
        this.mCancelResid = R.string.mdtp_cancel;
        this.mCancelColor = -1;
        this.mVersion = Build.VERSION.SDK_INT < 23 ? Version.VERSION_1 : Version.VERSION_2;
        this.mTimePicker = null;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean is24HourMode() {
        return this.mIs24HourMode;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isAmDisabled() {
        return this.mLimiter.isAmDisabled();
    }

    public boolean isOutOfRange(Timepoint timepoint) {
        return isOutOfRange(timepoint, 2);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isOutOfRange(Timepoint timepoint, int i) {
        return this.mLimiter.isOutOfRange(timepoint, i, y());
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isPmDisabled() {
        return this.mLimiter.isPmDisabled();
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isThemeDark() {
        return this.mThemeDark;
    }

    public void notifyOnDateListener() {
        OnTimeSetListener onTimeSetListener = this.mCallback;
        if (onTimeSetListener != null) {
            onTimeSetListener.onTimeSet(this, this.mTimePicker.getHours(), this.mTimePicker.getMinutes(), this.mTimePicker.getSeconds());
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
        setStyle(1, 0);
        if (bundle != null && bundle.containsKey(KEY_INITIAL_TIME) && bundle.containsKey(KEY_IS_24_HOUR_VIEW)) {
            this.mInitialTime = (Timepoint) bundle.getParcelable(KEY_INITIAL_TIME);
            this.mIs24HourMode = bundle.getBoolean(KEY_IS_24_HOUR_VIEW);
            this.mInKbMode = bundle.getBoolean(KEY_IN_KB_MODE);
            this.mTitle = bundle.getString(KEY_TITLE);
            this.mThemeDark = bundle.getBoolean(KEY_THEME_DARK);
            this.mThemeDarkChanged = bundle.getBoolean(KEY_THEME_DARK_CHANGED);
            this.mAccentColor = bundle.getInt(KEY_ACCENT);
            this.mVibrate = bundle.getBoolean(KEY_VIBRATE);
            this.mDismissOnPause = bundle.getBoolean(KEY_DISMISS);
            this.mEnableSeconds = bundle.getBoolean(KEY_ENABLE_SECONDS);
            this.mEnableMinutes = bundle.getBoolean(KEY_ENABLE_MINUTES);
            this.mOkResid = bundle.getInt(KEY_OK_RESID);
            this.mOkString = bundle.getString(KEY_OK_STRING);
            this.mOkColor = bundle.getInt(KEY_OK_COLOR);
            this.mCancelResid = bundle.getInt(KEY_CANCEL_RESID);
            this.mCancelString = bundle.getString(KEY_CANCEL_STRING);
            this.mCancelColor = bundle.getInt(KEY_CANCEL_COLOR);
            this.mVersion = (Version) bundle.getSerializable(KEY_VERSION);
            this.mLimiter = (TimepointLimiter) bundle.getParcelable(KEY_TIMEPOINTLIMITER);
            this.mLocale = (Locale) bundle.getSerializable(KEY_LOCALE);
            TimepointLimiter timepointLimiter = this.mLimiter;
            this.mDefaultLimiter = timepointLimiter instanceof DefaultTimepointLimiter ? (DefaultTimepointLimiter) timepointLimiter : new DefaultTimepointLimiter();
        }
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
        RelativeLayout.LayoutParams layoutParams;
        TextView textView;
        RelativeLayout.LayoutParams layoutParams2;
        int i;
        View inflate = layoutInflater.inflate(this.mVersion == Version.VERSION_1 ? R.layout.mdtp_time_picker_dialog : R.layout.mdtp_time_picker_dialog_v2, viewGroup, false);
        KeyboardListener keyboardListener = new KeyboardListener();
        inflate.findViewById(R.id.mdtp_time_picker_dialog).setOnKeyListener(keyboardListener);
        if (this.mAccentColor == -1) {
            this.mAccentColor = Utils.getAccentColorFromThemeIfAvailable(getActivity());
        }
        if (!this.mThemeDarkChanged) {
            this.mThemeDark = Utils.isDarkTheme(getActivity(), this.mThemeDark);
        }
        Resources resources = getResources();
        FragmentActivity requireActivity = requireActivity();
        this.mHourPickerDescription = resources.getString(R.string.mdtp_hour_picker_description);
        this.mSelectHours = resources.getString(R.string.mdtp_select_hours);
        this.mMinutePickerDescription = resources.getString(R.string.mdtp_minute_picker_description);
        this.mSelectMinutes = resources.getString(R.string.mdtp_select_minutes);
        this.mSecondPickerDescription = resources.getString(R.string.mdtp_second_picker_description);
        this.mSelectSeconds = resources.getString(R.string.mdtp_select_seconds);
        this.mSelectedColor = ContextCompat.getColor(requireActivity, R.color.mdtp_white);
        this.mUnselectedColor = ContextCompat.getColor(requireActivity, R.color.mdtp_accent_color_focused);
        this.mHourView = (TextView) inflate.findViewById(R.id.mdtp_hours);
        this.mHourView.setOnKeyListener(keyboardListener);
        this.mHourSpaceView = (TextView) inflate.findViewById(R.id.mdtp_hour_space);
        this.mMinuteSpaceView = (TextView) inflate.findViewById(R.id.mdtp_minutes_space);
        this.mMinuteView = (TextView) inflate.findViewById(R.id.mdtp_minutes);
        this.mMinuteView.setOnKeyListener(keyboardListener);
        this.mSecondSpaceView = (TextView) inflate.findViewById(R.id.mdtp_seconds_space);
        this.mSecondView = (TextView) inflate.findViewById(R.id.mdtp_seconds);
        this.mSecondView.setOnKeyListener(keyboardListener);
        this.mAmTextView = (TextView) inflate.findViewById(R.id.mdtp_am_label);
        this.mAmTextView.setOnKeyListener(keyboardListener);
        this.mPmTextView = (TextView) inflate.findViewById(R.id.mdtp_pm_label);
        this.mPmTextView.setOnKeyListener(keyboardListener);
        this.mAmPmLayout = inflate.findViewById(R.id.mdtp_ampm_layout);
        String[] amPmStrings = new DateFormatSymbols(this.mLocale).getAmPmStrings();
        this.mAmText = amPmStrings[0];
        this.mPmText = amPmStrings[1];
        this.mHapticFeedbackController = new HapticFeedbackController(getActivity());
        RadialPickerLayout radialPickerLayout = this.mTimePicker;
        if (radialPickerLayout != null) {
            this.mInitialTime = new Timepoint(radialPickerLayout.getHours(), this.mTimePicker.getMinutes(), this.mTimePicker.getSeconds());
        }
        this.mInitialTime = roundToNearest(this.mInitialTime);
        this.mTimePicker = (RadialPickerLayout) inflate.findViewById(R.id.mdtp_time_picker);
        this.mTimePicker.setOnValueSelectedListener(this);
        this.mTimePicker.setOnKeyListener(keyboardListener);
        this.mTimePicker.initialize(getActivity(), this.mLocale, this, this.mInitialTime, this.mIs24HourMode);
        setCurrentItemShowing((bundle == null || !bundle.containsKey(KEY_CURRENT_ITEM_SHOWING)) ? 0 : bundle.getInt(KEY_CURRENT_ITEM_SHOWING), false, true, true);
        this.mTimePicker.invalidate();
        this.mHourView.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerDialog.this.b(view);
            }
        });
        this.mMinuteView.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerDialog.this.c(view);
            }
        });
        this.mSecondView.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerDialog.this.d(view);
            }
        });
        this.mOkButton = (Button) inflate.findViewById(R.id.mdtp_ok);
        this.mOkButton.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerDialog.this.e(view);
            }
        });
        this.mOkButton.setOnKeyListener(keyboardListener);
        this.mOkButton.setTypeface(ResourcesCompat.getFont(requireActivity, R.font.robotomedium));
        String str = this.mOkString;
        if (str != null) {
            this.mOkButton.setText(str);
        } else {
            this.mOkButton.setText(this.mOkResid);
        }
        this.mCancelButton = (Button) inflate.findViewById(R.id.mdtp_cancel);
        this.mCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerDialog.this.f(view);
            }
        });
        this.mCancelButton.setTypeface(ResourcesCompat.getFont(requireActivity, R.font.robotomedium));
        String str2 = this.mCancelString;
        if (str2 != null) {
            this.mCancelButton.setText(str2);
        } else {
            this.mCancelButton.setText(this.mCancelResid);
        }
        this.mCancelButton.setVisibility(isCancelable() ? 0 : 8);
        if (this.mIs24HourMode) {
            this.mAmPmLayout.setVisibility(8);
        } else {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimePickerDialog.this.g(view);
                }
            };
            this.mAmTextView.setVisibility(8);
            this.mPmTextView.setVisibility(0);
            this.mAmPmLayout.setOnClickListener(onClickListener);
            if (this.mVersion == Version.VERSION_2) {
                this.mAmTextView.setText(this.mAmText);
                this.mPmTextView.setText(this.mPmText);
                this.mAmTextView.setVisibility(0);
            }
            updateAmPmDisplay(!this.mInitialTime.isAM() ? 1 : 0);
        }
        if (!this.mEnableSeconds) {
            this.mSecondView.setVisibility(8);
            inflate.findViewById(R.id.mdtp_separator_seconds).setVisibility(8);
        }
        if (!this.mEnableMinutes) {
            this.mMinuteSpaceView.setVisibility(8);
            inflate.findViewById(R.id.mdtp_separator).setVisibility(8);
        }
        if (getResources().getConfiguration().orientation == 2) {
            if (!this.mEnableMinutes && !this.mEnableSeconds) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(2, R.id.mdtp_center_view);
                layoutParams3.addRule(14);
                this.mHourSpaceView.setLayoutParams(layoutParams3);
                if (this.mIs24HourMode) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(1, R.id.mdtp_hour_space);
                }
            } else if (this.mEnableSeconds || !this.mIs24HourMode) {
                if (!this.mEnableSeconds) {
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(14);
                    layoutParams4.addRule(2, R.id.mdtp_center_view);
                    ((TextView) inflate.findViewById(R.id.mdtp_separator)).setLayoutParams(layoutParams4);
                    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(13);
                    i = R.id.mdtp_center_view;
                } else if (this.mIs24HourMode) {
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams5.addRule(14);
                    layoutParams5.addRule(2, R.id.mdtp_seconds_space);
                    ((TextView) inflate.findViewById(R.id.mdtp_separator)).setLayoutParams(layoutParams5);
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    textView = this.mSecondSpaceView;
                    textView.setLayoutParams(layoutParams);
                } else {
                    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams6.addRule(13);
                    this.mSecondSpaceView.setLayoutParams(layoutParams6);
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams7.addRule(14);
                    layoutParams7.addRule(2, R.id.mdtp_seconds_space);
                    ((TextView) inflate.findViewById(R.id.mdtp_separator)).setLayoutParams(layoutParams7);
                    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(14);
                    i = R.id.mdtp_seconds_space;
                }
                layoutParams2.addRule(3, i);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(14);
                layoutParams.addRule(2, R.id.mdtp_center_view);
                textView = (TextView) inflate.findViewById(R.id.mdtp_separator);
                textView.setLayoutParams(layoutParams);
            }
            this.mAmPmLayout.setLayoutParams(layoutParams2);
        } else if (this.mIs24HourMode && !this.mEnableSeconds && this.mEnableMinutes) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            textView = (TextView) inflate.findViewById(R.id.mdtp_separator);
            textView.setLayoutParams(layoutParams);
        } else if (!this.mEnableMinutes && !this.mEnableSeconds) {
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams8.addRule(13);
            this.mHourSpaceView.setLayoutParams(layoutParams8);
            if (!this.mIs24HourMode) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(1, R.id.mdtp_hour_space);
                layoutParams2.addRule(4, R.id.mdtp_hour_space);
                this.mAmPmLayout.setLayoutParams(layoutParams2);
            }
        } else if (this.mEnableSeconds) {
            View findViewById = inflate.findViewById(R.id.mdtp_separator);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams9.addRule(0, R.id.mdtp_minutes_space);
            layoutParams9.addRule(15, -1);
            findViewById.setLayoutParams(layoutParams9);
            if (this.mIs24HourMode) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(1, R.id.mdtp_center_view);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
            }
            textView = this.mMinuteSpaceView;
            textView.setLayoutParams(layoutParams);
        }
        this.mAllowAutoAdvance = true;
        setHour(this.mInitialTime.getHour(), true);
        setMinute(this.mInitialTime.getMinute());
        setSecond(this.mInitialTime.getSecond());
        this.mDoublePlaceholderText = resources.getString(R.string.mdtp_time_placeholder);
        this.mDeletedKeyFormat = resources.getString(R.string.mdtp_deleted_key);
        this.mPlaceholderText = this.mDoublePlaceholderText.charAt(0);
        this.mPmKeyCode = -1;
        this.mAmKeyCode = -1;
        generateLegalTimesTree();
        if (this.mInKbMode && bundle != null) {
            this.mTypedTimes = bundle.getIntegerArrayList(KEY_TYPED_TIMES);
            tryStartingKbMode(-1);
            this.mHourView.invalidate();
        } else if (this.mTypedTimes == null) {
            this.mTypedTimes = new ArrayList<>();
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.mdtp_time_picker_header);
        if (!this.mTitle.isEmpty()) {
            textView2.setVisibility(0);
            textView2.setText(this.mTitle);
        }
        textView2.setBackgroundColor(Utils.darkenColor(this.mAccentColor));
        inflate.findViewById(R.id.mdtp_time_display_background).setBackgroundColor(this.mAccentColor);
        inflate.findViewById(R.id.mdtp_time_display).setBackgroundColor(this.mAccentColor);
        int i2 = this.mOkColor;
        if (i2 != -1) {
            this.mOkButton.setTextColor(i2);
        } else {
            this.mOkButton.setTextColor(this.mAccentColor);
        }
        int i3 = this.mCancelColor;
        if (i3 != -1) {
            this.mCancelButton.setTextColor(i3);
        } else {
            this.mCancelButton.setTextColor(this.mAccentColor);
        }
        if (getDialog() == null) {
            inflate.findViewById(R.id.mdtp_done_background).setVisibility(8);
        }
        int color = ContextCompat.getColor(requireActivity, R.color.mdtp_circle_background);
        int color2 = ContextCompat.getColor(requireActivity, R.color.mdtp_background_color);
        int color3 = ContextCompat.getColor(requireActivity, R.color.mdtp_light_gray);
        int color4 = ContextCompat.getColor(requireActivity, R.color.mdtp_light_gray);
        RadialPickerLayout radialPickerLayout2 = this.mTimePicker;
        if (this.mThemeDark) {
            color = color4;
        }
        radialPickerLayout2.setBackgroundColor(color);
        View findViewById2 = inflate.findViewById(R.id.mdtp_time_picker_dialog);
        if (this.mThemeDark) {
            color2 = color3;
        }
        findViewById2.setBackgroundColor(color2);
        return inflate;
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
        RadialPickerLayout radialPickerLayout = this.mTimePicker;
        if (radialPickerLayout != null) {
            bundle.putParcelable(KEY_INITIAL_TIME, radialPickerLayout.getTime());
            bundle.putBoolean(KEY_IS_24_HOUR_VIEW, this.mIs24HourMode);
            bundle.putInt(KEY_CURRENT_ITEM_SHOWING, this.mTimePicker.getCurrentItemShowing());
            bundle.putBoolean(KEY_IN_KB_MODE, this.mInKbMode);
            if (this.mInKbMode) {
                bundle.putIntegerArrayList(KEY_TYPED_TIMES, this.mTypedTimes);
            }
            bundle.putString(KEY_TITLE, this.mTitle);
            bundle.putBoolean(KEY_THEME_DARK, this.mThemeDark);
            bundle.putBoolean(KEY_THEME_DARK_CHANGED, this.mThemeDarkChanged);
            bundle.putInt(KEY_ACCENT, this.mAccentColor);
            bundle.putBoolean(KEY_VIBRATE, this.mVibrate);
            bundle.putBoolean(KEY_DISMISS, this.mDismissOnPause);
            bundle.putBoolean(KEY_ENABLE_SECONDS, this.mEnableSeconds);
            bundle.putBoolean(KEY_ENABLE_MINUTES, this.mEnableMinutes);
            bundle.putInt(KEY_OK_RESID, this.mOkResid);
            bundle.putString(KEY_OK_STRING, this.mOkString);
            bundle.putInt(KEY_OK_COLOR, this.mOkColor);
            bundle.putInt(KEY_CANCEL_RESID, this.mCancelResid);
            bundle.putString(KEY_CANCEL_STRING, this.mCancelString);
            bundle.putInt(KEY_CANCEL_COLOR, this.mCancelColor);
            bundle.putSerializable(KEY_VERSION, this.mVersion);
            bundle.putParcelable(KEY_TIMEPOINTLIMITER, this.mLimiter);
            bundle.putSerializable(KEY_LOCALE, this.mLocale);
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.OnValueSelectedListener
    public void onValueSelected(Timepoint timepoint) {
        setHour(timepoint.getHour(), false);
        this.mTimePicker.setContentDescription(this.mHourPickerDescription + ": " + timepoint.getHour());
        setMinute(timepoint.getMinute());
        this.mTimePicker.setContentDescription(this.mMinutePickerDescription + ": " + timepoint.getMinute());
        setSecond(timepoint.getSecond());
        this.mTimePicker.setContentDescription(this.mSecondPickerDescription + ": " + timepoint.getSecond());
        if (this.mIs24HourMode) {
            return;
        }
        updateAmPmDisplay(!timepoint.isAM() ? 1 : 0);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public Timepoint roundToNearest(@NonNull Timepoint timepoint, @Nullable Timepoint.TYPE type) {
        return this.mLimiter.roundToNearest(timepoint, type, y());
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

    public void setDisabledTimes(Timepoint[] timepointArr) {
        this.mDefaultLimiter.a(timepointArr);
    }

    public void setInitialSelection(int i, int i2) {
        setInitialSelection(i, i2, 0);
    }

    public void setInitialSelection(int i, int i2, int i3) {
        setInitialSelection(new Timepoint(i, i2, i3));
    }

    public void setInitialSelection(Timepoint timepoint) {
        this.mInitialTime = roundToNearest(timepoint);
        this.mInKbMode = false;
    }

    public void setLocale(Locale locale) {
        this.mLocale = locale;
    }

    public void setMaxTime(int i, int i2, int i3) {
        setMaxTime(new Timepoint(i, i2, i3));
    }

    public void setMaxTime(Timepoint timepoint) {
        this.mDefaultLimiter.a(timepoint);
    }

    public void setMinTime(int i, int i2, int i3) {
        setMinTime(new Timepoint(i, i2, i3));
    }

    public void setMinTime(Timepoint timepoint) {
        this.mDefaultLimiter.b(timepoint);
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

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnTimeSetListener(OnTimeSetListener onTimeSetListener) {
        this.mCallback = onTimeSetListener;
    }

    public void setSelectableTimes(Timepoint[] timepointArr) {
        this.mDefaultLimiter.b(timepointArr);
    }

    @Deprecated
    public void setStartTime(int i, int i2) {
        setStartTime(i, i2, 0);
    }

    @Deprecated
    public void setStartTime(int i, int i2, int i3) {
        this.mInitialTime = roundToNearest(new Timepoint(i, i2, i3));
        this.mInKbMode = false;
    }

    public void setThemeDark(boolean z) {
        this.mThemeDark = z;
        this.mThemeDarkChanged = true;
    }

    public void setTimeInterval(@IntRange(from = 1, to = 24) int i) {
        setTimeInterval(i, 60);
    }

    public void setTimeInterval(@IntRange(from = 1, to = 24) int i, @IntRange(from = 1, to = 60) int i2) {
        setTimeInterval(i, i2, 60);
    }

    public void setTimeInterval(@IntRange(from = 1, to = 24) int i, @IntRange(from = 1, to = 60) int i2, @IntRange(from = 1, to = 60) int i3) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < 24) {
            int i5 = 0;
            while (i5 < 60) {
                int i6 = 0;
                while (i6 < 60) {
                    arrayList.add(new Timepoint(i4, i5, i6));
                    i6 += i3;
                }
                i5 += i2;
            }
            i4 += i;
        }
        setSelectableTimes((Timepoint[]) arrayList.toArray(new Timepoint[arrayList.size()]));
    }

    public void setTimepointLimiter(TimepointLimiter timepointLimiter) {
        this.mLimiter = timepointLimiter;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVersion(Version version) {
        this.mVersion = version;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public void tryVibrate() {
        if (this.mVibrate) {
            this.mHapticFeedbackController.tryVibrate();
        }
    }

    public void vibrate(boolean z) {
        this.mVibrate = z;
    }

    @NonNull
    Timepoint.TYPE y() {
        return this.mEnableSeconds ? Timepoint.TYPE.SECOND : this.mEnableMinutes ? Timepoint.TYPE.MINUTE : Timepoint.TYPE.HOUR;
    }
}
