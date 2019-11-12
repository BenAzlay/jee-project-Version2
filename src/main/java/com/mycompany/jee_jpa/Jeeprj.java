package com.mycompany.jee_jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "jeeprj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jeeprj.findAll", query = "SELECT j FROM Jeeprj j"),
    @NamedQuery(name = "Jeeprj.findById", query = "SELECT j FROM Jeeprj j WHERE j.id = :id"),
    @NamedQuery(name = "Jeeprj.findByName", query = "SELECT j FROM Jeeprj j WHERE j.name = :name"),
    @NamedQuery(name = "Jeeprj.findByFirstname", query = "SELECT j FROM Jeeprj j WHERE j.firstname = :firstname"),
    @NamedQuery(name = "Jeeprj.findByTelhome", query = "SELECT j FROM Jeeprj j WHERE j.telhome = :telhome"),
    @NamedQuery(name = "Jeeprj.findByTelmob", query = "SELECT j FROM Jeeprj j WHERE j.telmob = :telmob"),
    @NamedQuery(name = "Jeeprj.findByTelpro", query = "SELECT j FROM Jeeprj j WHERE j.telpro = :telpro"),
    @NamedQuery(name = "Jeeprj.findByAdress", query = "SELECT j FROM Jeeprj j WHERE j.adress = :adress"),
    @NamedQuery(name = "Jeeprj.findByPostalcode", query = "SELECT j FROM Jeeprj j WHERE j.postalcode = :postalcode"),
    @NamedQuery(name = "Jeeprj.findByCity", query = "SELECT j FROM Jeeprj j WHERE j.city = :city"),
    @NamedQuery(name = "Jeeprj.findByEmail", query = "SELECT j FROM Jeeprj j WHERE j.email = :email")})
public class Jeeprj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TELHOME")
    private String telhome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TELMOB")
    private String telmob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TELPRO")
    private String telpro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ADRESS")
    private String adress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CITY")
    private String city;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "EMAIL")
    private String email;

    public Jeeprj() {
    }

    public Jeeprj(Integer id) {
        this.id = id;
    }

    public Jeeprj(Integer id, String name, String firstname, String telhome, String telmob, String telpro, String adress, String postalcode, String city, String email) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.telhome = telhome;
        this.telmob = telmob;
        this.telpro = telpro;
        this.adress = adress;
        this.postalcode = postalcode;
        this.city = city;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTelhome() {
        return telhome;
    }

    public void setTelhome(String telhome) {
        this.telhome = telhome;
    }

    public String getTelmob() {
        return telmob;
    }

    public void setTelmob(String telmob) {
        this.telmob = telmob;
    }

    public String getTelpro() {
        return telpro;
    }

    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jeeprj)) {
            return false;
        }
        Jeeprj other = (Jeeprj) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jee_jpa.Jeeprj[ id=" + id + " ]";
    }

}