package stx.first.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import stx.first.one.pojo.people;

import java.util.Arrays;
import java.util.Map;

@Controller
public class helloworldController {


    @RequestMapping("login" )
    public  String hello(Map<String,Object> map){

        return "login";
    }
}
