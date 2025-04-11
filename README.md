## Description
Scratch game that generates a matrix from Standard symbols and Bonus symbols has been developed, a winning combintations has been designed based on which user either will win or lost. User will place a bet with any amount which we call betting amount in this assignment.

## Loosing Condition Achievement

#### 3X3 Matrix
Given Symbols are A, B, C, D, E, F

in this matrix possiblity of loossing combination is high

because [ A, B, C

          D, E, F
          
      BONUS, A , F ] ----> This is the extreme case, here possibility of loosing combination is high.

In organization(game development company) point of view, in this scenario probability of wining is high.
Hence to conculde the wining chances of the organization and user, can be altered by varing the number of symbol and size of the matrix.
 if no of symbols is >= 40 % of no of cells, then the loosing can be high.


#### 4X4 Matrix

Loosing combination cannot be achieved in 4X4 matrix

Explanation : As there are 16 cells available and we have 6 values only to be filled in the cells

for a winning combination to be achieved we need atleast 3 times a single value to be occured which will always be fullfilled as there are only 6 values and one bonus symbol to be filled in the 16th cells

calculation: 6 X 2 = 12 

16 - 12 = 4 

From 4 we can reduce one symbol for bonus, so in total we have 3 cells left for winning combination to occur

so there is always a opportunity in the 3 cells when fullfilled by any values to a achiev on winning combination.

to achieve a loosing combination in 4x4 matrix we need to increase the number of values from 6 to 8

Calculatin: 8 x 2 = 16  --> this explains that 8 values can be occured only to the max of 2 times, with which we can achieve a loosing combination.

16 = total no of available cell







## Config.json

This json file holds the below mentioned data
1) 3x3 matrix generation
2) Standard symbol occurance.
3) Bonus symbol occurance.
4) Winning combination condition
5) Special patterns - Horizantal, Vertical, Left diagonal, Right diagonal

To execute/Test use the mentioned CLI

## java -jar scratch - copy.jar --config config.json --betting-amount 100


## Test Cases

#### Bonus Miss:

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar --config config.json --betting-amount 100

{
  "matrix" : 
[ 

[ "F", "MISS", "F" ], 

[ "F", "D", "C" ],

 [ "A", "C", "D" ] 
 
],
  "reward" : 150.0,
  
  "applied_winning_combinations" : {
    "F" : [ "same_symbol_3_times" ]
  },
  
  "applied_bonus_symbol" : "MISS"
  
}

#### Winning Condition With Bonus

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar --config config.json --betting-amount 500

{
  "matrix" : [ 
  
[ "+1000", "D", "C" ], 

[ "F", "D", "F" ], 

[ "C", "F", "F" ]

 ],
  "reward" : 2125.00,
  
  "applied_winning_combinations" : 
  {
    "F" : [ "same_symbol_4_times" ]
    
  },
  
  "applied_bonus_symbol" : "+1000"
  
}
## Special Pattern Acheivemet

#### Same Symbol Vertical Occurance

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar --config config.json --betting-amount 1000

{
  "matrix" : [
  
 [ "F", "C", "F" ],
 
 [ "+500", "C", "F" ], 
 
[ "D", "C", "F" ] 

],

  "reward" : 25000.00,
  
  "applied_winning_combinations" : {
    "C" : [ "same_symbol_3_times", "same_symbols_vertically" ],
    "F" : [ "same_symbol_4_times", "same_symbols_vertically" ]
  },
  
  "applied_bonus_symbol" : "+500"
  
}

#### Same Symbol Horizontal Occurance

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar --config config.json --betting-amount 4500

{
  "matrix" : [ 
  
[ "5x", "C", "F" ],

 [ "E", "E", "E" ],
 
 [ "D", "F", "B" ] 
 
],

  "reward" : 135000,
  
  "applied_winning_combinations" : {
    "E" : [ "same_symbol_3_times", "same_symbols_horizontally" ]
  },
  "applied_bonus_symbol" : "5x"
}


#### Right to left diagonal same symbol occurance.

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar --config config.json --betting-amount 4100

{
  "matrix" : [ 
  
[ "+1000", "F", "C" ],

 [ "D", "C", "E" ], 
 
[ "C", "E", "F" ] ],


  "reward" : 206000,
  
  "applied_winning_combinations" : {
    "C" : [ "same_symbol_3_times", "same_symbols_diagonally_right_to_left" ]
  },
  "applied_bonus_symbol" : "+1000"
  
}


#### Left to right diagonal same symbol occurance.

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar --config config.json --betting-amount 10

{
  "matrix" : [ 
  
  [ "5x", "D", "C" ], 
  
  [ "E", "D", "F" ], 
  
  [ "F", "D", "E" ]
  ],
  
  "reward" : 500,
  
  "applied_winning_combinations" : {
    "D" : [ "same_symbol_3_times", "same_symbols_vertically" ]
  },
  
  "applied_bonus_symbol" : "5x"
  
}

#### No winning combination occurance/ Loosig game

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar --config config.json --betting-amount 2000

{
  "matrix" : [
  
 [ "F", "D", "A" ],
 
 [ "+500", "E", "E" ],
 
 [ "C", "B", "C" ]
 
 ],
 
  "reward" : 0
}






## configfor4X4.json

This json file holds the below mentioned data
1) 4x4 matrix generation
2) Standard symbol occurance.
3) Bonus symbol occurance.
4) Winning combination condition
5) Special patterns - Horizantal, Vertical, Left diagonal, Right diagonal

To execute/Test use the mentioned CLI

## java -jar scratch - copy.jar --config configfor4X4.json --betting-amount 100

## Test Cases

#### Winning combinatin with vertical occurance

E:\Dubai\mygameboard-scratcher>java -jar target\mygameboardscratcher.jar  --config configfor4x4.json --betting-amount 242

{
  "matrix" : [
  
  [ "D", "F", "F", "D" ],
  
  [ "+500", "F", "E", "F" ], 
  
  [ "E", "F", "C", "C" ], 
  
  [ "C", "F", "B", "E" ] ],
  
  "reward" : 2847.4,
  
  "applied_winning_combinations" : {
    "C" : [ "same_symbol_3_times" ],
    "E" : [ "same_symbol_3_times" ],
    "F" : [ "same_symbol_6_times", "same_symbols_vertically" ]
  },
  
  "applied_bonus_symbol" : "+500"
  
}









