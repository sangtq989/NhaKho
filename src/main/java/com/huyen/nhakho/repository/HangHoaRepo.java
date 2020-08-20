package com.huyen.nhakho.repository;

import com.huyen.nhakho.entity.HangHoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangHoaRepo extends CrudRepository<HangHoa,Long> {
}
