/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.fuzzy;

import kelayakanmustahiq.function.FunctionDerajatFuzzy;

/**
 *
 * @author Hadyan Ahmad
 */
public class Apred {

//  Fungsi MIN
    private Float MIN(float derajat1, float derajat2, float derajat3, float derajat4) {
        float a = Math.min(derajat1, derajat2);
        float b = Math.min(derajat3, derajat4);
        return Math.min(a, b);
    }
    
    private Float MAX(float derajat1, float derajat2, float derajat3, float derajat4) {
        float a = Math.max(derajat1, derajat2);
        float b = Math.max(derajat3, derajat4);
        return Math.max(a, b);
    }

//[R1] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BAIK And Pendapatan CUKUP And Attitude BAIK THEN Mustahiq TIDAK LAYAK    
    public Float Rule1(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R2] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BAIK And Pendapatan CUKUP And Attitude BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule2(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R3] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BURUK And Pendapatan CUKUP And Attitude BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule3(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R4] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BAIK And Pendapatan KURANG And Attitude BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule4(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R5] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BAIK And Pendapatan CUKUP And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule5(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeKurang(i));
    }
    
//[R6] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BURUK And Pendapatan CUKUP And Attitude BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule6(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R7] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BURUK And Pendapatan KURANG And Attitude BAIK THEN Mustahiq LAYAK
    public Float Rule7(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R8] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BURUK And Pendapatan CUKUP And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule8(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeKurang(i));
    }
    
//[R9] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BAIK And Pendapatan KURANG And Attitude BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule9(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R10] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BAIK And Pendapatan CUKUP And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule10(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeKurang(i));
    }
    
//[R11] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BAIK And Pendapatan KURANG And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule11(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeKurang(i));
    }
    
//[R12] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BURUK And Pendapatan KURANG And Attitude BAIK THEN Mustahiq LAYAK
    public Float Rule12(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeBaik(i));
    }
    
//[R13] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BURUK And Pendapatan CUKUP And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule13(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanCukup(i), fdf.derajatAttitudeKurang(i));
    }
    
//[R14] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BAIK And Pendapatan KURANG And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule14(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBaik(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeKurang(i));
    }
    
//[R15] IF Tanggungan BANYAK And Kualitas Tempat Tinggal BURUK And Pendapatan KURANG And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule15(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganBanyak(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeKurang(i));
    }
    
//[R16] IF Tanggungan SEDIKIT And Kualitas Tempat Tinggal BURUK And Pendapatan KURANG And Attitude KURANG BAIK THEN Mustahiq TIDAK LAYAK
    public Float Rule16(int i){
        FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
        return MIN(fdf.derajatTanggunganSedikit(i), fdf.derajatKualitasBuruk(i), fdf.derajatPendapatanKurang(i), fdf.derajatAttitudeKurang(i));
    }
}
