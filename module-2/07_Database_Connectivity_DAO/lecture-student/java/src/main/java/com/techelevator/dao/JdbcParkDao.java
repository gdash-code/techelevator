package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate; //cannot change once assigned

    public JdbcParkDao(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        Park retrievedPark = null; //don't know what we're going to get back

        String sqlGetPark = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park WHERE park_id = ?";

        SqlRowSet foundParks = jdbcTemplate.queryForRowSet(sqlGetPark, parkId); //whatever is found is going to be stored into foundParks
        if(foundParks.next()){
            retrievedPark = mapRowToPark(foundParks);
        }
        //paramerterized query
        return  retrievedPark;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> stateParks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " + "FROM park p" +
                "INNER JOIN park_state ps ON p.park_id = ps.park_id" +
                "WHERE ps.state_abbreviation = ?;";

        SqlRowSet stateParksResults = jdbcTemplate.queryForRowSet(sql, stateAbbreviation); //whatever is found is going to be stored into foundParks
        while(stateParksResults.next()){
            stateParks.add(mapRowToPark(stateParksResults));
        }
        return stateParks;
    }

    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park(park_name, date_established, area, has_camping)" +
                "VALUES (?, ?, ?, ?) RETURNING park_id;";
        Long newParkId = jdbcTemplate.queryForObject(sql, Long.class, park.getParkName(),
                park.getDateEstablished(), park.getArea(), park.getHasCamping());

        return getPark(newParkId);
    }

    @Override
    public void updatePark(Park park) {
        String sql = " UPDATE park" + "SET park_name = ?, date_established = ?, area = ?, has_camping = ?" +
                "WHERE park_id = ?;";
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(long parkId) {
        String sql = "DELETE FROM park_state WHERE park_id = ?;";
        jdbcTemplate.update(sql, parkId);
        sql = "DELETE FROM park WHERE park_id = ?";
        jdbcTemplate.update(sql, parkId);
    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {
    String sql = "INSERT INTO park_state (park_id, state_abbreviation) VALUES(?, ?);";
    jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park newPark = new Park();
        //assign values based on rowset given -- setters!
        newPark.setParkId(rowSet.getLong("park_id"));
        newPark.setParkName(rowSet.getString("park_name"));
        newPark.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        newPark.setArea(rowSet.getDouble("area"));
        newPark.setHasCamping(rowSet.getBoolean("has_camping"));

        return newPark;
    }//define map method first
}
