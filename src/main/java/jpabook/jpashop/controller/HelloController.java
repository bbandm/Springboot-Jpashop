package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HelloController {

    @RequestMapping("/")
    //컨트롤러에서 데이터를 뷰로 넘김
    public String hello() {
        log.info("home controller");
        return "home";
    }
}
