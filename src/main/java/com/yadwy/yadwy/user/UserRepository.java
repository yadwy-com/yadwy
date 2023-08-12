package com.yadwy.yadwy.user;

import com.yadwy.yadwy.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
