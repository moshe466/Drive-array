package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    Context a;
    String b;
    Intent[] c;
    ComponentName d;
    CharSequence e;
    CharSequence f;
    CharSequence g;
    IconCompat h;
    boolean i;
    Person[] j;
    Set<String> k;
    boolean l;

    /* loaded from: classes.dex */
    public static class Builder {
        private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            shortcutInfoCompat.a = context;
            shortcutInfoCompat.b = shortcutInfo.getId();
            Intent[] intents = shortcutInfo.getIntents();
            this.mInfo.c = (Intent[]) Arrays.copyOf(intents, intents.length);
            this.mInfo.d = shortcutInfo.getActivity();
            this.mInfo.e = shortcutInfo.getShortLabel();
            this.mInfo.f = shortcutInfo.getLongLabel();
            this.mInfo.g = shortcutInfo.getDisabledMessage();
            this.mInfo.k = shortcutInfo.getCategories();
            this.mInfo.j = ShortcutInfoCompat.a(shortcutInfo.getExtras());
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            shortcutInfoCompat.a = context;
            shortcutInfoCompat.b = str;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = this.mInfo;
            shortcutInfoCompat2.a = shortcutInfoCompat.a;
            shortcutInfoCompat2.b = shortcutInfoCompat.b;
            Intent[] intentArr = shortcutInfoCompat.c;
            shortcutInfoCompat2.c = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            ShortcutInfoCompat shortcutInfoCompat3 = this.mInfo;
            shortcutInfoCompat3.d = shortcutInfoCompat.d;
            shortcutInfoCompat3.e = shortcutInfoCompat.e;
            shortcutInfoCompat3.f = shortcutInfoCompat.f;
            shortcutInfoCompat3.g = shortcutInfoCompat.g;
            shortcutInfoCompat3.h = shortcutInfoCompat.h;
            shortcutInfoCompat3.i = shortcutInfoCompat.i;
            shortcutInfoCompat3.l = shortcutInfoCompat.l;
            Person[] personArr = shortcutInfoCompat.j;
            if (personArr != null) {
                shortcutInfoCompat3.j = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            Set<String> set = shortcutInfoCompat.k;
            if (set != null) {
                this.mInfo.k = new HashSet(set);
            }
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.e)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            Intent[] intentArr = shortcutInfoCompat.c;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            return shortcutInfoCompat;
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            this.mInfo.d = componentName;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.mInfo.i = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            this.mInfo.k = set;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            this.mInfo.g = charSequence;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.h = iconCompat;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            this.mInfo.c = intentArr;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            this.mInfo.f = charSequence;
            return this;
        }

        @NonNull
        public Builder setLongLived() {
            this.mInfo.l = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            return setPersons(new Person[]{person});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            this.mInfo.j = personArr;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            this.mInfo.e = charSequence;
            return this;
        }
    }

    ShortcutInfoCompat() {
    }

    @VisibleForTesting
    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static Person[] a(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int i = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        Person[] personArr = new Person[i];
        int i2 = 0;
        while (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append(EXTRA_PERSON_);
            int i3 = i2 + 1;
            sb.append(i3);
            personArr[i2] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb.toString()));
            i2 = i3;
        }
        return personArr;
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildExtrasBundle() {
        PersistableBundle persistableBundle = new PersistableBundle();
        Person[] personArr = this.j;
        if (personArr != null && personArr.length > 0) {
            persistableBundle.putInt(EXTRA_PERSON_COUNT, personArr.length);
            int i = 0;
            while (i < this.j.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(EXTRA_PERSON_);
                int i2 = i + 1;
                sb.append(i2);
                persistableBundle.putPersistableBundle(sb.toString(), this.j[i].toPersistableBundle());
                i = i2;
            }
        }
        persistableBundle.putBoolean(EXTRA_LONG_LIVED, this.l);
        return persistableBundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent a(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.c[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.e.toString());
        if (this.h != null) {
            Drawable drawable = null;
            if (this.i) {
                PackageManager packageManager = this.a.getPackageManager();
                ComponentName componentName = this.d;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.h.addToShortcutIntent(intent, drawable, this.a);
        }
        return intent;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.d;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.k;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.h;
    }

    @NonNull
    public String getId() {
        return this.b;
    }

    @NonNull
    public Intent getIntent() {
        return this.c[r0.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] intentArr = this.c;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.f;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.e;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.a, this.b).setShortLabel(this.e).setIntents(this.c);
        IconCompat iconCompat = this.h;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon());
        }
        if (!TextUtils.isEmpty(this.f)) {
            intents.setLongLabel(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            intents.setDisabledMessage(this.g);
        }
        ComponentName componentName = this.d;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.k;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setExtras(buildExtrasBundle());
        return intents.build();
    }
}
