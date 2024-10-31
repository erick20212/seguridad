package upeu.democontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class Democontroller {
	
	@PostMapping(value="demo")
	public String welcome() {
		return "welcome form secure endpoint";
	}

}
