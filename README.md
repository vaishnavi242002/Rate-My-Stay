# **Rate My Stay (Hotel Review and Rating System)**

## **Description**
"Rate My Stay" is a web-based platform designed to help users find, rate, and review hotels based on their experiences. The system allows users to browse through various hotels, view ratings, and read reviews to make informed booking decisions. It is built using **Java**, **Spring Boot**, **Hibernate**, and **MySQL** for the backend, with RESTful APIs facilitating communication. JWT authentication has been integrated for secure login and session management. 

This project emphasizes user-generated content, offering a robust rating system and review mechanism that empowers travelers to share their experiences with others.

## **Screenshot**
Here is a concept illustrating the hotel's inventory and review management system:

![Inventory Control System Concept](https://chanoudgarh.com/wp-content/uploads/2023/05/Luxury-Hotels-in-India.jpg)

## **Technologies Used**
- **Java** (Core for building the business logic)
- **Spring Boot** (Framework for building microservices and backend services)
- **Hibernate** (ORM for database interaction)
- **MySQL** (Relational database for data management)
- **JWT** (JSON Web Tokens for secure authentication)
- **RESTful APIs** (For communication between the frontend and backend)
- **Maven** (For managing project dependencies)

## **Features**

### **1. Hotel Management**
- **Add New Hotels**: Admins can add new hotels to the platform. Each hotel can include detailed attributes such as name, location, available amenities, price range, and description.
- **Update Hotel Information**: Admins can update the details of hotels, such as the amenities offered, pricing changes, or any updates on availability.
- **Delete Hotels**: Admins have the ability to remove outdated or discontinued hotel listings to ensure the accuracy of the platform.
- **Fetch Hotel Information**: Users can view detailed information about each hotel, including reviews, ratings, and amenities, to make well-informed decisions.

### **2. Review & Rating System**
- **Submit Reviews**: Registered users can share their experiences by writing reviews and submitting ratings for the hotels they’ve stayed at. Reviews include descriptive text as well as a 5-star rating system.
- **View Hotel Reviews**: Prospective customers can read reviews submitted by previous guests to get an idea of the quality of service, cleanliness, and overall experience.
- **Edit/Delete Reviews**: Users can edit or delete their reviews if they want to modify their feedback or remove it entirely.
- **Sort and Filter Reviews**: Reviews can be sorted based on date or rating, allowing users to quickly find the most relevant or recent reviews.
- **Overall Hotel Rating**: The system calculates and displays an overall average rating for each hotel based on the submitted user ratings.

### **3. Authentication & Authorization**
- **JWT Authentication**: The application uses JWT (JSON Web Tokens) for secure login and session management, ensuring that only authenticated users can submit reviews and perform other user-specific actions.
- **Role-Based Access Control**: Different roles are assigned to users (e.g., Admins for hotel management, Registered Users for writing reviews) to ensure the system remains secure and organized.

### **4. Full CRUD Operations**
- **Create**: Users can create new hotel listings, reviews, and ratings.
- **Read**: Retrieve details about hotels, reviews, and overall ratings.
- **Update**: Modify existing hotel information, reviews, or ratings.
- **Delete**: Remove hotel listings or user-submitted reviews from the platform.

### **5. Advanced Search & Filter**
- **Search Hotels**: Users can search for hotels by location, name, or specific amenities.
- **Filter by Rating**: Users can filter the list of hotels based on their average rating to quickly find top-rated stays.
- **Sort by Price**: Hotels can be sorted by price range to fit the user’s budget.

### **6. Integration of External Ratings**
- **Third-Party Rating Systems**: Integrates external hotel ratings from platforms like TripAdvisor or Google Reviews to provide users with a broader perspective.

## **Getting Started**

### **Installation**

1. **Clone the repository**:
   ```bash
   git clone https://github.com/vaishnavi242002/Rate-My-Stay.git
