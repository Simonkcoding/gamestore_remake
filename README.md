# gamestore_remake

## this is a remale of capstone project, methodology as below:
1.  convert monolith JDBCTemplate to JPA project
2.  single mysql database with these tables:
    a. invoice (one to many with invoice item , one to one with customer),
    b. customer,
    c. invoice_item,
    d. t_shirt,
    e. console,
    f. game
3.  TDD

## Stages of completion:
1. see if I can do it in JPA or hibernate
2. create util which directly manipulate database tables
3. service layer
4. controller with exception handling

## update
1. sucessfully perform the one to many many to one relation among the tables
