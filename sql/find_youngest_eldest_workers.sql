SELECT NAME, t.dd, BIRTHDAY, 'YOUNGEST' as 'TYPE'
FROM (
	SELECT worker.NAME, worker.BIRTHDAY, timestampdiff(YEAR, BIRTHDAY, now()) as dd
    FROM megasoft.worker
    ORDER BY dd)t
HAVING t.dd = (
		SELECT MIN(c.dd)
        FROM(
			SELECT timestampdiff(YEAR, BIRTHDAY, now()) as dd
			FROM megasoft.worker p)c
		)
UNION 
SELECT NAME, t.dd, BIRTHDAY, 'ELDEST' as 'TYPE'
FROM (
	SELECT worker.NAME, worker.BIRTHDAY, timestampdiff(YEAR, BIRTHDAY, now()) as dd
    FROM megasoft.worker
    ORDER BY dd)t
HAVING t.dd = (
		SELECT MAX(c.dd)
        FROM(
			SELECT timestampdiff(YEAR, BIRTHDAY, now()) as dd
			FROM megasoft.worker p)c
		)
        ;