package com.shippingcompany.delivery;

import com.shippingcompany.delivery.Delivery;

public class TruckDelivery extends Delivery {
    public static final double TRUCK_TOP_SPEED = 60.0;

    @Override
    public int getDuration() {
        // time = distance / rate
        double decimalHours = (double) super.getDistance() / TRUCK_TOP_SPEED;

        return convertHoursToMinutes(decimalHours) //duration in minutes
    }
}
