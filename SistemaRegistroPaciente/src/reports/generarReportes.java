/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import Logica.conexion;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;

/**
 *
 * @author root
 */


public class generarReportes {
    public Connection connection= new conexion().conectar();
    public void reportePacientes(int idpersona){
        Map p = new HashedMap();
        JasperReport report;
        JasperPrint print;
        try {
//            report=(JasperReport) JRLoader.loadObject("h_paciente.jasper");
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/reports/h_paciente.jrxml");
            p.put("idpersona", idpersona);
            print= JasperFillManager.fillReport(report, p,connection);
            JasperViewer view= new JasperViewer(print,false);
            view.setTitle("ficha de paciente");
            view.setVisible(true);
            
        } catch (Exception e) {
            System.out.println("error "+e);
        }
//       
//        try {
//            JasperReport report=(JasperReport) JRLoader.loadObject("reporte1.jrxml");
//            Map parametro = new HashMap();
//            
//            parametro.put("idpersona",idpersona);
//            JasperPrint j= JasperFillManager.fillReport(report, parametro,connection);
//            JasperViewer jv = new JasperViewer(j,false);
//            jv.setTitle("Reporte Paciente");
//            jv.setVisible(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e + "Error logica reporte");
//        }
    }

 
    
}
