

import java.io.*;


abstract class Plan{  
    protected double rate;  
    abstract void getRate();  

    public void calculateBill(int units){  
         System.out.println(units*rate);  
     }  
}
class  DomesticPlan extends Plan{   
     public void getRate(){  
         rate=25;              
    }  
}
class  CommercialPlan extends Plan{  
 
	    public void getRate(){   
	        rate=87;  
	   }  
}
class  InstitutionalPlan extends Plan{    
	    public void getRate(){   
	        rate=225;  
	   }   
}
class GetPlanFactory{  
      
	       public Plan getPlan(String planType){  
	            if(planType == null){  
	             return null;  
	            }  
	          if(planType.equalsIgnoreCase("DOMESTIC_PLAN")) {  
	                 return new DomesticPlan();  
	               }   
	           else if(planType.equalsIgnoreCase("COMMERCIAL_PLAN")){  
	                return new CommercialPlan();  
	            }   
	          else if(planType.equalsIgnoreCase("INSTITUTIONAL_PLAN")) {  
	                return new InstitutionalPlan();  
	          }  
	      return null;  
	   }  
	}


public class FactoryPattern {
	public static void main(String args[])throws IOException
	{  
	      GetPlanFactory planFactory = new GetPlanFactory();  
	        
	      String plan_Name ="Domestic_plan";
	      int units=75;  
	  
	      Plan p = planFactory.getPlan(plan_Name);  
	       
	  
	       System.out.print("Bill amount for "+plan_Name+" of  "+units+" units is: ");  
	           p.getRate();  
	           p.calculateBill(units);  
	            }  

}