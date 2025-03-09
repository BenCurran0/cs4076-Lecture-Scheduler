/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server_23369205;

/**
 *
 * @author bmcmo
 */
public class RequestProcessor {
    
    static String checkRequest(String request) {

        String[] parts = request.split("_");

            String command = parts[0].toUpperCase();
            String moduleCode = parts[1];

            switch (command) {
                case "ADD":
                if (parts.length < 4) {
                    return "Invalid ADD format";
                }
                return scheduleOperations.addLecture(moduleCode, parts[2], parts[3]);

                case "REMOVE":
                    scheduleOperations.removeLecture(moduleCode);
                        return "Lecture removed: " + moduleCode;
                    
                case "DISPLAY":
                    scheduleOperations.displaySchedule();
                    
                default:
                    return "Unknown command";
            }
        }
}
