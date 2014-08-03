Car-Configuration-Application
=============================


Unit 1-5:
To run the whole program, right click on the Car_Configuration_Web project and run on server. Then we can see the following web page pops
up:

Then go to the Car_Configuration_Client project, right click on the SocketClient class in client package and run as java application. Next the application will prompt you to type a command.
We type “upload”, and then type in the file path. After the upload is done, the application will prompt you with the same message again, so we can upload multiple files.
￼￼
￼￼!
!
Next we check the web page again. We have successfully uploaded the data and in the drop down menu for car model, we have 2 choices now.
￼
￼￼!
We can choose whichever of them and they all the corresponding options
automatically shows on the webpage.
!
￼
Then after we have made all the configuration, we click on the done
button, and the result web page shows up.
Unit 6:
The test class is the TestDB class which located in driver package, Database project. Run the class as java application and we can get the following output:
!
(1) Create a table from the *dat file.
Now we have created a new table with the .dat file..
Focus, 10000, white
Honda, 12000, silver
Hyundai, 14000, red
Benz, 16000, gold
!
(2) Insert a new item (BMW) to the existing table.
Now we're testing the insert function....
Focus, 10000, white
Honda, 12000, silver
Hyundai, 14000, red
Benz, 16000, gold
BMW, 20000, Silver
!
(3) Update the price of Benz to 30000.
Now we're testing the update function....
Focus, 10000, white
Honda, 12000, silver
Hyundai, 14000, red
Benz, 30000, gold
BMW, 20000, Silver
!
(4) Delete the Benz item.
Now we're testing the delete function....
Focus, 10000, white
Honda, 12000, silver
Hyundai, 14000, red
BMW, 20000, Silver
