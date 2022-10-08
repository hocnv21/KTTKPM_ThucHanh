package iuh.fit.se.springDataJPA_NVH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.fit.se.springDataJPA_NVH.entity.MayBay;

@Repository
public interface MayBayRepository extends JpaRepository<MayBay, Integer> {
	
	//2. Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
	@Query(value = "select * from maybay where TamBay > 10000", nativeQuery = true)
	List<MayBay> getMayBayByTamBayTren10000();
	
	// 7. Có bao nhiêu loại máy báy Boeing.
	@Query(value = "select count(*) from maybay where loai like 'Boeing%'", nativeQuery = true)
	Integer getSoLuongMayBayLoaiBoeing();
	
	// 11. Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
	@Query(value = "select m.MaMB  from maybay m join "
			+ "chungnhan c on c.MaMB = m.MaMB join nhanvien n  on n.MaNV = c.MaNV where n.Ten  like 'Nguyen%' ", nativeQuery = true)
	List<Integer> getLoaiMayBayNhanVienHoNguyen();
	
	
	
	// 13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
	@Query(value = "select loai from MayBay "
			+ " where tambay >= "
			+ " (select dodai from chuyenbay "
			+ " where MaCB like 'VN280') ", nativeQuery = true)
	List<String> findMayBayVN280();
	
	// 16. Với mỗi loại máy bay có phi công lái cho biết mã số,
	// loại máy báy và tổng số phi công có thể lái loại máy bay đó.
	@Query(value = "select m.MaMB,Loai, count(MaNV) as 'TongPhiCong' from maybay m left join "
			+ "chungnhan c on m.MaMB = c.MaMB where c.MaNV is not null "
			+ "	group by m.MaMB,Loai ", nativeQuery = true)
	List<Object> findMayBayVoiTongPhiCong();

}
