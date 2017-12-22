package com.shinyay.sample.springboot.demokotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import com.shinyay.sample.springboot.demokotlin.model.fizzBuzzLambda

@Controller
class MainController {
    @GetMapping("/")
    fun index(model: Model): String {
        val fizzbuzz = fizzBuzzLambda(50)
        model.addAttribute("message", fizzbuzz)
        return "index"
    }
}