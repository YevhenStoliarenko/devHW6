SELECT NAME, SALARY
FROM megasoft.worker
WHERE SALARY = (
	SELECT max(SALARY)
	FROM megasoft.worker);
	
