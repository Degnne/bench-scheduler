package org.example.dao;

import org.example.model.Bench;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public class JdbcBenchDao implements BenchDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBenchDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Bench getBenchById(int benchId) {
        return null;
    }

    @Override
    public List<Bench> getBenches() {
        return null;
    }

    @Override
    public int getBenchRequirementsByBenchIdAndDate(int benchId, LocalDate date) {
        return 0;
    }

    @Override
    public List<Bench> getBenchesTrainedByPersonId(int personId) {
        return null;
    }

    @Override
    public int deleteBenchById(int id) {
        return 0;
    }

    @Override
    public Bench createBench(Bench bench) {
        return null;
    }

    @Override
    public Bench updateBench(Bench bench) {
        return null;
    }
}
