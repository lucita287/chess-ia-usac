/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import gui.resources.lookandfeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author D@N13L
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            lookandfeel laf_config=new lookandfeel(true);
            laf_config.setSkin("org.jvnet.substance.skin.MagmaSkin");
            laf_config.setCurrentTheme("org.jvnet.substance.theme.SubstanceBrownTheme");
            laf_config.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceFabricWatermark");
            laf_config.setCurrentButtonShaper("org.jvnet.substance.button.StandardButtonShaper");

            try {
            UIManager.setLookAndFeel(laf_config.LookAndFeel());
            } catch (Exception e) {
              System.out.println("Look And Feel Failed to Initialize");
              System.out.println(e.toString());
            }

            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
               new view().setVisible(true);
              }
            });
    
    }
}
