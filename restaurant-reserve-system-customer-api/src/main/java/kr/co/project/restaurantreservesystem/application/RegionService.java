package kr.co.project.restaurantreservesystem.application;

import kr.co.project.restaurantreservesystem.domain.Region;
import kr.co.project.restaurantreservesystem.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();
        return regions;
    }

}
