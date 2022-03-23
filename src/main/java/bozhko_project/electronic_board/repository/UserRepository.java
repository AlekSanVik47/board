package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 User findUserByPhone (String phone);
 User findUserByEmail (String email);
 User findUserByLogin(String login);

 @Transactional
 @Modifying
 @Query("update User u set u.login = :login, u.password = :password, u.email = :email, u.phone = :phone " +
         "where u.id = :id")
 void updateAccount(@Param("login") String login, @Param("password")
         String password, @Param("email") String email, @Param("phone")
         String phone, @Param("id") Long id);


 @Transactional
 @Modifying
 @Query("update User u set u.login = ?1 where u.id = ?2")
 void loginUpdate(String login, Long id);

}