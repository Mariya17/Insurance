package application;

public class InsuranceFactory {

	public Insurance create(String InsuranceType){ 
	     if(InsuranceType == null){
	           return null; }
	     if(InsuranceType.equalsIgnoreCase("Car Insurance")){ 
	         return new CarInsurance(); 
	     } else if(InsuranceType.equalsIgnoreCase("Apartment Insurance")){ 
	           return new ApartmentInsurance(); 
	     } else if(InsuranceType.equalsIgnoreCase("Life Insurance")){ 
	           return new LifeInsurance(); 
		 } else if(InsuranceType.equalsIgnoreCase("Disability Insurance")){ 
			 return new DisabilityInsurance(); }
	     return null; 
	} 

}
