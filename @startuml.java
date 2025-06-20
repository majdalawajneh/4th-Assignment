@startuml

class Booking {
    - UserInfo customer
    - int booking_id
    - long checkInDateTime
    - long checkOutDateTime
    - String bookingType
    - int person
    - int roomsFare
    + int getBooking_id()
    + void setBooking_id(int booking_id)
    + String getBookingType()
    + void setBookingType(String bookingType)
    + void addRoom(String roomNo)
    + void removeRoom(String roomNo)
    + int getPerson()
    + void setPerson(int person)
    + ArrayList<Room> getRooms()
    + int getRoomsFare()
    + UserInfo getCustomer()
    + void setCustomer(UserInfo customer)
    + void setCheckOutDateTime(int checkOutDateTime)
    + long getCheckInDateTime()
    + void setCheckInDateTime(long checkInDateTime)
    + long getCheckOutDateTime()
    + void setCheckOutDateTime(long checkOutDateTime)
}

class ExtraOrders {
    - int order_id
    - int customer_id
    - String dateTime
    - int quantity
    - Item item
    + int getOrder_id()
    + void setOrder_id(int order_id)
    + int getCustomer_id()
    + void setCustomer_id(int customer_id)
    + String getDateTime()
    + void setDateTime(String dateTime)
    + int getQuantity()
    + void setQuantity(int quantity)
    + Item getItem()
    + void setItem(Item item)
    + int calculateTotal()
}

class Food {
    - int food_id
    - String name
    - int price
    + int getFood_id()
    + void setFood_id(int food_id)
    + String getName()
    + void setName(String name)
    + int getPrice()
    + void setPrice(int price)
}
class Item {
    - int item_id
    - String item_name
    - String description
    - int price
    + int getItem_id()
    + void setItem_id(int item_id)
    + String getItem_name()
    + void setItem_name(String item_name)
    + String getDescription()
    + void setDescription(String description)
    + int getPrice()
    + void setPrice(int price)
}

class Room {
    - int room_id
    - String room_no
    - int bed_number
    - boolean hasTV
    - boolean hasWIFI
    - boolean hasGizer
    - boolean hasPhone
    - RoomFare room_class
    + int getRoom_id()
    + void setRoom_id(int room_id)
    + String getRoom_no()
    + void setRoom_no(String room_no)
    + int getBed_number()
    + void setBed_number(int bed_number)
    + boolean isHasTV()
    + void setHasTV(boolean hasTV)
    + boolean isHasWIFI()
    + void setHasWIFI(boolean hasWIFI)
    + boolean isHasGizer()
    + void setHasGizer(boolean hasGizer)
    + boolean isHasPhone()
    + void setHasPhone(boolean hasPhone)
    + RoomFare getRoom_class()
    + void setRoom_class(RoomFare room_class)
}

class RoomFare {
    - String room_type
    - int pricePerDay
    + String getRoom_type()
    + void setRoom_type(String room_type)
    + int getPricePerDay()
    + void setPricePerDay(int pricePerDay)
}
class UserInfo {
    - int customer_id
    - String name
    - String address
    - String phone_no
    - String type
    + int getCustomer_id()
    + void setCustomer_id(int customer_id)
    + String getName()
    + void setName(String name)
    + String getAddress()
    + void setAddress(String address)
    + String getPhone_no()
    + void setPhone_no(String phone_no)
    + String getType()
    + void setType(String type)
}

@enduml
class DatabaseOperation {
    - Connection conn
    + Connection connect()
    + void disconnect()
    + ResultSet select(String query)
    + int insert(String query)
    + int update(String query)
    + int delete(String query)
}
class BookingDb {
    - DatabaseOperation dbOp
    + BookingDb()
    + void addBooking(Booking booking)
    + Booking getBookingById(int bookingId)
    + List<Booking> getAllBookings()
    + void updateBooking(Booking booking)
    + void deleteBooking(int bookingId)
}
class FoodDb {
    - DatabaseOperation dbOp
    + FoodDb()
    + void addFood(Food food)
    + Food getFoodById(int foodId)
    + List<Food> getAllFood()
    + void updateFood(Food food)
    + void deleteFood(int foodId)
}
class RoomDb {
    - DatabaseOperation dbOp
    + RoomDb()
    + void addRoom(Room room)
    + Room getRoomById(int roomId)
    + List<Room> getAllRooms()
    + void updateRoom(Room room)
    + void deleteRoom(int roomId)
}
class UserDb {
    - DatabaseOperation dbOp
    + UserDb()
    + void addUser(UserInfo user)
    + UserInfo getUserById(int userId)
    + List<UserInfo> getAllUsers()
    + void updateUser(UserInfo user)
    + void deleteUser(int userId)
}
class Test {
    + void main(String[] args)
}
