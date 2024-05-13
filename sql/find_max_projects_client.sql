SELECT cl.NAME, COUNT(*) countproject
FROM megasoft.client cl JOIN megasoft.project pr
ON cl.ID = pr.CLIENT_ID
GROUP BY pr.CLIENT_ID
HAVING COUNT(*) = (
	SELECT MAX(t.count)
    FROM(
		SELECT COUNT(*)count
		FROM megasoft.project
		GROUP BY CLIENT_ID
    )t
);