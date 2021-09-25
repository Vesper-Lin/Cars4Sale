<p align="center"><img height="150" src="https://github.com/Vesper-Lin/Cars4Sale/blob/master/app/src/main/res/drawable-xxxhdpi/cars4sale.png" alt="Cars4Sale logo"></p>

## Cars4Sale

ANU COMP2100 : Software Design Methodologies - Group Project

## App Overview

*Car4Sale is an online marketplace, which specializes in automotive classifieds business in Australia*

## App Implemented Features
**App Activities:**

* Main Activity (*MainActivity.java*)
* Results Activity (*ResultActivity.java*)
* Details Activity (*DetailActivity.java*)
* HelpScreen Activity (*HelpScreen.java*)

**Display Features:**

* Results displayed a list using a ListView, with each result item containing the Car's brand, year, price, location.
* Constraint layout, Drawer layout for Activity layouts.

**Implemented Data Structures:**

* Binary tree - Used to store information about price and id for search function. (*DataStructure package*)
* Map -Used to store all information(id, name, location, year, price) for search function. (*DataStructure package*)
* Binary tree:insert method, find method, getHigherPrice, getLowerPrice
* Map: getLocation, getName, getYear, getYearBefore. getYearAfter.

**Query Search and Results:**

* A possible search query can be "name=mini; price>500000; location=melbourne; year<2020".
* Intakes single line search queries and processes query using implemented tokenizer and parser. (*parser and tokenizer*)
* Can handle partially correct queries and return results for several partially incorrect queries. (*parseQuery and parseModule methods in Parser class*)
* Uses String similarity comparisons to process queries with minor typos. (*StringSimilarity class, TextQuery class lines 90-106, Field enum lines 79-89*)
* Informs user when the submitted query has incorrect grammar. (*MainActivity line 63, ResultsActivity line 72*)
* Query results are ranked according to relevancy and contractor rating. (rankedRetrieve method in Query class, rankedRetrieveResults in all classes that extend the Query class)
* Query retrieveResults method parameters can be adjusted to allow different tolerances for query relevance, and different weighting for categorical and numerical fields, and to moderate the impact contractor rating on the rank. (*ResultsActivity lines 118-119, rankedRetrieve method in Query class, rankedRetrieveResults in all class that extend Query class*)
* Results display a specified number of promoted contractors at the top of the results. Promoted contractors are indicated by the label "featured user" in the results. (*Query class lines 100-111, ResultsActivity lines 130-135*)

**Data Generator:**

* *carData.xml* - Contains the data instances for 1000 car information.
* *GetRandom* - Contains method of getRandomPrice, getRandomCarModelName, getRandomLocationOfAu and getRandomYear used to generate the data instances.
* *xmlGenerator* -  generate the data instances in carData.xml.
* *StringData* - locations, carModelName


## Usage Instructions


**Starting the App**

The Main Activity is the first Activity that the user sees when he or she starts the app. In this activity, the user can submit a query to search for the appropriate car. At the bottom of this activity is a link to a help page that will provide users with a brief description of the application and further information on how to properly organize their queries. You can enter your conditions on the car in the search box (price, location, name, year), click 'go', and the qualified car information will appear. You can click each information to see more specific information.

**Search Queries**

Search requirement is structured with a search field, an operator, and the search value(s). The operator used for categorical data, such as the name field, location field, price field, and year field, is a colon `:` whereas the operators used for numerical values included equal `=`, greater than `>`, greater than or equal to `>=`, less than `<`, and less than or equal to `<=`.

Categorical fields can search for more than one word. Words are separated by either a comma `,` or whitespace

**Example Queries**

> A perfectly correct query can be
> "name=mini; price>500000; location=melbourne; year<2020".
>
> A partially correct query can be
> "nMe=mini; pircCE>500000; lOc=melbourne; Ayaer<2020".
> MyTokenizer.java can do pre-treatment to the above partially correct query.
> Thus, the query above doesn't seem to be different with
> "name=mini; price>500000; location=melbourne; year<2020"
> from the perspective of the tokenizer.
>
> A wrong query can be empty, or missing elements, or in the wrong combination.
> For instance, "", "name=", "=name mini".
> The parser will throw An IllegalArgumentException for the wrong queries above.
> Toast message will be displayed if the user enters a wrong query.

**Production Rules**

```
<exp> -> <term> | <term> ; <exp>
<term> -> <keyword> <comparison> <value>
<value> -> <unsigned string> | <unsigned integer>
<keyword> -> "name" | "location" | "price" | "year"
<comparison> -> "=" | "<" | ">"
```


## Design Summary
** Application Map **
![](https://github.com/Vesper-Lin/Cars4Sale/blob/master/design_summary.jpg)

**Car Information**
The following information was included in each car in our app.
1. Car Name
2. Car Location
3. Car Price
4. Car Year

**Data Persistence**
**Data Instances**

Our vision is to sell Australian vehicles. That's why all the production areas are In Australia. We manually wrote down the names of all the places in Australia and the types of cars and then assigned each car to a randomly generated method. For the price and year of the car, we also created the corresponding method of random production.

We think of XML as the preferred data format for storing this data because it can easily handle multiple data types, four random methods, and assign names, years, prices, and regions to 1,000 cars. Each car generates an ID so we can look it up later.

**Data Structures**

The data instance of the car is stored as a map, where the ID number of the car is key and the vehicle information is Value. The data structure is very easy to find. The time complexity of its access algorithm is small.

The binary tree is used to store the price and ID of the car, ensuring that the operation is O(height) time, which does what Map would have been inconvenient to do, and ensures a fast search response.

## Testing Summary

| Test Method   |      Code Tested     |  Code Coverage |
|----------|:-------------:|------:|
| testtree |  tree.insert | Branch Complete |
| testTokenizer |  MyTokenizer | Branch Complete |



**UserTest**

| Test Method   |      Code Tested      |  Test Cases |
|----------|:-------------:|------:|
| testGetName() | GetName() | 1 |
| testGetLocation() | GetLocation() | 1 |
| testGetAccountName() | GetAccountName()  | 1 |
| testGetYear() | GetYear() | 1 |
| testGetYearBefore() | GetYearBefore() | 1 |
| testGetYearAfter() | GetYearAfter() | 1 |
| testGetHigherPrice() | GetHigherPrice() | 1 |
| testGetLowerPrice() | GetLowerPrice() | 1 |
| testTokenizerEquity1() | MyTokenizer() | 1 |
| testTokenizerEquity2() | MyTokenizer() | 1 |
| testTokenizerInEquity1() | MyTokenizer() | 1 |
| testTokenizerInEquity2() | MyTokenizer() | 1 |


## Project Wiki
[**Wiki link**](https://github.com/Vesper-Lin/Cars4Sale/wiki).
