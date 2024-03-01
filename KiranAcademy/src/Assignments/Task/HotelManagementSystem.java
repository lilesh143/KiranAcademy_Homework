package Assignments.Task;

import java.util.Arrays;

//Custom exception classes
class InvalidReservationException extends Exception {
 public InvalidReservationException(String message) {
     super(message);
 }
}

class RoomNotFoundException extends Exception {
 public RoomNotFoundException(String message) {
     super(message);
 }
}

//Guest class
class Guest {
 private String name;

 public Guest(String name) {
     this.name = name;
 }

 public String getName() {
     return name;
 }
}

//Reservation class (base class)
abstract class Reservation {
 protected Guest guest;

 public Reservation(Guest guest) {
     this.guest = guest;
 }

 public abstract void confirm() throws InvalidReservationException;
}

//Room class hierarchy
class Room {
 private int roomNumber;
 private boolean available;

 public Room(int roomNumber) {
     this.roomNumber = roomNumber;
     this.available = true;
 }

 public int getRoomNumber() {
     return roomNumber;
 }

 public boolean isAvailable() {
     return available;
 }

 public void book() {
     this.available = false;
 }

 public void cancelBooking() {
     this.available = true;
 }
}

class StandardRoom extends Room {
 public StandardRoom(int roomNumber) {
     super(roomNumber);
 }
}

class DeluxeRoom extends Room {
 public DeluxeRoom(int roomNumber) {
     super(roomNumber);
 }
}

class Suite extends Room {
 public Suite(int roomNumber) {
     super(roomNumber);
 }
}

//Reservation types
class RoomReservation extends Reservation {
 private Room room;

 public RoomReservation(Guest guest, Room room) {
     super(guest);
     this.room = room;
 }

 @Override
 public void confirm() throws InvalidReservationException {
     if (room.isAvailable()) {
         room.book();
         System.out.println("Room reservation confirmed for guest: " + guest.getName() + " in room number: " + room.getRoomNumber());
     } else {
         throw new InvalidReservationException("Room is not available for reservation.");
     }
 }
}

//Hotel class to manage rooms and reservations
class Hotel {
 private Room[] rooms;
 private Reservation[] reservations;
 private int numRooms;
 private int numReservations;

 public Hotel(int maxRooms, int maxReservations) {
     rooms = new Room[maxRooms];
     reservations = new Reservation[maxReservations];
     numRooms = 0;
     numReservations = 0;

     // Initialize rooms
     for (int i = 0; i < maxRooms; i++) {
         if (i < 100) {
             rooms[i] = new StandardRoom(i + 1);
         } else if (i < 150) {
             rooms[i] = new DeluxeRoom(i + 1);
         } else {
             rooms[i] = new Suite(i + 1);
         }
     }
     numRooms = maxRooms;
 }

 public void makeReservation(Guest guest, Room room) {
     Reservation reservation = new RoomReservation(guest, room);
     reservations[numReservations++] = reservation;
     try {
         reservation.confirm();
     } catch (InvalidReservationException e) {
         System.out.println("Failed to make reservation: " + e.getMessage());
     }
 }

 public Room findAvailableRoom() throws RoomNotFoundException {
     for (Room room : rooms) {
         if (room.isAvailable()) {
             return room;
         }
     }
     throw new RoomNotFoundException("No available rooms found.");
 }
}

//Simple command-line interface
public class HotelManagementSystem {
 public static void main(String[] args) {
     Hotel hotel = new Hotel(200, 100); // Max rooms and max reservations
     Guest guest1 = new Guest("John");
     Guest guest2 = new Guest("Lilesh");
     Guest guest3 = new Guest("Chintu");
     try {
         Room availableRoom = hotel.findAvailableRoom();
         hotel.makeReservation(guest1, availableRoom);
         Room availableRoom2 = hotel.findAvailableRoom();
         hotel.makeReservation(guest2, availableRoom2);
         Room availableRoom3 = hotel.findAvailableRoom();
         hotel.makeReservation(guest3, availableRoom3);
     } catch (RoomNotFoundException e) {
         System.out.println("Failed to make reservation: " + e.getMessage());
     }
 }
}
