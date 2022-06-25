package com.project.questapp.Repositories;

import com.project.questapp.Entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
