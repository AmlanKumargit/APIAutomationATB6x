package com.amlankumar.modules;

import com.amlankumar.pojos.Booking;
import com.amlankumar.pojos.BookingDates;
import com.amlankumar.pojos.BookingResponse;
import com.google.gson.Gson;

public class PayLoadManager {
    public static Gson gson;

    public String CreateBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bd = new BookingDates();
        bd.setCheckin("2018-01-01");
        bd.setCheckout("2019-01-01");
        booking.setBookingdates(bd);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        return gson.toJson(booking);
    }

    public String CreateInvalidPayload() {
        return "{}";
    }

    public String FullyUpdateBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Amlan");
        booking.setLastname("Kumar");
        booking.setTotalprice(112);
        booking.setDepositpaid(false);

        BookingDates bd = new BookingDates();
        bd.setCheckin("2018-01-02");
        bd.setCheckout("2019-01-02");
        booking.setBookingdates(bd);
        booking.setAdditionalneeds("Lunch");
        gson = new Gson();
        return gson.toJson(booking);
    }

    public String PartiallyUpdateBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Partial");
        booking.setLastname("Edit");
        gson = new Gson();
        return gson.toJson(booking);
    }

    //Deserialize
    public static BookingResponse BookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse br = gson.fromJson(responseString, BookingResponse.class);
        return br;
    }

}
