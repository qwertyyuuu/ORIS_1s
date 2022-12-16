package org.example.services;

import org.example.view.PostModel;
import org.example.repo.PostsRepository;

import java.util.List;
import java.util.Optional;

public class PostService {
    private static final PostsRepository repository = new PostsRepository();
    public List<PostModel> getAllPosts() {
        return repository.findAll();
    }
    public void savePost(PostModel postModel) {
        repository.save(postModel);
    }
    public PostModel findPost(Long id) {
        Optional<PostModel> post = repository.findByID(id);

        if (post.isPresent()) {
            return post.get();
        } else {
            throw new IllegalArgumentException("No such post");
        }
    }
    public void updatePost(PostModel postModel) {
        repository.update(postModel);
    }

    public void deletePost(Long id) {
        repository.delete(id);
    }
}
