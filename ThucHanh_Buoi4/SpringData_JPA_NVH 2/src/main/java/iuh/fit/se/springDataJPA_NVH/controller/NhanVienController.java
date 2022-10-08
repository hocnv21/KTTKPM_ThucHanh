package iuh.fit.se.springDataJPA_NVH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.fit.se.springDataJPA_NVH.entity.NhanVien;
import iuh.fit.se.springDataJPA_NVH.repository.NhanVienRepository;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {

	@Autowired
	NhanVienRepository nhanVienRepository;

	//3. Tìm các nhân viên có lương nhỏ hơn 10,000.
	@GetMapping("/cau3-GetLuongDuoi10000")
	public List<NhanVien> getNhanVienLuongDuoiChiDinh() {

		return nhanVienRepository.findNhanVienByLuongDuoi10000();
	}

	//8. Cho biết tổng số lương phải trả cho các nhân viên.
	@GetMapping("/cau8-getTongLuongCacNhanVien")
	public Integer getTongLuongNhanVien() {

		return nhanVienRepository.getTongLuongCacNhanVien();
	}

	// 9. Cho biết mã số của các phi công lái máy báy Boeing.
	@GetMapping("/cau9-GetNhanVienLaiMayBayBoeing")
	public List<NhanVien> getNhanVienLaiMayBayBoeing() {

		return nhanVienRepository.findNhanVienLaiMayBayBoeing();
	}

	// 10. Cho biết các nhân viên có thể lái máy bay có mã số 747.
	@GetMapping("/cau10-GetNhanVienLaiMayBay747")
	public List<NhanVien> getNhanVienLaiMayBay747() {

		return nhanVienRepository.findNhanVienLaiMayBay747();
	}

	// 12. Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
	@GetMapping("/cau12-GetNhanVienLaiBoeingVaAirbus")
	public List<NhanVien> getNhanVienLaiBoeingVaAirbus() {

		return nhanVienRepository.findNhanVienLaiBoingVaAirbus();
	}

	// 15. Cho biết tên của các phi công lái máy bay Boeing.
	@GetMapping("/cau15-GetTenNVLaiBoeing")
	public List<String> getTenNVLaiBoeing() {

		return nhanVienRepository.findTenNhanVienLaiBoeing();
	}

	// 22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
	@GetMapping("/cau22-GetMaNVLai3LoaiMayBay")
	public List<String> getMaNVLai3LoaiMayBay() {

		return nhanVienRepository.findMaNVLai3LoaiMayBay();
	}

	
}
