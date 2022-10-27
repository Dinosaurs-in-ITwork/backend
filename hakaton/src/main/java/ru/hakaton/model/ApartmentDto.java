package ru.hakaton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartmentDto {
    private String location;
    private Integer numberOfRooms;
    private String segment;
    private Integer numberOfHouseFloors;
    private String wallMaterial;
    private Integer floor;
    private Double square;
    private Double squareOfKitchen;
    private Boolean balconyPresence;
    private Integer distanceFromMetroInMin;
    private String repairStatus;
}
