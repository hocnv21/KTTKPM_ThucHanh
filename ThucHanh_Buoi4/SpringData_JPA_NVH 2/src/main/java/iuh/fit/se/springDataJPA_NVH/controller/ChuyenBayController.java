package iuh.fit.se.springDataJPA_NVH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iuh.fit.se.springDataJPA_NVH.entity.ChuyenBay;
import iuh.fit.se.springDataJPA_NVH.repository.ChuyenBayRepository;

@RequestMapping("/chuyenbay")
@RestController
public class ChuyenBayController {

	@Autowired
	ChuyenBayRepository chuyenBayRepository;

	//1. Cho biết các chuyến bay đi Đà Lạt (DAD).
	@GetMapping("/cau1-GetChuyenBayDiDalat")
	public List<ChuyenBay> getDiemDenDaLat() {

		return chuyenBayRepository.findChuyenBayDaLat();
	}

	// 4. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
	@GetMapping("/cau4-GetDuongBayTren10000VaDuoi8000")
	public List<ChuyenBay> getChuyenBayCoDoDaiLonHon10000VaBeHon8000() {

		return chuyenBayRepository.findChuyenBayByDoDaiTren10000VaDuoi8000();
	}

	// 5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
	@GetMapping("/cau5-ChuyenBayTuSgDenbmt")
	public List<ChuyenBay> getChuyenBayTuSGDenBMT() {

		return chuyenBayRepository.findChuyenBayTuSGDenBMT();
	}

	// 6. Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
	@GetMapping("/cau6-ChuyenBayTuSg")
	public List<ChuyenBay> getChuyenBayTuSaiGon() {

		return chuyenBayRepository.findChuyenBayTuSg();
	}

	// 14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
	@GetMapping("/cau14-GetChuyenBayMayBayA320")
	public List<ChuyenBay> getChuyenBayMayBayA320() {

		return chuyenBayRepository.findChuyenBayMayBayA320();
	}

	// 17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A.
	// Cho biết các đường bay nào có thể đáp ứng yêu cầu này.
	@GetMapping("/cau17-GetDuongBayKhuHoi")
	public List<ChuyenBay> getDuongBayKhuHoi() {

		return chuyenBayRepository.findDuongBayKhuHoi();
	}

	// 18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
	@GetMapping("/cau18-GetChuyenBayMoiGa")
	public List<Object> getChuyenBayTuMoiGa() {

		return chuyenBayRepository.findChuyenBayMoiGa();
	}

	// 19. Với mỗi ga có chuyến bay xuất phát từ đó cho biết 
	// tổng chi phí phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.
	@GetMapping("/cau19-GetChiPhiChuyenBayMoiGa")
	public List<Object> getChiPhiChuyenBayMoiGa() {

		return chuyenBayRepository.findChiPhiChuyenBayMoiGa();
	}

	// 20. Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
	@GetMapping("/cau20-GetChuyenBayTruoc12h")
	public List<ChuyenBay> getChuyenBayTruoc12h() {

		return chuyenBayRepository.findChuyenBayTruoc12h();
	}

	// 21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
	@GetMapping("/cau21-GetSoChuyenBayMoiGaTruoc12h")
	public List<Object> getSoChuyenBayMoiGaTruoc12h() {

		return chuyenBayRepository.findSoChuyenBayMoiGaTruoc12h();
	}

	

}
