
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

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
    public class updel implements Serializable {
    public user us; 
    private boolean delreq;
    boolean upreq;
    int id,origin_id;
    int phid;
    public String phdate; 
    private String phtitle,phdescription,phinstructor_Type,phinstructor,phduration,phtotal_cost,phparticipant,phcost_per_person,phstatus;

    public user getUs() {
        return us;
    }

    public void setUs(user us) {
        this.us = us;
    }

    
    public int getPhid() {
        return phid;
    }

    public void setPhid(int phid) {
        this.phid = phid;
    }

    public String getPhtitle() {
        return phtitle;
    }

    public void setPhtitle(String phtitle) {
        this.phtitle = phtitle;
    }

    public String getPhdate() {
        return phdate;
    }

    public void setPhdate(String phdate) {
        this.phdate = phdate;
    }

    

    public String getPhdescription() {
        return phdescription;
    }

    public void setPhdescription(String phdescription) {
        this.phdescription = phdescription;
    }

    public String getPhInstructor_Type() {
        return phinstructor_Type;
    }

    public void setPhInstructor_Type(String phinstructor_Type) {
        this.phinstructor_Type = phinstructor_Type;
    }

    public String getPhInstructor() {
        return phinstructor;
    }

    public void setPhInstructor(String phinstructor) {
        this.phinstructor = phinstructor;
    }

    public String getPhDuration() {
        return phduration;
    }

    public void setPhDuration(String phduration) {
        this.phduration = phduration;
    }

    public String getPhtotal_cost() {
        return phtotal_cost;
    }

    public void setPhtotal_cost(String phtotal_cost) {
        this.phtotal_cost = phtotal_cost;
    }

    public String getPhparticipant() {
        return phparticipant;
    }

    public void setPhparticipant(String phparticipant) {
        this.phparticipant = phparticipant;
    }

    public String getPhcost_per_person() {
        return phcost_per_person;
    }

    public void setPhcost_per_person(String phcost_per_person) {
        this.phcost_per_person = phcost_per_person;
    }

    public String getPhstatus() {
        return phstatus;
    }

    public void setPhstatus(String phstatus) {
        this.phstatus = phstatus;
    }
    
    
    

    public boolean isUpreq() {
        return upreq;
    }

    public void setUpreq(boolean upreq) {
        this.upreq = upreq;
    }

    public boolean isDelreq() {
        return delreq;
    }

    public void setDelreq(boolean delreq) {
        this.delreq = delreq;
    }
     public void deletes(){
        System.out.println("delete started");
        delreq=true;
    }
    public void upstart(){
        System.out.println("update start");
        upreq=true;
    }
    public String delete(emp1 l){
         System.out.println("ORGIGN ID : "+origin_id+delreq+upreq);
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        if(delreq==true){
            System.out.println("delete begins"+delreq+l.id);
            try{  
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
                Connection con = DriverManager.getConnection( "jdbc:sqlserver://192.168.11.219;databaseName=FreshersCheck","freshertraining","FrEsherP@ssw0rd");  
                Statement stmt=con.createStatement();
                System.out.println("connected");
                stmt.executeUpdate("delete from trial3 where id = '"+origin_id+"'");
                }catch(SQLException e){  
                System.out.println("SQL ERROR"+e);  
                } catch(ClassNotFoundException ce){
                System.out.println("CLASS NOT FOUND"+ce);
                }
            return "/index.xhtml?faces-redirect=true";
        }
        else if(upreq==true){
            System.out.println("inisde edit ");
            try{  
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
                Connection con = DriverManager.getConnection( "jdbc:sqlserver://192.168.11.219;databaseName=FreshersCheck","freshertraining","FrEsherP@ssw0rd");  
                Statement stmt=con.createStatement();
                System.out.println("connected");
                ResultSet s=stmt.executeQuery("select * from trial3 where id='"+origin_id+"'");
                while(s.next()){
                    phid=origin_id;
                    System.out.println("ph id : "+phid);
                    
                    phtitle=s.getString(2);
                    phdate=s.getString(3);
                    phdescription=s.getString(4);
                    phinstructor_Type=s.getString(5);
                    phinstructor=s.getString(6);
                    phduration=s.getString(7);
                    phtotal_cost=s.getString(8);
                    phparticipant=s.getString(9);
                    phcost_per_person=s.getString(10);
                    phstatus=s.getString(11);
                }
            }
            catch(SQLException e){  
                System.out.println("SQL ERROR"+e);  
                } catch(ClassNotFoundException ce){
                System.out.println("CLASS NOT FOUND"+ce);
                }}
        return ""; 
   
}
     public void id_transfer(int id){
         origin_id = id;
     }
    public updel() {
        
    }
    
}
