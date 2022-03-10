package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.Status;
import bozhko_project.electronic_board.dto.UserRegistrationDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper {
    String userRegDTO(String entity);

    UserUpdateDTO userToUserDTO(User entity);

    User userRegistrationRequestToUser(UserRegistrationDTO dto);

    User updateUser(UserUpdateDTO dto, Integer id);

    @AfterMapping
    default void afterMappingFromCreate(@MappingTarget User target, UserRegistrationDTO dto){
        target.setStatus(Status.NEW);
    }

    User updateUser(UserUpdateDTO dto, String surname);


}
