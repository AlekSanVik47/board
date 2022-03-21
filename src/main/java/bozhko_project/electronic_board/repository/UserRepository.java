package bozhko_project.electronic_board.repository;

import bozhko_project.electronic_board.for_board.User;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 User findUserByPhone (String phone);
 User findUserByEmail (String email);
 User findUserByLogin(String login);

 @Modifying
 @Query("Обновление параметра логин")
 public  void userLoginUpdate (@Param(value = "id") Integer id,
                               @Param(value = "login")String login);

 @Modifying
 @Query("Обновление параметра пароль")
 public  void userPasswordUpdate (@Param(value = "id") Integer id,
                               @Param(value = "password")String password);

 @Modifying
 @Query("Обновление параметра телефон")
 public  void userPhoneUpdate (@Param(value = "id") Integer id,
                               @Param(value = "phone")String phone);

 @Modifying
 @Query("Обновление параметра email")
 public  void userEmailUpdate (@Param(value = "id") Integer id,
                               @Param(value = "email")String email);


}