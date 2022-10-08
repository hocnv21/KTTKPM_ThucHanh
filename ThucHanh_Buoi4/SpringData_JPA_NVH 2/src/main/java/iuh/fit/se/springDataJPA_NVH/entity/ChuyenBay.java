package iuh.fit.se.springDataJPA_NVH.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chuyenbay")
public class ChuyenBay {
	
	@Id
	@Column(name = "MaCB", nullable = false, columnDefinition = "varchar(5)")
	private String maCB;
	
	@Column(name = "GaDi", columnDefinition = "varchar(50)")
	private String gaDi;
	
	@Column(name = "GaDen",  columnDefinition = "varchar(50)")
	private String gaDen;
	
	@Column(name = "DoDai")
	private Integer doDai;
	
	@Column(name = "GioDi", columnDefinition = "Time")
	private Time gioDi;
	
	@Column(name = "GioDen", columnDefinition = "Time")
	private Time gioDen;
	
	@Column(name = "ChiPhi")
	private Integer chiPhi;

	public String getMaCB() {
		return maCB;
	}

	public void setMaCB(String maCB) {
		this.maCB = maCB;
	}

	public String getGaDi() {
		return gaDi;
	}

	public void setGaDi(String gaDi) {
		this.gaDi = gaDi;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public Integer getDoDai() {
		return doDai;
	}

	public void setDoDai(Integer doDai) {
		this.doDai = doDai;
	}

	public Time getGioDi() {
		return gioDi;
	}

	public void setGioDi(Time gioDi) {
		this.gioDi = gioDi;
	}

	public Time getGioDen() {
		return gioDen;
	}

	public void setGioDen(Time gioDen) {
		this.gioDen = gioDen;
	}

	public ChuyenBay() {
		super();
	}

	public Integer getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(Integer chiPhi) {
		this.chiPhi = chiPhi;
	}

	public ChuyenBay(String maCB, String gaDi, String gaDen, Integer doDai, Time gioDi, Time gioDen, Integer chiPhi) {
		super();
		this.maCB = maCB;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.doDai = doDai;
		this.gioDi = gioDi;
		this.gioDen = gioDen;
		this.chiPhi = chiPhi;
	}
	
	

}
