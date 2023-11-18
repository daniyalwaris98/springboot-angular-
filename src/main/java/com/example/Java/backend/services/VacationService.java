package com.example.Java.backend.services;

import com.example.Java.backend.dao.VacationRepository;
import com.example.Java.backend.entities.Vacation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    // public List<Vacation> getAllVacations() {
    //     String sql = "SELECT * FROM vacations";
    //     // return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Country.class));
    //     return jdbcTemplate.query(sql, new CountryRowMapper());
    // }

    public List<Vacation>  getAllVacations() {
        return vacationRepository.findAll();
    }

    private static class CountryRowMapper implements RowMapper<Vacation> {
        @Override
        public Vacation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Vacation vacation = new Vacation();
            vacation.setId(rs.getLong("vacation_id")); // Assuming 'vacationId' is the column name in your
                                                               // database
            vacation.setVacation_title(rs.getString("vacation_title")); // Assuming 'vacationId' is the column name in your
                                                               // database

            vacation.setImage_URL(rs.getString("image_url")); // Maps the 'vacation' column to 'vacation_name'
            vacation.setDescription(rs.getString("description")); // Maps the 'Country' column to 'country_name'
            vacation.setTravel_price(rs.getDouble("travel_fare_price")); // Maps the 'Country' column to
                                                                            // 'country_name'
            vacation.setCreateDate(rs.getTimestamp("create_date")); // Assuming 'createDate' is the column name
            vacation.setLastUpdate(rs.getTimestamp("last_update")); // Assuming 'lastUpdate' is the column name
            return vacation;
        }
    }

    public Vacation getVacationById(Long id) {
        Optional<Vacation> vacationOptional = vacationRepository.findById(id);

        if (vacationOptional.isPresent()) {
            return vacationOptional.get();
        } else {
            throw new RuntimeException("Vacation not found");
        }
    }
}
