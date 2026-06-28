package a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class sk implements si {
    public static final qt b = new qt("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme", null, qt.e);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f282a;

    public sk(Context context) {
        this.f282a = context.getApplicationContext();
    }

    @Override // a.si
    public final /* bridge */ /* synthetic */ sf a(Object obj, int i, int i2, qu quVar) {
        return c((Uri) obj, quVar);
    }

    @Override // a.si
    public final boolean b(Object obj, qu quVar) {
        String scheme = ((Uri) obj).getScheme();
        return scheme != null && scheme.equals("android.resource");
    }

    public final sf c(Uri uri, qu quVar) {
        Context contextCreatePackageContext;
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalStateException("Package name for " + uri + " is null or empty");
        }
        Context context = this.f282a;
        if (authority.equals(context.getPackageName())) {
            contextCreatePackageContext = context;
        } else {
            try {
                contextCreatePackageContext = context.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (!authority.contains(context.getPackageName())) {
                    throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
                }
                contextCreatePackageContext = context;
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            identifier = contextCreatePackageContext.getResources().getIdentifier(str2, str, authority2);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier == 0) {
                throw new IllegalArgumentException("Failed to find resource id for: " + uri);
            }
        } else {
            if (pathSegments.size() != 1) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
            }
            try {
                identifier = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
            }
        }
        Resources.Theme theme = authority.equals(context.getPackageName()) ? (Resources.Theme) quVar.c(b) : null;
        Drawable drawableJ = theme == null ? mk.j(context, contextCreatePackageContext, identifier, null) : mk.j(context, context, identifier, theme);
        if (drawableJ != null) {
            return new ko(drawableJ, 1);
        }
        return null;
    }
}
