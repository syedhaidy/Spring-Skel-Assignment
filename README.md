# Spring-Skel-Assignment

## Assignment

- Add some attributes to the Item class, e.g. a name, a state that can have one of these three values (undefined, valid, invalid) etc.
    > Custom Validator is implemented for State Attribute  
    >Spring-Skel-Assignment/src/main/java/com/cepheid/cloud/skel/validation/
      
- Create a new entity class Description, and setup a one to many relation between Item and Description. I.e. an Item has many Descriptions.
   >Implemented One to many relationship.
   >While creating Description a new item will also be added.

- Add Item CRUD methods to the controller.
     > Creation of Item
      > Getting item by id
       >Update Item by id
       >Deleting Item by id

- Add methods to the controller to query for specific Items based on it's attributes.
    > Using JPA Query,get the item name based on the keyword search

- Add something of your own choice that uses something from the Spring framework or demonstrates some Object-Oriented Programming Concepts.
    > Implemeted RestTemplete to test API 
    > Spring-Skel-Assignment/src/main/java/com/cepheid/cloud/skel/client/

All the API Details and necessary Requestpayload is available in Spring-Skel API Details.json.Please import into Postman/Insomnia restful API testing tool to test all the functionality.
