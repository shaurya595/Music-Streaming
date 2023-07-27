package com.geekster.Music.Streaming.repositeries;

import com.geekster.Music.Streaming.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User,Long> {
    public User findByUserEmail(String userEmail);

    public boolean existsByUserEmail(String userEmail);
}
