/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq;

import com.alee.laf.WebLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Hadyan Ahmad
 */
public class KelayakanMustahiq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
            MainWindow mw = new MainWindow();
            mw.pack();
            mw.setLocationRelativeTo(null);
            mw.setVisible(true);
        } catch (UnsupportedLookAndFeelException e) {
        }
    }
    
}
