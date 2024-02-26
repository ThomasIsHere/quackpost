package ahiru.quackpost.controller;

import ahiru.quackpost.model.QuackPost;
import ahiru.quackpost.service.QuackPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/quack_post")
public class QuackPostController {
    @Autowired
    private QuackPostService quackPostService;

    @GetMapping
    public List<QuackPost> findAll(){
        return quackPostService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<QuackPost> findById(@PathVariable UUID id){
        return quackPostService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public QuackPost save(@RequestBody QuackPost quackPost){
        return quackPostService.save(quackPost);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public QuackPost update(@RequestBody QuackPost quackPost){
        return quackPostService.save(quackPost);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        quackPostService.deleteById(id);
    }

}
