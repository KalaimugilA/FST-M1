REM   Script: Activities1-5
REM   Activity 1 2 3 4 5

create TABLE salesman( 
saleman_id int NOT NULL, 
salesman_name varchar(32), 
salesman_city varchar(32), 
commission int 
);

describe salesman


describe salesman


describe salesman


describe salesman


select * from saleman;

select * from salesman;

insert into salesman values(5002,'Nail Knite','Paris',13);

insert all  
 
into salesman values(5005, 'Pit Alex', 'London', 11) 
 
into salesman values(5006, 'McLyon', 'Paris', 14) 
into salesman values(5007,'Paul Adam', 'Rome', 13) 
into salesman values(5003,'Lauson Hen', 'San Jose', 12) 
 
select 1 from dual;

SELECT * FROM salesman;

SELECT saleman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT saleman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

SELECT saleman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT saleman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

-- Add the grade column
ALTER TABLE salesman ADD grade int;

-- Update the values in the grade column
UPDATE salesman SET grade=100;

-- Display data
SELECT * FROM salesman;


-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

-- Update the grade score of James Hoog to 300.
UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

-- Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

-- Display modified data
SELECT * FROM salesman;


