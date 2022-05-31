CREATE FUNCTION A1(n INT)
RETURNS INT NO SQL 
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE result INT DEFAULT 0;
    WHILE i <= n DO
        SET result = result + i;
        SET i = i + 1;
    END WHILE;
    RETURN(result);
END;

SELECT A1(100);