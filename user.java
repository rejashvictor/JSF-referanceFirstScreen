
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.jboss.weld.context.RequestContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author priyadharshini.p
 */
@ManagedBean
@ViewScoped
public class user {

    @ManagedProperty(value = "#{updel}")
    private updel ud_o;
    private int id;
    private String title;
    private Date date;
    private String description;
    public String instructor_Type;
    private String instructor;
    private String duration;
    public String total_cost;
    public String participant;
    public String cost_per_person;
    private String status;
    private String titleerror, descriptionerror, total_costerror, participant_error, duration_error, instructorerror, instructerr;
    public int tc=0,pc=0;
    public boolean instlist,instname;
    public String instructor_name;

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public boolean isInstlist() {
        return instlist;
    }

    public void setInstlist(boolean instlist) {
        this.instlist = instlist;
    }

    public boolean isInstname() {
        return instname;
    }

    public void setInstname(boolean instname) {
        this.instname = instname;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
    
    public updel getUd_o() {
        return ud_o;
    }

    public void setUd_o(updel ud_o) {
        this.ud_o = ud_o;
    }

    public boolean isDelreq() {
        return delreq;
    }

    public void setDelreq(boolean delreq) {
        this.delreq = delreq;
    }
    private boolean delreq;
    private List<emp1> ab;

    public List<emp1> getAb() {
        return ab;
    }

    public void setAb(List<emp1> ab) {
        this.ab = ab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public void valid_titlename() {
        if (title.matches("^[a-zA-Z]*$")) {
            titleerror = "";
        } else {
            titleerror = "Title must be Alphabets";
        }
    }

    public void valid_description() {
        if (description.matches("^[a-zA-Z0-9]*$") && description.length() > 10) {
            descriptionerror = "";
        } else {
            descriptionerror = "Description must be more than 10 characters";
        }
    }

    public void validcost() {
        System.out.println("inside totalcost"+pc);
        if (total_cost.matches("^[0-9]*$")) {
            total_costerror = "";
            tc=Integer.parseInt(total_cost);
            if(pc==0){
                  int a=Integer.parseInt(total_cost);
                cost_per_person=String.valueOf(a/1);
            }else{
                  int a=Integer.parseInt(total_cost);
                int b=Integer.parseInt(participant);
                cost_per_person=String.valueOf(a/pc);
                System.out.println("total cost"+cost_per_person);
            }
            System.out.println("this is tc : "+tc);
        } 
        else {
            total_costerror = "Numeric only";
        }
    }

    public void validparticipant() {
        System.out.println("inside #of"+tc);
        if (participant.matches("^[0-9]*$") ) {
//            int a;
//            a = Integer.parseInt(total_cost) / Integer.parseInt(participant);
//            cost_per_person = a + "";
            participant_error = "";
            pc=Integer.parseInt(participant);
            System.out.println("inside if #of"+total_cost);
            if(tc==0){
                 int D=Integer.parseInt(participant);
                  cost_per_person=String.valueOf(D/1);
            }else{
                 int c=Integer.parseInt(total_cost);
                int D=Integer.parseInt(participant);
                cost_per_person=String.valueOf(tc/D);
                System.out.println("costper"+cost_per_person);
            }
           
        } else {

            participant_error = "Numeric only";
        }
//        RequestContext.getCurrentInstance().update("UPR");
    }

    public void validduration() {
        if (duration.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            duration_error = "";
        } else {

            duration_error = "Must be hours";
        }
    }

    public void valid_instructor() {
        if (instructor.matches("^[a-zA-Z]*$")) {
            instructorerror = "";
        } else {
            instructorerror = "Instructor must be Alphabets";
        }
    }

    public int valid_costperperson() {
//        int a;
//        a = total_cost /participant;
        return 0;
    }

    public void valid_date() throws ParseException {

    }

//    public String valid_status() throws ParseException {
//        Date date1 = new Date();
//        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
//        boolean a = date1.after(date2);
//        boolean b = date1.before(date2);
//        if (a == true) {
//            status = "3";
//        } else if (b == true) {
//            status = "1";
//        } else {
//            status = "2";
//        }
//        return status;
//    }
    
    //Status validation
    public String statusvalidate(){ 
          Date now = new Date();
          if(now.compareTo(date)<0){
              status="3";//2
          }else{
              status="2";
          }
          System.out.println("status validation"+now.compareTo(date));
           return "/index.xhtml?faces-redirect=true";
          
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

  
    public String getInstructerr() {
        return instructerr;
    }

    public void setInstructerr(String instructerr) {
        this.instructerr = instructerr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String refresh() {
        return "/index.xhtml?faces-redirect=true";

    }

    public void edit() {

    }

    public List<emp1> list() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.11.219;databaseName=FreshersCheck", "freshertraining", "FrEsherP@ssw0rd");
            Statement stmt = con.createStatement();
            ResultSet s = stmt.executeQuery("select*from trial3");
            ab = new ArrayList<>();
            while (s.next()) {

//               ab.add(new emp1(s.getInt(1)), s.getString(2), s.getDate(3), s.getString(4), s.getString(5), s.getString(6), s.getString(7), s.getString(8), s.getString(9), s.getString(10), s.getString(11));
                ab.add(new emp1(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getString(5), s.getString(6), s.getString(7), s.getString(8), s.getString(9), s.getString(10), s.getString(11)));
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR" + e);
        } catch (ClassNotFoundException ce) {
            System.out.println("CLASS NOT FOUND" + ce);
        }
        return ab;
    }

    public void instruct() {
        if (instructor_Type.equalsIgnoreCase("Internal")) {

        } else if (instructor.matches("^[a-zA-Z]*$")) {
            instructorerror = "";
        } else {
            instructorerror = "Instructor must be Alphabets";
        }
    }
    


    public String save() {
        if (ud_o.upreq == true) {
            System.out.println(title + "" + date + "" + description + "" + instructor_Type + "" + instructor + "" + duration + "" + total_cost + "" + participant + "" + cost_per_person + "" + status + "" + ud_o.id);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.11.219;databaseName=FreshersCheck", "freshertraining", "FrEsherP@ssw0rd");
                Statement stmt = con.createStatement();
                System.out.println("connected");
                if (title.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set title='" + title + "' where id='" + ud_o.phid + "'");
                }
                if (date.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set date='" + date + "' where id='" + ud_o.phid + "'");
                }
                if (description.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set description='" + description + "' where id='" + ud_o.phid + "'");
                }
                if (instructor_Type.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set instructor_Type='" + instructor_Type + "' where id='" + ud_o.phid + "'");
                }
                if (instructor.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set instructor ='" + instructor + "' where id='" + ud_o.phid + "'");
                }
                if (duration.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set duration='" + duration + "' where id='" + ud_o.phid + "'");
                }
                if (total_cost.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set total_cost='" + total_cost + "' where id='" + ud_o.phid + "'");
                }
                if (participant.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set participant='" + participant + "' where id='" + ud_o.phid + "'");
                }
                if (cost_per_person.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set cost_per_person='" + cost_per_person + "' where id='" + ud_o.phid + "'");
                }
                if (status.equals("") == false) {
                    stmt.executeLargeUpdate("update trial3 set status='" + status + "' where id='" + ud_o.phid + "'");
                }

            } catch (SQLException e) {
                System.out.println("SQL ERROR" + e);
            } catch (ClassNotFoundException ce) {
                System.out.println("CLASS NOT FOUND" + ce);
            }
        } else {
            if (title != null && date != null && description != null && instructor_Type != null && instructor != null && duration != null && total_cost != null && participant != null && cost_per_person != null && status != null) {
                try {
                    System.out.println("inside save method fof");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.11.219;databaseName=FreshersCheck", "freshertraining", "FrEsherP@ssw0rd");
                    Statement stmt = con.createStatement();
                    System.out.println("connected");
                    stmt.executeUpdate("insert into trial3(title,date,description,instructor_Type,instructor,duration,total_cost,participant,cost_per_person,status) values('" + title + "','" + sdf.format(date) + "','" + description + "','" + instructor_Type + "','" + instructor + "','" + duration + "','" + total_cost + "','" + participant + "','" + cost_per_person + "','" + status + "')");
                } catch (SQLException e) {
                    System.out.println("SQL ERROR" + e);
                } catch (ClassNotFoundException ce) {
                    System.out.println("CLASS NOT FOUND" + ce);
                }
   
            }
            return "/index.xhtml?faces-redirect=true";
        }
        return "/index.xhtml?faces-redirect=true";
    }
    public void instructor_t(){
        System.out.println("this is instructor : "+instructor_Type);
        if(instructor_Type.equalsIgnoreCase("Internal")){
            instlist=true;
            instname=false;
        }else if(instructor_Type.equalsIgnoreCase("External")){
            instname=true;
            instlist=false;
        }
        System.out.println("after event : "+instlist);
        System.out.println("after event : "+instname);
    }
    
    public void setvalues() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("this is titler" +ud_o.getPhtitle());
        title=ud_o.getPhtitle();
        date=sdf.parse(ud_o.getPhdate());
        description=ud_o.getPhdescription();
        instructor_Type=ud_o.getPhInstructor_Type();
        instructor=ud_o.getPhInstructor();
        duration=ud_o.getPhDuration();
        total_cost=ud_o.getPhtotal_cost();
        participant=ud_o.getPhparticipant();
        cost_per_person=ud_o.getPhcost_per_person();
        status=ud_o.getPhstatus();
      
        
    }

}
