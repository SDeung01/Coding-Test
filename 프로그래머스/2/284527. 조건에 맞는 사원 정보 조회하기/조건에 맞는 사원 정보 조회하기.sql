-- 코드를 작성해주세요
WITH TOTAL_GRADE AS (
    SELECT EMP_NO, SUM(SCORE) AS TOTAL_SCORE
      FROM HR_GRADE
     GROUP BY EMP_NO
)

SELECT grd.TOTAL_SCORE AS SCORE,
       emp.EMP_NO,
       emp.EMP_NAME,
       emp.POSITION,
       emp.EMAIL
  FROM HR_EMPLOYEES emp
  LEFT JOIN TOTAL_GRADE grd
    ON emp.EMP_NO = grd.EMP_NO
  ORDER BY SCORE DESC
  LIMIT 1;