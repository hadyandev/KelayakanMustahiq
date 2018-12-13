/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.function;

import kelayakanmustahiq.entities.VariabelFuzzy;
import kelayakanmustahiq.model.HibernateUtil;
import kelayakanmustahiq.model.VariabelFuzzyModel;
import org.hibernate.Session;

/**
 *
 * @author Hadyan Ahmad
 */
public class FunctionVariabelFuzzy {

    private Session session;
    private VariabelFuzzy vf;
    private VariabelFuzzyModel vfm;

    public Integer idVariabel(String namaVariabel) {
        int id = 0;        
        switch (namaVariabel) {
            case "Tanggungan":
                id=1;
                break;
            case "Tempat Tinggal":
                id=2;
                break;
            case "Pendapatan":
                id=3;
                break;
            case "Attitude":
                id=4;
                break;
            case "Kelayakan":
                id=5;
                break;
        }
        return id;
    }

    public Integer domainMin(String namaVariabel) {
        int domainMin;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        vf = (VariabelFuzzy) session.get(VariabelFuzzy.class, idVariabel(namaVariabel));
        domainMin = vf.getDomainMin();
        session.disconnect();
        session.close();
        return domainMin;
    }

    public Integer domainMax(String namaVariabel) {
        int domainMax;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        vf = (VariabelFuzzy) session.get(VariabelFuzzy.class, idVariabel(namaVariabel));
        domainMax = vf.getDomainMax();
        session.disconnect();
        session.close();
        return domainMax;
    }

//    public Integer domainMin(int x) {
//        int domainMin;
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        vf = (VariabelFuzzy) session.get(VariabelFuzzy.class, x);
//        domainMin = vf.getDomainMin();
//        session.disconnect();
//        session.close();
//        return domainMin;
//    }
//
//    public Integer domainMax(int x) {
//        int domainMax;
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        vf = (VariabelFuzzy) session.get(VariabelFuzzy.class, x);
//        domainMax = vf.getDomainMax();
//        session.disconnect();
//        session.close();
//        return domainMax;
//    }
}
