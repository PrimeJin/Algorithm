-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, CASE
    WHEN FREEZER_YN = 'Y' THEN 'Y'
    WHEN FREEZER_YN = 'N' THEN 'N'
    WHEN FREEZER_YN IS NULL THEN 'N'
    END as FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE WAREHOUSE_NAME like '%경기%'
ORDER BY WAREHOUSE_ID ASC;