CREATE TABLE `cars` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `brand` LONGTEXT,
  `model` LONGTEXT,
  `year` INT(4) NOT NULL,
  `price` DECIMAL(65, 2) NOT NULL,
  `color` LONGTEXT,
  `units` INT,
  `speed` DECIMAL(5, 2),
  `power` INT
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
