package com.johndoe.accounting.service.service;

import com.johndoe.accounting.service.model.Location;
import com.johndoe.accounting.service.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nebil on 11/30/18.
 */
@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

/*    public void addLocation(Location locationRequest){
        Location location = new Location();
        location.setZipCode(locationRequest.getZipCode());
        location.setState(locationRequest.getState());
        location.setCity(locationRequest.getCity());
        location.setAddress(locationRequest.getAddress());
        locationRepository.save(location);
    }*/

    public Location getLocationById(long id)throws Exception{
        return locationRepository.findById(id).orElseThrow(()->new Exception());
    }

    public List<Location> getAllLocations(){
        List<Location> locations = new ArrayList<>();
        for(Location location: locationRepository.findAll()){
            locations.add(location);
        }
        return locations;
    }

}
