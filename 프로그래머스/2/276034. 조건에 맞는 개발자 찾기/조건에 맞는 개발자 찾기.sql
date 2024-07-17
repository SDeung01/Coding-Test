-- 코드를 작성해주세요
SELECT d.id, d.email, d.first_name, d.last_name
  FROM DEVELOPERS d
 WHERE d.skill_code & (
                        (SELECT s.code FROM SKILLCODES s WHERE s.name = 'C#')
                        + (SELECT s.code FROM SKILLCODES s WHERE s.name = 'Python')
                      ) != 0
 ORDER BY d.id ASC;