package Assignments.Task.AdvanceHotelManagementSystem;

//Custom exception classes
class DuplicateEmployeeException extends Exception {
 public DuplicateEmployeeException(String message) {
     super(message);
 }
}

class InvalidTaskAssignmentException extends Exception {
 public InvalidTaskAssignmentException(String message) {
     super(message);
 }
}

//Base Employee class
class Employee {
 protected String name;
 protected int id;

 public Employee(String name, int id) {
     this.name = name;
     this.id = id;
 }

 public void performTask() {
     // Generic task execution logic
     System.out.println(name + " is performing a task.");
 }
}

//Specialized employee classes
class FrontDeskEmployee extends Employee {
 public FrontDeskEmployee(String name, int id) {
     super(name, id);
 }

 public void checkInGuests() {
     System.out.println(name + " is checking in guests.");
 }
}

class HousekeepingEmployee extends Employee {
 public HousekeepingEmployee(String name, int id) {
     super(name, id);
 }

 public void cleanRoom() {
     System.out.println(name + " is cleaning a room.");
 }
}

//Hotel class to manage employees
class Hotel {
 private FrontDeskEmployee[] frontDeskEmployees;
 private HousekeepingEmployee[] housekeepingEmployees;
 private int frontDeskCount;
 private int housekeepingCount;

 public Hotel(int maxFrontDeskEmployees, int maxHousekeepingEmployees) {
     frontDeskEmployees = new FrontDeskEmployee[maxFrontDeskEmployees];
     housekeepingEmployees = new HousekeepingEmployee[maxHousekeepingEmployees];
     frontDeskCount = 0;
     housekeepingCount = 0;
 }

 public void hireFrontDeskEmployee(String name, int id) throws DuplicateEmployeeException {
     for (int i = 0; i < frontDeskCount; i++) {
         if (frontDeskEmployees[i].id == id) {
             throw new DuplicateEmployeeException("Employee with ID " + id + " already exists.");
         }
     }
     frontDeskEmployees[frontDeskCount++] = new FrontDeskEmployee(name, id);
     System.out.println("Front desk employee hired: " + name);
 }

 public void hireHousekeepingEmployee(String name, int id) throws DuplicateEmployeeException {
     for (int i = 0; i < housekeepingCount; i++) {
         if (housekeepingEmployees[i].id == id) {
             throw new DuplicateEmployeeException("Employee with ID " + id + " already exists.");
         }
     }
     housekeepingEmployees[housekeepingCount++] = new HousekeepingEmployee(name, id);
     System.out.println("Housekeeping employee hired: " + name);
 }

 public void assignTask(String task, int employeeId) throws InvalidTaskAssignmentException {
     boolean found = false;
     for (int i = 0; i < frontDeskCount; i++) {
         if (frontDeskEmployees[i].id == employeeId) {
             frontDeskEmployees[i].performTask();
             found = true;
             break;
         }
     }
     if (!found) {
         for (int i = 0; i < housekeepingCount; i++) {
             if (housekeepingEmployees[i].id == employeeId) {
                 housekeepingEmployees[i].performTask();
                 found = true;
                 break;
             }
         }
     }
     if (!found) {
         throw new InvalidTaskAssignmentException("Employee with ID " + employeeId + " not found.");
     }
 }
}

//Main class for the Advance Hotel Management System
public class AdvanceHotelManagementSystem {
 public static void main(String[] args) {
     Hotel hotel = new Hotel(10, 10); // Max front desk and housekeeping employees
     try {
         hotel.hireFrontDeskEmployee("John", 101);
         hotel.hireHousekeepingEmployee("Alice", 201);
         hotel.assignTask("Clean room 101", 201);
     } catch (DuplicateEmployeeException | InvalidTaskAssignmentException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}
