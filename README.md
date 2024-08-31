# URL_Shortener

# Features

Shorten URL: Convert a long URL into a shortened version.


Redirect URL: Redirect users to the original URL using the shortened version.


RESTful API: Exposes endpoints for shortening and redirecting URLs.


Error Handling: Handles invalid URLs and missing resources gracefully.

# Technologies Used

Backend: Spring Boot


Database: MongoDB


Java Version: 17


Build Tool: Maven

# Project Structure


URL_Shortener/  
│  
├── src/main/java/com/balram/urlShortner/  
│   ├── controller/         # REST Controllers  
│   ├── domain/dto/url/     # Data Transfer Objects  
│   ├── entities/           # Entity classes  
│   ├── exceptions/         # Custom exceptions  
│   ├── repository/         # MongoDB Repositories  
│   └── service/            # Service layer  
│  
├── src/main/resources/  
│   └── application.properties  # Spring Boot configuration  
│  
├── src/test/java/            # Unit and integration tests  
│  
├── pom.xml                   # Maven dependencies  
└── README.md                 # Project documentation

# Contact

Author: Balram Ishwar


Email: ishwarbalram22@gmail.com
