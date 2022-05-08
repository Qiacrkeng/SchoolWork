USE ruanti212;

-- 1

SELECT NOW();

-- 2

SELECT employee_id,name,salary,salary * 1.2 as newSalary FROM emp;

-- 3

SELECT name,LENGTH(name) FROM emp ORDER BY name;

-- 4

SELECT CONCAT(name,employee_id,salary) as OUT_PUT FROM emp ;

-- 5

SELECT
	TIMESTAMPDIFF(YEAR, entry_data, NOW()) as yearNumber,
	TIMESTAMPDIFF(MONTH, entry_data, NOW()),
	TIMESTAMPDIFF(DAY, entry_data, NOW())
FROM
	emp
ORDER BY
	yearNumber;

-- 6

SELECT
	a.name,
	a.department_name,
	b.employee_id
FROM
	emp a,
	emp_history b
WHERE
	YEAR(entry_data) > 1997
	AND name IS NOT NULL
	AND (
		b.employee_id = 80
		OR b.employee_id = 90
		OR b.employee_id = 110
	);

-- 7

SELECT
	name,
	TIMESTAMPDIFF(DAY, entry_data, NOW()) as ruzhishijian
FROM
	emp
WHERE
	TIMESTAMPDIFF(DAY, entry_data, NOW()) > 10000;

-- 8

SELECT name,salary,salary * 3 as wants FROM emp;