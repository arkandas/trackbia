package com.arkandas.trackbiaback.repository;


import com.arkandas.trackbiaback.models.PageView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<PageView, Long> {

    // 1. Number of visits by Blog Page
    @Query(value = "SELECT trackbia.qr_code.*, (SELECT COUNT(*) FROM trackbia.pageview WHERE trackbia.pageview.hash_id = trackbia.qr_code.hash_id) AS total_views FROM trackbia.qr_code WHERE trackbia.qr_code.user_id = :user_id ORDER BY trackbia.qr_code.creation_date DESC", nativeQuery = true)
    ArrayList<String> getQrTotalViewsByUserId(@Param("user_id") Integer user_id);

    // 2. Get Page Views last X days
    @Query(value = "select COUNT(*) from trackbia.pageview where user_id = ( ?2 ) and timestamp > current_date - ( ?1 )\\:\\:interval", nativeQuery = true)
    Integer getTotalPageViewsLastXDays(@Param("interval") String interval, @Param("user_id") Integer user_id);

    // 3. Get Total Page Views By User Id
    @Query(value = "SELECT COUNT(*) FROM trackbia.pageview WHERE user_id = :user_id", nativeQuery = true)
    Integer getTotalPageViews(@Param("user_id") Integer user_id);

    void deleteByHashId(String hashId);

    @Modifying
    @Transactional
    @Query(value = "delete from trackbia.pageview p where p.hash_id=:hashId", nativeQuery = true)
    void deleteAllByHashId(@Param("hashId") String hashId);


    // 1. Get Total Page Views
    @Query(value = "SELECT COUNT(*) FROM trackbia.pageview where hash_id = :hashId", nativeQuery = true)
    Integer getTotalPageViews(@Param("hashId") String hashId);

    // 2. Get Unique Visitors
    @Query(value = "SELECT COUNT(*) FROM (SELECT distinct on (ip_address, country) ip_address, country FROM trackbia.pageview where hash_id = :hashId) AS x", nativeQuery = true)
    Integer getUniqueVisitors(@Param("hashId") String hashId);

    // 3. Get Page Views last X days
    @Query(value = "select COUNT(*) from trackbia.pageview where hash_id = ( ?2 ) and timestamp > current_date - ( ?1 )\\:\\:interval", nativeQuery = true)
    Integer getTotalViewsLastXDaysHashId(@Param("interval") String interval, @Param("hash_id") String hash_id);

    // 4. Get Countries
    @Query(value = "SELECT COUNT(*) FROM (SELECT DISTINCT country FROM trackbia.pageview where hash_id = :hashId) AS x", nativeQuery = true)
    Integer getUniqueCountries(@Param("hashId") String hashId);

    @Query(value = "SELECT  ip_address, timestamp, page, country, country_iso_code, city, postal_code, asn_operator FROM trackbia.pageview WHERE hash_id = :hashId ORDER BY id DESC LIMIT 1000", nativeQuery = true)
    ArrayList<String> findLast1000VisitorsWeb(@Param("hashId") String hashId);

    @Query(value = "select distinct on (ip_address) ip_address, city, country, asn_number, asn_operator, latitude, longitude  FROM trackbia.pageview WHERE hash_id = :hashId", nativeQuery = true)
    ArrayList<String> findDistinctIpAddress(@Param("hashId") String hashId);
}
