package iuh.fit.se.springDataJPA_NVH.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "maybay")
public class MayBay {
	
	@Id
	@Column(name = "MaMB")
	private Integer maMB;
	
	@Column(name = "Loai", columnDefinition = "varchar(50)")
	private String loai;
	
	@Column(name = "TamBay")
	private Integer tamBay;
	
	@ManyToMany()
	@JoinTable(name = "chungnhan", 
	joinColumns = @JoinColumn(name= "MaMB", referencedColumnName = "MaMB"),
	inverseJoinColumns = @JoinColumn(name= "MaNV", referencedColumnName = "MaNV"))
	private List<NhanVien> nhanViens;

	public Integer getMaMB() {
		return maMB;
	}

	public void setMaMB(Integer maMB) {
		this.maMB = maMB;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Integer getTamBay() {
		return tamBay;
	}

	public void setTamBay(Integer tamBay) {
		this.tamBay = tamBay;
	}

	public MayBay() {
		super();
	}

	public List<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

	public MayBay(Integer maMB, String loai, Integer tamBay, List<NhanVien> nhanViens) {
		super();
		this.maMB = maMB;
		this.loai = loai;
		this.tamBay = tamBay;
		this.nhanViens = nhanViens;
	}

	
	
	

}
