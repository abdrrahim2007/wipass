package a;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pl implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f236a;

    public /* synthetic */ pl(int i) {
        this.f236a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f236a) {
            case 0:
                return MaterialDynamicColors.lambda$inverseSurface$37(dynamicScheme);
            case 1:
                return MaterialDynamicColors.lambda$inverseSurface$38(dynamicScheme);
            case 2:
                return MaterialDynamicColors.lambda$surfaceDim$18(dynamicScheme);
            case 3:
                return MaterialDynamicColors.lambda$onErrorContainer$100(dynamicScheme);
            case 4:
                return MaterialDynamicColors.lambda$onErrorContainer$101(dynamicScheme);
            case 5:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$154(dynamicScheme);
            case 6:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$155(dynamicScheme);
            case 7:
                return MaterialDynamicColors.lambda$errorContainer$97(dynamicScheme);
            case 8:
                return MaterialDynamicColors.lambda$errorContainer$98(dynamicScheme);
            case 9:
                return MaterialDynamicColors.lambda$tertiaryFixed$131(dynamicScheme);
            case 10:
                return MaterialDynamicColors.lambda$tertiaryFixed$132(dynamicScheme);
            case 11:
                return MaterialDynamicColors.lambda$controlNormal$147(dynamicScheme);
            case 12:
                return MaterialDynamicColors.lambda$primary$52(dynamicScheme);
            case 13:
                return MaterialDynamicColors.lambda$primary$53(dynamicScheme);
            case 14:
                return MaterialDynamicColors.lambda$scrim$48(dynamicScheme);
            case 15:
                return MaterialDynamicColors.lambda$scrim$49(dynamicScheme);
            case 16:
                return MaterialDynamicColors.lambda$onSecondaryFixedVariant$127(dynamicScheme);
            case 17:
                return MaterialDynamicColors.lambda$onSecondaryFixedVariant$128(dynamicScheme);
            case 18:
                return MaterialDynamicColors.lambda$controlNormal$148(dynamicScheme);
            case 19:
                return MaterialDynamicColors.lambda$tertiary$79(dynamicScheme);
            case 20:
                return MaterialDynamicColors.lambda$tertiary$80(dynamicScheme);
            case 21:
                return MaterialDynamicColors.lambda$controlActivated$145(dynamicScheme);
            case 22:
                return MaterialDynamicColors.lambda$controlActivated$146(dynamicScheme);
            case 23:
                return MaterialDynamicColors.lambda$primaryPaletteKeyColor$0(dynamicScheme);
            case 24:
                return MaterialDynamicColors.lambda$primaryPaletteKeyColor$1(dynamicScheme);
            case 25:
                return MaterialDynamicColors.lambda$surface$16(dynamicScheme);
            case 26:
                return MaterialDynamicColors.lambda$onTertiaryFixedVariant$141(dynamicScheme);
            case 27:
                return MaterialDynamicColors.lambda$onTertiaryFixedVariant$142(dynamicScheme);
            case 28:
                return MaterialDynamicColors.lambda$secondaryPaletteKeyColor$2(dynamicScheme);
            default:
                return MaterialDynamicColors.lambda$secondaryPaletteKeyColor$3(dynamicScheme);
        }
    }
}
