package ahiru.quackpost.service;

import ahiru.quackpost.model.QuackPost;
import ahiru.quackpost.repository.IQuackPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuackPostService {
    @Autowired
    private IQuackPostRepository quackPostRepository;

    public List<QuackPost> findAll(){
        return quackPostRepository.findAll();
    }

    public Optional<QuackPost> findById(UUID id){
        return quackPostRepository.findById(id);
    }

    public QuackPost save(QuackPost quackPost){
        return quackPostRepository.save(quackPost);
    }

    public void deleteById(UUID id){
        quackPostRepository.deleteById(id);
    }
}
