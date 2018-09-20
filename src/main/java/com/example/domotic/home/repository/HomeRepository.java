package com.example.domotic.home.repository;

import com.example.domotic.home.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}
