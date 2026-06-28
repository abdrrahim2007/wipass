package a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class gb implements ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources.Theme f93a;
    public final Resources b;
    public final ga c;
    public final int d;
    public Object e;

    public gb(Resources.Theme theme, Resources resources, ga gaVar, int i) {
        this.f93a = theme;
        this.b = resources;
        this.c = gaVar;
        this.d = i;
    }

    @Override // a.ew
    public final Class a() {
        switch (this.c.f92a) {
            case 0:
                return AssetFileDescriptor.class;
            case 1:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    @Override // a.ew
    public final void b() {
        Object obj = this.e;
        if (obj != null) {
            try {
                switch (this.c.f92a) {
                    case 0:
                        ((AssetFileDescriptor) obj).close();
                        break;
                    case 1:
                        break;
                    default:
                        ((InputStream) obj).close();
                        break;
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // a.ew
    public final int e() {
        return 1;
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) {
        Object objOpenRawResourceFd;
        try {
            ga gaVar = this.c;
            Resources.Theme theme = this.f93a;
            Resources resources = this.b;
            int i = this.d;
            switch (gaVar.f92a) {
                case 0:
                    objOpenRawResourceFd = resources.openRawResourceFd(i);
                    break;
                case 1:
                    Context context = gaVar.b;
                    objOpenRawResourceFd = mk.j(context, context, i, theme);
                    break;
                default:
                    objOpenRawResourceFd = resources.openRawResource(i);
                    break;
            }
            this.e = objOpenRawResourceFd;
            evVar.d(objOpenRawResourceFd);
        } catch (Resources.NotFoundException e) {
            evVar.c(e);
        }
    }

    @Override // a.ew
    public final void cancel() {
    }
}
