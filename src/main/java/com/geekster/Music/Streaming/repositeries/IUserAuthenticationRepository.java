package com.geekster.Music.Streaming.repositeries;

import com.geekster.Music.Streaming.model.User;
import com.geekster.Music.Streaming.model.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAuthenticationRepository  extends JpaRepository<UserAuthentication, Long> {
    public UserAuthentication findByUser(User user);
}
