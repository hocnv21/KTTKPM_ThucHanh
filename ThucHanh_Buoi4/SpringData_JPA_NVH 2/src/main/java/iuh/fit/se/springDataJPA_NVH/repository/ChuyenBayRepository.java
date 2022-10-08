package iuh.fit.se.springDataJPA_NVH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.fit.se.springDataJPA_NVH.entity.ChuyenBay;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {

	// 1. Cho biết các chuyến bay đi Đà Lạt (DAD).
	@Query(value = "select * from chuyenbay where GaDen ='DAD'", nativeQuery = true)
	List<ChuyenBay> findChuyenBayDaLat();

	// 4. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
	@Query(value = "select * from chuyenbay where DoDai < 10000 and DoDai > 8000", nativeQuery = true)
	List<ChuyenBay> findChuyenBayByDoDaiTren10000VaDuoi8000();

	// 5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
	@Query(value = "select * from chuyenbay where GaDi = 'SGN' and GaDen = 'BMV'", nativeQuery = true)
	List<ChuyenBay> findChuyenBayTuSGDenBMT();

	// 6. Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
	@Query(value = "select * from chuyenbay where GaDi = 'SGN' ", nativeQuery = true)
	List<ChuyenBay> findChuyenBayTuSg();

	// 14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
	@Query(value = " select * from chuyenbay " + " where dodai < (select tambay from maybay "
			+ " where Loai like '%Airbus A320%') ", nativeQuery = true)
	List<ChuyenBay> findChuyenBayMayBayA320();

	// 17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A.
	// Cho biết các đường bay nào có thể đáp ứng yêu cầu này.
	@Query(value = " select * from chuyenbay where GaDi in ( select GaDen from chuyenbay) and GaDen in (select GaDi from chuyenbay)", nativeQuery = true)
	List<ChuyenBay> findDuongBayKhuHoi();

	// 18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
	@Query(value = "select GaDi, count(MaCB) as 'SoChuyen' from  chuyenbay group by GaDi ", nativeQuery = true)
	List<Object> findChuyenBayMoiGa();

	// 19. Với mỗi ga có chuyến bay xuất phát từ đó,  cho biết tổng
	// chi phí phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.
	@Query(value = " select GaDi, sum(ChiPhi) as PhiPhaiTra from  chuyenbay group by GaDi ", nativeQuery = true)
	List<Object> findChiPhiChuyenBayMoiGa();

	// 20. Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
	@Query(value = "  select * from chuyenbay where Hour(gioDi) < 12", nativeQuery = true)
	List<ChuyenBay> findChuyenBayTruoc12h();

	// 21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
	@Query(value = "select GaDi, count(MaCB) as "
			+ " 'SoChuyenBay' from  chuyenbay where Hour(gioDi) < 12 group by GaDi ", nativeQuery = true)
	List<Object> findSoChuyenBayMoiGaTruoc12h();

	

}
