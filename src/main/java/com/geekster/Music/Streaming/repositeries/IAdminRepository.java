package com.geekster.Music.Streaming.repositeries;

import com.geekster.Music.Streaming.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
    public boolean existsByAdminEmail(String adminEmail);

    public Admin findAdminByAdminEmail(String userEmail);
}
