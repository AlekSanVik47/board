package bozhko_project.electronic_board.mapper;

import bozhko_project.electronic_board.dto.UserRegistrationDTO;
import bozhko_project.electronic_board.for_board.User;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserMapper {
    UserRegistrationDTO userRegDTO(User entity);

    User UserRegistrationRequestToUser(UserRegistrationDTO dto, Integer id, String phone);
}
