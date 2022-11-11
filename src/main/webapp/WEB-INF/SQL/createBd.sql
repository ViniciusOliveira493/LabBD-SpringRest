CREATE DATABASE bdIot
USE bdIot
INSERT INTO BME280(dateAndTime,humidity,pressure,temperature)
    VALUES
        ('2022-11-11 13:17:32.9766667',50,10,15)
        ,('2022-11-11 14:17:32.9766667',60,9,18)
        ,('2022-11-11 15:17:32.9766667',55,8,14)
        
SELECT * FROM BME280