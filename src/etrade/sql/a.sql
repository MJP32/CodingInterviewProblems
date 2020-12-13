SELECT cust.first_name                AS FirstName, 
       cust.last_name                 AS LastName, 
       acc.TYPE                       AS AccountType, 
       acc.account_number             AS AccountID, 
       Ifnull(SUM(TRAN.amount), 0)    AS Total, 
       IF(acc.SHARED = '1', 'Y', 'N') AS Shared 
FROM   customer cust 
       left join account acc 
              ON cust.customer_id = acc.customer_id 
       left join TRANSACTION TRAN 
              ON acc.account_number = TRAN.account_number 
GROUP  BY acc.account_number, 
          acc.TYPE, 
          acc.SHARED, 
          cust.first_name, 
          cust.last_name; 