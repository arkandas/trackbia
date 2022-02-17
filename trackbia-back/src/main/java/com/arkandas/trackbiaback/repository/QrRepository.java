package com.arkandas.trackbiaback.repository;

import com.arkandas.trackbiaback.models.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface QrRepository extends JpaRepository<QrCode, Integer> {
    Optional<QrCode> findByHashId(String HashId);

    Boolean existsByHashId(String HashId);

    boolean existsByUrl(String hashId);

    void deleteByHashId(String hashId);

    @Query(value = "SELECT COUNT(*) FROM trackbia.qr_code where user_id = :user_id", nativeQuery = true)
    Integer getTotalQRsByUserId(@Param("user_id") Integer user_id);
}
