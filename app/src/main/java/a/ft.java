package a;

import android.app.Person;
import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ft {
    public static /* bridge */ /* synthetic */ Person g(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ Person h(Object obj) {
        return (Person) obj;
    }

    public static /* synthetic */ PrecomputedText.Params.Builder o(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ PrecomputedText r(Object obj) {
        return (PrecomputedText) obj;
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj) {
        return obj instanceof PrecomputedText;
    }
}
