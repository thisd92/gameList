package com.devth.dslistpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devth.dslistpro.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
