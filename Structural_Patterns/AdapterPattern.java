interface Animal
{ 
    //Animal implement Animal interface that allows 
    // them to run and make sounds adapter interface 
    public void walk(); 
    public void makeSound(); 
} 
  
class Dog implements Animal
{ 
    // a concrete implementation of animal
    public void walk() 
    { 
        System.out.println("walking"); 
    } 
    public void makeSound() 
    { 
        System.out.println("bark"); 
    } 
} 
  
interface ToyAnimal 
{ 
    // target interface 
    //  dont walk they just make 
    // barking  sound 
    public void bark(); 
} 
  
class ToyDog implements ToyAnimal
{ 
    public void bark() 
    { 
        System.out.println("bark"); 
    } 
} 
  
class AnimalAdapter implements ToyAnimal 
{ 
    // You need to implement the interface your 
    // client expects to use. 
    Animal animal; 
    public AnimalAdapter(Animal animal) 
    { 
        // we need reference to the object we 
        // are adapting 
        this.animal = animal; 
    } 
  
    public void bark() 
    { 
        // translate the methods appropriately 
        animal.makeSound(); 
    } 
} 
  
class AdapterPattern
{ 
    public static void main(String args[]) 
    { 
        Dog lab = new Dog(); 
        ToyAnimal toydog = new ToyDog(); 
  
        // Wrap an animal in an animalAdapter so that it  
        // behaves like toy animal 
        ToyAnimal animalAdapter = new AnimalAdapter(lab); 
  
        System.out.println("lab Dog"); 
        lab.walk(); 
        lab.makeSound(); 
  
        System.out.println("ToyDog..."); 
        toydog.bark(); 
  
        // toy dog behaving like a Animal  
        System.out.println("AnimalAdapter..."); 
        animalAdapter.bark(); 
    } 
} 