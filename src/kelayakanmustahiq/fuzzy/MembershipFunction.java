/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.fuzzy;

import kelayakanmustahiq.function.FunctionMustahiq;
import kelayakanmustahiq.function.FunctionVariabelFuzzy;
import java.text.DecimalFormat;

/**
 *
 * @author Hadyan Ahmad
 */
public class MembershipFunction {

    private Float derajatMin(int domainMin, int domainMax, int input) {
        float derajatMin;
        if (input <= domainMin) {
            derajatMin = 1;
        } else if (input >= domainMax) {
            derajatMin = 0;
        } else {
            float pembilang = domainMax - input;
            float penyebut = domainMax - domainMin;
            derajatMin = pembilang / penyebut;
        }
        return derajatMin;
    }

    private Float derajatMax(int domainMin, int domainMax, int input) {
        float derajatMax;
        if (input <= domainMin) {
            derajatMax = 0;
        } else if (input >= domainMax) {
            derajatMax = 1;
        } else {
            float pembilang = input - domainMin;
            float penyebut = domainMax - domainMin;
            derajatMax = pembilang / penyebut;
        }
        return derajatMax;
    }

    private Float decimal(float derajatInput) {
        DecimalFormat decimal = new DecimalFormat();
        decimal.setMaximumFractionDigits(2);
        String derajatProccess = decimal.format(derajatInput);
        float derajatOutput = Float.valueOf(derajatProccess);
        return derajatOutput;
    }

    //Menghitung Derajat Keanggotaan Variabel Tanggungan
    public Float tanggunganSedikit(int id) {
        float tanggunganSedikit;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        tanggunganSedikit = derajatMin(fvf.domainMin("Tanggungan"), fvf.domainMax("Tanggungan"), fm.jumlahTanggungan(id));
        return decimal(tanggunganSedikit);
    }

    public Float tanggunganBanyak(int id) {
        float tanggunganBanyak;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        tanggunganBanyak = derajatMax(fvf.domainMin("Tanggungan"), fvf.domainMax("Tanggungan"), fm.jumlahTanggungan(id));
        return decimal(tanggunganBanyak);
    }

    //Menghitung Derajat Keanggotaan Variabel Tempat Tinggal
    public Float tempatTinggalBuruk(int id) {
        float tempatTinggalBuruk;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        tempatTinggalBuruk = derajatMin(fvf.domainMin("Tempat Tinggal"), fvf.domainMax("Tempat Tinggal"), fm.tempatTinggal(id));
        return decimal(tempatTinggalBuruk);
    }

    public Float tempatTinggalBaik(int id) {
        float tempatTinggalBaik;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        tempatTinggalBaik = derajatMax(fvf.domainMin("Tempat Tinggal"), fvf.domainMax("Tempat Tinggal"), fm.tempatTinggal(id));
        return decimal(tempatTinggalBaik);
    }

    //Menghitung Derajat Keanggotaan Variabel Pendapatan
    public Float pendapatanKurang(int id) {
        float pendapatanKurang;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        pendapatanKurang = derajatMin(fvf.domainMin("Pendapatan"), fvf.domainMax("Pendapatan"), fm.jumlahPendapatan(id));
        return decimal(pendapatanKurang);
    }

    public Float pendapatanCukup(int id) {
        float pendapatanCukup;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        pendapatanCukup = derajatMax(fvf.domainMin("Pendapatan"), fvf.domainMax("Pendapatan"), fm.jumlahPendapatan(id));
        return decimal(pendapatanCukup);
    }

    //Menghitung Derajat Keanggotaan Variabel Attitude
    public Float attitudeKurangBaik(int id) {
        float attitudeKurangBaik;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        attitudeKurangBaik = derajatMin(fvf.domainMin("Attitude"), fvf.domainMax("Attitude"), fm.attitude(id));
        return decimal(attitudeKurangBaik);
    }

    public Float attitudeBaik(int id) {
        float attitudeBaik;
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        FunctionMustahiq fm = new FunctionMustahiq();
        attitudeBaik = derajatMax(fvf.domainMin("Attitude"), fvf.domainMax("Attitude"), fm.attitude(id));
        return decimal(attitudeBaik);
    }
}
