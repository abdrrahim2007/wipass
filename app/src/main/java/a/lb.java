package a;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class lb implements Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f162a;
    public boolean b = true;

    public lb(Appendable appendable) {
        this.f162a = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) throws IOException {
        boolean z = this.b;
        Appendable appendable = this.f162a;
        if (z) {
            this.b = false;
            appendable.append("  ");
        }
        this.b = c == '\n';
        appendable.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) throws IOException {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z = this.b;
        Appendable appendable = this.f162a;
        boolean z2 = false;
        if (z) {
            this.b = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
            z2 = true;
        }
        this.b = z2;
        appendable.append(charSequence, i, i2);
        return this;
    }
}
