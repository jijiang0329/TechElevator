package com.shippingcompany.delivery;

import com.shippingcompany.delivery.Delivery;

public class DroneDelivery extends Delivery {
    public static final double DRONE_TOP_SPEED = 100.0;

    @Override
    public int getDuration() {
        int weight = super.getShipment().getWeight();
        double topSpeedWithWeight = DRONE_TOP_SPEED / weight;
        double decimalHours = super.getDistance() / topSpeedWithWeight;
        return convertHoursToMinutes(decimalHours); //duration in minutes
    }
}
