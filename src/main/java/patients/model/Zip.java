package patients.model;
// Generated Jul 23, 2016 7:02:42 PM by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.owlike.genson.annotation.JsonIgnore;

/**
 * Zip generated by hbm2java
 */
@Entity
@Table(name = "zip", catalog = "patients")
public class Zip implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2307725430780120339L;
	private int zipid;
	private Integer version;
	private String zip;
	private String city;
	private Integer landId;
	private String selfCreated;
	private Integer deleted;
	private Set<Patient> patients = new HashSet<Patient>(0);

	public Zip() {
	}

	public Zip(int zipid) {
		this.zipid = zipid;
	}

	public Zip(int zipid, String zip, String city, Integer landId, String selfCreated, Integer deleted, Set<Patient> patients) {
		this.zipid = zipid;
		this.zip = zip;
		this.city = city;
		this.landId = landId;
		this.selfCreated = selfCreated;
		this.deleted = deleted;
		this.patients = patients;
	}

	@Id

	@Column(name = "ZIPID", unique = true, nullable = false)
	public int getZipid() {
		return this.zipid;
	}

	public void setZipid(int zipid) {
		this.zipid = zipid;
	}

	@Version
	@Column(name = "Version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "ZIP", length = 65535)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "City", length = 65535)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "LandID")
	public Integer getLandId() {
		return this.landId;
	}

	public void setLandId(Integer landId) {
		this.landId = landId;
	}

	@Column(name = "SelfCreated", length = 65535)
	public String getSelfCreated() {
		return this.selfCreated;
	}

	public void setSelfCreated(String selfCreated) {
		this.selfCreated = selfCreated;
	}

	@Column(name = "Deleted")
	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "zip")
	public Set<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}