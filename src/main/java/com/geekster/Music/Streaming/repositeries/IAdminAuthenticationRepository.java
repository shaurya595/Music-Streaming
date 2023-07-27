package com.geekster.Music.Streaming.repositeries;

import com.geekster.Music.Streaming.model.AdminAuthentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminAuthenticationRepository extends CrudRepository<AdminAuthentication,Long> {
    AdminAuthentication findByToken(String token);
}
