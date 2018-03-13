package com.snilloc.springwebdemo.controllers;

import com.snilloc.springwebdemo.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

   private JokeService jokeService;

   @Autowired
   public JokeController(JokeService jokeService) {
      this.jokeService = jokeService;
   }

   @RequestMapping("joke")
   public String getJokeOfDay(Model model) {
      model.addAttribute("jokes", jokeService.getJoke());

      // Return view name
      return "jod";
   }

}
