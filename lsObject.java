package src;
import java.lang.Comparable;
import java.util.Arrays;
public  class lsObject implements Comparable< lsObject> {
    String stage;
    String day;
    String time;
    String[] areas;
/**
 * 
 * @param stage
 * @param day
 * @param time
 */    
public lsObject(String stage,String day, String time)  {
    this.stage=stage;
   this.day= day;
    this.time= time;
    areas= null;
    
}
/**
 * 
 * @param key
 */
public lsObject(String key){
    String[] info = key.split(" ",2);
     String[] varArray = info[0].split("_");
     String[] ArrayArea = info[1].split(", ");
            
    stage = varArray[0];
    day = varArray[1];
    time = varArray[2];
    this.areas = ArrayArea;
    }
/**
 * 
 * @return
 */
public String getStage(){
    return this.stage;

}
public String getday(){
    return this.day;
    
}
public String getTime(){
    return this.time;
    
}
public String[] getAreas(){
    return this.areas;
    
}
public String getInfo(){
    return stage + " " + day + " " + time;
    }

public void setStage(String stage){
     this.stage= stage;

}
public void setday(String day){
    this.day= day;
    
}
public void setTime(String time){
    this.time= time;
    

}
   public String toString()
   {
   return "Stage: "+getStage()+" Day: "+getday()+" Time: "+getTime()+" Areas afffected: "+Arrays.toString(areas);
   }
   public int compareTo(lsObject other){
    return this.getInfo().compareTo(other.getInfo());
    }
  
}