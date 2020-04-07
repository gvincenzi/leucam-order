package org.leucam.order.repository;

import org.leucam.order.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByActiveTrue();
    List<User> findByAdministratorTrue();
    User findByMail(String mail);
    Optional<User> findByTelegramUserId(Integer telegramUserId);
    Optional<User> findByTelegramUserIdAndActiveTrue(Integer id);
}
