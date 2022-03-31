package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.UserAuthDTO;
import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.dto.UserDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.entities.User;
import org.mapstruct.*;

import static org.mapstruct.ReportingPolicy.IGNORE;


@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE/*, uses = BCryptPasswordEncoder.class*/)
public interface UserMapper{
    /*@Mapping(source = "password", target = "password", qualifiedBy = EncodedMapping.class)*/

    UserDTO userToUserDTO(User entity);

//    @Mapping(source = "password", target = "password", qualifiedBy = EncodedMapping.class)
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


