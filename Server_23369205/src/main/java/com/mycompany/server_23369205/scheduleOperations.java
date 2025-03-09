/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server_23369205;
import java.util.HashMap;

/**
 *
 * @author bmcmo
 */
public class scheduleOperations {
    
    private static HashMap<String, String> courseSchedule = new HashMap<>(); 
    
    static String addLecture(String moduleCode, String room, String time) {
        courseSchedule.put(moduleCode, room + "_" + time);
        return "Lecture added: " + moduleCode + " " + room + "  " + time;
    }

    static String removeLecture(String moduleCode) {
        if (courseSchedule.containsKey(moduleCode)) {
            courseSchedule.remove(moduleCode);
            return "Lecture removed: " + moduleCode;
        } else {
            return "Lecture not found: " + moduleCode;
        }
    }

    static String displaySchedule() {
        if (courseSchedule.isEmpty()) {
            return "No lectures scheduled";
        }        

        StringBuilder schedule = new StringBuilder();
        for (String module : courseSchedule.keySet()) {
            schedule.append(module).append("_").append(courseSchedule.get(module)).append("/");
        }

        return schedule.toString();
    }

    

}
