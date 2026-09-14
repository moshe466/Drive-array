# הגדרות חתימה וגרסאות - פרויקט העברת התראות חכמה

## פרטי חתימה (Signing Configuration)
- **Store File**: `responder_key.jks` (נמצא בנתיב הראשי של הפרויקט)
- **Key Alias**: `responder_key`
- **Store Password**: `Navnzrjh12!@`
- **Key Password**: `Navnzrjh12!@`
- **הערה**: הגדרות וסיסמת החתימה תקפות גם עבור אפליקציית מערך הכוננים הלאומי.

## חוקי גרסאות לגוגל פליי (Google Play Release Versioning Rules)
- **גרסת בסיס קודמת**: `versionCode: 3022` | `versionName: "1.4.19"`
- **כלל קבוע**: בכל שינוי גרסה / בילד שנעשה באפליקציית העברת ההתראה החכמה לצורך העלאה ל-Google Play, ה-`versionCode` וה-`versionName` יהיו **תמיד לפחות אחד מעל גרסה זו**:
  - גרסת הבילד הבאה: `versionCode = 3023` (או ערך גבוה יותר במידה ונוספו גרסאות)
  - שם הגרסה הבאה: `versionName = "1.4.20"` (או לפי סכמת הגרסאות הרלוונטית)
  - **אין להוריד או להשתמש ב-versionCode נמוך מ-3023 בעת הכנת חבילת Release / AAB / APK להעלאה.**
