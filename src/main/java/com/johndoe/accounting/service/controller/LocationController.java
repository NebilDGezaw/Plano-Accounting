package com.johndoe.accounting.service.controller;

import com.johndoe.accounting.service.model.Location;
import com.johndoe.accounting.service.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nebil on 12/1/18.
 */
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable long id)throws Exception{
        return locationService.getLocationById(id);
    }

    @GetMapping("/getall")
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }

/*    @PostMapping("/add")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }*/


}
