/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.fuzzy;

import kelayakanmustahiq.function.FunctionVariabelFuzzy;

/**
 *
 * @author Hadyan Ahmad
 */
public class Tsukamoto {

    //Mencari Nilai Z pada aturan dengan himpunan negatif
    public Integer ZMin(float derajat) {
        Apred a_predikat = new Apred();
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        int z;
        float temp;
        temp = fvf.domainMax("Kelayakan") - (derajat * (fvf.domainMax("Kelayakan") - fvf.domainMin("Kelayakan")));
        z = (int) temp;
        return z;
    }

    //Mencari Nilai Z pada aturan dengan himpunan positif
    public Integer ZMax(float derajat) {
        Apred a_predikat = new Apred();
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        int z;
        float temp;
        temp = (derajat * (fvf.domainMax("Kelayakan") - fvf.domainMin("Kelayakan"))) + fvf.domainMin("Kelayakan");
        z = (int) temp;
        return z;
    }

    //Menghitung z Tsukamoto
    public Float z(int x) {
        Apred a = new Apred();
        float z;
        float pembilang = (a.Rule1(x) * ZMin(a.Rule1(x))) + (a.Rule2(x) * ZMin(a.Rule2(x))) + (a.Rule3(x) * ZMin(a.Rule3(x))) + (a.Rule4(x) * ZMin(a.Rule4(x)))
                + (a.Rule5(x) * ZMin(a.Rule5(x))) + (a.Rule6(x) * ZMin(a.Rule6(x))) + (a.Rule7(x) * ZMax(a.Rule7(x))) + (a.Rule8(x) * ZMin(a.Rule8(x)))
                + (a.Rule9(x) * ZMin(a.Rule9(x))) + (a.Rule10(x) * ZMin(a.Rule10(x))) + (a.Rule11(x) * ZMin(a.Rule11(x))) + (a.Rule12(x) * ZMax(a.Rule12(x)))
                + (a.Rule13(x) * ZMin(a.Rule13(x))) + (a.Rule14(x) * ZMin(a.Rule14(x))) + (a.Rule15(x) * ZMin(a.Rule15(x))) + (a.Rule16(x) * ZMin(a.Rule16(x)));
        float penyebut = (a.Rule1(x) + a.Rule2(x) + a.Rule3(x) + a.Rule4(x) + a.Rule5(x) + a.Rule6(x) + a.Rule7(x) + a.Rule8(x)
                + a.Rule9(x) + a.Rule10(x) + a.Rule11(x) + a.Rule12(x) + a.Rule13(x) + a.Rule14(x) + a.Rule15(x) + a.Rule16(x));
        z = pembilang / penyebut;
        return z;
    }
}
