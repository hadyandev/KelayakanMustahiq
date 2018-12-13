/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.function;

import kelayakanmustahiq.entities.Mustahiq;
import kelayakanmustahiq.model.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Hadyan Ahmad
 */
public class FunctionMustahiq {

    private Session session;
    private Mustahiq cm;
    
    public Integer idMustahiq(int x) {
        int idMustahiq;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        idMustahiq = cm.getIdMustahiq();
        session.disconnect();
        session.close();
        return idMustahiq;
    }
    
    public String namaMustahiq(int x) {
        String namaMustahiq;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        namaMustahiq = cm.getNamaMustahiq();
        session.disconnect();
        session.close();
        return namaMustahiq;
    }
    
    public String alamat(int x) {
        String alamat;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        alamat = cm.getAlamat();
        session.disconnect();
        session.close();
        return alamat;
    }
    
    public Integer jumlahPendapatan(int x) {
        int jumlahPendapatan;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        jumlahPendapatan = cm.getJumlahPendapatan();
        session.disconnect();
        session.close();
        return jumlahPendapatan;
    }
    
    public Integer jumlahTanggungan(int x) {
        int jumlahTanggungan;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        jumlahTanggungan = cm.getJumlahTanggungan();
        session.disconnect();
        session.close();
        return jumlahTanggungan;
    }
    
    public Integer tempatTinggal(int x) {
        int tempatTinggal;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        tempatTinggal = cm.getKualitasTempattinggal();
        session.disconnect();
        session.close();
        return tempatTinggal;
    }
    
    public Integer attitude(int x) {
        int attitude;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        attitude = cm.getAttitude();
        session.disconnect();
        session.close();
        return attitude;
    }
    
    public Float kelayakan(int x) {
        float kelayakan;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        kelayakan = cm.getKelayakan();
        session.disconnect();
        session.close();
        return kelayakan;
    }
    
    public String status(int x) {
        String status;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cm = (Mustahiq) session.get(Mustahiq.class, x);
        status = cm.getStatus();
        session.disconnect();
        session.close();
        return status;
    }
}
