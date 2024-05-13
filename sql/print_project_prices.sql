SELECT PROJECT_ID, sum(a.fazit) prices
FROM(SELECT t.months*SALARY as fazit, PROJECT_ID
	FROM(SELECT PROJECT_ID, SALARY, round(datediff(FINISH_DATE, START_DATE)/ 30) as months
		FROM megasoft.project_worker pw
		JOIN megasoft.worker w ON pw.WORKER_ID = w.ID
		JOIN megasoft.project p ON pw.PROJECT_ID = p.ID)t
	order by PROJECT_ID) a
    group by PROJECT_ID
    ORDER BY prices DESC
;