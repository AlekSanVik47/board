package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.dto_user.UserAuthDTO;
import bozhko_project.electronic_board.dto.dto_user.UserCreationDTO;
import bozhko_project.electronic_board.dto.dto_user.UserDTO;
import bozhko_project.electronic_board.dto.dto_user.UserUpdateDTO;
import bozhko_project.electronic_board.entities.user_entities.User;
import org.mapstruct.*;

import static org.mapstruct.ReportingPolicy.IGNORE;


@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper{



    UserUpdateDTO userToUpdateDTO(User entity);

    UserAuthDTO userAuthDTO(UserAuthDTO dto);

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


