package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.Status;
import bozhko_project.electronic_board.dto.UserRegistrationDTO;
import bozhko_project.electronic_board.dto.UserUpdateDTO;
import bozhko_project.electronic_board.for_board.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import static bozhko_project.electronic_board.dto.Status.*;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper {
    String userRegDTO(String entity);

    User userRegistrationRequestToUser(UserRegistrationDTO dto, Integer id, String surname);

    User updateUser(UserUpdateDTO dto, String surname);

    @AfterMapping
    default void afterMappingFromCreate(@MappingTarget User target, UserRegistrationDTO dto){
        target.setStatus(Status.NEW);
    }
}
