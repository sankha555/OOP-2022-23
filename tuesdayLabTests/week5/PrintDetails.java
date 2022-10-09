import java.io.*;
import java.util.*;

class Animal{ 
    private String name;
  
    Animal(String name){
    	this.name = name;
    }

   protected String getName(){
        return this.name;
    }
}

class Dog extends Animal{
    private String owner;
  
    Dog(String owner, String dogName){
        super(dogName);
        this.owner = owner;
    }
  
    public String getOwnerName(){
        return this.owner;
    }
  
    public void print(){
        System.out.println("Hello I am " + getOwnerName() + " and this my dog " + super.getName() + "!");
    }
}

/*
	Do not modify any code below this line!
*/

class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
      	int n = Integer.parseInt(sc.nextLine());
      
        for(int i = 0; i < n; i++){
        	String owner = sc.nextLine();
            String dog = sc.nextLine();
          	
            Dog d = new Dog(owner, dog);
            d.print();
        }
    }
}
