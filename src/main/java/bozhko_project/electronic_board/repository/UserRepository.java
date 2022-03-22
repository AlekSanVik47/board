package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 User findUserByPhone (String phone);
 User findUserByEmail (String email);
 User findUserByLogin(String login);
 //User findById(Long id);


 /*@Modifying
 @Query("UPDATE users SET login = 'login' WHERE users.id = id ")
 public  void userLoginUpdate (@Param(value = "id") Integer id,
                               @Param(value = "login")String login);

 @Modifying
 @Query("UPDATE users SET password = 'password' WHERE users.id = id")
 public  void userPasswordUpdate (@Param(value = "id") Integer id,
                               @Param(value = "password")String password);

 @Modifying
 @Query("UPDATE users SET phone = 'phone' WHERE users.id = id")
 public  void userPhoneUpdate (@Param(value = "id") Integer id,
                               @Param(value = "phone")String phone);

 @Modifying
 @Query("UPDATE users SET users.email = email WHERE users.id = id")
 public  void userEmailUpdate (@Param(value = "id") Integer id,
                               @Param(value = "email")String email);
*/
 @Transactional
 @Modifying
 @Query("update User u set u.login = ?1 where u.id = ?2")
 void loginUpdate(String login, Integer id);

}