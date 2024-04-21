package org.example.springsecurity.restcontrollers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(" api/v1/articles")
public class ArticleRestController {

    @GetMapping
    public String getAllArticles(){

        return" Getting All aritcle from database!";
    }
    @GetMapping("/read/{id}")
    public String readSingleArticle(@PathVariable int id){

        return "Reading on article!! "+id;
    }
    @PostMapping("/write")
    public String createArticle(){

        return"Creating the new article!";
    }
    @DeleteMapping("/delect/{id}")
    public String deleteArticles(@PathVariable int id){
        return"article have been Delete"+id;
    }
}
