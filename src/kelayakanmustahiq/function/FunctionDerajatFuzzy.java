/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.function;

import kelayakanmustahiq.entities.DerajatFuzzy;
import kelayakanmustahiq.model.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Hadyan Ahmad
 */
public class FunctionDerajatFuzzy {

    private Session session;
    private DerajatFuzzy df;
    
    public Integer idMustahiq(int x) {
        int idDerajat;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        idDerajat = df.getIdDerajat();
        session.disconnect();
        session.close();
        return idDerajat;
    }
    
    public String namaMustahiq(int x) {
        String namaMustahiq;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        namaMustahiq = df.getNamaMustahiq();
        session.disconnect();
        session.close();
        return namaMustahiq;
    }
    
    public Float derajatTanggunganSedikit(int x) {
        float tanggunganSedikit;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        tanggunganSedikit = df.getTanggunganSedikit();
        session.disconnect();
        session.close();
        return tanggunganSedikit;
    }
    
    public Float derajatTanggunganBanyak(int x) {
        float tanggunganBanyak;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        tanggunganBanyak = df.getTanggunganBanyak();
        session.disconnect();
        session.close();
        return tanggunganBanyak;
    }
    
    public Float derajatKualitasBuruk(int x) {
        float kualitasBuruk;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        kualitasBuruk = df.getTempattinggalBuruk();
        session.disconnect();
        session.close();
        return kualitasBuruk;
    }
    
    public Float derajatKualitasBaik(int x) {
        float kualitasBaik;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        kualitasBaik = df.getTempattinggalBaik();
        session.disconnect();
        session.close();
        return kualitasBaik;
    }
    
    public Float derajatPendapatanKurang(int x) {
        float pendapatanKurang;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        pendapatanKurang = df.getPendapatanKurang();
        session.disconnect();
        session.close();
        return pendapatanKurang;
    }
    
    public Float derajatPendapatanCukup(int x) {
        float pendapatanCukup;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        pendapatanCukup = df.getPendapatanCukup();
        session.disconnect();
        session.close();
        return pendapatanCukup;
    }
    
    public Float derajatAttitudeKurang(int x) {
        float attitudeKurang;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        attitudeKurang = df.getAttitudeKurangbaik();
        session.disconnect();
        session.close();
        return attitudeKurang;
    }
    
    public Float derajatAttitudeBaik(int x) {
        float attitudeBaik;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        df = (DerajatFuzzy) session.get(DerajatFuzzy.class, x);
        attitudeBaik = df.getAttitudeBaik();
        session.disconnect();
        session.close();
        return attitudeBaik;
    }
}
