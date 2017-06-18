create database expense_tracker;

create user expense_user;

grant all on expense_tracker.* to 'expense_user'@'localhost' identified by 'expensetracker';


USE expense_tracker;

CREATE TABLE expenses (expense_id INT NOT NULL AUTO_INCREMENT,
expense_category VARCHAR(50) NOT NULL,
expense_date DATE NOT NULL,
expense_price DOUBLE NOT NULL,
expense_comments VARCHAR(100),
PRIMARY KEY(expense_id));

CREATE TABLE expense_user (user_id INT NOT NULL auto_increment,
user_name VARCHAR(10) NOT NULL,
password VARCHAR(10) NOT NULL,
PRIMARY KEY(user_id)
);

INSERT INTO `expense_tracker`.`expense_user` (`user_name`, `password`) VALUES ('admin', 'admin');
