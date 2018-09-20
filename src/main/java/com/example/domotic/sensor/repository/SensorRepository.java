package com.example.domotic.sensor.repository;

import com.example.domotic.sensor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
