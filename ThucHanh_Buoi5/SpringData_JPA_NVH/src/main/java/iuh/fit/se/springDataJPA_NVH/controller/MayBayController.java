package iuh.fit.se.springDataJPA_NVH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.fit.se.springDataJPA_NVH.entity.MayBay;
import iuh.fit.se.springDataJPA_NVH.repository.MayBayRepository;

@RestController
@RequestMapping("/maybay")
public class MayBayController {

	@Autowired
	MayBayRepository mayBayRepository;

	//2. Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
	@GetMapping("/cau2-GetTamBayTren10000km")
	public List<MayBay> getMayBayTheoTamBay() {
		return mayBayRepository.getMayBayByTamBayTren10000();
	}
	
	//7. Có bao nhiêu loại máy báy Boeing.
	@GetMapping("/cau7-getSoMayBayLoaiBoeing")
	public Integer getSoMayBayLoaiBoeing() {
		return mayBayRepository.getSoLuongMayBayLoaiBoeing();
	}
	
	// 11. Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
	@GetMapping("/cau11-GetLoaiMayBayNhanVienHoNguyen")
	public List<Integer> getLoaiMayBayNhanVienHoNguyen() {
		return mayBayRepository.getLoaiMayBayNhanVienHoNguyen();
	}
	
	
	
	// 13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
	@GetMapping("/cau13-GetLoaiMayBayVN280")
	public List<String> getLoaiMayBayVN280() {
		return mayBayRepository.findMayBayVN280();
	}
	
	//16. Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể
	// lái loại máy bay đó.
		@GetMapping("/cau16-GetMayBayVoiTongPhiCong")
		public List<Object> getMayBayVoiTongPC() {
			return mayBayRepository.findMayBayVoiTongPhiCong();
		}

}
