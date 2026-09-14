# העברת התראות חכמה (Smart Notification Forwarding)

פרויקט זה כולל את אפליקציית הליבה של **Live Caption** (`com.samsung.android.six.livecaption`) וכן את קוד המקור, השירותים והמשאבים המלאים של אפליקציות החירום, הכוננים והדיווחים:

## אפליקציות בפרויקט
1. **Live Caption (פרויקט ראשי)**:
   - חבילה: `com.samsung.android.six.livecaption`
   - ממוקם ב: `app/`
2. **איחוד הצלה (United Hatzalah - גרסה 1.4.1)**:
   - חבילה: `com.uh.sf` (גרסה `1.4.1`, קוד גרסה `95`)
   - ממוקם ב: `reference_apps/united_hatzalah_1.4.1/`
3. **מערך הכוננים הלאומי מד"א (National Responders MDA - גרסה 13.2.0)**:
   - חבילה: `il.org.mda.health` (גרסה `13.2.0`, קוד גרסה `11500`)
   - ממוקם ב: `reference_apps/national_responders_mda_13.2.0/`
4. **דיווחי מגן דוד אדום (MDA Reports - גרסה 3.5.7)**:
   - חבילה: `atlow.chemi.mymada` (גרסה `3.5.7`, קוד גרסה `12822`)
   - ממוקם ב: `reference_apps/mda_reports/`

## מבנה התיקיות
- **`app/`**: פרויקט Live Caption המרכזי.
- **`reference_apps/`**: קודי המקור המפורקים, המשאבים, המודלים והשירותים של אפליקציות הכוננים והדיווחים.
- **`../extracted_apks/`**: קובצי ה-APK המקוריים שנמשכו מהמכשיר ומהמחשב.
