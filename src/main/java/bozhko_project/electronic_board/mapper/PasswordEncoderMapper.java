package bozhko_project.electronic_board.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncoderMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @EncodedMapping
    public String encode(String value) {
        return bCryptPasswordEncoder.encode(value);
    }
}
