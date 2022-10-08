package iuh.fit.se.springDataJPA_NVH.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
	
	@Id
	@Column(name = "MaNV", columnDefinition = "varchar(9)")
	private String maNV;
	
	@Column(name = "Ten", columnDefinition = "varchar(50)")
	private String ten;
	
	
	private Integer luong;


	public String getMaNV() {
		return maNV;
	}


	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public Integer getLuong() {
		return luong;
	}


	public void setLuong(Integer luong) {
		this.luong = luong;
	}


	public NhanVien() {
		super();
	}


	public NhanVien(String maNV, String ten, Integer luong) {
		super();
		this.maNV = maNV;
		this.ten = ten;
		this.luong = luong;
	}
	
	
	
	

}
