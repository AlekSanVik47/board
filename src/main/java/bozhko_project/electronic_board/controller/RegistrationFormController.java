package bozhko_project.electronic_board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/regForm")
public class RegistrationFormController {
	@GetMapping
	public String getRegForm(){
		return "/regForm";
	}
}
