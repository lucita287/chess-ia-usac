/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.resources;

import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

public class lookandfeel {

    /**
     * @param args the command line arguments
     */
private SubstanceLookAndFeel lookandfeel=new SubstanceLookAndFeel();

/**Constructor, el cual se inicializa con una variable la cual sirve
 * para Ocultar o Mostrar Marco del JFrame
 *
 * @param Mostrar
 */
public lookandfeel(boolean Mostrar){
    JFrame.setDefaultLookAndFeelDecorated(Mostrar);
}

/**Devuelve el lookandfeel Substance que estamos utilizando
 *
 * @return
 */
public SubstanceLookAndFeel LookAndFeel(){
    return lookandfeel;
}

/**Para Cambiar el Fondo
 *
 *- org.jvnet.substance.skin.AutumnSkin
- org.jvnet.substance.skin.BusinessBlackSteelSkin
- org.jvnet.substance.skin.BusinessBlueSteelSkin
- org.jvnet.substance.skin.BusinessSkin
- org.jvnet.substance.skin.CremeCoffeeSkin
- org.jvnet.substance.skin.CremeSkin
- org.jvnet.substance.skin.EmeraldDuskSkin
- org.jvnet.substance.skin.FieldOfWheatSkin
- org.jvnet.substance.skin.FindingNemoSkin
- org.jvnet.substance.skin.GreenMagicSkin
- org.jvnet.substance.skin.MagmaSkin
- org.jvnet.substance.skin.MangoSkin
- org.jvnet.substance.skin.MistAquaSkin
- org.jvnet.substance.skin.ModerateSkin
- org.jvnet.substance.skin.NebulaBrickWallSkin
- org.jvnet.substance.skin.NebulaSkin
- org.jvnet.substance.skin.OfficeBlue2007Skin
- org.jvnet.substance.skin.OfficeSilver2007Skin
- org.jvnet.substance.skin.RavenGraphiteGlassSkin
- org.jvnet.substance.skin.RavenGraphiteSkin
- org.jvnet.substance.skin.RavenSkin
- org.jvnet.substance.skin.SaharaSkin
 *
 * @param skin
 */
@SuppressWarnings("static-access")
public void setSkin(String skin){
    lookandfeel.setSkin(skin);
}

/**Para Cambiar el Tema
 * 
 *- org.jvnet.substance.theme.SubstanceAquaTheme
- org.jvnet.substance.theme.SubstanceBarbyPinkTheme
- org.jvnet.substance.theme.SubstanceBlendBiTheme
- org.jvnet.substance.theme.SubstanceBottleGreenTheme
- org.jvnet.substance.theme.SubstanceBrownTheme.
- org.jvnet.substance.theme.SubstanceCharcoalTheme
- org.jvnet.substance.theme.SubstanceCremeTheme.
- org.jvnet.substance.theme.SubstanceDarkVioletTheme
- org.jvnet.substance.theme.SubstanceDesertSandTheme.
- org.jvnet.substance.theme.SubstanceEbonyTheme.
- org.jvnet.substance.theme.SubstanceJadeForestTheme.
- org.jvnet.substance.theme.SubstanceLightAquaTheme
- org.jvnet.substance.theme.SubstanceLimeGreenTheme.
- org.jvnet.substance.theme.SubstanceNegatedTheme
- org.jvnet.substance.theme.SubstanceOliveTheme
- org.jvnet.substance.theme.SubstanceOrangeTheme
- org.jvnet.substance.theme.SubstancePurpleTheme
- org.jvnet.substance.theme.SubstanceRaspberryTheme
- org.jvnet.substance.theme.SubstanceSaturatedTheme
- org.jvnet.substance.theme.SubstanceSepiaTheme
- org.jvnet.substance.theme.SubstanceSteelBlueTheme
- org.jvnet.substance.theme.SubstanceSunGlareTheme
- org.jvnet.substance.theme.SubstanceSunsetTheme
- org.jvnet.substance.theme.SubstanceTerracottaTheme
 *
 * @param skin
 * @return
 */
@SuppressWarnings("static-access")
public boolean setCurrentTheme(String skin){
        return lookandfeel.setCurrentTheme(skin);
}

/**Para Cambiar Marca de Agua
 *
 * org.jvnet.substance.watermark. SubstanceBubblesWatermark
- org.jvnet.substance.watermark. SubstanceBinaryWatermark
- org.jvnet.substance.watermark. SubstanceCopperplateEngravingWatermark
- org.jvnet.substance.watermark. SubstanceCrosshatchWatermark
- org.jvnet.substance.watermark. SubstanceFabricWatermark
- org.jvnet.substance.watermark. SubstanceGenericNoiseWatermark
- org.jvnet.substance.watermark. SubstanceImageWatermark
- org.jvnet.substance.watermark. SubstanceKatakanaWatermark
- org.jvnet.substance.watermark.SubstanceLatchWatermark
- org.jvnet.substance.watermark. SubstanceMagneticFieldWatermark
- org.jvnet.substance.watermark. SubstanceMarbleVeinWatermark
- org.jvnet.substance.watermark.SubstanceMazeWatermark
- org.jvnet.substance.watermark. SubstanceMetalWallWatermark
- org.jvnet.substance.watermark.SubstanceNoneWatermark
- org.jvnet.substance.watermark.SubstanceNullWatermark
- org.jvnet.substance.watermark. SubstancePlanktonWatermark
- org.jvnet.substance.watermark. SubstanceStripeWatermark
- org.jvnet.substance.watermark. SubstanceWoodWatermark
 *
 * @param skin
 */
@SuppressWarnings("static-access")
public void setCurrentWatermark(String skin){
        lookandfeel.setCurrentWatermark(skin);
}

/**Para el Estilo del Botton
 *
 * org.jvnet.substance.button.StandardButtonShaper
 *
 * @param skin
  */
@SuppressWarnings("static-access")
public void setCurrentButtonShaper(String skin){
        lookandfeel.setCurrentButtonShaper(skin);
}
}
