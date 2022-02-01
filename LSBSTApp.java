package src;
import java.io.File;
import java.util.Scanner;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random; 
import java.util.ArrayList;
import java.io.PrintWriter;
public class LSBSTApp
{   
    private BinarySearchTree<lsObject> bst;
    
    int opCount = 0;

    public LSBSTApp() {
      bst = new BinarySearchTree<lsObject>();
      
    }

    public static void main(String[] args) throws FileNotFoundException {
    
      LSBSTApp LSTree = new LSBSTApp();
      
      try {
        File shit = new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        
        Scanner scan = new Scanner(shit);

        while (scan.hasNextLine()) {

          String Lit = scan.nextLine();
          
          LSTree.insertTree(new lsObject(Lit));
          
              }
              scan.close();
              
     }catch (FileNotFoundException e){
     
     e.printStackTrace();
     
     }
     
     LSTree.Createfiles();
    
       if (args.length==3)
       
          {LSTree.printAreas(args[0], args[1], args[2]);}
          
       else if(args.length==0){
           
           LSTree.printAllAreas();}
       else{
            System.out.println("Error input entered in Incorrectly. Please Enter in the form:");
            
            System.out.println(" stage day time, i.e. 1 1 10");
       }
      }
      
     public void insertTree(lsObject other){
     
      bst.insert(other);
      }
      
    public void Createfiles() throws FileNotFoundException {
      String Samples[] = new String[] { "number 1", "number 2", "number 3", "number 4", "number 5", "number 6",
      "number 7", "number 8", "number 9", "number 10" };
      
      ArrayList<Object> findOpcount = new ArrayList<>();
      
      LSBSTApp lSTree1= new LSBSTApp();
      
      ArrayList<String> result= new ArrayList<>();
      
  int len = Samples.length;
  int Bands=0;
      int size=250;
      try {
      
        File shit = new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner scan = new Scanner(shit);

        while (scan.hasNextLine()) {

          String Lit = scan.nextLine();
          
          result.add(Lit);
             
             
              }
              scan.close();
     }catch (FileNotFoundException e){
     e.printStackTrace();
     
     }
     File shit3 = new File("./best counter BS tree"+".txt");
     
      File shit4 = new File("./Average counter BS tree"+".txt");
      
      File shit5 = new File("./worst counter BS tree"+".txt");
      
     PrintWriter pen3 = new PrintWriter(shit3);
      PrintWriter pen4 = new PrintWriter(shit4);
      PrintWriter pen5 = new PrintWriter(shit5);
      
     for (int i=0;i<len;i++ ){
       
        
       
      File shit1 = new File("./"+Samples[i]+"BS tree.txt");

      
      
      
      int j=0;
      PrintWriter pen = new PrintWriter(shit1);
      
      
      

      while(j<size){
        
        Random Rad = new Random(); 
        
        Bands = Rad.nextInt(result.size());
           
      String SRZ=result.get(Bands);
      
      pen.println(SRZ);
      j++;

      

      } 
      pen.close();
     
      try {
       
        Scanner scan = new Scanner(shit1);

        while (scan.hasNextLine()) {

          String Lit = scan.nextLine();
          
          lsObject lsobj=  new lsObject(Lit);
          
          lSTree1.insertTree(lsobj);
          
          findOpcount.add(lsobj);
          
              }
              scan.close();
              
     }
     catch (FileNotFoundException e){
     e.printStackTrace();
     
     }
     int [] opCompare = new int[297006] ;
     
     for (int k=0; k<findOpcount.size();k++){
     
       lSTree1.bst.find((lsObject) findOpcount.get(k));
       
       opCompare[k]=  lSTree1.bst.getInscount()+lSTree1.bst.getOpcount();
       
     }
     int worst= opCompare[size-1];

     int best= opCompare[1];
     
     long avrg=0;
     
     for (int num: opCompare){
     
       avrg= avrg+num;

     }
     long totalAvrg=avrg/size;
     pen5.println(worst);
     
     pen4.println(totalAvrg);
     
     pen3.println(+best);
     
     
     
     

     
     
      
      size= size+250; 
     }
     pen5.close();
     
     pen4.close();
     
     pen3.close();
     
     

     
     
     
    }
    
    public void printAreas (String stage2, String day2, String time2) 
    
    {
   
     try{
     
      System.out.println("Areas: " + Arrays.toString((bst.find(new lsObject(stage2,day2,time2)).getData()).getAreas()));
     }
    
     catch(NullPointerException e){
     
       System.out.println("Area not found!");
     }

     System.out.println("The number of insertions performed: "+Integer.toString(bst.getInscount()) );
    System.out.println("The number of comparisons formed: "+Integer.toString(bst.getOpcount()) );
    
    }

    
    public void printAllAreas () 
    {
    
     
    bst.inOrder();
    System.out.println("The number of insertions performed: "+Integer.toString(bst.getInscount()) );
     
    } 
  }


   


