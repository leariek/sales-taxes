# sales-taxes
## assumptions
* The input is read through txt documents, provided under resources.
* The file provides information about one product each line.
* Every product includes three parts of information: quantity, description, price. 
* The first part is always the number, terminated by a space character.
* After the space follows the second part, the description, up to the word "at".
* The description does not contain numbers.
* If the description contains any of the components "chocolate", "book" or "pill", the product is considered exempt.
* If the description contains the component "imported", the product is considered imported.
* After the "at" follows the third part, the price, in the format "x.xx".
* The output is written to console.

## build information
* Java Version 16.0.2
* Gradle version 7.4.2
* The application was build and run in IntelliJ