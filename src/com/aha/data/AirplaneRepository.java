/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aha.data;

import com.aha.service.AirplaneService;
import com.aha.AHA;
import com.aha.businesslogic.model.Airplane;
import com.aha.businesslogic.model.Seat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to handle airplane data
 *
 * @author HB
 */
public class AirplaneRepository implements AirplaneService {

    /**
     * Return the Airplane object with the given model name
     *
     * @param airplaneModel String representing the model of the airplane, e.g
     * "Boeing"
     * @return The Airplane object if exists, null otherwise
     */
    @Override
    public Airplane getAirplaneByModel(String airplaneModel) {
        Airplane airplane = null;
        PreparedStatement stmt = null;
        String query = "SELECT AIRPLANES.ID AS AIRPLANE_ID,\n"
                + "       AIRPLANES.MAXDISTANCE,\n"
                + "       AIRPLANES.MODEL,\n"
                + "       SEATS.ID AS SEAT_ID,\n"
                + "       SEATS.AIRPLANEID,\n"
                + "       SEATS.ROWNUMBER,\n"
                + "       SEATS.COLUMNLETTER\n"
                + "FROM AHA.AIRPLANES\n"
                + "JOIN AHA.SEATS ON SEATS.AIRPLANEID = AIRPLANES.ID "
                + "where MODEL = ?";

        try {
            stmt = AHA.connection.prepareStatement(query);
            stmt.setString(1, airplaneModel);

            ResultSet rs = stmt.executeQuery();
            List<Seat> seats = new ArrayList<Seat>();
            while (rs.next()) {

                int id = rs.getInt("AIRPLANE_ID");
                int maxDistance = rs.getInt("MAXDISTANCE");
                String model = rs.getString("MODEL");

                Seat seat = new Seat();

                int seatId = rs.getInt("SEAT_ID");
                int seatRow = rs.getInt("ROWNUMBER");
                String seatColumn = rs.getString("COLUMNLETTER");
                seat.setId(seatId);
                seat.setLetter(seatColumn);
                seat.setRow(seatRow);

                seats.add(seat);

                if (airplane == null) {
                    airplane = new Airplane();
                    airplane.setMaxDistance(maxDistance);
                    airplane.setModel(model);
                    airplane.setId(id);
                }
            }

            if (airplane != null) {
                airplane.setSeats(seats);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return airplane;

    }

    /**
     * Return all Airplane objects
     *
     * @return All Airplanes in the database
     */
    @Override
    public List<Airplane> getAirplanes() {
        List<Airplane> airplanes = new ArrayList<>();

        Statement stmt = null;
        String query = "select ID, MAXDISTANCE, MODEL "
                + "from AHA.Airplanes";
        try {
            stmt = AHA.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                int maxDistance = rs.getInt("MAXDISTANCE");
                String model = rs.getString("MODEL");

                Airplane plane = new Airplane();
                plane.setMaxDistance(maxDistance);
                plane.setModel(model);
                plane.setId(id);

                airplanes.add(plane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return airplanes;
    }

}
