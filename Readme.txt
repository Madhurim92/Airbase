Amazon Automation is a java project which uses selenium to automate the Add to cart functionality. 

Feature.java:
============

Feature.java is the main feature file where we are reading the config properties and calling various methods (based on the operations required) for the each of the brand name. 

SearchItems.java:
================

SearchItems.java is a java class that has all the modules required to Lauch the amazon website and search for an item (specified in the config properties). 
It has modules to verify the loaded page and the also to select the required brand.

filter.java:
===========

filter.java is a java class which contains methods to do various filter operations like selecting the price range and sorting based on price which can be enhanced as per the requirements of the test scenarios. 

addToCart.java:
==============

addToCart.java is a java class which containes method to add a product to the cart and verify if the same item was added to the cart. 

config.properties:
=================

Properties file which can be used to give the values needed for the 

Steps to Run the Feature.java :
1. Download the Amazon Automation file and import it on any IDE.
2. Download the required chrome webdriver on your system. 
3. Modify the chromedriverPath in the config.properties.
4. Run Feature.java file. 

ScreenRecording of the Testcase: https://drive.google.com/file/d/1U1QGddb3MhCWAb9mjZb93nI10K4oUr2G/view?usp=sharing
