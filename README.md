[ATM Demo - How it works] {3 Min}
https://www.youtube.com/watch?v=MqsNHeupuuI&ab_channel=%D0%A1%D1%82%D0%B0%D0%BD%D0%B8%D0%BC%D0%B8%D1%80%D0%A1%D0%B5%D1%80%D0%B3%D0%B5%D0%B2

[Introduction]
This documentation provides an overview of a Java ATM project that utilizes the MongoDB database to store user information and the AWS S3 database to store all images and backgrounds.
The project is designed to simulate an Automated Teller Machine (ATM) and allows users to perform common banking tasks such as:
- Login and Registration fields (checked by regular expressions)
- Checking account balance
- Withdrawing cash
- Depositing money
- Transferring funds
- Changing PIN
- Account information
- Permanently delete the account
- Simple donation system
- Transactions History
- Dark mode

[Technologies Used]
Java 18
Java Swing
MongoDB
AWS S3

[Security]
- The application uses a secure connection to communicate with the MongoDB instance.
- User passwords are hashed and salted before being stored in the database.

[Problems with the application that I am aware of]
1) Fixed screen size - I found it impossible to resize the window with fixed background size images.

[Additional Information]
To access the images, you have two options. 
- The first option is to access them from an AWS S3 database, but this method may have a slower load time of around 10 seconds. 
- The second option is to access them from a local folder within your Images folder, which may be a faster option. (default)
You can choose which method to use based on your preferences and requirements for accessing the images. 
(Comment and Uncomment the constructor in Images(Folder) -> IMG class)

[Start the program]
You need to have MongoDB and replace the String located in
Pages -> Main Pages -> StartPage.class 23rd line with your String connector. Keep in mind that if you try to launch the program without changing the row you won't be able to close it.

[Conclusion]
This Java ATM project utilizes MongoDB and AWS S3 to provide a secure and scalable banking application.
The application is designed to handle common banking tasks and can be easily extended to include additional functionality.

