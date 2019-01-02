package com.codecool.mexicocity.dao;

import com.codecool.mexicocity.model.Rooster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoosterRepository extends JpaRepository<Rooster, Long> {

    public List<Rooster> findTop10ByOrderByWonMatchesDesc();

}
