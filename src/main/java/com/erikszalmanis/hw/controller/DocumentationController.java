package com.erikszalmanis.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DocumentationController {

    @GetMapping("/documentation")
    public String documentation(final HttpServletRequest request, final Model model) {
        final String contextPath = request.getContextPath();
        model.addAttribute("contextPath", contextPath);
        return "redoc";
    }
}
