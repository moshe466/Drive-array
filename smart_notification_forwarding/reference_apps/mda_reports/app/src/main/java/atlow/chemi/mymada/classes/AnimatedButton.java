package atlow.chemi.mymada.classes;

/* loaded from: classes.dex */
interface AnimatedButton {
    void dispose();

    void resetProgress();

    void revertAnimation();

    void revertAnimation(OnAnimationEndListener onAnimationEndListener);

    void setProgress(int i);

    void startAnimation();
}
