# Milankas API

For the third assignment of the Backend Training related to microservices I’d like you to follow the next assignment:

Create the next Spring Application using initializer with the following specs:

------------
Package: com.milankas.training
Artifact: milankas-api
Type: Maven Project
Java Version: 8
Packaging: Jar
Dependencies:
- Spring Web
- Lombok
- MapStruct

This application would be applying the api gateway pattern in order to communicate with the rest of the application It will also be in charge of applying the composer pattern (optionally this can go in another service) in order to retrieve:

- Orders from user /user/{userId}/orders
- Products bought by user /user/{userId}/products
- Company products /company/{companyId}/products

The milankas gateway will also expose all the endpoints from the other apis (user, order, product, company)

##### On the user-api add the following:

- JWT generation with expiration time and the user information, and use the standard jwt claims (ex. Iat, exp, iss, sub, jti)
- Add a login method with the user and password in order to generate the JWT mentioned before
- Refactor the PATCH in order to extract the password value into another endpoint /users/{userId}/change-password that will have in the body the old password and the new one
 
##### On all the APIs add the following requirement:

- Add a healthcheck endpoint /healtcheck that will return 200 each time you acceed
- Add the following constraints to the milankas gateway API:

  - An user cannot access information from other users (user and orders only) return 403 if it is forbidden.
  - The only endpoints that are allowed to everybody are login and healthchecks (for each service)
 
----------
Delivery date & review:  23/10/2020
Time: 8:30am (Let me know in advance if you will have problems to complete this task on time or if you finish before)
Deadline date of PR to develop: 22/10/2020
Deadline Time of PR: 6:00pm

If you have any doubts and/or thoughts, please let me know.

Best regards,