SELECT t.months, ID
FROM(SELECT ID, round(datediff(FINISH_DATE, START_DATE)/ 30) as months
	FROM megasoft.project p
	GROUP BY ID)t
    GROUP BY ID
    HAVING t.months = (
		SELECT MAX(c.months)
        FROM(
			SELECT round(datediff(FINISH_DATE, START_DATE)/ 30) as months
			FROM megasoft.project p)c
		)
;
