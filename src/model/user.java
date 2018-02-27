/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import view.loginUI;
import view.mainUI;
import view.registerUI;

/**
 *
 * @author Dinuthara
 */




public class user {
    
    /**
     *
     * @param 
     * @return
     */
 ArrayList PParray;
 ArrayList PRarray;
 ArrayList RParray;
 ArrayList RRarray;
 ArrayList keys;
 String name;
 
 public user(ArrayList keys,ArrayList PParray,ArrayList PRarray,ArrayList RParray,ArrayList RRarray){
     
     this.PParray = PParray;
     this.PRarray = PRarray;
     this.RParray = RParray;
     this.RRarray = RRarray;
     this.keys = keys;
     this.name = "";
 
 }
    
    
    public boolean auth(){
long temp;
int marks = 0;
float sampleCount;
float accuracy = 0;
for(int i =0 ; i<PParray.size();i++){
    temp = java.lang.Math.abs((long)PParray.get(i) - (long)registerUI.PP1array.get(i));
    if (temp<50){
      marks+=2;
    }
    else if(temp<70){
        marks+=1;
    }
    else{
     marks--;
    }
    System.out.println(Long.toString(temp));
}
for(int i =0 ; i<PRarray.size();i++){
temp = java.lang.Math.abs((long)PRarray.get(i) - (long)registerUI.PR1array.get(i));
    System.out.println(Long.toString(temp));
      if (temp<50){
      marks+=2;
    }
    else if(temp<70){
        marks+=1;
    }
    else{
     marks--;
    }

}
for(int i =0 ; i<RParray.size();i++){
temp = java.lang.Math.abs((long)RParray.get(i) - (long)registerUI.RP1array.get(i));
    System.out.println(Long.toString(temp));
      if (temp<50){
      marks+=2;
    }
    else if(temp<70){
        marks+=1;
    }
    else{
     marks--;
    }

}
for(int i =0 ; i<RRarray.size();i++){
temp = java.lang.Math.abs((long)RRarray.get(i) - (long)registerUI.RR1array.get(i));
    System.out.println(Long.toString(temp));
      if (temp<50){
      marks+=2;
    }
    else if(temp<70){
        marks+=1;
    }
    else{
     marks--;
    }

}

sampleCount = PParray.size()+PRarray.size()+RParray.size()+RRarray.size();
sampleCount*=2;
System.out.println(Float.toString((marks/sampleCount)*100));
accuracy = (marks/sampleCount)*100;

if (accuracy>70){
    return true;
}
else{
return false;
}


}
    
    
    public void login(loginUI login){
    String regName = "";
    boolean authenticated = auth();
    
   // System.out.println(Integer.toString(registerUI.keys.size()));
    
for (int i = 0; i < this.keys.size();i++){
    this.name+=this.keys.get(i);
    regName+=registerUI.keys.get(i);
}

System.out.println(this.name);
System.out.println(regName);

if(authenticated && this.name.equals(regName)){
    login.setVisible(false);
    mainUI ui = new mainUI();
    ui.show();
}
else{
System.out.println("UNSUCCESS");
}

}
    
}
