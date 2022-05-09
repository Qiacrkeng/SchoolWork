-- 1

CREATE PROCEDURE z1() 
BEGIN 
	SELECT * FROM vol_info WHERE countScore > 50;
END; 

CALL z1() ;

-- 2

CREATE PROCEDURE z2() 
BEGIN 
	SELECT countScore FROM vol_info WHERE volunteerNumber = 100002;
END; 

CALL z2();

-- 3

CREATE PROCEDURE z3(In vNum INT) 
BEGIN 
	SELECT * FROM vol_info WHERE volunteerNumber = vNum;
END; 

CALL z3(100004);

CREATE PROCEDURE z4(In vNum INT, OUT result double(
7, 2)) 
BEGIN 
	SELECT
		countScore INTO result
	FROM
		vol_info
	WHERE
		volunteerNumber = vNum;
END; 

SET @result = 0.0;

SELECT @result;

CALL z4(100004,@result);