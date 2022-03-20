package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.mapper.UserMapper;
import bozhko_project.electronic_board.repository.UserRepository;
import bozhko_project.electronic_board.service.AccountUserDetailsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "CreateUserController", description = "API контролера по регистрации пользователя")
@Validated
public class CreateUserController {
    @Autowired
    private AccountUserDetailsService userDetailsService;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(CreateUserController.class);

    @Autowired
    public void setUserDetailsService (AccountUserDetailsService userDetailsService)
    {this.userDetailsService = userDetailsService;}

}
