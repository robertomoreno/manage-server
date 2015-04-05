package org.rober.example.servlet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roberto on 05/04/2015.
 */

@RestController
public class WhateverController {

    @RequestMapping("/dosomething")
    public String doSomeThing() {
        return "doing stuff";
    }
}
