package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.Status;
import bozhko_project.electronic_board.dto.UserAuthDTO;
import bozhko_project.electronic_board.dto.UserCreationDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import org.mapstruct.*;


import static org.mapstruct.ReportingPolicy.IGNORE;


@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper {
    String userRegDTO(String entity);

    UserUpdateDTO userToUserDTO(User entity);

    User userCreationRequestToUser(UserCreationDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(UserUpdateDTO dto, @MappingTarget User entity);

    User updateUser(UserUpdateDTO dto, Integer id);

    User userAuth(UserAuthDTO dto, String nick);

    @AfterMapping
    default void afterMappingFromCreate(@MappingTarget User target, UserCreationDTO dto){
        target.getState();
    }

    User userAuth(UserAuthDTO dto);

    User updateUser(UserUpdateDTO dto, String surname);

}

