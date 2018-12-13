/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.report;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kelayakanmustahiq.view.PanelKelayakan;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Hadyan Ahmad
 */
public class Reports {

    public void printReport() {
        JasperReport report;
        JasperPrint print;
        Map<String, Object> param = new HashMap<String, Object>();
        JasperDesign design;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/KelayakanMustahiq", "root", "");
//            File file = new File("src/kelayakanmustahiq/report/reportKelayakan.jrxml");
//            design = JRXmlLoader.load(file.getAbsolutePath());
//            param.clear();
//            report = JasperCompileManager.compileReport(design);
//            print = JasperFillManager.fillReport(report, param, koneksi);
            print = JasperFillManager.fillReport(ClassLoader.getSystemResourceAsStream("src/kelayakanmustahiq/report/reportKelayakan.jasper"), param, koneksi);
            JasperViewer.viewReport(print, false);
            JasperViewer jv = new JasperViewer(print, false);
            jv.setVisible(true);
            JRViewer v = new JRViewer(print);
            v.setVisible(true);

//            String reportSource = "src/report/reportKelayakan.jasper";
//            InputStream is = getClass().getResourceAsStream(reportSource);
//            design = JRXmlLoader.load(is);
//            report = JasperCompileManager.compileReport(is);
//            print = JasperFillManager.fillReport(report, param, koneksi);
//            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
