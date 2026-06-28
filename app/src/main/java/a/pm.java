package a;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pm implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f237a;

    public /* synthetic */ pm(int i) {
        this.f237a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f237a) {
            case 0:
                return MaterialDynamicColors.lambda$surfaceContainerLow$23(dynamicScheme);
            case 1:
                return MaterialDynamicColors.lambda$surfaceContainerLow$24(dynamicScheme);
            case 2:
                return MaterialDynamicColors.lambda$secondaryContainer$73(dynamicScheme);
            case 3:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$158(dynamicScheme);
            case 4:
                return MaterialDynamicColors.lambda$onTertiaryFixed$137(dynamicScheme);
            case 5:
                return MaterialDynamicColors.lambda$onTertiaryFixed$138(dynamicScheme);
            case 6:
                return MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$4(dynamicScheme);
            case 7:
                return MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$5(dynamicScheme);
            case 8:
                return MaterialDynamicColors.lambda$controlHighlight$149(dynamicScheme);
            case 9:
                return MaterialDynamicColors.lambda$controlHighlight$150(dynamicScheme);
            case 10:
                return MaterialDynamicColors.lambda$controlHighlight$151(dynamicScheme);
            case 11:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159(dynamicScheme);
            case 12:
                return MaterialDynamicColors.lambda$primaryContainer$58(dynamicScheme);
            case 13:
                return MaterialDynamicColors.lambda$background$10(dynamicScheme);
            case 14:
                return MaterialDynamicColors.lambda$background$11(dynamicScheme);
            case 15:
                return MaterialDynamicColors.lambda$surfaceContainerHigh$27(dynamicScheme);
            case 16:
                return MaterialDynamicColors.lambda$surfaceContainerHigh$28(dynamicScheme);
            case 17:
                return MaterialDynamicColors.lambda$onBackground$12(dynamicScheme);
            case 18:
                return MaterialDynamicColors.lambda$onBackground$13(dynamicScheme);
            case 19:
                return MaterialDynamicColors.lambda$onTertiary$82(dynamicScheme);
            case 20:
                return MaterialDynamicColors.lambda$outlineVariant$44(dynamicScheme);
            case 21:
                return MaterialDynamicColors.lambda$outlineVariant$45(dynamicScheme);
            case 22:
                return MaterialDynamicColors.lambda$surfaceBright$19(dynamicScheme);
            case 23:
                return MaterialDynamicColors.lambda$surfaceBright$20(dynamicScheme);
            case 24:
                return MaterialDynamicColors.lambda$onPrimary$55(dynamicScheme);
            case 25:
                return MaterialDynamicColors.lambda$onPrimary$56(dynamicScheme);
            case 26:
                return MaterialDynamicColors.lambda$inversePrimary$64(dynamicScheme);
            case 27:
                return MaterialDynamicColors.lambda$inversePrimary$65(dynamicScheme);
            case 28:
                return MaterialDynamicColors.lambda$onTertiary$83(dynamicScheme);
            default:
                return MaterialDynamicColors.lambda$secondaryFixed$117(dynamicScheme);
        }
    }
}
