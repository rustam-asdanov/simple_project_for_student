package com.movies.royal.controller;

import com.movies.royal.model.Movie;
import com.movies.royal.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin_page")
public class AdminController {

    private final MovieService movieService;

    @GetMapping
    public String getPage(){
        return "page---admin";
    }

    @GetMapping("/addMovie")
    public String getAddMoviePage(Model model){
        model.addAttribute("movie",new Movie());
        return "page---movie---add";
    }

    @GetMapping("/getMovieBase")
    public String getMovieBase(Model model){
        model.addAttribute("movieList",null);
        return "page---movie---base";
    }

    @PostMapping("/addMovie")
    public String addMovie(
            @ModelAttribute("movie") Movie movie
    ){
        return "redirect:/admin_page/getMovieBase";
    }

    @GetMapping("/updateMovie/{id}")
    public String updateMovie(){
        return "";
    }
}
