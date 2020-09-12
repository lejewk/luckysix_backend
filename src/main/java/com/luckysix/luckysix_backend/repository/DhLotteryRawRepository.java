package com.luckysix.luckysix_backend.repository;

import com.luckysix.luckysix_backend.domain.DhLotteryRaw;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DhLotteryRawRepository extends CrudRepository<DhLotteryRaw, Integer> {
    DhLotteryRaw findTopByOrderByRoundDesc();
}
