package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.dto.UserDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.entities.User;
import com.sun.xml.bind.v2.runtime.output.Encoded;
import org.hibernate.exception.spi.Configurable;
import org.mapstruct.*;
import org.springframework.data.convert.ConfigurableTypeInformationMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static org.mapstruct.ReportingPolicy.IGNORE;


@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper{


    UserDTO userToUserDTO(User entity);


    UserUpdateDTO userToUpdateDTO(User entity);


    UserCreationDTO createNewUser(User entity);

    User userCreationToUser(UserCreationDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(UserUpdateDTO dto, @MappingTarget User entity);


    @AfterMapping
    default void afterMappingFromCreate(@MappingTarget User target, UserCreationDTO dto){
        target.getState();
    }


    User updateUser(UserUpdateDTO dto, Integer id);

    User updateUser(UserUpdateDTO dto, String surname);

    User getUserById(Long id);
}


