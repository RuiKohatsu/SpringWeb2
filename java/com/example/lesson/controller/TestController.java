package com.example.lesson.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Controller
public class TestController {

//    @GetMapping("/date")
//    @ResponseBody
//    public String date(@RequestParam(name="month", defaultValue = "1") int month,
//                       @RequestParam(name="day", defaultValue = "1") int day) {
//        return month + "月" + day + "日です。";
//    }
//
//    @GetMapping("/date/{month}/{day}")
//    @ResponseBody
//    public String date1(@PathVariable("month") int month,
//                        @PathVariable("day") int day ){
//        return month + "月" + day +"日です。";
//    }

    // 追加
    @GetMapping("input")
    //@ResponseBodyを使用するとinput文字列が返されるだけとなる
    public String input() {
        return "input"; //URLでinputにアクセスしたとき,returnにある文字列を含むファイル名のhtmlファイルが呼び出される
    }

//    @PostMapping("output")  //htmlファイルのaction属性と結びついている
//                           //Mappringのパスが同じでもメソッド名が異なれば違うリクエストとして認識される
//    @ResponseBody
//    public String output(@RequestParam(name="userName") String userName) {
//        return "<p>ようこそ" + userName + "さん</p>";
//    }

    @PostMapping("output")
    public String output(@RequestParam(name="userName") String userName, Model model) {
        model.addAttribute("n", userName);
        return "output";
    }



// ...

    // レコードクラスをフィールドに追加
    private record User(String name, String role){}

    // メソッド追加
    @GetMapping("user-list")
    public String userList(Model model) {

        List list = List.of(
                new User("Yamada", "admin"),
                new User("Saito", "admin"),
                new User("Kimura", "user"),
                new User("Nakayama", "user")
        );

        model.addAttribute("users", list);

        return "user-list";
    }
}