package ahiru.quackpost.service;

import ahiru.quackpost.model.QuackPost;
import ahiru.quackpost.repository.IQuackPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuackPostService {
    @Autowired
    private IQuackPostRepository quackPostRepository;

    public List<QuackPost> findAll(){
        return quackPostRepository.findAll();
    }

    public Optional<QuackPost> findById(Integer id){
        return quackPostRepository.findById(id);
    }

    public QuackPost save(QuackPost quackPost){
        return quackPostRepository.save(quackPost);
    }

    public void deleteById(Integer id){
        quackPostRepository.deleteById(id);
    }
}
