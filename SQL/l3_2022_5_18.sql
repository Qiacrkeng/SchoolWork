-- 1
CREATE PROCEDURE update_salary_by_id_2(IN emp_id INT)
BEGIN
    DECLARE salary INT;
    DECLARE entryTime DATE;
    SELECT salary,entry_data INTO salary,entryTime 
        FROM emp WHERE employee_id = emp_id;
    IF salary < 8000 AND 
        TIMESTAMPDIFF(YEAR,entryTime,NOW()) > 5
    THEN UPDATE emp SET salary = salary + 500 
        WHERE employee_id = emp_id;
    ELSE UPDATE emp SET salary = salary + 100
        WHERE employee_id = emp_id;
    END IF;
    SELECT * FROM emp WHERE employee_id = emp_id;
END;
CALL update_salary_by_id_2(80);

-- 2
CREATE PROCEDURE calc_num(
    IN a INT,
    IN b INT,
    IN c VARCHAR(1)
)
BEGIN
    DECLARE result INT;
    CASE c
        WHEN "+" THEN
            SET result = a + b;
        WHEN "-" THEN
            SET result = a - b;
        WHEN "/" THEN
            SET result = a / b;
        WHEN "*" THEN
            SET result = a * b;
    END CASE;
    SELECT result;
END;
CALL calc_num(1,2,"+");

-- 3
CREATE PROCEDURE update_salary_loop_2(
    OUT num INT
)
BEGIN
    DECLARE averageSalary DOUBLE(7,2);
    DECLARE whileCount INT DEFAULT 0;
    SELECT AVG(salary) INTO averageSalary
        FROM emp;
    WHILE averageSalary < 12000 DO
        UPDATE emp SET salary = salary * 1.1;
        SET whileCount = whileCount + 1;
        SELECT AVG(salary) INTO averageSalary FROM emp;
    END WHILE;
    SET num = whileCount;
END;
SET @result_2 = 0;
CALL update_salary_loop_2(@result_2);
SELECT @result_2;

-- 4
CREATE PROCEDURE update_salary_while_2(
    OUT num INT
)
BEGIN
    DECLARE averageSalary INT;
    DECLARE whileCount INT DEFAULT 0;
    SELECT AVG(salary) INTO averageSalary
        FROM emp;
    WHILE averageSalary > 5000 DO
        SET whileCount = whileCount + 1;
        UPDATE emp SET salary = salary * 0.9;
        SELECT AVG(salary) INTO averageSalary
            FROM emp;
    END WHILE;
    SET num = whileCount;
END;
SET @result_3 = 0;
CALL update_salary_while_2(@result_3);
SELECT @result_3;