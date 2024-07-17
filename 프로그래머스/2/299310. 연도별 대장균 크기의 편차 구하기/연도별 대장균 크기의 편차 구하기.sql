-- 코드를 작성해주세요
SELECT YEAR(e1.differentiation_date) AS YEAR,
       (sub.max_size_by_year - e1.size_of_colony) AS YEAR_DEV,
       e1.id
  FROM ECOLI_DATA e1
 INNER JOIN (
                SELECT YEAR(e2.differentiation_date) AS sub_year,
                       MAX(e2.size_of_colony) AS max_size_by_year
                  FROM ECOLI_DATA e2
                 GROUP BY YEAR(e2.differentiation_date)
            ) sub
    ON YEAR(e1.differentiation_date) = sub.sub_year
 ORDER BY YEAR ASC, YEAR_DEV ASC;