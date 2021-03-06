package kelayakanmustahiq.entities;
// Generated Feb 24, 2017 6:41:49 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VariabelFuzzy generated by hbm2java
 */
@Entity
@Table(name="variabel_fuzzy"
    ,catalog="kelayakanmustahiq"
)
public class VariabelFuzzy  implements java.io.Serializable {


     private int idVariabel;
     private String namaVariabel;
     private Integer domainMin;
     private Integer domainMax;

    public VariabelFuzzy() {
    }

	
    public VariabelFuzzy(int idVariabel) {
        this.idVariabel = idVariabel;
    }
    public VariabelFuzzy(int idVariabel, String namaVariabel, Integer domainMin, Integer domainMax) {
       this.idVariabel = idVariabel;
       this.namaVariabel = namaVariabel;
       this.domainMin = domainMin;
       this.domainMax = domainMax;
    }
   
     @Id 

    
    @Column(name="id_variabel", unique=true, nullable=false)
    public int getIdVariabel() {
        return this.idVariabel;
    }
    
    public void setIdVariabel(int idVariabel) {
        this.idVariabel = idVariabel;
    }

    
    @Column(name="nama_variabel", length=30)
    public String getNamaVariabel() {
        return this.namaVariabel;
    }
    
    public void setNamaVariabel(String namaVariabel) {
        this.namaVariabel = namaVariabel;
    }

    
    @Column(name="domain_min")
    public Integer getDomainMin() {
        return this.domainMin;
    }
    
    public void setDomainMin(Integer domainMin) {
        this.domainMin = domainMin;
    }

    
    @Column(name="domain_max")
    public Integer getDomainMax() {
        return this.domainMax;
    }
    
    public void setDomainMax(Integer domainMax) {
        this.domainMax = domainMax;
    }




}


