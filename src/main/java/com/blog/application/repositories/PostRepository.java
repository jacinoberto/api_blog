package com.blog.application.repositories;

import com.blog.application.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostModel, UUID> {


}
