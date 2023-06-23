package org.example.dao;

import org.example.model.Bench;

import java.time.LocalDate;
import java.util.List;

public interface BenchDao {

    public Bench getBenchById(int benchId);

    public List<Bench> getBenches();

    public int getBenchRequirementsByBenchIdAndDate(int benchId, LocalDate date);

    public List<Bench> getBenchesTrainedByPersonId(int personId);

    public int deleteBenchById(int id);

    public Bench createBench(Bench bench);

    public Bench updateBench(Bench bench);

}
