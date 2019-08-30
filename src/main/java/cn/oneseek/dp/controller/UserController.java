package cn.oneseek.dp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/index")
    public String user(@AuthenticationPrincipal Principal principal, Model model){

        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }
        return "index";
    }

    @GetMapping("/echarts")
    public String echarts(@AuthenticationPrincipal Principal principal, Model model){

        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }
        return "charts";
    }

    @GetMapping("/table")
    public String table(@AuthenticationPrincipal Principal principal, Model model){

        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }
        return "table";
    }

    @GetMapping("/about")
    public String about(@AuthenticationPrincipal Principal principal, Model model){
        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }

        return "about";
    }


    @GetMapping("/n1")
    public String n1(@AuthenticationPrincipal Principal principal, Model model){

        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }
        return "n1";
    }
    @GetMapping("/n2")
    public String n2(@AuthenticationPrincipal Principal principal, Model model){

        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }
        return "n2";
    }

    @GetMapping("/n3")
    public String n3(@AuthenticationPrincipal Principal principal, Model model){

        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }
        return "n3";
    }

    @GetMapping("/n4")
    public String n4(@AuthenticationPrincipal Principal principal, Model model){

        try {
            model.addAttribute("username", principal.getName());
        }catch (NullPointerException e){
            e.printStackTrace();
            return "login";
        }
        return "n4";
    }
}
