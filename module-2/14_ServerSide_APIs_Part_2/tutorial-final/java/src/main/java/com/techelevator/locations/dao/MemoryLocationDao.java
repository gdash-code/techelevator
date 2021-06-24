package com.techelevator.locations.dao;

import com.techelevator.locations.exception.LocationNotFoundException;
import com.techelevator.locations.model.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryLocationDao implements LocationDao {

    private List<Location> locations = new ArrayList<>();

    public MemoryLocationDao() {
    	initializeLocationData();
    }

    @Override
    public List<Location> list() {
        return Collections.unmodifiableList(locations);
    }

    @Override
    public Location get(int id) throws LocationNotFoundException {
        for(Location location : locations) {
            if(location.getId() == id) {
                return location;
            }
        }

        throw new LocationNotFoundException();
    }

    @Override
    public Location create(Location location) {
        location.setId(getMaxIdPlusOne());
        locations.add(location);
        return location;
    }

    @Override
    public Location update(Location location, int id) throws LocationNotFoundException {
        Location result = location;
        boolean finished = false;

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getId() == id) {
                if( result.getId() == 0 ) {
                    result.setId(id);
                }
                locations.set(i, result);
                finished = true;
                break;
            }
        }
        if (!finished) {
            throw new LocationNotFoundException();
        }

        return result;
    }

    @Override
    public void delete(int id) throws LocationNotFoundException {
        boolean found = false;
        // avoid concurrent modification exception using iterator
        for(Iterator<Location> iterator = locations.iterator(); iterator.hasNext(); ) {
            Location Location = iterator.next();
            if(Location.getId() == id) {
                iterator.remove();
                found = true;
            }
        }
        if( !found ) {
            throw new LocationNotFoundException();
        }
    }

    private void initializeLocationData() {
        locations.add(new Location(1,
                "Tech Elevator Cleveland",
                "7100 Euclid Ave #14",
                "Cleveland",
                "OH",
                "44103"));
        locations.add(new Location(2,
                "Tech Elevator Columbus",
                "1275 Kinnear Rd #121",
                "Columbus",
                "OH",
                "43212"));
        locations.add(new Location(3,
                "Tech Elevator Cincinnati",
                "1776 Mentor Ave Suite 355",
                "Cincinnati",
                "OH",
                "45212"));
        locations.add(new Location(4,
                "Tech Elevator Pittsburgh",
                "901 Pennsylvania Ave #3",
                "Pittsburgh",
                "PA",
                "15233"));
        locations.add(new Location(5,
                "Tech Elevator Detroit",
                "440 Burroughs St #316",
                "Detroit",
                "MI",
                "48202"));
        locations.add(new Location(6,
                "Tech Elevator Philadelphia",
                "30 S 17th St",
                "Philadelphia",
                "PA",
                "19203"));
    }

    /**
     * finds the max id in the list of locations and returns it
     *
     * @return int the max id
     */
    private int getMaxID() {
        int maxID = 0;
        for (Location Location : locations) {
            if (Location.getId() > maxID) {
                maxID = Location.getId();
            }
        }
        return maxID;
    }

    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private int getMaxIdPlusOne() {
        return getMaxID() + 1;
    }

}
