package iuh.fit.se.springDataJPA_NVH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iuh.fit.se.springDataJPA_NVH.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

	// 3. Tìm các nhân viên có lương nhỏ hơn 10,000.
	@Query(value = "select * from nhanvien where Luong < 10000", nativeQuery = true)
	List<NhanVien> findNhanVienByLuongDuoi10000();

	// 8. Cho biết tổng số lương phải trả cho các nhân viên.
	@Query(value = "select sum(luong) as LuongNV from nhanvien", nativeQuery = true)
	Integer getTongLuongCacNhanVien();

	// 9. Cho biết mã số của các phi công lái máy báy Boeing.
	@Query(value = " select  n.MaNV, n.Ten ,n.Luong  from nhanvien n join"
			+ " chungnhan c on n.MaNV = c.MaNV join maybay m on c.MaMB = m.MaMB where m.Loai like 'Boeing%'"
			, nativeQuery = true)
	List<NhanVien> findNhanVienLaiMayBayBoeing();

	// 10. Cho biết các nhân viên có thể lái máy bay có mã số 747.
	@Query(value = " select  n.MaNV, Ten, Luong from nhanvien "
			+ "n join chungnhan c on n.MaNV = c.MaNV join maybay m on "
			+ "c.MaMB = m.MaMB where m.Loai like '%747%' ", nativeQuery = true)
	List<NhanVien> findNhanVienLaiMayBay747();

	// 12. Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
	@Query(value = "select  * from nhanVien nv join chungnhan c"
			+ " on nv.MaNV = c.MaNV 	join MayBay m on c.MaMB = m.MaMB where "
			+ "loai like 'airbus%' or nv.MaNV like 'boeing%' ", nativeQuery = true)
	List<NhanVien> findNhanVienLaiBoingVaAirbus();

	// 15. Cho biết tên của các phi công lái máy bay Boeing.
	@Query(value = "select distinct nv.Ten from nhanVien nv join chungnhan vn "
			+ "on nv.MaNV = vn.MaNV join MayBay m on vn.MaMB = m.MaMB where Loai like '%boeing%' ", nativeQuery = true)
	List<String> findTenNhanVienLaiBoeing();

	// 22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
	@Query(value = "select MaNV from chungnhan " + " group by MaNV having count(MaMB) = 3", nativeQuery = true)
	List<String> findMaNVLai3LoaiMayBay();

	
	
	

}
