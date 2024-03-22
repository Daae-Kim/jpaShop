package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //data 라는 key 에 값을 hello 라는 것을 넘김.
        return "hello"; //hello -> 화면 이름 -> hello.html이 된다.

    }
}
