# gamestore_remake

## this is a remale of capstone project, methodology as below:
1.  convert monolith JDBCTemplate to JPA project
2.  single mysql database with these tables:
    a. invoice (one to many with invoice item),
    b. invoice_item (many to one with invoice and one to one with following tables),
    c. t_shirt
    d. console
    e. game
3.  TDD

## Stages of completion:
1. see if I can do it in JPA or hibernate
2. create util which directly manipulate database tables
3. service layer
4. controller with exception handling

## update
