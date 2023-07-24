package com.kata.clientprofilefacade.repository;

import com.kata.clientprofilefacade.entity.IPRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPRangeRepository extends JpaRepository<IPRange, Long> {
    @Query(value = "SELECT city FROM ip_ranges WHERE inet(:ipAddress) BETWEEN inet(start_ip) AND inet(end_ip)", nativeQuery = true)
    Optional<String> findCityByIpAddress(@Param("ipAddress") String ipAddress);
}
