package a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ax implements qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18a = 1;
    public final Object b;
    public final Object c;

    public ax(AssetManager assetManager, aw awVar) {
        this.c = assetManager;
        this.b = awVar;
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        switch (this.f18a) {
            case 0:
                Uri uri = (Uri) obj;
                return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                return true;
            case 2:
                return true;
            default:
                Uri uri2 = (Uri) obj;
                return "android.resource".equals(uri2.getScheme()) && ((Context) this.c).getPackageName().equals(uri2.getAuthority());
        }
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        iu iuVar;
        Uri uri;
        switch (this.f18a) {
            case 0:
                Uri uri2 = (Uri) obj;
                String strSubstring = uri2.toString().substring(22);
                qq qqVar = new qq(uri2);
                AssetManager assetManager = (AssetManager) this.c;
                switch (((aw) this.b).f17a) {
                    case 0:
                        iuVar = new iu(assetManager, strSubstring, 0);
                        break;
                    default:
                        iuVar = new iu(assetManager, strSubstring, 1);
                        break;
                }
                return new pz(qqVar, iuVar);
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) quVar.c(sk.b);
                return new pz(new qq(num), new gb(theme, theme != null ? theme.getResources() : ((Context) this.c).getResources(), (ga) this.b, num.intValue()));
            case 2:
                Integer num2 = (Integer) obj;
                Resources resources = (Resources) this.b;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num2.intValue()) + '/' + resources.getResourceTypeName(num2.intValue()) + '/' + resources.getResourceEntryName(num2.intValue()));
                    break;
                } catch (Resources.NotFoundException unused) {
                    Log.isLoggable("ResourceLoader", 5);
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((qa) this.c).b(uri, i, i2, quVar);
            default:
                Uri uri3 = (Uri) obj;
                qa qaVar = (qa) this.b;
                List<String> pathSegments = uri3.getPathSegments();
                pz pzVarB = null;
                if (pathSegments.size() == 1) {
                    try {
                        int i3 = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (i3 != 0) {
                            pzVarB = qaVar.b(Integer.valueOf(i3), i, i2, quVar);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            uri3.toString();
                        }
                        return pzVarB;
                    } catch (NumberFormatException unused2) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return pzVarB;
                        }
                        Objects.toString(uri3);
                        return pzVarB;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    uri3.toString();
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return qaVar.b(Integer.valueOf(identifier), i, i2, quVar);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                uri3.toString();
                return null;
        }
    }

    public ax(Resources resources, qa qaVar) {
        this.b = resources;
        this.c = qaVar;
    }

    public ax(Context context, ga gaVar) {
        this.c = context.getApplicationContext();
        this.b = gaVar;
    }

    public ax(Context context, qa qaVar) {
        this.c = context.getApplicationContext();
        this.b = qaVar;
    }
}
