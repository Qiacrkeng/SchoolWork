CREATE TRIGGER A4 
AFTER INSERT ON test4
FOR EACH ROW
BEGIN
    DECLARE num INT DEFAULT 0;
    SELECT count INTO num FROM test4
        WHERE name = NEW.name;
    UPDATE test4 SET count = count - 1
        WHERE name = NEW.name;
END;
