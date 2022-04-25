
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author priyadharshini.p
 */
public class emp1 {
    public int id;
    public String title;
    public String date;
    public String description;
    public String instructor_Type;
    public String instructor;
    public String duration;
    public String total_cost;
    public String participant;
    public String cost_per_person;
    public String status;
    private String titleerror,descriptionerror,total_costerror,participant_error,duration_error,instructorerror;

    public emp1(int id, String title, String date, String description, String instructor_Type, String instructor, String duration, String total_cost, String participant, String cost_per_person, String status) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.instructor_Type = instructor_Type;
        this.instructor = instructor;
        this.duration = duration;
        this.total_cost = total_cost;
        this.participant = participant;
        this.cost_per_person = cost_per_person;
        this.status = status;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor_Type() {
        return instructor_Type;
    }

    public void setInstructor_Type(String instructor_Type) {
        this.instructor_Type = instructor_Type;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(String total_cost) {
        this.total_cost = total_cost;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getCost_per_person() {
        return cost_per_person;
    }

    public void setCost_per_person(String cost_per_person) {
        this.cost_per_person = cost_per_person;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitleerror() {
        return titleerror;
    }

    public void setTitleerror(String titleerror) {
        this.titleerror = titleerror;
    }

    public String getDescriptionerror() {
        return descriptionerror;
    }

    public void setDescriptionerror(String descriptionerror) {
        this.descriptionerror = descriptionerror;
    }

    public String getTotal_costerror() {
        return total_costerror;
    }

    public void setTotal_costerror(String total_costerror) {
        this.total_costerror = total_costerror;
    }

    public String getParticipant_error() {
        return participant_error;
    }

    public void setParticipant_error(String participant_error) {
        this.participant_error = participant_error;
    }

    public String getDuration_error() {
        return duration_error;
    }

    public void setDuration_error(String duration_error) {
        this.duration_error = duration_error;
    }

    public String getInstructorerror() {
        return instructorerror;
    }

    public void setInstructorerror(String instructorerror) {
        this.instructorerror = instructorerror;
    }
    
    
    
}
